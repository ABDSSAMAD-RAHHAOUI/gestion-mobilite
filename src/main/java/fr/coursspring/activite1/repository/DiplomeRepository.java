package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
    @Query("SELECT p.diplome1,p.diplome FROM Programme p WHERE p.codeProgramme = ?1")
    List<Diplome> findDiplomeByPrograme(Long codeProgramme);
}
