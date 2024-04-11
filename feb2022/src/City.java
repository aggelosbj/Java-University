import java.io.Serializable;
import java.util.ArrayList;

public class City  implements Serializable{
    private String place;
    private ArrayList<Community> communities = new ArrayList<>();  // Store the communities within the city

    public City(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void add(Community community) {
        communities.add(community);
    }

    
    //diatrexoume tin lista communities 
    //Στο εσωτερικό της βρόχου, καλείται η μέθοδος calculateFunding()
    // για την τρέχουσα κοινότητα (community
    //Αυτό υπολογίζει τη χρηματοδοτική ποσότητα για αυτήν την κοινότητα.
    //to epistrefoume  se mia metabliti totalFunding
    
    public double calculateFunding() {
        double totalFunding = 0;
        for (Community community : communities) {
            totalFunding += community.calculateFunding();
        }
        return totalFunding;
    }


    
   
}
