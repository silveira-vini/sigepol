package silveira.vinicius.sigepol.domain.viaturas;

import jakarta.validation.constraints.NotBlank;

public record ViaturaCadastroDTO(
        String placa,
        String prefixo,
        @NotBlank(message = "Marca é obrigatória")
        String marca,
        @NotBlank(message = "Modelo é obrigatório")
        String modelo,
        @NotBlank(message = "Ano é obrigatório")
        String ano,
        @NotBlank(message = "Km é obrigatório")
        String km) {
}
