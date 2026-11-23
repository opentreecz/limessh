package cz.opentree;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.vm */
/* loaded from: classes.dex */
public final class C2179vm extends AbstractC2301xm {

    /* renamed from: O */
    public int f7516O = 0;

    /* renamed from: P */
    public final int f7517P;

    /* renamed from: Q */
    public final /* synthetic */ AbstractC1939tm f7518Q;

    public C2179vm(AbstractC1939tm abstractC1939tm) {
        this.f7518Q = abstractC1939tm;
        this.f7517P = abstractC1939tm.mo2150f();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    /* renamed from: a */
    public final byte mo1225a() {
        int i = this.f7516O;
        if (i >= this.f7517P) {
            throw new NoSuchElementException();
        }
        this.f7516O = i + 1;
        return this.f7518Q.mo2155o(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7516O < this.f7517P;
    }
}
