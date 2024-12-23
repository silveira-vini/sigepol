package silveira.vinicius.sigepol.domain.viaturas;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "viaturas")
@Entity (name = "Viaturas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Viatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String prefixo;
    private String marca;
    private String modelo;
    private String ano;
    private String km;
    private boolean ativo;


    public Viatura (ViaturaCadastroDTO dados) {
        this.placa = dados.placa();
        this.prefixo = dados.prefixo();
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.km = dados.km();
        this.ativo = true;
    }
}
