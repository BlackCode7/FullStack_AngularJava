import { Component, OnInit } from '@angular/core';
import { IUsuarios } from './IUsuarios.model';
import { UsuarioServiceService } from './usuario-service.service';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  usuariosModel: IUsuarios  = new IUsuarios()  ;

  constructor(
    private usuariosService: UsuarioServiceService
  ) { }

  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios(){
    this.usuariosService.getUsuarios().subscribe( data => {
      this.usuariosModel = data;
    })
  }

}
