package be.mddpharma.management.services;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import be.mddpharma.management.model.Medication;
import be.mddpharma.management.repository.MedicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;


@Service
@Transactional
@Slf4j
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
    public Medication updateStatus(int id, Status status) {
        Long i = Long.valueOf(id);
        Medication medication = medicationRepository.findById(i).stream().findFirst().orElseThrow();
        String s = String.valueOf(medication.getId());
        log.info(s);
        medication.setStatus(status);
        return medication;
    }

    @Override
    public List<Medication> getMedicationByName(String name) {
        String s = name.toLowerCase(Locale.ROOT);
        return (List<Medication>) medicationRepository.findByNameIgnoreCase(s);
    }

    @Override
    public List<Medication> getMedicationByNameAndType(String name, Type type) {
        String s = name.toLowerCase(Locale.ROOT);
        return (List<Medication>) medicationRepository.findByNameAndType(s, type);
    }

    @Override
    public List<Medication> getMedicationByNameAndStatus(String name, Status status) {
        String s = name.toLowerCase(Locale.ROOT);
        return medicationRepository.findByNameAndStatus(s, status);
    }

    @Override
    public List<Medication> getMedicationByNameAndTypeAndStatus(String name, Type type, Status status) {
        String s = name.toLowerCase(Locale.ROOT);
        return medicationRepository.findByNameAndTypeAndStatus(s, type, status);
    }

    @Override
    public List<Medication> getMedicationByStatus(Status status) {
        return medicationRepository.findByStatus(status);
    }

    @Override
    public List<Medication> getMedicationByType(Type type) {
        return medicationRepository.findByType(type);
    }

    @Override
    public List<Medication> getMedicationByTypeAndStatus(Type type, Status status) {
        return medicationRepository.findByTypeAndStatus(type, status);
    }

    @Override
    public void deleteMedicationById(long id) {
        medicationRepository.deleteById(id);
    }

}
