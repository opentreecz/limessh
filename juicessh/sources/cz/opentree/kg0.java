package cz.opentree;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.platforminfo.UserAgentPublisher;
import cz.opentree.v70;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class kg0 implements UserAgentPublisher {

    /* renamed from: a */
    public final String f4536a;

    /* renamed from: b */
    public final lg0 f4537b;

    public kg0(Set<ng0> set, lg0 lg0Var) {
        this.f4536a = m5886d(set);
        this.f4537b = lg0Var;
    }

    /* renamed from: b */
    public static v70<UserAgentPublisher> m5884b() {
        v70.C2157b m9172a = v70.m9172a(UserAgentPublisher.class);
        m9172a.m9187b(b80.m2396h(ng0.class));
        m9172a.m9191f(jg0.m5109b());
        return m9172a.m9189d();
    }

    /* renamed from: c */
    public static /* synthetic */ UserAgentPublisher m5885c(ComponentContainer componentContainer) {
        return new kg0(componentContainer.mo1601d(ng0.class), lg0.m6157a());
    }

    /* renamed from: d */
    public static String m5886d(Set<ng0> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<ng0> it = set.iterator();
        while (it.hasNext()) {
            ng0 next = it.next();
            sb.append(next.mo4776b());
            sb.append('/');
            sb.append(next.mo4777c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    /* renamed from: a */
    public String mo1911a() {
        if (this.f4537b.m6158b().isEmpty()) {
            return this.f4536a;
        }
        return this.f4536a + ' ' + m5886d(this.f4537b.m6158b());
    }
}
