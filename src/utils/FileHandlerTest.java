package utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import utils.FileHandler;
import creatures.Creature;
import creatures.Dragon;
import creatures.Unicorn;
import managers.CreatureManager;
import java.util.List;

class FileHandlerTest {

    @Test
    void testSaveAndLoadCreatures() {
        CreatureManager manager = new CreatureManager();
        Dragon dragon = new Dragon("FireDragon", 0, 0);
        Unicorn unicorn = new Unicorn("Sparkle", 0, null);
        manager.addCreature(dragon);
        manager.addCreature(unicorn);

        FileHandler.saveCreaturesToFile(manager.displayCreatures(), "creatures.dat");
        List<Creature> loadedCreatures = FileHandler.loadCreaturesFromFile("creatures.dat");

        assertNotNull(loadedCreatures);
        assertTrue(loadedCreatures.contains(dragon));
        assertTrue(loadedCreatures.contains(unicorn));
    }
}
