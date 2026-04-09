package ma.enset.tp_gestion_cabinet.controller;

import jakarta.validation.Valid;
import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.service.IConsultationService;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsultationController {

    private IConsultationService consultationService;
    private IPatientService patientService;

    public ConsultationController(IConsultationService consultationService, IPatientService patientService) {
        this.consultationService = consultationService;
        this.patientService = patientService;
    }

    @GetMapping("/consultations")
    public String listeConsultations(Model model, @RequestParam(value = "patient", required = false) Long patientId) {
        List<Consultation> consultations = null;
        if (patientId != null) {
            consultations = consultationService.findConsultationsByPatientId(patientId);
        } else {
            consultations = consultationService.findAllConsultations();
        }

        model.addAttribute("consultations", consultations);
        return "consultations/list";
    }

    @GetMapping("/consultations/new")
    public String newConsultation(Model model) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("patients", patientService.findAllPatients());
        return "consultations/form";
    }

    @PostMapping("/consultations/save")
    public String saveConsultation(@Valid @ModelAttribute("consultation") Consultation consultation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patients", patientService.findAllPatients());
            return "consultations/form";
        }
        consultationService.addConsultation(consultation);
        return "redirect:/consultations";
    }

    @GetMapping("/consultations/edit/{id}")
    public String editConsultation(Model model, @PathVariable("id") long id){
        Consultation consultation = consultationService.getConsultationById(id);
        model.addAttribute("consultation", consultation);
        model.addAttribute("patients", patientService.findAllPatients());
        return "consultations/form";
    }

    @GetMapping("/consultations/delete/{id}")
    public String supprimerConsultation(@PathVariable("id") long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultations";
    }

}
