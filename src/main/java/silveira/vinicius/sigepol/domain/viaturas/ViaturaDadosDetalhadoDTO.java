package silveira.vinicius.sigepol.domain.viaturas;

public record ViaturaDadosDetalhadoDTO(
        Long id,
        String placa,
        String prefixo,
        String marca,
        String modelo,
        String ano,
        String km
) {
    public ViaturaDadosDetalhadoDTO(Viatura viatura) {
        this(viatura.getId(),
                viatura.getPlaca(),
                viatura.getPrefixo(),
                viatura.getMarca(),
                viatura.getModelo(),
                viatura.getAno(),
                viatura.getKm());
    }
}
