package fr.coursspring.activite1.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cours")
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeCours")
    private Long codeCours;

    @Column(name = "LibelleCours")
    private String libelleCours;

    @Column(name = "nbECTS")
    private String nbECTS;

    @Column(name = "annee")
    private int annee;

    @ManyToOne
    @JoinColumn(name = "codeDiplome")
    private Diplome diplome;

    @OneToMany(mappedBy = "cours")
    private List<Compatible> compatibles;

    public Long getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(Long codeCours) {
        this.codeCours = codeCours;
    }

    public String getLibelleCours() {
        return libelleCours;
    }

    public void setLibelleCours(String libelleCours) {
        this.libelleCours = libelleCours;
    }

    public String getNbECTS() {
        return nbECTS;
    }

    public void setNbECTS(String nbECTS) {
        this.nbECTS = nbECTS;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public List<Compatible> getCompatibles() {
        return compatibles;
    }

    public void setCompatibles(List<Compatible> compatibles) {
        this.compatibles = compatibles;
    }
}
