package interfaces;

import java.util.List;

public interface EvolutionChainInterface {

	/**
	 * Return a ArrayList of Pokemons withing that Evolution Chain
	 * @return the List of PokemonInterface
	 */
	public List<String> getEvolutions();
	/**
	 * Sets the Pokemons in the Evolution Chain
	 * @param pokemonList is a ArrayList of PokemonInterface
	 */
	public void setEvolutions(List<String> pokemonList);
	
	/**
	 * 
	 * @return the chain ID
	 */
	
	public String getId();
	
	/**
	 * Sets the Evolution chain ID
	 * @param id is a String corresponding to the Evolution Chain ID
	 */
	public void setId(String id);
	
}
