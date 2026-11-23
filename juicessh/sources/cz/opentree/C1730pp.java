package cz.opentree;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.pp */
/* loaded from: classes.dex */
public final class C1730pp<K, V> implements Comparable<C1730pp>, Map.Entry<K, V> {

    /* renamed from: O */
    public final Comparable f5752O;

    /* renamed from: P */
    public V f5753P;

    /* renamed from: Q */
    public final /* synthetic */ C1468kp f5754Q;

    /* JADX WARN: Multi-variable type inference failed */
    public C1730pp(C1468kp c1468kp, K k, V v) {
        this.f5754Q = c1468kp;
        this.f5752O = k;
        this.f5753P = v;
    }

    public C1730pp(C1468kp c1468kp, Map.Entry<K, V> entry) {
        this(c1468kp, (Comparable) entry.getKey(), entry.getValue());
    }

    /* renamed from: f */
    public static boolean m7434f(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(C1730pp c1730pp) {
        return ((Comparable) getKey()).compareTo((Comparable) c1730pp.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m7434f(this.f5752O, entry.getKey()) && m7434f(this.f5753P, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f5752O;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f5753P;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f5752O;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f5753P;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f5754Q.m5985p();
        V v2 = this.f5753P;
        this.f5753P = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5752O);
        String valueOf2 = String.valueOf(this.f5753P);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        return sb.toString();
    }
}
