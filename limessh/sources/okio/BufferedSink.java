package okio;

import cz.opentree.ap0;
import cz.opentree.zo0;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    /* renamed from: A */
    BufferedSink mo4611A(String str) throws IOException;

    /* renamed from: E */
    BufferedSink mo4612E(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: G */
    long mo4613G(Source source) throws IOException;

    /* renamed from: H */
    BufferedSink mo4614H(long j) throws IOException;

    /* renamed from: N */
    BufferedSink mo4615N(byte[] bArr) throws IOException;

    /* renamed from: O */
    BufferedSink mo4616O(ap0 ap0Var) throws IOException;

    /* renamed from: V */
    BufferedSink mo4617V(long j) throws IOException;

    /* renamed from: e */
    zo0 mo4618e();

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    /* renamed from: m */
    BufferedSink mo4619m(int i) throws IOException;

    /* renamed from: o */
    BufferedSink mo4620o(int i) throws IOException;

    /* renamed from: t */
    BufferedSink mo4621t(int i) throws IOException;

    /* renamed from: v */
    BufferedSink mo4622v() throws IOException;
}
