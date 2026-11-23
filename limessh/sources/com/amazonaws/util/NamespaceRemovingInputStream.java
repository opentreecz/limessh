package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NamespaceRemovingInputStream extends SdkFilterInputStream {

    /* renamed from: O */
    public final byte[] f486O;

    /* renamed from: P */
    public boolean f487P;

    /* loaded from: classes.dex */
    public static final class StringPrefixSlicer {

        /* renamed from: a */
        public String f488a;

        public StringPrefixSlicer(String str) {
            this.f488a = str;
        }

        /* renamed from: a */
        public String m672a() {
            return this.f488a;
        }

        /* renamed from: b */
        public boolean m673b(String str) {
            if (!this.f488a.startsWith(str)) {
                return false;
            }
            this.f488a = this.f488a.substring(str.length());
            return true;
        }

        /* renamed from: c */
        public boolean m674c(String str) {
            int indexOf = this.f488a.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.f488a = this.f488a.substring(indexOf + str.length());
            return true;
        }

        /* renamed from: d */
        public boolean m675d(String str) {
            if (!this.f488a.startsWith(str)) {
                return false;
            }
            while (this.f488a.startsWith(str)) {
                this.f488a = this.f488a.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.f486O = new byte[200];
        this.f487P = false;
    }

    /* renamed from: c */
    public final int m671c(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.m673b("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.m675d(" ");
        if (!stringPrefixSlicer.m673b(SimpleComparison.EQUAL_TO_OPERATION)) {
            return -1;
        }
        stringPrefixSlicer.m675d(" ");
        if (stringPrefixSlicer.m673b("\"") && stringPrefixSlicer.m674c("\"")) {
            return str.length() - stringPrefixSlicer.m672a().length();
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        m210b();
        int read = ((FilterInputStream) this).in.read();
        if (read != 120 || this.f487P) {
            return read;
        }
        this.f486O[0] = (byte) read;
        ((FilterInputStream) this).in.mark(this.f486O.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.f486O;
        int read2 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int m671c = m671c(new String(this.f486O, 0, read2 + 1, StringUtils.f489a));
        if (m671c <= 0) {
            return read;
        }
        for (int i = 0; i < m671c - 1; i++) {
            ((FilterInputStream) this).in.read();
        }
        int read3 = ((FilterInputStream) this).in.read();
        this.f487P = true;
        return read3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i3 + i] = (byte) read;
        }
        return i2;
    }
}
