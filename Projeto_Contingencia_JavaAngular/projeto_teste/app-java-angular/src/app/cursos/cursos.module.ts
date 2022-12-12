import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { CursosRoutingModule } from './cursos.routing.module';
import { CursosComponent } from './cursos.component';
import { CursoDetalheComponent } from './curso-detalhe/curso-detalhe.component';
import { CursoNaoEncontradoComponent } from './curso-nao-encontrado/curso-nao-encontrado.component';
import { CursoFormComponent } from './curso-form/curso-form.component';
import { CursosService } from "./cursos.service";

@NgModule({
    imports: [
        CommonModule,
        CursosRoutingModule
    ],

    exports: [],
    declarations: [
        CursosComponent,
        CursoDetalheComponent,
        CursoNaoEncontradoComponent,
        CursoFormComponent
    ],
    providers: [ CursosService ],
})

export class CursosModule { }