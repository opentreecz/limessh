package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes.dex */
public class wp0 extends FilterInputStream implements BERTags {

    /* renamed from: O */
    public final int f7783O;

    /* renamed from: P */
    public final boolean f7784P;

    /* renamed from: Q */
    public final byte[][] f7785Q;

    public wp0(InputStream inputStream) {
        this(inputStream, ks0.m5994c(inputStream));
    }

    public wp0(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public wp0(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.f7783O = i;
        this.f7784P = z;
        this.f7785Q = new byte[11];
    }

    public wp0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public wp0(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    /* renamed from: b */
    public static eq0 m9621b(int i, es0 es0Var, byte[][] bArr) throws IOException {
        if (i == 10) {
            return sp0.m8479t(m9623d(es0Var, bArr));
        }
        if (i == 12) {
            return new qr0(es0Var.m3553f());
        }
        if (i == 30) {
            return new wq0(m9622c(es0Var));
        }
        switch (i) {
            case 1:
                return qp0.m7773t(m9623d(es0Var, bArr));
            case 2:
                return new xp0(es0Var.m3553f(), false);
            case 3:
                return pp0.m7436u(es0Var.m3551c(), es0Var);
            case 4:
                return new gr0(es0Var.m3553f());
            case 5:
                return er0.f2528O;
            case 6:
                return aq0.m2254v(m9623d(es0Var, bArr));
            default:
                switch (i) {
                    case 18:
                        return new fr0(es0Var.m3553f());
                    case 19:
                        return new jr0(es0Var.m3553f());
                    case 20:
                        return new or0(es0Var.m3553f());
                    case 21:
                        return new sr0(es0Var.m3553f());
                    case 22:
                        return new dr0(es0Var.m3553f());
                    case 23:
                        return new jq0(es0Var.m3553f());
                    case 24:
                        return new vp0(es0Var.m3553f());
                    case 25:
                        return new cr0(es0Var.m3553f());
                    case 26:
                        return new tr0(es0Var.m3553f());
                    case 27:
                        return new ar0(es0Var.m3553f());
                    case 28:
                        return new rr0(es0Var.m3553f());
                    default:
                        throw new IOException("unknown tag " + i + " encountered");
                }
        }
    }

    /* renamed from: c */
    public static char[] m9622c(es0 es0Var) throws IOException {
        int i;
        int m3551c = es0Var.m3551c();
        if ((m3551c & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i2 = m3551c / 2;
        char[] cArr = new char[i2];
        byte[] bArr = new byte[8];
        int i3 = 0;
        int i4 = 0;
        while (m3551c >= 8) {
            if (r51.m7882d(es0Var, bArr, 0, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i4] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
            cArr[i4 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
            cArr[i4 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
            cArr[i4 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
            i4 += 4;
            m3551c -= 8;
        }
        if (m3551c > 0) {
            if (r51.m7882d(es0Var, bArr, 0, m3551c) != m3551c) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            while (true) {
                int i5 = i3 + 1;
                int i6 = i5 + 1;
                i = i4 + 1;
                cArr[i4] = (char) ((bArr[i3] << 8) | (bArr[i5] & 255));
                if (i6 >= m3551c) {
                    break;
                }
                i3 = i6;
                i4 = i;
            }
            i4 = i;
        }
        if (es0Var.m3551c() == 0 && i2 == i4) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public static byte[] m9623d(es0 es0Var, byte[][] bArr) throws IOException {
        int m3551c = es0Var.m3551c();
        if (m3551c >= bArr.length) {
            return es0Var.m3553f();
        }
        byte[] bArr2 = bArr[m3551c];
        if (bArr2 == null) {
            bArr2 = new byte[m3551c];
            bArr[m3551c] = bArr2;
        }
        es0Var.m3552d(bArr2);
        return bArr2;
    }

    /* renamed from: l */
    public static int m9624l(InputStream inputStream, int i, boolean z) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (read == 128) {
            return -1;
        }
        if (read <= 127) {
            return read;
        }
        int i2 = read & KeycodeConstants.KEYCODE_MEDIA_PAUSE;
        if (i2 > 4) {
            throw new IOException("DER length more than 4 bytes: " + i2);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int read2 = inputStream.read();
            if (read2 < 0) {
                throw new EOFException("EOF found reading length");
            }
            i3 = (i3 << 8) + read2;
        }
        if (i3 < 0) {
            throw new IOException("corrupted stream - negative length found");
        }
        if (i3 < i || z) {
            return i3;
        }
        throw new IOException("corrupted stream - out of bounds length found: " + i3 + " >= " + i);
    }

    /* renamed from: p */
    public static int m9625p(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & KeycodeConstants.KEYCODE_MEDIA_PAUSE) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while (read >= 0 && (read & 128) != 0) {
            i3 = (i3 | (read & KeycodeConstants.KEYCODE_MEDIA_PAUSE)) << 7;
            read = inputStream.read();
        }
        if (read >= 0) {
            return i3 | (read & KeycodeConstants.KEYCODE_MEDIA_PAUSE);
        }
        throw new EOFException("EOF found inside tag value.");
    }

    /* renamed from: a */
    public eq0 m9626a(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        es0 es0Var = new es0(this, i3, this.f7783O);
        if ((i & 64) != 0) {
            return new ur0(z, i2, es0Var.m3553f());
        }
        if ((i & 128) != 0) {
            return new hq0(es0Var).m4640c(z, i2);
        }
        if (!z) {
            return m9621b(i2, es0Var, this.f7785Q);
        }
        if (i2 != 4) {
            if (i2 == 8) {
                return new wr0(m9630x(es0Var));
            }
            if (i2 == 16) {
                return this.f7784P ? new hs0(es0Var.m3553f()) : xr0.m9878a(m9630x(es0Var));
            }
            if (i2 == 17) {
                return xr0.m9879b(m9630x(es0Var));
            }
            throw new IOException("unknown tag " + i2 + " encountered");
        }
        rp0 m9630x = m9630x(es0Var);
        int m8228f = m9630x.m8228f();
        bq0[] bq0VarArr = new bq0[m8228f];
        for (int i4 = 0; i4 != m8228f; i4++) {
            ASN1Encodable m8226d = m9630x.m8226d(i4);
            if (!(m8226d instanceof bq0)) {
                throw new tp0("unknown object encountered in constructed OCTET STRING: " + m8226d.getClass());
            }
            bq0VarArr[i4] = (bq0) m8226d;
        }
        return new nq0(bq0VarArr);
    }

    /* renamed from: f */
    public int m9627f() {
        return this.f7783O;
    }

    /* renamed from: h */
    public int m9628h() throws IOException {
        return m9624l(this, this.f7783O, false);
    }

    /* renamed from: n */
    public eq0 m9629n() throws IOException {
        int read = read();
        if (read <= 0) {
            if (read != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int m9625p = m9625p(this, read);
        boolean z = (read & 32) != 0;
        int m9628h = m9628h();
        if (m9628h >= 0) {
            try {
                return m9626a(read, m9625p, m9628h);
            } catch (IllegalArgumentException e) {
                throw new tp0("corrupted stream detected", e);
            }
        }
        if (!z) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        hq0 hq0Var = new hq0(new fs0(this, this.f7783O), this.f7783O);
        if ((read & 64) != 0) {
            return new lq0(m9625p, hq0Var).mo2595g();
        }
        if ((read & 128) != 0) {
            return new uq0(true, m9625p, hq0Var).mo2595g();
        }
        if (m9625p == 4) {
            return new oq0(hq0Var).mo2595g();
        }
        if (m9625p == 8) {
            return new zq0(hq0Var).mo2595g();
        }
        if (m9625p == 16) {
            return new qq0(hq0Var).mo2595g();
        }
        if (m9625p == 17) {
            return new sq0(hq0Var).mo2595g();
        }
        throw new IOException("unknown BER object encountered");
    }

    /* renamed from: x */
    public rp0 m9630x(es0 es0Var) throws IOException {
        if (es0Var.m3551c() < 1) {
            return new rp0(0);
        }
        wp0 wp0Var = new wp0(es0Var);
        rp0 rp0Var = new rp0();
        while (true) {
            eq0 m9629n = wp0Var.m9629n();
            if (m9629n == null) {
                return rp0Var;
            }
            rp0Var.m8224a(m9629n);
        }
    }
}
