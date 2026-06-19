// File: UrlUriClassifier.java
import java.net.*;
import java.util.Scanner;

public class UrlUriClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========== URL vs URI CLASSIFIER ==========");
        System.out.println("Enter resource identifiers to classify.");
        System.out.println("Press Enter (empty line) to exit.");
        System.out.println();

        while (true) {
            System.out.print("Input: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Exiting...");
                break;
            }

            try {
                // First, try to parse as a URI
                URI uri = new URI(input);
                
                // Then, try to convert to URL
                try {
                    URL url = uri.toURL();
                    System.out.println("  Classification: URL and URI");
                    System.out.println("  Scheme: " + url.getProtocol());
                    System.out.println("  Host: " + url.getHost());
                } catch (MalformedURLException e) {
                    System.out.println("  Classification: URI but NOT a URL");
                    System.out.println("  Scheme: " + uri.getScheme());
                }
            } catch (URISyntaxException e) {
                System.out.println("  Classification: INVALID URI/URL");
            }
            System.out.println();
        }
        sc.close();
    }
}