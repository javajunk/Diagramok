


public class Vector2D {
	private double angle;
	private double x;
	private double y;



	/**
	 * 
	 * @param vec
	 */
	public void Add(Vector2D vec){
		SkeletonHelper.writeOutMethodName("[:Vector2D] Add (vec)");
		SkeletonHelper.returnFromMethod();
	}

	public double Length(){
		SkeletonHelper.writeOutMethodName("[:Vector2D] Length ()");
		int l = SkeletonHelper.getIntegerAnswer("Mekkora a vektor?");
		SkeletonHelper.returnFromMethod();
		return l;
	}

	public void Normalize(){
		SkeletonHelper.writeOutMethodName("[:Vector2D] Normalize ()");
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * 
	 * @param s
	 */
	public void Scale(double s){
		SkeletonHelper.writeOutMethodName("[:Vector2D] Scale (s)");
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * 
	 * @param newVal
	 */
	public void Subtract(Vector2D vec){
		SkeletonHelper.writeOutMethodName("[:Vector2D] Substract (vec)");
		SkeletonHelper.returnFromMethod();
	}
}
