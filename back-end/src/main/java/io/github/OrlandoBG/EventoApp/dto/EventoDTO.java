package io.github.OrlandoBG.EventoApp.dto;

import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO implements Serializable {

    private Long id;

    private String nome;

    private String data;

    private String url;

    private CidadeDTO cidade;

    public EventoDTO(Evento entity, String data){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.data = data;
        this.url = entity.getUrl();
        this.cidade = new CidadeDTO(entity.getCidade());
    }

}
