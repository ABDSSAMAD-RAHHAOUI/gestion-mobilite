package fr.coursspring.activite1.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompatiblesId implements Serializable {

    @Column(name = "codeCours")
    private Long codeCours;

    @Column(name = "codeCours_1")
    private Long codeCours1;

    public CompatiblesId(Long codeCours, Long codeCours1) {
        this.codeCours = codeCours;
        this.codeCours1 = codeCours1;
    }

    public CompatiblesId() {
    }

    public Long getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(Long codeCours) {
        this.codeCours = codeCours;
    }

    public Long getCodeCours1() {
        return codeCours1;
    }

    public void setCodeCours1(Long codeCours1) {
        this.codeCours1 = codeCours1;
    }
}