package be.mddpharma.management.services;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import be.mddpharma.management.model.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicationService {
    Medication addNewMedication(String name, Type type, Status status);
    List<Medication> getAllMedications();
    Medication update(String name, Type type, Status status);
}
