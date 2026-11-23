package cz.opentree;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.fk0;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.mi0;
import java.util.UUID;

/* compiled from: SSHExecTransport.java */
/* loaded from: classes.dex */
public class fi0 extends ji0 {

    /* renamed from: l */
    public Snippet f2694l;

    /* renamed from: m */
    public int f2695m;

    /* renamed from: n */
    public String f2696n;

    /* compiled from: SSHExecTransport.java */
    /* renamed from: cz.opentree.fi0$a */
    /* loaded from: classes.dex */
    public class C0992a extends fk0.AbstractC0995a {
        public C0992a() {
        }

        @Override // cz.opentree.fk0.AbstractC0995a
        /* renamed from: a */
        public void mo3777a(int i) {
            super.mo3777a(i);
            fi0.this.f2695m = i;
            fi0.this.m5129z();
        }

        @Override // cz.opentree.fk0.AbstractC0995a
        /* renamed from: b */
        public void mo3778b(String str) {
            super.mo3778b(str);
            fi0.this.f2696n += str + "\n";
        }
    }

    public fi0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, Connection connection, Identity identity, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, gi0Var, connection, identity);
        this.f2695m = -1;
        this.f2696n = "";
        this.f2694l = snippet;
    }

    @Override // cz.opentree.ji0
    /* renamed from: B */
    public void mo3775B() {
        try {
            this.f3568k.m2845f(this.f2694l.content, new C0992a());
        } catch (ek0 e) {
            m5127x().m2505D(this, mi0.EnumC1556b.PROCESS_EXECUTION_FAILED, e.getMessage());
        }
    }

    /* renamed from: G */
    public String m3776G() {
        return this.f2696n;
    }

    @Override // cz.opentree.mi0
    /* renamed from: l */
    public int mo3507l() {
        return this.f2695m;
    }

    @Override // cz.opentree.mi0
    /* renamed from: m */
    public NotificationCompat.Builder mo3508m() {
        return null;
    }

    @Override // cz.opentree.mi0
    /* renamed from: n */
    public NotificationCompat.Builder mo3509n() {
        return null;
    }
}
