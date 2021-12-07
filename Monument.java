package application;

public class Monument {
    
    private int health;
    private double money;
    private boolean displaying = true;
    private int enemiesKilled = 0;
    private int moneyEarned = 0;
    private int damageTaken = 0;
    
    public Monument(int health, int money) {
        this.health = health;
        this.money = money;
    }
    
    public void buy(double price) {
        this.money -= price;
        this.updateLevelText();
    }

    public void gainMoney(double money) {
        this.money += money;
        this.moneyEarned += money;
        this.enemiesKilled++;
        this.updateLevelText();
    }
    
    public void takeDamage(int dmg) {
        this.health -= dmg;
        this.damageTaken += dmg;
        this.updateLevelText();
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
    
    public boolean getDisplay() {
        return this.displaying;
    }
    
    public void setDisplay(boolean displaying) {
        this.displaying = displaying;
    }
    
    private void updateLevelText() {
        Level.getInstance().updateText();
    }
    
    public int getEnemiesKilled() {
        return this.enemiesKilled;
    }
    
    public int getMoneyEarned() {
        return this.moneyEarned;
    }
    
    public int getDamageTaken() {
        return this.damageTaken;
    }
}
