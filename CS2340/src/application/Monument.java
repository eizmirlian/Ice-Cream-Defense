package application;

public class Monument {
    
    private int health;
    private int money;
    
    public Monument(int health, int money) {
        this.health = health;
        this.money = money;
    }
    
    public void buy(int price) {
        this.money -= price;
    }
    
    public void takeDamage(int dmg) {
        this.health -= dmg;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public int getHealth() {
        return this.health;
    }
}
