package silveira.vinicius.sigepol.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import silveira.vinicius.sigepol.domain.viaturas.*;
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
                .map(v -> new ViaturaListagemDTO(v.getPrefixo(), v.getMarca(), v.getModelo()));
        return ResponseEntity.ok(page);
    }

    public ResponseEntity<ViaturaDadosDetalhadoDTO> detalharViatura(Long id) {
        var viatura = viaturaRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new ViaturaDadosDetalhadoDTO(viatura));
    }

    public ResponseEntity<ViaturaDadosDetalhadoDTO> atualizarViatura(Long id, @Valid ViaturaAtualizacaoDTO dados) {
        var viatura = viaturaRepository.findById(id).orElseThrow();
        viatura.atualizar(dados);
        viaturaRepository.save(viatura);
        return ResponseEntity.ok(new ViaturaDadosDetalhadoDTO(viatura));
    }

    public ResponseEntity<?> deletarViatura(Long id) {
        var viatura = viaturaRepository.findById(id).orElseThrow();
        viatura.desativar();
        viaturaRepository.save(viatura);
        return ResponseEntity.noContent().build();
    }
}