package cz.opentree;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.ed */
/* loaded from: classes.dex */
public final class BinderC0922ed extends AbstractBinderC0763bd {

    /* renamed from: b */
    public final byte[] f2369b;

    public BinderC0922ed(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f2369b = bArr;
    }

    @Override // cz.opentree.AbstractBinderC0763bd
    /* renamed from: s */
    public final byte[] mo2434s() {
        return this.f2369b;
    }
}
