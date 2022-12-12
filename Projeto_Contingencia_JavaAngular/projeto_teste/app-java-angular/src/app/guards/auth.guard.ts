import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, CanDeactivate, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';

@Injectable({
  providedIn: 'root'
})


export class AuthGuard implements CanActivate, CanLoad {

  constructor( 
    private authService: AuthService,
    private router: Router
   ){

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
    ): Observable<boolean> | Promise<boolean> | boolean {
      console.log( 'AuthGuard' );
    return this.verificarAcesso();
  }
  verificarAcesso(){
    if( this.authService.usuarioEstaAutenticado() ){

      return true;
    }
    
    this.router.navigate(['/login']);

    return false;
  }
  
  canLoad( route: Route): Observable<boolean> | Promise<boolean> | boolean {
    console.log( 'canload: Verificando se o usuario pode carregar o cod módulo' );
    return this.verificarAcesso();
  }


/*

  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }


  canDeactivate(
    component: unknown,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }

*/



}
