package pokedex.evolutionchainservice.models;

import java.io.IOException;
import java.util.ArrayList;
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
		ArrayList<String> evolutions = getEvolutions(root);
		
		
		return new EvolutionChain(id, evolutions);
	}

	
	private ArrayList<String> getEvolutions(JsonNode root){
		
		ArrayList<String> temporaryList = new ArrayList<>();
		JsonNode chain = root.get("chain");
		String currentSpecie = IDParser.parseSpecie(chain.get("species").get("url").asText());
		temporaryList.add(currentSpecie);
		JsonNode nextChain = chain.get("evolves_to");
		
		while(nextChain != null && nextChain.size() > 0) {
			for(int i=0; i<nextChain.size(); i++) {
				currentSpecie = IDParser.parseSpecie(nextChain.get(i).get("species").get("url").asText());
				temporaryList.add(currentSpecie);
			}
			nextChain = nextChain.get(0).get("evolves_to");
		}
		
		return temporaryList;
	}
}
