package silveira.vinicius.sigepol.domain.viaturas;

public record ViaturaAtualizacaoDTO(String placa,
                                    String prefixo,
                                    String marca,
                                    String modelo,
                                    String ano,
                                    String km) {
}
