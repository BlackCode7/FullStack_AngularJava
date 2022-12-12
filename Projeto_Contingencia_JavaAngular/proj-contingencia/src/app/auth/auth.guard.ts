import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginAuthService } from '../services/login-auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor( 
    private loginAuthService: LoginAuthService,
    private router: Router
   ){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    
      const usuarioLogado = this.loginAuthService.usuarioLogado;
      let url = state.url;

      if( usuarioLogado ){
        if(   route.data?.['role'] && route.data?.['role'].indexOf(usuarioLogado.perfi) === -1 ){
          // Se o perfil do susario não estiver no login ele retorna para a tela de login
          this.router.navigate(['/login'], { queryParams: { error: "Proibido o acesso a " + url }});

          return false;
        }
        // Em qualquer outro caso permite a acesso
        return true;
      }
      this.router.navigate(['/login'], { queryParams: { error: "Deve fazer o login antes de tentar acessar " + url}});
      return false;
  }

  
  
}
