package ma.enset.tp_gestion_cabinet.service;

import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void ajouterPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void supprimerPatient(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
}
