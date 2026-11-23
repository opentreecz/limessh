package cz.opentree;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'R' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.eo */
/* loaded from: classes.dex */
public final class EnumC0948eo {

    /* renamed from: Q */
    public static final EnumC0948eo f2502Q;

    /* renamed from: R */
    public static final EnumC0948eo f2503R;

    /* renamed from: S */
    public static final EnumC0948eo f2504S;

    /* renamed from: T */
    public static final EnumC0948eo f2505T;

    /* renamed from: U */
    public static final EnumC0948eo f2506U;

    /* renamed from: V */
    public static final EnumC0948eo f2507V;

    /* renamed from: W */
    public static final EnumC0948eo f2508W;

    /* renamed from: X */
    public static final EnumC0948eo f2509X;

    /* renamed from: Y */
    public static final EnumC0948eo f2510Y;

    /* renamed from: Z */
    public static final EnumC0948eo f2511Z;

    /* renamed from: a0 */
    public static final /* synthetic */ EnumC0948eo[] f2512a0;

    /* renamed from: O */
    public final Class<?> f2513O;

    /* renamed from: P */
    public final Object f2514P;

    static {
        EnumC0948eo enumC0948eo = new EnumC0948eo("VOID", 0, Void.class, Void.class, null);
        f2502Q = enumC0948eo;
        Class cls = Integer.TYPE;
        EnumC0948eo enumC0948eo2 = new EnumC0948eo("INT", 1, cls, Integer.class, 0);
        f2503R = enumC0948eo2;
        EnumC0948eo enumC0948eo3 = new EnumC0948eo("LONG", 2, Long.TYPE, Long.class, 0L);
        f2504S = enumC0948eo3;
        EnumC0948eo enumC0948eo4 = new EnumC0948eo("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f2505T = enumC0948eo4;
        EnumC0948eo enumC0948eo5 = new EnumC0948eo("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(ShadowDrawableWrapper.COS_45));
        f2506U = enumC0948eo5;
        EnumC0948eo enumC0948eo6 = new EnumC0948eo("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f2507V = enumC0948eo6;
        EnumC0948eo enumC0948eo7 = new EnumC0948eo("STRING", 6, String.class, String.class, "");
        f2508W = enumC0948eo7;
        EnumC0948eo enumC0948eo8 = new EnumC0948eo("BYTE_STRING", 7, AbstractC1939tm.class, AbstractC1939tm.class, AbstractC1939tm.f6790P);
        f2509X = enumC0948eo8;
        EnumC0948eo enumC0948eo9 = new EnumC0948eo("ENUM", 8, cls, Integer.class, null);
        f2510Y = enumC0948eo9;
        EnumC0948eo enumC0948eo10 = new EnumC0948eo("MESSAGE", 9, Object.class, Object.class, null);
        f2511Z = enumC0948eo10;
        f2512a0 = new EnumC0948eo[]{enumC0948eo, enumC0948eo2, enumC0948eo3, enumC0948eo4, enumC0948eo5, enumC0948eo6, enumC0948eo7, enumC0948eo8, enumC0948eo9, enumC0948eo10};
    }

    public EnumC0948eo(String str, int i, Class cls, Class cls2, Object obj) {
        this.f2513O = cls2;
        this.f2514P = obj;
    }

    public static EnumC0948eo[] values() {
        return (EnumC0948eo[]) f2512a0.clone();
    }

    /* renamed from: f */
    public final Class<?> m3534f() {
        return this.f2513O;
    }
}
