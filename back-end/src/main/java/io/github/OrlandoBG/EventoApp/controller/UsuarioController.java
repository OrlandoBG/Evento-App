package io.github.OrlandoBG.EventoApp.controller;

import io.github.OrlandoBG.EventoApp.model.entity.Usuario;
import io.github.OrlandoBG.EventoApp.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
            service.salvar(usuario);
    }
}
