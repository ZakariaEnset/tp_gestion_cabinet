package ma.enset.tp_gestion_cabinet.repository;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatientId(long id);
    Page<Consultation> findByPatientId(long id, Pageable pageable);
}
