package silveira.vinicius.sigepol.domain.formacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FormacaoDTO(
        @NotBlank(message = "Grau de formação é obrigatório")
        String grau,
        @NotBlank(message = "Curso é obrigatório")
        String curso,
        @NotNull(message = "Informe se concluído")
        Boolean concluido,
        @NotBlank(message = "Informe o ano de conclusão")
        String anoConclusao
) {
}
