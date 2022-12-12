import { Router } from '@angular/router';
import { Injectable, EventEmitter } from '@angular/core';

import { Usuario } from './usuario';


@Injectable()
export class AuthService{

    private usuarioAutenticado: boolean = false;
    mostrarMenuEmitter = new EventEmitter<boolean>();

    constructor( private router: Router ){}

    fazerLohin( usuario: Usuario ){

        if( usuario.nome === "usuario@email.com" && usuario.senha === "1234567" ){
            this.usuarioAutenticado = true; // autentica usuario
            this.mostrarMenuEmitter.emit(true); // mostra o menu
            this.router.navigate(['/']); // e navega para pagina inicial
        } else{
            this.usuarioAutenticado = false;
            this.mostrarMenuEmitter.emit(false);
        }
    }

    usuarioEstaAutenticado(){
        return this.usuarioAutenticado;
    }


}