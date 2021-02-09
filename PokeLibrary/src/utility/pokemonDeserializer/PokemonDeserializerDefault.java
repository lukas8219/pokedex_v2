package utility.pokemonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import standardObject.defaultPokemon;
import standardObject.defaultPokemonInterface;


/**
 * 
 * @author Lucas
 *
 * Default class that interacts directly with external API. PokeApi
 *
 */

public class PokemonDeserializerDefault extends PokemonDeserializerAbstract{

	public PokemonDeserializerDefault() {
		this(null);
	}
	
	protected PokemonDeserializerDefault(Class<?> vc) {
		super(vc);
	}

	@Override
	protected ArrayList<String> getTypes(JsonNode typeNode){
		
		ArrayList<String> types = new ArrayList<>();
		
		for(int i=0; i<typeNode.size(); i++) {
			types.add(typeNode.get(i).get("type").get("name").asText());
		}
		
		return types;
	}
	
	@Override
	protected ArrayList<String> getAbilities(JsonNode abilitiesNode){
		
		ArrayList<String> abilities = new ArrayList<>();
		
		for(int i=0; i<abilitiesNode.size(); i++) {
			abilities.add(abilitiesNode.get(i).get("ability").get("name").asText());
		}
		
		return abilities;
	}
	
	@Override
	protected HashMap<String, Integer> getBaseStatus(JsonNode statsNode){
		
		HashMap<String, Integer> base_status = new HashMap<>();
		String[] statusNotation = {"HP","Attack","Defense","Special Attack","Special Defense","Speed"};
		
		for(int i=0; i<6; i++) {
			int status = (Integer) statsNode.get(i).get("base_stat").numberValue();
			base_status.put(statusNotation[i], status);
		}
		
		return base_status;
	}

	@Override
	protected String getIconURL(JsonNode root) {
		return root.get("sprites").get("front_default").asText();
	}
}
