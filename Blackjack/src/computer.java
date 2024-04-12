import java.util.Random;

public class computer {
	
		private int card1;
		private int card2;
		private int total;
		private boolean flag = true;
		
	
	
		public computer() {
		Random random = new Random();
		this.card1 = random.nextInt(10) + 2; 
		this.card2 = random.nextInt(10) + 2;
		this.total = card1 + card2;
	}
	
		public void printCards() {
		System.out.println("The dealer has a " + card1 + " showing, and a hidden card." );
		}
		
		public void DealersPlay() {
			
			while(total <=16) {
				System.out.println("Dealer draw a card");
				Random  random = new Random();
				int newCard = random.nextInt(10) + 2;
				total += newCard;
				System.out.println("Dealers hand  " + total + ".");
				
			}
			
			if(total == 21) {
				System.out.println("DEALER WINS!");
				flag = false;
				
			}
			if(total > 21) {
				System.out.println("YOU WIN!");
				flag = false;
				
			}
			
			
			}
		
		public int getTotal() {
			return total;
		}
		
		public boolean getFlaf() {
			return flag;
		}
		
		
}
