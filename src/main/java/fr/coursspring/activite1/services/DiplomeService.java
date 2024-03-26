package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Diplome;
import fr.coursspring.activite1.repository.DiplomeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeService {
    private final DiplomeRepository diplomeRepository;

    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    public List<Diplome> getDiplomes() {
        return diplomeRepository.findAll();
    }

    public List<Diplome> getDiplomeByProgramme(Long codeProgramme) {
        return diplomeRepository.findDiplomeByPrograme(codeProgramme);
    }

}
