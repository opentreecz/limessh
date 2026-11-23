package cz.opentree;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import cz.opentree.C1848s7;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.w8 */
/* loaded from: classes.dex */
public final class C2204w8 extends AbstractC2158v8<Boolean> {

    /* renamed from: b */
    public final C2155v7<?> f7629b;

    public C2204w8(C2155v7<?> c2155v7, k60<Boolean> k60Var) {
        super(4, k60Var);
        this.f7629b = c2155v7;
    }

    @Override // cz.opentree.AbstractC1636o8
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6882c(@NonNull C0702a9 c0702a9, boolean z) {
    }

    @Override // cz.opentree.AbstractC0915e8
    @Nullable
    /* renamed from: g */
    public final Feature[] mo3455g(C1848s7.a<?> aVar) {
        C1591n8 c1591n8 = aVar.m8390x().get(this.f7629b);
        if (c1591n8 == null) {
            return null;
        }
        return c1591n8.f5239a.m9724b();
    }

    @Override // cz.opentree.AbstractC0915e8
    /* renamed from: h */
    public final boolean mo3456h(C1848s7.a<?> aVar) {
        C1591n8 c1591n8 = aVar.m8390x().get(this.f7629b);
        if (c1591n8 == null) {
            return false;
        }
        c1591n8.f5239a.m9726d();
        throw null;
    }

    @Override // cz.opentree.AbstractC2158v8
    /* renamed from: i */
    public final void mo9195i(C1848s7.a<?> aVar) throws RemoteException {
        C1591n8 remove = aVar.m8390x().remove(this.f7629b);
        if (remove == null) {
            this.f7426a.m5846e(Boolean.FALSE);
        } else {
            remove.f5240b.m10395a(aVar.m8382l(), this.f7426a);
            remove.f5239a.m9723a();
        }
    }
}
