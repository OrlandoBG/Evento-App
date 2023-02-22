import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { TemplateModule } from './template/template.module';
import { CidadeModule } from './cidade/cidade.module';
import { EventoModule } from './evento/evento.module';

import { CidadeService } from './cidade.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    CidadeModule,
    EventoModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [CidadeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
