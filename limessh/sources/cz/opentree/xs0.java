package cz.opentree;

/* loaded from: classes.dex */
public class xs0 {
    /* renamed from: a */
    public static at0 m9880a(du0 du0Var) {
        if (du0Var == null) {
            return null;
        }
        return new at0(du0Var.m3318a(), new ct0(du0Var.m3319b(), false), du0Var.m3321d(), du0Var.m3320c(), du0Var.m3322e());
    }

    /* renamed from: b */
    public static at0 m9881b(String str) {
        at0 m10220h = ys0.m10220h(str);
        if (m10220h == null) {
            m10220h = ts0.m8804j(str);
        }
        if (m10220h == null) {
            m10220h = ps0.m7442b(str);
        }
        if (m10220h == null) {
            m10220h = us0.m8982h(str);
        }
        if (m10220h == null) {
            m10220h = ls0.m6288h(str);
        }
        if (m10220h == null) {
            m10220h = m9880a(ns0.m6779c(str));
        }
        return m10220h == null ? os0.m7093h(str) : m10220h;
    }

    /* renamed from: c */
    public static at0 m9882c(aq0 aq0Var) {
        at0 m10221i = ys0.m10221i(aq0Var);
        if (m10221i == null) {
            m10221i = ts0.m8805k(aq0Var);
        }
        if (m10221i == null) {
            m10221i = us0.m8983i(aq0Var);
        }
        if (m10221i == null) {
            m10221i = ls0.m6289i(aq0Var);
        }
        if (m10221i == null) {
            m10221i = m9880a(ns0.m6780d(aq0Var));
        }
        return m10221i == null ? os0.m7094i(aq0Var) : m10221i;
    }

    /* renamed from: d */
    public static aq0 m9883d(String str) {
        aq0 m10222j = ys0.m10222j(str);
        if (m10222j == null) {
            m10222j = ts0.m8806l(str);
        }
        if (m10222j == null) {
            m10222j = ps0.m7444d(str);
        }
        if (m10222j == null) {
            m10222j = us0.m8984j(str);
        }
        if (m10222j == null) {
            m10222j = ls0.m6290j(str);
        }
        if (m10222j == null) {
            m10222j = ns0.m6781e(str);
        }
        if (m10222j == null) {
            m10222j = os0.m7095j(str);
        }
        return (m10222j == null && str.equals("curve25519")) ? ms0.f5136c : m10222j;
    }
}
