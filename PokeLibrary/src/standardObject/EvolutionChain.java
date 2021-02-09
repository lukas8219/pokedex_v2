package standardObject;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * 
 * @author Lucas Weis Polesello
 *
 *Has to be parent-class in the Application
 *Has to be overriden
 *Has to get Annotation of JsonDeserialize
 */
public class EvolutionChain {
	
	/**
	 * Contains the EvolutionChain ID
	 */
	private int id;
	
	/**
	 * Contains a List of All pokemons from this Chain ID.
	 */
	private List<defaultPokemonInterface> chain;
	
	public EvolutionChain() {
	}
	
	public EvolutionChain(int id, List<defaultPokemonInterface> chain) {
		this.id = id;
		this.chain = chain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<defaultPokemonInterface> getChain() {
		return chain;
	}

	public void setChain(List<defaultPokemonInterface> chain) {
		this.chain = chain;
	}
	
	
	
}
