
import java.io.Serializable;
import java.util.ArrayList;

public class Fleet implements Serializable {
	
	private String CityName;
	private ArrayList<Taxi> taxis;
	
	public Fleet(String cityName) {
		CityName = cityName;
		taxis = new ArrayList<>();
	}

	
	
	public void storeTaxi(Taxi taxi) {
		taxis.add(taxi);
		
	}


	public String getCityName() {
		return CityName;
	}


	public void setCityName(String cityName) {
		CityName = cityName;
	}


	public ArrayList<Taxi> getTaxis() {
		return taxis;
	}


	public void setTaxis(ArrayList<Taxi> taxis) {
		this.taxis = taxis;
	}
	
	
	public double calculateTotalAutonomy() {
		double sum = 0;
		for(Taxi t: taxis)
			sum += t.calculateAutonomy();
		
		return sum;
	}
	
	

	
	
	

}
