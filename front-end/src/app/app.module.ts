import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { TemplateModule } from './template/template.module';
import { CidadeModule } from './cidade/cidade.module';
import { EventoModule } from './evento/evento.module';

import { CidadeService } from './cidade.service';
import { LoginComponent } from './login/login.component';

import { TokenInterceptor } from './token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    RouterModule,
    MatButtonModule,
    FormsModule,
    MatInputModule,
    MatCardModule,
    CidadeModule,
    EventoModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    CidadeService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
