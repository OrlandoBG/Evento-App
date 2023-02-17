package io.github.OrlandoBG.EventoApp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private LocalDate data;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

}
