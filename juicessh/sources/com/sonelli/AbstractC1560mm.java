package com.sonelli;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgt;
import com.sonelli.AbstractC1464km;
import com.sonelli.AbstractC1560mm;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.mm */
/* loaded from: classes.dex */
public abstract class AbstractC1560mm<MessageType extends AbstractC1464km<MessageType, BuilderType>, BuilderType extends AbstractC1560mm<MessageType, BuilderType>> implements zzgs {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzgs
    /* renamed from: K */
    public final /* synthetic */ zzgs mo1258K(zzgt zzgtVar) {
        if (!mo1269e().getClass().isInstance(zzgtVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        mo6460k((AbstractC1464km) zzgtVar);
        return this;
    }

    public abstract /* synthetic */ Object clone() throws CloneNotSupportedException;

    /* renamed from: k */
    public abstract BuilderType mo6460k(MessageType messagetype);

    /* renamed from: l */
    public abstract BuilderType mo6461l(byte[] bArr, int i, int i2) throws C0839co;

    /* renamed from: m */
    public abstract BuilderType mo6462m(byte[] bArr, int i, int i2, C1466kn c1466kn) throws C0839co;

    @Override // com.google.android.gms.internal.measurement.zzgs
    /* renamed from: p */
    public final /* synthetic */ zzgs mo1261p(byte[] bArr, C1466kn c1466kn) throws C0839co {
        mo6462m(bArr, 0, bArr.length, c1466kn);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    /* renamed from: x */
    public final /* synthetic */ zzgs mo1262x(byte[] bArr) throws C0839co {
        mo6461l(bArr, 0, bArr.length);
        return this;
    }
}
