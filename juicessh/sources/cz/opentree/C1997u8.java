package cz.opentree;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import cz.opentree.AbstractC1802r7;
import cz.opentree.C1848s7;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.u8 */
/* loaded from: classes.dex */
public final class C1997u8<A extends AbstractC1802r7<? extends Result, Api.AnyClient>> extends AbstractC1636o8 {

    /* renamed from: a */
    public final A f6925a;

    public C1997u8(int i, A a) {
        super(i);
        this.f6925a = a;
    }

    @Override // cz.opentree.AbstractC1636o8
    /* renamed from: b */
    public final void mo6881b(@NonNull Status status) {
        this.f6925a.m7887r(status);
    }

    @Override // cz.opentree.AbstractC1636o8
    /* renamed from: c */
    public final void mo6882c(@NonNull C0702a9 c0702a9, boolean z) {
        c0702a9.m2002b(this.f6925a, z);
    }

    @Override // cz.opentree.AbstractC1636o8
    /* renamed from: d */
    public final void mo6883d(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f6925a.m7887r(new Status(10, sb.toString()));
    }

    @Override // cz.opentree.AbstractC1636o8
    /* renamed from: f */
    public final void mo6884f(C1848s7.a<?> aVar) throws DeadObjectException {
        try {
            this.f6925a.m7885p(aVar.m8382l());
        } catch (RuntimeException e) {
            mo6883d(e);
        }
    }
}
