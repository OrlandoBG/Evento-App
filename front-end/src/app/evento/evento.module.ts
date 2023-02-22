import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { EventoRoutingModule } from './evento-routing.module';
import { EventoFormComponent } from './evento-form/evento-form.component';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';

import { EventoListagemComponent } from './evento-listagem/evento-listagem.component';


@NgModule({
  declarations: [
    EventoFormComponent,
    EventoListagemComponent
  ],
  imports: [
    CommonModule,
    EventoRoutingModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatTableModule,
    FormsModule
  ],
  exports:[
    EventoFormComponent,
    EventoListagemComponent
  ]
})
export class EventoModule { }
