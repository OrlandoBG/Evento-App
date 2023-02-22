import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CidadeFormComponent } from './cidade-form/cidade-form.component';

const routes: Routes = [
  {path:'cidade-form', component: CidadeFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CidadeRoutingModule { }
