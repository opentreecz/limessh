package cz.opentree;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v00 {

    /* renamed from: a */
    public final Context f7372a;

    /* renamed from: b */
    public String f7373b;

    /* renamed from: c */
    public String f7374c;

    /* renamed from: d */
    public String f7375d;

    /* renamed from: e */
    public Boolean f7376e;

    /* renamed from: f */
    public long f7377f;

    /* renamed from: g */
    public zzaa f7378g;

    /* renamed from: h */
    public boolean f7379h;

    /* renamed from: i */
    public Long f7380i;

    public v00(Context context, zzaa zzaaVar, Long l) {
        this.f7379h = true;
        C0813ca.m2729k(context);
        Context applicationContext = context.getApplicationContext();
        C0813ca.m2729k(applicationContext);
        this.f7372a = applicationContext;
        this.f7380i = l;
        if (zzaaVar != null) {
            this.f7378g = zzaaVar;
            this.f7373b = zzaaVar.f970T;
            this.f7374c = zzaaVar.f969S;
            this.f7375d = zzaaVar.f968R;
            this.f7379h = zzaaVar.f967Q;
            this.f7377f = zzaaVar.f966P;
            Bundle bundle = zzaaVar.f971U;
            if (bundle != null) {
                this.f7376e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
