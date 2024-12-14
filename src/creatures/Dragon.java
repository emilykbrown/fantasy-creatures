package creatures;

import java.io.Serializable;

public class Dragon extends Creature {
	
    private int firePower;

	public Dragon(String name, int age, int firePower) {
        super(name, age);
        this.firePower = firePower;
    }

    // Getter and Setter
    public int getFirePower() {
        return getFirePower();
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    @Override
    public String getCreatureDetails() {
        return "Dragon: " + getName() + ", Age: " + getAge() + ", Fire Power: " + firePower;
    }

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}
}
