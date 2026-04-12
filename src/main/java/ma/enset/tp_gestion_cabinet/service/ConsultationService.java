package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.repository.ConsultationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Consultation getConsultationById(long id) {
        return consultationRepository.findById(id).get();
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

    @Override
    public List<Consultation> findConsultationsByPatientId(long patientId) {
        return consultationRepository.findByPatientId(patientId);
    }

    @Override
    public Page<Consultation> findAllConsultationPaginatedAndSorted(long patientId, int page, int size, String sortField, String sortDirection) {
        Sort sort =  sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page - 1, size, sort);
        if(patientId != 0){
            return consultationRepository.findByPatientId(patientId, pageable);
        }
        return consultationRepository.findAll(pageable);
    }
}
