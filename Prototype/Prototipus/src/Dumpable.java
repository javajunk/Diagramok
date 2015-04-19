import java.util.LinkedHashMap;

public interface Dumpable {
	/**
	 * 
	 * @return Az objektum egyedi azonosítója
	 */
	public int getProtoId();
	
	/**
	 * 
	 * @return Kulcs - adattag, Érték - adattag értéke
	 */
	public LinkedHashMap<String,String> dump();
}
