package defaultAbstract;

import java.util.ArrayList;

import interfaces.EvolutionChainInterface;
import interfaces.PokemonInterface;

public class EvolutionChainAbstract implements EvolutionChainInterface {

	private ArrayList<PokemonInterface> evolutions;
	private String id;
	
	@Override
	public ArrayList<PokemonInterface> getEvolutions() {
		return this.evolutions;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setEvolutions(ArrayList<PokemonInterface> pokemonList) {
		this.evolutions = pokemonList;
		
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

}
