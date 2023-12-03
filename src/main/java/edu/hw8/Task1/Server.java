package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private final int port = 6666;
    private final ExecutorService threadPool = Executors.newFixedThreadPool(8);

    private static String searchQuote(String word) {
        return switch (word) {
            case "personal" -> "Don't get personal where there are none";
            case "insults" -> "If your opponents have turned to personal insults, your victory is not far off.";
            case "stupid" -> "Did I tell you that you're stupid? Well, I take it back... You're just a god of idiocy.";
            case "intelligence" -> "The lower the intelligence, the louder the insults.";
            default -> "There is no quote with this word.";
        };
    }

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(server.port);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            this.threadPool.execute(new Worker(serverSocket.accept()));
        }

    }

    public void stop() throws IOException {
        serverSocket.close();
        threadPool.shutdown();
    }

    private static class Worker implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        private Worker(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equals("!exit")) {
                        out.println("bye");
                        break;
                    }
                    out.println(searchQuote(inputLine));
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
