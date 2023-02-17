package io.github.OrlandoBG.EventoApp.service;


import io.github.OrlandoBG.EventoApp.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.entity.Evento;
import io.github.OrlandoBG.EventoApp.model.repository.EventoRepository;
import io.github.OrlandoBG.EventoApp.factory.EventoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class EventoServiceTest {

    @InjectMocks
    private EventoService service;

    @Mock
    private EventoRepository repository;

    private EventoDTO eventoDTO;
    private Evento evento;
    private PageImpl<Evento> pagina;
    private PageImpl<EventoDTO> paginaDTO;


    @BeforeEach
    void setUp() throws Exception{

        eventoDTO = EventoFactory.criarEventoDTO();
        evento = EventoFactory.criarEvento();
        pagina = new PageImpl<>(List.of(evento));
        paginaDTO = new PageImpl<>(List.of(eventoDTO));
        Mockito.when(repository.save(evento)).thenReturn(evento);
        Mockito.when(repository.obterTodos((Cidade)ArgumentMatchers.any(),(Pageable)ArgumentMatchers.any())).thenReturn(pagina);
    }

    @Test
    public void obterTodosDeveriaRetornarPaginaDeEventos(){
        Pageable pageable = PageRequest.of(0,10);
        Page<EventoDTO> paginaDeEventos =  service.obterTodos(0L, pageable);
        Assertions.assertNotNull(paginaDeEventos);
        Assertions.assertEquals(paginaDTO, paginaDeEventos);
    }

    @Test
    public void salvarDeveriaRetornarEventoDTO(){

        EventoDTO e = service.salvar(eventoDTO);

        Assertions.assertEquals(eventoDTO, e);

        Mockito.verify(repository).save(evento);
    }



}
