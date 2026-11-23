package com.sonelli;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Signer;

/* loaded from: classes.dex */
public class ou0 implements Signer {

    /* renamed from: a */
    public final C1676b f5555a = new C1676b();

    /* renamed from: b */
    public boolean f5556b;

    /* renamed from: c */
    public iu0 f5557c;

    /* renamed from: com.sonelli.ou0$b */
    /* loaded from: classes.dex */
    public static class C1676b extends ByteArrayOutputStream {
        public C1676b() {
        }

        /* renamed from: a */
        public synchronized byte[] m7105a(iu0 iu0Var) {
            byte[] bArr;
            bArr = new byte[64];
            iu0Var.m4928b(0, null, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr, 0);
            reset();
            return bArr;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            e51.m3443l(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    /* renamed from: a */
    public void mo7101a(byte[] bArr, int i, int i2) {
        this.f5555a.write(bArr, i, i2);
    }

    @Override // org.bouncycastle.crypto.Signer
    /* renamed from: b */
    public void mo7102b(boolean z, CipherParameters cipherParameters) {
        this.f5556b = z;
        if (z) {
            this.f5557c = (iu0) cipherParameters;
        } else {
            this.f5557c = null;
        }
        m7104d();
    }

    @Override // org.bouncycastle.crypto.Signer
    /* renamed from: c */
    public byte[] mo7103c() {
        iu0 iu0Var;
        if (!this.f5556b || (iu0Var = this.f5557c) == null) {
            throw new IllegalStateException("Ed25519Signer not initialised for signature generation.");
        }
        return this.f5555a.m7105a(iu0Var);
    }

    /* renamed from: d */
    public void m7104d() {
        this.f5555a.reset();
    }
}
