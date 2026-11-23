package cz.opentree;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.ib */
/* loaded from: classes.dex */
public class C1154ib {

    /* renamed from: a */
    public final String f3280a;

    /* renamed from: b */
    public final String f3281b;

    /* renamed from: c */
    public final int f3282c;

    public C1154ib(String str, String str2) {
        this.f3281b = str2;
        this.f3280a = str;
        new C2267x9(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f3280a, i)) {
            i++;
        }
        this.f3282c = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1154ib(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L6
            java.lang.String r8 = ""
            goto L36
        L6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L28
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L22
            java.lang.String r4 = ","
            r0.append(r4)
        L22:
            r0.append(r3)
            int r2 = r2 + 1
            goto L12
        L28:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L36:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C1154ib.<init>(java.lang.String, java.lang.String[]):void");
    }

    /* renamed from: a */
    public void m4739a(String str, @Nullable Object... objArr) {
        if (m4742d(3)) {
            Log.d(this.f3280a, m4741c(str, objArr));
        }
    }

    /* renamed from: b */
    public void m4740b(String str, @Nullable Object... objArr) {
        Log.e(this.f3280a, m4741c(str, objArr));
    }

    /* renamed from: c */
    public String m4741c(String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f3281b.concat(str);
    }

    /* renamed from: d */
    public boolean m4742d(int i) {
        return this.f3282c <= i;
    }
}
