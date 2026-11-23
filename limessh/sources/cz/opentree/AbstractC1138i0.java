package cz.opentree;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import cz.opentree.C0747b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC1138i0 {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.i0$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        /* renamed from: a */
        public abstract AbstractC1138i0 mo2326a();

        /* renamed from: b */
        public abstract a mo2327b(String str);

        /* renamed from: c */
        public abstract a mo2328c(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* renamed from: d */
        public abstract a mo2329d(EnumC0854d enumC0854d);
    }

    /* renamed from: a */
    public static a m4681a() {
        C0747b0.b bVar = new C0747b0.b();
        bVar.mo2329d(EnumC0854d.DEFAULT);
        return bVar;
    }

    /* renamed from: b */
    public abstract String mo2323b();

    @Nullable
    /* renamed from: c */
    public abstract byte[] mo2324c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: d */
    public abstract EnumC0854d mo2325d();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: e */
    public AbstractC1138i0 m4682e(EnumC0854d enumC0854d) {
        a m4681a = m4681a();
        m4681a.mo2327b(mo2323b());
        m4681a.mo2329d(enumC0854d);
        m4681a.mo2328c(mo2324c());
        return m4681a.mo2326a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = mo2323b();
        objArr[1] = mo2325d();
        objArr[2] = mo2324c() == null ? "" : Base64.encodeToString(mo2324c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
