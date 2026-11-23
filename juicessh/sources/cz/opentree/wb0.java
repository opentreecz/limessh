package cz.opentree;

import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class wb0 implements CreateReportSpiCall {

    /* renamed from: a */
    public final xb0 f7660a;

    /* renamed from: b */
    public final yb0 f7661b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.wb0$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2212a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f7662a;

        static {
            int[] iArr = new int[Report.EnumC0663a.values().length];
            f7662a = iArr;
            try {
                iArr[Report.EnumC0663a.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7662a[Report.EnumC0663a.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public wb0(xb0 xb0Var, yb0 yb0Var) {
        this.f7660a = xb0Var;
        this.f7661b = yb0Var;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    /* renamed from: b */
    public boolean mo1841b(tb0 tb0Var, boolean z) {
        int i = C2212a.f7662a[tb0Var.f6756c.getType().ordinal()];
        if (i == 1) {
            this.f7660a.mo1841b(tb0Var, z);
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.f7661b.mo1841b(tb0Var, z);
        return true;
    }
}
