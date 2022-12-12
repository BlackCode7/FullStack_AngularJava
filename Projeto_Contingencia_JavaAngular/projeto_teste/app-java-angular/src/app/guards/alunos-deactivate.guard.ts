import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, CanDeactivate, CanLoad, Route, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { IFormCanDeactivate } from './iform-candeactivate';

@Injectable({
  providedIn: 'root'
})
export class AlunosDeactivateGuard implements  CanDeactivate<IFormCanDeactivate> {
  
  canDeactivate(
    component: IFormCanDeactivate,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

      console.log('guarda de desativação');

    return component.podeDesativar ? component.podeDesativar() : true;
  }

}
