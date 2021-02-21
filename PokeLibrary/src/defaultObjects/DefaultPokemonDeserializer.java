package defaultObjects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import interfaces.PokemonDeserializerInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DefaultPokemonDeserializer extends StdDeserializer<PokemonDefault> implements PokemonDeserializerInterface  {

	public DefaultPokemonDeserializer() {
		this(null);
	}
	
	protected DefaultPokemonDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public ArrayList<String> getTypes(JsonNode typesNode) {
		ArrayList<String> types = new ArrayList<>();

		for(JsonNode type : typesNode){
			types.add(type.asText());
		}
		
		return types;
	}

	@Override
	public ArrayList<String> getAbilities(JsonNode abilitiesNode) {
		ArrayList<String> abilities = new ArrayList<>();
		
		for(JsonNode ability : abilitiesNode){
			abilities.add(ability.asText());
		}
		
		return abilities;
	}

	@Override
	public HashMap<String, Integer> getBaseStatus(JsonNode statsNode) {

		HashMap<String, Integer> currentStatus = new HashMap<>();

		for (Iterator<String> Iterator = statsNode.fieldNames(); Iterator.hasNext(); ) {
			String status = Iterator.next();
			currentStatus.put(status, statsNode.get(status).asInt());
		}

		return currentStatus;
	}

	@Override
	public String getIconURL(JsonNode spriteNode) {
		return spriteNode.get("iconURL").asText();
	}


	//Only called in final product. Doesnt interact with default PokeApi JSON.
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
		int height = root.get("height").asInt();
		int weight = root.get("weight").asInt();
		EvolutionChainDefault evolutions = getEvolutions(root);
		
		return new PokemonDefault(name, id, iconURL, types, abilities, evolutions, base_status, height, weight);
	}

}
