package io.github.OrlandoBG.EventoApp.model.repository;

import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("SELECT obj" +
            " FROM Evento obj" +
            " WHERE (:cidade IS NULL OR obj.cidade = :cidade)" +
            " ORDER BY obj.nome")
    Page<Evento> obterTodos(Cidade cidade, Pageable pageable);

}
