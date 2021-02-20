package pokedex.pokemonlistservice.controllers;

import defaultObjects.PokemonDefault;
import interfaces.ListItemInterface;
import interfaces.PokemonListInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pokedex.pokemonlistservice.models.ListItem;
import pokedex.pokemonlistservice.models.PokemonList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class ListController {
	
	
	@Autowired
	private RestTemplate rest;
	
	@GetMapping("/{id}")
	public PokemonListInterface getPokemonList(@PathVariable("id") int from, @RequestParam(value="size", required=false) Integer size) throws MalformedURLException, IOException, RestClientException, URISyntaxException {
		
		PokemonList pokedex = new PokemonList();
		ArrayList<ListItemInterface> pokeList = new ArrayList<>();
		
		if(size == null) {
			size = 3;
			pokeList = getDefaultList(from);
		} else {
			pokeList = getListFrom(from, size);
		}
		
		pokedex.setPokemonList(pokeList);
		pokedex.setSize(size);

		return pokedex;
	}
	
	private ArrayList<ListItemInterface> getDefaultList(int id) throws RestClientException, URISyntaxException{
		
		ArrayList<ListItemInterface> currentList = new ArrayList<>();
		
		int from = id-1;
		int to = id+1;
		
		for(int i=from; i<=to; i++) {
			
			int pokemonID = i;
			
			if(i==0) pokemonID = 898;
			if(i==899) pokemonID = 1;
			
			PokemonDefault currentPokemon = rest.getForObject(new URI("http://pokemon-data-service/"+pokemonID), PokemonDefault.class);
			ListItem item = new ListItem(currentPokemon.getName(), "/"+currentPokemon.getId());
			currentList.add(item);
		}
		
		return currentList;
	}
	
	private ArrayList<ListItemInterface> getListFrom(int from, int size) throws RestClientException, URISyntaxException{
		
		ArrayList<ListItemInterface> currentList = new ArrayList<>();
		
		for(int i=from; currentList.size() != size; i++) {
			
			if(i==899) {
				i = 1;
			}
			
			PokemonDefault currentPokemon = rest.getForObject(new URI("http://pokemon-data-service/"+i), PokemonDefault.class);
			ListItem item = new ListItem(currentPokemon.getName(), "/"+currentPokemon.getId());
			currentList.add(item);
		}
		
		return currentList;
	}
	
}
