import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from './models/usuario.model';
import { LoginAuthService } from './services/login-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proj-contingencia';

  constructor(
    private router: Router,
    private loginAuthService: LoginAuthService
  ){}

  get usuarioLogado( ): Usuario | null {
    return this.loginAuthService.usuarioLogado;
  }

  logout(){
    this.loginAuthService.logout();
    this.router.navigate(['/login']);
  }

}
