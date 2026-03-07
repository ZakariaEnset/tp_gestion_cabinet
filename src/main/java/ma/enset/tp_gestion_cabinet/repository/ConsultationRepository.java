package ma.enset.tp_gestion_cabinet.repository;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
