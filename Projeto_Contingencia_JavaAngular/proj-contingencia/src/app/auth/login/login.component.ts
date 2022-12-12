import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginAuthService } from 'src/app/services/login-auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Login } from 'src/app/models/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('formLogin') formLogin!: NgForm;
  
  login: any = Login;
  loading: boolean = false;
  message!: string;


  public usuario: string = 'admin';

  constructor( private loginAuthService: LoginAuthService, private router: Router, private route: ActivatedRoute ) {
    if( this.loginAuthService.usuarioLogado ){
      this.router.navigate( ["/home"] );
    }
   }

  ngOnInit(): void { /* Mostra mensagem ou não */
    this.route.queryParams.subscribe(params =>{
      this.message = params['error'];
    });
  }

  /* Vai verificar se os dados são validos para permitir entrada do usuario */
  logar(): void{
    this.loading = true;
    if( this.formLogin.form.valid ){
      this.loginAuthService.login(this.login).subscribe((usu) => {
        if( usu != null ){
          this.loginAuthService.usuarioLogado = usu;
          this.loading = false;
          this.router.navigate(["/home"]);
        }
        else{
          this.loading = false;
          this.message = "Usuário senha inválida!";
        }
      });
    }
  }

}
