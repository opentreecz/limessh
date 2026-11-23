package com.sonelli;

import android.net.Uri;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public class x50 {

    /* renamed from: e */
    public static x50 f7876e;

    /* renamed from: a */
    public volatile EnumC2259a f7877a = EnumC2259a.NONE;

    /* renamed from: c */
    public volatile String f7879c = null;

    /* renamed from: b */
    public volatile String f7878b = null;

    /* renamed from: d */
    public volatile String f7880d = null;

    /* renamed from: com.sonelli.x50$a */
    /* loaded from: classes.dex */
    public enum EnumC2259a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    /* renamed from: c */
    public static String m9700c(String str) {
        return str.split("&")[0].split(SimpleComparison.EQUAL_TO_OPERATION)[1];
    }

    /* renamed from: d */
    public static x50 m9701d() {
        x50 x50Var;
        synchronized (x50.class) {
            if (f7876e == null) {
                f7876e = new x50();
            }
            x50Var = f7876e;
        }
        return x50Var;
    }

    /* renamed from: a */
    public final String m9702a() {
        return this.f7878b;
    }

    /* renamed from: b */
    public final synchronized boolean m9703b(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    String valueOf = String.valueOf(decode);
                    v50.m9167b(valueOf.length() != 0 ? "Invalid preview uri: ".concat(valueOf) : new String("Invalid preview uri: "));
                    return false;
                }
                if (!m9700c(uri.getQuery()).equals(this.f7878b)) {
                    return false;
                }
                String valueOf2 = String.valueOf(this.f7878b);
                v50.m9166a(valueOf2.length() != 0 ? "Exit preview mode for container: ".concat(valueOf2) : new String("Exit preview mode for container: "));
                this.f7877a = EnumC2259a.NONE;
                this.f7879c = null;
                return true;
            }
            String valueOf3 = String.valueOf(decode);
            v50.m9166a(valueOf3.length() != 0 ? "Container preview url: ".concat(valueOf3) : new String("Container preview url: "));
            if (decode.matches(".*?&gtm_debug=x$")) {
                this.f7877a = EnumC2259a.CONTAINER_DEBUG;
            } else {
                this.f7877a = EnumC2259a.CONTAINER;
            }
            this.f7880d = uri.getQuery().replace("&gtm_debug=x", "");
            if (this.f7877a == EnumC2259a.CONTAINER || this.f7877a == EnumC2259a.CONTAINER_DEBUG) {
                String valueOf4 = String.valueOf(this.f7880d);
                this.f7879c = valueOf4.length() != 0 ? "/r?".concat(valueOf4) : new String("/r?");
            }
            this.f7878b = m9700c(this.f7880d);
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* renamed from: e */
    public final EnumC2259a m9704e() {
        return this.f7877a;
    }

    /* renamed from: f */
    public final String m9705f() {
        return this.f7879c;
    }
}
