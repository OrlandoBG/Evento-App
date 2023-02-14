package io.github.OrlandoBG.EventoApp.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Cidade {

    @Column
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column
    private String nome;

    @OneToMany(mappedBy = "cidade")
    private List<Evento> eventos = new ArrayList<>();

}
