

/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:07:59
 */
public class Glue extends Obstacle {

	private static String glueImage = /obstacles/glue.png;
	private static final double Radius = /*coming soon*/;
	private Vector2D m_Vector2D;

	public Glue(){

	}

	public String getglueImage(){
		return glueImage;
	}

	public double getRadius(){
		return Radius;
	}

	public Vector2D getVector2D(){
		return m_Vector2D;
	}


	/**
	 * 
	 * @param newVal
	 */
	public void setRadius(double newVal){
		Radius = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVector2D(Vector2D newVal){
		m_Vector2D = newVal;
	}

}