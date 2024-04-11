import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FundingCalculator extends JFrame {
	
	private JPanel panel = new JPanel();
	private JList<String> citiesList = new JList<>();
	private DefaultListModel<String> citiesModel = new DefaultListModel<>();
	
	private JButton cityFundingButton = new JButton("Calculate City Funding");
	
	private JTextField fundingTextField = new JTextField("calculated funding");
	
	private ArrayList<City> cities;
	private JList listView;
	private DefaultListModel model;
	
	public FundingCalculator() {
		
		//an boro na peirakso main koita examfeb 2022
		
		
		//apo kato se periptsi poy den peirazoume tin main 
		
		//an den yparxoun afta pano sto private ta dilono to array kai afta 
		
		//an moy leei oti den tropopoio tin main katholou kano afto to pragma
		//gia na emfaniso ta onomata tis main edo 
		// pairno to file apo tin main kai to dilono edo 
		File file = new File("Cities.ser");
		
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			cities = (ArrayList<City>) in.readObject();
			
			in.close();
			fileIn.close();
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
		
//		citiesModel.addElement("City 1");
//		citiesModel.addElement("City 2");
//		citiesModel.addElement("City 3");
//		citiesModel.addElement("City 4");
		citiesList.setModel(citiesModel);//afto to afino os exei 
		
	
				//diatrexo ta cities 
		for(City city: cities) {
			citiesModel.addElement(city.getPlace());
		}
		
		
			
		panel.add(citiesList);
		panel.add(cityFundingButton);
		panel.add(fundingTextField);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		cityFundingButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Funding Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//anaktoume ton dikti toy epilegmenoy epilegmenou stoixeio 
			//kai ton apothikevoume stin metabliti selectedIndexx
			int selectedIndex = citiesList.getSelectedIndex();
			
			// elexoume μεγαλύτερος από ή ίσος με 0 και μικρότερος από τον 
			//αριθμό των πόλεων που υπάρχουν στη λίστα cities.
			if(selectedIndex >=0 && selectedIndex < cities.size()) {
				//ipoligizoume to xrimatiko poso kai kaloume tin methodo calculateFunding
				//kai meta to emfainzoume sto pedio keimenou
				double funding = cities.get(selectedIndex).calculateFunding();
				fundingTextField.setText("Funding: " + funding);
			}
			
		}
		
	}
	
	
	
}
