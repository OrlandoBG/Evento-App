package io.github.OrlandoBG.EventoApp.dto;

import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private LocalDate data;

    private String url;

    private Long cidade_id;

    public EventoDTO(Evento entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.data = entity.getData();
        this.url = entity.getUrl();
        this.cidade_id = entity.getCidade().getId();
    }


}
