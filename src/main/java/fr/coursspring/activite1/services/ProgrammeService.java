package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Programme;
import fr.coursspring.activite1.repository.ProgrammeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProgrammeService {
    private final ProgrammeRepository programmeRepository;

    public ProgrammeService(ProgrammeRepository programmeRepository) {
        this.programmeRepository=programmeRepository;
    }

    public List<Programme> findAll() {
        return programmeRepository.findAll();
    }

    public List<Programme> findByCodeDiplome(Long codeDiplome) {
        return programmeRepository.findByCodeDiplome(codeDiplome);
    }

    public Programme findByCodeProgramme(Long codeProgramme) {
        return programmeRepository.findById(codeProgramme).orElse(null);
    }
}
