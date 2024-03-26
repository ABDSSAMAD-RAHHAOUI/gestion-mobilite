package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    @Query("SELECT c FROM Contrat c JOIN c.demandeMobilite d JOIN d.etudiant e WHERE d.etatDemandeM = 'accepter' AND e.numEtudiant = :userId")
    public List<Contrat> getContratsAccepterByUserId(Long userId);

}
