package com.example.demo.resource;

import com.example.demo.domain.Violation;
import com.example.demo.service.ViolationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/violation")
public class ViolationResource {

    @Autowired
    private final ViolationService violationService;

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody Violation violation) {
        if (violation.getId() != null) {
            ResponseEntity.badRequest().body("invalid information");
        }
        return ResponseEntity.ok(violationService.create(violation));
    }

    @GetMapping("/read")
    ResponseEntity<List<Violation>> getList() {
        return ResponseEntity.ok(violationService.getList());
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Boolean> update(@PathVariable String id, @RequestBody Violation violation) {
        return ResponseEntity.ok(violationService.update(id, violation));
    }

    @DeleteMapping ("/delete")
    ResponseEntity<List<Violation>> deleteList() {
        return ResponseEntity.ok(violationService.deleteList());
    }

    @GetMapping("/read/{id}")
    ResponseEntity<Violation> getOne(@PathVariable String id) {
        return ResponseEntity.ok(violationService.getOne(id));
    }

    @DeleteMapping ("/delete/{id}")
    ResponseEntity<Violation> deleteOne(@PathVariable String id) {
        return ResponseEntity.ok(violationService.deleteOne(id));
    }

}
