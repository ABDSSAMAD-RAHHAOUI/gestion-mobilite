package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.DemandeMobilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeMRepository extends JpaRepository<DemandeMobilite, Long> {
    List<DemandeMobilite> getDemandeMobiliteByEtudiant_NumEtudiant(Long idEtudiant);

}
