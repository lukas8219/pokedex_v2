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
 * Abstract class that standardize the Serialization.
 *
 */

public abstract class PokemonDeserializerAbstract extends StdDeserializer<defaultPokemonInterface>{

		public PokemonDeserializerAbstract() {
			this(null);
		}
		
		protected PokemonDeserializerAbstract(Class<?> vc) {
			super(vc);
		}

		@Override
		public defaultPokemonInterface deserialize(JsonParser parser, DeserializationContext arg1)
				throws IOException, JsonProcessingException {
			
			JsonNode root = parser.getCodec().readTree(parser);
			
			String name = root.get("name").asText();
			String id = root.get("id").asText();
			int weight = (Integer) root.get("weight").numberValue();
			int height = (Integer) root.get("height").numberValue();
			String iconURL = getIconURL(root);
			ArrayList<String> types = getTypes(root.get("types"));
			ArrayList<String> abilities = getAbilities(root.get("abilities"));
			HashMap<String, Integer> base_status = getBaseStatus(root.get("stats"));
			
			
			return new defaultPokemon(name,id,base_status,types, iconURL, weight, height, abilities);
		}

		protected abstract ArrayList<String> getTypes(JsonNode typeNode);
		
		protected abstract ArrayList<String> getAbilities(JsonNode abilitiesNode);
		
		protected abstract HashMap<String, Integer> getBaseStatus(JsonNode statsNode);
		
		protected abstract String getIconURL(JsonNode root);
}
