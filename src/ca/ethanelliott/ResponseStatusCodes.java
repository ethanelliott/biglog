package ca.ethanelliott;

import java.util.HashMap;
import java.util.Map;

public class ResponseStatusCodes {
    private static final Map<String, String> statusTextMap = new HashMap<>(){{
        put("100", "CONTINUE");
        put("200", "OK");
        put("201", "CREATED");
        put("202", "ACCEPTED");
        put("204", "NO CONTENT");
        put("404", "NOT FOUND");
    }};
    public static Map<String, String> get() {
        return statusTextMap;
    }
}
