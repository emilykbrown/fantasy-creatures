package managers;

import java.util.ArrayList;
import java.util.List;
import creatures.Creature;

public class CreatureManager {
    private List<Creature> creatures;

    public CreatureManager() {
        this.creatures = new ArrayList<>();
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public Creature removeCreatureByName(String name) {
        creatures.removeIf(c -> c.getName().equalsIgnoreCase(name));
		return null;
    }

    public List<Creature> displayCreatures() {
        creatures.forEach(System.out::println);
        return creatures;
    }

	public void displayCreaturesByType(Class<?> filterType) {
		// TODO Auto-generated method stub
		
	}


	public List<Creature> getAllCreatures() {
		// TODO Auto-generated method stub
		return null;
	}
}
