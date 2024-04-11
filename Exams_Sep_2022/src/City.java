import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable
{
	//dilosi ton xaraktiristikon tis polis 
    protected String city_name;
    protected int population;
    ArrayList<Property> properties = new ArrayList<>();
    
    //dimioyrgia kataskevasti
    public City(String city_name, int population)
    {
        this.city_name=city_name;
        this.population=population;
    }
    
    //dimiourgoume mia methodo printProperties
    //to kanoume etsi gt leei na ektiponi se ena arxeio keimonou
    //garfoume tin poli poy tha emfanisti 
    //meta diatrexoume me for ta properites 
    //oste na grapsoume kai property
    //kai meta gia to taxrate grafoume taxRate se parametro(Population)
    //apo kato kanoume gia ta shared Room 
	public void printProperties(String fileName)
    {
		File file = new File(fileName);
		try
		{
			FileWriter writer = new FileWriter(file);
			
			writer.write("City: "+city_name+"\n");
			for (Property property : properties)
			{
				writer.write( "Property: "+property.identifier+", Tax Rate: "+property.calculateTaxRate(population)+"\n");
				if(property instanceof SharedRoom) {
					SharedRoom sharedRoom = (SharedRoom) property;
					System.out.println("/n");
					writer.write(city_name +"SharedRoom: " + property.identifier + "Tax Rate: " + sharedRoom.calculateTaxRate(population)+ "\n");
				}
			}
			
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
	public String getCityName()
	{
		return city_name;
	}
	
}