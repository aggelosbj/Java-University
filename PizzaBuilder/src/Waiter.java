
class Waiter {
    private MenuBuilder menuBuilder;
    
    public Waiter(MenuBuilder mb) {
    	menuBuilder = mb;
    }

    

    public Menu getMenu() {
        return menuBuilder.getMenu();
    }

    public void constructPizza() {
        menuBuilder.createNewMenuProduct();
        menuBuilder.buildMeat();
        menuBuilder.buildsalat();
        menuBuilder.buildbread();
        menuBuilder.builddrink();
    }



}