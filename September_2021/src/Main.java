import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		Fleet f1 = new Fleet("Hrakleio");
		Fleet f2 = new Fleet("Rethimno");
		
		
		ElectricalTaxi el1 = new ElectricalTaxi("MNA1234","John", 1000);
		ElectricalTaxi el2 = new ElectricalTaxi("MNA12345","Mary", 1200);
		
		
		GasolineTaxi g1 = new GasolineTaxi("KIW123","AGGELO MPENTAI",60,4.7);
		GasolineTaxi g2 = new GasolineTaxi("KIW1234","Mikel",50,5.6);
		
		
		f1.storeTaxi(el1);
		f1.storeTaxi(g1);
		
		
		f2.storeTaxi(el2);
		f2.storeTaxi(g2);
		
		
		g1.setDriversName("Aggelos bendaj");
		
		
		ArrayList<Fleet> allfleets = new ArrayList<>();
		
		allfleets.add(f1);
		allfleets.add(f2);
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("ics21182.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allfleets);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		new TaxiFrame(allfleets);
		
	}

}
