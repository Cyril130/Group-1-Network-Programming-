// File: HelpdeskJava.java
// Run server: java HelpdeskJava server
// Run client: java HelpdeskJava client
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HelpdeskJava {
    static final String HOST = "127.0.0.1";
    static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equalsIgnoreCase("server"))
            runServer();
        else
            runClient();
    }

    static void runServer() throws IOException {
        // ServerSocket creates a TCP server that listens for client requests.
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Helpdesk server listening on port " + PORT);
        int ticket = 1;
        while (true) {
            // accept() waits until a client connects.
            Socket socket = server.accept();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String request = in.readLine();
                System.out.println("Received: " + request);
                out.println(String.format("Request received. Ticket number: HD%03d", ticket++));
            }
        }
    }

    static void runClient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Registration number: ");
        String reg = sc.nextLine();
        System.out.print("Issue: ");
        String issue = sc.nextLine();
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println(reg + ": " + issue); // Send helpdesk request.
            System.out.println(in.readLine()); // Read server confirmation.
        } catch (IOException e) {
            System.out.println("Server unreachable: " + e.getMessage());
        }
    }
}