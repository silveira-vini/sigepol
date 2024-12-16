package silveira.vinicius.sigepol.servive;

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

    @Autowired
    private PolicialRepository repository;

    public ResponseEntity<PolicialDadosDetalhadoDTO> cadastrarPolicial(PolicialCadastroDTO dados, UriBuilder uriBuilder) throws MalformedURLException, URISyntaxException {
        var policial = new Policial(dados);
        repository.save(policial);
        var uri = uriBuilder.path("policial/{id}").build(policial.getId()).toURL();
        return ResponseEntity.created(uri.toURI()).body(new PolicialDadosDetalhadoDTO(policial));
    }

    public ResponseEntity<List<PolicialListagemDTO>> listarTodos(int pagina, int itens) {
        return ResponseEntity.ok(repository.findAllByAtivoTrue(PageRequest.of(pagina, itens))
                .stream().map(p -> new PolicialListagemDTO(p.getPatente(), p.getNomeDeGuerra(), p.getMatricula()))
                .collect(Collectors.toList()));
    }
}
