package cz.opentree;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f11 extends j11 {

    /* renamed from: O */
    public final int f2591O;

    /* renamed from: P */
    public final boolean f2592P;

    /* renamed from: Q */
    public List<k11> f2593Q;

    /* renamed from: R */
    public List<m11> f2594R;

    /* renamed from: S */
    public final long f2595S;

    /* renamed from: T */
    public long f2596T;

    public f11(int i, List<k11> list, List<m11> list2, long j, long j2, boolean z) {
        super(true);
        this.f2596T = 0L;
        this.f2591O = i;
        this.f2593Q = Collections.unmodifiableList(list);
        this.f2594R = Collections.unmodifiableList(list2);
        this.f2596T = j;
        this.f2595S = j2;
        this.f2592P = z;
    }

    /* renamed from: a */
    public static f11 m3652a(Object obj) throws IOException {
        if (obj instanceof f11) {
            return (f11) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int readInt = dataInputStream.readInt();
            long readLong = dataInputStream.readLong();
            long readLong2 = dataInputStream.readLong();
            boolean readBoolean = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                arrayList.add(k11.m5779e(obj));
            }
            for (int i2 = 0; i2 < readInt - 1; i2++) {
                arrayList2.add(m11.m6338a(obj));
            }
            return new f11(readInt, arrayList, arrayList2, readLong, readLong2, readBoolean);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return m3652a(r51.m7880b((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                f11 m3652a = m3652a(dataInputStream3);
                dataInputStream3.close();
                return m3652a;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: e */
    public static f11 m3653e(f11 f11Var) {
        try {
            return m3652a(f11Var.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public int m3654b() {
        return this.f2591O;
    }

    /* renamed from: c */
    public synchronized g11 m3655c() {
        return new g11(this.f2591O, m3656d().m5787i());
    }

    public Object clone() throws CloneNotSupportedException {
        return m3653e(this);
    }

    /* renamed from: d */
    public k11 m3656d() {
        return this.f2593Q.get(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f11.class != obj.getClass()) {
            return false;
        }
        f11 f11Var = (f11) obj;
        if (this.f2591O == f11Var.f2591O && this.f2592P == f11Var.f2592P && this.f2595S == f11Var.f2595S && this.f2596T == f11Var.f2596T && this.f2593Q.equals(f11Var.f2593Q)) {
            return this.f2594R.equals(f11Var.f2594R);
        }
        return false;
    }

    @Override // cz.opentree.j11, org.bouncycastle.util.Encodable
    public synchronized byte[] getEncoded() throws IOException {
        d11 m3091f;
        m3091f = d11.m3091f();
        m3091f.m3099i(0);
        m3091f.m3099i(this.f2591O);
        m3091f.m3100j(this.f2596T);
        m3091f.m3100j(this.f2595S);
        m3091f.m3092a(this.f2592P);
        Iterator<k11> it = this.f2593Q.iterator();
        while (it.hasNext()) {
            m3091f.m3094c(it.next());
        }
        Iterator<m11> it2 = this.f2594R.iterator();
        while (it2.hasNext()) {
            m3091f.m3094c(it2.next());
        }
        return m3091f.m3093b();
    }

    public int hashCode() {
        int hashCode = ((((((this.f2591O * 31) + (this.f2592P ? 1 : 0)) * 31) + this.f2593Q.hashCode()) * 31) + this.f2594R.hashCode()) * 31;
        long j = this.f2595S;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f2596T;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }
}
