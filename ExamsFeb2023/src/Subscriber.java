
public class Subscriber {
	
	protected String lastName;
	protected double lostPower;
	
	
	public Subscriber(String lastName, double lostPower) {
		this.lastName = lastName;
		this.lostPower = lostPower;
	}
	
	
	//prostheto methodo gia ipologismo energeias
	//kai epistrefo tin mesi timi <lostpower>
	public double calculateNetEnergy() {
		return this.lostPower;
	}
	
	
}
