package silveira.vinicius.sigepol.domain.policial;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import silveira.vinicius.sigepol.domain.endereco.EnderecoDTO;
import silveira.vinicius.sigepol.domain.formacao.FormacaoDTO;

import java.util.Date;

public record PolicialCadastroDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Nome é obrigatório")
        @Pattern(regexp = "\\d{11,15}", message = "Formato do CPF é inválido")
        String cpf,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,
        @Past(message = "A data de nascimento deve ser no passado")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato da data de nascimento inválido. Utilize dd/mm/aaaa")
        Date nascimento,
        String nomeMae,
        String nomePai,
        @NotBlank(message = "Posto ou Graduação obrigatório")
        String patente,
        @NotBlank(message = "Nome de Guerra é obrigatório")
        String nomeDeGuerra,
        @NotBlank(message = "Lotação atual é obrigatória")
        String lotacao,
        @NotBlank(message = "Matrícula é obrigatória")
        Integer matricula,
        @Past(message = "A data da incorporação deve ser no passado")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato da data de nascimento inválido. Utilize dd/mm/aaaa")
        Date dataIncorporacao,
        @NotNull(message = "Dados de formação são obrigatórios")
        @Valid
        FormacaoDTO formacao,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        EnderecoDTO endereco) {
}
