package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import managers.CreatureManager;
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
                    modifyCreature(manager, myScanner);
                    break;
                case 4:
                    removeCreature(manager, myScanner);
                    break;
                case 5:
                    filterByType(manager, myScanner);
                    break;
                case 6:
                    showStatistics(manager);
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
    

@SuppressWarnings("null")
public void addCreature() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Add Creature ---");
    System.out.println("1. Dragon");
    System.out.println("2. Unicorn");
    System.out.println("3. Phoenix");
    System.out.print("Choose creature type (1-3): ");
    int creatureType = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    System.out.print("Enter creature name: ");
    String name = scanner.nextLine();

    int age = 0;
    boolean validAge = false;
    while (!validAge) {
        try {
            System.out.print("Enter creature age: ");
            age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            validAge = true; // Age is valid, exit loop
        } catch (InputMismatchException e) {
            System.out.println("Invalid age input. Please enter a valid integer for age.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    CreatureManager manager = null;
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
            break;
    }
}

    private static void addCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Add Creature ---");
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


        }
    

    private static void modifyCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Modify Creature ---");
        manager.displayCreatures();
        System.out.print("Enter the name of the creature to modify: ");
        String name = scanner.nextLine();

        var creature = manager.removeCreatureByName(name);
        if (creature == null) {
            System.out.println("Creature not found.");
            return;
        }

        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        creature.setAge(newAge);

        if (creature instanceof Dragon) {
            System.out.print("Enter new fire power level (1-100): ");
            int newFirePower = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            ((Dragon) creature).setFirePower(newFirePower);
        } else if (creature instanceof Unicorn) {
            System.out.print("Enter new horn color: ");
            String newHornColor = scanner.nextLine();
            ((Unicorn) creature).setHornColor(newHornColor);
        } else if (creature instanceof Phoenix) {
            System.out.print("Enter new number of life cycles: ");
            int newLifeCycles = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            ((Phoenix) creature).setLifeCycles(newLifeCycles);
        }

        System.out.println("Creature updated successfully.");
    }

    private static void removeCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Remove Creature ---");
        manager.displayCreatures();
        System.out.print("Enter the name of the creature to remove: ");
        String name = scanner.nextLine();
        manager.removeCreatureByName(name);
    }

    private static void filterByType(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Filter by Type ---");
        System.out.println("1. Dragon");
        System.out.println("2. Unicorn");
        System.out.println("3. Phoenix");
        System.out.print("Choose creature type (1-3): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Class<?> filterType = switch (typeChoice) {
            case 1 -> Dragon.class;
            case 2 -> Unicorn.class;
            case 3 -> Phoenix.class;
            default -> null;
        };

        if (filterType == null) {
            System.out.println("Invalid type selection.");
            return;
        }

        manager.displayCreaturesByType(filterType);
    }

    private static void showStatistics(CreatureManager manager) {
        System.out.println("\n--- Show Statistics ---");

        int totalCreatures = manager.getAllCreatures().size();
        long dragonCount = manager.getAllCreatures().stream().filter(c -> c instanceof Dragon).count();
        long unicornCount = manager.getAllCreatures().stream().filter(c -> c instanceof Unicorn).count();
        long phoenixCount = manager.getAllCreatures().stream().filter(c -> c instanceof Phoenix).count();

        double averageFirePower = manager.getAllCreatures().stream()
                .filter(c -> c instanceof Dragon)
                .mapToInt(c -> ((Dragon) c).getFirePower())
                .average()
                .orElse(0);

        double averageLifeCycles = manager.getAllCreatures().stream()
                .filter(c -> c instanceof Phoenix)
                .mapToInt(c -> ((Phoenix) c).getLifeCycles())
                .average()
                .orElse(0);

        System.out.println("Total creatures: " + totalCreatures);
        System.out.println("Number of Dragons: " + dragonCount);
        System.out.println("Number of Unicorns: " + unicornCount);
        System.out.println("Number of Phoenixes: " + phoenixCount);

        if (dragonCount > 0) {
            System.out.printf("Average Fire Power (Dragons): %.2f\n", averageFirePower);
        }
        if (phoenixCount > 0) {
            System.out.printf("Average Life Cycles (Phoenixes): %.2f\n", averageLifeCycles);
        }

        System.out.println("Statistics calculated successfully!");
    }

    private static void saveData(CreatureManager manager) {
        System.out.println("\n--- Save Data ---");
        if (FileHandler.saveCreaturesToFile(manager.getAllCreatures(), "creatures.dat")) {
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
