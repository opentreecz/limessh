package cz.opentree;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.wy */
/* loaded from: classes.dex */
public final class C2249wy {

    /* renamed from: a */
    @NonNull
    public String f7812a;

    /* renamed from: b */
    @NonNull
    public String f7813b;

    /* renamed from: c */
    public long f7814c;

    /* renamed from: d */
    @NonNull
    public Bundle f7815d;

    public C2249wy(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.f7812a = str;
        this.f7813b = str2;
        this.f7815d = bundle == null ? new Bundle() : bundle;
        this.f7814c = j;
    }

    public final String toString() {
        String str = this.f7813b;
        String str2 = this.f7812a;
        String valueOf = String.valueOf(this.f7815d);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }
}
