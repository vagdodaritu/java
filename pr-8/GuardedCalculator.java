import java.util.InputMismatchException;
import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException() { super("Cannot divide by zero."); }
}

public class GuardedCalculator {
    static double calculate(double a, double b, char op) throws DivideByZeroException {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new DivideByZeroException();
                return a / b;
            default: throw new IllegalArgumentException("Invalid operator.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter two numbers: ");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                System.out.print("Enter operator (+ - * /): ");
                char op = sc.next().charAt(0);
                System.out.println("Result: " + calculate(a, b, op));
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number input. Please try again.");
                sc.nextLine();
            } catch (DivideByZeroException | IllegalArgumentException e) {
                System.out.println("Calculation error: " + e.getMessage());
            } finally {
                System.out.println("Calculation attempt logged.");
            }
        }
        sc.close();
    }
}