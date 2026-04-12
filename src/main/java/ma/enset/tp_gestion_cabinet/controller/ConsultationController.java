package ma.enset.tp_gestion_cabinet.controller;

import jakarta.validation.Valid;
import ma.enset.tp_gestion_cabinet.entity.Consultation;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.service.IConsultationService;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.data.domain.Page;
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
    public String listeConsultations(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "sortField", defaultValue = "date") String sortField,
                                     @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                                     @RequestParam(value = "patient", required = false, defaultValue = "0") long patientId,
                                     Model model) {

        int pageSize = 5;

        Page<Consultation> pageConsultations = consultationService.findAllConsultationPaginatedAndSorted(patientId, page, pageSize, sortField, sortDir);
        List<Consultation> consultations = pageConsultations.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageConsultations.getTotalPages());
        model.addAttribute("totalItems", pageConsultations.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

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
    public String editConsultation(Model model, @PathVariable("id") long id) {
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
