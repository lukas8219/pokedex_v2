package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * 
 * @author Lucas
 *
 *Couple of interfaces to navigate through the Json
 *
 */
public interface PokemonDeserializerInterface {

	/**
	 * Navigate through the JsonNodes specifically the way you want to.
	 * @return
	 */
	public ArrayList<String> getTypes(JsonNode typesNode);
	
	/**
	 * Navigate through the JsonNodes specifically the way you want to.
	 * @return
	 */
	public ArrayList<String> getAbilities(JsonNode abilitiesNode);
	
	/**
	 * Navigate through the JsonNodes specifically the way you want to.
	 * @return
	 */
	public HashMap<String, Integer> getBaseStatus(JsonNode statsNode);
	
	/**
	 * Navigate through the JsonNodes specifically the way you want to.
	 * @return
	 */
	public String getIconURL(JsonNode spriteNode);
	
}
