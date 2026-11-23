package cz.opentree;

import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.PreCompInfo;

/* loaded from: classes.dex */
public class kv0 implements PreCompInfo {

    /* renamed from: a */
    public iv0 f4662a = null;

    /* renamed from: b */
    public ECLookupTable f4663b = null;

    /* renamed from: c */
    public int f4664c = -1;

    /* renamed from: a */
    public ECLookupTable m6000a() {
        return this.f4663b;
    }

    /* renamed from: b */
    public iv0 m6001b() {
        return this.f4662a;
    }

    /* renamed from: c */
    public int m6002c() {
        return this.f4664c;
    }

    /* renamed from: d */
    public void m6003d(ECLookupTable eCLookupTable) {
        this.f4663b = eCLookupTable;
    }

    /* renamed from: e */
    public void m6004e(iv0 iv0Var) {
        this.f4662a = iv0Var;
    }

    /* renamed from: f */
    public void m6005f(int i) {
        this.f4664c = i;
    }
}
