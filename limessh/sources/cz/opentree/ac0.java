package cz.opentree;

import com.google.android.datatransport.Transformer;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ac0 implements Transformer {

    /* renamed from: a */
    public static final ac0 f1364a = new ac0();

    /* renamed from: a */
    public static Transformer m2039a() {
        return f1364a;
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        byte[] bytes;
        bytes = bc0.f1641c.m1814F((oa0) obj).getBytes(Charset.forName("UTF-8"));
        return bytes;
    }
}
