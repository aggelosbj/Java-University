public class SharedRoom extends Property
{
	
    private int square_meters;
    
    
    public SharedRoom(String identifier, int guests_number, int square_meters)
    {
    	super(identifier, guests_number);
    	this.square_meters=square_meters;
    }
    
    public double calculateTaxRate(int population)
    {
    	
        double tax_percentage;
    	
    	if(square_meters > 15)
    	{
    		tax_percentage=0.11;
    	}
    	else
    	{
    		tax_percentage=0.09;
		}
    	
    	if(guests_number > 4)
    	{
    		tax_percentage+=0.01;
    	}
    	return tax_percentage;
    }

	public int getSquare_meters() {
		return square_meters;
	}
    
    
    
}