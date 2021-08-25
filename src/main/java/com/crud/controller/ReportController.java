package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.Report;
import com.crud.dto.ReportWrapper;
import com.crud.service.ReportService;

@RestController
@RequestMapping(path = "/reports", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    private final ReportService service;

    @Autowired
    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Report> get(@PathVariable("id") String id) {
        Report report = service.get(id);
        return ResponseEntity.ok(report);
    }

    @GetMapping(consumes = MediaType.ALL_VALUE)
    public ResponseEntity<ReportWrapper> getMany() {
        ReportWrapper reports = service.getMany();
        return ResponseEntity.ok(reports);
    }

    @PostMapping
    public ResponseEntity<Report> create() {
        Report report = service.create();
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Report> update(@PathVariable("id") String id) {
        Report report = service.update(id);
        return ResponseEntity.ok(report);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Report> patch(@PathVariable("id") String id) {
        Report report = service.patch(id);
        return ResponseEntity.ok(report);
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
