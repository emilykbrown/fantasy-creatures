

import java.util.Scanner;
import managers.CreatureManager;
import creatures.Creature;
import creatures.Dragon;
import creatures.Unicorn;
import creatures.Phoenix;
import utils.FileHandler;

public class FantasyCreatureSystem {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        CreatureManager manager = new CreatureManager();

        while (true) {
            System.out.println("\n--- Creature Management ---");
            System.out.println("1. Add Creature");
            System.out.println("2. Display Creatures");
            System.out.println("3. Modify Creature");
            System.out.println("4. Remove Creature");
            System.out.println("5. Filter by Type");
            System.out.println("6. Show Statistics");
            System.out.println("7. Save Data");
            System.out.println("8. Load Data");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            int choice = myScanner.nextInt();
            myScanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addCreature(manager, myScanner);
                    break;
                case 2:
                    manager.displayCreatures();
                    break;
                case 3:
                    System.out.println("Feature not implemented yet.");
                    break;
                case 4:
                    removeCreature(manager, myScanner);
                    break;
                case 5:
                    filterByType(manager, myScanner);
                    break;
                case 6:
                    System.out.println("Feature not implemented yet.");
                    break;
                case 7:
                    saveData(manager);
                    break;
                case 8:
                    loadData(manager);
                    break;
                case 9:
                    System.out.println("Exiting Creature Management System.");
                    myScanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    private static void filterByType(CreatureManager manager, Scanner myScanner) {
		// TODO Auto-generated method stub
		
	}
A    private static void removeCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Remove Creature ---");
        manager.displayCreatures();
        System.out.print("Enter the name of the creature to remove: ");
        String name = scanner.nextLine();
        manager.removeCreatureByName(name);
    }

    private static void addCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n---Add Creature---");
        System.out.println("1. Dragon");
        System.out.println("2. Unicorn");
        System.out.println("3. Phoenix");
        System.out.print("Choose creature type (1-3): ");

        int creatureType = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter creature name: ");
        String name = scanner.nextLine();

        System.out.print("Enter creature age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (creatureType) {
            case 1:
                System.out.print("Enter fire power level (1-100): ");
                int firePower = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                manager.addCreature(new Dragon(name, age, firePower));
                break;
            case 2:
                System.out.print("Enter horn color: ");
                String hornColor = scanner.nextLine();
                manager.addCreature(new Unicorn(name, age, hornColor));
                break;
            case 3:
                System.out.print("Enter number of life cycles: ");
                int lifeCycles = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                manager.addCreature(new Phoenix(name, age, lifeCycles));
                break;
            default:
                System.out.println("Invalid creature type.");
        }
    }


    private static void saveData(CreatureManager manager) {
        System.out.println("\n--- Save Data ---");
        if (FileHandler.saveCreaturesToFile(manager.displayCreatures(), "creatures.dat")) {
            System.out.println("Data saved successfully.");
        } else {
            System.out.println("Failed to save data.");
        }
    }

    private static void loadData(CreatureManager manager) {
        System.out.println("\n--- Load Data ---");
        var creatures = FileHandler.loadCreaturesFromFile("creatures.dat");
        if (creatures != null) {
            creatures.forEach(manager::addCreature);
            System.out.println("Data loaded successfully.");
        } else {
            System.out.println("Failed to load data.");
        }
    }
}
