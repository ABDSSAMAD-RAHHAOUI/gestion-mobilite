package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.services.EtudiantService;
import fr.coursspring.activite1.services.ProgrammeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProgrammeController {
    private final ProgrammeService programmeService;
    private final EtudiantService etudiantService;

    public ProgrammeController(ProgrammeService programmeService, EtudiantService etudiantService) {
        this.programmeService = programmeService;
        this.etudiantService = etudiantService;
    }

    @GetMapping("/programme-echange")
    public String showAllProgrammesByCodeDiplome(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("mail")) {
                    //programmeService.findByCodeDiplome(etudiantService.findByMail(cookie.getValue()).getDiplome().getCodeDiplome());
                    request.setAttribute("programmes", programmeService.findByCodeDiplome(etudiantService.findByMail(cookie.getValue()).getDiplome().getCodeDiplome()));
                    //request.setAttribute("mode", "ALL_USERS");
                }
            }
        }
        return "programme-echange";
    }

}
