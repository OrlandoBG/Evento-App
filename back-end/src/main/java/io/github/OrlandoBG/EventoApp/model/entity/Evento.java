package io.github.OrlandoBG.EventoApp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
public class Evento {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private LocalDate data;

    @Column
    @Lob
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

}
