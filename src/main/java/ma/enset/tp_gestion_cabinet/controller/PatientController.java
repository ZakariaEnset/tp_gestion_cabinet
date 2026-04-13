package ma.enset.tp_gestion_cabinet.controller;

import jakarta.validation.Valid;
import ma.enset.tp_gestion_cabinet.entity.Patient;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String listePatients(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "sortField", defaultValue = "nom") String sortField,
                                @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                                Model model){

        int pageSize = 5;

        Page<Patient> pagePatients = patientService.findAllPatientsPaginatedAndSorted(page, pageSize, sortField, sortDir);
        List<Patient> patiens = pagePatients.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pagePatients.getTotalPages());
        model.addAttribute("totalItems", pagePatients.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

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
