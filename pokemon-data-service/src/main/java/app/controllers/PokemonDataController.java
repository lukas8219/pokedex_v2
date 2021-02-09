package app.controllers;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import standardObject.defaultPokemon;


@RestController
@RequestMapping("/")
@EnableCaching
public class PokemonDataController {
	
	@GetMapping("/{id}")
	@Cacheable("id")
	public defaultPokemon getPokemonData(@PathVariable("id") String id) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		return new ObjectMapper().readValue(new URL("https://pokeapi.co/api/v2/pokemon/"+id), defaultPokemon.class);
	}
}
