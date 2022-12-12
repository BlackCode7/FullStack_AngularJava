import { Injectable } from '@angular/core';
import { off } from 'process';
import { of } from 'rxjs/internal/observable/of';
import { Login } from '../models/login.model';
import { Usuario } from '../models/usuario.model';
import { Observable } from 'rxjs';

const LS_CHAVE: string = "usuarioLogado";

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {

  constructor() { }

  public get usuarioLogado(): Usuario{    
    let usu = localStorage[LS_CHAVE];    
    return ( usu ? JSON.parse( localStorage[LS_CHAVE] ) : null);
  }

  public set usuarioLogado( usuario: Usuario ){
    localStorage[LS_CHAVE] = JSON.stringify(usuario);
  }

  logout(){
    delete localStorage[LS_CHAVE];
  }

  login(login: Login): Observable<Usuario | null>{
    let usu = new Usuario(1, "Razer-FUNC", login.login, login.senha, "FUNC")
    if( login.login == login.senha ){
      if( login.login == "admin" ){
        usu = new Usuario( 1, "Razor-Admin", login.login, login.senha, "ADMIN" );
      }
      else if( login.login == "gerente" ){
        usu = new Usuario(1, "Razor-Gerente", login.login, login.senha, "GERENTE");      
      }
      return of(usu);
    }
    else{
      return of(null);
    }

  }




}
