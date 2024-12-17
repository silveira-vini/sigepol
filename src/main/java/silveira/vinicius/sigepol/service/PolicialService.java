package silveira.vinicius.sigepol.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import silveira.vinicius.sigepol.domain.policial.Policial;
import silveira.vinicius.sigepol.domain.policial.PolicialCadastroDTO;
import silveira.vinicius.sigepol.domain.policial.PolicialDadosDetalhadoDTO;
import silveira.vinicius.sigepol.domain.policial.PolicialListagemDTO;
import silveira.vinicius.sigepol.repositories.PolicialRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicialService {

    private final PolicialRepository repository;

    @Autowired
    public PolicialService(PolicialRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<PolicialDadosDetalhadoDTO> cadastrarPolicial(PolicialCadastroDTO dados, UriBuilder uriBuilder) {
        try {
            var policial = new Policial(dados);
            repository.save(policial);
            var uri = uriBuilder.path("policial/{id}").build(policial.getId()).toURL();
            return ResponseEntity.created(uri.toURI()).body(new PolicialDadosDetalhadoDTO(policial));
        } catch (MalformedURLException | URISyntaxException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<PolicialListagemDTO>> listarTodos(int pagina, int itens) {
        if (pagina < 0 || itens <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var policiais = repository.findAllByAtivoTrue(PageRequest.of(pagina, itens))
                .stream()
                .map(p -> new PolicialListagemDTO(p.getPatente(), p.getNomeDeGuerra(), p.getMatricula()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(policiais);
    }

    public ResponseEntity<PolicialDadosDetalhadoDTO> buscarPorId(Long id) {
        var policial = repository.findById(id);
        return policial.map(p -> ResponseEntity.ok(new PolicialDadosDetalhadoDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<PolicialDadosDetalhadoDTO> atualizar(Long id, @Valid PolicialCadastroDTO dados) {
        var policial = repository.findById(id);
        if (policial.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var p = policial.get();
        p.atualizar(dados);
        repository.save(p);
        return ResponseEntity.ok(new PolicialDadosDetalhadoDTO(p));
    }
}