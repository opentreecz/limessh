package cz.opentree;

import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.ssh_key_struct;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/* compiled from: SSHKeyGenerator.java */
/* loaded from: classes.dex */
public class gk0 {

    /* compiled from: SSHKeyGenerator.java */
    /* renamed from: cz.opentree.gk0$a */
    /* loaded from: classes.dex */
    public static class C1047a {

        /* renamed from: a */
        public String f2884a;
    }

    /* renamed from: a */
    public static C1047a m4160a(int i, String str) throws ek0 {
        return m4162c(4, i, str);
    }

    /* renamed from: b */
    public static C1047a m4161b(String str) throws ek0 {
        return m4162c(5, 0, str);
    }

    /* renamed from: c */
    public static C1047a m4162c(int i, int i2, String str) throws ek0 {
        SshLibrary m4164e = m4164e();
        ssh_key_struct.ByReference[] byReferenceArr = {new ssh_key_struct.ByReference()};
        if (m4164e.ssh_pki_generate(i, i2, byReferenceArr) != 0) {
            throw new ek0(ek0.f2485w0, "failed to generate key");
        }
        PointerByReference pointerByReference = new PointerByReference();
        if (str == null || str.isEmpty()) {
            if (m4164e.ssh_pki_export_privkey_base64(byReferenceArr[0], Pointer.NULL, (SshLibrary.ssh_auth_callback) null, (Pointer) null, pointerByReference) != 0) {
                throw new ek0(ek0.f2485w0, "failed to export generated private key");
            }
        } else if (m4164e.ssh_pki_export_privkey_base64(byReferenceArr[0], str, (SshLibrary.ssh_auth_callback) null, (Pointer) null, pointerByReference) != 0) {
            throw new ek0(ek0.f2485w0, "failed to export generated private key");
        }
        PointerByReference pointerByReference2 = new PointerByReference();
        if (m4164e.ssh_pki_export_pubkey_base64(byReferenceArr[0], pointerByReference2) != 0) {
            throw new ek0(ek0.f2485w0, "failed to export generated public key");
        }
        String str2 = i != 2 ? i != 4 ? i != 5 ? "ssh-unknown " : "ssh-ed25519 " : "ssh-ecdsa " : "ssh-rsa ";
        C1047a c1047a = new C1047a();
        String str3 = str2 + pointerByReference2.getValue().getString(0L);
        c1047a.f2884a = pointerByReference.getValue().getString(0L);
        return c1047a;
    }

    /* renamed from: d */
    public static C1047a m4163d(int i, String str) throws ek0 {
        return m4162c(2, i, str);
    }

    /* renamed from: e */
    public static SshLibrary m4164e() throws ek0 {
        try {
            return SshLibrary.INSTANCE;
        } catch (UnsatisfiedLinkError e) {
            throw new ek0(ek0.f2452P, e.getMessage());
        }
    }
}
