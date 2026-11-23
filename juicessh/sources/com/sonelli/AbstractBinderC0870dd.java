package com.sonelli;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.dd */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0870dd extends AbstractBinderC0763bd {

    /* renamed from: c */
    public static final WeakReference<byte[]> f2153c = new WeakReference<>(null);

    /* renamed from: b */
    public WeakReference<byte[]> f2154b;

    public AbstractBinderC0870dd(byte[] bArr) {
        super(bArr);
        this.f2154b = f2153c;
    }

    /* renamed from: P0 */
    public abstract byte[] mo3190P0();

    @Override // com.sonelli.AbstractBinderC0763bd
    /* renamed from: s */
    public final byte[] mo2434s() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f2154b.get();
            if (bArr == null) {
                bArr = mo3190P0();
                this.f2154b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
