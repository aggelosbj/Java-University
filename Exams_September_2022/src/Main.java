import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
    {
		
		City city = new City("Kozani", 70000);
		City city2 = new City("Thessaloniki", 1000000);
		City city3 = new City("Athens", 3700000);
		
		ArrayList<City> cities = new ArrayList<>();
		cities.add(city);
		cities.add(city2);
		cities.add(city3);
		
    	Property property1 = new Property("Mary's House", 1);
    	Property property2 = new Property("John's House", 2);
    	SharedRoom sharedProperty = new SharedRoom("Mike's House", 3,30);
    	SharedRoom sharedProperty2 = new SharedRoom("Helens House", 4,40);
    	
    	city.properties.add(property1);
    	city.properties.add(property2);
    	city.properties.add(sharedProperty);
    	city.properties.add(sharedProperty2);
    	
    	city2.properties.add(property1);
    	
    	city3.properties.add(sharedProperty);
    	city3.properties.add(sharedProperty2);
    	
    	
    	File file = new File("Cities.ser");
    	
    	try {
			FileOutputStream outStream = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(cities);
			out.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	GUI frame = new GUI();
    	
    	
    	
    }
}