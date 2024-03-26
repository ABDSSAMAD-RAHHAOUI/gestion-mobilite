package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Concerner;
import fr.coursspring.activite1.modal.ConcernerId;
import fr.coursspring.activite1.modal.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcernerRepository extends JpaRepository<Concerner, ConcernerId> {

    @Query("select c.cours from Concerner c where c.id.codeDemandeM = ?1")
    List<Cour> getCourByDemandeMobilite_CodeDemandeM(Long codeDemandeM);

}
