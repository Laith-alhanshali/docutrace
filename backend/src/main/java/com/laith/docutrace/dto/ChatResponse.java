package com.laith.docutrace.dto;

import java.util.List;

/**
 * The reply to a ChatRequest: the answer, the chunks it was based on, and how it was made.
 */
public record ChatResponse(
        String sessionId,                    // echoed back so the frontend can match replies to chats
        String answer,
        List<RetrievedChunkDto> sources,     // the chunks given to the model
        PipelineTraceDto trace
) {
    public ChatResponse {
        sources = sources == null ? List.of() : List.copyOf(sources);
    }
}