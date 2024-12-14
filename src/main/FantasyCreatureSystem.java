package main;

import java.util.InputMismatchException;
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

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                myScanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Add Creature ---");
        System.out.println("1. Dragon");
        System.out.println("2. Unicorn");
        System.out.println("3. Phoenix");
        System.out.print("Choose creature type (1-3): ");

        int creatureType = -1;
        while (creatureType < 1 || creatureType > 3) {
            try {
                creatureType = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please choose a number between 1 and 3.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        System.out.print("Enter creature name: ");
        String name = scanner.nextLine();

        int age = -1;
        while (age < 0) {
            try {
                System.out.print("Enter creature age: ");
                age = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        switch (creatureType) {
            case 1 -> {
                System.out.print("Enter fire power level (1-100): ");
                int firePower = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                manager.addCreature(new Dragon(name, age, firePower));
            }
            case 2 -> {
                System.out.print("Enter horn color: ");
                String hornColor = scanner.nextLine();
                manager.addCreature(new Unicorn(name, age, hornColor));
            }
            case 3 -> {
                System.out.print("Enter number of life cycles: ");
                int lifeCycles = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                manager.addCreature(new Phoenix(name, age, lifeCycles));
            }
        }
        System.out.println("Creature added successfully!");
    }

    private static void modifyCreature(CreatureManager manager, Scanner scanner) {
        System.out.println("\n--- Modify Creature ---");
        manager.displayCreatures();
        System.out.print("Enter the name of the creature to modify: ");
        String name = scanner.nextLine();

        // Get the creature by name
        Creature creature = manager.removeCreatureByName(name);  // Ensure this method returns a Creature object
        if (creature == null) {
            System.out.println("Creature not found.");
            return;  // If creature is not found, exit the method
        }

        // Update the age
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        creature.setAge(newAge);  // Assuming setAge exists in Creature class

        // Now handle the creature-specific changes based on its type
        if (creature instanceof Dragon) {
            System.out.print("Enter new fire power level (1-100): ");
            int newFirePower = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            ((Dragon) creature).setFirePower(newFirePower);  // Set fire power for Dragon
        } else if (creature instanceof Unicorn) {
            System.out.print("Enter new horn length: ");
            int newHornColor = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            ((Unicorn) creature).setHornColor(newHornColor);  // Set horn length for Unicorn
        } else if (creature instanceof Phoenix) {
            System.out.print("Enter new rebirth cycle: ");
            int newRebirthCycle = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            ((Phoenix) creature).setRebirthCycle(newRebirthCycle);  // Set rebirth cycle for Phoenix
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
        // Implement logic as per initial design
    }
    private static void saveData(CreatureManager manager) {
        // Assuming you want to save the list of creatures to a file
        FileHandler.saveCreaturesToFile(manager.displayCreatures(), "creatures.dat");
    }

    private static void loadData(CreatureManager manager) {
        // Assuming you want to load the list of creatures from a file
        var creatures = FileHandler.loadCreaturesFromFile("creatures.dat");
        if (creatures != null) {
            creatures.forEach(manager::addCreature);
            System.out.println("Data loaded successfully.");
        } else {
            System.out.println("Failed to load data.");
        }
    }
}
