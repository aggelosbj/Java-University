import java.io.Serializable;

public class Property implements Serializable
{
	//dilosi ton idiotion tis property
    protected String identifier;
    protected int guests_number;
    
    //dimioyrgia kataskevasti
    public Property(String identifier, int guests_number)
    {
    	
    	this.identifier=identifier;
    	this.guests_number=guests_number;
    }
    
    //int population dioti milame gia ton pithismo 
    //dimiourgoume mia methodo calculateTaxRate
    //dilonoume se double to pososto forou
    //kai ipoligizoume an >10000 kai an mikrotero
    //sto telos ipolgizoume kai ta atoma poy filoksenoume
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
    
    //dimiourgoume mia get giati to theloyme sto Cyti file
    public String getIdentifier()
    {
    	return identifier;
    }
    
}