

/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:14
 */
public class Oil extends Obstacle {

	private static final string oilImage = /obstacles/oil.png;
	private static final double Radius = /*coming soon*/;
	private Vector2D m_Vector2D;

	public Oil(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public string getoilImage(){
		return oilImage;
	}

	public double getRadius(){
		return Radius;
	}

	public Vector2D getVector2D(){
		return m_Vector2D;
	}

	public Vector2D getVector2D(){
		return m_Vector2D;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setoilImage(string newVal){
		oilImage = newVal;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setVector2D(Vector2D newVal){
		m_Vector2D = newVal;
	}

}