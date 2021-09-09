package be.mddpharma.management.repository;

import be.mddpharma.management.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Medication findByName(String name);

}
