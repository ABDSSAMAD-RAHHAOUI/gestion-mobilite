package fr.coursspring.activite1.services;

import fr.coursspring.activite1.repository.ContratRepository;
import org.springframework.stereotype.Service;

@Service
public class ContratService {
    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }
}
