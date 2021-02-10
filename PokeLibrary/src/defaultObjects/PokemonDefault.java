package defaultObjects;

import java.util.ArrayList;
import java.util.HashMap;

import defaultAbstract.PokemonAbstract;
import interfaces.PokemonInterface;

public class PokemonDefault extends PokemonAbstract {
	
	public PokemonDefault() {
		
	}
	
	public PokemonDefault(String name,
			String id,
			String iconURL,
			ArrayList<String> types,
			ArrayList<String> abilities,
			ArrayList<PokemonInterface> evolutions,
			HashMap<String, Integer> baseStatus,
			int height,
			int weight) {
		
		setName(name);
		setId(id);
		setIconURL(iconURL);
		setTypes(types);
		setAbilities(abilities);
		setEvolutions(evolutions);
		setBaseStatus(baseStatus);
		setHeight(height);
		setWeight(weight);
		
	}
	
}
