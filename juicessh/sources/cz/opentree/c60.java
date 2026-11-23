package cz.opentree;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* loaded from: classes.dex */
public final class c60 implements DataLayer.zzb {

    /* renamed from: a */
    public final Context f1874a;

    public c60(Context context) {
        this.f1874a = context;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzb
    /* renamed from: a */
    public final void mo1531a(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get("url");
        }
        if (obj2 == null || !(obj2 instanceof String) || (queryParameter = Uri.parse((String) obj2).getQueryParameter("referrer")) == null) {
            return;
        }
        u50.m8853b(this.f1874a, queryParameter);
    }
}
