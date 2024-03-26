package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.modal.DemandeMobilite;

import java.util.List;

public class DemandeMDto {
    DemandeMobilite demandeMobilite;
    List<Cour> cours;

    public DemandeMDto(DemandeMobilite demandeMobilite, List<Cour> cours) {
        this.demandeMobilite = demandeMobilite;
        this.cours = cours;
    }

    public DemandeMobilite getDemandeMobilite() {
        return demandeMobilite;
    }

    public void setDemandeMobilite(DemandeMobilite demandeMobilite) {
        this.demandeMobilite = demandeMobilite;
    }

    public List<Cour> getCours() {
        return cours;
    }

    public void setCours(List<Cour> cours) {
        this.cours = cours;
    }
}
