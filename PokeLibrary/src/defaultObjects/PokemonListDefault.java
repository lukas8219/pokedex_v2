package defaultObjects;

import java.util.ArrayList;

import defaultAbstract.PokemonListAbstract;
import interfaces.ListItemInterface;

public class PokemonListDefault extends PokemonListAbstract {

	PokemonListDefault(ArrayList<ListItemInterface> pokeList, int size){
		setPokemonList(pokeList);
		setSize(size);
	}
	
	PokemonListDefault(){
	}
	
}
