import java.util.Hashtable;

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
	public Hashtable<String,String> dump();
}
