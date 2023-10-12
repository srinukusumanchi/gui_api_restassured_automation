/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-09-01
 * Created Time: 1:00 p.m.
 */

package bns.a6.microui.api.headers;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Builder(setterPrefix = "set")
@Getter
public class OpenAMHeaders {

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }
}
