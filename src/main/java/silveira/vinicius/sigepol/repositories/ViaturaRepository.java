package silveira.vinicius.sigepol.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import silveira.vinicius.sigepol.domain.viaturas.Viatura;


public interface ViaturaRepository extends JpaRepository<Viatura, Long> {
    Page<Viatura> findAllByAtivoTrue(Pageable pageable);
}
