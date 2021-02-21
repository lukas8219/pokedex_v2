package app.controllers;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import defaultObjects.PokemonDefault;
import interfaces.PokemonInterface;


@RestController
@RequestMapping("/")
public class PokemonDataController {
	
	@Autowired
	private PokemonRepository pokemonCollection;
	
	@GetMapping("/{inputId}")
	public PokemonInterface getPokemonData(@PathVariable("inputId") String inputId) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		Optional<PokemonInterface> pokemonQuery = pokemonCollection.findById(inputId);
		
		if(pokemonQuery.isEmpty()) {
			Pokemon pokemon = new ObjectMapper().readValue(new URL("https://pokeapi.co/api/v2/pokemon/"+inputId), Pokemon.class);
			pokemonCollection.save(pokemon);
			return pokemon;
		} else {
			return pokemonQuery.get();
		}
		
	}
	
	@PutMapping
	public void updatePokemon(@RequestBody PokemonDefault pokemonToUpdate) {
		pokemonCollection.save(pokemonToUpdate);
	}
}
