package pokedex.pokedexclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import defaultObjects.EvolutionChainDefault;
import defaultObjects.PokemonDefault;
import defaultObjects.PokemonListDefault;
import interfaces.PokemonInterface;
import interfaces.PokemonListInterface;

@RestController
@RequestMapping("/")
public class ClientController {

	@Autowired
	public RestTemplate rest;
	
	@GetMapping("{id}")
	public PokemonInterface returnPokemon(@PathVariable("id") String id) {
		
		PokemonDefault pokemon = rest.getForObject("http://pokemon-data-service/"+id, PokemonDefault.class);
		
		if(pokemon.getEvolutions() == null) {
			pokemon.setEvolutions(rest.getForObject("http://evolution-chain-service/"+id, EvolutionChainDefault.class));
			rest.put("http://pokemon-data-service/"+id, pokemon);
		}
		return pokemon;
	}
	
	@GetMapping("/list/{id}")
	public PokemonListInterface returnList(@RequestParam(value = "size", required = false) Integer size, @PathVariable("id") String id) {
		
		PokemonListDefault returnList;
		
		if(size == null) {
			returnList = rest.getForObject("http://pokemon-list-service/"+id, PokemonListDefault.class);
		} else {
			returnList = rest.getForObject("http://pokemon-list-service/"+id+"?size="+size, PokemonListDefault.class);
		}
		
		return returnList;
	}
}
