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
	public RestTemplate restRequest;

	@Cacheable(value = "{inputId}")
	@CrossOrigin
	@GetMapping("{inputId}")
	public PokemonInterface returnPokemon(@PathVariable("inputId") String inputId) {
		
		PokemonDefault pokemon = restRequest.getForObject("http://pokemon-data-service/"+inputId, PokemonDefault.class);
		
		if(pokemon.getEvolutions() == null) {
			pokemon.setEvolutions(restRequest.getForObject("http://evolution-chain-service/"+inputId, EvolutionChainDefault.class));
			restRequest.put("http://pokemon-data-service/", pokemon);
		}
		return pokemon;
	}

	@Cacheable(value = "{id}")
	@CrossOrigin
	@GetMapping("/list/{id}")
	public PokemonListInterface returnList(@RequestParam(value = "size", required = false) Integer listSize, @PathVariable("id") String id) {
		
		PokemonListDefault returnList;
		
		if(listSize == null) {
			returnList = restRequest.getForObject("http://pokemon-list-service/"+id, PokemonListDefault.class);
		} else {
			returnList = restRequest.getForObject("http://pokemon-list-service/"+id+"?size="+listSize, PokemonListDefault.class);
		}
		
		return returnList;
	}
}
