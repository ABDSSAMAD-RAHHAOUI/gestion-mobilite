package fr.coursspring.activite1.modal;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diplomes")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeDiplome")
    private Long codeDiplome;

    @Column(name = "nomDiplome")
    private String nomDiplome;

    @Column(name = "niveauDiplome")
    private String niveauDiplome;

    @ManyToOne
    @JoinColumn(name = "codeU")
    private Universite universite;

    @OneToMany(mappedBy = "diplome")
    private List<Etudiant> etudiants;

    public Long getCodeDiplome() {
        return codeDiplome;
    }

    public void setCodeDiplome(Long codeDiplome) {
        this.codeDiplome = codeDiplome;
    }

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public String getNiveauDiplome() {
        return niveauDiplome;
    }

    public void setNiveauDiplome(String niveauDiplome) {
        this.niveauDiplome = niveauDiplome;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
