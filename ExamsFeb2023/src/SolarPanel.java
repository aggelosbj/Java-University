
public class SolarPanel {

	private String markName;
	private double avgPower;
	
	
	public SolarPanel(String markName, double plusPower) {
		this.markName = markName;
		this.avgPower = plusPower;
	}


	public String getMarkName() {
		return markName;
	}


	public void setMarkName(String markName) {
		this.markName = markName;
	}


	public double getPlusPower() {
		return avgPower;
	}


	public void setPlusPower(double plusPower) {
		this.avgPower = plusPower;
	}
	
	
	
	
}
