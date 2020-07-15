package ca.ethanelliott;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(8887);
        System.out.println("Listening for connection on port 8887 ....");
        while (!server.isClosed()) {
            try (Socket socket = server.accept()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ArrayList<String> r = new ArrayList<>();
                String line = "";
                while (bufferedReader.ready() && (line = bufferedReader.readLine()) != null) {
                    r.add(line);
                }
                if (r.size() > 0) {
                    Request req = RequestBuilder.from(r);
                    System.out.println(req);
                    String httpResponse = ResponseBuilder.start()
                            .withCode("200")
                            .withHeader("Content-Type", "text/json; charset=utf-8")
                            .withBody("{\"YO\":\"TEST\"}")
                            .build().toString();
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                } else {
                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                }

            }
        }
    }
}
