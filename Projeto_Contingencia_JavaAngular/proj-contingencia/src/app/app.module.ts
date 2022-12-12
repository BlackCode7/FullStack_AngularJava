import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { ListacontingenciaComponent } from './listacontingencia/listacontingencia.component';
import { CadastracontingenciaComponent } from './cadastracontingencia/cadastracontingencia.component';
import { HomeComponent } from './home/home.component';
import { AuthModule } from './auth/auth.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListacontingenciaComponent,
    CadastracontingenciaComponent,
    HomeComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    AuthModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
