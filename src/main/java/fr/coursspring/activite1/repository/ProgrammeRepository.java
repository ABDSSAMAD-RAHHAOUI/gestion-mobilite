package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
    @Query("SELECT p FROM Programme p WHERE p.diplome.codeDiplome = ?1")
    List<Programme> findByCodeDiplome(Long codeDiplome);
}
