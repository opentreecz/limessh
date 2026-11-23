package com.sonelli;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.g */
/* loaded from: classes.dex */
public final class C1019g implements Configurator {

    /* renamed from: a */
    public static final Configurator f2784a = new C1019g();

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$a */
    /* loaded from: classes.dex */
    public static final class a implements ObjectEncoder<AbstractC0962f> {

        /* renamed from: a */
        public static final a f2785a = new a();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AbstractC0962f abstractC0962f = (AbstractC0962f) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo1856f("sdkVersion", abstractC0962f.mo3614i());
            objectEncoderContext2.mo1856f("model", abstractC0962f.mo3611f());
            objectEncoderContext2.mo1856f("hardware", abstractC0962f.mo3609d());
            objectEncoderContext2.mo1856f("device", abstractC0962f.mo3607b());
            objectEncoderContext2.mo1856f("product", abstractC0962f.mo3613h());
            objectEncoderContext2.mo1856f("osBuild", abstractC0962f.mo3612g());
            objectEncoderContext2.mo1856f("manufacturer", abstractC0962f.mo3610e());
            objectEncoderContext2.mo1856f("fingerprint", abstractC0962f.mo3608c());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$b */
    /* loaded from: classes.dex */
    public static final class b implements ObjectEncoder<AbstractC1627o> {

        /* renamed from: a */
        public static final b f2786a = new b();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("logRequest", ((AbstractC1627o) obj).mo4680b());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$c */
    /* loaded from: classes.dex */
    public static final class c implements ObjectEncoder<AbstractC1684p> {

        /* renamed from: a */
        public static final c f2787a = new c();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AbstractC1684p abstractC1684p = (AbstractC1684p) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo1856f("clientType", abstractC1684p.mo4991c());
            objectEncoderContext2.mo1856f("androidClientInfo", abstractC1684p.mo4990b());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$d */
    /* loaded from: classes.dex */
    public static final class d implements ObjectEncoder<AbstractC1742q> {

        /* renamed from: a */
        public static final d f2788a = new d();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AbstractC1742q abstractC1742q = (AbstractC1742q) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo1854b("eventTimeMs", abstractC1742q.mo5750d());
            objectEncoderContext2.mo1856f("eventCode", abstractC1742q.mo5749c());
            objectEncoderContext2.mo1854b("eventUptimeMs", abstractC1742q.mo5751e());
            objectEncoderContext2.mo1856f("sourceExtension", abstractC1742q.mo5753g());
            objectEncoderContext2.mo1856f("sourceExtensionJsonProto3", abstractC1742q.mo5754h());
            objectEncoderContext2.mo1854b("timezoneOffsetSeconds", abstractC1742q.mo5755i());
            objectEncoderContext2.mo1856f("networkConnectionInfo", abstractC1742q.mo5752f());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$e */
    /* loaded from: classes.dex */
    public static final class e implements ObjectEncoder<AbstractC1794r> {

        /* renamed from: a */
        public static final e f2789a = new e();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AbstractC1794r abstractC1794r = (AbstractC1794r) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo1854b("requestTimeMs", abstractC1794r.mo6022g());
            objectEncoderContext2.mo1854b("requestUptimeMs", abstractC1794r.mo6023h());
            objectEncoderContext2.mo1856f("clientInfo", abstractC1794r.mo6017b());
            objectEncoderContext2.mo1856f("logSource", abstractC1794r.mo6019d());
            objectEncoderContext2.mo1856f("logSourceName", abstractC1794r.mo6020e());
            objectEncoderContext2.mo1856f("logEvent", abstractC1794r.mo6018c());
            objectEncoderContext2.mo1856f("qosTier", abstractC1794r.mo6021f());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.g$f */
    /* loaded from: classes.dex */
    public static final class f implements ObjectEncoder<AbstractC1892t> {

        /* renamed from: a */
        public static final f f2790a = new f();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void mo1852a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AbstractC1892t abstractC1892t = (AbstractC1892t) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo1856f("networkType", abstractC1892t.mo6599c());
            objectEncoderContext2.mo1856f("mobileSubtype", abstractC1892t.mo6598b());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    /* renamed from: a */
    public void mo1859a(EncoderConfig<?> encoderConfig) {
        b bVar = b.f2786a;
        encoderConfig.mo1860a(AbstractC1627o.class, bVar);
        encoderConfig.mo1860a(C1137i.class, bVar);
        e eVar = e.f2789a;
        encoderConfig.mo1860a(AbstractC1794r.class, eVar);
        encoderConfig.mo1860a(C1482l.class, eVar);
        c cVar = c.f2787a;
        encoderConfig.mo1860a(AbstractC1684p.class, cVar);
        encoderConfig.mo1860a(C1190j.class, cVar);
        a aVar = a.f2785a;
        encoderConfig.mo1860a(AbstractC0962f.class, aVar);
        encoderConfig.mo1860a(C1087h.class, aVar);
        d dVar = d.f2788a;
        encoderConfig.mo1860a(AbstractC1742q.class, dVar);
        encoderConfig.mo1860a(C1418k.class, dVar);
        f fVar = f.f2790a;
        encoderConfig.mo1860a(AbstractC1892t.class, fVar);
        encoderConfig.mo1860a(C1581n.class, fVar);
    }
}
