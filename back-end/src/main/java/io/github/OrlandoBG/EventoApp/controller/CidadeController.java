package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.controller.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RequestMapping(value = "/api/cidades")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CidadeDTO> obter(){
       return service.obterTodos();
}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CidadeDTO> salvar(@Valid @RequestBody CidadeDTO dto){
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
