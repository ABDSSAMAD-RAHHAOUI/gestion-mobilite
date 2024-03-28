package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.DemandeMobilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeMRepository extends JpaRepository<DemandeMobilite, Long> {
    List<DemandeMobilite> getDemandeMobiliteByEtudiant_NumEtudiant(Long idEtudiant);
    @Query("select d from DemandeMobilite d where d.programme.codeProgramme = ?1 and d.etudiant.numEtudiant = ?2")
    DemandeMobilite getDemandeMobilitebyProgrameANDEtudiant(Long codeProgramme, Long numEtudiant);

}
