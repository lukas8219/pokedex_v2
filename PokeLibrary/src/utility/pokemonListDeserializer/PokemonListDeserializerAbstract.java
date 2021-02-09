package utility.pokemonListDeserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import standardObject.PokemonList;

/**
 * 
 * @author Lucas
 *
 *Has to be a superClass
 *Has to be overriden in Deserialize with the Eureka Server communication.
 */
public abstract class PokemonListDeserializerAbstract extends StdDeserializer<PokemonList>{

	public PokemonListDeserializerAbstract() {
		this(null);
	}
	
	protected PokemonListDeserializerAbstract(Class<?> vc) {
		super(vc);
	}

	@Override
	public abstract PokemonList deserialize(JsonParser parser, DeserializationContext arg1);

}
