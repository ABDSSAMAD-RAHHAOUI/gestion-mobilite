package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.DemandeFinancement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeFinancementRepository extends JpaRepository<DemandeFinancement, Long> {

    @Query("SELECT COUNT(df) > 0 FROM DemandeFinancement df WHERE df.contrat.codeContrat = :codeContrat")
    boolean existeDemandeFinancementPourContrat(@Param("codeContrat") long codeContrat);

}
