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

// Class that interacts with PokeAPI.
public class PokemonDeserializer extends StdDeserializer<Pokemon> implements PokemonDeserializerInterface{

	private String[] STATUS_NAME = {"HP","Attack","Defense","SpecialAttack","SpecialDefense","Speed"};

	public PokemonDeserializer() {
		this(null);
	}
	
	protected PokemonDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Pokemon deserialize(JsonParser json, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode root = json.getCodec().readTree(json);
		
		String name = root.get("name").asText();
		String id = root.get("id").asText();
		int height = root.get("height").asInt();
		int weight = root.get("weight").asInt();
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

		HashMap<String, Integer> base_status = new HashMap<>();
		
		for(int i=0; i<statsNode.size(); i++) {
			String statusName = STATUS_NAME[i];
			int statusValue = statsNode.get(i).get("base_stat").asInt();

			base_status.put(statusName, statusValue);
		}
		
		return base_status;
	}

	@Override
	public String getIconURL(JsonNode spriteNode) {
		return spriteNode.get("front_default").asText();
	}

	@Override
	public ArrayList<String> getTypes(JsonNode typesNode) {
		
		ArrayList<String> types = new ArrayList<>();

		for(JsonNode typeNode : typesNode){
			String type = typeNode.get("type").get("name").asText();
			types.add(type);
		}

		return types;
	}


}
