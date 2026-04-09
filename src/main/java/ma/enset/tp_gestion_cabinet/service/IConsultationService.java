package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;

import java.util.List;

public interface IConsultationService {
    Consultation getConsultationById(long id);
    void addConsultation(Consultation consultation);
    void deleteConsultation(long id);
    List<Consultation> findAllConsultations();
    List<Consultation> findConsultationsByPatientId(long patientId);
}
