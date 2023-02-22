import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CidadeRoutingModule } from './cidade-routing.module';
import { CidadeFormComponent } from './cidade-form/cidade-form.component';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';



@NgModule({
  declarations: [
    CidadeFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    CidadeRoutingModule
  ],
  exports:[
    CidadeFormComponent
  ]
})
export class CidadeModule { }
