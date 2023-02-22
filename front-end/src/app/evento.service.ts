import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Evento } from './evento/evento';


@Injectable({
  providedIn: 'root'
})
export class EventoService {

  url: string  = environment.apiUrl + '/api/evento';

  constructor(private http: HttpClient) { }

  salvar(evento: Evento): Observable<Evento>{
    return this.http.post<Evento>(this.url, evento);
  }

  obter(): Observable<any>{
    return this.http.get<any>(this.url);
  }

}
