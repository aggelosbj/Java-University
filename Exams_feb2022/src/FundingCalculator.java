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
		citiesList.setModel(citiesModel);
		
	
				
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
			
			int selectedIndex = citiesList.getSelectedIndex();
			
			
			if(selectedIndex >=0 && selectedIndex < cities.size()) {
				double funding = cities.get(selectedIndex).calculateFunding();
				fundingTextField.setText("Funding: " + funding);
			}
			
		}
		
	}
	
	
	
}
