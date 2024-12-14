package creatures;

public class Unicorn extends Creature {

    private String hornColor;

    public Unicorn(String name, int age, String hornColor) {
        super(name, age);
        this.hornColor = hornColor;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(int newHornColor) {
        this.hornColor = newHornColor;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Type: Unicorn, Age: " + getAge() + ", Horn color: " + hornColor;
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
}
