package cz.opentree;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: cz.opentree.oh */
/* loaded from: classes.dex */
public final class C1654oh extends AbstractC2006uf {

    /* renamed from: Q */
    public SharedPreferences f5482Q;

    /* renamed from: R */
    public long f5483R;

    /* renamed from: S */
    public long f5484S;

    /* renamed from: T */
    public final C1763qh f5485T;

    public C1654oh(C2216wf c2216wf) {
        super(c2216wf);
        this.f5484S = -1L;
        this.f5485T = new C1763qh(this, "monitoring", C0770bh.f1673C.m2801a().longValue());
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        this.f5482Q = m8675x().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    /* renamed from: H0 */
    public final long m7035H0() {
        C1434k4.m5823i();
        m8878F0();
        if (this.f5483R == 0) {
            long j = this.f5482Q.getLong("first_run", 0L);
            if (j != 0) {
                this.f5483R = j;
            } else {
                long mo1177a = m8659g0().mo1177a();
                SharedPreferences.Editor edit = this.f5482Q.edit();
                edit.putLong("first_run", mo1177a);
                if (!edit.commit()) {
                    m8649A0("Failed to commit first run time");
                }
                this.f5483R = mo1177a;
            }
        }
        return this.f5483R;
    }

    /* renamed from: I0 */
    public final C2221wh m7036I0() {
        return new C2221wh(m8659g0(), m7035H0());
    }

    /* renamed from: J0 */
    public final long m7037J0() {
        C1434k4.m5823i();
        m8878F0();
        if (this.f5484S == -1) {
            this.f5484S = this.f5482Q.getLong("last_dispatch", 0L);
        }
        return this.f5484S;
    }

    /* renamed from: K0 */
    public final void m7038K0() {
        C1434k4.m5823i();
        m8878F0();
        long mo1177a = m8659g0().mo1177a();
        SharedPreferences.Editor edit = this.f5482Q.edit();
        edit.putLong("last_dispatch", mo1177a);
        edit.apply();
        this.f5484S = mo1177a;
    }

    /* renamed from: L0 */
    public final String m7039L0() {
        C1434k4.m5823i();
        m8878F0();
        String string = this.f5482Q.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* renamed from: M0 */
    public final C1763qh m7040M0() {
        return this.f5485T;
    }
}
