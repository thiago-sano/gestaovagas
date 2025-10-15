package br.com.rocketseat.gestaovagas.modules.candidate.usecases;

import br.com.rocketseat.gestaovagas.exceptions.JobNotFoundException;
import br.com.rocketseat.gestaovagas.exceptions.UserNotFoundException;
import br.com.rocketseat.gestaovagas.modules.candidate.entities.ApplyJobEntity;
import br.com.rocketseat.gestaovagas.modules.candidate.entities.CandidateEntity;
import br.com.rocketseat.gestaovagas.modules.candidate.repositories.ApplyJobRepository;
import br.com.rocketseat.gestaovagas.modules.candidate.repositories.CandidateRepository;
import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplyJobCandidateUseCaseTest {

    //@InjectMocks sinaliza que essa classe é a classe principal que será testada, e que suas dependências serão injetadas com @Mock
    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    //@Mock sinaliza que essas classes são dependências que serão mockadas dentro da classe anotada com @InjectMocks
    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRespository jobRespository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply for a job with candidate not found")
    void should_not_be_able_to_apply_for_a_job_with_candidate_not_found() {
        assertThrows(UserNotFoundException.class, () -> applyJobCandidateUseCase.execute(null, null));
    }

    @Test
    void should_not_be_able_to_apply_job_with_job_not_found() {
        UUID idCandidate = UUID.randomUUID();
        CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidateEntity));
        assertThrows(JobNotFoundException.class, () -> applyJobCandidateUseCase.execute(idCandidate, null));
    }

    @Test
    void should_be_able_to_create_a_new_apply_job() {
        // GIVEN
        UUID idCandidate = UUID.randomUUID();
        UUID idJob = UUID.randomUUID();

        ApplyJobEntity applyJobCreated = ApplyJobEntity.builder()
                .id(UUID.randomUUID())
                    .build();

        // WHEN
        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRespository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));
        when(applyJobRepository.save(any(ApplyJobEntity.class))).thenReturn(applyJobCreated);

        // THEN
        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);
        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
