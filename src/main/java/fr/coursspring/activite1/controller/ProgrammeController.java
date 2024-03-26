package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Diplome;
import fr.coursspring.activite1.modal.Programme;
import fr.coursspring.activite1.services.CourService;
import fr.coursspring.activite1.services.DiplomeService;
import fr.coursspring.activite1.services.EtudiantService;
import fr.coursspring.activite1.services.ProgrammeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProgrammeController {
    private final ProgrammeService programmeService;
    private final CourService courService;
    private final EtudiantService etudiantService;

    public ProgrammeController(CourService courService, ProgrammeService programmeService, EtudiantService etudiantService) {
        this.programmeService = programmeService;
        this.etudiantService = etudiantService;
        this.courService = courService;
    }

    @GetMapping("/programme-echange")
    public String showAllProgrammesByCodeDiplome(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("mail")) {
                    List<ProgrameDTO> programmes = new ArrayList<>();
                    programmeService.findByCodeDiplome(etudiantService.findByMail(cookie.getValue()).getDiplome().getCodeDiplome()).stream()
                            .forEach(programme -> {
                                    if (!programme.getDiplome().getCodeDiplome().equals(etudiantService.findByMail(cookie.getValue()).getDiplome().getCodeDiplome())) {
                                         programmes.add(new ProgrameDTO(programme.getCodeProgramme(), programme.getNomProgramme(), programme.getDiplome().getCodeDiplome(), programme.getDiplome().getNomDiplome(), courService.getCoursByDiplom(programme.getDiplome().getCodeDiplome()),programme.getDiplome().getUniversite().getNomU()));
                                    }else {
                                        programmes.add(new ProgrameDTO(programme.getCodeProgramme(), programme.getNomProgramme(), programme.getDiplome1().getCodeDiplome(), programme.getDiplome1().getNomDiplome(), courService.getCoursByDiplom(programme.getDiplome1().getCodeDiplome()),programme.getDiplome1().getUniversite().getNomU()));
                                    }
                            });
                    request.setAttribute("programmes", programmes);
                    System.out.println(programmes);
                }
            }
        }
        return "programme-echange";
    }

}
