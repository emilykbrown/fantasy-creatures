package creatures;

public class Phoenix extends Creature implements Ability {
    private int lifeCycles;

    public Phoenix(String name, int age, int lifeCycles) {
        super(name, age, "Phoenix");
        this.lifeCycles = lifeCycles;
    }

    public int getLifeCycles() {
        return lifeCycles;
    }

    public void setLifeCycles(int lifeCycles) {
        this.lifeCycles = lifeCycles;
    }

    @Override
    public void useAbility() {
        System.out.println(getName() + " bursts into flames and is reborn! Remaining life cycles: " + lifeCycles);
    }
}
