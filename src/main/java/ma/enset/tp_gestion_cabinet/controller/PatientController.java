package ma.enset.tp_gestion_cabinet.controller;

import jakarta.validation.Valid;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {

    private final IPatientService patientService;

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
    public String newPatient(Model model){
        model.addAttribute("patient" , new Patient());
        return "patients/form";
    }

    @PostMapping("/patients/save")
    public String savePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            return "patients/form";
        }
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/edit/{id}")
    public String editPatient(Model model, @PathVariable("id") long id){
       Patient patient = patientService.getPatientById(id);
       model.addAttribute("patient", patient);
       return "patients/form";
    }

    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable("id") long id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
