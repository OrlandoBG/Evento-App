import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventoFormComponent } from './evento-form/evento-form.component';
import { EventoListagemComponent } from './evento-listagem/evento-listagem.component';

const routes: Routes = [
  {path:'evento-form', component: EventoFormComponent},
  {path:'evento-listagem', component: EventoListagemComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventoRoutingModule { }
