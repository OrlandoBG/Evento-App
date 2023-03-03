import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Evento } from './evento/evento';
import { PaginaContato } from './evento/paginaContato';


@Injectable({
  providedIn: 'root'
})
export class EventoService {

  url: string  = environment.apiUrl + '/api/eventos';

  constructor(private http: HttpClient) { }

  salvar(evento: Evento): Observable<Evento>{
    return this.http.post<Evento>(this.url, evento);
  }

  obter(cidade_id: number, pagina: number, tamanho: number): Observable<PaginaContato>{
    const httpParams = new HttpParams()
    .set("cidadeId", cidade_id ? cidade_id.toString() : "")
    .set("page", pagina ? pagina.toString() : "0")
    .set("size", tamanho.toString());
    const url = this.url + '?' + httpParams.toString(); 
    
    return this.http.get<any>(url);
  }

}
