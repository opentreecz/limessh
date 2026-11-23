package cz.opentree;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.il */
/* loaded from: classes.dex */
public final class C1165il {

    /* renamed from: a */
    public final Map<String, Map<String, String>> f3337a;

    public C1165il(Map<String, Map<String, String>> map) {
        this.f3337a = map;
    }

    @Nullable
    /* renamed from: a */
    public final String m4794a(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map<String, String> map = this.f3337a.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str2);
            String valueOf2 = String.valueOf(str3);
            str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return map.get(str3);
    }
}
