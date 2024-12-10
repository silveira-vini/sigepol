package silveira.vinicius.sigepol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import silveira.vinicius.sigepol.domain.policial.Policial;
import silveira.vinicius.sigepol.domain.policial.PolicialCadastroDTO;
import silveira.vinicius.sigepol.domain.policial.PolicialDadosDetalhadoDTO;
import silveira.vinicius.sigepol.repositories.PolicialRepository;

@RestController
@RequestMapping("/policial")
public class PolicialController {

    @Autowired
    private PolicialRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(PolicialCadastroDTO dados, UriComponentsBuilder uriBuilder) {
        var policial = new Policial(dados);
        repository.save(policial);
        var uri = uriBuilder.path("policial/{id}").buildAndExpand(policial.getId()).toUri();
        return ResponseEntity.created(uri).body(new PolicialDadosDetalhadoDTO(policial));
    }
}
