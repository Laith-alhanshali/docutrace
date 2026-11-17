package com.laith.docutrace.dto;

import jakarta.validation.constraints.*;

public record ChatRequest(
        @NotBlank
        @Size(max = 2000)
        String question,

        @NotBlank
        @Size(max = 64)
        String sessionId,

        @NotNull
        @Min(1) @Max(10)
        Integer topK
) {
}
