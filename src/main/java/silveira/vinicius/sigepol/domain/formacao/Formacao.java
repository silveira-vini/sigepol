package silveira.vinicius.sigepol.domain.formacao;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formacao {

    private String grau;
    private String curso;
    private Boolean concluido;
    private Integer anoConclusao;

    public Formacao(@NotNull(message = "Dados de formação são obrigatórios") @Valid FormacaoDTO formacao) {
        this.grau = formacao.grau();
        this.curso = formacao.curso();
        this.concluido = formacao.concluido();
        this.anoConclusao = formacao.anoConclusao();
    }
}
