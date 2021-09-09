package be.mddpharma.management.services;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import be.mddpharma.management.model.Medication;
import be.mddpharma.management.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public Medication addNewMedication(String name, Type type, Status status) {
        Medication medication = new Medication();
        medication.setName(name);
        medication.setType(type);
        medication.setStatus(status);
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    @Transactional
    public Medication update(String name, Type type, Status status) {
        Medication medication = medicationRepository.findByName(name);
        medication.setStatus(status);
        return medication;
    }
}
