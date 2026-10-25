import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = {"riya", "amit", "neha", "riya", "karan", "amit", "isha"};
        Set<String> unique = new HashSet<>(Arrays.asList(logins));
        Set<String> firstSeen = new LinkedHashSet<>(Arrays.asList(logins));
        System.out.println("Unique visitor count: " + unique.size());
        System.out.println("First three distinct visitors:");
        int count = 0;
        for (String name : firstSeen) {
            if (count == 3) break;
            System.out.println(name); count++;
        }
    }
}