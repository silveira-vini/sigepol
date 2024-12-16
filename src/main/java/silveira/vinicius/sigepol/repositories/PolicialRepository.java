package silveira.vinicius.sigepol.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import silveira.vinicius.sigepol.domain.policial.Policial;

import java.util.List;

public interface PolicialRepository extends JpaRepository<Policial, Long> {

    List<Policial> findAllByAtivoTrue(Pageable pageable);
}
