package cz.opentree;

import android.content.Context;
import android.os.Bundle;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.zi */
/* loaded from: classes.dex */
public final class C2427zi extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f8518S;

    /* renamed from: T */
    public final /* synthetic */ String f8519T;

    /* renamed from: U */
    public final /* synthetic */ Context f8520U;

    /* renamed from: V */
    public final /* synthetic */ Bundle f8521V;

    /* renamed from: W */
    public final /* synthetic */ C2224wi f8522W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2427zi(C2224wi c2224wi, String str, String str2, Context context, Bundle bundle) {
        super(c2224wi);
        this.f8522W = c2224wi;
        this.f8518S = str;
        this.f8519T = str2;
        this.f8520U = context;
        this.f8521V = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0052, B:16:0x005e, B:18:0x006c, B:22:0x0081), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0052, B:16:0x005e, B:18:0x006c, B:22:0x0081), top: B:2:0x0002 }] */
    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo2112a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            cz.opentree.wi r2 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L9e
            r3.<init>()     // Catch: java.lang.Exception -> L9e
            cz.opentree.C2224wi.m9538e(r2, r3)     // Catch: java.lang.Exception -> L9e
            cz.opentree.wi r2 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            java.lang.String r3 = r14.f8518S     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = r14.f8519T     // Catch: java.lang.Exception -> L9e
            boolean r2 = cz.opentree.C2224wi.m9543t(r2, r3, r4)     // Catch: java.lang.Exception -> L9e
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.String r3 = r14.f8519T     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = r14.f8518S     // Catch: java.lang.Exception -> L9e
            cz.opentree.wi r4 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = cz.opentree.C2224wi.m9544u(r4)     // Catch: java.lang.Exception -> L9e
            r10 = r2
            r11 = r3
            r9 = r4
            goto L2a
        L27:
            r9 = r3
            r10 = r9
            r11 = r10
        L2a:
            android.content.Context r2 = r14.f8520U     // Catch: java.lang.Exception -> L9e
            cz.opentree.C2224wi.m9524C(r2)     // Catch: java.lang.Exception -> L9e
            java.lang.Boolean r2 = cz.opentree.C2224wi.m9533R()     // Catch: java.lang.Exception -> L9e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L9e
            if (r2 != 0) goto L3e
            if (r10 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r0
            goto L3f
        L3e:
            r2 = r1
        L3f:
            cz.opentree.wi r3 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            android.content.Context r4 = r14.f8520U     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.zzr r4 = r3.m9553c(r4, r2)     // Catch: java.lang.Exception -> L9e
            cz.opentree.C2224wi.m9537d(r3, r4)     // Catch: java.lang.Exception -> L9e
            cz.opentree.wi r3 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.zzr r3 = cz.opentree.C2224wi.m9523A(r3)     // Catch: java.lang.Exception -> L9e
            if (r3 != 0) goto L5e
            cz.opentree.wi r2 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = cz.opentree.C2224wi.m9544u(r2)     // Catch: java.lang.Exception -> L9e
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: java.lang.Exception -> L9e
            return
        L5e:
            android.content.Context r3 = r14.f8520U     // Catch: java.lang.Exception -> L9e
            int r3 = cz.opentree.C2224wi.m9526F(r3)     // Catch: java.lang.Exception -> L9e
            android.content.Context r4 = r14.f8520U     // Catch: java.lang.Exception -> L9e
            int r4 = cz.opentree.C2224wi.m9528J(r4)     // Catch: java.lang.Exception -> L9e
            if (r2 == 0) goto L77
            int r2 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Exception -> L9e
            if (r4 >= r3) goto L74
            r3 = r1
            goto L75
        L74:
            r3 = r0
        L75:
            r8 = r3
            goto L81
        L77:
            if (r3 <= 0) goto L7a
            r4 = r3
        L7a:
            if (r3 <= 0) goto L7e
            r2 = r1
            goto L7f
        L7e:
            r2 = r0
        L7f:
            r8 = r2
            r2 = r4
        L81:
            com.google.android.gms.internal.measurement.zzaa r13 = new com.google.android.gms.internal.measurement.zzaa     // Catch: java.lang.Exception -> L9e
            r4 = 27000(0x6978, double:1.334E-319)
            long r6 = (long) r2     // Catch: java.lang.Exception -> L9e
            android.os.Bundle r12 = r14.f8521V     // Catch: java.lang.Exception -> L9e
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L9e
            cz.opentree.wi r2 = r14.f8522W     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.zzr r2 = cz.opentree.C2224wi.m9523A(r2)     // Catch: java.lang.Exception -> L9e
            android.content.Context r3 = r14.f8520U     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.dynamic.IObjectWrapper r3 = cz.opentree.BinderC1548md.m6402O0(r3)     // Catch: java.lang.Exception -> L9e
            long r4 = r14.f7727O     // Catch: java.lang.Exception -> L9e
            r2.initialize(r3, r13, r4)     // Catch: java.lang.Exception -> L9e
            return
        L9e:
            r2 = move-exception
            cz.opentree.wi r3 = r14.f8522W
            cz.opentree.C2224wi.m9540l(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C2427zi.mo2112a():void");
    }
}
