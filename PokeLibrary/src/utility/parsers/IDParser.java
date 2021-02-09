package utility.parsers;

public class IDParser {

	/*
	 * @param URL of Pokemon
	 * 
	 * returns the ID.
	 */
	public static String parsePokemon(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(34, sb.length()).toString();
	}
	
	/*
	 * @param URL of evolution chain
	 * 
	 * returns ID.
	 */
	public static String parseEvolution(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(42, sb.length()-1).toString();
	}
	
	/*
	 * @param URL of Species.
	 * 
	 * return the species ID.
	 */
	public static String parseSpecie(String url) {
		StringBuilder sb = new StringBuilder(url);
		return sb.substring(42, sb.length()-1).toString();
	}
	
}
