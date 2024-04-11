import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfitCalculator extends JFrame {
	
	private JPanel panel = new JPanel();
	private JList<String> providersList = new JList<>();
	private DefaultListModel<String> providerModel = new DefaultListModel<>();
	
	private JButton profitButton = new JButton("Calculate Provider Profit");
	
	private JTextField profitTextField = new JTextField("calculated profit");
	private ArrayList<Provider> providers; // trabao apo main
	
	public ProfitCalculator(ArrayList<Provider> someProviders) {
		//trbao apo main ta onomata 
		providers = someProviders;// kai edo apo main
		
		
		providerModel.addElement("Provider 1");
		providerModel.addElement("Provider 2");
		providerModel.addElement("Provider 3");
		providersList.setModel(providerModel);
		
		
		// trabame apo tin main 
		DefaultListModel<String> model = new DefaultListModel<>();
		
		//daitrexo ta onomata oste na emfanistoun
		for(Provider provider: providers)
			model.addElement(provider.getCompanyName());
		
		providersList.setModel(model);
		// eos edo kai ginetai emfanisi apo main 
			
		panel.add(providersList);
		panel.add(profitButton);
		panel.add(profitTextField);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		profitButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Profit Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Όταν επιλέγω εταιρία με πάτημα κουμπιού, υπολογίζω και εμφανίζω το κέρδος
			
			String selectedComName = (String) providersList.getSelectedValue();
			//ανακτά το επιλεγμένο αντικείμενο από μια λίστα
			//και το αποθηκεύει στη μεταβλητή selectedComName.
			
			Provider selectedCom = null;
			//dimioyrgoyme mia metabliti selectedCom typoy provider
			//gia na apothikefsoume to epilegmeno antikeimno paroxoy
			
			
			//ερνά από κάθε αντικείμενο provider που υπάρχει στη λίστα providers.
			//mesa kanoume elexo an to onoma tis etairias provider einai 
			//iso me to selectesCom
			for(Provider provider: providers) {
				if(provider.getCompanyName().equals(selectedComName)) {
					selectedCom = provider;
					break;
				}
			}
			
			//Αν η selectedCom δεν είναι null, υπολογίζεται το κέρδος για την εταιρεία.
			//dimioyrgeite ena hashMap me tis times energeias 
			//xrisimopoiontas tin methodo readFile apo main
			//kai kaleite i methodos calcprofit toy selected com gia na ipologisei kerdos
			//tin opoia dimioyegisame sto provider
			//to emfanzoume to kerdos sto profittextfield
			if(selectedCom != null) {
				HashMap<String,String> energyPrices = Main.readFile("EnergyPrices.txt");
				double profit = selectedCom.calculateProfit(energyPrices);
				
				profitTextField.setText(Double.toString(profit));
			}
			
		}
		
	}

	
}
