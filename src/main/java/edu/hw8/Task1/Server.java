package edu.hw8.Task1;

import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final int PORT = 6666;
    private ExecutorService threadPool = Executors.newFixedThreadPool(8);
    private ByteBuffer buffer = ByteBuffer.allocate(256);

    private static String searchQuote(String word) {
        return switch (word) {
            case "personal" -> "Don't get personal where there are none";
            case "insults" -> "If your opponents have turned to personal insults, your victory is not far off.";
            case "stupid" -> "Did I tell you that you're stupid? Well, I take it back... You're just a god of idiocy.";
            case "intelligence" -> "The lower the intelligence, the louder the insults.";
            default -> "There is no quote with this word.";
        };
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(6666);

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

        public Worker(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
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
