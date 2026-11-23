package cz.opentree;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.EncodableDigest;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public abstract class nt0 implements ExtendedDigest, Memoable, EncodableDigest {

    /* renamed from: o */
    public static final long[] f5363o = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* renamed from: c */
    public long f5366c;

    /* renamed from: d */
    public long f5367d;

    /* renamed from: e */
    public long f5368e;

    /* renamed from: f */
    public long f5369f;

    /* renamed from: g */
    public long f5370g;

    /* renamed from: h */
    public long f5371h;

    /* renamed from: i */
    public long f5372i;

    /* renamed from: j */
    public long f5373j;

    /* renamed from: k */
    public long f5374k;

    /* renamed from: l */
    public long f5375l;

    /* renamed from: n */
    public int f5377n;

    /* renamed from: a */
    public byte[] f5364a = new byte[8];

    /* renamed from: m */
    public long[] f5376m = new long[80];

    /* renamed from: b */
    public int f5365b = 0;

    public nt0() {
        mo6793r();
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: a */
    public void mo6293a(byte[] bArr, int i, int i2) {
        while (this.f5365b != 0 && i2 > 0) {
            mo6294c(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.f5364a.length) {
            m6792q(bArr, i);
            byte[] bArr2 = this.f5364a;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.f5366c += bArr2.length;
        }
        while (i2 > 0) {
            mo6294c(bArr[i]);
            i++;
            i2--;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: c */
    public void mo6294c(byte b) {
        byte[] bArr = this.f5364a;
        int i = this.f5365b;
        int i2 = i + 1;
        this.f5365b = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            m6792q(bArr, 0);
            this.f5365b = 0;
        }
        this.f5366c++;
    }

    /* renamed from: g */
    public final long m6782g(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    /* renamed from: h */
    public final long m6783h(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    /* renamed from: i */
    public final long m6784i(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    /* renamed from: j */
    public final long m6785j(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    /* renamed from: k */
    public final long m6786k(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    /* renamed from: l */
    public final long m6787l(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    /* renamed from: m */
    public final void m6788m() {
        long j = this.f5366c;
        if (j > 2305843009213693951L) {
            this.f5367d += j >>> 61;
            this.f5366c = j & 2305843009213693951L;
        }
    }

    /* renamed from: n */
    public void m6789n() {
        m6788m();
        long j = this.f5366c << 3;
        long j2 = this.f5367d;
        byte b = Byte.MIN_VALUE;
        while (true) {
            mo6294c(b);
            if (this.f5365b == 0) {
                m6791p(j, j2);
                m6790o();
                return;
            }
            b = 0;
        }
    }

    /* renamed from: o */
    public void m6790o() {
        m6788m();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.f5376m;
            long m6785j = m6785j(jArr[i - 2]);
            long[] jArr2 = this.f5376m;
            jArr[i] = m6785j + jArr2[i - 7] + m6784i(jArr2[i - 15]) + this.f5376m[i - 16];
        }
        long j = this.f5368e;
        long j2 = this.f5369f;
        long j3 = this.f5370g;
        long j4 = this.f5371h;
        long j5 = this.f5372i;
        long j6 = this.f5373j;
        long j7 = this.f5374k;
        long j8 = j6;
        long j9 = j4;
        int i2 = 0;
        long j10 = j2;
        long j11 = j3;
        long j12 = j5;
        int i3 = 0;
        long j13 = this.f5375l;
        long j14 = j;
        long j15 = j7;
        while (i3 < 10) {
            long j16 = j12;
            long m6787l = m6787l(j12) + m6782g(j12, j8, j15);
            long[] jArr3 = f5363o;
            int i4 = i2 + 1;
            long j17 = j13 + m6787l + jArr3[i2] + this.f5376m[i2];
            long j18 = j9 + j17;
            long m6786k = j17 + m6786k(j14) + m6783h(j14, j10, j11);
            int i5 = i4 + 1;
            long m6787l2 = j15 + m6787l(j18) + m6782g(j18, j16, j8) + jArr3[i4] + this.f5376m[i4];
            long j19 = j11 + m6787l2;
            long m6786k2 = m6787l2 + m6786k(m6786k) + m6783h(m6786k, j14, j10);
            int i6 = i5 + 1;
            long m6787l3 = j8 + m6787l(j19) + m6782g(j19, j18, j16) + jArr3[i5] + this.f5376m[i5];
            long j20 = j10 + m6787l3;
            long m6786k3 = m6787l3 + m6786k(m6786k2) + m6783h(m6786k2, m6786k, j14);
            int i7 = i6 + 1;
            long m6787l4 = j16 + m6787l(j20) + m6782g(j20, j19, j18) + jArr3[i6] + this.f5376m[i6];
            long j21 = j14 + m6787l4;
            long m6786k4 = m6787l4 + m6786k(m6786k3) + m6783h(m6786k3, m6786k2, m6786k);
            int i8 = i7 + 1;
            long m6787l5 = j18 + m6787l(j21) + m6782g(j21, j20, j19) + jArr3[i7] + this.f5376m[i7];
            long j22 = m6786k + m6787l5;
            long m6786k5 = m6787l5 + m6786k(m6786k4) + m6783h(m6786k4, m6786k3, m6786k2);
            int i9 = i8 + 1;
            long m6787l6 = j19 + m6787l(j22) + m6782g(j22, j21, j20) + jArr3[i8] + this.f5376m[i8];
            long j23 = m6786k2 + m6787l6;
            long m6786k6 = m6787l6 + m6786k(m6786k5) + m6783h(m6786k5, m6786k4, m6786k3);
            j15 = j23;
            int i10 = i9 + 1;
            long m6787l7 = j20 + m6787l(j23) + m6782g(j23, j22, j21) + jArr3[i9] + this.f5376m[i9];
            long j24 = m6786k3 + m6787l7;
            j8 = j24;
            j10 = m6787l7 + m6786k(m6786k6) + m6783h(m6786k6, m6786k5, m6786k4);
            long m6787l8 = j21 + m6787l(j24) + m6782g(j24, j15, j22) + jArr3[i10] + this.f5376m[i10];
            long m6786k7 = m6787l8 + m6786k(j10) + m6783h(j10, m6786k6, m6786k5);
            i3++;
            j12 = m6786k4 + m6787l8;
            j11 = m6786k6;
            j13 = j22;
            j9 = m6786k5;
            i2 = i10 + 1;
            j14 = m6786k7;
        }
        this.f5368e += j14;
        this.f5369f += j10;
        this.f5370g += j11;
        this.f5371h += j9;
        this.f5372i += j12;
        this.f5373j += j8;
        this.f5374k += j15;
        this.f5375l += j13;
        this.f5377n = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.f5376m[i11] = 0;
        }
    }

    /* renamed from: p */
    public void m6791p(long j, long j2) {
        if (this.f5377n > 14) {
            m6790o();
        }
        long[] jArr = this.f5376m;
        jArr[14] = j2;
        jArr[15] = j;
    }

    /* renamed from: q */
    public void m6792q(byte[] bArr, int i) {
        this.f5376m[this.f5377n] = h51.m4366b(bArr, i);
        int i2 = this.f5377n + 1;
        this.f5377n = i2;
        if (i2 == 16) {
            m6790o();
        }
    }

    /* renamed from: r */
    public void mo6793r() {
        this.f5366c = 0L;
        this.f5367d = 0L;
        int i = 0;
        this.f5365b = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f5364a;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.f5377n = 0;
        while (true) {
            long[] jArr = this.f5376m;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }
}
