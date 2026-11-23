package cz.opentree;

import com.google.android.gms.internal.measurement.zzde;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.am */
/* loaded from: classes.dex */
public final class C0720am<T> implements zzde<T>, Serializable {

    /* renamed from: O */
    public final zzde<T> f1447O;

    /* renamed from: P */
    public volatile transient boolean f1448P;

    /* renamed from: Q */
    @NullableDecl
    public transient T f1449Q;

    public C0720am(zzde<T> zzdeVar) {
        C2299xl.m9800a(zzdeVar);
        this.f1447O = zzdeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    /* renamed from: a */
    public final T mo1223a() {
        if (!this.f1448P) {
            synchronized (this) {
                if (!this.f1448P) {
                    T mo1223a = this.f1447O.mo1223a();
                    this.f1449Q = mo1223a;
                    this.f1448P = true;
                    return mo1223a;
                }
            }
        }
        return this.f1449Q;
    }

    public final String toString() {
        Object obj;
        if (this.f1448P) {
            String valueOf = String.valueOf(this.f1449Q);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            obj = sb.toString();
        } else {
            obj = this.f1447O;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
