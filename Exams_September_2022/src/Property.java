import java.io.Serializable;

public class Property implements Serializable
{
	
    protected String identifier;
    protected int guests_number;
    
   
    public Property(String identifier, int guests_number)
    {
    	
    	this.identifier=identifier;
    	this.guests_number=guests_number;
    }
    
    
    public double calculateTaxRate(int population)
    {
    	
    	double tax_percentage;
    	
    	if(population > 100000)
    	{
    		tax_percentage=0.12;
    	}
    	else
    	{
		    tax_percentage=0.1;
		}
    	
    	if(guests_number > 4)
    	{
    		tax_percentage+=0.01;
    	}
    	return tax_percentage;
    }
    
   
    public String getIdentifier()
    {
    	return identifier;
    }
    
}