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
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(long id) {
        Patient patient = getPatientById(id);
        if(patient.getConsultations().isEmpty()) patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
}
