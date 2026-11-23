package cz.opentree;

/* loaded from: classes.dex */
public class st0 extends nt0 {
    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: b */
    public int mo7096b(byte[] bArr, int i) {
        m6789n();
        h51.m4372h(this.f5368e, bArr, i);
        h51.m4372h(this.f5369f, bArr, i + 8);
        h51.m4372h(this.f5370g, bArr, i + 16);
        h51.m4372h(this.f5371h, bArr, i + 24);
        h51.m4372h(this.f5372i, bArr, i + 32);
        h51.m4372h(this.f5373j, bArr, i + 40);
        h51.m4372h(this.f5374k, bArr, i + 48);
        h51.m4372h(this.f5375l, bArr, i + 56);
        mo6793r();
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHA-512";
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return 64;
    }

    @Override // cz.opentree.nt0
    /* renamed from: r */
    public void mo6793r() {
        super.mo6793r();
        this.f5368e = 7640891576956012808L;
        this.f5369f = -4942790177534073029L;
        this.f5370g = 4354685564936845355L;
        this.f5371h = -6534734903238641935L;
        this.f5372i = 5840696475078001361L;
        this.f5373j = -7276294671716946913L;
        this.f5374k = 2270897969802886507L;
        this.f5375l = 6620516959819538809L;
    }
}
