package cz.opentree;

import com.google.android.gms.tasks.Continuation;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class m90 implements Continuation {

    /* renamed from: a */
    public final o90 f5005a;

    public m90(o90 o90Var) {
        this.f5005a = o90Var;
    }

    /* renamed from: b */
    public static Continuation m6385b(o90 o90Var) {
        return new m90(o90Var);
    }

    @Override // com.google.android.gms.tasks.Continuation
    /* renamed from: a */
    public Object mo1552a(j60 j60Var) {
        boolean m6907i;
        m6907i = this.f5005a.m6907i(j60Var);
        return Boolean.valueOf(m6907i);
    }
}
