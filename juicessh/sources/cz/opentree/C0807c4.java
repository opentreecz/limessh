package cz.opentree;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzo;
import java.util.ListIterator;

/* renamed from: cz.opentree.c4 */
/* loaded from: classes.dex */
public class C0807c4 extends C1195j4<C0807c4> {

    /* renamed from: d */
    public final C2216wf f1870d;

    /* renamed from: e */
    public boolean f1871e;

    public C0807c4(C2216wf c2216wf) {
        super(c2216wf.m9479g(), c2216wf.m9476d());
        this.f1870d = c2216wf;
    }

    @Override // cz.opentree.C1195j4
    /* renamed from: a */
    public final void mo2663a(C1093h4 c1093h4) {
        C1933ti c1933ti = (C1933ti) c1093h4.m4363n(C1933ti.class);
        if (TextUtils.isEmpty(c1933ti.m8692j())) {
            c1933ti.m8687e(this.f1870d.m9491s().m7029J0());
        }
        if (this.f1871e && TextUtils.isEmpty(c1933ti.m8694l())) {
            C1602nf m9490r = this.f1870d.m9490r();
            c1933ti.m8700r(m9490r.m6668I0());
            c1933ti.m8689g(m9490r.m6667H0());
        }
    }

    @Override // cz.opentree.C1195j4
    /* renamed from: b */
    public final C1093h4 mo2664b() {
        C1093h4 m4353d = this.f3487b.m4353d();
        m4353d.m4352c(this.f1870d.m9484l().m4444G0());
        m4353d.m4352c(this.f1870d.m9485m().m10129G0());
        m5051d(m4353d);
        return m4353d;
    }

    /* renamed from: e */
    public final void m2665e(boolean z) {
        this.f1871e = z;
    }

    /* renamed from: f */
    public final void m2666f(String str) {
        C0813ca.m2725g(str);
        Uri m3118H0 = C0859d4.m3118H0(str);
        ListIterator<zzo> listIterator = this.f3487b.m4355f().listIterator();
        while (listIterator.hasNext()) {
            if (m3118H0.equals(listIterator.next().mo835l())) {
                listIterator.remove();
            }
        }
        this.f3487b.m4355f().add(new C0859d4(this.f1870d, str));
    }

    /* renamed from: g */
    public final C2216wf m2667g() {
        return this.f1870d;
    }
}
