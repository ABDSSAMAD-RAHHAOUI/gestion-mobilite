package fr.coursspring.activite1.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "universites")
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeU")
    private Long codeU;

    @Column(name = "nomU")
    private String nomU;

    @Column(name = "villeU")
    private String villeU;

    @Column(name = "paysU")
    private String paysU;

    @Column(name = "webU")
    private String webU;

    @OneToMany(mappedBy = "universite")
    private List<Diplome> diplomes;

    public Long getCodeU() {
        return codeU;
    }

    public void setCodeU(Long codeU) {
        this.codeU = codeU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getVilleU() {
        return villeU;
    }

    public void setVilleU(String villeU) {
        this.villeU = villeU;
    }

    public String getPaysU() {
        return paysU;
    }

    public void setPaysU(String paysU) {
        this.paysU = paysU;
    }

    public String getWebU() {
        return webU;
    }

    public void setWebU(String webU) {
        this.webU = webU;
    }

    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }
}
