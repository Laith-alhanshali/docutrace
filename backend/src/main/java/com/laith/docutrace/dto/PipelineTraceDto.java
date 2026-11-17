package com.laith.docutrace.dto;

import java.util.List;

/**
 * How one chat answer was produced: the steps, total time, and model usage.
 * Feeds the inspector (steps) and the telemetry pane (numbers).
 */
public record PipelineTraceDto(
        String traceId,                // unique ID for this request, handy for matching logs
        String model,                  // e.g. "llama3.2:3b", to compare models in Stage 6
        long totalDurationMs,
        int promptTokens,              // from Ollama's prompt_eval_count
        int completionTokens,          // from Ollama's eval_count
        List<ExecutionStepDto> steps
) {
    public PipelineTraceDto {
        steps = steps == null ? List.of() : List.copyOf(steps);
    }
}