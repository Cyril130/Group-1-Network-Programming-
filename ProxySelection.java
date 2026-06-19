// File: ProxySelection.java
import java.net.*;
import java.util.*;

public class ProxySelection {
    public static void main(String[] args) throws Exception {
        // Define local websites (direct connection)
        Set<String> local = Set.of("localhost", "127.0.0.1", "jkuat.ac.ke");
        
        // Define blocked websites
        Set<String> blocked = Set.of("blockedsite.com", "malware.example");

        Scanner sc = new Scanner(System.in);
        System.out.println("========== PROXY SELECTION SIMULATION ==========");
        System.out.print("URL: ");
        String input = sc.nextLine().trim();

        // Parse the URL to extract host
        URI uri = new URI(input);
        String host = uri.getHost();

        System.out.println();
        System.out.println("Host: " + host);
        System.out.println("----------------------------------------");

        // Decision logic
        if (host == null) {
            System.out.println("Decision: Invalid URL");
        } else if (blocked.stream().anyMatch(host::contains)) {
            System.out.println("Decision: Access denied");
        } else if (local.contains(host) || host.endsWith(".local")) {
            System.out.println("Decision: Direct connection");
        } else {
            System.out.println("Decision: Use proxy");
        }

        sc.close();
    }
}