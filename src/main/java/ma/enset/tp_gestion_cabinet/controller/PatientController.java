package ma.enset.tp_gestion_cabinet.controller;

import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {

    private IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String listePatients(Model model){
        List<Patient> patiens = patientService.findAllPatients();
        model.addAttribute("patients", patiens);
        return "patients/list";
    }

    @GetMapping("/patients/new")
    public String nouveauPatient(Model model){
        model.addAttribute("patient" , new Patient());
        return "patients/form";
    }

    @PostMapping("/patients/save")
    public String sauvegarderPatient(@ModelAttribute("patient") Patient patient){
        patientService.ajouterPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/delete/{id}")
    public String supprimerPatient(@PathVariable("id") long id){
        patientService.supprimerPatient(id);
        return "redirect:/patients";
    }
}
