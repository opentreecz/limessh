package cz.opentree;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public enum e90 {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: O */
    public final int f2351O;

    e90(int i) {
        this.f2351O = i;
    }

    /* renamed from: f */
    public static e90 m3458f(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    /* renamed from: h */
    public int m3459h() {
        return this.f2351O;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f2351O);
    }
}
