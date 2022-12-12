import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { HomeComponent } from './home/home.component';
import { ListacontingenciaComponent } from './listacontingencia/listacontingencia.component';
import { CadastracontingenciaComponent } from './cadastracontingencia/cadastracontingencia.component';
import { LoginRoutes } from './auth/auth-routing.module';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [

  { path:"", redirectTo: "login", pathMatch: "full"},
  { path:"home", component: HomeComponent, canActivate: [ AuthGuard], data: { role:" ADMIN, GERENTE, FUNC" } },
  { path:"listacontingencia", component: ListacontingenciaComponent, canActivate: [ AuthGuard], data: { role:" ADMIN, GERENTE, FUNC" } },
  { path:"cadastracontingencia", component: CadastracontingenciaComponent, canActivate: [ AuthGuard], data: { role:" ADMIN, GERENTE, FUNC" } },
  ...LoginRoutes

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
