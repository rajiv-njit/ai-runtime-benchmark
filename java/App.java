import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/infer", new InferHandler());
        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
        System.out.println("Java server running on port 8080");
    }

    static class InferHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = simulateInference();
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static String simulateInference() {
        long sum = 0;
        for (int i = 0; i < 5_000_000; i++) {
            sum += i;
        }
        return "{\"result\":\"ok\"}";
    }
}
