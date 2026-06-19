// File: NetworkToolRunner.java
// Runs installed command-line tools and saves output to tool_report.txt.
import java.io.*;
import java.util.*;

public class NetworkToolRunner {
    public static void main(String[] args) throws Exception {
        // Define the commands to run
        // Note: Windows uses "ping -n 4" while Linux/Mac use "ping -c 4"
        String[][] tools = {
            {"ping", "-n", "4", "8.8.8.8"},  // Windows version
            {"netstat", "-an"}
        };

        PrintWriter report = new PrintWriter(new FileWriter("tool_report.txt"));

        for (String[] cmd : tools) {
            report.println("===== " + cmd[0].toUpperCase() + " =====");
            try {
                Process p = new ProcessBuilder(cmd).redirectErrorStream(true).start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    report.println(line);
                }
                p.waitFor(); // Wait for the command to finish
            } catch (Exception e) {
                report.println("Could not run " + cmd[0] + ": " + e.getMessage());
            }
            report.println(); // Add a blank line between commands
        }

        report.close();
        System.out.println("Report saved to tool_report.txt");
    }
}