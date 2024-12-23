package silveira.vinicius.sigepol.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaCadastroDTO;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaDadosDetalhadoDTO;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaListagemDTO;
import silveira.vinicius.sigepol.service.ViaturaService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/viatura")
public class ViaturaController {

    private final ViaturaService viaturaService;

    public ViaturaController(ViaturaService viaturaService) {
        this.viaturaService = viaturaService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ViaturaDadosDetalhadoDTO> cadastrar(@RequestBody @Valid ViaturaCadastroDTO dados, UriComponentsBuilder uriBuilder) throws MalformedURLException, URISyntaxException {
        return viaturaService.cadastrarViatura(dados, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<ViaturaListagemDTO>> listar(@PageableDefault(size = 10, sort = {"prefixo"}) Pageable pageable) {
        return viaturaService.listarViaturas(pageable);
    }

}
