package io.github.OrlandoBG.EventoApp.model.repository;

import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
