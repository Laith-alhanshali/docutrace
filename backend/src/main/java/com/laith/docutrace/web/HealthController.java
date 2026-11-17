package com.laith.docutrace.web;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/health")
    public String health(){
        return jdbcTemplate.queryForObject("SELECT version()", String.class);
    }

    @GetMapping("/api/health/chunks")
    public Long chunksCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM ?", Long.class, "document_chunks");
    }
}
