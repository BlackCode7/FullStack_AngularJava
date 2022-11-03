import { Component, OnInit, ViewChild } from '@angular/core';
import { IUsuarios } from './IUsuarios.model';
import { UsuarioServiceService } from './usuario-service.service';
import { Observable, Subscriber } from 'rxjs';
import { MatTable } from '@angular/material/table';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  /* Dados retornados na tabela */
  dataSource: any = new Array<IUsuarios>();
  displayedColumns = ["nome", "email", "seriePeito"];

  testss: any = new Array<IUsuarios>();


  constructor(
    private usuariosService: UsuarioServiceService
  ) { }

  ngOnInit() {
    this.getUsuarios()
  }

 
  getUsuarios(){
    this.usuariosService.getUsuarios().subscribe( data => {
      this.dataSource = data;
    })
  }



}
