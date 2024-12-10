package silveira.vinicius.sigepol.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
        @NotBlank(message = "logradouro é obrigatório")
        String logradouro,
        String numero,
        String complemento,
        @NotBlank(message = "bairro é obrigatório")
        String bairro,
        @NotBlank(message = "cidade é obrigatório")
        String cidade,
        @NotBlank(message = "UF é obrigatório")
        String uf,
        @NotBlank(message = "CEP é obrigatório")
        String cep
) {
}
