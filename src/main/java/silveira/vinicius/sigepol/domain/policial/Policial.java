package silveira.vinicius.sigepol.domain.policial;

import jakarta.persistence.*;
import lombok.*;
import silveira.vinicius.sigepol.domain.endereco.Endereco;
import silveira.vinicius.sigepol.domain.formacao.Formacao;

import java.util.Date;

@Table(name = "policial")
@Entity(name = "Policial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Policial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Date nascimento;
    private String nomeMae;
    private String nomePai;
    private String patente;
    private String nomeDeGuerra;
    private String lotacao;
    private String matricula;
    private Date dataIncorporacao;
    private boolean ativo;
    @Embedded
    private Formacao formacao;
    @Embedded
    private Endereco endereco;


    public Policial(PolicialCadastroDTO dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.nascimento = dados.nascimento();
        this.nomeMae = dados.nomeMae();
        this.nomePai = dados.nomePai();
        this.patente = dados.patente();
        this.nomeDeGuerra = dados.nomeDeGuerra();
        this.lotacao = dados.lotacao();
        this.matricula = dados.matricula();
        this.dataIncorporacao = dados.dataIncorporacao();
        this.ativo = true;
        this.formacao = new Formacao(dados.formacao());
        this.endereco = new Endereco(dados.endereco());
    }
}
