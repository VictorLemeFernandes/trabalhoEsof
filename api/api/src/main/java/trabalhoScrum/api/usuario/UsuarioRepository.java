package trabalhoScrum.api.usuario;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmail(String email);
}
