package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Consultation;

import java.util.List;

public interface IConsultationService {
    void ajouterConsultation(Consultation consultation);
    void supprimerConsultation(long id);
    List<Consultation> findAllConsultations();
}
