import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ContainerFrame extends JFrame{
	
	
	private JPanel panel = new JPanel();
	private JPanel fieldPanel = new JPanel();
	private JTextField codeField,destinationField, weightField, powerField;
	private JButton  createBulButton, createRefrButton;
	private JList shipList;
	private ArrayList<Ship> ships;
	
	public ContainerFrame(ArrayList<Ship> someShips) {
		
		ships = someShips;
		
		panel.setLayout(new BorderLayout());
		
		fieldPanel.setLayout(new GridLayout(3, 2));
		
		codeField = new JTextField("Code");
		destinationField = new JTextField("Destination");
		weightField = new JTextField("Weight");
		powerField = new JTextField("power");
		createBulButton = new JButton("Create Bulk");
		createRefrButton = new JButton("create Refr");
		shipList = new JList();
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		for(Ship ship: ships)
			model.addElement(ship.getName());
		
		shipList.setModel(model);
		
		fieldPanel.add(codeField);
		fieldPanel.add(destinationField);
		fieldPanel.add(weightField);
		fieldPanel.add(powerField);
		fieldPanel.add(createBulButton);
		fieldPanel.add(createRefrButton);
		
		panel.add(fieldPanel, BorderLayout.CENTER);
		panel.add(shipList , BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		createBulButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Create Container");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			String weightText = weightField.getText();
			double weight = Double.parseDouble(weightText);
			
			Container bulk = new Bulk(code, destination, weight);
			
			String selectedShipName = (String) shipList.getSelectedValue();
			
			Ship selectedShip = null;
			
			for(Ship ship: ships)
				if(ship.getName().equals(selectedShipName))
					selectedShip = ship;
			
			selectedShip.loadContainer(bulk);
			System.out.println("Container loaded on ship " + selectedShipName);
		
			System.out.println("Total charge for " + selectedShipName + " is " + selectedShip.calcTotalCharge());	
			
		
		}
		
	}

}
