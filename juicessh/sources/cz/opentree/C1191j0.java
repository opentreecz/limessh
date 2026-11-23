package cz.opentree;

import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportInternal;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.j0 */
/* loaded from: classes.dex */
public final class C1191j0 implements TransportFactory {

    /* renamed from: a */
    public final Set<C0746b> f3459a;

    /* renamed from: b */
    public final AbstractC1138i0 f3460b;

    /* renamed from: c */
    public final TransportInternal f3461c;

    public C1191j0(Set<C0746b> set, AbstractC1138i0 abstractC1138i0, TransportInternal transportInternal) {
        this.f3459a = set;
        this.f3460b = abstractC1138i0;
        this.f3461c = transportInternal;
    }

    @Override // com.google.android.datatransport.TransportFactory
    /* renamed from: a */
    public <T> Transport<T> mo739a(String str, Class<T> cls, C0746b c0746b, Transformer<T, byte[]> transformer) {
        if (this.f3459a.contains(c0746b)) {
            return new C1419k0(this.f3460b, str, c0746b, transformer, this.f3461c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c0746b, this.f3459a));
    }
}
