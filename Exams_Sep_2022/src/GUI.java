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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
    JPanel panel = new JPanel();
    JLabel label = new JLabel("City");
    JTextField textField = new JTextField(10);
    JButton button = new JButton("Click");
    JList<String> list = new JList<>();
    DefaultListModel<String> citiesModel = new DefaultListModel<>();
    ArrayList<City> cities;
    
    public GUI()
    {
    	//afto prepei na kanoume gia na emfanisoume ta onomata
    	// sto gui fitaxnoume FileInputStream
    	
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
    	
    	
    	
//    	citiesModel.addElement("City 1");
//    	citiesModel.addElement("City 2");
//    	citiesModel.addElement("City 3");
    	list.setModel(citiesModel);
    	
    	for(City city: cities) {
    		citiesModel.addElement(city.city_name);
    	}
    	
    	list.setModel(citiesModel);
    	button.addActionListener(this);
    	
    	panel.add(list);
    	panel.add(button);
    	
    	this.setContentPane(panel);
    	this.setTitle("Window");
    	this.setSize(500,500);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    	this.setResizable(false);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource().equals(button))
	    {
			//λέγχουμε αν έχει επιλεγεί μια πόλη από τη λίστα (JList).
	    	if(!(list.getSelectedValue()==null))
	    	{
	    		//διατρέχουμε με for
	    		for (City city : cities)
		    	{
	    			//όνομα της πόλης (city.city_name) είναι ίσο 
	    			//με την πόλη που έχει επιλεγεί από τον 
	    			//χρήστη (list.getSelectedValue()
					if(city.city_name.equals(list.getSelectedValue()))
					{
						//αν ταιριάζουν τότε καλούμε την μέθοδο
						//printProperties της πόλης, περνώντας ως 
						//όρισμα το όνομα του αρχείου ("Properties.txt")
						//όπου θα αποθηκευθούν οι πληροφορίες της πόλης
						city.printProperties("Properties.txt");
						System.out.println("Informations saved on new file");
					}
				}
	    	}
	    	else 
	    	{
			    JOptionPane.showMessageDialog(null, "City not selected. Please select city.");
			}
	    }
	}
}