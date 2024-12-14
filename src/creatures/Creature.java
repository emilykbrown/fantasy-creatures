package creatures;

import java.io.Serializable;

public abstract class Creature implements Serializable {
    private static final long serialVersionUID = 1L; // A unique ID for serialization
    private String name;
    private int age;

    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract methods for subclass-specific details
    public abstract String getCreatureDetails();

	dx abstract void displayInfo();
}
