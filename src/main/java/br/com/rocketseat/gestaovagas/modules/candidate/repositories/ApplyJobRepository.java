package br.com.rocketseat.gestaovagas.modules.candidate.repositories;

import br.com.rocketseat.gestaovagas.modules.candidate.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}
