// File: RelativeUrlResolver.java
import java.net.*;
import java.util.Scanner;

public class RelativeUrlResolver {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== RELATIVE URL RESOLVER ==========");
        System.out.println();

        System.out.print("Base URL: ");
        URL base = new URL(sc.nextLine().trim());

        System.out.print("Relative URL: ");
        String rel = sc.nextLine().trim();

        // Resolves relative URL against base URL
        URL absolute = new URL(base, rel);

        System.out.println();
        System.out.println("Resolved Absolute URL: " + absolute);

        sc.close();
    }
}