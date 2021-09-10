package be.mddpharma.management.repository;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import be.mddpharma.management.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    @Query("FROM Medication m where m.name LIKE %:name%")
    List<Medication> findByNameIgnoreCase(@Param("name") String name);
    @Query("FROM Medication m where lower(m.name) LIKE %:name% AND m.type = :type")
    List<Medication> findByNameAndType(@Param("name") String name, @Param("type") Type type);
    @Query("FROM Medication m where lower(m.name) LIKE %:name% AND m.status = :status")
    List<Medication> findByNameAndStatus(@Param("name") String name, @Param("status") Status status);
    @Query("FROM Medication m where lower(m.name) LIKE %:name% AND m.type = :type AND m.status = :status")
    List<Medication> findByNameAndTypeAndStatus(@Param("name") String name, @Param("type") Type type, @Param("status") Status status);
    List<Medication> findByStatus(Status status);
    List<Medication> findByType(Type type);
    List<Medication> findByTypeAndStatus(Type type, Status status);
}
