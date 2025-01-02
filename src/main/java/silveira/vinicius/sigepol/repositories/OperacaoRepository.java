package silveira.vinicius.sigepol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silveira.vinicius.sigepol.domain.operacao.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
