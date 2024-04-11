
public class All_Inclusive extends Reservation{
	
	private int meals;

	public All_Inclusive(int days, int meals) {
		super(days);
		this.meals = meals;
	}
	
	public int calculateCost() {
		return days * (120 + meals * 30);
	}
	

}
