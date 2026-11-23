package com.sonelli;

import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.sonelli.AbstractC1142i4;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.sonelli.i4 */
/* loaded from: classes.dex */
public abstract class AbstractC1142i4<T extends AbstractC1142i4> {
    /* renamed from: a */
    public static String m4715a(Object obj) {
        return m4716b(obj, 0);
    }

    /* renamed from: b */
    public static String m4716b(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == ShadowDrawableWrapper.COS_45 ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object obj2 : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(m4716b(obj2, i + 1));
            }
            if (i > 0) {
                sb.append("]");
            }
            return sb.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        int i2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String m4716b = m4716b(entry.getValue(), i + 1);
            if (!TextUtils.isEmpty(m4716b)) {
                if (i > 0 && !z) {
                    sb2.append("{");
                    i2 = sb2.length();
                    z = true;
                }
                if (sb2.length() > i2) {
                    sb2.append(", ");
                }
                sb2.append((String) entry.getKey());
                sb2.append('=');
                sb2.append(m4716b);
            }
        }
        if (z) {
            sb2.append("}");
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m4717c(Map map) {
        return m4716b(map, 1);
    }

    /* renamed from: d */
    public abstract void mo4718d(T t);
}
