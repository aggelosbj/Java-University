import java.util.Scanner;
import java.util.Random;

public class Player {
	private int card1;
	private int card2;
	private int total;
	private String answer;
	private boolean flag = true;
	
	
	public Player(String answer) {
		this.answer = answer;
	}

	public Player() {
		Random random = new Random();
		this.card1 = random.nextInt(10) + 2; 
		this.card2 = random.nextInt(10) + 2;
		this.total = card1 + card2;
	}
	
	public void printCards() {
		System.out.println("You get a " + card1 + " and " + card2 + "." );
		System.out.println("Your total is: " + total + ".");
	}
	
	public void makeChoice(){
		Scanner scanner = new Scanner(System.in);
		String answer;
		
		do {
			System.out.println("Would you like to 'hit or 'stay' ?");
			answer = scanner.nextLine();
			
			if (answer.equals("hit")) {
				Random random = new Random();
				int newCard = random.nextInt(10) + 2;
				System.out.println("You drew a " + newCard + ".");
				total += newCard;
				System.out.println("Your total is " + total + ".");
			}
			
		}while(answer.equals("hit") && total<21);
		
		if(total == 21 ) {
			System.out.println("You win");
			flag = false;
			
		}
		 if(total > 21) {
			System.out.println("DEALER WINS");
			flag=false;
			
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean getFlag() {
		return flag;
	}
	
	
	
	
}
