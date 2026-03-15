package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Patient;

import java.util.List;

public interface IPatientService
{
    void ajouterPatient(Patient patient);
    void supprimerPatient(long id);
    List<Patient> findAllPatients();
}
