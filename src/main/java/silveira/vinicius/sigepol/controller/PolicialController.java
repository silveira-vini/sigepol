package silveira.vinicius.sigepol.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silveira.vinicius.sigepol.domain.policial.PolicialCadastroDTO;
import silveira.vinicius.sigepol.domain.policial.PolicialDadosDetalhadoDTO;
import silveira.vinicius.sigepol.domain.policial.PolicialListagemDTO;
import silveira.vinicius.sigepol.servive.PolicialService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/policial")
public class PolicialController {

    @Autowired
    private PolicialService policialService;

    @PostMapping
    @Transactional
    public ResponseEntity<PolicialDadosDetalhadoDTO> cadastrar(@RequestBody @Valid PolicialCadastroDTO dados, UriComponentsBuilder uriBuilder) throws MalformedURLException, URISyntaxException {
        return policialService.cadastrarPolicial(dados, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<List<PolicialListagemDTO>> listar(@RequestParam int pagina, @RequestParam int itens) {
        return policialService.listarTodos(pagina, itens);
    }

}
