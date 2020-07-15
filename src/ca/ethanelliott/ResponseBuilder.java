package ca.ethanelliott;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {
    private String statusCode;
    private String body;
    private final Map<String, String> headers = new HashMap<>();

    public static ResponseBuilder start() {
        return new ResponseBuilder();
    }

    public Response build() {
        return new Response(this.statusCode, ResponseStatusCodes.get().get(this.statusCode), this.body, this.headers);
    }

    private ResponseBuilder() {
    }

    public ResponseBuilder withCode(String code) {
        this.statusCode = code;
        return this;
    }

    public ResponseBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public ResponseBuilder withHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }
}
