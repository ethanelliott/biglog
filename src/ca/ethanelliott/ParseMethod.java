package ca.ethanelliott;

public class ParseMethod {
    public static HTTPMethod from(String method) {
        return switch (method) {
            case "GET" -> HTTPMethod.GET;
            case "POST" -> HTTPMethod.POST;
            default -> null;
        };
    }
}
