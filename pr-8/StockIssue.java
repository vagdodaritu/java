import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;
    OutOfStockException(int shortfall) {
        super("Out of stock; shortfall = " + shortfall);
        this.shortfall = shortfall;
    }
}
class InvalidQuantityException extends Exception {
    InvalidQuantityException() { super("Quantity must be greater than zero."); }
}
class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();
    Warehouse() { stock.put("Pen", 5); stock.put("Book", 2); }
    void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) throw new InvalidQuantityException();
        int available = stock.getOrDefault(item, 0);
        if (qty > available) throw new OutOfStockException(qty - available);
        stock.put(item, available - qty);
        System.out.println("Issued " + qty + " " + item + "; remaining = " + (available - qty));
    }
}
public class StockIssue {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Object[][] requests = {{"Pen", 3}, {"Book", 4}, {"Pen", 0}, {"Book", 1}};
        for (Object[] request : requests) {
            try { w.issue((String) request[0], (int) request[1]); }
            catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println("Request failed: " + e.getMessage());
            }
        }
        System.out.println("Processing completed.");
    }
}