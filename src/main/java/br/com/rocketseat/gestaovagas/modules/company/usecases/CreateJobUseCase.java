package br.com.rocketseat.gestaovagas.modules.company.usecases;

import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRespository jobRespository;

    public CreateJobUseCase(JobRespository jobRespository) {
        this.jobRespository = jobRespository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRespository.save(jobEntity);
    }
}
