import java.util.ArrayList;

public class MunicipalCommunity extends Community {
    private double area;  // in square kilometers
    private double recyclingTonnage;  // in tons
    private ArrayList<RecyclingCenter> recyclingCenters = new ArrayList<>();

    public MunicipalCommunity( String name, int population, double area) {
        super( name, population);
        this.area = area;
        
    }

    // Additional method to set the recycling tonnage
    public void setRecyclingTonnage(double recyclingTonnage) {
        this.recyclingTonnage = recyclingTonnage;
    }
    
    
    //ipoligizoume gia kathe pliros tetragoniko xiliometro 
    //kai ipoligizoume gia kathe pliri anakiklosimo tono
    @Override
    public double calculateFunding() {
        double baseFunding = 10000 * area;
        double recyclingFunding = 1000 * recyclingTonnage;

        return baseFunding + recyclingFunding;
    }
    
    //prostheto ena kedro anakiklosis 
    public void add(RecyclingCenter recyclingCenter) {
    	recyclingCenters.add(recyclingCenter);
    }
}
