import java.util.Hashtable;


public class PlayerInitParams {
	
	private Hashtable<Control,Integer> controlKeys;
	private String imageSrc;
	private Vector2D initPosition;
	
	public PlayerInitParams(Hashtable<Control,Integer> cKeys,String imgSrc,Vector2D initPos)
	{
		controlKeys = cKeys;
		imageSrc = imgSrc;
		initPosition = initPos;
	}
	
	public Hashtable<Control,Integer> getControlKeys()
	{
		return controlKeys;
	}
	
	public String getImageSrc() 
	{
		return imageSrc;
	}
	
	public Vector2D getInitPosition() 
	{
		return initPosition;
	}
}
