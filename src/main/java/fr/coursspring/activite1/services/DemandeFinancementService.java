package fr.coursspring.activite1.services;

import fr.coursspring.activite1.modal.Contrat;
import fr.coursspring.activite1.modal.DemandeFinancement;
import fr.coursspring.activite1.modal.Etudiant;
import fr.coursspring.activite1.repository.DemandeFinancementRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandeFinancementService {
    private final DemandeFinancementRepository demandeFinancementRepository;

    public DemandeFinancementService(DemandeFinancementRepository demandeFinancementRepository) {
        this.demandeFinancementRepository = demandeFinancementRepository;
    }

    public void save(DemandeFinancement demandeFinancement) {
        demandeFinancementRepository.save(demandeFinancement);
    }

    public boolean existsByContrat(Long contratId) {
        return demandeFinancementRepository.existeDemandeFinancementPourContrat(contratId);
    }
}
