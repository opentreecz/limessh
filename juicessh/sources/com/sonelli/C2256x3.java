package com.sonelli;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.analytics.ExceptionParser;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* renamed from: com.sonelli.x3 */
/* loaded from: classes.dex */
public class C2256x3 implements ExceptionParser {

    /* renamed from: a */
    public final TreeSet<String> f7862a = new TreeSet<>();

    public C2256x3(Context context, Collection<String> collection) {
        m9685e(context, collection);
    }

    @Override // com.google.android.gms.analytics.ExceptionParser
    /* renamed from: a */
    public String mo812a(String str, Throwable th) {
        return m9684d(m9683c(th), m9682b(m9683c(th)), str);
    }

    /* renamed from: b */
    public StackTraceElement m9682b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.f7862a.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    /* renamed from: c */
    public Throwable m9683c(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* renamed from: d */
    public String m9684d(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            sb.append(String.format(" (@%s:%s:%s)", (split == null || split.length <= 0) ? EnvironmentCompat.MEDIA_UNKNOWN : split[split.length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        if (str != null) {
            sb.append(String.format(" {%s}", str));
        }
        return sb.toString();
    }

    /* renamed from: e */
    public void m9685e(Context context, Collection<String> collection) {
        this.f7862a.clear();
        HashSet<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            hashSet.add(context.getApplicationContext().getPackageName());
        }
        for (String str : hashSet) {
            boolean z = true;
            Iterator<String> it = this.f7862a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str.startsWith(next)) {
                    z = false;
                } else if (next.startsWith(str)) {
                    this.f7862a.remove(next);
                }
            }
            if (z) {
                this.f7862a.add(str);
            }
        }
    }
}
