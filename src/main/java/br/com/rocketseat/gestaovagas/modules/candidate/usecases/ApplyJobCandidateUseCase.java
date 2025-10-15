package br.com.rocketseat.gestaovagas.modules.candidate.usecases;

import br.com.rocketseat.gestaovagas.exceptions.JobNotFoundException;
import br.com.rocketseat.gestaovagas.exceptions.UserNotFoundException;
import br.com.rocketseat.gestaovagas.modules.candidate.entities.ApplyJobEntity;
import br.com.rocketseat.gestaovagas.modules.candidate.repositories.ApplyJobRepository;
import br.com.rocketseat.gestaovagas.modules.candidate.repositories.CandidateRepository;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    private final CandidateRepository candidateRepository;

    private final JobRespository jobRespository;

    private final ApplyJobRepository applyJobRepository;

    public ApplyJobCandidateUseCase(CandidateRepository candidateRepository, JobRespository jobRespository, ApplyJobRepository applyJobRepository) {
        this.candidateRepository = candidateRepository;
        this.jobRespository = jobRespository;
        this.applyJobRepository = applyJobRepository;
    }

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        // Validar se candidato existe
        candidateRepository.findById(idCandidate)
                .orElseThrow(UserNotFoundException::new);

        // Validar se vaga existe
        jobRespository.findById(idJob)
                .orElseThrow(JobNotFoundException::new);

        // Candidato se inscreve na vaga
        var applyJob = ApplyJobEntity.builder()
                .idCandidate(idCandidate)
                .idJob(idJob).build();

        return applyJobRepository.save(applyJob);
    }
}
