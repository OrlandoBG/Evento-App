import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthClientGuard } from '../auth-client.guard';
import { CidadeFormComponent } from './cidade-form/cidade-form.component';
import { CidadeListagemComponent } from './cidade-listagem/cidade-listagem.component';

const routes: Routes = [
  {path:'cidade-form', component: CidadeFormComponent, canActivate:[AuthClientGuard]},
  {path: 'cidade-listagem', component: CidadeListagemComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CidadeRoutingModule { }
