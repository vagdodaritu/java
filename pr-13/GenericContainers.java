class Box<T> {
    private T value;
    Box(T value) { this.value = value; }
    T get() { return value; }
    void set(T value) { this.value = value; }
}
class Pair<A, B> {
    A first; B second;
    Pair(A first, B second) { this.first = first; this.second = second; }
    public String toString() { return "(" + first + ", " + second + ")"; }
}
public class GenericContainers {
    static <T> T first(T[] values) { return values[0]; }
    public static void main(String[] args) {
        Box<String> name = new Box<>("Rujuta");
        Box<Integer> number = new Box<>(25);
        Pair<String, Integer> pair = new Pair<>("CE", 3);
        String[] names = {"Riya", "Amit", "Neha"};
        System.out.println("String box: " + name.get());
        System.out.println("Integer box: " + number.get());
        System.out.println("Pair: " + pair);
        System.out.println("First array element: " + first(names));
    }
}