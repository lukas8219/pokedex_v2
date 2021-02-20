import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PokemonService } from '../service/pokemon.service';
import PokemonTest from '../service/Templates/bulbasaur.json';
import lista from '../service/Templates/lista.json';

@Component({
  selector: 'pokemonComponent',
  templateUrl: './pokemon-component.component.html',
  styleUrls: ['./pokemon-component.component.css']
})
export class PokemonComponentComponent implements OnInit {

  pokemon:PokemonService;
  pokemonEvo:string[];
  id:any;
  lista:any;

  constructor(private pokemonService:PokemonService,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.pokemon = PokemonTest;
    this.pokemonEvo = PokemonTest.evolutions['evolutions'];
    this.lista = lista['pokemonList'];

    this.id = this.route.snapshot.paramMap.get("id");

    console.log(this.id);
  }

  previous(){
    return this.getData(this.lista[0].url, this.pokemon.id);
  }

  next(){
    return this.getData(this.lista[2].url, this.pokemon.id);
  }

  async getData(url:string, id:string) {
    var currentPokemonID = "";
    await this.pokemonService.getPokemon(url)
    .then(pokemon => {
      this.pokemon = pokemon;
      this.pokemonEvo = this.pokemon.evolutions['evolutions'];
      currentPokemonID = this.pokemon.id;

    });

    await this.pokemonService.getPokemonList(currentPokemonID)
    .then(lista => {
      this.lista = lista['pokemonList'];
    })

  }
}
