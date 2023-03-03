import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthClientGuard } from '../auth-client.guard';
import { EventoFormComponent } from './evento-form/evento-form.component';
import { EventoListagemComponent } from './evento-listagem/evento-listagem.component';

const routes: Routes = [
  {path:'evento-form', component: EventoFormComponent, canActivate:[AuthClientGuard]},
  {path:'evento-listagem', component: EventoListagemComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventoRoutingModule { }
