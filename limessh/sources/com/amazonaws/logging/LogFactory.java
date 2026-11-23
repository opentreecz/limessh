package com.amazonaws.logging;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LogFactory {

    /* renamed from: a */
    public static final String f172a = "LogFactory";

    /* renamed from: b */
    public static Level f173b;

    /* renamed from: c */
    public static Map<String, Log> f174c = new HashMap();

    /* loaded from: classes.dex */
    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);


        /* renamed from: O */
        public int f183O;

        Level(int i) {
            this.f183O = i;
        }

        /* renamed from: f */
        public int m240f() {
            return this.f183O;
        }
    }

    /* renamed from: a */
    public static boolean m235a() {
        try {
            Class.forName("org.apache.commons.logging.LogFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e) {
            android.util.Log.e(f172a, e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public static Level m236b() {
        return f173b;
    }

    /* renamed from: c */
    public static synchronized Log m237c(Class cls) {
        Log m238d;
        synchronized (LogFactory.class) {
            m238d = m238d(m239e(cls.getSimpleName()));
        }
        return m238d;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0011, B:12:0x0017, B:15:0x001c, B:19:0x0028, B:9:0x0032), top: B:3:0x0003 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.amazonaws.logging.Log m238d(java.lang.String r6) {
        /*
            java.lang.Class<com.amazonaws.logging.LogFactory> r0 = com.amazonaws.logging.LogFactory.class
            monitor-enter(r0)
            java.lang.String r6 = m239e(r6)     // Catch: java.lang.Throwable -> L3e
            java.util.Map<java.lang.String, com.amazonaws.logging.Log> r1 = com.amazonaws.logging.LogFactory.f174c     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L3e
            com.amazonaws.logging.Log r1 = (com.amazonaws.logging.Log) r1     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L3c
            boolean r2 = m235a()     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L30
            com.amazonaws.logging.ApacheCommonsLogging r2 = new com.amazonaws.logging.ApacheCommonsLogging     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3e
            r2.<init>(r6)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3e
            java.util.Map<java.lang.String, com.amazonaws.logging.Log> r1 = com.amazonaws.logging.LogFactory.f174c     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L3e
            r1.put(r6, r2)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L3e
            goto L2f
        L22:
            r1 = move-exception
            goto L28
        L24:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L28:
            java.lang.String r3 = com.amazonaws.logging.LogFactory.f172a     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Could not create log from org.apache.commons.logging.LogFactory"
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3e
        L2f:
            r1 = r2
        L30:
            if (r1 != 0) goto L3c
            com.amazonaws.logging.AndroidLog r1 = new com.amazonaws.logging.AndroidLog     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3e
            java.util.Map<java.lang.String, com.amazonaws.logging.Log> r2 = com.amazonaws.logging.LogFactory.f174c     // Catch: java.lang.Throwable -> L3e
            r2.put(r6, r1)     // Catch: java.lang.Throwable -> L3e
        L3c:
            monitor-exit(r0)
            return r1
        L3e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.logging.LogFactory.m238d(java.lang.String):com.amazonaws.logging.Log");
    }

    /* renamed from: e */
    public static String m239e(String str) {
        if (str.length() <= 23) {
            return str;
        }
        if (m235a()) {
            new ApacheCommonsLogging(f172a).mo231g("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        } else {
            android.util.Log.w(f172a, "Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        }
        return str.substring(0, 23);
    }
}
