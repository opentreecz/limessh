package cz.opentree;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import java.util.Map;

/* loaded from: classes.dex */
public final class d60 implements DataLayer.zzb {

    /* renamed from: a */
    public final /* synthetic */ TagManager f2135a;

    public d60(TagManager tagManager) {
        this.f2135a = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzb
    /* renamed from: a */
    public final void mo1531a(Map<String, Object> map) {
        Object obj = map.get(NotificationCompat.CATEGORY_EVENT);
        if (obj != null) {
            this.f2135a.m1539f(obj.toString());
        }
    }
}
