import java.util.List;

public class Main {
    public static void main(String[] args) {

        Server server = new Server(9999, 64);

        final var validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");

        server.startServer(validPaths);

    }
}
