package io.github.OrlandoBG.EventoApp.model.repository;

import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
