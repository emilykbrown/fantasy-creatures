package utils;

import creatures.Creature;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;

public class FileHandler {

    public static boolean saveCreaturesToFile(List<Creature> creatures, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(creatures);
            System.out.println("Data saved successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving creatures: " + e.getMessage());
            return false;
        }
    }

	public static Object loadCreaturesFromFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
