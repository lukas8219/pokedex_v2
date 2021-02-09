package standardObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import utility.pokemonDeserializer.PokemonDeserializerDefault;


/**
 * 
 * @author Lucas Weis Polesello - Git @lukas819
 *	
 *	Class utilized to alocated JSON into Java object to further manipulation
 *	Contains name, id, status, icon_url, weight, height, abilities, types
 *	and possibility to add evolutions.
 */

@JsonDeserialize(using = PokemonDeserializerDefault.class)
public class defaultPokemon implements defaultPokemonInterface{

	
	/**
	 * Pokemon Name
	 */
	private String name;
	
	/**
	 * PokemonID can be utilized to found Species.
	 */
	private String id;
	/*
	 * HashMap containing Keys
	 * HP, Attack, Defense, Special Attack, Special Defense, Speed.
	 */
	private HashMap<String, Integer> base_status;
	private ArrayList<String> types;
	private List<defaultPokemonInterface> evolutions;
	/**
	 * URL that disposes a .jpeg of the PokemonICON
	 */
	private String icon_url;
	private int height;
	private int weight;
	private ArrayList<String> abilities;
	
	public defaultPokemon() {
	}
	
	public defaultPokemon(String name, String id, HashMap<String, Integer> base_status, ArrayList<String> types,
			String icon_url, int weight, int height, ArrayList<String> abilities) {
		this.name = name;
		this.id = id;
		this.base_status = base_status;
		this.types = types;
		this.icon_url = icon_url;
		this.weight = weight;
		this.height = height;
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, Integer> getBase_status() {
		return base_status;
	}

	public void setBase_status(HashMap<String, Integer> base_status) {
		this.base_status = base_status;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	public List<defaultPokemonInterface> getEvolutions() {
		return evolutions;
	}

	public void setEvolutions(List<defaultPokemonInterface> evolutions) {
		this.evolutions = evolutions;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void insertEvolution(defaultPokemonInterface p) {
		this.evolutions.add(p);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<String> abilities) {

		this.abilities = abilities;
	}

	
	
	
}
