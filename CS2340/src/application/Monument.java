package application;

public class Monument {
    
    private int health;
    private double money;
    private boolean displaying = true;
    
    public Monument(int health, int money) {
        this.health = health;
        this.money = money;
    }
    
    public void buy(double price) {
        this.money -= price;
    }

    public void sell(double price) {
        this.money += price;
    }
    
    public void takeDamage(int dmg) {
        this.health -= dmg;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public boolean getDisplay() {
        return this.displaying;
    }
    
    public void setDisplay(boolean displaying) {
        this.displaying = displaying;
    }
}
