package defaultAbstract;

import java.util.ArrayList;

import interfaces.ListItemInterface;
import interfaces.PokemonListInterface;

public abstract class PokemonListAbstract implements PokemonListInterface {

	private ArrayList<ListItemInterface> pokemonList;
	private int size;
	
	@Override
	public ArrayList<ListItemInterface> getPokemonList() {
		return this.pokemonList;
	}

	@Override
	public void setPokemonList(ArrayList<ListItemInterface> pokeList) {
		this.pokemonList = pokeList;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

}
