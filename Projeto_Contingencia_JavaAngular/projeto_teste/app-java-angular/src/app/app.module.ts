import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CursosComponent } from './cursos/cursos.component';
import { AlunosComponent } from './alunos/alunos.component';
import { CursoDetalheComponent } from './cursos/curso-detalhe/curso-detalhe.component';
import { CursoFormComponent } from './cursos/curso-form/curso-form.component';
import { CursoNaoEncontradoComponent } from './cursos/curso-nao-encontrado/curso-nao-encontrado.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PaginaNaoEncontradaComponent,
    LoginComponent,
    HomeComponent,
    CursosComponent,
    AlunosComponent,
    CursoDetalheComponent,
    CursoFormComponent,
    CursoNaoEncontradoComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
