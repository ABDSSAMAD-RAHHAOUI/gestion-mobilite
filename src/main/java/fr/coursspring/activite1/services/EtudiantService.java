package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Etudiant;
import fr.coursspring.activite1.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository=etudiantRepository;
    }




    public Etudiant findByMailAndPassword(String mail, String password) {
        return etudiantRepository.findByMailEtudiantAndPassword(mail, password);
    }

    public Etudiant enregistreEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant findByMail(String mail) {
        return etudiantRepository.findByMailEtudiant(mail);
    }
}
