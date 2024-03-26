package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.modal.DemandeMobilite;
import fr.coursspring.activite1.services.ConcernerService;
import fr.coursspring.activite1.services.DemandeMService;
import fr.coursspring.activite1.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class DemandeMController {

    private final DemandeMService demandeMService;
    private final EtudiantService etudiantService;

    private final ConcernerService concernerService;

    public DemandeMController(DemandeMService demandeMService, EtudiantService etudiantService,ConcernerService concernerService) {
        this.demandeMService = demandeMService;
        this.etudiantService = etudiantService;
        this.concernerService=concernerService;
    }



    @GetMapping("/demandeM")
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
                    List<DemandeMDto> demandeMobilites =new ArrayList<>();
                    demandeMService.getDemandeMobility(etudiantService.findByMail(cookiemail.getValue()).getNumEtudiant())
                            .stream()
                            .forEach(demandeMobilite -> {
                                List<Cour> cours = concernerService.getCourByDemandeMobilite_CodeDemandeM(demandeMobilite.getCodeDemandeM());
                                demandeMobilites.add(new DemandeMDto(demandeMobilite, cours));
                            });
                        ;

                    request.setAttribute("demandeM",demandeMobilites);
                    return "demande-mobilite";
                }
            }
        return "redirect:/login";

    }


}
