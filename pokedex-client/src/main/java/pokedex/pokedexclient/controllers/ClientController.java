package pokedex.pokedexclient.controllers;

import defaultObjects.EvolutionChainDefault;
import defaultObjects.PokemonDefault;
import defaultObjects.PokemonListDefault;
import interfaces.PokemonInterface;
import interfaces.PokemonListInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ClientController {

	@Autowired
	public RestTemplate rest;

	@Cacheable(value = "{id}")
	@CrossOrigin
	@GetMapping("{id}")
	public PokemonInterface returnPokemon(@PathVariable("id") String id) {
		
		PokemonDefault pokemon = rest.getForObject("http://pokemon-data-service/"+id, PokemonDefault.class);
		
		if(pokemon.getEvolutions() == null) {
			pokemon.setEvolutions(rest.getForObject("http://evolution-chain-service/"+id, EvolutionChainDefault.class));
			rest.put("http://pokemon-data-service/"+id, pokemon);
		}
		return pokemon;
	}

	@Cacheable(value = "{id}")
	@CrossOrigin
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
