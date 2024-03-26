package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.services.ContratService;
import org.springframework.stereotype.Controller;

@Controller
public class ContratController {
    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }


}
