package cz.opentree;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.kd */
/* loaded from: classes.dex */
public final class C1445kd extends C1156id {

    /* renamed from: e */
    public final Callable<String> f4514e;

    public C1445kd(Callable<String> callable) {
        super(false, null, null);
        this.f4514e = callable;
    }

    @Override // cz.opentree.C1156id
    /* renamed from: a */
    public final String mo4750a() {
        try {
            return this.f4514e.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
