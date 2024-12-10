package silveira.vinicius.sigepol.domain.formacao;

import jakarta.persistence.Embeddable;
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
}
