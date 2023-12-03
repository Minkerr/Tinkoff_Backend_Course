package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void givenClient1_whenServerResponds_thenCorrect() throws IOException, InterruptedException {
        Server server = new Server();
        Thread serv = new Thread(() -> {
            try {
                server.start(6666);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Thread cl = new Thread(() -> {
            Client client1 = new Client();
            try {
                client1.startConnection("localhost", 6666);
                String msg1 = client1.sendMessage("personal");
                String msg2 = client1.sendMessage("stupid");
                String msgEx = client1.sendMessage("!exit");
                assertEquals(msg1, "Don't get personal where there are none");
                assertEquals(msg2, "Did I tell you that you're stupid? Well, I take it back..." +
                    " You're just a god of idiocy.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Thread close = new Thread(() -> {
            try {
                Thread.sleep(1000);
                server.stop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        serv.start();
        cl.start();
        Thread.sleep(200);
        close.start();

        try {
            serv.join();
            cl.join();
            close.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
/*
    @Test
    public void givenClient_whenServerResponds_thenCorrect()
        throws IOException, ExecutionException, InterruptedException {
        Server server = new Server();
        server.start(6666);

        ExecutorService service = Executors.newFixedThreadPool(4);
        Callable<String> task = () -> {
            Client client = new Client();
            client.startConnection("localhost", 6666);
            String msg = client.sendMessage("personal");
            client.stopConnection();
            //System.out.println(Thread.currentThread().getName());
            return msg;
        };
        for (int i = 0; i < 20; i++) {
            int messageNumber = i;
            Future result = service.submit(task);
            assertThat(result.get()).isEqualTo("Don't get personal where there are none");
        }

        service.shutdown();
        server.stop();
    }
*/
}

