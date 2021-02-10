package parsers;

public class IDParser {
	
	/*
	 * @param Pokemon full URL - with ID
	 * 
	 * @return the PokemonID
	 */
	public static String parsePokemon(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(34, sb.length()).toString();
	}
	
	/*
	 * @param Evolution Chain full API URL
	 * 
	 * @return the ID
	 */
	public static String parseEvolution(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(42, sb.length()-1).toString();
	}
	
	/*
	 * @param Species full API URL
	 * 
	 * @return the ID
	 */
	public static String parseSpecie(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(42, sb.length()-1).toString();
	}
	
}
