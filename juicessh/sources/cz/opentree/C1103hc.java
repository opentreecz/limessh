package cz.opentree;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.hc */
/* loaded from: classes.dex */
public class C1103hc {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    /* renamed from: a */
    public static String m4429a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: b */
    public static Map<String, String> m4430b(URI uri, String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new HashMap<>();
            Scanner scanner = new Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                String[] split = scanner.next().split(SimpleComparison.EQUAL_TO_OPERATION);
                if (split.length == 0 || split.length > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                String m4429a = m4429a(split[0], str);
                String str2 = null;
                if (split.length == 2) {
                    str2 = m4429a(split[1], str);
                }
                emptyMap.put(m4429a, str2);
            }
        }
        return emptyMap;
    }
}
