package io.github.OrlandoBG.EventoApp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email(message = "{usuario.email.invalido}")
    @Column(unique = true, name="email")
    @NotEmpty(message = "{usuario.login.obrigatorio}")
    private String username;

    @NotEmpty(message = "{usuario.senha.obrigatorio}")
    @Column(name = "senha")
    private String password;

}
