import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonComponentComponent } from './pokemon-component/pokemon-component.component';
import { EvolutionComponentComponent } from './evolution-component/evolution-component.component';
import { ActivatedRoute, RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    PokemonComponentComponent,
    EvolutionComponentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot([
      { path : ':id', component: PokemonComponentComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
}
