abstract class MenuBuilder {
    protected Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void createNewMenuProduct() {
        menu = new Menu();
    }

    public abstract void buildMeat();
    public abstract void buildbread();
    public abstract void buildsalat();
    public abstract void builddrink();
    
    
}
