package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.modal.Programme;
import fr.coursspring.activite1.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private final ProgrammeService programmeService;
    private final CourService courService;
    private final ConcernerService concernerService;

    public DemandeMController(DemandeMService demandeMService, EtudiantService etudiantService,ConcernerService concernerService, ProgrammeService programmeService, CourService courService) {
        this.demandeMService = demandeMService;
        this.etudiantService = etudiantService;
        this.concernerService=concernerService;
        this.programmeService = programmeService;
        this.courService = courService;
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

    @GetMapping("/create-DM/{programId}")
    public String demanderMobilite(@PathVariable("programId") Long programId, HttpServletRequest request) {
        Programme program = programmeService.findByCodeProgramme(programId);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("mail")) {
                    ProgrameDTO programme = null;
                    if (!program.getDiplome().getCodeDiplome().equals(etudiantService.findByMail(cookie.getValue()).getDiplome().getCodeDiplome())) {
                        programme =new ProgrameDTO(program.getCodeProgramme(), program.getNomProgramme(), program.getDiplome().getCodeDiplome(), program.getDiplome().getNomDiplome(), courService.getCoursByDiplom(program.getDiplome().getCodeDiplome()),program.getDiplome().getUniversite().getNomU());
                    }else {
                        programme =new ProgrameDTO(program.getCodeProgramme(), program.getNomProgramme(), program.getDiplome1().getCodeDiplome(), program.getDiplome1().getNomDiplome(), courService.getCoursByDiplom(program.getDiplome1().getCodeDiplome()),program.getDiplome1().getUniversite().getNomU());
                    }
                    request.setAttribute("programme", programme);
                }
            }
        }
        return "create-demanade-mobilite";
    }

    @PostMapping("/save-DM")
    public String createDemandeMobilite(@RequestParam("coursIds") Long[] coursIds) {
        System.out.println(coursIds);
        return "redirect:/programme-echange";
    }


}
