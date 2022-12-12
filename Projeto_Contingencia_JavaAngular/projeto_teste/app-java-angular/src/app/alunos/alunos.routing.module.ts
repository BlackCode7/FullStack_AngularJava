import { NgModule, Component } from '@angular/core';
import { RouterModule, CanActivateChild } from '@angular/router';
import { AlunosComponent } from './alunos.component';
import { AlunosGuard } from '../guards/alunos.guard';
import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { AlunosDeactivateGuard} from '../guards/alunos-deactivate.guard';


const alunosRoutes = [

    {
        path: '', Comment: AlunosComponent,
        canActivateChild: [AlunosGuard],
        children: [
            { path: 'novo', component: AlunoFormComponent },
            { path: 'id', component: AlunoDetalheComponent, resolve: { aluno: AlunoDetalheComponent }},
            { path: ':id/editar', component: AlunoFormComponent, canDeactivate: [ AlunosDeactivateGuard ]}
        ]
    }

];

@NgModule({
    imports: [ RouterModule.forChild( alunosRoutes) ],
    exports: [RouterModule]
})

export class AlunosRoutingModule{}