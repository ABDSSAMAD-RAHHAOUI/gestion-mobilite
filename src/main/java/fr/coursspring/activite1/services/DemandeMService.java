package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.DemandeMobilite;
import fr.coursspring.activite1.repository.DemandeMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeMService {

    private final DemandeMRepository demandeMRepository;

    public DemandeMService(DemandeMRepository demandeMRepository) {
        this.demandeMRepository=demandeMRepository;
    }

    public List<DemandeMobilite> getDemandeMobility(Long idEtudiant) {
        return demandeMRepository.getDemandeMobiliteByEtudiant_NumEtudiant(idEtudiant);
    }

}
