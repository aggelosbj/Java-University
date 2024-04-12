import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultsFrame extends JFrame {
	
	private JList listView;
	private JPanel panel;
	private JButton refreshButton;
	private JButton calcButton;
	private JTextField chargeField;
	private DefaultListModel model;
	private String onomaAsfalismenou;
	
	private ArrayList<Insurance> insurances;
	
	public ResultsFrame(ArrayList<Insurance> insurances, String onomaAsfalismenou) 
	{
		this.insurances = insurances;
		this.onomaAsfalismenou = onomaAsfalismenou;
		
		listView = new JList();
		panel = new JPanel();
		refreshButton = new JButton("Ananewsh");
		calcButton = new JButton("Ypologismos Kostous");
		chargeField = new JTextField("Kostos");
		
		model = new DefaultListModel();
//		model.addElement("Dummy Name 1");
//		model.addElement("Dummy Name 2");
//		model.addElement("Dummy Name 3");
		
		for(Insurance insurance: insurances)
			model.addElement(onomaAsfalismenou);
		
		listView.setModel(model);
		
		panel.add(listView);
		panel.add(refreshButton);
		panel.add(calcButton);
		panel.add(chargeField);
				
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		refreshButton.addActionListener(listener);
		calcButton.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(200, 300);
		this.setLocation(300, 0);
		this.setTitle("Results");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			//elexoume an o xristis tha patisi to koympi tis ananeosis
			//diatrexoume me for tin domi dedomenon kai prosthetoume
			//stin lista to onoma otan patithi to koympi
			if(e.getSource().equals(refreshButton)) {
				model.clear();
				for(Insurance insurance: insurances) {
					model.addElement(insurance.getName());
				}
			}
			else if (e.getSource().equals(calcButton))
			{
				//pairnoume to onoma apo tin lista kai to pername se mia 
				//selected name
				String selectedName = (String) listView.getSelectedValue();
				//arxikopioume to actualInsurance se null
				Insurance actualInsurance = null;
				//diatrexoume tin domi dedomenon an to onoma einai idio 
				//me to selectedName tote to actualInsurance einai to onoma 
				for(Insurance insurance: insurances) {
					if(insurance.getName().equals(selectedName)) {
						actualInsurance = insurance;
						
					}
					
				}
				
				//elexoume an actualInsurance den einai null diladi
				//an exei brei asfalisi poy adistixei sto onoma
				//kai kaloume tin totalCharge gia to adikeimno afto 
				//tin metatrepoyme se alfarithmitki morfi 
				//kai tin anathetoume sto field gia emfanisi 
				if(actualInsurance != null) {
					//dimiurgoume mia metabliti total kai kanoume ta all
					
					String totalValue = Integer.toString(actualInsurance.totalCharge());
					chargeField.setText(totalValue);
					
				}
			}
			
			
			
		}
	}

}
