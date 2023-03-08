import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  
  cadastrando: boolean = false;
  username: string ="";
  password: string ="";
  mensagemSucesso: string = "";
  errors: String[] = [];
  message: string = "";

  constructor(private authService: AuthService, private router: Router){}

  onSubmit(){

    this.authService.tentarLogar(this.username, this.password)
                .subscribe(response =>{
                  const access_token = JSON.stringify(response);
                  localStorage.setItem('access_token', access_token);
                  this.router.navigate(['/home']);
                }, errorResponse =>{
                  this.errors = ['Usuário e/ou senha incorretos.'];
                });
  }

  preparaCadastrar(event: { preventDefault: () => void; }){
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;

    this.authService
      .salvar(usuario)
      .subscribe(response =>{
        this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue o login.";
        this.errors = []
        this.cadastrando = false;
        this.username="";
        this.password="";
        this.message = ""
      }, errorResponse =>{
        this.errors = errorResponse.error.errors;
        this.mensagemSucesso = "";
        this.message = errorResponse.error.message;
      });
  }

}
