import { AlunosService } from './../alunos/alunos.service';
import { Aluno } from './../alunos/alunos';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Resolve } from '@angular/router';

@Injectable()
export class AlunoDetalheResolver implements Resolve<Aluno> {

    constructor(private alunosService: AlunosService) {}

    resolve( route: ActivatedRouteSnapshot, state: RouterStateSnapshot ): Observable<any>|Promise<any>|any {
            console.log('AlunoDetalheResolver');            
            let id = route.params['id'];            
            return this.alunosService.getAluno(id);
    }
    
}