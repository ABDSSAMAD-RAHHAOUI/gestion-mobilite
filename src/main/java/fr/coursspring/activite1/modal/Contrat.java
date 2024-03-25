package fr.coursspring.activite1.modal;

import javax.persistence.*;

@Entity
@Table(name = "contrats")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeContrat")
    private Long codeContrat;

    @Column(name = "dureeContrat")
    private int dureeContrat;

    @Column(name = "etatContrat")
    private String etatContrat;

    @ManyToOne
    @JoinColumn(name = "codeDemandeM")
    private DemandeMobilite demandeMobilite;

    public Long getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(Long codeContrat) {
        this.codeContrat = codeContrat;
    }

    public int getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(int dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public String getEtatContrat() {
        return etatContrat;
    }

    public void setEtatContrat(String etatContrat) {
        this.etatContrat = etatContrat;
    }

    public DemandeMobilite getDemandeMobilite() {
        return demandeMobilite;
    }

    public void setDemandeMobilite(DemandeMobilite demandeMobilite) {
        this.demandeMobilite = demandeMobilite;
    }

    // Getters and setters
}

