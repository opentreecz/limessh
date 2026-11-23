package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.p0 */
/* loaded from: classes.dex */
public final class C1685p0 extends AbstractC1841s0 {

    /* renamed from: a */
    public final Context f5585a;

    /* renamed from: b */
    public final Clock f5586b;

    /* renamed from: c */
    public final Clock f5587c;

    /* renamed from: d */
    public final String f5588d;

    public C1685p0(Context context, Clock clock, Clock clock2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f5585a = context;
        Objects.requireNonNull(clock, "Null wallClock");
        this.f5586b = clock;
        Objects.requireNonNull(clock2, "Null monotonicClock");
        this.f5587c = clock2;
        Objects.requireNonNull(str, "Null backendName");
        this.f5588d = str;
    }

    @Override // cz.opentree.AbstractC1841s0
    /* renamed from: b */
    public Context mo7162b() {
        return this.f5585a;
    }

    @Override // cz.opentree.AbstractC1841s0
    @NonNull
    /* renamed from: c */
    public String mo7163c() {
        return this.f5588d;
    }

    @Override // cz.opentree.AbstractC1841s0
    /* renamed from: d */
    public Clock mo7164d() {
        return this.f5587c;
    }

    @Override // cz.opentree.AbstractC1841s0
    /* renamed from: e */
    public Clock mo7165e() {
        return this.f5586b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1841s0)) {
            return false;
        }
        AbstractC1841s0 abstractC1841s0 = (AbstractC1841s0) obj;
        return this.f5585a.equals(abstractC1841s0.mo7162b()) && this.f5586b.equals(abstractC1841s0.mo7165e()) && this.f5587c.equals(abstractC1841s0.mo7164d()) && this.f5588d.equals(abstractC1841s0.mo7163c());
    }

    public int hashCode() {
        return ((((((this.f5585a.hashCode() ^ 1000003) * 1000003) ^ this.f5586b.hashCode()) * 1000003) ^ this.f5587c.hashCode()) * 1000003) ^ this.f5588d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f5585a + ", wallClock=" + this.f5586b + ", monotonicClock=" + this.f5587c + ", backendName=" + this.f5588d + "}";
    }
}
