package fr.coursspring.activite1.modal;

import javax.persistence.*;

@Entity
@Table(name = "concerners")
public class Concerner {

    @EmbeddedId
    private ConcernerId id;

    public Concerner(ConcernerId id, Cour cours, DemandeMobilite demandeMobilite) {
        this.id = id;
        this.cours = cours;
        this.demandeMobilite = demandeMobilite;
    }

    public Concerner() {
    }

    @ManyToOne
    @MapsId("codeCours")
    @JoinColumn(name = "codeCours")
    private Cour cours;

    @ManyToOne
    @MapsId("codeDemandeM")
    @JoinColumn(name = "codeDemandeM")
    private DemandeMobilite demandeMobilite;


    public ConcernerId getId() {
        return id;
    }

    public void setId(ConcernerId id) {
        this.id = id;
    }

    public Cour getCours() {
        return cours;
    }

    public void setCours(Cour cours) {
        this.cours = cours;
    }

    public DemandeMobilite getDemandeMobilite() {
        return demandeMobilite;
    }

    public void setDemandeMobilite(DemandeMobilite demandeMobilite) {
        this.demandeMobilite = demandeMobilite;
    }
}