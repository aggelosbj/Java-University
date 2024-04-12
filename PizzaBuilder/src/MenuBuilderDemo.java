
public class MenuBuilderDemo {
    public static void main(String[] args) {
    	
        Waiter waiter = new Waiter(new GyrosMenuBuilder());
        
        waiter.constructPizza();
        Menu menu1 = waiter.getMenu();
        menu1.printInfo();
    
    }
}