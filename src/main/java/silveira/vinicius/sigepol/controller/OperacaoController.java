package silveira.vinicius.sigepol.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import silveira.vinicius.sigepol.domain.operacao.OperacaoCadastroDTO;
import silveira.vinicius.sigepol.service.OperacaoService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoService operacaoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarOperacao(@RequestBody @Valid OperacaoCadastroDTO dados) throws MalformedURLException, URISyntaxException {
        var detalhamentoOperacao = operacaoService.cadastrarOperacao(dados);
        return ResponseEntity.ok(detalhamentoOperacao);

    }


}
