package utility.evolutionChainDeserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import standardObject.EvolutionChain;


/**
 * 
 * @author Lucas Weis Polesello
 * 
 * Has to be a superclass
 * Has to be overriden with the Eureka Server Communication
 */
public abstract class EvolutionChainDeserializerAbstract extends StdDeserializer<EvolutionChain>{

	protected EvolutionChainDeserializerAbstract(Class<?> vc) {
		super(vc);
	}
	
	public EvolutionChainDeserializerAbstract() {
		this(null);
	}
	
	/**
	 * Need to be Overwritten in the Application.
	 */
	@Override
	public abstract EvolutionChain deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException;

}
