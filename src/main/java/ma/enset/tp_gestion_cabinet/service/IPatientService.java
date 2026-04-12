package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Patient;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IPatientService
{
    Patient getPatientById(long id);
    Patient savePatient(Patient patient);
    void deletePatient(long id);
    List<Patient> findAllPatients();
    Page<Patient> findAllPatientsPaginatedAndSorted(int page, int size, String sortField, String sortDirection);
}
