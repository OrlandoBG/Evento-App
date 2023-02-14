package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/cidade")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> obter(){
       return service.findAll();
}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeDTO salvar( @RequestBody CidadeDTO dto){
        return service.salvar(dto);
    }


}
