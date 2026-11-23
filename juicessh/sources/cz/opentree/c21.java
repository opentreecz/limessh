package cz.opentree;

/* loaded from: classes.dex */
public class c21 {
    /* renamed from: a */
    public static String m2658a(int i) {
        if (i == 5) {
            return "qTESLA-p-I";
        }
        if (i == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    /* renamed from: b */
    public static int m2659b(int i) {
        if (i == 5) {
            return 5184;
        }
        if (i == 6) {
            return 12352;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    /* renamed from: c */
    public static int m2660c(int i) {
        if (i == 5) {
            return 14880;
        }
        if (i == 6) {
            return 38432;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }
}
