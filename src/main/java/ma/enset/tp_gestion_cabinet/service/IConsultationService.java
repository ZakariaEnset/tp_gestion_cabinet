package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;

import java.util.List;

public interface IConsultationService {
    void addConsultation(Consultation consultation);
    void deleteConsultation(long id);
    List<Consultation> findAllConsultations();
}
