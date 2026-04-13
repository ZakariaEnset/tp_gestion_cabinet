package ma.enset.tp_gestion_cabinet.controller;

import ma.enset.tp_gestion_cabinet.service.IConsultationService;
import ma.enset.tp_gestion_cabinet.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final IPatientService patientService;
    private final IConsultationService consultationService;


    public DashboardController(IPatientService patientService, IConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("countPatients", patientService.getCountPatients());
        model.addAttribute("countConsultations", consultationService.getCountConsultations());
        return "dashboard/index";
    }
}
