package poke_unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import standardObject.defaultPokemon;

class PokemonTest {
	
	@Test
	void BulbasaurTest() throws JsonParseException, JsonMappingException, IOException {
	
		File f = new File("test/bulbasaur.json");
		ObjectMapper mp = new ObjectMapper();
		
		defaultPokemon pokemon = mp.readValue(f, defaultPokemon.class);
		
		assertAll("Should complete everything",
				() -> assertEquals("bulbasaur", pokemon.getName()),
				() -> assertEquals("1", pokemon.getId()),
				() -> assertEquals(7, pokemon.getHeight()),
				() -> assertEquals(69, pokemon.getWeight()),
				() -> assertTrue(pokemon.getIcon_url().contains("pokemon/1.png")),
				() -> assertTrue(pokemon.getTypes().containsAll(Arrays.asList("grass","poison"))),
				() -> assertTrue(pokemon.getAbilities().containsAll(Arrays.asList("overgrow", "chlorophyll")))
		);
		
		assertAll("Status error",
				() -> assertEquals(45, pokemon.getBase_status().get("HP")),
				() -> assertEquals(49, pokemon.getBase_status().get("Attack")),
				() -> assertEquals(49, pokemon.getBase_status().get("Defense")),
				() -> assertEquals(65, pokemon.getBase_status().get("Special Attack")),
				() -> assertEquals(65, pokemon.getBase_status().get("Special Defense")),
				() -> assertEquals(45, pokemon.getBase_status().get("Speed"))
		);
	}
	
	@Test
	void SandshrewTest() throws JsonParseException, JsonMappingException, IOException {
		
		File f = new File("test/sandshrew.json");
		ObjectMapper mp = new ObjectMapper();
		
		defaultPokemon pokemon = mp.readValue(f, defaultPokemon.class);
		
		assertAll("Should complete everything",
				() -> assertEquals("sandshrew", pokemon.getName()),
				() -> assertEquals("27", pokemon.getId()),
				() -> assertEquals(6, pokemon.getHeight()),
				() -> assertEquals(120, pokemon.getWeight()),
				() -> assertTrue(pokemon.getIcon_url().contains("pokemon/27.png")),
				() -> assertTrue(pokemon.getTypes().containsAll(Arrays.asList("ground"))),
				() -> assertTrue(pokemon.getAbilities().containsAll(Arrays.asList("sand-veil", "sand-rush")))
		);
		
		assertAll("Status error",
				() -> assertEquals(50, pokemon.getBase_status().get("HP")),
				() -> assertEquals(75, pokemon.getBase_status().get("Attack")),
				() -> assertEquals(85, pokemon.getBase_status().get("Defense")),
				() -> assertEquals(20, pokemon.getBase_status().get("Special Attack")),
				() -> assertEquals(30, pokemon.getBase_status().get("Special Defense")),
				() -> assertEquals(40, pokemon.getBase_status().get("Speed"))
		);
	}
	
	@Test
	void EeveeTest() throws JsonParseException, JsonMappingException, IOException {
		
		File f = new File("test/eevee.json");
		ObjectMapper mp = new ObjectMapper();
		
		defaultPokemon pokemon = mp.readValue(f, defaultPokemon.class);
		
		assertAll("Should complete everything",
				() -> assertEquals("eevee", pokemon.getName()),
				() -> assertEquals("133", pokemon.getId()),
				() -> assertEquals(3, pokemon.getHeight()),
				() -> assertEquals(65, pokemon.getWeight()),
				() -> assertTrue(pokemon.getIcon_url().contains("pokemon/133.png")),
				() -> assertTrue(pokemon.getTypes().containsAll(Arrays.asList("normal"))),
				() -> assertTrue(pokemon.getAbilities().containsAll(Arrays.asList("run-away",
						"adaptability",
						"anticipation")))
		);
		
		assertAll("Status error",
				() -> assertEquals(55, pokemon.getBase_status().get("HP")),
				() -> assertEquals(55, pokemon.getBase_status().get("Attack")),
				() -> assertEquals(50, pokemon.getBase_status().get("Defense")),
				() -> assertEquals(45, pokemon.getBase_status().get("Special Attack")),
				() -> assertEquals(65, pokemon.getBase_status().get("Special Defense")),
				() -> assertEquals(55, pokemon.getBase_status().get("Speed"))
		);
	}
	
}
