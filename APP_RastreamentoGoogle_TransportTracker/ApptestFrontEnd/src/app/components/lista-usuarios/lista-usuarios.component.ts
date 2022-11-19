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
  dataSource: any = new IUsuarios();
  displayedColumns = ["nome", "email", "seriePeito"];

  //testss: any = new Array<IUsuarios>();

  //dadosIpeia: any;


  constructor(
    private usuariosService: UsuarioServiceService
  ) { }

  ngOnInit() {
    //this.getDadosIpeia()
    this.getUsuarios()
  }

/*
  getDadosIpeia(){
    this.usuariosService.getDadosIPEA().subscribe( dadosipeia => {
      this.dadosIpeia = dadosipeia
    })
  }
*/

 
  getUsuarios(){
    this.usuariosService.getUsuarios().subscribe( (data: any) => {
      this.dataSource = data;
    })
  }



}
