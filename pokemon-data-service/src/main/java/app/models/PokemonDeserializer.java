package app.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import interfaces.PokemonDeserializerInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class PokemonDeserializer extends StdDeserializer<Pokemon> implements PokemonDeserializerInterface{
	

	public PokemonDeserializer() {
		this(null);
	}
	
	protected PokemonDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Pokemon deserialize(JsonParser json, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		//TO-DO
		
		JsonNode root = json.getCodec().readTree(json);
		
		String name = root.get("name").asText();
		String id = root.get("id").asText();
		int height = (Integer) root.get("height").numberValue();
		int weight = (Integer) root.get("weight").numberValue();
		ArrayList<String> abilities = getAbilities(root.get("abilities"));
		ArrayList<String> types = getTypes(root.get("types"));
		String iconURL = getIconURL(root.get("sprites"));
		HashMap<String, Integer> baseStatus = getBaseStatus(root.get("stats"));
		
		
		return new Pokemon(name,id,iconURL,height,weight,types,abilities,baseStatus);
	}

	@Override
	public ArrayList<String> getAbilities(JsonNode abilitiesNode) {
		
		ArrayList<String> abilities = new ArrayList<>();
		
		for(int i=0; i<abilitiesNode.size(); i++) {
			String ability = abilitiesNode.get(i).get("ability").get("name").asText();
			abilities.add(ability);
		}
		
		return abilities;
	}

	@Override
	public HashMap<String, Integer> getBaseStatus(JsonNode statsNode) {

		String[] statusNotation = {"HP","Attack","Defense","SpecialAttack","SpecialDefense","Speed"};
		HashMap<String, Integer> base_status = new HashMap<>();
		
		for(int i=0; i<statsNode.size(); i++) {
			String statusName = statusNotation[i];
			int statusValue = (Integer) statsNode.get(i).get("base_stat").numberValue();
			base_status.put(statusName, statusValue);
		}
		
		return base_status;
	}

	@Override
	public String getIconURL(JsonNode spriteNode) {
		return spriteNode.get("front_default").asText();
	}

	@Override
	public ArrayList<String> getTypes(JsonNode typeNode) {
		
		ArrayList<String> types = new ArrayList<>();
		
		for(int i=0; i<typeNode.size(); i++) {
			String type = typeNode.get(i).get("type").get("name").asText();
			types.add(type);
		}
		
		return types;
	}


}
