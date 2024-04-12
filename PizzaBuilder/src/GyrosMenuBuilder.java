
public class GyrosMenuBuilder extends MenuBuilder {

	   

	    public void buildbread() {
	        menu.setBread("pita");
	    }

	    public void buildsalat() {
	        menu.setSalat("xtypiti");
	    }
	    
	    public void builddrink() {
	    	menu.setDrink("coke");
	    }

		@Override
		public void buildMeat() {
			menu.setMeat("gyros");
			
		}
	}