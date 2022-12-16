import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.*;

public class Server {

    int portNumber;
    int poolSize;
    private final ExecutorService threadPool;

    public Server(int portNumber, int poolSize) {
        this.poolSize = poolSize;
        this.portNumber = portNumber;
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket socket, List<String> validPaths) {
        ClientHandler clientHandler = new ClientHandler(socket, validPaths);
        threadPool.execute(clientHandler);
    }

    public void startServer(List<String> validPaths) {

        try (final var serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                final var socket = serverSocket.accept();
                handleClient(socket, validPaths);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
