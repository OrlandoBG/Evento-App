package io.github.OrlandoBG.EventoApp.factory;

import io.github.OrlandoBG.EventoApp.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;

import java.time.LocalDate;


public class EventoFactory {

    public static Evento criarEvento(){
        Evento evento = new Evento(1L,"Feira do Software", LocalDate.of(2023,05,02),"https://feiradosoftware.com",new Cidade(1L,null,null));
        return evento;
    }

    public static EventoDTO criarEventoDTO(){
        EventoDTO dto = new EventoDTO(criarEvento());
        return dto;
    }



}
