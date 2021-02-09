package standardObject;

import java.util.HashMap;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * 
 * @author Lucas
 *
 *Has to be a superclass
 *Has to be overriden in getPokeList, setPrev, setNext...
 */
public class PokemonList {

	private String next;
	private String prev;
	private HashMap<String, defaultPokemonInterface> pokeList;
	private int from;
	private int to;
	
	/*
	 * Default constructor with range from 1 to 10;
	 */
	public PokemonList(HashMap<String, defaultPokemonInterface> pokeList) {
		this.from = 1;
		this.to = 10;
		this.pokeList = pokeList;
	}
	
	public PokemonList(String next, String prev, HashMap<String, defaultPokemonInterface> pokeList, int from, int to) {
		super();
		this.next = next;
		this.prev = prev;
		this.pokeList = pokeList;
		this.from = from;
		this.to = to;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public HashMap<String, defaultPokemonInterface> getPokeList() {
		return pokeList;
	}

	public void setPokeList(HashMap<String, defaultPokemonInterface> pokeList) {
		this.pokeList = pokeList;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
}
