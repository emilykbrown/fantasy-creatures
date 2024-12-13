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

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Type: Unicorn, Age: " + getAge() + ", Horn color: " + hornColor;
    }
}
