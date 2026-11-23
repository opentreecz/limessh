package cz.opentree;

import java.util.Objects;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class z21 {

    /* renamed from: a */
    public final XMSSOid f8418a;

    /* renamed from: b */
    public final int f8419b;

    /* renamed from: c */
    public final int f8420c;

    /* renamed from: d */
    public final int f8421d;

    /* renamed from: e */
    public final int f8422e;

    /* renamed from: f */
    public final int f8423f;

    /* renamed from: g */
    public final aq0 f8424g;

    public z21(aq0 aq0Var) {
        Objects.requireNonNull(aq0Var, "treeDigest == null");
        this.f8424g = aq0Var;
        Digest m8307a = s21.m8307a(aq0Var);
        int m6358h = m31.m6358h(m8307a);
        this.f8419b = m6358h;
        this.f8420c = 16;
        int ceil = (int) Math.ceil((m6358h * 8) / m31.m6365o(16));
        this.f8422e = ceil;
        int floor = ((int) Math.floor(m31.m6365o((16 - 1) * ceil) / m31.m6365o(16))) + 1;
        this.f8423f = floor;
        int i = ceil + floor;
        this.f8421d = i;
        y21 m10056c = y21.m10056c(m8307a.mo7097e(), m6358h, 16, i);
        this.f8418a = m10056c;
        if (m10056c != null) {
            return;
        }
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + m8307a.mo7097e());
    }

    /* renamed from: a */
    public int m10325a() {
        return this.f8421d;
    }

    /* renamed from: b */
    public aq0 m10326b() {
        return this.f8424g;
    }

    /* renamed from: c */
    public int m10327c() {
        return this.f8419b;
    }

    /* renamed from: d */
    public int m10328d() {
        return this.f8420c;
    }
}
