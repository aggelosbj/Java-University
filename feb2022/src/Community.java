import java.io.Serializable;

public class Community implements Serializable {
    
	
	protected String name;
    protected int population;

    public Community( String name, int population) {
        this.name = name;
        this.population = population;
    }

    
    //ipologizoume tin epidotisi poy lambanei i koinotita
    public double calculateFunding() {
        return 50 * population;
    }

   
}
