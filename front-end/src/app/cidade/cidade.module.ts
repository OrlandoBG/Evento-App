import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CidadeRoutingModule } from './cidade-routing.module';
import { CidadeFormComponent } from './cidade-form/cidade-form.component';

import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CidadeListagemComponent } from './cidade-listagem/cidade-listagem.component';



@NgModule({
  declarations: [
    CidadeFormComponent,
    CidadeListagemComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    CidadeRoutingModule
  ],
  exports:[
    CidadeFormComponent,
    CidadeListagemComponent
  ]
})
export class CidadeModule { }
