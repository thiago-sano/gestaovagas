package br.com.rocketseat.gestaovagas.modules.company.controllers;

import br.com.rocketseat.gestaovagas.modules.company.dto.AuthCompanyDTO;
import br.com.rocketseat.gestaovagas.modules.company.dto.AuthCompanyResponseDTO;
import br.com.rocketseat.gestaovagas.modules.company.useCases.AuthCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Tag(name = "Empresa", description = "Informações da empresa")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/auth")
    @Operation(summary = "Autenticação de empresa", description = "Essa função é responsável pela autenticação da empresa")
    @ApiResponse(
            responseCode = "200",
            content = {
                    @Content(schema = @Schema(implementation = AuthCompanyResponseDTO.class))
            }
    )
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var result = this.authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
}
