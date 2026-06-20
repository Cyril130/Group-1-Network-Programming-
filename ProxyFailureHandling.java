// File: ProxyFailureHandling.java
import java.util.*;

public class ProxyFailureHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== PROXY FAILURE HANDLING ==========");
        System.out.print("Proxy host: ");
        String host = sc.nextLine().trim();

        System.out.print("Proxy port: ");
        int port = 0;
        try {
            port = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            port = -1; // Invalid port
        }

        System.out.print("URL: ");
        String url = sc.nextLine().trim();

        System.out.println();
        System.out.println("========== VALIDATION RESULTS ==========");

        // Validation logic
        if (host.isEmpty()) {
            System.out.println("❌ Error: proxy host cannot be empty");
        } else if (port <= 0 || port > 65535) {
            System.out.println("❌ Error: invalid port (must be between 1 and 65535)");
        } else if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            System.out.println("❌ Error: invalid URL (must start with http:// or https://)");
        } else if (url.contains("blockedsite.com") || url.contains("malware.example")) {
            System.out.println("❌ Error: blocked website");
        } else {
            System.out.println("✅ Proxy settings accepted");
            System.out.println("   Proxy Server: " + host + ":" + port);
            System.out.println("   Target URL: " + url);
        }

        sc.close();
    }
}