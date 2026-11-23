package cz.opentree;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@Deprecated
/* renamed from: cz.opentree.ic */
/* loaded from: classes.dex */
public final class C1155ic {
    /* renamed from: a */
    public static void m4744a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
