package defaultObjects;

import java.util.List;

import defaultAbstract.EvolutionChainAbstract;

public class EvolutionChainDefault extends EvolutionChainAbstract {

	public EvolutionChainDefault() {
	}
	
	public EvolutionChainDefault(String id, List<String> pokemonList) {
		setEvolutions(pokemonList);
		setId(id);
	}
	
}
