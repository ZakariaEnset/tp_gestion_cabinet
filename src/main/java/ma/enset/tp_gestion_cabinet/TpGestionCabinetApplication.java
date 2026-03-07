package ma.enset.tp_gestion_cabinet;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.repository.ConsultationRepository;
import ma.enset.tp_gestion_cabinet.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TpGestionCabinetApplication implements CommandLineRunner {

    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;

    public TpGestionCabinetApplication(PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TpGestionCabinetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // création d'un patient
        /*
        Patient p1 = Patient.builder()
                .nom("Hamidi")
                .prenom("Ahmed")
                .email("hamidi@gmail.com")
                .tel("0600000000")
                .build();
        patientRepository.save(p1);
         */
        // Récupération de patient par id et l'affecter a une consultation
        /*
        Patient p1 = patientRepository.findById(1L).get();
        Consultation c1 = Consultation.builder()
                .date(new Date(System.currentTimeMillis()))
                .description("Aucune maladie")
                .patient(p1)
                .build();
        consultationRepository.save(c1);
        */
    }
}
