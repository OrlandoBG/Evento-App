package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value = "/api/cidade")
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
    public CidadeDTO salvar( @Valid @RequestBody CidadeDTO dto){
            return service.salvar(dto);
    }
}
