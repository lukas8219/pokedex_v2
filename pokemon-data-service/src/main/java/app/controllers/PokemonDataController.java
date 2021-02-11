package app.controllers;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.models.Pokemon;
import app.models.repository.PokemonRepository;
import interfaces.PokemonInterface;


@RestController
@RequestMapping("/")
@EnableCaching
public class PokemonDataController {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@GetMapping("/{id}")
	@Cacheable("id")
	public PokemonInterface getPokemonData(@PathVariable("id") String id) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		Optional<PokemonInterface> pokeQuery = pokemonRepository.findById(id);
		
		if(pokeQuery.isEmpty()) {
			Pokemon currentPokemon = new ObjectMapper().readValue(new URL("https://pokeapi.co/api/v2/pokemon/"+id), Pokemon.class);
			pokemonRepository.save(currentPokemon);
			return currentPokemon;
		} else {
			return pokeQuery.get();
		}
		
	}
	
	@PutMapping("/{id}")
	public void updatePokemon(@RequestBody PokemonInterface pokemonToUpdate) {
		pokemonRepository.save(pokemonToUpdate);
	}
}
