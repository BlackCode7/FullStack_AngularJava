import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { IUsuarios } from './IUsuarios.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  baseURL: string = "http://localhost:8170/ApptestBackEnd/usuario/listatodos";

  dadosIPEA: string ="http://www.ipeadata.gov.br/api/odata4/Temas";

  constructor( private http: HttpClient ) { }

  getDadosIPEA(){
    return this.http.get<any>(this.dadosIPEA).pipe(
      map(retorno => retorno)
    )
  }

  public getUsuarios(): Observable<IUsuarios>{
    return this.http.get<IUsuarios>(this.baseURL).pipe(
      map(retorno => retorno)
    )
  }



}
