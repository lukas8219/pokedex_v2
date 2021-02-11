package pokedex.evolutionchainservice.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import interfaces.EvolutionChainInterface;

@JsonDeserialize(using = EvolutionChainDeserializer.class)
public class EvolutionChain implements EvolutionChainInterface {

	private String id;
	private List<String> evolutions;
	
	public EvolutionChain() {
	}
	
	public EvolutionChain(String id, List<String> evo) {
		this.id = id;
		this.evolutions= evo;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getEvolutions() {
		return evolutions;
	}
	public void setEvolutions(List<String> evolutions) {
		this.evolutions = evolutions;
	}
	
}
