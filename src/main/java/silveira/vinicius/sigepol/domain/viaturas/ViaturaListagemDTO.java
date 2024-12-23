package silveira.vinicius.sigepol.domain.viaturas;

import java.util.List;

public record ViaturaListagemDTO(
    String placa,
    String prefixo,
    String marca,
    String modelo,
    String ano
) {

}
