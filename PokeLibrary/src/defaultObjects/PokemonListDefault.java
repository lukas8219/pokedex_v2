package defaultObjects;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import defaultAbstract.PokemonListAbstract;
import interfaces.ListItemInterface;

@JsonDeserialize(using = PokemonListDefaultDeserializer.class)
public class PokemonListDefault extends PokemonListAbstract {

	PokemonListDefault(ArrayList<ListItemInterface> pokeList, int size){
		setPokemonList(pokeList);
		setSize(size);
	}
	
	PokemonListDefault(){
	}
	
}
