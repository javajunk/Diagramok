import java.util.Hashtable;


public class PlayerInitParams {
	
	private Hashtable<Control,Integer> controlKeys;
	private String imageSrc;
	private Vector2D initPosition;
	private String playerName;
	
	public PlayerInitParams(String name, Hashtable<Control,Integer> cKeys,String imgSrc,Vector2D initPos)
	{
		controlKeys = cKeys;
		imageSrc = imgSrc;
		initPosition = initPos;
		playerName = name;
	}
	
	public Hashtable<Control,Integer> getControlKeys()
	{
		return controlKeys;
	}
	
	public String getImageSrc() 
	{
		return imageSrc;
	}
	
	public String getName() 
	{
		return playerName;
	}
	
	public Vector2D getInitPosition() 
	{
		return initPosition;
	}
}
