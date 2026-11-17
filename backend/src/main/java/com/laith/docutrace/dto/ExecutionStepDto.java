package com.laith.docutrace.dto;

import java.util.Map;

/**
 * One step of the pipeline, e.g. "embed the question" or "search vectors".
 * Kept generic on purpose: in Phase 1 the actor is a Java service,
 * in Phase 2 (JADE) it is an agent and each step is one ACL message.
 */
public record ExecutionStepDto(
        int order,                    // position in the pipeline: 1, 2, 3...
        String actor,                 // who did it: "OllamaGateway" now, "RetrieverAgent" in Phase 2
        String action,                // what it did: "embed-query", "vector-search", "generate"
        long durationMs,
        StepStatus status,
        Map<String, Object> details   // step-specific extras: {"topK": 5}, {"promptTokens": 412}
) {
    public ExecutionStepDto {
        details = details == null ? Map.of() : Map.copyOf(details);
    }
}