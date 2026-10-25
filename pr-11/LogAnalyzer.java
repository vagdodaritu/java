import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.stream.Stream;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Path folder = Path.of("logs");
        Files.createDirectories(folder);
        Files.writeString(folder.resolve("app1.txt"), "INFO started\nERROR failed to connect\nINFO retry\n");
        Files.writeString(folder.resolve("app2.txt"), "INFO ready\nERROR timeout\n");
        String keyword = "ERROR";
        int totalLines = 0, matches = 0;
        try (DirectoryStream<Path> files = Files.newDirectoryStream(folder, "*.txt")) {
            for (Path file : files) {
                BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                System.out.println(file.getFileName() + " size=" + attr.size() + " bytes");
                try (Stream<String> lines = Files.lines(file)) {
                    for (String line : (Iterable<String>) lines::iterator) {
                        totalLines++;
                        if (line.contains(keyword)) matches++;
                    }
                }
            }
        }
        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": " + matches);
    }
}