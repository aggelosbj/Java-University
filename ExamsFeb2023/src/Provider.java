import java.util.ArrayList;
import java.util.HashMap;

public class Provider {
    
    private String companyName;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    
    public Provider(String companyName) {
        this.companyName = companyName;
    }
    
    public void addSubscriber(Subscriber aSubscriber) {
        subscribers.add(aSubscriber);
    }

	public ArrayList<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void getSubscribers(ArrayList<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setSubscribers(ArrayList<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}
	
	// kano mia methodo getPanelBrnad gia ta stoixeia toy pinaka oste 
	//na ta xrisimopoiso stin main  kai apo kato mia alli 
	//methodo getPanelAvverage gia tin mesi katanalosi
	public String getPanelBrand() {
		if(this.companyName.equals("New Energy")) {
			return "SunPower";
		}else if(this.companyName.equals("Power Tech")) {
			return "Panasonic";
		}else
			return  "RECSolar";
	}
	
	public double getPanelAvverage() {
		if(this.companyName.equals("New Energy")) {
			return 480;
		}else if(this.companyName.equals("Power Tech")) {
			return 550;
		}else
			return  490;
	}
    // eos edo gia ta parapano kai pao stin main 
	
	//upolizo tin sinoliki etisia kai kalo to sub.calc... afou 
	//exoyme tin idia methodo stis alles klaseis 
	public double calculateTotalNetEnergy() {
		double sum = 0;
		
		for(Subscriber sub: subscribers)
			sum += sub.calculateNetEnergy();
		
		return sum;
	}
	
	
	public double calculateProfit(HashMap<String,String> KWPrices) {
		return calculateTotalNetEnergy() * Double.valueOf(KWPrices.get(this.companyName));
	}
	//Η μέθοδος παίρνει ένα HashMap με τις τιμές της ενέργειας ανά kW (KWPrices). 
	//Το HashMap περιλαμβάνει ζευγάρια "κλειδιού-τιμής", 
	//όπου το κλειδί είναι το όνομα της εταιρείας που είναι αποθηκευμένο στη μεταβλητή this.companyName
    //Η μέθοδος καλεί τη μέθοδο calculateTotalNetEnergy()
	//Αυτή η τιμή πολλαπλασιάζεται με την τιμή της ενέργειας ανά kW για τη συγκεκριμένη εταιρεία
	//απο το hashmap
}


	

	
	
	
	


