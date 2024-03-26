package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.modal.DemandeFinancement;
import fr.coursspring.activite1.services.DemandeFinancementService;
import fr.coursspring.activite1.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemandeFController {
    private final DemandeFinancementService demandeFinancementService;
    private final EtudiantService etudiantService;

    public DemandeFController(DemandeFinancementService demandeFinancementService, EtudiantService etudiantService) {
        this.demandeFinancementService = demandeFinancementService;
        this.etudiantService = etudiantService;
    }

    @GetMapping("/demande-financiere")
    public String demandeM(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookiemail= null;
        Cookie cokieloggedIn = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("mail")) {
                cookiemail = cookie;
            }
            if (cookie.getName().equals("loggedIn")) {
                cokieloggedIn = cookie;
            }
        }


        if (cookies != null) {
            if (cokieloggedIn.getName().equals("loggedIn") && cokieloggedIn.getValue().equals("true")) {
                List<DemandeFinancement> demandeFinancements = demandeFinancementService.getAllDemandeFinancement(etudiantService.findByMail(cookiemail.getValue()));

                request.setAttribute("demandeF",demandeFinancements);
                return "demande-financiere";
            }
        }
        return "redirect:/login";

    }



}
