package cz.opentree;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class lg0 {

    /* renamed from: b */
    public static volatile lg0 f4795b;

    /* renamed from: a */
    public final Set<ng0> f4796a = new HashSet();

    /* renamed from: a */
    public static lg0 m6157a() {
        lg0 lg0Var = f4795b;
        if (lg0Var == null) {
            synchronized (lg0.class) {
                lg0Var = f4795b;
                if (lg0Var == null) {
                    lg0Var = new lg0();
                    f4795b = lg0Var;
                }
            }
        }
        return lg0Var;
    }

    /* renamed from: b */
    public Set<ng0> m6158b() {
        Set<ng0> unmodifiableSet;
        synchronized (this.f4796a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f4796a);
        }
        return unmodifiableSet;
    }
}
