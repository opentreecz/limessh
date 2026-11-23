package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class SdkFilterInputStream extends FilterInputStream implements MetricAware {
    public SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    public void m209a() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        m210b();
        return ((FilterInputStream) this).in.available();
    }

    /* renamed from: b */
    public final void m210b() {
        if (Thread.interrupted()) {
            m209a();
            throw new AbortedException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        m210b();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        m210b();
        ((FilterInputStream) this).in.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        m210b();
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        m210b();
        ((FilterInputStream) this).in.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        m210b();
        return ((FilterInputStream) this).in.skip(j);
    }
}
