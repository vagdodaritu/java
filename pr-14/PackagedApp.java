import java.io.*;
import java.nio.file.*;
import java.util.*;

class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    String text;
    Note(String text) { this.text = text; }
    public String toString() { return text; }
}
public class PackagedApp {
    public static void main(String[] args) throws Exception {
        List<Note> notes = Arrays.asList(new Note("First note"), new Note("Saved OOP work"));
        Path file = Path.of("notes.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(new ArrayList<>(notes));
        }
        List<Note> loaded;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            loaded = (List<Note>) in.readObject();
        }
        System.out.println("Saved notes: " + notes.size());
        System.out.println("Reloaded notes: " + loaded.size());
        for (Note note : loaded) System.out.println("- " + note);
        System.out.println("Save/reload test: " + (notes.toString().equals(loaded.toString()) ? "PASS" : "FAIL"));
    }
}