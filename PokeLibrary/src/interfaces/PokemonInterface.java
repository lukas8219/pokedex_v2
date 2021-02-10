package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface PokemonInterface {
	//name, id, iconURL,height,weight, base status, types, abilities, evolutions.
	
	/**
	 * @return the Pokemon's Name
	 */
	public String getName();
	
	/**
	 * Set the PokemonName
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * 
	 * @return the Pokemon Pixel URL
	 */
	public String getIconURL();
	/**
	 * Sets the URL to the Icon
	 * @param iconURL
	 */
	public void setIconURL(String iconURL);
	
	/**
	 * 
	 * @return the Pokemon ID
	 */
	public String getId();
	/**
	 * Sets the Pokemon ID
	 * @param id
	 */
	public void setId(String id);
	
	/**
	 * 
	 * @return the Pokemon height
	 */
	public int getHeight();
	/**
	 * Sets the Pokemon Height
	 * @param height
	 */
	public void setHeight(int height);
	
	/**
	 * 
	 * @return the Pokemon Weight
	 */
	public int getWeight();
	/**
	 * Sets the Pokemon Weight
	 * @param weight
	 */
	public void setWeight(int weight);
	
	/**
	 * 
	 * @return the Pokemon Base Status containing 6 Keys(HP, Attack, Defense, Special Attack, Special Defense, Speed)
	 */
	public HashMap<String, Integer> getBaseStatus();
	/**
	 * Sets the Pokemon Base Status. Needs to have 6 Keys equals to (HP, Attack, Defense, Special Attack, Special Defense, Speed)
	 * @param base_status
	 */
	public void setBaseStatus(HashMap<String, Integer> base_status);
	
	/**
	 * 
	 * @return an ArrayList of String (Types)
	 */
	public ArrayList<String> getTypes();
	/**
	 * Sets the Types
	 * @param types
	 */
	public void setTypes(ArrayList<String> types);
	
	/**
	 * 
	 * @return the Abilities
	 */
	public ArrayList<String> getAbilities();
	/**
	 * Sets the Abilities
	 * @param abilities
	 */
	public void setAbilities(ArrayList<String> abilities);
	
	/**
	 * 
	 * @return a List containing all evolutions from the Pokemon
	 */
	public ArrayList<PokemonInterface> getEvolutions();
	
	/**
	 * Sets the evolution list.
	 * @param AllPokemons
	 */
	public void setEvolutions(ArrayList<PokemonInterface> AllPokemons);
}
