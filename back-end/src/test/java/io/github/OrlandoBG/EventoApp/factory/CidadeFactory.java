package io.github.OrlandoBG.EventoApp.factory;

import io.github.OrlandoBG.EventoApp.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CidadeFactory {

    public static Cidade criarCidade(){
        List<Evento> evento = new ArrayList<>();
        Cidade cidade = new Cidade(1L,"São Paulo", evento);
        return cidade;
    }

    public static Cidade criarCidadeSemId(){
        List<Evento> evento = new ArrayList<>();
        Cidade cidade = new Cidade(null,"São Paulo", evento);
        return cidade;
    }

    public static CidadeDTO CriarCidadeDto(){
        CidadeDTO dto = new CidadeDTO(criarCidade());
        return dto;
    }

    public static List<Cidade> criarListaDeCidades() {
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(new Cidade(1L, "São Paulo",null));
        cidades.add(new Cidade(2L, "Bauru",null));
        return cidades;
    }

    public static List<CidadeDTO> criarListaDeCidadesDTO() {
        List<Cidade> cidades = criarListaDeCidades();
        return cidades.stream().map(c -> new CidadeDTO(c)).collect(Collectors.toList());
    }


}
