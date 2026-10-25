public class BoundedStats {
    static <N extends Number> double average(N[] values) {
        if (values.length == 0) return 0;
        double total = 0;
        for (N value : values) total += value.doubleValue();
        return total / values.length;
    }
    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30};
        Double[] decimals = {2.5, 3.5, 4.0};
        Long[] longs = {100L, 200L, 300L};
        System.out.println("Integer average: " + average(integers));
        System.out.println("Double average: " + average(decimals));
        System.out.println("Long average: " + average(longs));
    }
}