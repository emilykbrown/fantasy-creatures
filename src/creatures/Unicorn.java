package creatures;

public class Unicorn extends Creature implements Ability {
    private String hornColor;

    public Unicorn(String name, int age, String hornColor) {
        super(name, age, "Unicorn");
        this.hornColor = hornColor;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    @Override
    public void useAbility() {
        System.out.println(getName() + " uses its magical " + hornColor + " horn to heal!");
    }
}
