package standardObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface defaultPokemonInterface {
	
	public String getName();

	public void setName(String name);

	public String getId();

	public void setId(String id);

	public HashMap<String, Integer> getBase_status();

	public void setBase_status(HashMap<String, Integer> base_status);

	public ArrayList<String> getTypes();

	public void setTypes(ArrayList<String> types);

	public List<defaultPokemonInterface> getEvolutions();

	public void setEvolutions(List<defaultPokemonInterface> evolutions);

	public String getIcon_url();

	public void setIcon_url(String icon_url);

	public int getWeight();

	public void setWeight(int weight);
	
	public void insertEvolution(defaultPokemonInterface p);

	public int getHeight();

	public void setHeight(int height);

	public ArrayList<String> getAbilities();

	public void setAbilities(ArrayList<String> abilities);
	
}
