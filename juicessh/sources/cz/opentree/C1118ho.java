package cz.opentree;

import com.google.android.gms.internal.measurement.zzgt;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.ho */
/* loaded from: classes.dex */
public class C1118ho {

    /* renamed from: a */
    public volatile zzgt f3185a;

    /* renamed from: b */
    public volatile AbstractC1939tm f3186b;

    static {
        C1466kn.m5954a();
    }

    /* renamed from: a */
    public final zzgt m4579a(zzgt zzgtVar) {
        zzgt zzgtVar2 = this.f3185a;
        this.f3186b = null;
        this.f3185a = zzgtVar;
        return zzgtVar2;
    }

    /* renamed from: b */
    public final int m4580b() {
        if (this.f3186b != null) {
            return this.f3186b.mo2150f();
        }
        if (this.f3185a != null) {
            return this.f3185a.mo1267j();
        }
        return 0;
    }

    /* renamed from: c */
    public final zzgt m4581c(zzgt zzgtVar) {
        if (this.f3185a == null) {
            synchronized (this) {
                if (this.f3185a == null) {
                    try {
                        this.f3185a = zzgtVar;
                        this.f3186b = AbstractC1939tm.f6790P;
                    } catch (C0839co unused) {
                        this.f3185a = zzgtVar;
                        this.f3186b = AbstractC1939tm.f6790P;
                    }
                }
            }
        }
        return this.f3185a;
    }

    /* renamed from: d */
    public final AbstractC1939tm m4582d() {
        if (this.f3186b != null) {
            return this.f3186b;
        }
        synchronized (this) {
            if (this.f3186b != null) {
                return this.f3186b;
            }
            if (this.f3185a == null) {
                this.f3186b = AbstractC1939tm.f6790P;
            } else {
                this.f3186b = this.f3185a.mo1265g();
            }
            return this.f3186b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1118ho)) {
            return false;
        }
        C1118ho c1118ho = (C1118ho) obj;
        zzgt zzgtVar = this.f3185a;
        zzgt zzgtVar2 = c1118ho.f3185a;
        return (zzgtVar == null && zzgtVar2 == null) ? m4582d().equals(c1118ho.m4582d()) : (zzgtVar == null || zzgtVar2 == null) ? zzgtVar != null ? zzgtVar.equals(c1118ho.m4581c(zzgtVar.mo1269e())) : m4581c(zzgtVar2.mo1269e()).equals(zzgtVar2) : zzgtVar.equals(zzgtVar2);
    }

    public int hashCode() {
        return 1;
    }
}
