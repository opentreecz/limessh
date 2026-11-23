package cz.opentree;

import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportInternal;
import cz.opentree.AbstractC1088h0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.k0 */
/* loaded from: classes.dex */
public final class C1419k0<T> implements Transport<T> {

    /* renamed from: a */
    public final AbstractC1138i0 f4413a;

    /* renamed from: b */
    public final String f4414b;

    /* renamed from: c */
    public final C0746b f4415c;

    /* renamed from: d */
    public final Transformer<T, byte[]> f4416d;

    /* renamed from: e */
    public final TransportInternal f4417e;

    public C1419k0(AbstractC1138i0 abstractC1138i0, String str, C0746b c0746b, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f4413a = abstractC1138i0;
        this.f4414b = str;
        this.f4415c = c0746b;
        this.f4416d = transformer;
        this.f4417e = transportInternal;
    }

    @Override // com.google.android.datatransport.Transport
    /* renamed from: a */
    public void mo738a(AbstractC0802c<T> abstractC0802c, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal = this.f4417e;
        AbstractC1088h0.a m4296a = AbstractC1088h0.m4296a();
        m4296a.mo1940e(this.f4413a);
        m4296a.mo1938c(abstractC0802c);
        m4296a.mo1941f(this.f4414b);
        m4296a.mo1939d(this.f4416d);
        m4296a.mo1937b(this.f4415c);
        transportInternal.mo742a(m4296a.mo1936a(), transportScheduleCallback);
    }
}
