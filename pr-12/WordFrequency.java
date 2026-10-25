import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "java is useful and java is popular and useful";
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : paragraph.toLowerCase().split("\\W+"))
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        List<Map.Entry<String, Integer>> words = new ArrayList<>(frequency.entrySet());
        words.sort((a, b) -> {
            int byCount = b.getValue().compareTo(a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });
        System.out.println("Word frequencies (highest first):");
        for (Map.Entry<String, Integer> entry : words)
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}