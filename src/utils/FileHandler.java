package utils;

import creatures.Creature;
import java.io.*;
import java.util.List;

public class FileHandler {

    public static void saveCreaturesToFile1(Object object, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
            System.out.println("Creatures saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving creatures: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
	public static List<Creature> loadCreaturesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Creature>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading creatures: " + e.getMessage());
            return null;
        }
    }

	public static boolean saveCreaturesToFile2(Object displayCreatures, String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void saveCreaturesToFile3(Object displayCreatures, String filename) {
		// TODO Auto-generated method stub
		
	}

	public static boolean saveCreaturesToFile(Object displayCreatures, String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
