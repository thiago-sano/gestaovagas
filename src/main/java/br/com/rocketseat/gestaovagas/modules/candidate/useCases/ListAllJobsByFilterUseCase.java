package br.com.rocketseat.gestaovagas.modules.candidate.useCases;

import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import br.com.rocketseat.gestaovagas.modules.company.repositories.JobRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRespository jobRespository;

    public List<JobEntity> execute(String filter) {
        return this.jobRespository.findByDescriptionContainingIgnoreCase(filter);
    }
}
