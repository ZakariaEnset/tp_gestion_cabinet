package ma.enset.tp_gestion_cabinet.controller;

import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.service.IConsultationService;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ConsultationController {

    private IConsultationService consultationService;
    private IPatientService patientService;

    public ConsultationController(IConsultationService consultationService, IPatientService patientService){
        this.consultationService = consultationService;
        this.patientService = patientService;
    }

    @GetMapping("/consultations")
    public String listeConsultations(Model model){
        List<Consultation> consultations = consultationService.findAllConsultations();
        model.addAttribute("consultations", consultations);
        return "consultations/list";
    }

    @GetMapping("/consultations/new")
    public String nouvelleConsultation(Model model){
        model.addAttribute("consultation" , new Consultation());
        model.addAttribute("patients", patientService.findAllPatients());
        return "consultations/form";
    }

    @PostMapping("/consultations/save")
    public String sauvegarderConsultation(@ModelAttribute("consultation") Consultation consultation){
        consultationService.addConsultation(consultation);
        return "redirect:/consultations";
    }

    @GetMapping("/consultations/delete/{id}")
    public String supprimerConsultation(@PathVariable("id") long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultations";
    }

}
