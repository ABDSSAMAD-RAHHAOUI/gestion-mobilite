package fr.coursspring.activite1.modal;
import javax.persistence.*;

@Entity
@Table(name = "demande_financements")
public class DemandeFinancement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeDemandeF")
    private Long codeDemandeF;

    @Column(name = "dateDepotDemandeF")
    private String dateDepotDemandeF;

    @Column(name = "etatDemandeF")
    private String etatDemandeF;

    @Column(name = "montantDemandeF")
    private double montantDemandeF;

    @ManyToOne
    @JoinColumn(name = "codeContrat")
    private Contrat contrat;

    @ManyToOne
    @JoinColumn(name = "numEtudiant")
    private Etudiant etudiant;

    public Long getCodeDemandeF() {
        return codeDemandeF;
    }

    public void setCodeDemandeF(Long codeDemandeF) {
        this.codeDemandeF = codeDemandeF;
    }

    public String getDateDepotDemandeF() {
        return dateDepotDemandeF;
    }

    public void setDateDepotDemandeF(String dateDepotDemandeF) {
        this.dateDepotDemandeF = dateDepotDemandeF;
    }

    public String getEtatDemandeF() {
        return etatDemandeF;
    }

    public void setEtatDemandeF(String etatDemandeF) {
        this.etatDemandeF = etatDemandeF;
    }

    public double getMontantDemandeF() {
        return montantDemandeF;
    }

    public void setMontantDemandeF(double montantDemandeF) {
        this.montantDemandeF = montantDemandeF;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}