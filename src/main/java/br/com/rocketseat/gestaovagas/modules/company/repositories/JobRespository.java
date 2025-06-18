package br.com.rocketseat.gestaovagas.modules.company.repositories;

import br.com.rocketseat.gestaovagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRespository extends JpaRepository<JobEntity, UUID> {

    List<JobEntity> findByDescriptionContaining(String filter);
}
