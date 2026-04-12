package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IConsultationService {
    Consultation getConsultationById(long id);
    void addConsultation(Consultation consultation);
    void deleteConsultation(long id);
    List<Consultation> findAllConsultations();
    List<Consultation> findConsultationsByPatientId(long patientId);
    Page<Consultation> findAllConsultationPaginatedAndSorted(long patientId, int page, int size, String sortField, String sortDirection);
}
