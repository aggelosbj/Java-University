import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel commonPanel;
	private JPanel carHousePanel;
	private JPanel carPanel;
	private JPanel housePanel;
	private JLabel commonLabel;
	private JLabel carLabel;
	private JLabel houseLabel;
	private JTextField nameField;
	private JTextField durationField;
	private JTextField displacementField;
	private JTextField squareMetersField;
	private JButton storeCarButton;
	private JButton storeHouseButton;
	
	private ArrayList<Insurance> insurances = new ArrayList<>();
 	
	public InputFrame() 
	{		

		panel = new JPanel();
		commonPanel = new JPanel();
		carPanel = new JPanel();
		housePanel = new JPanel();
		carHousePanel = new JPanel();
		
		panel.setLayout(new GridLayout(2, 0));
		
		commonLabel = new JLabel("Autokinita kai Spitia");
		carLabel = new JLabel("Autokinita");
		houseLabel = new JLabel("Spitia");
		
		nameField = new JTextField("Onoma Asfalizomenou");
		durationField = new JTextField("Diarkeia se mines");
		displacementField = new JTextField("Kyvika Ekatosta");
		squareMetersField = new JTextField("Tetragwnika Metra");
		
		storeCarButton = new JButton("Apothikeusi");
		storeHouseButton = new JButton("Apothikeusi");
		
		commonPanel.setLayout(new GridLayout(3, 0));
		commonPanel.add(commonLabel);
		commonPanel.add(nameField);
		commonPanel.add(durationField);
		commonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		carPanel.setLayout(new GridLayout(3, 0));
		carPanel.add(carLabel);
		carPanel.add(displacementField);
		carPanel.add(storeCarButton);
		carPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		housePanel.setLayout(new GridLayout(3, 0));
		housePanel.add(houseLabel);
		housePanel.add(squareMetersField);
		housePanel.add(storeHouseButton);
		housePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		carHousePanel.add(carPanel);
		carHousePanel.add(housePanel);
		
		panel.add(commonPanel);
		panel.add(carHousePanel);
		
		this.setContentPane(panel);
		
		ApothikefsiButtonListener ButtonListener = new ApothikefsiButtonListener();
		storeCarButton.addActionListener(ButtonListener);
		storeHouseButton.addActionListener(ButtonListener);
		
		
		this.setVisible(true);
		this.setSize(300, 300);
		this.setLocation(0, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gia na emfanistoun sto ResultsFrame 
		String onomaAsfalismenou = nameField.getText();
		//ResultsFrame resultsFrame =
		new ResultsFrame(insurances, onomaAsfalismenou);
	}
	
	class ApothikefsiButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			//apothikevoume to onoma poy tha eisagoume sto nameField
			String onomaAsfalismenou = nameField.getText();
			
			//dimioyrgoume mia metabliti flas kai tin arxikopoioyme se true
			//afti i metabliti tha xrisimopoihthei gia na katagrafei an to onoma
			//poy eisagage o xristis yparxei idi stin arrayList insyranceis
			boolean flag =true;
			for(Insurance i: insurances)
			{
				if(i.getName().equals(onomaAsfalismenou))
				{
					System.out.println("Name Already exists");
					flag = false;
					break;
				}
			}
			
			//meta an flag parameini true simainei oti den yparxei to onoma
			if(flag==true)
			{
				//opote pairnei to keimeno duration poy eisage o xristis 
				//to metatrepei se akeraio arithmo poy adiprosopevei
				//tin diarkeia tis asfaleias se mines
				String diarkeiaSeMinesString = durationField.getText();
				int diarkeiaSeMines = Integer.parseInt(diarkeiaSeMinesString);
				
				//an to koumpti einai i apothikefsi se amaksi 
				if(e.getSource().equals(storeCarButton))
				{
					//pairnei to keimeno poy eisagei o xristis sto pedio diplacementField
					//metatrepei ta kivikaEkatostaString se int 
					String kivikaEkatostaString = displacementField.getText();
					int kivikaEkatosta = Integer.parseInt(kivikaEkatostaString);
					
					//dimourgei ena neo adikeimeno CarInsurance me parametrous 
					//onoma asfalismenoy, diarkeia se mines kai ta kivika ekatosta
					insurances.add(new CarInsurance(onomaAsfalismenou, diarkeiaSeMines, kivikaEkatosta));							
				}
				
				//an o xristos patisi apothkefsi gia spitia 
				else if(e.getSource().equals(storeHouseButton))
				{
					//pairnei to keimeno poy eisagei o xristis sto squareMetersField
					//metatrepei ta tetragonikaMetraString se int
					String tetragonikaMetraString = squareMetersField.getText();	
					int tetragonikaMetra = Integer.parseInt(tetragonikaMetraString);
					
					//dhmioyrgei ena neo adeikeimeno HouseIncurance me parametrous
					//onoma asfaleismenoy, ddeiarkei se mines kai ta tetragonika metra
					insurances.add(new HouseInsurance(onomaAsfalismenou, diarkeiaSeMines, tetragonikaMetra));
				}

			}
			
			
			
		}
	}

}
