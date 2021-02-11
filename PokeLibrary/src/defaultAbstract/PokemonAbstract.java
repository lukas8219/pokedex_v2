package defaultAbstract;

import java.util.ArrayList;
import java.util.HashMap;

import defaultObjects.EvolutionChainDefault;
import interfaces.EvolutionChainInterface;
import interfaces.PokemonInterface;

/**
 * 
 * @author Lucas
 *
 */
public abstract class PokemonAbstract implements PokemonInterface{

	private String name;
	private String id;
	private String iconURL;
	private ArrayList<String> types;
	private int height;
	private int weight;
	private ArrayList<String> abilities;
	private EvolutionChainInterface evolutions;
	private HashMap<String, Integer> baseStatus;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getIconURL() {
		return this.iconURL;
	}
	
	@Override
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	
	@Override
	public ArrayList<String> getTypes() {
		return this.types;
	}
	
	@Override
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public ArrayList<String> getAbilities() {
		return this.abilities;
	}
	
	@Override
	public void setAbilities(ArrayList<String> abilities) {
		this.abilities = abilities;
	}
	
	@Override
	public EvolutionChainInterface getEvolutions() {
		return this.evolutions;
	}
	
	@Override
	public void setEvolutions(EvolutionChainInterface evolutions) {
		this.evolutions = evolutions;
	}

	public HashMap<String, Integer> getBaseStatus() {
		return this.baseStatus;
	}

	public void setBaseStatus(HashMap<String, Integer> baseStatus) {
		this.baseStatus = baseStatus;
	}
	
	
}
