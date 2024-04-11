import java.awt.Panel;
import java.util.ArrayList;

public class GreenSubscriber extends Subscriber{
	
	
	private String city;
	private ArrayList<SolarPanel> solarPanels;
	
	
	public GreenSubscriber(String lastName, double lostPower, String city) {
		super(lastName, lostPower);
		this.city = city;
		this.solarPanels = new ArrayList<SolarPanel>();// otan thelo arraylist na to bazo ston kataskevasti me afton ton tropo 
	}
	
	public void addPanel(SolarPanel solarPanel) {
		solarPanels.add(solarPanel);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<SolarPanel> getSolarPanels() {
		return solarPanels;
	}

	public void setSolarPanels(ArrayList<SolarPanel> solarPanels) {
		this.solarPanels = solarPanels;
	}

	public void addSolarPanel(String brand, double avg) {
		SolarPanel panel = new SolarPanel(brand,avg);
		this.solarPanels.add(panel);
		
	}
	
	//edo idia methodos alla e
	public double calculateNetEnergy() {
		
		double sum =0;
		
		for(SolarPanel solarPanel: solarPanels)
			sum += solarPanel.getPlusPower();//προστίθεται η
		//ενέργεια που παράγεται από κάθε ηλιακό πάνελ.
		
		return lostPower - sum; //afairo tin mesi katanalosi 
		
	}
	
	
	
	

}
