package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByMailEtudiantAndPassword(String email, String password);
    Etudiant findByMailEtudiant(String mail);

}
