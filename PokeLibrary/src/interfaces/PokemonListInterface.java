package interfaces;

import java.util.ArrayList;

public interface PokemonListInterface {

	public ArrayList<ListItemInterface> getPokemonList();
	public void setPokemonList(ArrayList<ListItemInterface> pokeList);
	
	public int getSize();
	public void setSize(int size);
	
}
