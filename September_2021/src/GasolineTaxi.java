import java.io.Serializable;

public class GasolineTaxi extends Taxi implements Serializable{
	
	private int fuelSize;
	private double averrageFuel;
	
	
	public GasolineTaxi(String licensePlate, String driversName, int fuelSize, double averrageFuel) {
		super(licensePlate, driversName);
		this.fuelSize = fuelSize;
		this.averrageFuel = averrageFuel;
	}
	
	public double  calculateAutonomy() {
		return 90 * (fuelSize / averrageFuel);
	}

}
