package cz.opentree;

import com.google.android.gms.internal.measurement.zzef;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.tm */
/* loaded from: classes.dex */
public abstract class AbstractC1939tm implements Serializable, Iterable<Byte> {

    /* renamed from: P */
    public static final AbstractC1939tm f6790P = new C0722an(C2435zn.f8566b);

    /* renamed from: Q */
    public static final zzef f6791Q;

    /* renamed from: O */
    public int f6792O = 0;

    static {
        C2179vm c2179vm = null;
        f6791Q = C1775qm.m7743b() ? new C0890dn(c2179vm) : new C2233wm(c2179vm);
    }

    /* renamed from: j */
    public static AbstractC1939tm m8763j(String str) {
        return new C0722an(str.getBytes(C2435zn.f8565a));
    }

    /* renamed from: k */
    public static AbstractC1939tm m8764k(byte[] bArr, int i, int i2) {
        m8765p(i, i + i2, bArr.length);
        return new C0722an(f6791Q.mo1224a(bArr, i, i2));
    }

    /* renamed from: p */
    public static int m8765p(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    /* renamed from: r */
    public static C2433zm m8766r(int i) {
        return new C2433zm(i, null);
    }

    /* renamed from: e */
    public abstract byte mo2149e(int i);

    public abstract boolean equals(Object obj);

    /* renamed from: f */
    public abstract int mo2150f();

    /* renamed from: h */
    public abstract int mo2151h(int i, int i2, int i3);

    public final int hashCode() {
        int i = this.f6792O;
        if (i == 0) {
            int mo2150f = mo2150f();
            i = mo2151h(mo2150f, 0, mo2150f);
            if (i == 0) {
                i = 1;
            }
            this.f6792O = i;
        }
        return i;
    }

    /* renamed from: i */
    public abstract AbstractC1939tm mo2152i(int i, int i2);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new C2179vm(this);
    }

    /* renamed from: m */
    public abstract String mo2153m(Charset charset);

    /* renamed from: n */
    public abstract void mo2154n(AbstractC2020um abstractC2020um) throws IOException;

    /* renamed from: o */
    public abstract byte mo2155o(int i);

    /* renamed from: q */
    public final String m8767q() {
        return mo2150f() == 0 ? "" : mo2153m(C2435zn.f8565a);
    }

    /* renamed from: s */
    public abstract boolean mo2156s();

    /* renamed from: t */
    public final int m8768t() {
        return this.f6792O;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(mo2150f());
        objArr[2] = mo2150f() <= 50 ? C1944tp.m8791a(this) : String.valueOf(C1944tp.m8791a(mo2152i(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
