import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel diamoniPanel;
	private JPanel allInclusivePanel;
	private JPanel buttonPanel;
	
	private JLabel diamoniLabel;
	private JLabel hotelLabel;
	private JLabel allInclusiveLabel;
	
	private JList listView;
	private DefaultListModel model;
	
	private JTextField daysField;
	private JTextField mealsField;
	
	private JButton storeButton;
	private JButton calculateCostButton;
	
	private JTextField costField;
	
	//tin dilono edo stin grafiki diasindesi
	private ArrayList<Hotel> hotels;

	
	public InputFrame() {
		
		//grafoume kodika oste na diabzoume apo to hotels.ser
		//ta ksenodoxia briskodai stin main
		//opote anoigo to parathiro diabzo apo to arxei
		
		try {
			FileInputStream fileIn = new FileInputStream("hotels.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
				//tora pairno afto poy exo mesa sto arxeio
			//epeidh theloume na to anathesoume se mia lista ksenodoxeio
			//aftin tin lista prepei na tin diloso epano 
			hotels = (ArrayList<Hotel>) in.readObject();//casting
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
		
		
		
		panel = new JPanel();
		diamoniPanel = new JPanel();
		allInclusivePanel = new JPanel();
		buttonPanel = new JPanel();	
		
		listView = new JList();
		model = new DefaultListModel();

		//kalo tin Collections.sort kai ta taksinomo
		Collections.sort(hotels);
		
		//tha balo ta pragmatika onomata tora apo hotel ta diatrexo
		for(Hotel hotel: hotels) {
			String hotelName = hotel.getName();
			model.addElement(hotelName);
		}
			
		
		listView.setModel(model);
		
		
		
		diamoniLabel = new JLabel("Stoixeia Diamonis");
		hotelLabel = new JLabel("Hotel");
		allInclusiveLabel = new JLabel("AllInclusive");
		
		daysField = new JTextField("Hmeres Diamonis");
		mealsField = new JTextField("Plithos Geumatwn (1,2,3)");
		costField = new JTextField("Synoliko Kostos");
		
		storeButton = new JButton("Apothikeusi Kratisis");
		calculateCostButton = new JButton("Ypologismos Kostous");
		
		diamoniPanel.setLayout(new BoxLayout(diamoniPanel, BoxLayout.Y_AXIS));
		diamoniLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(diamoniLabel);
		hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(hotelLabel);
		diamoniPanel.add(listView);
		diamoniPanel.add(daysField);
		diamoniPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allInclusivePanel.setLayout(new GridLayout(2,0));
		allInclusivePanel.add(allInclusiveLabel);
		allInclusivePanel.add(mealsField);
		allInclusivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(storeButton);
		buttonPanel.add(calculateCostButton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(diamoniPanel);
		panel.add(allInclusivePanel);
		panel.add(buttonPanel);
		panel.add(costField);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		storeButton.addActionListener(listener);
		calculateCostButton.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//briskoume pio einai to epilegmeno ksenodoxeio
			String selectedHotelName = (String) listView.getSelectedValue();
			//an den epileksei tipota
			Hotel selectedHotel = null;
			//an to ksenodoxeio eiani afto poy epelekse
			for(Hotel hotel: hotels)
				if(hotel.getName().equals(selectedHotelName))
					selectedHotel = hotel;
			
			
			
			if(e.getSource().equals(storeButton)) {
			//storeButton clicked
					
					//poses meres tha mini exei i oxi gevmata
					//pairno tis imeres
					//pira merres san alfarithmitko to kano akeraio
					String daysString = daysField.getText();
					int days = Integer.parseInt(daysString);
					String mealsString = mealsField.getText();
					
					//epeidi einai dio tin dilono stin arxi an to kano sta if 
					//einai block kodika 
					Reservation reserve;
					//kai meta apla anatheto timi
					
					if(mealsString.equals("")) {
						//dhmhourgia adikimenoy tipoy Reservation
						reserve = new Reservation(days);
					}
					else {
						//dhmhoyrgia adikimenoy typoy allInclusive
						//ta kano apo string arithmo den egine prin 
						//giati mporei na min eixe arithmo 
						int meals = Integer.parseInt(mealsString);
						reserve = new All_Inclusive(days,meals);
						
					}
					
					//prpeei na kataxoriso tin kratisi sto ksenodoxeio
					//diasindesi metaksi klaseon
					selectedHotel.addReservation(reserve);
					System.out.println("the reservation has been stored hotel"
							+ selectedHotel.getName());//BAZO KAI TO GETNAME ALLIOS 
													   //BGAZEI DIEFTHINSI APO MNIMI 
			
			}
			else {
				//calculateCostButton clicked
				//pao sto epilegmeno ksenodoxeio kai thelo na to emfaniso
				int totalCost = selectedHotel.calculateTotalCost();
				//i methodos poy thetei kati se ena pedio
				//epeidi kati perimenei string kai oxi int
				String totalCostText = Integer.toString(totalCost);
				costField.setText(totalCostText);
			}
			
		}
		
	}

}
