
public class Subscriber {
	
	protected String lastName;
	protected double lostPower;
	
	
	public Subscriber(String lastName, double lostPower) {
		this.lastName = lastName;
		this.lostPower = lostPower;
	}
	
	
	
	public double calculateNetEnergy() {
		return this.lostPower;
	}
	
	
}
