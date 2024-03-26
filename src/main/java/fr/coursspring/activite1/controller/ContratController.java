package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Contrat;
import fr.coursspring.activite1.modal.DemandeFinancement;
import fr.coursspring.activite1.modal.Etudiant;
import fr.coursspring.activite1.services.ContratService;
import fr.coursspring.activite1.services.DemandeFinancementService;
import fr.coursspring.activite1.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ContratController {
    private final ContratService contratService;
    private final EtudiantService etudiantService;

    private final DemandeFinancementService demandeFinancementService;

    public ContratController(ContratService contratService, EtudiantService etudiantService, DemandeFinancementService demandeFinancementService) {
        this.contratService = contratService;
        this.etudiantService = etudiantService;
        this.demandeFinancementService = demandeFinancementService;
    }

    @GetMapping("/contrat")
    public String getContrat(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookiemail = null;
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
                request.setAttribute("contrat", contratService.getContratsAccepterByUserId(etudiantService.findByMail(cookiemail.getValue()).getNumEtudiant()));
                return "contrat";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/contrat/{contratId}/demande-financement")
    public String demanderFinancement(@PathVariable("contratId") Long contratId, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookiemail = null;
        Cookie cokieloggedIn = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("mail")) {
                cookiemail = cookie;
            }
            if (cookie.getName().equals("loggedIn")) {
                cokieloggedIn = cookie;
            }
        }

        if (cookies != null && cokieloggedIn.getName().equals("loggedIn") && cokieloggedIn.getValue().equals("true")) {
            Etudiant etudiant = etudiantService.findByMail(cookiemail.getValue());
            DemandeFinancement demandeFinancement = new DemandeFinancement();
            demandeFinancement.setContrat(contratService.getContratById(contratId));
            demandeFinancement.setEtudiant(etudiant);
            demandeFinancement.setDateDepotDemandeF(new java.sql.Date(System.currentTimeMillis()).toString());
            demandeFinancement.setEtatDemandeF("En attente");
            request.setAttribute("valide", "Votre demande est enregistré avec succès");
            request.setAttribute("contrat", contratService.getContratsAccepterByUserId(etudiantService.findByMail(cookiemail.getValue()).getNumEtudiant()));
            if (demandeFinancementService.existsByContrat(contratId)) {
                request.setAttribute("valide", null);
                request.setAttribute("error", "Vous avez déjà demandé un financement pour ce contrat");
                return "contrat";
            }
            request.setAttribute("error", null);

            demandeFinancementService.save(demandeFinancement);
        }
        return "contrat";
    }
}
