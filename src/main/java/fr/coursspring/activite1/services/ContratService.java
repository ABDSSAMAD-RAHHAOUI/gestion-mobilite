package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Contrat;
import fr.coursspring.activite1.repository.ContratRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {
    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public List<Contrat> getContratsAccepterByUserId(Long userId) {
        return contratRepository.getContratsAccepterByUserId(userId);
    }

    public Contrat getContratById(Long contratId) {
        return contratRepository.getReferenceById(contratId);
    }
}
