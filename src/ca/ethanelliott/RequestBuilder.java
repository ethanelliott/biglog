package ca.ethanelliott;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestBuilder {
    static Request from(List<String> reqList) {
        reqList.remove(reqList.size() - 1);
        List<String> main = Arrays.stream(reqList.remove(0).split(" ")).collect(Collectors.toList());
        HTTPMethod method = ParseMethod.from(main.get(0));
        String route = main.get(1);
        String httpVersion = main.get(2);
        Map<String, String> headers = new HashMap<>();
        reqList.forEach(e -> {
            List<String> hkv = Arrays.stream(e.split(": ")).collect(Collectors.toList());
            headers.put(hkv.get(0), hkv.get(1));
        });
        return new Request(method, route, httpVersion, headers);
    }
}
