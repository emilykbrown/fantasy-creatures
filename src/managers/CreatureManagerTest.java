package managers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import managers.CreatureManager;
import creatures.Dragon;
import creatures.Unicorn;
import creatures.Phoenix;

class CreatureManagerTest {

    @Test
    void testAddCreature() {
        CreatureManager manager = new CreatureManager();
        Dragon dragon = new Dragon("FireDragon", 0, 0);
        manager.addCreature(dragon);

        assertTrue(manager.displayCreatures().contains(dragon));
    }

    @Test
    void testRemoveCreatureByName() {
        CreatureManager manager = new CreatureManager();
        Unicorn unicorn = new Unicorn("Sparkle", 0, null);
        manager.addCreature(unicorn);
        manager.removeCreatureByName("Sparkle");

        assertFalse(manager.displayCreatures().contains(unicorn));
    }

    @Test
    void testDisplayCreatures() {
        CreatureManager manager = new CreatureManager();
        Dragon dragon = new Dragon("FireDragon", 0, 0);
        Unicorn unicorn = new Unicorn("Sparkle", 0, null);
        manager.addCreature(dragon);
        manager.addCreature(unicorn);

        manager.displayCreatures();  // Test if displayCreatures prints the creatures correctly
    }

    @Test
    void testFilterCreaturesByType() {
        CreatureManager manager = new CreatureManager();
        Dragon dragon = new Dragon("FireDragon", 0, 0);
        Unicorn unicorn = new Unicorn("Sparkle", 0, null);
        manager.addCreature(dragon);
        manager.addCreature(unicorn);

        manager.displayCreaturesByType(1); // Test filtering by Dragon
    }
}
