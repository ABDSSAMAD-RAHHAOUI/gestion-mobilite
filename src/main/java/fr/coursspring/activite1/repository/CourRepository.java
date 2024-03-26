package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourRepository extends JpaRepository<Cour, Long> {
    @Query("SELECT c FROM Cour c WHERE c.diplome.codeDiplome = ?1")
    List<Cour> findByLibelleCours(Long idDiplome);
}
