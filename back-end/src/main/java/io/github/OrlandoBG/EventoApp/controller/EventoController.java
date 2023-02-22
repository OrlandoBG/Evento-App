package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/evento")
@RestController
public class EventoController {

    @Autowired
    private EventoService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<EventoDTO> obterTodos(Pageable pageable,
                                   @RequestParam(value="cidadeId", defaultValue = "0")Long cidadeId){
        return service.obterTodos(cidadeId,pageable);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EventoDTO salvar(@RequestBody EventoDTO dto){
        return service.salvar(dto);
    }

}
