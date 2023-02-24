import { Component, OnInit} from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatSelectChange } from '@angular/material/select';
import { CidadeService } from 'src/app/cidade.service';
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

  totalElementos: number = 0;
  pagina: number = 0;
  tamanho: number = 5;
  pageSizeOptions: number[] = [5];

  constructor(private service: EventoService, private cidadeService: CidadeService){}

  paginar(event: PageEvent){
    this.pagina = event.pageIndex;
    this.obterEventos(this.cidade_id, this.pagina, this.tamanho);
  }

  obterEventos(cidade_id: number, pagina: number, tamanho:number){
    this.service.obter(cidade_id, pagina, tamanho)
                .subscribe(response =>{
                   this.eventos = response.content;
                   this.totalElementos = response.totalElements;
                   this.pagina = response.number;
                  });
  }

  onCidadeChange(event: MatSelectChange){
    this.cidade_id = event.value;
    this.obterEventos(this.cidade_id, this.pagina, this.tamanho);
  }
  
  ngOnInit(){
  
    this.cidadeService.obter()
                      .subscribe(response => this.cidades = response);

    this.obterEventos(this.cidade_id, this.pagina, this.tamanho);
  }

}
