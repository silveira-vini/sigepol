package silveira.vinicius.sigepol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import silveira.vinicius.sigepol.domain.operacao.Operacao;
import silveira.vinicius.sigepol.domain.operacao.OperacaoCadastroDTO;
import silveira.vinicius.sigepol.domain.operacao.OperacaoDadosDetalhadoDTO;
import silveira.vinicius.sigepol.domain.policial.Policial;
import silveira.vinicius.sigepol.domain.viaturas.Viatura;
import silveira.vinicius.sigepol.repositories.OperacaoRepository;
import silveira.vinicius.sigepol.repositories.PolicialRepository;
import silveira.vinicius.sigepol.repositories.ViaturaRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public class OperacaoService {

    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private PolicialRepository policialRepository;
    @Autowired
    private ViaturaRepository viaturaRepository;


    public OperacaoDadosDetalhadoDTO cadastrarOperacao(OperacaoCadastroDTO dados) throws MalformedURLException, URISyntaxException {
        Policial responsavel = policialRepository.findById(dados.responsavelId()).orElseThrow(() -> new IllegalArgumentException("Policial não encontrado"));
        Viatura viatura = viaturaRepository.findById(dados.viaturaId()).orElseThrow(() -> new IllegalArgumentException("Viatura não encontrada"));

        var operacao = new Operacao(dados, responsavel, viatura);
        operacaoRepository.save(operacao);
        return new OperacaoDadosDetalhadoDTO(operacao);
    }

}
