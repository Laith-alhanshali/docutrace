package com.laith.docutrace.web;

import com.laith.docutrace.dto.IngestRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    @PostMapping("/api/dev/ingest-check")
    public IngestRequest check(@Valid @RequestBody IngestRequest request) {
        return request;   // just echoes it back if it passed validation
    }
}