package okhttp3.internal.publicsuffix;

import cz.opentree.ep0;
import cz.opentree.fn0;
import cz.opentree.gp0;
import cz.opentree.ro0;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e */
    public static final byte[] f8677e = {42};

    /* renamed from: f */
    public static final String[] f8678f = new String[0];

    /* renamed from: g */
    public static final String[] f8679g = {"*"};

    /* renamed from: h */
    public static final PublicSuffixDatabase f8680h = new PublicSuffixDatabase();

    /* renamed from: a */
    public final AtomicBoolean f8681a = new AtomicBoolean(false);

    /* renamed from: b */
    public final CountDownLatch f8682b = new CountDownLatch(1);

    /* renamed from: c */
    public byte[] f8683c;

    /* renamed from: d */
    public byte[] f8684d;

    /* renamed from: a */
    public static String m10750a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        i11 = -1;
                        z2 = true;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, fn0.f2730i);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* renamed from: c */
    public static PublicSuffixDatabase m10751c() {
        return f8680h;
    }

    /* renamed from: b */
    public final String[] m10752b(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (this.f8681a.get() || !this.f8681a.compareAndSet(false, true)) {
            try {
                this.f8682b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m10755f();
        }
        synchronized (this) {
            if (this.f8683c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(fn0.f2730i);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = m10750a(this.f8683c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f8677e;
                str3 = m10750a(this.f8683c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String m10750a = m10750a(this.f8684d, bArr, i);
                if (m10750a != null) {
                    str = m10750a;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return f8679g;
        }
        String[] split = str2 != null ? str2.split("\\.") : f8678f;
        String[] split2 = str3 != null ? str3.split("\\.") : f8678f;
        return split.length > split2.length ? split : split2;
    }

    /* renamed from: d */
    public String m10753d(String str) {
        int length;
        int length2;
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] m10752b = m10752b(split);
        if (split.length == m10752b.length && m10752b[0].charAt(0) != '!') {
            return null;
        }
        if (m10752b[0].charAt(0) == '!') {
            length = split.length;
            length2 = m10752b.length;
        } else {
            length = split.length;
            length2 = m10752b.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i = length - length2; i < split2.length; i++) {
            sb.append(split2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: e */
    public final void m10754e() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource m4228b = gp0.m4228b(new ep0(gp0.m4233g(resourceAsStream)));
        try {
            byte[] bArr = new byte[m4228b.readInt()];
            m4228b.readFully(bArr);
            byte[] bArr2 = new byte[m4228b.readInt()];
            m4228b.readFully(bArr2);
            synchronized (this) {
                this.f8683c = bArr;
                this.f8684d = bArr2;
            }
            this.f8682b.countDown();
        } finally {
            fn0.m3826g(m4228b);
        }
    }

    /* renamed from: f */
    public final void m10755f() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m10754e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    ro0.m8221j().mo6500p(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }
}
