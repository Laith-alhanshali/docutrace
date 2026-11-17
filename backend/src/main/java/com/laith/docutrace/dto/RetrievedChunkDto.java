package com.laith.docutrace.dto;

/**
 * One search result, shown in the inspector as "sourceDoc #chunkIndex, similarity".
 */
public record RetrievedChunkDto(
        long id,              // lets the UI refer to an exact chunk
        String sourceDoc,     // used for the citation [sourceDoc #chunkIndex]
        int chunkIndex,
        String content,       // the chunk's text, shown in the inspector
        double similarity     // 1 - cosine distance; calculated during the search, not a column
) {}