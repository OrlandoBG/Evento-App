import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cidade } from './cidade/cidade';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  url: string = environment.apiUrl + '/api/cidade';

  constructor(private http: HttpClient) {}

    salvar(cidade: Cidade): Observable<Cidade>{
      return this.http.post<Cidade>(this.url, cidade);
    }

    obter(): Observable<any>{
      return this.http.get<any>(this.url);
    }

   
}
