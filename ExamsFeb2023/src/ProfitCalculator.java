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
	private ArrayList<Provider> providers; 
	
	public ProfitCalculator(ArrayList<Provider> someProviders) {
		 
		providers = someProviders;
		
		
		providerModel.addElement("Provider 1");
		providerModel.addElement("Provider 2");
		providerModel.addElement("Provider 3");
		providersList.setModel(providerModel);
		
		
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		
		for(Provider provider: providers)
			model.addElement(provider.getCompanyName());
		
		providersList.setModel(model);
		
			
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
			
			
			String selectedComName = (String) providersList.getSelectedValue();
			
			
			Provider selectedCom = null;
						
			
			for(Provider provider: providers) {
				if(provider.getCompanyName().equals(selectedComName)) {
					selectedCom = provider;
					break;
				}
			}
			
			
			if(selectedCom != null) {
				HashMap<String,String> energyPrices = Main.readFile("EnergyPrices.txt");
				double profit = selectedCom.calculateProfit(energyPrices);
				
				profitTextField.setText(Double.toString(profit));
			}
			
		}
		
	}

	
}
