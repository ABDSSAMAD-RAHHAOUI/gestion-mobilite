package fr.coursspring.activite1.modal;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "compatibles")
public class Compatible {

    @EmbeddedId
    private CompatiblesId id;

    @ManyToOne
    @JoinColumn(name = "codeCours", referencedColumnName = "codeCours", insertable = false, updatable = false)
    private Cour cours;

    @ManyToOne
    @JoinColumn(name = "codeCours_1", referencedColumnName = "codeCours", insertable = false, updatable = false)
    private Cour cours1;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


    public Cour getCours() {
        return cours;
    }

    public void setCours(Cour cours) {
        this.cours = cours;
    }

    public Cour getCours1() {
        return cours1;
    }

    public void setCours1(Cour cours1) {
        this.cours1 = cours1;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}