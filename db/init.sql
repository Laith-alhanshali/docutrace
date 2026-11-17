-- Turn on pgvector in this database (must come first: the table uses the vector type)
CREATE EXTENSION IF NOT EXISTS vector;

-- One row = one chunk (a piece of an uploaded document)
CREATE TABLE document_chunks (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,   -- auto-numbered row ID
    source_doc TEXT NOT NULL,                             -- which document the chunk came from
    chunk_index INT NOT NULL,                             -- chunk number inside that document (0, 1, 2...)
    content TEXT NOT NULL,                                -- the chunk's text
    embedding vector(768) NOT NULL,                       -- its location on the map of meaning (nomic-embed-text)
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),        -- when it was saved, filled in automatically
    UNIQUE (source_doc, chunk_index)                      -- the same document can't have the same chunk number twice
);

-- HNSW index: finds the closest vectors fast, measuring closeness by angle (cosine)
CREATE INDEX idx_chunks_embedding ON document_chunks USING hnsw (embedding vector_cosine_ops);