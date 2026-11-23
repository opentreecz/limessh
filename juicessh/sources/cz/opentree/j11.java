package cz.opentree;

import java.io.IOException;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public abstract class j11 extends vt0 implements Encodable {
    public j11(boolean z) {
        super(z);
    }

    public abstract byte[] getEncoded() throws IOException;
}
