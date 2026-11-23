package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class o00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f5394O;

    /* renamed from: P */
    public final /* synthetic */ String f5395P;

    /* renamed from: Q */
    public final /* synthetic */ String f5396Q;

    /* renamed from: R */
    public final /* synthetic */ long f5397R;

    /* renamed from: S */
    public final /* synthetic */ a00 f5398S;

    public o00(a00 a00Var, String str, String str2, String str3, long j) {
        this.f5398S = a00Var;
        this.f5394O = str;
        this.f5395P = str2;
        this.f5396Q = str3;
        this.f5397R = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        String str = this.f5394O;
        if (str == null) {
            z30Var2 = this.f5398S.f1301a;
            z30Var2.m10370f0().m9110P().m1968P(this.f5395P, null);
        } else {
            b20 b20Var = new b20(this.f5396Q, str, this.f5397R);
            z30Var = this.f5398S.f1301a;
            z30Var.m10370f0().m9110P().m1968P(this.f5395P, b20Var);
        }
    }
}
