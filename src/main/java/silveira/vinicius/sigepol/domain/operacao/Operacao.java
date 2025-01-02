package silveira.vinicius.sigepol.domain.operacao;

import jakarta.persistence.*;
import lombok.*;
import silveira.vinicius.sigepol.domain.endereco.Endereco;
import silveira.vinicius.sigepol.domain.policial.Policial;
import silveira.vinicius.sigepol.domain.viaturas.Viatura;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "Operacao")
@Table(name = "operacao")
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime data;
    @Embedded
    private Endereco local;
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Policial responsavel;
    @ManyToOne
    @JoinColumn(name = "viatura_id")
    private Viatura viatura;

    public Operacao(OperacaoCadastroDTO dados, Policial responsavel, Viatura viatura) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.data = dados.data();
        this.local = dados.local();
        this.responsavel = responsavel;
        this.viatura = viatura;

    }
}

