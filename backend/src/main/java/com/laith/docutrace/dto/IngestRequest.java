package com.laith.docutrace.dto;

import jakarta.validation.constraints.*;

public record IngestRequest(
        @NotBlank
        @Size(max = 255)
        String sourceDoc,

        @NotBlank
        @Size(max = 1_000_000)
        String content,

        @NotNull
        @Min(100) @Max(4000)
        Integer chunkSize,

        @NotNull
        @Min(0) @Max(1000)
        Integer chunkOverlap
) {
        @AssertTrue(message = "chunkOverlap must be smaller than chunkSize")
        public boolean isOverlapSmallerThanSize() {
                if (chunkSize == null || chunkOverlap == null) {
                        return true;   // @NotNull reports missing values; don't report them twice
                }
                return chunkOverlap < chunkSize;
        }
}
