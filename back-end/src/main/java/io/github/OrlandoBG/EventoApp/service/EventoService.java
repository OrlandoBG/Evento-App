package io.github.OrlandoBG.EventoApp.service;

import io.github.OrlandoBG.EventoApp.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import io.github.OrlandoBG.EventoApp.model.repository.CidadeRepository;
import io.github.OrlandoBG.EventoApp.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public Page<EventoDTO> obterTodos(Long cidadeId, Pageable pageable){
        Cidade cidade = (cidadeId == 0) ? null  : cidadeRepository.getOne(cidadeId);
        Page<Evento> paginaDeEventos = repository.obterTodos(cidade,pageable);
        return paginaDeEventos.map(evento -> new EventoDTO(evento, evento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    @Transactional
    public EventoDTO salvar(@RequestBody EventoDTO dto){
        dto.setId(null);
        Evento evento = dtoParaEvento(dto);
        evento = repository.save(evento);
        return new EventoDTO(evento, evento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public Evento dtoParaEvento(EventoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Evento evento = new Evento();
        evento.setId(dto.getId());
        evento.setNome(dto.getNome());
        evento.setData(data);
        evento.setUrl(dto.getUrl());
        evento.setCidade(new Cidade(dto.getCidade().getId(), null,null));
        return evento;
    }

}
