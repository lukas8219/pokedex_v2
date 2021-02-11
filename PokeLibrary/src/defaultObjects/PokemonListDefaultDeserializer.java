package defaultObjects;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import interfaces.ListItemInterface;

public class PokemonListDefaultDeserializer extends StdDeserializer<PokemonListDefault>{

	public PokemonListDefaultDeserializer() {
		this(null);
	}
	
	protected PokemonListDefaultDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PokemonListDefault deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {

		JsonNode root = parser.getCodec().readTree(parser);
		int size = (Integer) root.get("size").numberValue();
		ArrayList<ListItemInterface> itemList = new ArrayList<>();
		
		JsonNode listNode = root.get("pokemonList");
		
		for(int i=0; i<listNode.size(); i++) {
			JsonNode currNode = listNode.get(i);
			itemList.add(new ListItemDefault(currNode.get("name").asText(), currNode.get("url").asText()));
		}
		
		
		return new PokemonListDefault(itemList, size);
	}

}
