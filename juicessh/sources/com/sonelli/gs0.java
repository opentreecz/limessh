package com.sonelli;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public class gs0 implements Enumeration {

    /* renamed from: a */
    public wp0 f2980a;

    /* renamed from: b */
    public Object f2981b = m4257a();

    public gs0(byte[] bArr) {
        this.f2980a = new wp0(bArr, true);
    }

    /* renamed from: a */
    public final Object m4257a() {
        try {
            return this.f2980a.m9629n();
        } catch (IOException e) {
            throw new dq0("malformed DER construction: " + e, e);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f2981b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f2981b;
        this.f2981b = m4257a();
        return obj;
    }
}
