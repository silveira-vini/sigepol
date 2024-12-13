package silveira.vinicius.sigepol.domain.policial;

import silveira.vinicius.sigepol.domain.endereco.Endereco;
import silveira.vinicius.sigepol.domain.formacao.Formacao;

import java.util.Date;

public record PolicialDadosDetalhadoDTO(
        String nome,
        String cpf,
        String email,
        Date nascimento,
        String nomeMae,
        String nomePai,
        String patente,
        String nomeDeGuerra,
        String lotacao,
        String matricula,
        Date dataIncorporacao,
        Formacao formacao,
        Endereco endereco) {

    public PolicialDadosDetalhadoDTO(Policial policial) {
        this(policial.getNome(), policial.getCpf(), policial.getEmail(),
                policial.getNascimento(), policial.getNomeMae(), policial.getNomePai(),
                policial.getPatente(), policial.getNomeDeGuerra(), policial.getLotacao(),
                policial.getMatricula(), policial.getDataIncorporacao(), policial.getFormacao(),
                policial.getEndereco());
        }
}
