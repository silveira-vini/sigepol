package silveira.vinicius.sigepol.domain.policial;

import jakarta.persistence.*;
import lombok.*;
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
    private String patente;
    private String nomeDeGuerra;
    private String lotacao;
    private Integer matricula;
    private Date dataIncorporacao;
    private boolean ativo;
    @Embedded
    private Formacao formacao;
    @Embedded
    private Endereco endereco;


}
