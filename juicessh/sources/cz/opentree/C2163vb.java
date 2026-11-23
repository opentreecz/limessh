package cz.opentree;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.vb */
/* loaded from: classes.dex */
public class C2163vb {
    /* renamed from: a */
    public static String m9207a(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Nullable
    /* renamed from: b */
    public static List<String> m9208b(@Nullable List<String> list) {
        if (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) {
            return null;
        }
        return list;
    }

    @Nullable
    /* renamed from: c */
    public static String m9209c(String str) {
        if ("com.google.android.gms".equals(str)) {
            return null;
        }
        return str;
    }
}
