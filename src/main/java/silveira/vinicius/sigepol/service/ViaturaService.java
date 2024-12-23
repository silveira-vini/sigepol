package silveira.vinicius.sigepol.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import silveira.vinicius.sigepol.domain.viaturas.Viatura;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaCadastroDTO;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaDadosDetalhadoDTO;
import silveira.vinicius.sigepol.domain.viaturas.ViaturaListagemDTO;
import silveira.vinicius.sigepol.repositories.ViaturaRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public class ViaturaService {

    private final ViaturaRepository viaturaRepository;

    public ViaturaService(ViaturaRepository viaturaRepository) {
        this.viaturaRepository = viaturaRepository;
    }

    public ResponseEntity<ViaturaDadosDetalhadoDTO> cadastrarViatura(ViaturaCadastroDTO dados, UriComponentsBuilder uriBuilder) throws URISyntaxException, MalformedURLException {
        var viatura = new Viatura(dados);
        viaturaRepository.save(viatura);
        var uri = uriBuilder.path("viatura/{id}").build(viatura.getId()).toURL();
        return ResponseEntity.created(uri.toURI()).body(new ViaturaDadosDetalhadoDTO(viatura));
    }

    public ResponseEntity<Page<ViaturaListagemDTO>> listarViaturas(Pageable pageable) {
        var page = viaturaRepository.findAllByAtivoTrue(pageable)
                .map(v -> new ViaturaListagemDTO(v.getPlaca(), v.getPrefixo(), v.getMarca(), v.getModelo(), v.getAno()));
        return ResponseEntity.ok(page);
    }
}