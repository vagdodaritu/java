import java.util.Scanner;

public class tollbooth {

 
    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number (or done): ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.nextLine().toLowerCase();

            // Create Vehicle
            Vehicle v = new Vehicle(number, type);

            int toll = 0;

            switch (v.type()) {

                case "bike":
                    toll = 20;
                    bikeCount++;
                    break;

                case "car":
                    toll = 50;
                    carCount++;
                    break;

                case "truck":
                    toll = 150;
                    truckCount++;
                    break;

                default:
                    System.out.println("Invalid vehicle type!");
                    break;
            }

            totalToll = totalToll + toll;
        }

        
        String mostFrequent;

        if (carCount >= bikeCount && carCount >= truckCount) {
            mostFrequent = "car";
        }
        else if (bikeCount >= carCount && bikeCount >= truckCount) {
            mostFrequent = "bike";
        }
        else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}
