class Menu {
	
	private String meat = "";
	private String bread = "";
	private String salat = "";
	private String drink = "";
	
	public void setMeat(String meat) {
		this.meat = meat;
	}
	
	public void setBread(String bread) {
		this.bread = bread;
	}
	
	public void setSalat(String salat) {
		this.salat = salat;
	}
	
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	public void printInfo() {
		System.out.println("==================");
		System.out.println("A menou with");
		System.out.println("\t " + meat + "   :    "+"meat");
		System.out.println("\t " + bread + "  :    "+"bread");
		System.out.println("\t " + salat + "  :    "+ "salat");
		System.out.println("\t " + drink + "  :    "+"drink");
		System.out.println("=================");
	}
	
	
	
}