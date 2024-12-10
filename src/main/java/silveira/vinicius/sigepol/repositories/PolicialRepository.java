package silveira.vinicius.sigepol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silveira.vinicius.sigepol.domain.policial.Policial;

public interface PolicialRepository extends JpaRepository<Policial, Long> {
}
