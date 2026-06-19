// File: ReachabilityReport.java
import java.io.*;
import java.net.*;
import java.util.*;

public class ReachabilityReport {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter report = new PrintWriter(new FileWriter("reachability_report.txt"));

        System.out.println("========== REACHABILITY TESTING TOOL ==========");
        System.out.println("Enter hosts/IPs to test. Press Enter (empty line) to exit and save report.");
        System.out.println();

        while (true) {
            System.out.print("Host: ");
            String host = sc.nextLine().trim();

            if (host.isEmpty()) {
                break;
            }

            long start = System.currentTimeMillis();
            boolean ok = false;
            String ip = "";

            try {
                InetAddress a = InetAddress.getByName(host);
                ip = a.getHostAddress();
                ok = a.isReachable(2000); // 2-second timeout
            } catch (Exception e) {
                ip = "not resolved";
            }

            long elapsed = System.currentTimeMillis() - start;

            // Write to report file
            report.println("Host: " + host);
            report.println("IP: " + ip);
            report.println("Status: " + (ok ? "Reachable" : "Unreachable"));
            report.println("Response time: " + elapsed + " ms");
            report.println();

            // Also display on screen
            System.out.println("  IP: " + ip);
            System.out.println("  Status: " + (ok ? "Reachable" : "Unreachable"));
            System.out.println("  Response time: " + elapsed + " ms");
            System.out.println();
        }

        report.close();
        System.out.println("Report saved to reachability_report.txt");
        sc.close();
    }
}