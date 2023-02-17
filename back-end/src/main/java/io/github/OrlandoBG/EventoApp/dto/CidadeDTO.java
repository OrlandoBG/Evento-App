package io.github.OrlandoBG.EventoApp.dto;

import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public CidadeDTO(Cidade entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
