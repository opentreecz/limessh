package cz.opentree;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.m5 */
/* loaded from: classes.dex */
public class C1538m5 {

    /* renamed from: b */
    public static int f4985b = 31;

    /* renamed from: a */
    public int f4986a = 1;

    /* renamed from: a */
    public C1538m5 m6369a(Object obj) {
        this.f4986a = (f4985b * this.f4986a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    /* renamed from: b */
    public int m6370b() {
        return this.f4986a;
    }

    /* renamed from: c */
    public final C1538m5 m6371c(boolean z) {
        this.f4986a = (f4985b * this.f4986a) + (z ? 1 : 0);
        return this;
    }
}
