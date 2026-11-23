package com.sonelli;

/* loaded from: classes.dex */
public class js0 {

    /* renamed from: a */
    public String f3650a;

    /* renamed from: b */
    public int f3651b = 0;

    public js0(String str) {
        this.f3650a = str;
    }

    /* renamed from: a */
    public boolean m5190a() {
        return this.f3651b != -1;
    }

    /* renamed from: b */
    public String m5191b() {
        int i = this.f3651b;
        if (i == -1) {
            return null;
        }
        int indexOf = this.f3650a.indexOf(46, i);
        if (indexOf == -1) {
            String substring = this.f3650a.substring(this.f3651b);
            this.f3651b = -1;
            return substring;
        }
        String substring2 = this.f3650a.substring(this.f3651b, indexOf);
        this.f3651b = indexOf + 1;
        return substring2;
    }
}
