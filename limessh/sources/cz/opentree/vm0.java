package cz.opentree;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes.dex */
public enum vm0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: O */
    public final String f7526O;

    vm0(String str) {
        this.f7526O = str;
    }

    /* renamed from: f */
    public static vm0 m9313f(String str) throws IOException {
        vm0 vm0Var = HTTP_1_0;
        if (str.equals(vm0Var.f7526O)) {
            return vm0Var;
        }
        vm0 vm0Var2 = HTTP_1_1;
        if (str.equals(vm0Var2.f7526O)) {
            return vm0Var2;
        }
        vm0 vm0Var3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(vm0Var3.f7526O)) {
            return vm0Var3;
        }
        vm0 vm0Var4 = HTTP_2;
        if (str.equals(vm0Var4.f7526O)) {
            return vm0Var4;
        }
        vm0 vm0Var5 = SPDY_3;
        if (str.equals(vm0Var5.f7526O)) {
            return vm0Var5;
        }
        vm0 vm0Var6 = QUIC;
        if (str.equals(vm0Var6.f7526O)) {
            return vm0Var6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f7526O;
    }
}
