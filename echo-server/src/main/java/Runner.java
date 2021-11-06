import com.gmail.elbaglikov.Server;

public class Runner {
    public static void main(String[] args) {
        final int PORT_NUMBER = 8080;
        Server server = new Server(PORT_NUMBER);
        Thread serverStarter = new Thread(server);
        serverStarter.start();
    }
}
