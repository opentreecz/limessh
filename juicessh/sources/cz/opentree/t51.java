package cz.opentree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.util.io.pem.PemObjectGenerator;

/* loaded from: classes.dex */
public class t51 implements PemObjectGenerator {

    /* renamed from: c */
    public static final List f6711c = Collections.unmodifiableList(new ArrayList());

    /* renamed from: a */
    public List f6712a;

    /* renamed from: b */
    public byte[] f6713b;

    public t51(String str, List list, byte[] bArr) {
        this.f6712a = Collections.unmodifiableList(list);
        this.f6713b = bArr;
    }

    /* renamed from: a */
    public byte[] m8596a() {
        return this.f6713b;
    }
}
