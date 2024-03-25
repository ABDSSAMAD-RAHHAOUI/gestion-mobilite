package fr.coursspring.activite1.controller;


import fr.coursspring.activite1.modal.Diplome;
import fr.coursspring.activite1.modal.Etudiant;
import fr.coursspring.activite1.services.DiplomeService;
import fr.coursspring.activite1.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EtudiantController {

    private final EtudiantService etudiantService;
    private final DiplomeService diplomeService;

    public EtudiantController(EtudiantService etudiantService,DiplomeService diplomeService) {
        this.etudiantService = etudiantService;
        this.diplomeService = diplomeService;
    }

    // Méthode pour afficher la page d'inscription
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "welcomepage";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String mail, @RequestParam String password) {
        if (isValidUser(mail, password)) {
            Cookie cookie1 = new Cookie("mail", mail);
            Cookie cookie = new Cookie("loggedIn", "true");
            cookie1.setMaxAge(60 * 60 * 24); // Durée de vie du cookie (en secondes), ici 1 jour
            cookie.setMaxAge(60 * 60 * 24); // Durée de vie du cookie (en secondes), ici 1 jour
            response.addCookie(cookie);
            response.addCookie(cookie1);
            // Redirection vers la page d'accueil ou une autre page après la connexion réussie
            return "redirect:/diplome";
        } else {
            request.setAttribute("error", "Invalid Username or Password");
            return "loginpage";
        }
    }


   // @RequestMapping ("/login-user")
    public String loginUser(@ModelAttribute Etudiant etudiant, HttpServletRequest request) {
        if(etudiantService.findByMailAndPassword(etudiant.getMailEtudiant(), etudiant.getPassword())!=null) {
            return "homepage";
        }
        else {
            request.setAttribute("error", "Invalid Username or Password");
            return "welcomepage";

        }
    }

    // Méthode pour afficher tous les utilisateurs
    @GetMapping("/diplome")
    public String showAllUsers(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loggedIn") && cookie.getValue().equals("true")) {
                    // Utilisateur connecté
                    //request.setAttribute("users", userService.showAllUsers());
                    //request.setAttribute("mode", "ALL_USERS");
                    return "diplome";
                }
            }
        }
        // Utilisateur non connecté, rediriger vers une page de connexion
        return "redirect:/login";
    }

    // Méthode de connexion


    // Méthode de déconnexion
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("loggedIn", "false");
        cookie.setMaxAge(0); // Supprimer le cookie
        response.addCookie(cookie);
        // Redirection vers la page de connexion après la déconnexion
        return "redirect:/login";
    }

    // Méthode pour vérifier les informations d'identification de l'utilisateur (exemplaire)
    private boolean isValidUser(String mail, String password) {
            return etudiantService.findByMailAndPassword(mail, password) != null;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {


        return "loginpage";
    }


    @GetMapping("/navbar")
    public String diplome() {
        return "navbar";
    }


    @GetMapping("/create")
    public String creatUser(Model model) {
        // Récupérer la liste des diplômes depuis le service
        List<Diplome> diplomes = diplomeService.getDiplomes();

        // Ajouter la liste des diplômes à l'objet Model pour qu'elle soit accessible dans la vue JSP
        model.addAttribute("diplomes", diplomes);
        return "create_user";
    }

    @PostMapping("/save")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant,HttpServletRequest request) {
        etudiantService.enregistreEtudiant(etudiant);

        request.setAttribute("valide", "Votre Compte est enregistré avec succès");
        return "loginpage";
    }

}
