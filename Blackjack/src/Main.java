import java.util.*;
public class Main {
	
	private static int Ptotal,Ctotal;
	private static boolean Pflag,Cflag;

	public static void main(String[] args) {
		System.out.println("Welcome to the simpified blackjack game!");
		
		Player player = new Player();
		player.printCards();
		
		computer computer = new computer();
		computer.printCards();
		
		player.makeChoice();
		Ptotal = player.getTotal();
		Pflag = player.getFlag();
		
		
		if(Pflag) {
			computer.DealersPlay();
			Cflag = computer.getFlaf();
			Ctotal = computer.getTotal();
			
			if(Cflag) {
				if (Ctotal > Ptotal) {
					System.out.println("DEALER WIN!");
				}
				if(Ctotal == Ptotal) {
					System.out.println("DEALER WIN!");
				}
				if(Ctotal < Ptotal) {
					System.out.println("YOU WIN!");
				}
			}
		}
	
	
		
	}
}
