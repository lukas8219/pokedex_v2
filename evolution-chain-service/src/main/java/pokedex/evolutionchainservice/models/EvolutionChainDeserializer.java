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

		JsonNode rootNode = parser.getCodec().readTree(parser);
		String id = rootNode.get("id").asText();
		ArrayList<String> evolutions = getEvolutions(rootNode.get("chain"));
		
		
		return new EvolutionChain(id, evolutions);
	}

	//Depth First Search
	private ArrayList<String> getEvolutions(JsonNode chainNode){

		Stack<JsonNode> stack = new Stack<>();
		ArrayList<String> evolutions = new ArrayList<>();

		evolutions.add(getID(chainNode));
		stack.push(chainNode.get("evolves_to"));

		while(! stack.isEmpty()){

			JsonNode evolutionNode = stack.pop();

			for(JsonNode chain : evolutionNode){
				String id = getID(chain);
				if(! evolutions.contains(id)){
					evolutions.add(id);
					stack.push(chain.get("evolves_to"));
				}
			}
		}

		return evolutions;
	}

	private String getID(JsonNode node){
		return IDParser.parseSpecie(node.get("species").get("url").asText());
	}
}
