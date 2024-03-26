package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Concerner;
import fr.coursspring.activite1.modal.Cour;
import fr.coursspring.activite1.repository.ConcernerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcernerService {
    private final ConcernerRepository concernerRepository;

    public ConcernerService(ConcernerRepository concernerRepository) {
        this.concernerRepository = concernerRepository;
    }

    public List<Cour> getCourByDemandeMobilite_CodeDemandeM(Long codeDemandeM) {
        return concernerRepository.getCourByDemandeMobilite_CodeDemandeM(codeDemandeM);
    }

    public void saveConcerner(Concerner concerner) {
        concernerRepository.save(concerner);
    }
}
