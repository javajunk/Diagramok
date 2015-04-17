/**
 * Az osztály egy egyszerű 2 dimenziós vektort implementál.
 */
public class Vector2D {

	private double x;
	private double y;
	
	public Vector2D ()
	{
		this.x = 1;
		this.y = 0;
	}
	
 	public Vector2D (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Módosítja a vektor koordinátáit a paraméterként kapott értékekre.
	 * @param x - Az új X koordináta érték.
	 * @param y - Az új Y koordináta érték.
	 */
	public void setCoords (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Visszaadja a vektor koordinátáit egy kettő elemű tömbben.
	 * @return A vektor koordinátái egy tömbben, {x, y} sorrendben.
	 */
	public double[] getCoords ()
	{
		return new double[] {x, y};
	}

	/**
	 * Visszaadja a vektor X koordinátáját.
	 * @return Az X koordináta értéke.
	 */
	public double getX ()
	{
		return x;
	}
	
	/**
	 * Módosítja a vektor X koordinátáját a paraméterként kapott értékre.
	 * @param value - Az új X koordináta érték.
	 */
	public void setX (double value)
	{
		x = value;
	}
	
	/**
	 * Visszaadja a vektor Y koordinátáját.
	 * @return Az Y koordináta értéke.
	 */
	public double getY ()
	{
		return y;
	}
	
	/**
	 * Módosítja a vektor Y koordinátáját a paraméterként kapott értékre.
	 * @param value - Az új Y koordináta érték.
	 */
	public void setY (double value)
	{
		y = value;
	}
	
	/**
	 * Visszadja a vektor és x tengely által bezárt szöget, 0 és 2 * PI közötti értékkel.
	 * @return A bezárt szog.
	 */
	public double getAngle ()
	{
		double a = Math.atan2(y, x);
		if (a < 0)
			return Math.PI * 2 + a;
		return a;
	}
	
	/**
	 * Módosítja a vektor x tengellyel bezárt szögét.
	 * @param degrees - Az új szög, fokban.
	 */
	public void setDegreeAngle (double degrees)
	{
		double r = Length();
		x = r * Math.cos(Math.toRadians(degrees));
		y = r * Math.sin(Math.toRadians(degrees));
	}
	
	/**
	 * Módosítja a vektor x tengellyel bezárt szögét.
	 * @param degrees - Az új szög, radiánban.
	 */
	public void setRadianAngle (double radians)
	{
		double r = Length();
		x = r * Math.cos(radians);
		y = r * Math.sin(radians);
	}
		
	/**
	 * Visszaadja a vektor jelenlegi hosszát.
	 * @return A vektor hossza.
	 */
	public double Length(){
		return Math.sqrt((x * x) + (y * y));
	}

	/**
	 * Vektorösszeadás.
	 * @param vec - A hozzáadandó vektor.
	 */
	public void Add(Vector2D vec){
		x = x + vec.getX();
		y = y + vec.getY();
	}

	/**
	 * Normalizálja a vektort.
	 */
	public void Normalize(){
		if (Length() == 0)
			return;
		x = x / Length();
		y = y / Length();
	}

	/**
	 * Skalárszorzás. A paraméterként kapott skalárral megszorozza a vektort.
	 * @param s - a skalár
	 */
	public void Scale(double s){
		x = x * s;
		y = y * s;
	}

	/**
	 * Vektorkivonás.
	 * @param vec - A kivonandó vektor.
	 */
	public void Subtract(Vector2D vec){
		x = x - vec.getX();
		y = y - vec.getY();
	}
	
	/**
	 * Kiszámolja két pont távolságát
	 * @param v1 - a pont, aminek a távolságára kíváncsiak vagyunk
	 * @return - a két pont távolsága
	 */
	public double Distance(Vector2D v1)
	{
		return Math.sqrt((v1.x-this.x)*(v1.x-this.x)+(v1.y-this.y)*(v1.y-this.y));
	}
	
	/**
	 * Ha két kisrobot ütközik egymással, lepattannak egymásról és irányt váltanak.
	 * Az eredeti irányvektorukat -90 fokkal (= 270 fokkal) módosítjuk. 
	 * @return az új irány
	 */
	public Vector2D Rotate270 ()
	{
		Vector2D newspeed = null;
		newspeed.setX(this.y);
		newspeed.setY(this.x*-1);
		return newspeed;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
