package br.com.rocketseat.gestaovagas.modules.company.usecases;

import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRespository jobRespository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRespository.save(jobEntity);
    }
}
