package silveira.vinicius.sigepol.domain.operacao;

import silveira.vinicius.sigepol.domain.endereco.Endereco;

import java.time.LocalDateTime;

public record OperacaoDadosDetalhadoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime data,
        Endereco local,
        Long responsavelId,
        Long viaturaId) {

    public OperacaoDadosDetalhadoDTO(Operacao operacao) {
        this(operacao.getId(),
                operacao.getNome(),
                operacao.getDescricao(),
                operacao.getData(),
                operacao.getLocal(),
                operacao.getResponsavel().getId(),
                operacao.getViatura().getId());
    }
}
