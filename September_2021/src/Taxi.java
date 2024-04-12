import java.io.Serializable;

public abstract class Taxi implements Serializable {
	
	protected String licensePlate;
	protected String driversName;
	
	
	public Taxi(String licensePlate, String driversName) {
		this.licensePlate = licensePlate;
		this.driversName = driversName;
	}


	public String getLicensePlate() {
		return licensePlate;
	}


	public String getDriversName() {
		return driversName;
	}
	
	public abstract double calculateAutonomy();
		
	


	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}


	public void setDriversName(String driversName) {
		this.driversName = driversName;
	}
	
	

}
