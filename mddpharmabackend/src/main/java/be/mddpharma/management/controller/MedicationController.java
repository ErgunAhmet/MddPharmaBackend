package be.mddpharma.management.controller;

import be.mddpharma.management.dto.MedicationDto;
import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
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

    @PostMapping("/updateStatus/{id}/{status}")
    public ResponseEntity<Medication> updateMedicationStatus(@PathVariable("id") int id,
                                                             @PathVariable("status") Status status) {
        Medication medication = medicationService.updateStatus(id, status);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Medication>> getAllMedication() {
        List<Medication> medicationList = medicationService.getAllMedications();
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Medication>> findByName(@PathVariable("name") String name) {
        List<Medication> medicationList = medicationService.getMedicationByName(name);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByNameAndType/{name}/{type}")
    public ResponseEntity<List<Medication>> findByNameAndType(@PathVariable("name") String name,
                                                              @PathVariable("type") Type type) {
        List<Medication> medicationList = medicationService.getMedicationByNameAndType(name, type);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByNameAndStatus/{name}/{status}")
    public ResponseEntity<List<Medication>> findByNameAndStatus(@PathVariable("name") String name,
                                                                @PathVariable("status") Status status) {
        List<Medication> medicationList = medicationService.getMedicationByNameAndStatus(name, status);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByNameAndTypeAndStatus/{name}/{type}/{status}")
    public ResponseEntity<List<Medication>> findByNameAndType(@PathVariable("name") String name,
                                                              @PathVariable("type") Type type,
                                                              @PathVariable("status") Status status) {
        List<Medication> medicationList = medicationService.getMedicationByNameAndTypeAndStatus(name, type, status);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<List<Medication>> findByStatus(@PathVariable("status") Status status) {
        List<Medication> medicationList = medicationService.getMedicationByStatus(status);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByType/{type}")
    public ResponseEntity<List<Medication>> findByType(@PathVariable("type") Type type) {
        List<Medication> medicationList = medicationService.getMedicationByType(type);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }

    @GetMapping("/findByTypeAndStatus/{type}/{status}")
    public ResponseEntity<List<Medication>> findByTypeAndStatus(@PathVariable("type") Type type,
                                                       @PathVariable("status") Status status) {
        List<Medication> medicationList = medicationService.getMedicationByTypeAndStatus(type, status);
        return new ResponseEntity<>(medicationList, HttpStatus.OK);
    }
}
