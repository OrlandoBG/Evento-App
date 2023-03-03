package io.github.OrlandoBG.EventoApp.model.repository;

import io.github.OrlandoBG.EventoApp.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    boolean existsByUsername(String username);
}
