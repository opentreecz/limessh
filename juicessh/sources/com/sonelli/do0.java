package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Header;
import okio.BufferedSource;
import okio.Source;

/* compiled from: Hpack.java */
/* loaded from: classes.dex */
public final class do0 {

    /* renamed from: a */
    public static final Header[] f2250a;

    /* renamed from: b */
    public static final Map<ap0, Integer> f2251b;

    /* compiled from: Hpack.java */
    /* renamed from: com.sonelli.do0$a */
    /* loaded from: classes.dex */
    public static final class C0892a {

        /* renamed from: a */
        public final List<Header> f2252a;

        /* renamed from: b */
        public final BufferedSource f2253b;

        /* renamed from: c */
        public final int f2254c;

        /* renamed from: d */
        public int f2255d;

        /* renamed from: e */
        public Header[] f2256e;

        /* renamed from: f */
        public int f2257f;

        /* renamed from: g */
        public int f2258g;

        /* renamed from: h */
        public int f2259h;

        public C0892a(int i, int i2, Source source) {
            this.f2252a = new ArrayList();
            this.f2256e = new Header[8];
            this.f2257f = r0.length - 1;
            this.f2258g = 0;
            this.f2259h = 0;
            this.f2254c = i;
            this.f2255d = i2;
            this.f2253b = gp0.m4228b(source);
        }

        public C0892a(int i, Source source) {
            this(i, i, source);
        }

        /* renamed from: a */
        public final void m3279a() {
            int i = this.f2255d;
            int i2 = this.f2259h;
            if (i < i2) {
                if (i == 0) {
                    m3280b();
                } else {
                    m3282d(i2 - i);
                }
            }
        }

        /* renamed from: b */
        public final void m3280b() {
            Arrays.fill(this.f2256e, (Object) null);
            this.f2257f = this.f2256e.length - 1;
            this.f2258g = 0;
            this.f2259h = 0;
        }

        /* renamed from: c */
        public final int m3281c(int i) {
            return this.f2257f + 1 + i;
        }

        /* renamed from: d */
        public final int m3282d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f2256e.length;
                while (true) {
                    length--;
                    i2 = this.f2257f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f2256e;
                    i -= headerArr[length].f8664c;
                    this.f2259h -= headerArr[length].f8664c;
                    this.f2258g--;
                    i3++;
                }
                Header[] headerArr2 = this.f2256e;
                System.arraycopy(headerArr2, i2 + 1, headerArr2, i2 + 1 + i3, this.f2258g);
                this.f2257f += i3;
            }
            return i3;
        }

        /* renamed from: e */
        public List<Header> m3283e() {
            ArrayList arrayList = new ArrayList(this.f2252a);
            this.f2252a.clear();
            return arrayList;
        }

        /* renamed from: f */
        public final ap0 m3284f(int i) throws IOException {
            if (m3286h(i)) {
                return do0.f2250a[i].f8662a;
            }
            int m3281c = m3281c(i - do0.f2250a.length);
            if (m3281c >= 0) {
                Header[] headerArr = this.f2256e;
                if (m3281c < headerArr.length) {
                    return headerArr[m3281c].f8662a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: g */
        public final void m3285g(int i, Header header) {
            this.f2252a.add(header);
            int i2 = header.f8664c;
            if (i != -1) {
                i2 -= this.f2256e[m3281c(i)].f8664c;
            }
            int i3 = this.f2255d;
            if (i2 > i3) {
                m3280b();
                return;
            }
            int m3282d = m3282d((this.f2259h + i2) - i3);
            if (i == -1) {
                int i4 = this.f2258g + 1;
                Header[] headerArr = this.f2256e;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f2257f = this.f2256e.length - 1;
                    this.f2256e = headerArr2;
                }
                int i5 = this.f2257f;
                this.f2257f = i5 - 1;
                this.f2256e[i5] = header;
                this.f2258g++;
            } else {
                this.f2256e[i + m3281c(i) + m3282d] = header;
            }
            this.f2259h += i2;
        }

        /* renamed from: h */
        public final boolean m3286h(int i) {
            return i >= 0 && i <= do0.f2250a.length - 1;
        }

        /* renamed from: i */
        public final int m3287i() throws IOException {
            return this.f2253b.readByte() & 255;
        }

        /* renamed from: j */
        public ap0 m3288j() throws IOException {
            int m3287i = m3287i();
            boolean z = (m3287i & 128) == 128;
            int m3291m = m3291m(m3287i, KeycodeConstants.KEYCODE_MEDIA_PAUSE);
            return z ? ap0.m2234r(jo0.m5174f().m5177c(this.f2253b.mo4897L(m3291m))) : this.f2253b.mo4906k(m3291m);
        }

        /* renamed from: k */
        public void m3289k() throws IOException {
            while (!this.f2253b.mo4907s()) {
                int readByte = this.f2253b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m3290l(m3291m(readByte, KeycodeConstants.KEYCODE_MEDIA_PAUSE) - 1);
                } else if (readByte == 64) {
                    m3293o();
                } else if ((readByte & 64) == 64) {
                    m3292n(m3291m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m3291m = m3291m(readByte, 31);
                    this.f2255d = m3291m;
                    if (m3291m < 0 || m3291m > this.f2254c) {
                        throw new IOException("Invalid dynamic table size update " + this.f2255d);
                    }
                    m3279a();
                } else if (readByte == 16 || readByte == 0) {
                    m3295q();
                } else {
                    m3294p(m3291m(readByte, 15) - 1);
                }
            }
        }

        /* renamed from: l */
        public final void m3290l(int i) throws IOException {
            if (m3286h(i)) {
                this.f2252a.add(do0.f2250a[i]);
                return;
            }
            int m3281c = m3281c(i - do0.f2250a.length);
            if (m3281c >= 0) {
                Header[] headerArr = this.f2256e;
                if (m3281c < headerArr.length) {
                    this.f2252a.add(headerArr[m3281c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: m */
        public int m3291m(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int m3287i = m3287i();
                if ((m3287i & 128) == 0) {
                    return i2 + (m3287i << i4);
                }
                i2 += (m3287i & KeycodeConstants.KEYCODE_MEDIA_PAUSE) << i4;
                i4 += 7;
            }
        }

        /* renamed from: n */
        public final void m3292n(int i) throws IOException {
            m3285g(-1, new Header(m3284f(i), m3288j()));
        }

        /* renamed from: o */
        public final void m3293o() throws IOException {
            ap0 m3288j = m3288j();
            do0.m3277a(m3288j);
            m3285g(-1, new Header(m3288j, m3288j()));
        }

        /* renamed from: p */
        public final void m3294p(int i) throws IOException {
            this.f2252a.add(new Header(m3284f(i), m3288j()));
        }

        /* renamed from: q */
        public final void m3295q() throws IOException {
            ap0 m3288j = m3288j();
            do0.m3277a(m3288j);
            this.f2252a.add(new Header(m3288j, m3288j()));
        }
    }

    /* compiled from: Hpack.java */
    /* renamed from: com.sonelli.do0$b */
    /* loaded from: classes.dex */
    public static final class C0893b {

        /* renamed from: a */
        public final zo0 f2260a;

        /* renamed from: b */
        public final boolean f2261b;

        /* renamed from: c */
        public int f2262c;

        /* renamed from: d */
        public boolean f2263d;

        /* renamed from: e */
        public int f2264e;

        /* renamed from: f */
        public Header[] f2265f;

        /* renamed from: g */
        public int f2266g;

        /* renamed from: h */
        public int f2267h;

        /* renamed from: i */
        public int f2268i;

        public C0893b(int i, boolean z, zo0 zo0Var) {
            this.f2262c = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f2265f = new Header[8];
            this.f2266g = r0.length - 1;
            this.f2267h = 0;
            this.f2268i = 0;
            this.f2264e = i;
            this.f2261b = z;
            this.f2260a = zo0Var;
        }

        public C0893b(zo0 zo0Var) {
            this(4096, true, zo0Var);
        }

        /* renamed from: a */
        public final void m3296a() {
            int i = this.f2264e;
            int i2 = this.f2268i;
            if (i < i2) {
                if (i == 0) {
                    m3297b();
                } else {
                    m3298c(i2 - i);
                }
            }
        }

        /* renamed from: b */
        public final void m3297b() {
            Arrays.fill(this.f2265f, (Object) null);
            this.f2266g = this.f2265f.length - 1;
            this.f2267h = 0;
            this.f2268i = 0;
        }

        /* renamed from: c */
        public final int m3298c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f2265f.length;
                while (true) {
                    length--;
                    i2 = this.f2266g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f2265f;
                    i -= headerArr[length].f8664c;
                    this.f2268i -= headerArr[length].f8664c;
                    this.f2267h--;
                    i3++;
                }
                Header[] headerArr2 = this.f2265f;
                System.arraycopy(headerArr2, i2 + 1, headerArr2, i2 + 1 + i3, this.f2267h);
                Header[] headerArr3 = this.f2265f;
                int i4 = this.f2266g;
                Arrays.fill(headerArr3, i4 + 1, i4 + 1 + i3, (Object) null);
                this.f2266g += i3;
            }
            return i3;
        }

        /* renamed from: d */
        public final void m3299d(Header header) {
            int i = header.f8664c;
            int i2 = this.f2264e;
            if (i > i2) {
                m3297b();
                return;
            }
            m3298c((this.f2268i + i) - i2);
            int i3 = this.f2267h + 1;
            Header[] headerArr = this.f2265f;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f2266g = this.f2265f.length - 1;
                this.f2265f = headerArr2;
            }
            int i4 = this.f2266g;
            this.f2266g = i4 - 1;
            this.f2265f[i4] = header;
            this.f2267h++;
            this.f2268i += i;
        }

        /* renamed from: e */
        public void m3300e(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f2264e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f2262c = Math.min(this.f2262c, min);
            }
            this.f2263d = true;
            this.f2264e = min;
            m3296a();
        }

        /* renamed from: f */
        public void m3301f(ap0 ap0Var) throws IOException {
            if (!this.f2261b || jo0.m5174f().m5179e(ap0Var) >= ap0Var.mo2247w()) {
                m3303h(ap0Var.mo2247w(), KeycodeConstants.KEYCODE_MEDIA_PAUSE, 0);
                this.f2260a.m10561j0(ap0Var);
                return;
            }
            zo0 zo0Var = new zo0();
            jo0.m5174f().m5178d(ap0Var, zo0Var);
            ap0 m10549a0 = zo0Var.m10549a0();
            m3303h(m10549a0.mo2247w(), KeycodeConstants.KEYCODE_MEDIA_PAUSE, 128);
            this.f2260a.m10561j0(m10549a0);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void m3302g(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sonelli.do0.C0893b.m3302g(java.util.List):void");
        }

        /* renamed from: h */
        public void m3303h(int i, int i2, int i3) {
            if (i < i2) {
                this.f2260a.m10565m0(i | i3);
                return;
            }
            this.f2260a.m10565m0(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f2260a.m10565m0(128 | (i4 & KeycodeConstants.KEYCODE_MEDIA_PAUSE));
                i4 >>>= 7;
            }
            this.f2260a.m10565m0(i4);
        }
    }

    static {
        ap0 ap0Var = Header.f8658f;
        ap0 ap0Var2 = Header.f8659g;
        ap0 ap0Var3 = Header.f8660h;
        ap0 ap0Var4 = Header.f8657e;
        f2250a = new Header[]{new Header(Header.f8661i, ""), new Header(ap0Var, "GET"), new Header(ap0Var, "POST"), new Header(ap0Var2, "/"), new Header(ap0Var2, "/index.html"), new Header(ap0Var3, "http"), new Header(ap0Var3, "https"), new Header(ap0Var4, "200"), new Header(ap0Var4, "204"), new Header(ap0Var4, "206"), new Header(ap0Var4, "304"), new Header(ap0Var4, "400"), new Header(ap0Var4, "404"), new Header(ap0Var4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f2251b = m3278b();
    }

    /* renamed from: a */
    public static ap0 m3277a(ap0 ap0Var) throws IOException {
        int mo2247w = ap0Var.mo2247w();
        for (int i = 0; i < mo2247w; i++) {
            byte mo2241p = ap0Var.mo2241p(i);
            if (mo2241p >= 65 && mo2241p <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + ap0Var.mo2236B());
            }
        }
        return ap0Var;
    }

    /* renamed from: b */
    public static Map<ap0, Integer> m3278b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f2250a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f2250a;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].f8662a)) {
                linkedHashMap.put(headerArr[i].f8662a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
