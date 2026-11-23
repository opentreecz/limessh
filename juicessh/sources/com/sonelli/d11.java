package com.sonelli;

import androidx.core.internal.view.SupportMenu;
import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public class d11 {

    /* renamed from: a */
    public final ByteArrayOutputStream f2103a = new ByteArrayOutputStream();

    /* renamed from: f */
    public static d11 m3091f() {
        return new d11();
    }

    /* renamed from: a */
    public d11 m3092a(boolean z) {
        this.f2103a.write(z ? 1 : 0);
        return this;
    }

    /* renamed from: b */
    public byte[] m3093b() {
        return this.f2103a.toByteArray();
    }

    /* renamed from: c */
    public d11 m3094c(Encodable encodable) {
        try {
            this.f2103a.write(encodable.getEncoded());
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: d */
    public d11 m3095d(byte[] bArr) {
        try {
            this.f2103a.write(bArr);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: e */
    public d11 m3096e(byte[][] bArr) {
        try {
            for (byte[] bArr2 : bArr) {
                this.f2103a.write(bArr2);
            }
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: g */
    public d11 m3097g(int i, int i2) {
        while (this.f2103a.size() < i2) {
            this.f2103a.write(i);
        }
        return this;
    }

    /* renamed from: h */
    public d11 m3098h(int i) {
        int i2 = i & SupportMenu.USER_MASK;
        this.f2103a.write((byte) (i2 >>> 8));
        this.f2103a.write((byte) i2);
        return this;
    }

    /* renamed from: i */
    public d11 m3099i(int i) {
        this.f2103a.write((byte) (i >>> 24));
        this.f2103a.write((byte) (i >>> 16));
        this.f2103a.write((byte) (i >>> 8));
        this.f2103a.write((byte) i);
        return this;
    }

    /* renamed from: j */
    public d11 m3100j(long j) {
        m3099i((int) (j >>> 32));
        m3099i((int) j);
        return this;
    }
}
