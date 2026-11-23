package cz.opentree;

/* compiled from: ErrorCode.java */
/* loaded from: classes.dex */
public enum co0 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: O */
    public final int f2021O;

    co0(int i) {
        this.f2021O = i;
    }

    /* renamed from: f */
    public static co0 m2895f(int i) {
        for (co0 co0Var : values()) {
            if (co0Var.f2021O == i) {
                return co0Var;
            }
        }
        return null;
    }
}
