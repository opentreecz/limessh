package okio;

import cz.opentree.ap0;
import cz.opentree.zo0;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    /* renamed from: B */
    boolean mo4893B(long j, ap0 ap0Var) throws IOException;

    /* renamed from: C */
    String mo4894C(Charset charset) throws IOException;

    /* renamed from: I */
    String mo4895I() throws IOException;

    /* renamed from: J */
    int mo4896J() throws IOException;

    /* renamed from: L */
    byte[] mo4897L(long j) throws IOException;

    /* renamed from: P */
    short mo4898P() throws IOException;

    /* renamed from: U */
    void mo4899U(long j) throws IOException;

    /* renamed from: W */
    long mo4900W(byte b) throws IOException;

    /* renamed from: X */
    long mo4901X() throws IOException;

    /* renamed from: e */
    zo0 mo4905e();

    /* renamed from: k */
    ap0 mo4906k(long j) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    /* renamed from: s */
    boolean mo4907s() throws IOException;

    void skip(long j) throws IOException;

    /* renamed from: w */
    String mo4908w(long j) throws IOException;
}
