package cz.opentree;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.o7 */
/* loaded from: classes.dex */
public final class C1635o7 extends UnsupportedOperationException {

    /* renamed from: O */
    public final Feature f5439O;

    public C1635o7(Feature feature) {
        this.f5439O = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.f5439O);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
