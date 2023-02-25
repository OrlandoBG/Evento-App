package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/evento")
@RestController
public class EventoController {

    @Autowired
    private EventoService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<EventoDTO> obterTodos(@RequestParam(value="page", defaultValue = "0") Integer page,
                                      @RequestParam(value="size", defaultValue = "0") Integer size,
                                   @RequestParam(value="cidadeId", defaultValue = "0")Long cidadeId){
        PageRequest pageRequest = PageRequest.of(page, size);
        return service.obterTodos(cidadeId,pageRequest);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EventoDTO salvar(@Valid @RequestBody EventoDTO dto){
        return service.salvar(dto);
    }

}
