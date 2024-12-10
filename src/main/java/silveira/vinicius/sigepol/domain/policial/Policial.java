package silveira.vinicius.sigepol.domain.policial;

import jakarta.persistence.*;
import lombok.*;
import silveira.vinicius.sigepol.domain.dadosFuncionais.DadosFuncionais;
import silveira.vinicius.sigepol.domain.endereco.Endereco;
import silveira.vinicius.sigepol.domain.formacao.Formacao;

import java.util.Date;

@Table(name = "policial")
@Entity(name = "Policial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Policial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Date nascimento;
    private String nomeMae;
    private String nomePai;
    @Embedded
    private Endereco endereco;
    @Embedded
    private DadosFuncionais dadosFuncionais;
    @Embedded
    private Formacao formacao;
    private boolean ativo;


}
