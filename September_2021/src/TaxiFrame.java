import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class TaxiFrame extends JFrame{
	
	private JPanel panel;
	private JTextField textField;
	private JButton viewButton;
	private JButton storeButton;
	private ArrayList<Fleet> allfleets;
	
	
	public TaxiFrame(ArrayList<Fleet> someFleets) {
		
		try {
			FileInputStream filein = new FileInputStream("ics21182.txt");
			ObjectInputStream in = new ObjectInputStream(filein);
			allfleets = (ArrayList<Fleet>) in.readObject();
			in.close();
			filein.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		allfleets = someFleets;
		
		panel = new JPanel();
		
		textField = new JTextField(10);
		viewButton = new JButton("emfanisi aftonomias");
		storeButton = new JButton("apothikefsi se arxeio");
		
		
		panel.add(textField);
		panel.add(viewButton);
		panel.add(storeButton);
		
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		viewButton.addActionListener(listener);
		storeButton.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("TaxiFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

	   
	   

	    @Override
	    public void actionPerformed(ActionEvent e) {

	    	
	        String cityName = textField.getText();

	        
	        for (Fleet fleet : allfleets) {
	            if (fleet.getCityName().equals(cityName)) {
	                int totalTaxis = fleet.getTaxis().size();
	                double totalAutonomy = 0;
	                
	                for (Taxi taxi : fleet.getTaxis()) {
	                    totalAutonomy += taxi.calculateAutonomy();
	                }
	                
	                if(e.getSource().equals(viewButton)) {
	                System.out.println("City name is: " + cityName);
	                System.out.println("All taxis: " + totalTaxis);
	                System.out.println("Total autonomy of all taxis is: " + totalAutonomy);
	                }
	                
	                
	                
	                else {
	                	
	                    String fileName = "ics21182";
	                    
	                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	                    	
	                        writer.write("City name is: " + cityName + "\n");

	                        
	                        
	                        for (Taxi taxi : fleet.getTaxis()) {
	                            writer.write("Driver is: " + taxi.getDriversName() + "\n");
	                            writer.write("Driver license: " + taxi.getLicensePlate() + "\n");
	                            writer.write("Autonomy: " + taxi.calculateAutonomy() + "\n");
	                        }
	                        
	                        
	                        writer.write("Total autonomy of all taxis is: " + totalAutonomy + "\n");

	                        System.out.println("Data written to file.");
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}
	
		
}
