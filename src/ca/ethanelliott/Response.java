package ca.ethanelliott;

import java.util.Map;

public class Response {
    private final String protocolVersion = "HTTP/1.1";
    public String statusCode;
    public String statusMessage;
    public String body;
    public Map<String, String> headers;

    public Response(String statusCode, String statusMessage, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(protocolVersion).append(" ").append(statusCode).append(" ").append(statusMessage);
        this.headers.forEach((s1, s2) -> s.append("\r\n").append(s1).append(": ").append(s2));
        s.append("\r\n\r\n").append(body);
        return s.append("\r\n").toString();
    }
}
