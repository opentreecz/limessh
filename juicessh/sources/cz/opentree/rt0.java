package cz.opentree;

/* loaded from: classes.dex */
public class rt0 extends nt0 {
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
        mo6793r();
        return 48;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHA-384";
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return 48;
    }

    @Override // cz.opentree.nt0
    /* renamed from: r */
    public void mo6793r() {
        super.mo6793r();
        this.f5368e = -3766243637369397544L;
        this.f5369f = 7105036623409894663L;
        this.f5370g = -7973340178411365097L;
        this.f5371h = 1526699215303891257L;
        this.f5372i = 7436329637833083697L;
        this.f5373j = -8163818279084223215L;
        this.f5374k = -2662702644619276377L;
        this.f5375l = 5167115440072839076L;
    }
}
