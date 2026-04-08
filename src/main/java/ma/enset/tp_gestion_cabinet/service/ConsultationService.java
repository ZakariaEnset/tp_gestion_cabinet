package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultationService implements IConsultationService{
    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository){
        this.consultationRepository = consultationRepository;
    }
    @Override
    public void addConsultation(Consultation consultation) {
        consultation.setDate(Date.valueOf(LocalDate.now()));
        consultationRepository.save(consultation);
    }

    @Override
    public void deleteConsultation(long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }
}
