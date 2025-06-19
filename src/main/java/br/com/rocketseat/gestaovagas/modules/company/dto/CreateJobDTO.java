package br.com.rocketseat.gestaovagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora júnior", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gympass, Plano de saúde, Vale Alimentação e Refeição", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JÚNIOR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
