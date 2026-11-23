package cz.opentree;

import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public abstract class ud0<T> {

    /* renamed from: a */
    public final int f6949a;

    /* renamed from: b */
    public final k60<T> f6950b = new k60<>();

    /* renamed from: c */
    public final int f6951c;

    /* renamed from: d */
    public final Bundle f6952d;

    public ud0(int i, int i2, Bundle bundle) {
        this.f6949a = i;
        this.f6951c = i2;
        this.f6952d = bundle;
    }

    /* renamed from: a */
    public abstract void mo8867a(Bundle bundle);

    /* renamed from: b */
    public final void m8868b(td0 td0Var) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(td0Var);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f6950b.m5843b(td0Var);
    }

    /* renamed from: c */
    public final void m8869c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f6950b.m5844c(t);
    }

    /* renamed from: d */
    public abstract boolean mo8870d();

    public String toString() {
        int i = this.f6951c;
        int i2 = this.f6949a;
        boolean mo8870d = mo8870d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(mo8870d);
        sb.append("}");
        return sb.toString();
    }
}
