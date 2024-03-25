package fr.coursspring.activite1.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConcernerId implements Serializable {

    @Column(name = "codeCours")
    private Long codeCours;

    @Column(name = "codeDemandeM")
    private Long codeDemandeM;

    public ConcernerId() {
    }

    public ConcernerId(Long codeCours, Long codeDemandeM) {
        this.codeCours = codeCours;
        this.codeDemandeM = codeDemandeM;
    }

    public Long getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(Long codeCours) {
        this.codeCours = codeCours;
    }

    public Long getCodeDemandeM() {
        return codeDemandeM;
    }

    public void setCodeDemandeM(Long codeDemandeM) {
        this.codeDemandeM = codeDemandeM;
    }
}
