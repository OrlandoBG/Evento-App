import { Component, OnInit } from '@angular/core';
import { CidadeService } from 'src/app/cidade.service';
import { Cidade } from 'src/app/cidade/cidade';
import { EventoService } from 'src/app/evento.service';
import { Evento } from '../evento';

@Component({
  selector: 'app-evento-form',
  templateUrl: './evento-form.component.html',
  styleUrls: ['./evento-form.component.css']
})
export class EventoFormComponent {

  evento: Evento = new Evento();
  cidades: Cidade[] = [];

  constructor(private cidadeService: CidadeService, private eventoService: EventoService){}

  ngOnInit(){
    
    this.cidadeService.obter()
                      .subscribe(response =>{
                        this.cidades = response;
                      });
  }

  Onsubmit(){
    console.log(this.evento);
    this.eventoService.salvar(this.evento)
                      .subscribe(response =>{
                        console.log(response);
                        this.evento = response;
                      });
  }

}
