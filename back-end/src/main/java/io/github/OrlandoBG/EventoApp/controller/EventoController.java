package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.controller.dto.EventoDTO;
import io.github.OrlandoBG.EventoApp.model.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(value = "/api/eventos")
@RestController
public class EventoController {

    @Autowired
    private EventoService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<EventoDTO> obterTodos(@RequestParam(value="page", defaultValue = "0") Integer page,
                                      @RequestParam(value="size", defaultValue = "1") Integer size,
                                      @RequestParam(value="cidadeId", defaultValue = "0")Long cidadeId){
        PageRequest pageRequest = PageRequest.of(page, size);
        return service.obterTodos(cidadeId,pageRequest);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@Valid @RequestBody EventoDTO dto){
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
