import { Component} from '@angular/core';
import { CidadeService } from 'src/app/cidade.service';
import { Cidade } from '../cidade';


@Component({
  selector: 'app-cidade-form',
  templateUrl: './cidade-form.component.html',
  styleUrls: ['./cidade-form.component.css']
})
export class CidadeFormComponent {

  cidade: Cidade = new Cidade();

  
  constructor(private service: CidadeService){ }

  onSubmit(){
   
    this.service.salvar(this.cidade)
                .subscribe(response =>{
                  this.cidade = response;  
                });
  }

}
