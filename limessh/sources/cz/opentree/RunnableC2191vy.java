package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.vy */
/* loaded from: classes.dex */
public final class RunnableC2191vy implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ int f7566O;

    /* renamed from: P */
    public final /* synthetic */ String f7567P;

    /* renamed from: Q */
    public final /* synthetic */ Object f7568Q;

    /* renamed from: R */
    public final /* synthetic */ Object f7569R;

    /* renamed from: S */
    public final /* synthetic */ Object f7570S;

    /* renamed from: T */
    public final /* synthetic */ C1889sy f7571T;

    public RunnableC2191vy(C1889sy c1889sy, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f7571T = c1889sy;
        this.f7566O = i;
        this.f7567P = str;
        this.f7568Q = obj;
        this.f7569R = obj2;
        this.f7570S = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j;
        char c2;
        long j2;
        C0960ez m9096B = this.f7571T.f5899a.m9096B();
        if (!m9096B.m7169u()) {
            this.f7571T.m8518B(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c = this.f7571T.f6604c;
        if (c == 0) {
            if (this.f7571T.m7590o().m2613G()) {
                C1889sy c1889sy = this.f7571T;
                c1889sy.mo1480f();
                c1889sy.f6604c = 'C';
            } else {
                C1889sy c1889sy2 = this.f7571T;
                c1889sy2.mo1480f();
                c1889sy2.f6604c = 'c';
            }
        }
        j = this.f7571T.f6605d;
        if (j < 0) {
            C1889sy c1889sy3 = this.f7571T;
            c1889sy3.f6605d = c1889sy3.m7590o().m2611E();
        }
        char charAt = "01VDIWEA?".charAt(this.f7566O);
        c2 = this.f7571T.f6604c;
        j2 = this.f7571T.f6605d;
        String m8510A = C1889sy.m8510A(true, this.f7567P, this.f7568Q, this.f7569R, this.f7570S);
        StringBuilder sb = new StringBuilder(String.valueOf(m8510A).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c2);
        sb.append(j2);
        sb.append(":");
        sb.append(m8510A);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f7567P.substring(0, 1024);
        }
        m9096B.f2559d.m6323b(sb2, 1L);
    }
}
