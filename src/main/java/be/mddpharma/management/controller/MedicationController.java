package be.mddpharma.management.controller;

import be.mddpharma.management.dto.MedicationDto;
import be.mddpharma.management.model.Medication;
import be.mddpharma.management.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = {"be.mddpharma.management.service"})
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @PostMapping("/add")
    public ResponseEntity<Medication> addMedication(@RequestBody MedicationDto medicationDto) {
        Medication medication = medicationService.addNewMedication(
                medicationDto.getName(),
                medicationDto.getType(),
                medicationDto.getStatus()
        );
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Medication>> getAllMedication() {
        List<Medication> medicationList = medicationService.getAllMedications();
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Medication> updateMedication(@RequestBody MedicationDto medicationDto) {
        Medication medication = medicationService.update(
                medicationDto.getName(),
                medicationDto.getType(),
                medicationDto.getStatus()
        );
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }
}
