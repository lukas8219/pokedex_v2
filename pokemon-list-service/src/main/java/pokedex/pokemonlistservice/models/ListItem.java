package pokedex.pokemonlistservice.models;

import interfaces.ListItemInterface;

public class ListItem implements ListItemInterface {

	private String name;
	private String url;
	
	public ListItem(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

}
