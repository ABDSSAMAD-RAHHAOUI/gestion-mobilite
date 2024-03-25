package fr.coursspring.activite1.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programmes")
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeProgramme")
    private Long codeProgramme;

    @Column(name = "nomProgramme")
    private String nomProgramme;

    @Column(name = "dureeEchange")
    private int dureeEchange;

    @ManyToOne
    @JoinColumn(name = "codeDiplome")
    private Diplome diplome;

    @ManyToOne
    @JoinColumn(name = "codeDiplome_1")
    private Diplome diplome1;

    public Diplome getDiplome1() {
        return diplome1;
    }

    public void setDiplome1(Diplome diplome1) {
        this.diplome1 = diplome1;
    }

    @OneToMany(mappedBy = "programme")
    private List<DemandeMobilite> demandesMobilites;

    public Long getCodeProgramme() {
        return codeProgramme;
    }

    public void setCodeProgramme(Long codeProgramme) {
        this.codeProgramme = codeProgramme;
    }

    public String getNomProgramme() {
        return nomProgramme;
    }

    public void setNomProgramme(String nomProgramme) {
        this.nomProgramme = nomProgramme;
    }

    public int getDureeEchange() {
        return dureeEchange;
    }

    public void setDureeEchange(int dureeEchange) {
        this.dureeEchange = dureeEchange;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public List<DemandeMobilite> getDemandesMobilites() {
        return demandesMobilites;
    }

    public void setDemandesMobilites(List<DemandeMobilite> demandesMobilites) {
        this.demandesMobilites = demandesMobilites;
    }
}
