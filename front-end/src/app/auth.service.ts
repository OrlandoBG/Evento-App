import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from './login/usuario';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url: string = environment.apiUrl + '/api/usuarios';
  tokenURL: string = environment.apiUrl + environment.obterTokenUrl;
  clientID: string = environment.clientId;
  clientSecret: string = environment.clientSecret;
  jwtHelper: JwtHelperService = new JwtHelperService();
  role: string[]= [];

  constructor(private http: HttpClient) { }

  salvar(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.url, usuario);
  }

  tentarLogar(username: string, password: string): Observable<any>{
    const params = new HttpParams()
                        .set('username', username)
                        .set('password', password)
                        .set('grant_type', 'password')

    const headers ={
      
      'authorization': 'Basic ' + btoa(`${this.clientID}:${this.clientSecret}`),
      'Content-Type':  'application/x-www-form-urlencoded'
    }
    return this.http.post(this.tokenURL, params.toString(),{ headers });
  }

  encerrarSessao(){
    localStorage.removeItem('access_token');
  }

  obterToken(){
    const tokenString = localStorage.getItem('access_token');
    if(tokenString){
      const token = JSON.parse(tokenString).access_token;
      return token;
    }
    return null; 
  }

  isRoleClient(){
    const token = this.obterToken();
    
    if(token){
      this.role = this.jwtHelper.decodeToken(token).authorities;
      for(let i =0; i< this.role.length; i++){
      if(this.role[i] == 'ROLE_CLIENT'){
        return true;
      }
      return false;
      }
    }
    return null;
  }

  decodeToken(){
    const token = this.obterToken();
    if(token){
      const usuario = this.jwtHelper.decodeToken(token);
      return usuario;
    }
    return null;
  }

  isAutenticated(): boolean{
    const token = this.obterToken();
    if(token){
      const expired = this.jwtHelper.isTokenExpired(token);
      return !expired;
    }
    return false;
  }

}
