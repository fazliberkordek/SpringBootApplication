package com.fobkred.learning;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    // Constructor to inject the service
    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // Get all software engineers
    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    // Get a specific software engineer by ID
    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    // Add a new software engineer
    @PostMapping
    public ResponseEntity<String> addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
        return ResponseEntity.ok("Software engineer added successfully!");
    }

    // Delete a software engineer by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
        return ResponseEntity.ok("Deletion completed successfully");
    }

    // Update an existing software engineer
    @PutMapping("{id}")
    public ResponseEntity<String> updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
        return ResponseEntity.ok("Software engineer updated successfully!");
    }
}