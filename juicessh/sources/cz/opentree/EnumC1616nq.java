package cz.opentree;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'S' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.nq */
/* loaded from: classes.dex */
public class EnumC1616nq {

    /* renamed from: Q */
    public static final EnumC1616nq f5330Q;

    /* renamed from: R */
    public static final EnumC1616nq f5331R;

    /* renamed from: S */
    public static final EnumC1616nq f5332S;

    /* renamed from: T */
    public static final EnumC1616nq f5333T;

    /* renamed from: U */
    public static final EnumC1616nq f5334U;

    /* renamed from: V */
    public static final EnumC1616nq f5335V;

    /* renamed from: W */
    public static final EnumC1616nq f5336W;

    /* renamed from: X */
    public static final EnumC1616nq f5337X;

    /* renamed from: Y */
    public static final EnumC1616nq f5338Y;

    /* renamed from: Z */
    public static final EnumC1616nq f5339Z;

    /* renamed from: a0 */
    public static final EnumC1616nq f5340a0;

    /* renamed from: b0 */
    public static final EnumC1616nq f5341b0;

    /* renamed from: c0 */
    public static final EnumC1616nq f5342c0;

    /* renamed from: d0 */
    public static final EnumC1616nq f5343d0;

    /* renamed from: e0 */
    public static final EnumC1616nq f5344e0;

    /* renamed from: f0 */
    public static final EnumC1616nq f5345f0;

    /* renamed from: g0 */
    public static final EnumC1616nq f5346g0;

    /* renamed from: h0 */
    public static final EnumC1616nq f5347h0;

    /* renamed from: i0 */
    public static final /* synthetic */ EnumC1616nq[] f5348i0;

    /* renamed from: O */
    public final EnumC1780qq f5349O;

    /* renamed from: P */
    public final int f5350P;

    static {
        EnumC1616nq enumC1616nq = new EnumC1616nq("DOUBLE", 0, EnumC1780qq.DOUBLE, 1);
        f5330Q = enumC1616nq;
        EnumC1616nq enumC1616nq2 = new EnumC1616nq("FLOAT", 1, EnumC1780qq.FLOAT, 5);
        f5331R = enumC1616nq2;
        EnumC1780qq enumC1780qq = EnumC1780qq.LONG;
        final int i = 2;
        EnumC1616nq enumC1616nq3 = new EnumC1616nq("INT64", 2, enumC1780qq, 0);
        f5332S = enumC1616nq3;
        final int i2 = 3;
        EnumC1616nq enumC1616nq4 = new EnumC1616nq("UINT64", 3, enumC1780qq, 0);
        f5333T = enumC1616nq4;
        EnumC1780qq enumC1780qq2 = EnumC1780qq.INT;
        EnumC1616nq enumC1616nq5 = new EnumC1616nq("INT32", 4, enumC1780qq2, 0);
        f5334U = enumC1616nq5;
        EnumC1616nq enumC1616nq6 = new EnumC1616nq("FIXED64", 5, enumC1780qq, 1);
        f5335V = enumC1616nq6;
        EnumC1616nq enumC1616nq7 = new EnumC1616nq("FIXED32", 6, enumC1780qq2, 5);
        f5336W = enumC1616nq7;
        EnumC1616nq enumC1616nq8 = new EnumC1616nq("BOOL", 7, EnumC1780qq.BOOLEAN, 0);
        f5337X = enumC1616nq8;
        final EnumC1780qq enumC1780qq3 = EnumC1780qq.STRING;
        final String str = "STRING";
        final int i3 = 8;
        EnumC1616nq enumC1616nq9 = new EnumC1616nq(str, i3, enumC1780qq3, i) { // from class: cz.opentree.mq
            {
                int i4 = 8;
                int i5 = 2;
            }
        };
        f5338Y = enumC1616nq9;
        final EnumC1780qq enumC1780qq4 = EnumC1780qq.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        EnumC1616nq enumC1616nq10 = new EnumC1616nq(str2, i4, enumC1780qq4, i2) { // from class: cz.opentree.pq
            {
                int i5 = 9;
                int i6 = 3;
            }
        };
        f5339Z = enumC1616nq10;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final int i6 = 2;
        EnumC1616nq enumC1616nq11 = new EnumC1616nq(str3, i5, enumC1780qq4, i6) { // from class: cz.opentree.oq
            {
                int i7 = 10;
                int i8 = 2;
            }
        };
        f5340a0 = enumC1616nq11;
        final EnumC1780qq enumC1780qq5 = EnumC1780qq.BYTE_STRING;
        final String str4 = "BYTES";
        final int i7 = 11;
        EnumC1616nq enumC1616nq12 = new EnumC1616nq(str4, i7, enumC1780qq5, i6) { // from class: cz.opentree.rq
            {
                int i8 = 11;
                int i9 = 2;
            }
        };
        f5341b0 = enumC1616nq12;
        EnumC1616nq enumC1616nq13 = new EnumC1616nq("UINT32", 12, enumC1780qq2, 0);
        f5342c0 = enumC1616nq13;
        EnumC1616nq enumC1616nq14 = new EnumC1616nq("ENUM", 13, EnumC1780qq.ENUM, 0);
        f5343d0 = enumC1616nq14;
        EnumC1616nq enumC1616nq15 = new EnumC1616nq("SFIXED32", 14, enumC1780qq2, 5);
        f5344e0 = enumC1616nq15;
        EnumC1616nq enumC1616nq16 = new EnumC1616nq("SFIXED64", 15, enumC1780qq, 1);
        f5345f0 = enumC1616nq16;
        EnumC1616nq enumC1616nq17 = new EnumC1616nq("SINT32", 16, enumC1780qq2, 0);
        f5346g0 = enumC1616nq17;
        EnumC1616nq enumC1616nq18 = new EnumC1616nq("SINT64", 17, enumC1780qq, 0);
        f5347h0 = enumC1616nq18;
        f5348i0 = new EnumC1616nq[]{enumC1616nq, enumC1616nq2, enumC1616nq3, enumC1616nq4, enumC1616nq5, enumC1616nq6, enumC1616nq7, enumC1616nq8, enumC1616nq9, enumC1616nq10, enumC1616nq11, enumC1616nq12, enumC1616nq13, enumC1616nq14, enumC1616nq15, enumC1616nq16, enumC1616nq17, enumC1616nq18};
    }

    public EnumC1616nq(String str, int i, EnumC1780qq enumC1780qq, int i2) {
        this.f5349O = enumC1780qq;
        this.f5350P = i2;
    }

    public static EnumC1616nq[] values() {
        return (EnumC1616nq[]) f5348i0.clone();
    }

    /* renamed from: f */
    public final EnumC1780qq m6767f() {
        return this.f5349O;
    }

    /* renamed from: h */
    public final int m6768h() {
        return this.f5350P;
    }
}
