package silveira.vinicius.sigepol.domain.policial;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import silveira.vinicius.sigepol.domain.endereco.EnderecoDTO;
import silveira.vinicius.sigepol.domain.formacao.FormacaoDTO;

import java.util.Date;

public record PolicialAtualizacaoDTO(
        String nome,
        @Pattern(regexp = "\\d{11,15}", message = "Formato do CPF é inválido")
        String cpf,
        @Email(message = "Formato do email é inválido")
        String email,
        @Past(message = "A data de nascimento deve ser no passado")
        Date nascimento,
        String nomeMae,
        String nomePai,
        String patente,
        String nomeDeGuerra,
        String lotacao,
        String matricula,
        @Past(message = "A data da incorporação deve ser no passado")
        Date dataIncorporacao,
        @Valid
        FormacaoDTO formacao,
        @Valid
        EnderecoDTO endereco
) {
}
