package cz.opentree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class kq0 extends op0 {
    public kq0(int i, rp0 rp0Var) {
        super(true, i, m5989u(rp0Var));
    }

    /* renamed from: u */
    public static byte[] m5989u(rp0 rp0Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != rp0Var.m8228f(); i++) {
            try {
                byteArrayOutputStream.write(((zp0) rp0Var.m8226d(i)).m10587j("BER"));
            } catch (IOException e) {
                throw new dq0("malformed object: " + e, e);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // cz.opentree.op0, cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2969o(z, this.f5530O ? 96 : 64, this.f5531P, this.f5532Q);
    }
}
