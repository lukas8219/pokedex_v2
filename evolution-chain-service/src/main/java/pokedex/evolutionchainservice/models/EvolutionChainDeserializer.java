package pokedex.evolutionchainservice.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import defaultObjects.PokemonDefault;
import interfaces.PokemonInterface;
import parsers.IDParser;

public class EvolutionChainDeserializer extends StdDeserializer<EvolutionChain> {

	public EvolutionChainDeserializer() {
		this(null);
	}
	
	protected EvolutionChainDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public EvolutionChain deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		JsonNode root = parser.getCodec().readTree(parser);
		String id = root.get("id").asText();
		ArrayList<String> evolutions = getEvolutions(root.get("chain"));
		
		
		return new EvolutionChain(id, evolutions);
	}

	//Realize Depth First Search
	private ArrayList<String> getEvolutions(JsonNode chainNode){

		Stack<JsonNode> stack = new Stack<>();
		ArrayList<String> output = new ArrayList<>();

		stack.push(chainNode.get("evolves_to"));
		output.add(getID(chainNode));

		while(! stack.isEmpty()){

			JsonNode currentNode = stack.pop();

			for(JsonNode node : currentNode){
				String id = getID(node);
				if(! output.contains(id)){
					output.add(id);
					stack.push(node.get("evolves_to"));
				}
			}
		}

		return output;
	}

	private String getID(JsonNode node){
		return IDParser.parseSpecie(node.get("species").get("url").asText());
	}
}
