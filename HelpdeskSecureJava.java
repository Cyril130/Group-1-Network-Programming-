// File: HelpdeskSecureJava.java
// Demonstrates threads, validation, token security and logging.
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class HelpdeskSecureJava {
    static final int PORT = 5001;
    static final String TOKEN = "NET123";
    static int ticket = 1;

    static synchronized String nextTicket() {
        return String.format("HD%03d", ticket++);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Secure helpdesk server on port " + PORT);
        while (true) {
            new Thread(new Handler(server.accept())).start();
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 FileWriter log = new FileWriter("helpdesk_log.txt", true)) {
                String line = in.readLine();
                if (line == null || !line.startsWith(TOKEN + "|")) {
                    out.println("Rejected: invalid token");
                    return;
                }
                String request = line.substring((TOKEN + "|").length()).trim();
                if (request.length() < 5) {
                    out.println("Rejected: message too short");
                    return;
                }
                String no = nextTicket();
                log.write(LocalDateTime.now() + " " + no + " " + request + System.lineSeparator());
                out.println("Accepted. Ticket: " + no);
            } catch (IOException e) {
                System.out.println("Client error: " + e.getMessage());
            }
        }
    }
}