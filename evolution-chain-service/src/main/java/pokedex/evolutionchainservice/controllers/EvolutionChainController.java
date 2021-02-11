package pokedex.evolutionchainservice.controllers;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import interfaces.EvolutionChainInterface;
import pokedex.evolutionchainservice.models.EvolutionChain;
import pokedex.evolutionchainservice.models.SpeciesID;

@RestController
@RequestMapping("/")
public class EvolutionChainController {

	
	@GetMapping("/{id}")
	public EvolutionChainInterface getEvolutionChain(@PathVariable("id") String id) {
		String evoID = new SpeciesID().getEvoID(id);
		EvolutionChain evoChain = new RestTemplate().getForObject("https://pokeapi.co/api/v2/evolution-chain/"+evoID, EvolutionChain.class);
		
		return new EvolutionChain(evoChain.getId(),
				evoChain.getEvolutions()
				.stream()
				.filter(x -> ! x.equals(id))
				.collect(Collectors.toList()));
	}
	
}
