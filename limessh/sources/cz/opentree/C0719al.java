package cz.opentree;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.al */
/* loaded from: classes.dex */
public class C0719al {

    /* renamed from: f */
    public static HashMap<String, String> f1439f;

    /* renamed from: k */
    public static Object f1444k;

    /* renamed from: l */
    public static boolean f1445l;

    /* renamed from: a */
    public static final Uri f1434a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b */
    public static final Uri f1435b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c */
    public static final Pattern f1436c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d */
    public static final Pattern f1437d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e */
    public static final AtomicBoolean f1438e = new AtomicBoolean();

    /* renamed from: g */
    public static final HashMap<String, Boolean> f1440g = new HashMap<>();

    /* renamed from: h */
    public static final HashMap<String, Integer> f1441h = new HashMap<>();

    /* renamed from: i */
    public static final HashMap<String, Long> f1442i = new HashMap<>();

    /* renamed from: j */
    public static final HashMap<String, Float> f1443j = new HashMap<>();

    /* renamed from: m */
    public static String[] f1446m = new String[0];

    /* renamed from: a */
    public static String m2141a(ContentResolver contentResolver, String str, String str2) {
        synchronized (C0719al.class) {
            if (f1439f == null) {
                f1438e.set(false);
                f1439f = new HashMap<>();
                f1444k = new Object();
                f1445l = false;
                contentResolver.registerContentObserver(f1434a, true, new C2431zk(null));
            } else if (f1438e.getAndSet(false)) {
                f1439f.clear();
                f1440g.clear();
                f1441h.clear();
                f1442i.clear();
                f1443j.clear();
                f1444k = new Object();
                f1445l = false;
            }
            Object obj = f1444k;
            if (f1439f.containsKey(str)) {
                String str3 = f1439f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : f1446m) {
                if (str.startsWith(str4)) {
                    if (!f1445l || f1439f.isEmpty()) {
                        f1439f.putAll(m2142b(contentResolver, f1446m));
                        f1445l = true;
                        if (f1439f.containsKey(str)) {
                            String str5 = f1439f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(f1434a, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    m2144d(obj, str, null);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                m2144d(obj, str, string);
                String str6 = string != null ? string : null;
                if (query != null) {
                    query.close();
                }
                return str6;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    /* renamed from: b */
    public static Map<String, String> m2142b(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f1435b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    /* renamed from: d */
    public static void m2144d(Object obj, String str, String str2) {
        synchronized (C0719al.class) {
            if (obj == f1444k) {
                f1439f.put(str, str2);
            }
        }
    }
}
