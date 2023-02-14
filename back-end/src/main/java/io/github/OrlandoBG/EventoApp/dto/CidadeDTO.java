package io.github.OrlandoBG.EventoApp.dto;

import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {

    private Long id;

    private String nome;

    public CidadeDTO(Cidade entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
