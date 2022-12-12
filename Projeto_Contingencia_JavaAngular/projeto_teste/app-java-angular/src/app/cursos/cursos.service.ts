import { Injectable } from "@angular/core";


@Injectable()
export class CursosService {

    getCursos(){
        return[
            { id:1, nome: "Angular 14"},
            { id:2, nome: "Java"},
            { id:3, nome: "Spring Boot"},
            { id:4, nome: "TypeScript"},
            { id:5, nome: "JavaScript"},
            { id:6, nome: "PostgreSql"},
            { id:7, nome: "ElastiSearch"}
        ];
    }

    getCurso(id: number){

        let cursos = this.getCursos();

        for( let i = 0; i < cursos.length; i++ ){

            let curso = cursos[i];

            if( curso.id == id ){

                return curso;

            }
        }

        return null;

    }

    constructor(){}


}