import java.io.Serializable;

public class ElectricalTaxi extends Taxi implements Serializable {
	
	private int  batteryCount;

	public ElectricalTaxi(String licensePlate, String driversName, int batteryCount) {
		super(licensePlate, driversName);
		this.batteryCount = batteryCount;
	}
	
	public double calculateAutonomy() {
		return 70 * batteryCount;
	}

}
