package ca.ethanelliott;

import java.util.Map;

public class Request {
    public HTTPMethod method;
    public String route;
    public String httpVersion;
    public Map<String, String> headers;

    public Request(HTTPMethod method, String route, String httpVersion, Map<String, String> headers) {
        this.method = method;
        this.route = route;
        this.httpVersion = httpVersion;
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request: " + this.method + " " + this.route;
    }
}
