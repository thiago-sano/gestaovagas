package br.com.rocketseat.gestaovagas.modules.candidate.usecases;

import br.com.rocketseat.gestaovagas.exceptions.JobNotFoundException;
import br.com.rocketseat.gestaovagas.exceptions.UserNotFoundException;
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

    public void execute(UUID candidateId, UUID jobId) {
        // Validar se candidato existe
        candidateRepository.findById(candidateId)
                .orElseThrow(UserNotFoundException::new);

        // Validar se vaga existe
        jobRespository.findById(jobId)
                .orElseThrow(JobNotFoundException::new);

        // Candidato se inscreve na vaga
    }
}
