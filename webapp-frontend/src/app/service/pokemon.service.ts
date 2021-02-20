import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  name:string;
  id:string;
  iconURL:string;
  types:string[];
  height:number;
  weight:number;
  abilities:string[];
  evolutions:any;
  baseStatus: {
    Speed:number,
    SpecialAttack:number,
    HP:number,
    SpecialDefense:number,
    Attack:number,
    Defense:number
  }

  constructor(private http?:HttpClient) {}

  async getPokemon(url:string):Promise<PokemonService>{

    var pokemon:any;

    await fetch("http://localhost:8085"+url)
    .then(response => response.json())
    .then(data => {
      pokemon = data;
    })

    
    return pokemon;
  }

  async getPokemonList(url:string):Promise<any>{

    var list:any;

    await fetch("http://localhost:8085/list/"+url)
    .then(response => response.json())
    .then(data => {
      list = data;
      return list;
    })

    return list;
    
  }

}
