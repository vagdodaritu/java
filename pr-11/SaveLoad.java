import java.io.*;
import java.nio.file.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient String temporaryNote;
    int marks;
    Student(String name, int marks, String temporaryNote) {
        this.name = name; this.marks = marks; this.temporaryNote = temporaryNote;
    }
    public String toString() { return name + " | marks=" + marks + " | note=" + temporaryNote; }
}
public class SaveLoad {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("students.dat");
        Student[] students = {new Student("Riya", 88, "temporary"), new Student("Amit", 76, "private note")};
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(students);
        }
        Student[] loaded;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            loaded = (Student[]) in.readObject();
        }
        System.out.println("Loaded objects:");
        for (Student s : loaded) System.out.println(s);
        System.out.println("File exists: " + Files.exists(file));
    }
}