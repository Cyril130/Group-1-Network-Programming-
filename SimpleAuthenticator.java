// File: SimpleAuthenticator.java
import java.util.*;

public class SimpleAuthenticator {
    public static void main(String[] args) {
        // Store username-password pairs
        Map<String, String> users = new HashMap<>();
        users.put("admin", "admin123");
        users.put("student", "net2026");
        users.put("lecturer", "teach456");

        // Prompt for credentials
        Scanner sc = new Scanner(System.in);
        System.out.println("========== AUTHENTICATION SYSTEM ==========");
        System.out.print("Username: ");
        String u = sc.nextLine().trim();
        System.out.print("Password: ");
        String p = sc.nextLine().trim();

        // Validate credentials
        if (users.containsKey(u) && users.get(u).equals(p)) {
            System.out.println("Authentication successful ✅");
            System.out.println("Welcome, " + u + "!");
        } else {
            System.out.println("Authentication failed ❌");
        }

        sc.close();
    }
}