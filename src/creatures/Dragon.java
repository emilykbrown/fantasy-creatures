package creatures;

public class Dragon extends Creature implements Ability {
    private int firePower;

    public Dragon(String name, int age, int firePower) {
        super(name, age, "Dragon");
        this.firePower = firePower;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    @Override
    public void useAbility() {
        System.out.println(getName() + " breathes fire with power " + firePower + "!");
    }
}