import { Component, OnInit } from '@angular/core';
import { CidadeService } from 'src/app/cidade.service';
import { Cidade } from '../cidade';

@Component({
  selector: 'app-cidade-listagem',
  templateUrl: './cidade-listagem.component.html',
  styleUrls: ['./cidade-listagem.component.css']
})
export class CidadeListagemComponent {

  cidades: Cidade[] = [];
  colunas = ['id', 'nome'];


  constructor(private service: CidadeService){}

  ngOnInit(){
    this.service.obter()
                .subscribe(response => this.cidades = response);
  }

}
