// File: ProtectedPageSimulation.java
import java.util.*;

public class ProtectedPageSimulation {
    public static void main(String[] args) {
        // Store username-password pairs
        Map<String, String> users = Map.of(
            "admin", "admin123",
            "student", "net2026",
            "lecturer", "teach456"
        );

        // Prompt for credentials
        Scanner sc = new Scanner(System.in);
        System.out.println("========== PROTECTED PAGE SIMULATION ==========");
        System.out.print("Username: ");
        String u = sc.nextLine().trim();
        System.out.print("Password: ");
        String p = sc.nextLine().trim();

        // Validate credentials and display content
        if (users.containsKey(u) && users.get(u).equals(p)) {
            System.out.println("\n✅ Authentication successful!");
            System.out.println("========================================");
            System.out.println("Welcome to the Internal Portal, " + u + "!");
            System.out.println("========================================");
            System.out.println("Protected Resources Available:");
            System.out.println("  1. Lecture Notes");
            System.out.println("  2. Lab Exercises");
            System.out.println("  3. Assignment Submissions");
            System.out.println("  4. Past Exam Papers");
            System.out.println("  5. Course Syllabus");
            System.out.println("========================================");
        } else {
            System.out.println("\n❌ Access denied.");
            System.out.println("Invalid username or password.");
        }

        sc.close();
    }
}