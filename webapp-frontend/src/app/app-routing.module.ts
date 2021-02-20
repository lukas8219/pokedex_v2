import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokemonComponentComponent } from './pokemon-component/pokemon-component.component';

const routes: Routes = [
  {
    path: '*/:id',
    component: PokemonComponentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
