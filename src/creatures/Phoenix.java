package creatures;

public class Phoenix extends Creature {

    private int lifeCycles;

    public Phoenix(String name, int age, int lifeCycles) {
        super(name, age);
        this.lifeCycles = lifeCycles;
    }

    public int getLifeCycles() {
        return lifeCycles;
    }

    public void setLifeCycles(int lifeCycles) {
        this.lifeCycles = lifeCycles;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Type: Phoenix, Age: " + getAge() + ", Life cycles: " + lifeCycles;
    }

	@Override
	public String getCreatureDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

	public void setRebirthCycle(int newRebirthCycle) {
		// TODO Auto-generated method stub
		
	}
}
