package ma.enset.tp_gestion_cabinet.repository;

import ma.enset.tp_gestion_cabinet.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
