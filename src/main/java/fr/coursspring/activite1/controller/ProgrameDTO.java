package fr.coursspring.activite1.controller;

import fr.coursspring.activite1.modal.Cour;

import java.util.List;

public class ProgrameDTO {
    private Long codeProgramme;

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    private String universite;
    private String libelleProgramme;
    private Long codeDiplomeUniv2;
    private String libelleDiplome;
    private List<Cour> cours;

    public ProgrameDTO(Long codeProgramme, String libelleProgramme, Long codeDiplomeUniv2, String libelleDiplome, List<Cour> cours, String universite) {
        this.codeProgramme = codeProgramme;
        this.libelleProgramme = libelleProgramme;
        this.codeDiplomeUniv2 = codeDiplomeUniv2;
        this.libelleDiplome = libelleDiplome;
        this.cours = cours;
        this.universite = universite;
    }

    public Long getCodeProgramme() {
        return codeProgramme;
    }

    public void setCodeProgramme(Long codeProgramme) {
        this.codeProgramme = codeProgramme;
    }

    public String getLibelleProgramme() {
        return libelleProgramme;
    }

    public void setLibelleProgramme(String libelleProgramme) {
        this.libelleProgramme = libelleProgramme;
    }

    public List<Cour> getCours() {
        return cours;
    }

    public void setCours(List<Cour> cours) {
        this.cours = cours;
    }

    public Long getCodeDiplomeUniv2() {
        return codeDiplomeUniv2;
    }

    public void setCodeDiplomeUniv2(Long codeDiplomeUniv2) {
        this.codeDiplomeUniv2 = codeDiplomeUniv2;
    }

    public String getLibelleDiplome() {
        return libelleDiplome;
    }

    public void setLibelleDiplome(String libelleDiplome) {
        this.libelleDiplome = libelleDiplome;
    }
}
