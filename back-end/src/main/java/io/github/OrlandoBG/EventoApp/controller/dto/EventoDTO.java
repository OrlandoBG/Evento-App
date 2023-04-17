package io.github.OrlandoBG.EventoApp.controller.dto;

import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "{evento.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{evento.data.obrigatorio}")
    private String data;

    @NotEmpty(message = "{evento.url.obrigatorio}")
    private String url;

    @Valid
    private CidadeDTO cidade;

    public EventoDTO(Evento entity, String data){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.data = data;
        this.url = entity.getUrl();
        this.cidade = new CidadeDTO(entity.getCidade());
    }

}
