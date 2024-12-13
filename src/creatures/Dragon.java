package creatures;

public class Dragon extends Creature {

    private int firePower;

    public Dragon(String name, int age, int firePower) {
        super(name, age);
        this.firePower = firePower;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    // Override the toString() method to return the desired format
    @Override
    public String toString() {
        return "Name: " + getName() + ", Type: Dragon, Age: " + getAge() + ", Fire power: " + firePower;
    }
}
