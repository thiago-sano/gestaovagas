package br.com.rocketseat.gestaovagas.modules.candidate.usecases;

import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    private final JobRespository jobRespository;

    public ListAllJobsByFilterUseCase(JobRespository jobRespository) {
        this.jobRespository = jobRespository;
    }

    public List<JobEntity> execute(String filter) {
        return this.jobRespository.findByDescriptionContainingIgnoreCase(filter);
    }
}
