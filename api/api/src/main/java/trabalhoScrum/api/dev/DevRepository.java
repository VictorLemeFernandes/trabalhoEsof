// Essa interface eh responsavel pela insercao, remocao e update no BD


package trabalhoScrum.api.dev;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<Dev, Long> {

}
