package pokedex.evolutionchainservice.models;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import parsers.IDParser;

public class SpeciesID {

	public String getEvoID(String id) {
		JsonNode root = new RestTemplate().getForObject("https://pokeapi.co/api/v2/pokemon-species/"+id, JsonNode.class);
		String evoURL = root.get("evolution_chain").get("url").asText();
		
		return IDParser.parseEvolution(evoURL);
	}
	
}
