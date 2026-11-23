package cz.opentree;

import com.google.firebase.crashlytics.internal.settings.model.Settings;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class mc0 implements Settings {

    /* renamed from: a */
    public final jc0 f5018a;

    /* renamed from: b */
    public final lc0 f5019b;

    /* renamed from: c */
    public final kc0 f5020c;

    /* renamed from: d */
    public final long f5021d;

    public mc0(long j, jc0 jc0Var, lc0 lc0Var, kc0 kc0Var, int i, int i2) {
        this.f5021d = j;
        this.f5018a = jc0Var;
        this.f5019b = lc0Var;
        this.f5020c = kc0Var;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    /* renamed from: a */
    public kc0 mo1845a() {
        return this.f5020c;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    /* renamed from: b */
    public lc0 mo1846b() {
        return this.f5019b;
    }

    /* renamed from: c */
    public jc0 m6399c() {
        return this.f5018a;
    }

    /* renamed from: d */
    public long m6400d() {
        return this.f5021d;
    }

    /* renamed from: e */
    public boolean m6401e(long j) {
        return this.f5021d < j;
    }
}
