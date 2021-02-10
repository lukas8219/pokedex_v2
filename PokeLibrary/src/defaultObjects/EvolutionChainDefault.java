package defaultObjects;

import java.util.ArrayList;

import defaultAbstract.EvolutionChainAbstract;
import interfaces.PokemonInterface;

public class EvolutionChainDefault extends EvolutionChainAbstract {

	public EvolutionChainDefault() {
	}
	
	public EvolutionChainDefault(String id, ArrayList<PokemonInterface> pokemonList) {
		setEvolutions(pokemonList);
		setId(id);
	}
	
}
