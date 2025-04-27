package com.fobkred.learning;

import org.springframework.stereotype.Service;

import java.util.List;

/*
* This will handle with the business logic
* */
@Service
public class SoftwareEngineerService {
    private final  SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }
    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("SoftwareEngineer not found")
        );
    }

    public void deleteSoftwareEngineer(Integer id) {
         softwareEngineerRepository.deleteById(id);
    }
}
