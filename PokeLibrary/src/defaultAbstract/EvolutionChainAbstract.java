package defaultAbstract;

import java.util.List;

import interfaces.EvolutionChainInterface;

public class EvolutionChainAbstract implements EvolutionChainInterface {

	private List<String> evolutions;
	private String id;
	
	@Override
	public List<String> getEvolutions() {
		return this.evolutions;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setEvolutions(List<String> pokemonList) {
		this.evolutions = pokemonList;
		
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

}
