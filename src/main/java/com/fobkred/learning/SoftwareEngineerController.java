package com.fobkred.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
@GetMapping
    public List<SoftwareEngineer> getEngineers(){

        return List.of(
                new SoftwareEngineer(
                        1,
                        "Berk",
                        28,
                        "java"
                ),new SoftwareEngineer(
                        2,
                        "Fazli",
                        3,
                        "javaScript"
                )
        );
    }
}
