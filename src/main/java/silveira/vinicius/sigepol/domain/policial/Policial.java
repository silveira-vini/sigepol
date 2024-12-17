package silveira.vinicius.sigepol.domain.policial;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    public void atualizar(@Valid PolicialCadastroDTO dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.cpf() != null) this.cpf = dados.cpf();
        if (dados.email() != null) this.email = dados.email();
        if (dados.nascimento() != null) this.nascimento = dados.nascimento();
        if (dados.nomeMae() != null) this.nomeMae = dados.nomeMae();
        if (dados.nomePai() != null) this.nomePai = dados.nomePai();
        if (dados.patente() != null) this.patente = dados.patente();
        if (dados.nomeDeGuerra() != null) this.nomeDeGuerra = dados.nomeDeGuerra();
        if (dados.lotacao() != null) this.lotacao = dados.lotacao();
        if (dados.matricula() != null) this.matricula = dados.matricula();
        if (dados.dataIncorporacao() != null) this.dataIncorporacao = dados.dataIncorporacao();
        if (dados.formacao() != null) this.formacao.atualizarFormacao(dados.formacao());
        if (dados.endereco() != null) this.endereco.atualizarEndereco(dados.endereco());
    }
}
