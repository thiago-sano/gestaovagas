package br.com.rocketseat.gestaovagas.modules.candidate.useCases;

import br.com.rocketseat.gestaovagas.exceptions.UserFoundException;
import br.com.rocketseat.gestaovagas.modules.candidate.entities.CandidateEntity;
import br.com.rocketseat.gestaovagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
