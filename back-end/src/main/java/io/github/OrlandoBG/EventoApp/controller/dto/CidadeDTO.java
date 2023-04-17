package io.github.OrlandoBG.EventoApp.controller.dto;


import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO implements Serializable{

    private Long id;

    @NotEmpty(message = "{cidade.nome.obrigatorio}")
    private String nome;

    public CidadeDTO(Cidade entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
