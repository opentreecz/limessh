package cz.opentree;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zzad;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import cz.opentree.C1610nk;
import cz.opentree.C1722pk;
import cz.opentree.C1766qk;
import cz.opentree.C1821rk;
import cz.opentree.C2175vk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public class z30 implements zzgu {

    /* renamed from: x */
    public static volatile z30 f8426x;

    /* renamed from: a */
    public C1792qz f8427a;

    /* renamed from: b */
    public C0744az f8428b;

    /* renamed from: c */
    public C0845cu f8429c;

    /* renamed from: d */
    public C0853cz f8430d;

    /* renamed from: e */
    public v30 f8431e;

    /* renamed from: f */
    public o40 f8432f;

    /* renamed from: g */
    public final d40 f8433g;

    /* renamed from: h */
    public z10 f8434h;

    /* renamed from: i */
    public final C2144uz f8435i;

    /* renamed from: j */
    public boolean f8436j;

    /* renamed from: k */
    public boolean f8437k;

    /* renamed from: l */
    public long f8438l;

    /* renamed from: m */
    public List<Runnable> f8439m;

    /* renamed from: n */
    public int f8440n;

    /* renamed from: o */
    public int f8441o;

    /* renamed from: p */
    public boolean f8442p;

    /* renamed from: q */
    public boolean f8443q;

    /* renamed from: r */
    public boolean f8444r;

    /* renamed from: s */
    public FileLock f8445s;

    /* renamed from: t */
    public FileChannel f8446t;

    /* renamed from: u */
    public List<Long> f8447u;

    /* renamed from: v */
    public List<Long> f8448v;

    /* renamed from: w */
    public long f8449w;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.z30$a */
    /* loaded from: classes.dex */
    public class C2410a implements zzad {

        /* renamed from: a */
        public C1821rk f8450a;

        /* renamed from: b */
        public List<Long> f8451b;

        /* renamed from: c */
        public List<C1610nk> f8452c;

        /* renamed from: d */
        public long f8453d;

        public C2410a(z30 z30Var) {
        }

        public /* synthetic */ C2410a(z30 z30Var, y30 y30Var) {
            this(z30Var);
        }

        /* renamed from: c */
        public static long m10389c(C1610nk c1610nk) {
            return ((c1610nk.m6711Y() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.measurement.internal.zzad
        /* renamed from: a */
        public final void mo1453a(C1821rk c1821rk) {
            C0813ca.m2729k(c1821rk);
            this.f8450a = c1821rk;
        }

        @Override // com.google.android.gms.measurement.internal.zzad
        /* renamed from: b */
        public final boolean mo1454b(long j, C1610nk c1610nk) {
            C0813ca.m2729k(c1610nk);
            if (this.f8452c == null) {
                this.f8452c = new ArrayList();
            }
            if (this.f8451b == null) {
                this.f8451b = new ArrayList();
            }
            if (this.f8452c.size() > 0 && m10389c(this.f8452c.get(0)) != m10389c(c1610nk)) {
                return false;
            }
            long mo1267j = this.f8453d + c1610nk.mo1267j();
            if (mo1267j >= Math.max(0, C1735pu.f5841j.m6320a(null).intValue())) {
                return false;
            }
            this.f8453d = mo1267j;
            this.f8452c.add(c1610nk);
            this.f8451b.add(Long.valueOf(j));
            return this.f8452c.size() < Math.max(1, C1735pu.f5843k.m6320a(null).intValue());
        }
    }

    public z30(e40 e40Var) {
        this(e40Var, null);
    }

    public z30(e40 e40Var, C2144uz c2144uz) {
        this.f8436j = false;
        C0813ca.m2729k(e40Var);
        C2144uz m9091a = C2144uz.m9091a(e40Var.f2334a, null, null);
        this.f8435i = m9091a;
        this.f8449w = -1L;
        d40 d40Var = new d40(this);
        d40Var.m9405u();
        this.f8433g = d40Var;
        C0744az c0744az = new C0744az(this);
        c0744az.m9405u();
        this.f8428b = c0744az;
        C1792qz c1792qz = new C1792qz(this);
        c1792qz.m9405u();
        this.f8427a = c1792qz;
        m9091a.mo1481g().m8281A(new y30(this, e40Var));
    }

    /* renamed from: L */
    public static void m10330L(w30 w30Var) {
        if (w30Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (w30Var.m9403s()) {
            return;
        }
        String valueOf = String.valueOf(w30Var.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: c */
    public static z30 m10331c(Context context) {
        C0813ca.m2729k(context);
        C0813ca.m2729k(context.getApplicationContext());
        if (f8426x == null) {
            synchronized (z30.class) {
                if (f8426x == null) {
                    f8426x = new z30(new e40(context));
                }
            }
        }
        return f8426x;
    }

    /* renamed from: l */
    public static void m10332l(C1610nk.a aVar, int i, String str) {
        List<C1722pk> m6722E = aVar.m6722E();
        for (int i2 = 0; i2 < m6722E.size(); i2++) {
            if ("_err".equals(m6722E.get(i2).m7363P())) {
                return;
            }
        }
        C1722pk.a m7356e0 = C1722pk.m7356e0();
        m7356e0.m7380B("_err");
        m7356e0.m7388y(Long.valueOf(i).longValue());
        C1722pk c1722pk = (C1722pk) ((AbstractC2303xn) m7356e0.mo1259f());
        C1722pk.a m7356e02 = C1722pk.m7356e0();
        m7356e02.m7380B("_ev");
        m7356e02.m7382D(str);
        C1722pk c1722pk2 = (C1722pk) ((AbstractC2303xn) m7356e02.mo1259f());
        aVar.m6718A(c1722pk);
        aVar.m6718A(c1722pk2);
    }

    /* renamed from: m */
    public static void m10333m(C1610nk.a aVar, @NonNull String str) {
        List<C1722pk> m6722E = aVar.m6722E();
        for (int i = 0; i < m6722E.size(); i++) {
            if (str.equals(m6722E.get(i).m7363P())) {
                aVar.m6724G(i);
                return;
            }
        }
    }

    /* renamed from: n */
    public static void m10334n(C1821rk.a aVar) {
        aVar.m8095J(RecyclerView.FOREVER_NS);
        aVar.m8100P(Long.MIN_VALUE);
        for (int i = 0; i < aVar.m8093H(); i++) {
            C1610nk m8094I = aVar.m8094I(i);
            if (m8094I.m6711Y() < aVar.m8112b0()) {
                aVar.m8095J(m8094I.m6711Y());
            }
            if (m8094I.m6711Y() > aVar.m8116f0()) {
                aVar.m8100P(m8094I.m6711Y());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r6.f8435i.m9096B().f2562g.m4969b(r6.f8435i.mo1483i().mo1177a());
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    @androidx.annotation.WorkerThread
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10336A(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10336A(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* renamed from: B */
    public final void m10337B(boolean z) {
        m10377l0();
    }

    @WorkerThread
    /* renamed from: C */
    public final boolean m10338C(int i, FileChannel fileChannel) {
        m10373i0();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f8435i.mo1484j().m8522H().m9083a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.f8435i.m9130y().m2630u(C1735pu.f5781B0) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.f8435i.mo1484j().m8522H().m9084b("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.f8435i.mo1484j().m8522H().m9084b("Failed to write to channel", e);
            return false;
        }
    }

    /* renamed from: D */
    public final boolean m10339D(C1610nk.a aVar, C1610nk.a aVar2) {
        C0813ca.m2719a("_e".equals(aVar.m6727J()));
        m10359Y();
        C1722pk m3131z = d40.m3131z((C1610nk) ((AbstractC2303xn) aVar.mo1259f()), "_sc");
        String m7366V = m3131z == null ? null : m3131z.m7366V();
        m10359Y();
        C1722pk m3131z2 = d40.m3131z((C1610nk) ((AbstractC2303xn) aVar2.mo1259f()), "_pc");
        String m7366V2 = m3131z2 != null ? m3131z2.m7366V() : null;
        if (m7366V2 == null || !m7366V2.equals(m7366V)) {
            return false;
        }
        m10345J(aVar, aVar2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0598 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x066f A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0816 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0826 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0840 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x080a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0256 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0262 A[Catch: all -> 0x0f33, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0f1b A[Catch: all -> 0x0f33, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:552:0x024f A[Catch: all -> 0x0f33, TRY_ENTER, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0f2f A[Catch: all -> 0x0f33, TRY_ENTER, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:582:? A[Catch: all -> 0x0f33, SYNTHETIC, TRY_LEAVE, TryCatch #3 {all -> 0x0f33, blocks: (B:3:0x000d, B:19:0x0084, B:20:0x0252, B:22:0x0256, B:27:0x0262, B:28:0x0288, B:31:0x02a0, B:34:0x02c6, B:36:0x02fd, B:41:0x0313, B:43:0x031d, B:46:0x0891, B:48:0x0343, B:51:0x035b, B:68:0x03be, B:71:0x03c8, B:73:0x03d6, B:75:0x0421, B:76:0x03f4, B:78:0x0403, B:86:0x042e, B:88:0x0465, B:89:0x0494, B:91:0x04c8, B:92:0x04ce, B:95:0x04da, B:97:0x050f, B:98:0x052c, B:100:0x0532, B:102:0x0540, B:104:0x0554, B:105:0x0549, B:113:0x055b, B:115:0x0561, B:116:0x057d, B:118:0x0598, B:119:0x05a4, B:122:0x05ae, B:126:0x05d1, B:127:0x05c0, B:135:0x05d7, B:137:0x05e3, B:139:0x05ef, B:144:0x063e, B:145:0x065b, B:147:0x066f, B:149:0x067c, B:152:0x068f, B:154:0x06a1, B:156:0x06af, B:160:0x0816, B:162:0x0820, B:164:0x0826, B:165:0x0840, B:167:0x0854, B:168:0x086e, B:169:0x0877, B:175:0x06d5, B:177:0x06e5, B:180:0x06fa, B:182:0x070c, B:184:0x071a, B:187:0x072d, B:189:0x0745, B:191:0x0751, B:194:0x0764, B:196:0x0778, B:198:0x07c3, B:199:0x07ca, B:201:0x07d0, B:203:0x07db, B:204:0x07e2, B:206:0x07e8, B:208:0x07f3, B:209:0x0804, B:213:0x0610, B:217:0x0624, B:219:0x062a, B:221:0x0635, B:233:0x037d, B:236:0x0387, B:239:0x0391, B:248:0x08ab, B:250:0x08b9, B:252:0x08c2, B:254:0x08f4, B:255:0x08ca, B:257:0x08d3, B:259:0x08d9, B:261:0x08e5, B:263:0x08ef, B:271:0x08fb, B:272:0x0907, B:274:0x090d, B:280:0x0926, B:281:0x0931, B:285:0x093e, B:286:0x0965, B:288:0x0984, B:290:0x0992, B:292:0x0998, B:294:0x09a2, B:295:0x09d1, B:297:0x09d7, B:301:0x09e5, B:303:0x09f0, B:299:0x09ea, B:306:0x09f3, B:308:0x0a05, B:309:0x0a08, B:381:0x0a77, B:383:0x0a93, B:384:0x0aa4, B:386:0x0aa8, B:388:0x0ab4, B:389:0x0abd, B:391:0x0ac1, B:393:0x0ac7, B:394:0x0ad6, B:395:0x0ae1, B:402:0x0b21, B:403:0x0b29, B:405:0x0b2f, B:409:0x0b41, B:411:0x0b45, B:415:0x0b7b, B:417:0x0b91, B:462:0x0b53, B:464:0x0b57, B:466:0x0b61, B:468:0x0b65, B:313:0x0d78, B:315:0x0d8a, B:316:0x0d8d, B:318:0x0d9f, B:319:0x0e14, B:321:0x0e1a, B:323:0x0e2f, B:326:0x0e36, B:327:0x0e69, B:328:0x0e3e, B:330:0x0e4a, B:331:0x0e50, B:332:0x0e7a, B:333:0x0e91, B:336:0x0e99, B:338:0x0e9e, B:341:0x0eae, B:343:0x0ec8, B:344:0x0ee1, B:346:0x0ee9, B:347:0x0f0b, B:354:0x0efa, B:355:0x0db9, B:357:0x0dbf, B:359:0x0dc9, B:360:0x0dd0, B:365:0x0de0, B:366:0x0de7, B:368:0x0e06, B:369:0x0e0d, B:370:0x0e0a, B:371:0x0de4, B:373:0x0dcd, B:486:0x0943, B:488:0x0949, B:494:0x0f1b, B:505:0x0120, B:519:0x01b8, B:535:0x01f1, B:531:0x0210, B:546:0x0229, B:552:0x024f, B:580:0x0f2f, B:581:0x0f32, B:569:0x00d9, B:508:0x0129), top: B:2:0x000d, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03a9  */
    /* JADX WARN: Type inference failed for: r5v0, types: [cz.opentree.y30] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    @androidx.annotation.WorkerThread
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m10340E(java.lang.String r44, long r45) {
        /*
            Method dump skipped, instructions count: 3901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10340E(java.lang.String, long):boolean");
    }

    @WorkerThread
    /* renamed from: F */
    public final void m10341F() {
        m10373i0();
        if (this.f8442p || this.f8443q || this.f8444r) {
            this.f8435i.mo1484j().m8530P().m9086d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f8442p), Boolean.valueOf(this.f8443q), Boolean.valueOf(this.f8444r));
            return;
        }
        this.f8435i.mo1484j().m8530P().m9083a("Stopping uploading service(s)");
        List<Runnable> list = this.f8439m;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f8439m.clear();
    }

    @WorkerThread
    /* renamed from: G */
    public final boolean m10342G() {
        FileLock fileLock;
        m10373i0();
        if (this.f8435i.m9130y().m2630u(C1735pu.f5852o0) && (fileLock = this.f8445s) != null && fileLock.isValid()) {
            this.f8435i.mo1484j().m8530P().m9083a("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f8435i.mo1482h().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f8446t = channel;
            FileLock tryLock = channel.tryLock();
            this.f8445s = tryLock;
            if (tryLock != null) {
                this.f8435i.mo1484j().m8530P().m9083a("Storage concurrent access okay");
                return true;
            }
            this.f8435i.mo1484j().m8522H().m9083a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.f8435i.mo1484j().m8522H().m9084b("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.f8435i.mo1484j().m8522H().m9084b("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            this.f8435i.mo1484j().m8525K().m9084b("Storage lock already acquired", e3);
            return false;
        }
    }

    /* renamed from: H */
    public final C0796bu m10343H() {
        return this.f8435i.m9130y();
    }

    @WorkerThread
    /* renamed from: I */
    public final Boolean m10344I(C2318xz c2318xz) {
        try {
            if (c2318xz.m9920V() != -2147483648L) {
                if (c2318xz.m9920V() == C2272xc.m9755a(this.f8435i.mo1482h()).m9468e(c2318xz.m9957t(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = C2272xc.m9755a(this.f8435i.mo1482h()).m9468e(c2318xz.m9957t(), 0).versionName;
                if (c2318xz.m9918T() != null && c2318xz.m9918T().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: J */
    public final void m10345J(C1610nk.a aVar, C1610nk.a aVar2) {
        C0813ca.m2719a("_e".equals(aVar.m6727J()));
        m10359Y();
        C1722pk m3131z = d40.m3131z((C1610nk) ((AbstractC2303xn) aVar.mo1259f()), "_et");
        if (!m3131z.m7368Y() || m3131z.m7369Z() <= 0) {
            return;
        }
        long m7369Z = m3131z.m7369Z();
        m10359Y();
        C1722pk m3131z2 = d40.m3131z((C1610nk) ((AbstractC2303xn) aVar2.mo1259f()), "_et");
        if (m3131z2 != null && m3131z2.m7369Z() > 0) {
            m7369Z += m3131z2.m7369Z();
        }
        m10359Y().m3136I(aVar2, "_et", Long.valueOf(m7369Z));
        m10359Y().m3136I(aVar, "_fr", 1L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:96|(1:98)(1:295)|99|(2:101|(1:103)(6:104|105|106|(1:108)|109|(0)))|287|288|289|290|105|106|(0)|109|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0955, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0359, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x035b, code lost:
    
        r7.mo1484j().m8522H().m9085c("Error pruning currencies. appId", cz.opentree.C1889sy.m8516y(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0391 A[Catch: all -> 0x09e6, TryCatch #2 {all -> 0x09e6, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:85:0x0273, B:87:0x027d, B:89:0x028b, B:92:0x02bc, B:94:0x02c2, B:96:0x02d0, B:98:0x02dc, B:99:0x02e6, B:101:0x02f1, B:104:0x02f8, B:106:0x0387, B:108:0x0391, B:111:0x03c8, B:114:0x03da, B:116:0x03ee, B:118:0x03fe, B:119:0x040f, B:121:0x0441, B:123:0x0446, B:124:0x045f, B:128:0x0470, B:130:0x0484, B:132:0x0489, B:133:0x04a2, B:137:0x04c5, B:141:0x04ea, B:142:0x0503, B:145:0x0512, B:148:0x0535, B:149:0x0551, B:151:0x055b, B:153:0x0567, B:155:0x056d, B:156:0x0578, B:158:0x0584, B:159:0x059b, B:161:0x05c5, B:164:0x05de, B:167:0x0621, B:168:0x0648, B:170:0x0680, B:171:0x0685, B:173:0x068d, B:174:0x0692, B:176:0x069a, B:177:0x069f, B:179:0x06a8, B:180:0x06ac, B:182:0x06b9, B:183:0x06be, B:185:0x06c4, B:187:0x06d4, B:189:0x06de, B:191:0x06e6, B:192:0x06eb, B:194:0x06f5, B:196:0x06ff, B:198:0x0707, B:199:0x0724, B:201:0x072c, B:202:0x072f, B:204:0x0744, B:206:0x074e, B:207:0x0751, B:209:0x075f, B:211:0x0769, B:213:0x076d, B:215:0x0778, B:216:0x07e4, B:218:0x0829, B:219:0x082e, B:221:0x0836, B:223:0x083f, B:224:0x0844, B:226:0x0850, B:228:0x08b4, B:229:0x08b9, B:230:0x08c5, B:232:0x08cf, B:233:0x08d6, B:235:0x08e0, B:236:0x08e7, B:237:0x08f2, B:239:0x08f8, B:242:0x0927, B:243:0x0937, B:245:0x093f, B:246:0x0943, B:248:0x0949, B:252:0x0991, B:254:0x0997, B:255:0x09b3, B:260:0x0957, B:262:0x097c, B:268:0x099b, B:269:0x0782, B:271:0x0794, B:273:0x0798, B:275:0x07aa, B:276:0x07e1, B:277:0x07c4, B:279:0x07ca, B:280:0x070d, B:282:0x0717, B:284:0x071f, B:285:0x063a, B:287:0x0320, B:289:0x033e, B:290:0x036c, B:294:0x035b, B:295:0x02e1, B:297:0x0295, B:298:0x02b2), top: B:53:0x01e7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c8 A[Catch: all -> 0x09e6, TRY_LEAVE, TryCatch #2 {all -> 0x09e6, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:85:0x0273, B:87:0x027d, B:89:0x028b, B:92:0x02bc, B:94:0x02c2, B:96:0x02d0, B:98:0x02dc, B:99:0x02e6, B:101:0x02f1, B:104:0x02f8, B:106:0x0387, B:108:0x0391, B:111:0x03c8, B:114:0x03da, B:116:0x03ee, B:118:0x03fe, B:119:0x040f, B:121:0x0441, B:123:0x0446, B:124:0x045f, B:128:0x0470, B:130:0x0484, B:132:0x0489, B:133:0x04a2, B:137:0x04c5, B:141:0x04ea, B:142:0x0503, B:145:0x0512, B:148:0x0535, B:149:0x0551, B:151:0x055b, B:153:0x0567, B:155:0x056d, B:156:0x0578, B:158:0x0584, B:159:0x059b, B:161:0x05c5, B:164:0x05de, B:167:0x0621, B:168:0x0648, B:170:0x0680, B:171:0x0685, B:173:0x068d, B:174:0x0692, B:176:0x069a, B:177:0x069f, B:179:0x06a8, B:180:0x06ac, B:182:0x06b9, B:183:0x06be, B:185:0x06c4, B:187:0x06d4, B:189:0x06de, B:191:0x06e6, B:192:0x06eb, B:194:0x06f5, B:196:0x06ff, B:198:0x0707, B:199:0x0724, B:201:0x072c, B:202:0x072f, B:204:0x0744, B:206:0x074e, B:207:0x0751, B:209:0x075f, B:211:0x0769, B:213:0x076d, B:215:0x0778, B:216:0x07e4, B:218:0x0829, B:219:0x082e, B:221:0x0836, B:223:0x083f, B:224:0x0844, B:226:0x0850, B:228:0x08b4, B:229:0x08b9, B:230:0x08c5, B:232:0x08cf, B:233:0x08d6, B:235:0x08e0, B:236:0x08e7, B:237:0x08f2, B:239:0x08f8, B:242:0x0927, B:243:0x0937, B:245:0x093f, B:246:0x0943, B:248:0x0949, B:252:0x0991, B:254:0x0997, B:255:0x09b3, B:260:0x0957, B:262:0x097c, B:268:0x099b, B:269:0x0782, B:271:0x0794, B:273:0x0798, B:275:0x07aa, B:276:0x07e1, B:277:0x07c4, B:279:0x07ca, B:280:0x070d, B:282:0x0717, B:284:0x071f, B:285:0x063a, B:287:0x0320, B:289:0x033e, B:290:0x036c, B:294:0x035b, B:295:0x02e1, B:297:0x0295, B:298:0x02b2), top: B:53:0x01e7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ee A[Catch: all -> 0x09e6, TryCatch #2 {all -> 0x09e6, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:85:0x0273, B:87:0x027d, B:89:0x028b, B:92:0x02bc, B:94:0x02c2, B:96:0x02d0, B:98:0x02dc, B:99:0x02e6, B:101:0x02f1, B:104:0x02f8, B:106:0x0387, B:108:0x0391, B:111:0x03c8, B:114:0x03da, B:116:0x03ee, B:118:0x03fe, B:119:0x040f, B:121:0x0441, B:123:0x0446, B:124:0x045f, B:128:0x0470, B:130:0x0484, B:132:0x0489, B:133:0x04a2, B:137:0x04c5, B:141:0x04ea, B:142:0x0503, B:145:0x0512, B:148:0x0535, B:149:0x0551, B:151:0x055b, B:153:0x0567, B:155:0x056d, B:156:0x0578, B:158:0x0584, B:159:0x059b, B:161:0x05c5, B:164:0x05de, B:167:0x0621, B:168:0x0648, B:170:0x0680, B:171:0x0685, B:173:0x068d, B:174:0x0692, B:176:0x069a, B:177:0x069f, B:179:0x06a8, B:180:0x06ac, B:182:0x06b9, B:183:0x06be, B:185:0x06c4, B:187:0x06d4, B:189:0x06de, B:191:0x06e6, B:192:0x06eb, B:194:0x06f5, B:196:0x06ff, B:198:0x0707, B:199:0x0724, B:201:0x072c, B:202:0x072f, B:204:0x0744, B:206:0x074e, B:207:0x0751, B:209:0x075f, B:211:0x0769, B:213:0x076d, B:215:0x0778, B:216:0x07e4, B:218:0x0829, B:219:0x082e, B:221:0x0836, B:223:0x083f, B:224:0x0844, B:226:0x0850, B:228:0x08b4, B:229:0x08b9, B:230:0x08c5, B:232:0x08cf, B:233:0x08d6, B:235:0x08e0, B:236:0x08e7, B:237:0x08f2, B:239:0x08f8, B:242:0x0927, B:243:0x0937, B:245:0x093f, B:246:0x0943, B:248:0x0949, B:252:0x0991, B:254:0x0997, B:255:0x09b3, B:260:0x0957, B:262:0x097c, B:268:0x099b, B:269:0x0782, B:271:0x0794, B:273:0x0798, B:275:0x07aa, B:276:0x07e1, B:277:0x07c4, B:279:0x07ca, B:280:0x070d, B:282:0x0717, B:284:0x071f, B:285:0x063a, B:287:0x0320, B:289:0x033e, B:290:0x036c, B:294:0x035b, B:295:0x02e1, B:297:0x0295, B:298:0x02b2), top: B:53:0x01e7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0441 A[Catch: all -> 0x09e6, TryCatch #2 {all -> 0x09e6, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:85:0x0273, B:87:0x027d, B:89:0x028b, B:92:0x02bc, B:94:0x02c2, B:96:0x02d0, B:98:0x02dc, B:99:0x02e6, B:101:0x02f1, B:104:0x02f8, B:106:0x0387, B:108:0x0391, B:111:0x03c8, B:114:0x03da, B:116:0x03ee, B:118:0x03fe, B:119:0x040f, B:121:0x0441, B:123:0x0446, B:124:0x045f, B:128:0x0470, B:130:0x0484, B:132:0x0489, B:133:0x04a2, B:137:0x04c5, B:141:0x04ea, B:142:0x0503, B:145:0x0512, B:148:0x0535, B:149:0x0551, B:151:0x055b, B:153:0x0567, B:155:0x056d, B:156:0x0578, B:158:0x0584, B:159:0x059b, B:161:0x05c5, B:164:0x05de, B:167:0x0621, B:168:0x0648, B:170:0x0680, B:171:0x0685, B:173:0x068d, B:174:0x0692, B:176:0x069a, B:177:0x069f, B:179:0x06a8, B:180:0x06ac, B:182:0x06b9, B:183:0x06be, B:185:0x06c4, B:187:0x06d4, B:189:0x06de, B:191:0x06e6, B:192:0x06eb, B:194:0x06f5, B:196:0x06ff, B:198:0x0707, B:199:0x0724, B:201:0x072c, B:202:0x072f, B:204:0x0744, B:206:0x074e, B:207:0x0751, B:209:0x075f, B:211:0x0769, B:213:0x076d, B:215:0x0778, B:216:0x07e4, B:218:0x0829, B:219:0x082e, B:221:0x0836, B:223:0x083f, B:224:0x0844, B:226:0x0850, B:228:0x08b4, B:229:0x08b9, B:230:0x08c5, B:232:0x08cf, B:233:0x08d6, B:235:0x08e0, B:236:0x08e7, B:237:0x08f2, B:239:0x08f8, B:242:0x0927, B:243:0x0937, B:245:0x093f, B:246:0x0943, B:248:0x0949, B:252:0x0991, B:254:0x0997, B:255:0x09b3, B:260:0x0957, B:262:0x097c, B:268:0x099b, B:269:0x0782, B:271:0x0794, B:273:0x0798, B:275:0x07aa, B:276:0x07e1, B:277:0x07c4, B:279:0x07ca, B:280:0x070d, B:282:0x0717, B:284:0x071f, B:285:0x063a, B:287:0x0320, B:289:0x033e, B:290:0x036c, B:294:0x035b, B:295:0x02e1, B:297:0x0295, B:298:0x02b2), top: B:53:0x01e7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0237 A[Catch: all -> 0x09e6, TRY_LEAVE, TryCatch #2 {all -> 0x09e6, blocks: (B:54:0x01e7, B:56:0x01f0, B:59:0x0201, B:63:0x020f, B:65:0x0219, B:69:0x0225, B:75:0x0237, B:78:0x0243, B:80:0x025a, B:85:0x0273, B:87:0x027d, B:89:0x028b, B:92:0x02bc, B:94:0x02c2, B:96:0x02d0, B:98:0x02dc, B:99:0x02e6, B:101:0x02f1, B:104:0x02f8, B:106:0x0387, B:108:0x0391, B:111:0x03c8, B:114:0x03da, B:116:0x03ee, B:118:0x03fe, B:119:0x040f, B:121:0x0441, B:123:0x0446, B:124:0x045f, B:128:0x0470, B:130:0x0484, B:132:0x0489, B:133:0x04a2, B:137:0x04c5, B:141:0x04ea, B:142:0x0503, B:145:0x0512, B:148:0x0535, B:149:0x0551, B:151:0x055b, B:153:0x0567, B:155:0x056d, B:156:0x0578, B:158:0x0584, B:159:0x059b, B:161:0x05c5, B:164:0x05de, B:167:0x0621, B:168:0x0648, B:170:0x0680, B:171:0x0685, B:173:0x068d, B:174:0x0692, B:176:0x069a, B:177:0x069f, B:179:0x06a8, B:180:0x06ac, B:182:0x06b9, B:183:0x06be, B:185:0x06c4, B:187:0x06d4, B:189:0x06de, B:191:0x06e6, B:192:0x06eb, B:194:0x06f5, B:196:0x06ff, B:198:0x0707, B:199:0x0724, B:201:0x072c, B:202:0x072f, B:204:0x0744, B:206:0x074e, B:207:0x0751, B:209:0x075f, B:211:0x0769, B:213:0x076d, B:215:0x0778, B:216:0x07e4, B:218:0x0829, B:219:0x082e, B:221:0x0836, B:223:0x083f, B:224:0x0844, B:226:0x0850, B:228:0x08b4, B:229:0x08b9, B:230:0x08c5, B:232:0x08cf, B:233:0x08d6, B:235:0x08e0, B:236:0x08e7, B:237:0x08f2, B:239:0x08f8, B:242:0x0927, B:243:0x0937, B:245:0x093f, B:246:0x0943, B:248:0x0949, B:252:0x0991, B:254:0x0997, B:255:0x09b3, B:260:0x0957, B:262:0x097c, B:268:0x099b, B:269:0x0782, B:271:0x0794, B:273:0x0798, B:275:0x07aa, B:276:0x07e1, B:277:0x07c4, B:279:0x07ca, B:280:0x070d, B:282:0x0717, B:284:0x071f, B:285:0x063a, B:287:0x0320, B:289:0x033e, B:290:0x036c, B:294:0x035b, B:295:0x02e1, B:297:0x0295, B:298:0x02b2), top: B:53:0x01e7, inners: #0, #1 }] */
    @androidx.annotation.WorkerThread
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10346K(com.google.android.gms.measurement.internal.zzaq r31, com.google.android.gms.measurement.internal.zzm r32) {
        /*
            Method dump skipped, instructions count: 2544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10346K(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzm):void");
    }

    @WorkerThread
    /* renamed from: M */
    public final void m10347M(zzkn zzknVar, zzm zzmVar) {
        m10373i0();
        m10364b0();
        if (m10356V(zzmVar)) {
            if (!zzmVar.f1004V) {
                m10352R(zzmVar);
                return;
            }
            if ("_npa".equals(zzknVar.f991P) && zzmVar.f1015g0 != null) {
                this.f8435i.mo1484j().m8529O().m9083a("Falling back to manifest metadata value for ad personalization");
                m10384v(new zzkn("_npa", this.f8435i.mo1483i().mo1177a(), Long.valueOf(zzmVar.f1015g0.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                return;
            }
            this.f8435i.mo1484j().m8529O().m9084b("Removing user property", this.f8435i.m9103I().m7805B(zzknVar.f991P));
            m10355U().m3035v0();
            try {
                m10352R(zzmVar);
                m10355U().m3025l0(zzmVar.f997O, zzknVar.f991P);
                m10355U().m3036w();
                this.f8435i.mo1484j().m8529O().m9084b("User property removed", this.f8435i.m9103I().m7805B(zzknVar.f991P));
            } finally {
                m10355U().m2992A0();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(2:94|95)|(2:97|(8:99|(3:101|(2:103|(1:105))(1:124)|106)(1:125)|107|(1:109)(1:123)|110|111|112|(4:114|(1:116)|117|(1:119))))|126|111|112|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x039a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x039b, code lost:
    
        r21.f8435i.mo1484j().m8522H().m9085c("Application info is null, first open report might be inaccurate. appId", cz.opentree.C1889sy.m8516y(r22.f997O), r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03b3 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0489 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cb A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0205 A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x022e A[Catch: all -> 0x04b5, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024e A[Catch: all -> 0x04b5, TRY_LEAVE, TryCatch #1 {all -> 0x04b5, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01a4, B:43:0x01b7, B:45:0x01cb, B:47:0x01d6, B:50:0x01e5, B:52:0x01ed, B:54:0x01f3, B:57:0x0202, B:59:0x0205, B:60:0x0229, B:62:0x022e, B:64:0x024e, B:67:0x0261, B:69:0x0284, B:70:0x0292, B:72:0x02c5, B:73:0x02cd, B:75:0x02d1, B:76:0x02d4, B:78:0x02f5, B:82:0x03cf, B:83:0x03d2, B:84:0x0443, B:86:0x0453, B:88:0x046d, B:89:0x0474, B:90:0x04a6, B:95:0x030e, B:97:0x0339, B:99:0x0341, B:101:0x0349, B:105:0x035d, B:107:0x036b, B:110:0x0376, B:112:0x0388, B:122:0x039b, B:114:0x03b3, B:116:0x03b9, B:117:0x03be, B:119:0x03c4, B:124:0x0363, B:129:0x0321, B:133:0x03ea, B:135:0x0420, B:136:0x0428, B:138:0x042c, B:139:0x042f, B:141:0x0489, B:143:0x048d, B:146:0x023e, B:152:0x00bc, B:154:0x00c0, B:157:0x00d1, B:159:0x00eb, B:161:0x00f5, B:165:0x00ff), top: B:24:0x009f, inners: #0, #2, #3 }] */
    @androidx.annotation.WorkerThread
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10348N(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10348N(com.google.android.gms.measurement.internal.zzm):void");
    }

    @WorkerThread
    /* renamed from: O */
    public final void m10349O(zzy zzyVar) {
        zzm m10366d = m10366d(zzyVar.f1019O);
        if (m10366d != null) {
            m10350P(zzyVar, m10366d);
        }
    }

    @WorkerThread
    /* renamed from: P */
    public final void m10350P(zzy zzyVar, zzm zzmVar) {
        C0813ca.m2729k(zzyVar);
        C0813ca.m2725g(zzyVar.f1019O);
        C0813ca.m2729k(zzyVar.f1021Q);
        C0813ca.m2725g(zzyVar.f1021Q.f991P);
        m10373i0();
        m10364b0();
        if (m10356V(zzmVar)) {
            if (!zzmVar.f1004V) {
                m10352R(zzmVar);
                return;
            }
            m10355U().m3035v0();
            try {
                m10352R(zzmVar);
                zzy m3029p0 = m10355U().m3029p0(zzyVar.f1019O, zzyVar.f1021Q.f991P);
                if (m3029p0 != null) {
                    this.f8435i.mo1484j().m8529O().m9085c("Removing conditional user property", zzyVar.f1019O, this.f8435i.m9103I().m7805B(zzyVar.f1021Q.f991P));
                    m10355U().m3031r0(zzyVar.f1019O, zzyVar.f1021Q.f991P);
                    if (m3029p0.f1023S) {
                        m10355U().m3025l0(zzyVar.f1019O, zzyVar.f1021Q.f991P);
                    }
                    zzaq zzaqVar = zzyVar.f1029Y;
                    if (zzaqVar != null) {
                        zzal zzalVar = zzaqVar.f987P;
                        Bundle m1457Z = zzalVar != null ? zzalVar.m1457Z() : null;
                        g40 m9102H = this.f8435i.m9102H();
                        String str = zzyVar.f1019O;
                        zzaq zzaqVar2 = zzyVar.f1029Y;
                        m10346K(m9102H.m4015F(str, zzaqVar2.f986O, m1457Z, m3029p0.f1020P, zzaqVar2.f989R, true, false), zzmVar);
                    }
                } else {
                    this.f8435i.mo1484j().m8525K().m9085c("Conditional user property doesn't exist", C1889sy.m8516y(zzyVar.f1019O), this.f8435i.m9103I().m7805B(zzyVar.f1021Q.f991P));
                }
                m10355U().m3036w();
            } finally {
                m10355U().m2992A0();
            }
        }
    }

    /* renamed from: Q */
    public final C1792qz m10351Q() {
        m10330L(this.f8427a);
        return this.f8427a;
    }

    @WorkerThread
    /* renamed from: R */
    public final C2318xz m10352R(zzm zzmVar) {
        m10373i0();
        m10364b0();
        C0813ca.m2729k(zzmVar);
        C0813ca.m2725g(zzmVar.f997O);
        C2318xz m3023j0 = m10355U().m3023j0(zzmVar.f997O);
        String m3601y = this.f8435i.m9096B().m3601y(zzmVar.f997O);
        if (!C2240wr.m9632b() || !this.f8435i.m9130y().m2630u(C1735pu.f5868w0)) {
            return m10363b(zzmVar, m3023j0, m3601y);
        }
        if (m3023j0 == null) {
            m3023j0 = new C2318xz(this.f8435i, zzmVar.f997O);
            m3023j0.m9929c(this.f8435i.m9102H().m4026M0());
            m3023j0.m9901C(m3601y);
        } else if (!m3601y.equals(m3023j0.m9908J())) {
            m3023j0.m9901C(m3601y);
            m3023j0.m9929c(this.f8435i.m9102H().m4026M0());
        }
        m3023j0.m9955r(zzmVar.f998P);
        m3023j0.m9959v(zzmVar.f1014f0);
        if (C1011fs.m3874b() && this.f8435i.m9130y().m2610D(m3023j0.m9957t(), C1735pu.f5856q0)) {
            m3023j0.m9963z(zzmVar.f1018j0);
        }
        if (!TextUtils.isEmpty(zzmVar.f1007Y)) {
            m3023j0.m9904F(zzmVar.f1007Y);
        }
        long j = zzmVar.f1001S;
        if (j != 0) {
            m3023j0.m9962y(j);
        }
        if (!TextUtils.isEmpty(zzmVar.f999Q)) {
            m3023j0.m9907I(zzmVar.f999Q);
        }
        m3023j0.m9958u(zzmVar.f1006X);
        String str = zzmVar.f1000R;
        if (str != null) {
            m3023j0.m9910L(str);
        }
        m3023j0.m9900B(zzmVar.f1002T);
        m3023j0.m9933e(zzmVar.f1004V);
        if (!TextUtils.isEmpty(zzmVar.f1003U)) {
            m3023j0.m9913O(zzmVar.f1003U);
        }
        if (!this.f8435i.m9130y().m2630u(C1735pu.f5807O0)) {
            m3023j0.m9930c0(zzmVar.f1008Z);
        }
        m3023j0.m9956s(zzmVar.f1011c0);
        m3023j0.m9960w(zzmVar.f1012d0);
        m3023j0.m9927b(zzmVar.f1015g0);
        m3023j0.m9903E(zzmVar.f1016h0);
        if (m3023j0.m9935f()) {
            m10355U().m3010O(m3023j0);
        }
        return m3023j0;
    }

    /* renamed from: S */
    public final C0744az m10353S() {
        m10330L(this.f8428b);
        return this.f8428b;
    }

    /* renamed from: T */
    public final String m10354T(zzm zzmVar) {
        try {
            return (String) this.f8435i.mo1481g().m8286x(new c40(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.f8435i.mo1484j().m8522H().m9085c("Failed to get app instance id. appId", C1889sy.m8516y(zzmVar.f997O), e);
            return null;
        }
    }

    /* renamed from: U */
    public final C0845cu m10355U() {
        m10330L(this.f8429c);
        return this.f8429c;
    }

    /* renamed from: V */
    public final boolean m10356V(zzm zzmVar) {
        return (C1011fs.m3874b() && this.f8435i.m9130y().m2610D(zzmVar.f997O, C1735pu.f5856q0)) ? (TextUtils.isEmpty(zzmVar.f998P) && TextUtils.isEmpty(zzmVar.f1018j0) && TextUtils.isEmpty(zzmVar.f1014f0)) ? false : true : (TextUtils.isEmpty(zzmVar.f998P) && TextUtils.isEmpty(zzmVar.f1014f0)) ? false : true;
    }

    /* renamed from: W */
    public final o40 m10357W() {
        m10330L(this.f8432f);
        return this.f8432f;
    }

    /* renamed from: X */
    public final z10 m10358X() {
        m10330L(this.f8434h);
        return this.f8434h;
    }

    /* renamed from: Y */
    public final d40 m10359Y() {
        m10330L(this.f8433g);
        return this.f8433g;
    }

    /* renamed from: Z */
    public final C1790qy m10360Z() {
        return this.f8435i.m9103I();
    }

    @WorkerThread
    /* renamed from: a */
    public final int m10361a(FileChannel fileChannel) {
        m10373i0();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f8435i.mo1484j().m8522H().m9083a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                this.f8435i.mo1484j().m8525K().m9084b("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e) {
            this.f8435i.mo1484j().m8522H().m9084b("Failed to read from channel", e);
            return 0;
        }
    }

    /* renamed from: a0 */
    public final g40 m10362a0() {
        return this.f8435i.m9102H();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final cz.opentree.C2318xz m10363b(com.google.android.gms.measurement.internal.zzm r8, cz.opentree.C2318xz r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10363b(com.google.android.gms.measurement.internal.zzm, cz.opentree.xz, java.lang.String):cz.opentree.xz");
    }

    /* renamed from: b0 */
    public final void m10364b0() {
        if (!this.f8436j) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    /* renamed from: c0 */
    public final void m10365c0() {
        C2318xz m3023j0;
        String str;
        m10373i0();
        m10364b0();
        this.f8444r = true;
        try {
            this.f8435i.mo1480f();
            Boolean m3960a0 = this.f8435i.m9111Q().m3960a0();
            if (m3960a0 == null) {
                this.f8435i.mo1484j().m8525K().m9083a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (m3960a0.booleanValue()) {
                this.f8435i.mo1484j().m8522H().m9083a("Upload called in the client side when service should be used");
                return;
            }
            if (this.f8438l > 0) {
                m10377l0();
                return;
            }
            m10373i0();
            if (this.f8447u != null) {
                this.f8435i.mo1484j().m8530P().m9083a("Uploading requested multiple times");
                return;
            }
            if (!m10353S().m2317z()) {
                this.f8435i.mo1484j().m8530P().m9083a("Network not connected, ignoring upload request");
                m10377l0();
                return;
            }
            long mo1177a = this.f8435i.mo1483i().mo1177a();
            int m2632w = this.f8435i.m9130y().m2632w(null, C1735pu.f5812R);
            long m2606O = mo1177a - C0796bu.m2606O();
            for (int i = 0; i < m2632w && m10340E(null, m2606O); i++) {
            }
            long m4968a = this.f8435i.m9096B().f2560e.m4968a();
            if (m4968a != 0) {
                this.f8435i.mo1484j().m8529O().m9084b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(mo1177a - m4968a)));
            }
            String m3040y = m10355U().m3040y();
            if (TextUtils.isEmpty(m3040y)) {
                this.f8449w = -1L;
                String m3004H = m10355U().m3004H(mo1177a - C0796bu.m2606O());
                if (!TextUtils.isEmpty(m3004H) && (m3023j0 = m10355U().m3023j0(m3004H)) != null) {
                    m10381r(m3023j0);
                }
            } else {
                if (this.f8449w == -1) {
                    this.f8449w = m10355U().m3020Y();
                }
                List<Pair<C1821rk, Long>> m3006J = m10355U().m3006J(m3040y, this.f8435i.m9130y().m2632w(m3040y, C1735pu.f5837h), Math.max(0, this.f8435i.m9130y().m2632w(m3040y, C1735pu.f5839i)));
                if (!m3006J.isEmpty()) {
                    Iterator<Pair<C1821rk, Long>> it = m3006J.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        C1821rk c1821rk = (C1821rk) it.next().first;
                        if (!TextUtils.isEmpty(c1821rk.m8024b0())) {
                            str = c1821rk.m8024b0();
                            break;
                        }
                    }
                    if (str != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= m3006J.size()) {
                                break;
                            }
                            C1821rk c1821rk2 = (C1821rk) m3006J.get(i2).first;
                            if (!TextUtils.isEmpty(c1821rk2.m8024b0()) && !c1821rk2.m8024b0().equals(str)) {
                                m3006J = m3006J.subList(0, i2);
                                break;
                            }
                            i2++;
                        }
                    }
                    C1766qk.a m7722H = C1766qk.m7722H();
                    int size = m3006J.size();
                    ArrayList arrayList = new ArrayList(m3006J.size());
                    boolean m2612F = this.f8435i.m9130y().m2612F(m3040y);
                    for (int i3 = 0; i3 < size; i3++) {
                        C1821rk.a m9840z = ((C1821rk) m3006J.get(i3).first).m9840z();
                        arrayList.add((Long) m3006J.get(i3).second);
                        m9840z.m8118h0(this.f8435i.m9130y().m2611E());
                        m9840z.m8139z(mo1177a);
                        this.f8435i.mo1480f();
                        m9840z.m8097M(false);
                        if (!m2612F) {
                            m9840z.m8084C0();
                        }
                        if (this.f8435i.m9130y().m2610D(m3040y, C1735pu.f5824a0)) {
                            m9840z.m8136x0(m10359Y().m3147x(((C1821rk) ((AbstractC2303xn) m9840z.mo1259f())).m5946k()));
                        }
                        m7722H.m7727v(m9840z);
                    }
                    String m3134D = this.f8435i.mo1484j().m8520D(2) ? m10359Y().m3134D((C1766qk) ((AbstractC2303xn) m7722H.mo1259f())) : null;
                    m10359Y();
                    byte[] m5946k = ((C1766qk) ((AbstractC2303xn) m7722H.mo1259f())).m5946k();
                    String m6320a = C1735pu.f5857r.m6320a(null);
                    try {
                        URL url = new URL(m6320a);
                        C0813ca.m2719a(!arrayList.isEmpty());
                        if (this.f8447u != null) {
                            this.f8435i.mo1484j().m8522H().m9083a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.f8447u = new ArrayList(arrayList);
                        }
                        this.f8435i.m9096B().f2561f.m4969b(mo1177a);
                        this.f8435i.mo1484j().m8530P().m9086d("Uploading data. app, uncompressed size, data", size > 0 ? m7722H.m7728w(0).m7989I2() : "?", Integer.valueOf(m5946k.length), m3134D);
                        this.f8443q = true;
                        C0744az m10353S = m10353S();
                        b40 b40Var = new b40(this, m3040y);
                        m10353S.mo7585d();
                        m10353S.m9404t();
                        C0813ca.m2729k(url);
                        C0813ca.m2729k(m5946k);
                        C0813ca.m2729k(b40Var);
                        m10353S.mo1481g().m8283D(new RunnableC0904dz(m10353S, m3040y, url, m5946k, null, b40Var));
                    } catch (MalformedURLException unused) {
                        this.f8435i.mo1484j().m8522H().m9085c("Failed to parse upload URL. Not uploading. appId", C1889sy.m8516y(m3040y), m6320a);
                    }
                }
            }
        } finally {
            this.f8444r = false;
            m10341F();
        }
    }

    @WorkerThread
    /* renamed from: d */
    public final zzm m10366d(String str) {
        C2318xz m3023j0 = m10355U().m3023j0(str);
        if (m3023j0 == null || TextUtils.isEmpty(m3023j0.m9918T())) {
            this.f8435i.mo1484j().m8529O().m9084b("No app data available; dropping", str);
            return null;
        }
        Boolean m10344I = m10344I(m3023j0);
        if (m10344I == null || m10344I.booleanValue()) {
            return new zzm(str, m3023j0.m9899A(), m3023j0.m9918T(), m3023j0.m9920V(), m3023j0.m9922X(), m3023j0.m9924Z(), m3023j0.m9928b0(), (String) null, m3023j0.m9934e0(), false, m3023j0.m9911M(), m3023j0.m9945k(), 0L, 0, m3023j0.m9947l(), m3023j0.m9949m(), false, m3023j0.m9902D(), m3023j0.m9951n(), m3023j0.m9932d0(), m3023j0.m9952o(), (C1011fs.m3874b() && this.f8435i.m9130y().m2610D(str, C1735pu.f5856q0)) ? m3023j0.m9905G() : null);
        }
        this.f8435i.mo1484j().m8522H().m9084b("App version does not match; dropping. appId", C1889sy.m8516y(str));
        return null;
    }

    @WorkerThread
    /* renamed from: d0 */
    public final void m10367d0() {
        m10373i0();
        m10364b0();
        if (this.f8437k) {
            return;
        }
        this.f8437k = true;
        if (m10342G()) {
            int m10361a = m10361a(this.f8446t);
            int m7575H = this.f8435i.m9113S().m7575H();
            m10373i0();
            if (m10361a > m7575H) {
                this.f8435i.mo1484j().m8522H().m9085c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(m10361a), Integer.valueOf(m7575H));
            } else if (m10361a < m7575H) {
                if (m10338C(m7575H, this.f8446t)) {
                    this.f8435i.mo1484j().m8530P().m9085c("Storage version upgraded. Previous, current version", Integer.valueOf(m10361a), Integer.valueOf(m7575H));
                } else {
                    this.f8435i.mo1484j().m8522H().m9085c("Storage version upgrade failed. Previous, current version", Integer.valueOf(m10361a), Integer.valueOf(m7575H));
                }
            }
        }
    }

    @WorkerThread
    /* renamed from: e */
    public final void m10368e() {
        this.f8435i.mo1481g().mo7585d();
        m10355U().m2996C0();
        if (this.f8435i.m9096B().f2560e.m4968a() == 0) {
            this.f8435i.m9096B().f2560e.m4969b(this.f8435i.mo1483i().mo1177a());
        }
        m10377l0();
    }

    /* renamed from: e0 */
    public final void m10369e0() {
        this.f8441o++;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: f */
    public final t40 mo1480f() {
        return this.f8435i.mo1480f();
    }

    /* renamed from: f0 */
    public final C2144uz m10370f0() {
        return this.f8435i;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: g */
    public final C1839rz mo1481g() {
        return this.f8435i.mo1481g();
    }

    /* renamed from: g0 */
    public final C0853cz m10371g0() {
        C0853cz c0853cz = this.f8430d;
        if (c0853cz != null) {
            return c0853cz;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: h */
    public final Context mo1482h() {
        return this.f8435i.mo1482h();
    }

    /* renamed from: h0 */
    public final v30 m10372h0() {
        m10330L(this.f8431e);
        return this.f8431e;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: i */
    public final Clock mo1483i() {
        return this.f8435i.mo1483i();
    }

    @WorkerThread
    /* renamed from: i0 */
    public final void m10373i0() {
        this.f8435i.mo1481g().mo7585d();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: j */
    public final C1889sy mo1484j() {
        return this.f8435i.mo1484j();
    }

    /* renamed from: j0 */
    public final long m10374j0() {
        long mo1177a = this.f8435i.mo1483i().mo1177a();
        C0960ez m9096B = this.f8435i.m9096B();
        m9096B.m7166q();
        m9096B.mo7585d();
        long m4968a = m9096B.f2564i.m4968a();
        if (m4968a == 0) {
            m4968a = 1 + m9096B.m7588m().m4018G0().nextInt(86400000);
            m9096B.f2564i.m4969b(m4968a);
        }
        return ((((mo1177a + m4968a) / 1000) / 60) / 60) / 24;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0156, code lost:
    
        r8.f8435i.m9096B().f2562g.m4969b(r8.f8435i.mo1483i().mo1177a());
     */
    @androidx.annotation.WorkerThread
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10375k(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10375k(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    /* renamed from: k0 */
    public final boolean m10376k0() {
        m10373i0();
        m10364b0();
        return m10355U().m3001F0() || !TextUtils.isEmpty(m10355U().m3040y());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a9  */
    @androidx.annotation.WorkerThread
    /* renamed from: l0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10377l0() {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.z30.m10377l0():void");
    }

    /* renamed from: o */
    public final void m10378o(C1821rk.a aVar, long j, boolean z) {
        String str = z ? "_se" : "_lte";
        h40 m3028o0 = m10355U().m3028o0(aVar.m8130t0(), str);
        h40 h40Var = (m3028o0 == null || m3028o0.f3104e == null) ? new h40(aVar.m8130t0(), "auto", str, this.f8435i.mo1483i().mo1177a(), Long.valueOf(j)) : new h40(aVar.m8130t0(), "auto", str, this.f8435i.mo1483i().mo1177a(), Long.valueOf(((Long) m3028o0.f3104e).longValue() + j));
        C2175vk.a m9264a0 = C2175vk.m9264a0();
        m9264a0.m9290z(str);
        m9264a0.m9289y(this.f8435i.mo1483i().mo1177a());
        m9264a0.m9284B(((Long) h40Var.f3104e).longValue());
        C2175vk c2175vk = (C2175vk) ((AbstractC2303xn) m9264a0.mo1259f());
        boolean z2 = false;
        int m3130w = d40.m3130w(aVar, str);
        if (m3130w >= 0) {
            aVar.m8137y(m3130w, c2175vk);
            z2 = true;
        }
        if (!z2) {
            aVar.m8083C(c2175vk);
        }
        if (j > 0) {
            m10355U().m3015T(h40Var);
            this.f8435i.mo1484j().m8530P().m9085c("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", h40Var.f3104e);
        }
    }

    @WorkerThread
    /* renamed from: p */
    public final void m10379p(zzaq zzaqVar, zzm zzmVar) {
        List<zzy> m3008L;
        List<zzy> m3008L2;
        List<zzy> m3008L3;
        List<String> list;
        zzaq zzaqVar2 = zzaqVar;
        C0813ca.m2729k(zzmVar);
        C0813ca.m2725g(zzmVar.f997O);
        m10373i0();
        m10364b0();
        String str = zzmVar.f997O;
        long j = zzaqVar2.f989R;
        m10359Y();
        if (d40.m3127S(zzaqVar, zzmVar)) {
            if (!zzmVar.f1004V) {
                m10352R(zzmVar);
                return;
            }
            if (this.f8435i.m9130y().m2610D(str, C1735pu.f5832e0) && (list = zzmVar.f1017i0) != null) {
                if (!list.contains(zzaqVar2.f986O)) {
                    this.f8435i.mo1484j().m8529O().m9086d("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.f986O, zzaqVar2.f988Q);
                    return;
                } else {
                    Bundle m1457Z = zzaqVar2.f987P.m1457Z();
                    m1457Z.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.f986O, new zzal(m1457Z), zzaqVar2.f988Q, zzaqVar2.f989R);
                }
            }
            m10355U().m3035v0();
            try {
                C0845cu m10355U = m10355U();
                C0813ca.m2725g(str);
                m10355U.mo7585d();
                m10355U.m9404t();
                if (j < 0) {
                    m10355U.mo1484j().m8525K().m9085c("Invalid time querying timed out conditional properties", C1889sy.m8516y(str), Long.valueOf(j));
                    m3008L = Collections.emptyList();
                } else {
                    m3008L = m10355U.m3008L("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzy zzyVar : m3008L) {
                    if (zzyVar != null) {
                        this.f8435i.mo1484j().m8530P().m9086d("User property timed out", zzyVar.f1019O, this.f8435i.m9103I().m7805B(zzyVar.f1021Q.f991P), zzyVar.f1021Q.m1501x());
                        if (zzyVar.f1025U != null) {
                            m10346K(new zzaq(zzyVar.f1025U, j), zzmVar);
                        }
                        m10355U().m3031r0(str, zzyVar.f1021Q.f991P);
                    }
                }
                C0845cu m10355U2 = m10355U();
                C0813ca.m2725g(str);
                m10355U2.mo7585d();
                m10355U2.m9404t();
                if (j < 0) {
                    m10355U2.mo1484j().m8525K().m9085c("Invalid time querying expired conditional properties", C1889sy.m8516y(str), Long.valueOf(j));
                    m3008L2 = Collections.emptyList();
                } else {
                    m3008L2 = m10355U2.m3008L("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(m3008L2.size());
                for (zzy zzyVar2 : m3008L2) {
                    if (zzyVar2 != null) {
                        this.f8435i.mo1484j().m8530P().m9086d("User property expired", zzyVar2.f1019O, this.f8435i.m9103I().m7805B(zzyVar2.f1021Q.f991P), zzyVar2.f1021Q.m1501x());
                        m10355U().m3025l0(str, zzyVar2.f1021Q.f991P);
                        zzaq zzaqVar3 = zzyVar2.f1029Y;
                        if (zzaqVar3 != null) {
                            arrayList.add(zzaqVar3);
                        }
                        m10355U().m3031r0(str, zzyVar2.f1021Q.f991P);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    m10346K(new zzaq((zzaq) obj, j), zzmVar);
                }
                C0845cu m10355U3 = m10355U();
                String str2 = zzaqVar2.f986O;
                C0813ca.m2725g(str);
                C0813ca.m2725g(str2);
                m10355U3.mo7585d();
                m10355U3.m9404t();
                if (j < 0) {
                    m10355U3.mo1484j().m8525K().m9086d("Invalid time querying triggered conditional properties", C1889sy.m8516y(str), m10355U3.m7587l().m7809x(str2), Long.valueOf(j));
                    m3008L3 = Collections.emptyList();
                } else {
                    m3008L3 = m10355U3.m3008L("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(m3008L3.size());
                for (zzy zzyVar3 : m3008L3) {
                    if (zzyVar3 != null) {
                        zzkn zzknVar = zzyVar3.f1021Q;
                        h40 h40Var = new h40(zzyVar3.f1019O, zzyVar3.f1020P, zzknVar.f991P, j, zzknVar.m1501x());
                        if (m10355U().m3015T(h40Var)) {
                            this.f8435i.mo1484j().m8530P().m9086d("User property triggered", zzyVar3.f1019O, this.f8435i.m9103I().m7805B(h40Var.f3102c), h40Var.f3104e);
                        } else {
                            this.f8435i.mo1484j().m8522H().m9086d("Too many active user properties, ignoring", C1889sy.m8516y(zzyVar3.f1019O), this.f8435i.m9103I().m7805B(h40Var.f3102c), h40Var.f3104e);
                        }
                        zzaq zzaqVar4 = zzyVar3.f1027W;
                        if (zzaqVar4 != null) {
                            arrayList2.add(zzaqVar4);
                        }
                        zzyVar3.f1021Q = new zzkn(h40Var);
                        zzyVar3.f1023S = true;
                        m10355U().m3016U(zzyVar3);
                    }
                }
                m10346K(zzaqVar2, zzmVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    m10346K(new zzaq((zzaq) obj2, j), zzmVar);
                }
                m10355U().m3036w();
            } finally {
                m10355U().m2992A0();
            }
        }
    }

    @WorkerThread
    /* renamed from: q */
    public final void m10380q(zzaq zzaqVar, String str) {
        C2318xz m3023j0 = m10355U().m3023j0(str);
        if (m3023j0 == null || TextUtils.isEmpty(m3023j0.m9918T())) {
            this.f8435i.mo1484j().m8529O().m9084b("No app data available; dropping event", str);
            return;
        }
        Boolean m10344I = m10344I(m3023j0);
        if (m10344I == null) {
            if (!"_ui".equals(zzaqVar.f986O)) {
                this.f8435i.mo1484j().m8525K().m9084b("Could not find package. appId", C1889sy.m8516y(str));
            }
        } else if (!m10344I.booleanValue()) {
            this.f8435i.mo1484j().m8522H().m9084b("App version does not match; dropping event. appId", C1889sy.m8516y(str));
            return;
        }
        m10379p(zzaqVar, new zzm(str, m3023j0.m9899A(), m3023j0.m9918T(), m3023j0.m9920V(), m3023j0.m9922X(), m3023j0.m9924Z(), m3023j0.m9928b0(), (String) null, m3023j0.m9934e0(), false, m3023j0.m9911M(), m3023j0.m9945k(), 0L, 0, m3023j0.m9947l(), m3023j0.m9949m(), false, m3023j0.m9902D(), m3023j0.m9951n(), m3023j0.m9932d0(), m3023j0.m9952o(), (C1011fs.m3874b() && this.f8435i.m9130y().m2610D(m3023j0.m9957t(), C1735pu.f5856q0)) ? m3023j0.m9905G() : null));
    }

    @WorkerThread
    /* renamed from: r */
    public final void m10381r(C2318xz c2318xz) {
        ArrayMap arrayMap;
        m10373i0();
        if (C1011fs.m3874b() && this.f8435i.m9130y().m2610D(c2318xz.m9957t(), C1735pu.f5856q0)) {
            if (TextUtils.isEmpty(c2318xz.m9899A()) && TextUtils.isEmpty(c2318xz.m9905G()) && TextUtils.isEmpty(c2318xz.m9902D())) {
                m10336A(c2318xz.m9957t(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(c2318xz.m9899A()) && TextUtils.isEmpty(c2318xz.m9902D())) {
            m10336A(c2318xz.m9957t(), 204, null, null, null);
            return;
        }
        String m2628s = this.f8435i.m9130y().m2628s(c2318xz);
        try {
            URL url = new URL(m2628s);
            this.f8435i.mo1484j().m8530P().m9084b("Fetching remote configuration", c2318xz.m9957t());
            C1113hk m7827w = m10351Q().m7827w(c2318xz.m9957t());
            String m7816B = m10351Q().m7816B(c2318xz.m9957t());
            if (m7827w == null || TextUtils.isEmpty(m7816B)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", m7816B);
                arrayMap = arrayMap2;
            }
            this.f8442p = true;
            C0744az m10353S = m10353S();
            String m9957t = c2318xz.m9957t();
            a40 a40Var = new a40(this);
            m10353S.mo7585d();
            m10353S.m9404t();
            C0813ca.m2729k(url);
            C0813ca.m2729k(a40Var);
            m10353S.mo1481g().m8283D(new RunnableC0904dz(m10353S, m9957t, url, null, arrayMap, a40Var));
        } catch (MalformedURLException unused) {
            this.f8435i.mo1484j().m8522H().m9085c("Failed to parse config URL. Not fetching. appId", C1889sy.m8516y(c2318xz.m9957t()), m2628s);
        }
    }

    /* renamed from: s */
    public final void m10382s(w30 w30Var) {
        this.f8440n++;
    }

    @WorkerThread
    /* renamed from: u */
    public final void m10383u(e40 e40Var) {
        this.f8435i.mo1481g().mo7585d();
        C0845cu c0845cu = new C0845cu(this);
        c0845cu.m9405u();
        this.f8429c = c0845cu;
        this.f8435i.m9130y().m2629t(this.f8427a);
        o40 o40Var = new o40(this);
        o40Var.m9405u();
        this.f8432f = o40Var;
        z10 z10Var = new z10(this);
        z10Var.m9405u();
        this.f8434h = z10Var;
        v30 v30Var = new v30(this);
        v30Var.m9405u();
        this.f8431e = v30Var;
        this.f8430d = new C0853cz(this);
        if (this.f8440n != this.f8441o) {
            this.f8435i.mo1484j().m8522H().m9085c("Not all upload components initialized", Integer.valueOf(this.f8440n), Integer.valueOf(this.f8441o));
        }
        this.f8436j = true;
    }

    @WorkerThread
    /* renamed from: v */
    public final void m10384v(zzkn zzknVar, zzm zzmVar) {
        m10373i0();
        m10364b0();
        if (m10356V(zzmVar)) {
            if (!zzmVar.f1004V) {
                m10352R(zzmVar);
                return;
            }
            int m4050w0 = this.f8435i.m9102H().m4050w0(zzknVar.f991P);
            int i = 0;
            if (m4050w0 != 0) {
                this.f8435i.m9102H();
                String m3987I = g40.m3987I(zzknVar.f991P, 24, true);
                String str = zzknVar.f991P;
                this.f8435i.m9102H().m4036V(zzmVar.f997O, m4050w0, "_ev", m3987I, str != null ? str.length() : 0);
                return;
            }
            int m4045o0 = this.f8435i.m9102H().m4045o0(zzknVar.f991P, zzknVar.m1501x());
            if (m4045o0 != 0) {
                this.f8435i.m9102H();
                String m3987I2 = g40.m3987I(zzknVar.f991P, 24, true);
                Object m1501x = zzknVar.m1501x();
                if (m1501x != null && ((m1501x instanceof String) || (m1501x instanceof CharSequence))) {
                    i = String.valueOf(m1501x).length();
                }
                this.f8435i.m9102H().m4036V(zzmVar.f997O, m4045o0, "_ev", m3987I2, i);
                return;
            }
            Object m4051x0 = this.f8435i.m9102H().m4051x0(zzknVar.f991P, zzknVar.m1501x());
            if (m4051x0 == null) {
                return;
            }
            if ("_sid".equals(zzknVar.f991P)) {
                long j = zzknVar.f992Q;
                String str2 = zzknVar.f995T;
                long j2 = 0;
                h40 m3028o0 = m10355U().m3028o0(zzmVar.f997O, "_sno");
                if (m3028o0 != null) {
                    Object obj = m3028o0.f3104e;
                    if (obj instanceof Long) {
                        j2 = ((Long) obj).longValue();
                        m10384v(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
                    }
                }
                if (m3028o0 != null) {
                    this.f8435i.mo1484j().m8525K().m9084b("Retrieved last session number from database does not contain a valid (long) value", m3028o0.f3104e);
                }
                C1473ku m2999E = m10355U().m2999E(zzmVar.f997O, "_s");
                if (m2999E != null) {
                    j2 = m2999E.f4650c;
                    this.f8435i.mo1484j().m8530P().m9084b("Backfill the session number. Last used session number", Long.valueOf(j2));
                }
                m10384v(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzmVar);
            }
            h40 h40Var = new h40(zzmVar.f997O, zzknVar.f995T, zzknVar.f991P, zzknVar.f992Q, m4051x0);
            this.f8435i.mo1484j().m8530P().m9085c("Setting user property", this.f8435i.m9103I().m7805B(h40Var.f3102c), m4051x0);
            m10355U().m3035v0();
            try {
                m10352R(zzmVar);
                boolean m3015T = m10355U().m3015T(h40Var);
                m10355U().m3036w();
                if (!m3015T) {
                    this.f8435i.mo1484j().m8522H().m9085c("Too many unique user properties are set. Ignoring user property", this.f8435i.m9103I().m7805B(h40Var.f3102c), h40Var.f3104e);
                    this.f8435i.m9102H().m4036V(zzmVar.f997O, 9, null, null, 0);
                }
            } finally {
                m10355U().m2992A0();
            }
        }
    }

    @WorkerThread
    /* renamed from: w */
    public final void m10385w(zzm zzmVar) {
        if (this.f8447u != null) {
            ArrayList arrayList = new ArrayList();
            this.f8448v = arrayList;
            arrayList.addAll(this.f8447u);
        }
        C0845cu m10355U = m10355U();
        String str = zzmVar.f997O;
        C0813ca.m2725g(str);
        m10355U.mo7585d();
        m10355U.m9404t();
        try {
            SQLiteDatabase m3038x = m10355U.m3038x();
            String[] strArr = {str};
            int delete = m3038x.delete("apps", "app_id=?", strArr) + 0 + m3038x.delete("events", "app_id=?", strArr) + m3038x.delete("user_attributes", "app_id=?", strArr) + m3038x.delete("conditional_properties", "app_id=?", strArr) + m3038x.delete("raw_events", "app_id=?", strArr) + m3038x.delete("raw_events_metadata", "app_id=?", strArr) + m3038x.delete("queue", "app_id=?", strArr) + m3038x.delete("audience_filter_values", "app_id=?", strArr) + m3038x.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                m10355U.mo1484j().m8530P().m9085c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            m10355U.mo1484j().m8522H().m9085c("Error resetting analytics data. appId, error", C1889sy.m8516y(str), e);
        }
        if (zzmVar.f1004V) {
            m10348N(zzmVar);
        }
    }

    @WorkerThread
    /* renamed from: x */
    public final void m10386x(zzy zzyVar) {
        zzm m10366d = m10366d(zzyVar.f1019O);
        if (m10366d != null) {
            m10387y(zzyVar, m10366d);
        }
    }

    @WorkerThread
    /* renamed from: y */
    public final void m10387y(zzy zzyVar, zzm zzmVar) {
        boolean z;
        C0813ca.m2729k(zzyVar);
        C0813ca.m2725g(zzyVar.f1019O);
        C0813ca.m2729k(zzyVar.f1020P);
        C0813ca.m2729k(zzyVar.f1021Q);
        C0813ca.m2725g(zzyVar.f1021Q.f991P);
        m10373i0();
        m10364b0();
        if (m10356V(zzmVar)) {
            if (!zzmVar.f1004V) {
                m10352R(zzmVar);
                return;
            }
            zzy zzyVar2 = new zzy(zzyVar);
            boolean z2 = false;
            zzyVar2.f1023S = false;
            m10355U().m3035v0();
            try {
                zzy m3029p0 = m10355U().m3029p0(zzyVar2.f1019O, zzyVar2.f1021Q.f991P);
                if (m3029p0 != null && !m3029p0.f1020P.equals(zzyVar2.f1020P)) {
                    this.f8435i.mo1484j().m8525K().m9086d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f8435i.m9103I().m7805B(zzyVar2.f1021Q.f991P), zzyVar2.f1020P, m3029p0.f1020P);
                }
                if (m3029p0 != null && (z = m3029p0.f1023S)) {
                    zzyVar2.f1020P = m3029p0.f1020P;
                    zzyVar2.f1022R = m3029p0.f1022R;
                    zzyVar2.f1026V = m3029p0.f1026V;
                    zzyVar2.f1024T = m3029p0.f1024T;
                    zzyVar2.f1027W = m3029p0.f1027W;
                    zzyVar2.f1023S = z;
                    zzkn zzknVar = zzyVar2.f1021Q;
                    zzyVar2.f1021Q = new zzkn(zzknVar.f991P, m3029p0.f1021Q.f992Q, zzknVar.m1501x(), m3029p0.f1021Q.f995T);
                } else if (TextUtils.isEmpty(zzyVar2.f1024T)) {
                    zzkn zzknVar2 = zzyVar2.f1021Q;
                    zzyVar2.f1021Q = new zzkn(zzknVar2.f991P, zzyVar2.f1022R, zzknVar2.m1501x(), zzyVar2.f1021Q.f995T);
                    zzyVar2.f1023S = true;
                    z2 = true;
                }
                if (zzyVar2.f1023S) {
                    zzkn zzknVar3 = zzyVar2.f1021Q;
                    h40 h40Var = new h40(zzyVar2.f1019O, zzyVar2.f1020P, zzknVar3.f991P, zzknVar3.f992Q, zzknVar3.m1501x());
                    if (m10355U().m3015T(h40Var)) {
                        this.f8435i.mo1484j().m8529O().m9086d("User property updated immediately", zzyVar2.f1019O, this.f8435i.m9103I().m7805B(h40Var.f3102c), h40Var.f3104e);
                    } else {
                        this.f8435i.mo1484j().m8522H().m9086d("(2)Too many active user properties, ignoring", C1889sy.m8516y(zzyVar2.f1019O), this.f8435i.m9103I().m7805B(h40Var.f3102c), h40Var.f3104e);
                    }
                    if (z2 && zzyVar2.f1027W != null) {
                        m10346K(new zzaq(zzyVar2.f1027W, zzyVar2.f1022R), zzmVar);
                    }
                }
                if (m10355U().m3016U(zzyVar2)) {
                    this.f8435i.mo1484j().m8529O().m9086d("Conditional property added", zzyVar2.f1019O, this.f8435i.m9103I().m7805B(zzyVar2.f1021Q.f991P), zzyVar2.f1021Q.m1501x());
                } else {
                    this.f8435i.mo1484j().m8522H().m9086d("Too many conditional properties, ignoring", C1889sy.m8516y(zzyVar2.f1019O), this.f8435i.m9103I().m7805B(zzyVar2.f1021Q.f991P), zzyVar2.f1021Q.m1501x());
                }
                m10355U().m3036w();
            } finally {
                m10355U().m2992A0();
            }
        }
    }

    @WorkerThread
    /* renamed from: z */
    public final void m10388z(Runnable runnable) {
        m10373i0();
        if (this.f8439m == null) {
            this.f8439m = new ArrayList();
        }
        this.f8439m.add(runnable);
    }
}
