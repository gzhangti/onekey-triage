package if12.onekey_triage.utils;

import static com.google.common.base.Strings.emptyToNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class LogEventHelper {
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(LogEventHelper.class.getName());


	public static class UrlQueryBuilder {
    private Map<String, String> query = new HashMap();

    public static String toString(Map<String, String> queryParameters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> keyPair : queryParameters.entrySet()) {
            String key = keyPair.getKey();
            String value = keyPair.getValue();
            stringBuilder.append(key)
                    .append("=");
            try {
                String encodeKey = URLEncoder.encode(value, "UTF-8");
                //encode space(+ in x-www-form-urlencoded) as %20 so javascript decodeURIComponent can decode it
                encodeKey = encodeKey.replaceAll("\\+", "%20");
                stringBuilder.append(encodeKey).append("&");
            } catch (UnsupportedEncodingException e) {
                LOG.log(Level.SEVERE, "failed to encode key " + key, e);
            }
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
    public static boolean nonEmpty(String value) {
        return emptyToNull(value) != null;
    }

    public UrlQueryBuilder putIfAbsent(String key, String value) {
        if (nonEmpty(value) && !"null".equals(value)) {
            //Map.putIfAbsent was @since 1.8, use get and check null to check
            Object existValue = query.get(key);
            if (existValue == null) {
                query.put(key, value);
            }
        }
        return this;
    }

    public Map getQueryMap() {
        return Collections.unmodifiableMap(query);
    }

    public String build() {
        return UrlQueryBuilder.toString(this.query);
    }
}

}