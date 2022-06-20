package dankook.play.studentcouncilhomepage.domain.auth;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class AuthorizationExtractor {

    public static final String AUTHORIZATION = "Authorization";
    public static final String ACCESS_TOKEN_TYPE = AuthorizationExtractor.class.getSimpleName() +
            ".ACCESS_TOKEN_TYPE";
    public static final String BEARER_TYPE = "Bearer";

    private AuthorizationExtractor() {
    }

    public static String extract(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(AUTHORIZATION);
        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            return checkValueStartsWithBearer(request, value);
        }
        return null;
    }

    public static String checkValueStartsWithBearer(HttpServletRequest request, String value) {
        if (value.toLowerCase().startsWith(BEARER_TYPE.toLowerCase())) {
            String authHeaderValue = value.substring(BEARER_TYPE.length()).trim();
            request.setAttribute(ACCESS_TOKEN_TYPE, value.substring(0, BEARER_TYPE.length()).trim());
            int commaIdx = authHeaderValue.indexOf(',');
            return updateAuthHeaderValue(authHeaderValue, commaIdx);
        }
        return null;
    }

    public static String updateAuthHeaderValue(String authHeaderValue, int commaIdx) {
        if (commaIdx > 0) {
            authHeaderValue = authHeaderValue.substring(0, commaIdx);
        }
        return authHeaderValue;
    }
}
