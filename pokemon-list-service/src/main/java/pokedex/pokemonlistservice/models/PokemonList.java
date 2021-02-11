package pokedex.pokemonlistservice.models;

import java.util.ArrayList;

import interfaces.ListItemInterface;
import interfaces.PokemonListInterface;

public class PokemonList implements PokemonListInterface{

	private ArrayList<ListItemInterface> pokemonList;
	private int size;
	
	public PokemonList() {
	}
	
	public PokemonList(ArrayList<ListItemInterface> pokeList, int size) {
		this.pokemonList = pokeList;
		this.size = size;
	}
	
	@Override
	public ArrayList<ListItemInterface> getPokemonList() {
		return this.pokemonList;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setPokemonList(ArrayList<ListItemInterface> pokeList) {
		this.pokemonList = pokeList;
		
	}

	@Override
	public void setSize(int size) {
		this.size = size;
		
	}

}
