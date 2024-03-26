package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.repository.CourRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CourService {
    private final CourRepository courRepository;

    public CourService(CourRepository courRepository) {
        this.courRepository = courRepository;
    }

    public List<Cour> getCoursByDiplom(Long idDiplome) {
        return courRepository.findByLibelleCours(idDiplome);
    }

    public Cour findByCodeCours(Long coursId) {
        return courRepository.findById(coursId).orElse(null);
    }
}
