package app.models;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import interfaces.EvolutionChainInterface;
import interfaces.PokemonInterface;

@JsonDeserialize(using = PokemonDeserializer.class)
public class Pokemon implements PokemonInterface {

	private String name;
	@Id
	private String id;
	private String iconURL;
	private int height;
	private int weight;
	private ArrayList<String> types;
	private ArrayList<String> abilities;
	private EvolutionChainInterface evolutions;
	private HashMap<String, Integer> baseStatus;
	
	public Pokemon() {
	}
	
	public Pokemon(String name, String id, String iconURL, int height, int weight, ArrayList<String> types,
			ArrayList<String> abilities, HashMap<String, Integer> baseStatus) {
		this.name = name;
		this.id = id;
		this.iconURL = iconURL;
		this.height = height;
		this.weight = weight;
		this.types = types;
		this.abilities = abilities;
		this.baseStatus = baseStatus;
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
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public ArrayList<String> getAbilities() {
		return abilities;
	}
	public void setAbilities(ArrayList<String> abilities) {
		this.abilities = abilities;
	}
	public EvolutionChainInterface getEvolutions() {
		return evolutions;
	}
	public void setEvolutions(EvolutionChainInterface evolutions) {
		this.evolutions = evolutions;
	}
	public HashMap<String, Integer> getBaseStatus() {
		return baseStatus;
	}
	public void setBaseStatus(HashMap<String, Integer> baseStatus) {
		this.baseStatus = baseStatus;
	}
	
	
	
}
