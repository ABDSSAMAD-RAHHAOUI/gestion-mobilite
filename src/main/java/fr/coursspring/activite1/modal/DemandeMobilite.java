package fr.coursspring.activite1.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "demande_mobilites")
public class DemandeMobilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeDemandeM")
    private Long codeDemandeM;

    @Column(name = "dateDepotDemandeM")
    private String dateDepotDemandeM;

    @Column(name = "etatDemandeM")
    private String etatDemandeM;

    @ManyToOne
    @JoinColumn(name = "numEtudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "codeProgramme")
    private Programme programme;

    public Long getCodeDemandeM() {
        return codeDemandeM;
    }

    public void setCodeDemandeM(Long codeDemandeM) {
        this.codeDemandeM = codeDemandeM;
    }

    public String getDateDepotDemandeM() {
        return dateDepotDemandeM;
    }

    public void setDateDepotDemandeM(String dateDepotDemandeM) {
        this.dateDepotDemandeM = dateDepotDemandeM;
    }

    public String getEtatDemandeM() {
        return etatDemandeM;
    }

    public void setEtatDemandeM(String etatDemandeM) {
        this.etatDemandeM = etatDemandeM;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
}
