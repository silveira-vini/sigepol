package silveira.vinicius.sigepol.domain.operacao;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import silveira.vinicius.sigepol.domain.endereco.Endereco;

import java.time.LocalDateTime;

public record OperacaoCadastroDTO(
        @NotBlank
        String nome,
        String descricao,
        @NotNull
        @Future
        LocalDateTime data,
        @NotNull
        Endereco local,
        @NotNull
        Long responsavelId,
        @NotNull
        Long viaturaId) {
}
