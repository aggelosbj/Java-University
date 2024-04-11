import java.io.Serializable;
import java.util.ArrayList;


//gia na apokithefti se ena arxeio prepei na tin lano Serializable
//px ta hotel ta apothikevo sta hotels.ser
//gia na taksinomiso ta onomata bazo enan sigriti comparable
//kai kano compate to 
public class Hotel implements Serializable, Comparable {
	
	private String name;
	//sisxetisi ksenodoxeio me kratisis
	private ArrayList<Reservation>  reservations= new ArrayList<>();

	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	//kodikas gia na sigrithoun ta ksenodoxeia
	@Override
	public int compareTo(Object o) {
		Hotel otherHotel = (Hotel)o;
		return this.name.compareTo(otherHotel.name);
	}
	
	//prostheto mia methodo gia na bazo kratisis 
	public void addReservation(Reservation r) {
		reservations.add(r);
	}
	
	//mia methodo na ipologizi to kostos to sinoliko
	//diatrexo tin kratisis kai pairno xreosis
	public int calculateTotalCost(){
		int sum = 0;
		for(Reservation reserve: reservations)
			sum += reserve.calculateCost();//polimorfiki klisi
		return sum;
	}

	
}
