package com.sonelli;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.sonelli.nh */
/* loaded from: classes.dex */
public final class C1604nh {

    /* renamed from: a */
    public int f5275a;

    /* renamed from: b */
    public ByteArrayOutputStream f5276b = new ByteArrayOutputStream();

    /* renamed from: c */
    public final /* synthetic */ C1552mh f5277c;

    public C1604nh(C1552mh c1552mh) {
        this.f5277c = c1552mh;
    }

    /* renamed from: a */
    public final byte[] m6676a() {
        return this.f5276b.toByteArray();
    }

    /* renamed from: b */
    public final boolean m6677b(C1043gh c1043gh) {
        byte[] bArr;
        C0813ca.m2729k(c1043gh);
        if (this.f5275a + 1 > C2007ug.m8884g()) {
            return false;
        }
        String m6413I0 = this.f5277c.m6413I0(c1043gh, false);
        if (m6413I0 == null) {
            this.f5277c.m8660h0().m5889G0(c1043gh, "Error formatting hit");
            return true;
        }
        byte[] bytes = m6413I0.getBytes();
        int length = bytes.length;
        if (length > C2007ug.m8880c()) {
            this.f5277c.m8660h0().m5889G0(c1043gh, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.f5276b.size() > 0) {
            length++;
        }
        if (this.f5276b.size() + length > C0770bh.f1694s.m2801a().intValue()) {
            return false;
        }
        try {
            if (this.f5276b.size() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = this.f5276b;
                bArr = C1552mh.f5036S;
                byteArrayOutputStream.write(bArr);
            }
            this.f5276b.write(bytes);
            this.f5275a++;
            return true;
        } catch (IOException e) {
            this.f5277c.m8674w0("Failed to write payload when batching hits", e);
            return true;
        }
    }

    /* renamed from: c */
    public final int m6678c() {
        return this.f5275a;
    }
}
