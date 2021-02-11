package defaultObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import interfaces.PokemonDeserializerInterface;

public class DefaultPokemonDeserializer extends StdDeserializer<PokemonDefault> implements PokemonDeserializerInterface  {

	public DefaultPokemonDeserializer() {
		this(null);
	}
	
	protected DefaultPokemonDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> getTypes(JsonNode typesNode) {
		ArrayList<String> types = new ArrayList<>();
		
		for(int i=0; i<typesNode.size(); i++) {
			types.add(typesNode.get(i).asText());
		}
		
		return types;
	}

	@Override
	public ArrayList<String> getAbilities(JsonNode abilitiesNode) {
		ArrayList<String> abilities = new ArrayList<>();
		
		for(int i=0; i<abilitiesNode.size(); i++) {
			abilities.add(abilitiesNode.get(i).asText());
		}
		
		return abilities;
	}

	@Override
	public HashMap<String, Integer> getBaseStatus(JsonNode statsNode) {

		HashMap<String, Integer> currentStatus = new HashMap<>();
		String[] statusNotation = {"Speed", "Special Attack","HP", "Special Defense","Attack", "Defense"};
		
		for(int i=0; i<statsNode.size(); i++) {
			currentStatus.put(statusNotation[i], (Integer) statsNode.get(statusNotation[i]).numberValue());
		}
		
		return currentStatus;
	}

	@Override
	public String getIconURL(JsonNode spriteNode) {
		return spriteNode.get("iconURL").asText();
	}

	public EvolutionChainDefault getEvolutions(JsonNode rootNode) {
		
		String id;
		ArrayList<String> evolutions = new ArrayList<>();
		
		JsonNode currentNode = rootNode.get("evolutions");
		
		if(currentNode.size() == 0) {
			return null;
		} else {
			
			id = currentNode.get("id").asText();
			
			currentNode = currentNode.get("evolutions");
			
			for(int i=0; i<currentNode.size(); i++) {
				evolutions.add(currentNode.get(i).asText());
			}
			return new EvolutionChainDefault(id, evolutions);
		}
		
	}
	
	@Override
	public PokemonDefault deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {

		JsonNode root = parser.getCodec().readTree(parser);
		
		ArrayList<String> types = getTypes(root.get("types"));
		ArrayList<String> abilities = getAbilities(root.get("abilities"));
		HashMap<String, Integer> base_status = getBaseStatus(root.get("baseStatus"));
		String iconURL = getIconURL(root);
		
		String name = root.get("name").asText();
		String id = root.get("id").asText();
		int height = (Integer) root.get("height").numberValue();
		int weight = (Integer) root.get("weight").numberValue();
		EvolutionChainDefault evolutions = getEvolutions(root);
		
		return new PokemonDefault(name, id, iconURL, types, abilities, evolutions, base_status, height, weight);
	}

}
