package com.sonelli;

import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: StatusLine.java */
/* loaded from: classes.dex */
public final class zn0 {

    /* renamed from: a */
    public final vm0 f8567a;

    /* renamed from: b */
    public final int f8568b;

    /* renamed from: c */
    public final String f8569c;

    public zn0(vm0 vm0Var, int i, String str) {
        this.f8567a = vm0Var;
        this.f8568b = i;
        this.f8569c = str;
    }

    /* renamed from: a */
    public static zn0 m10545a(String str) throws IOException {
        vm0 vm0Var;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vm0Var = vm0.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                vm0Var = vm0.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            vm0Var = vm0.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new zn0(vm0Var, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8567a == vm0.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f8568b);
        if (this.f8569c != null) {
            sb.append(' ');
            sb.append(this.f8569c);
        }
        return sb.toString();
    }
}
