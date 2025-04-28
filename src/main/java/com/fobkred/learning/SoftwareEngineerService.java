package com.fobkred.learning;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    // Constructor to inject dependencies
    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    // Method to get all software engineers
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    // Method to insert a new SoftwareEngineer and generate a learning path
    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        System.out.println("Inserting software engineer: " + softwareEngineer.getName());  // Log the name

        // Create prompt for AI service
        String prompt = """
            Based on the programming tech stack %s that %s has given,
            Provide a full learning path for this person.
            """.formatted(softwareEngineer.getTechStack(), softwareEngineer.getName());

        // Call AI service to get a learning path recommendation
        String chatRes = aiService.chat(prompt);

        // Set the learning path recommendation
        softwareEngineer.setLearningPathRecommendation(chatRes);

        // Save the new software engineer to the database
        softwareEngineerRepository.save(softwareEngineer);
    }

    // Method to get a SoftwareEngineer by ID
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("SoftwareEngineer not found"));
    }

    // Method to delete a SoftwareEngineer by ID
    public void deleteSoftwareEngineer(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }

    // Method to update an existing SoftwareEngineer by ID
    public void updateSoftwareEngineer(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Software Engineer with id " + id + " does not exist"));

        // Update fields with new values
        existingEngineer.setName(updatedEngineer.getName());
        existingEngineer.setAge(updatedEngineer.getAge());
        existingEngineer.setTechStack(updatedEngineer.getTechStack());

        // Save the updated engineer
        softwareEngineerRepository.save(existingEngineer);
    }
}