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
    Medication updateStatus(int id, Status status);
    List<Medication> getMedicationByName(String name);
    List<Medication> getMedicationByNameAndType(String name, Type type);
    List<Medication> getMedicationByNameAndStatus(String name, Status status);
    List<Medication> getMedicationByNameAndTypeAndStatus(String name, Type type, Status status);
    List<Medication> getMedicationByStatus(Status status);
    List<Medication> getMedicationByType(Type type);
    List<Medication> getMedicationByTypeAndStatus(Type type, Status status);
}
