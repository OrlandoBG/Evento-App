import { Component, OnInit } from '@angular/core';
import { Cidade } from 'src/app/cidade/cidade';
import { EventoService } from 'src/app/evento.service';
import { Evento } from '../evento';

@Component({
  selector: 'app-evento-listagem',
  templateUrl: './evento-listagem.component.html',
  styleUrls: ['./evento-listagem.component.css']
})
export class EventoListagemComponent {

  eventos: Evento[] = [];
  colunas = ['id', 'nome', 'data', 'url', 'cidade'];
  cidades: Cidade[] = [];
  cidade_id: number = 0;

  constructor(private service: EventoService){}
  
  ngOnInit(){
    this.service.obter()
                .subscribe(response => this.eventos = response.content);
  }

}
