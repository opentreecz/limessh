package com.sonelli;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.sonelli.oa0;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class t90 implements Configurator {

    /* renamed from: a */
    public static final Configurator f6726a = new t90();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$a */
    /* loaded from: classes.dex */
    public static final class C1905a implements ObjectEncoder<oa0.AbstractC1643b> {

        /* renamed from: a */
        public static final C1905a f6727a = new C1905a();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1643b abstractC1643b, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("key", abstractC1643b.mo6937b());
            objectEncoderContext.mo1856f("value", abstractC1643b.mo6938c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$b */
    /* loaded from: classes.dex */
    public static final class C1906b implements ObjectEncoder<oa0> {

        /* renamed from: a */
        public static final C1906b f6728a = new C1906b();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0 oa0Var, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("sdkVersion", oa0Var.mo6920i());
            objectEncoderContext.mo1856f("gmpAppId", oa0Var.mo6916e());
            objectEncoderContext.mo1855c("platform", oa0Var.mo6919h());
            objectEncoderContext.mo1856f("installationUuid", oa0Var.mo6917f());
            objectEncoderContext.mo1856f("buildVersion", oa0Var.mo6914c());
            objectEncoderContext.mo1856f("displayVersion", oa0Var.mo6915d());
            objectEncoderContext.mo1856f("session", oa0Var.mo6921j());
            objectEncoderContext.mo1856f("ndkPayload", oa0Var.mo6918g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$c */
    /* loaded from: classes.dex */
    public static final class C1907c implements ObjectEncoder<oa0.AbstractC1644c> {

        /* renamed from: a */
        public static final C1907c f6729a = new C1907c();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1644c abstractC1644c, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("files", abstractC1644c.mo6943b());
            objectEncoderContext.mo1856f("orgId", abstractC1644c.mo6944c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$d */
    /* loaded from: classes.dex */
    public static final class C1908d implements ObjectEncoder<oa0.AbstractC1644c.b> {

        /* renamed from: a */
        public static final C1908d f6730a = new C1908d();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1644c.b bVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("filename", bVar.mo6950c());
            objectEncoderContext.mo1856f("contents", bVar.mo6949b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$e */
    /* loaded from: classes.dex */
    public static final class C1909e implements ObjectEncoder<oa0.AbstractC1645d.a> {

        /* renamed from: a */
        public static final C1909e f6731a = new C1909e();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("identifier", aVar.mo6972c());
            objectEncoderContext.mo1856f("version", aVar.mo6975f());
            objectEncoderContext.mo1856f("displayVersion", aVar.mo6971b());
            objectEncoderContext.mo1856f("organization", aVar.mo6974e());
            objectEncoderContext.mo1856f("installationUuid", aVar.mo6973d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$f */
    /* loaded from: classes.dex */
    public static final class C1910f implements ObjectEncoder<oa0.AbstractC1645d.a.b> {

        /* renamed from: a */
        public static final C1910f f6732a = new C1910f();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.a.b bVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("clsId", bVar.mo2030a());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$g */
    /* loaded from: classes.dex */
    public static final class C1911g implements ObjectEncoder<oa0.AbstractC1645d.c> {

        /* renamed from: a */
        public static final C1911g f6733a = new C1911g();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.c cVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1855c("arch", cVar.mo2408b());
            objectEncoderContext.mo1856f("model", cVar.mo2412f());
            objectEncoderContext.mo1855c("cores", cVar.mo2409c());
            objectEncoderContext.mo1854b("ram", cVar.mo2414h());
            objectEncoderContext.mo1854b("diskSpace", cVar.mo2410d());
            objectEncoderContext.mo1853a("simulator", cVar.mo2416j());
            objectEncoderContext.mo1855c("state", cVar.mo2415i());
            objectEncoderContext.mo1856f("manufacturer", cVar.mo2411e());
            objectEncoderContext.mo1856f("modelClass", cVar.mo2413g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$h */
    /* loaded from: classes.dex */
    public static final class C1912h implements ObjectEncoder<oa0.AbstractC1645d> {

        /* renamed from: a */
        public static final C1912h f6734a = new C1912h();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d abstractC1645d, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("generator", abstractC1645d.mo6959f());
            objectEncoderContext.mo1856f("identifier", abstractC1645d.m6962i());
            objectEncoderContext.mo1854b("startedAt", abstractC1645d.mo6964k());
            objectEncoderContext.mo1856f("endedAt", abstractC1645d.mo6957d());
            objectEncoderContext.mo1853a("crashed", abstractC1645d.mo6966m());
            objectEncoderContext.mo1856f("app", abstractC1645d.mo6955b());
            objectEncoderContext.mo1856f("user", abstractC1645d.mo6965l());
            objectEncoderContext.mo1856f("os", abstractC1645d.mo6963j());
            objectEncoderContext.mo1856f("device", abstractC1645d.mo6956c());
            objectEncoderContext.mo1856f("events", abstractC1645d.mo6958e());
            objectEncoderContext.mo1855c("generatorType", abstractC1645d.mo6960g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$i */
    /* loaded from: classes.dex */
    public static final class C1913i implements ObjectEncoder<oa0.AbstractC1645d.d.a> {

        /* renamed from: a */
        public static final C1913i f6735a = new C1913i();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("execution", aVar.mo3173d());
            objectEncoderContext.mo1856f("customAttributes", aVar.mo3172c());
            objectEncoderContext.mo1856f("background", aVar.mo3171b());
            objectEncoderContext.mo1855c("uiOrientation", aVar.mo3174e());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$j */
    /* loaded from: classes.dex */
    public static final class C1914j implements ObjectEncoder<oa0.AbstractC1645d.d.a.b.AbstractC2503a> {

        /* renamed from: a */
        public static final C1914j f6736a = new C1914j();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b.AbstractC2503a abstractC2503a, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1854b("baseAddress", abstractC2503a.mo3697b());
            objectEncoderContext.mo1854b("size", abstractC2503a.mo3699d());
            objectEncoderContext.mo1856f("name", abstractC2503a.mo3698c());
            objectEncoderContext.mo1856f("uuid", abstractC2503a.m6999f());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$k */
    /* loaded from: classes.dex */
    public static final class C1915k implements ObjectEncoder<oa0.AbstractC1645d.d.a.b> {

        /* renamed from: a */
        public static final C1915k f6737a = new C1915k();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b bVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("threads", bVar.mo3464e());
            objectEncoderContext.mo1856f("exception", bVar.mo3462c());
            objectEncoderContext.mo1856f("signal", bVar.mo3463d());
            objectEncoderContext.mo1856f("binaries", bVar.mo3461b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$l */
    /* loaded from: classes.dex */
    public static final class C1916l implements ObjectEncoder<oa0.AbstractC1645d.d.a.b.c> {

        /* renamed from: a */
        public static final C1916l f6738a = new C1916l();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b.c cVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, cVar.mo4103f());
            objectEncoderContext.mo1856f("reason", cVar.mo4102e());
            objectEncoderContext.mo1856f("frames", cVar.mo4100c());
            objectEncoderContext.mo1856f("causedBy", cVar.mo4099b());
            objectEncoderContext.mo1855c("overflowCount", cVar.mo4101d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$m */
    /* loaded from: classes.dex */
    public static final class C1917m implements ObjectEncoder<oa0.AbstractC1645d.d.a.b.AbstractC2507d> {

        /* renamed from: a */
        public static final C1917m f6739a = new C1917m();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b.AbstractC2507d abstractC2507d, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("name", abstractC2507d.mo4423d());
            objectEncoderContext.mo1856f("code", abstractC2507d.mo4422c());
            objectEncoderContext.mo1854b("address", abstractC2507d.mo4421b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$n */
    /* loaded from: classes.dex */
    public static final class C1918n implements ObjectEncoder<oa0.AbstractC1645d.d.a.b.e> {

        /* renamed from: a */
        public static final C1918n f6740a = new C1918n();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b.e eVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("name", eVar.mo4734d());
            objectEncoderContext.mo1855c("importance", eVar.mo4733c());
            objectEncoderContext.mo1856f("frames", eVar.mo4732b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$o */
    /* loaded from: classes.dex */
    public static final class C1919o implements ObjectEncoder<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> {

        /* renamed from: a */
        public static final C1919o f6741a = new C1919o();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.a.b.e.AbstractC2510b abstractC2510b, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1854b("pc", abstractC2510b.mo5091e());
            objectEncoderContext.mo1856f("symbol", abstractC2510b.mo5092f());
            objectEncoderContext.mo1856f("file", abstractC2510b.mo5088b());
            objectEncoderContext.mo1854b("offset", abstractC2510b.mo5090d());
            objectEncoderContext.mo1855c("importance", abstractC2510b.mo5089c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$p */
    /* loaded from: classes.dex */
    public static final class C1920p implements ObjectEncoder<oa0.AbstractC1645d.d.c> {

        /* renamed from: a */
        public static final C1920p f6742a = new C1920p();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.c cVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("batteryLevel", cVar.mo5852b());
            objectEncoderContext.mo1855c("batteryVelocity", cVar.mo5853c());
            objectEncoderContext.mo1853a("proximityOn", cVar.mo5857g());
            objectEncoderContext.mo1855c("orientation", cVar.mo5855e());
            objectEncoderContext.mo1854b("ramUsed", cVar.mo5856f());
            objectEncoderContext.mo1854b("diskUsed", cVar.mo5854d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$q */
    /* loaded from: classes.dex */
    public static final class C1921q implements ObjectEncoder<oa0.AbstractC1645d.d> {

        /* renamed from: a */
        public static final C1921q f6743a = new C1921q();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d dVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1854b("timestamp", dVar.mo2738e());
            objectEncoderContext.mo1856f(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, dVar.mo2739f());
            objectEncoderContext.mo1856f("app", dVar.mo2735b());
            objectEncoderContext.mo1856f("device", dVar.mo2736c());
            objectEncoderContext.mo1856f("log", dVar.mo2737d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$r */
    /* loaded from: classes.dex */
    public static final class C1922r implements ObjectEncoder<oa0.AbstractC1645d.d.AbstractC2512d> {

        /* renamed from: a */
        public static final C1922r f6744a = new C1922r();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.d.AbstractC2512d abstractC2512d, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("content", abstractC2512d.mo6100b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$s */
    /* loaded from: classes.dex */
    public static final class C1923s implements ObjectEncoder<oa0.AbstractC1645d.e> {

        /* renamed from: a */
        public static final C1923s f6745a = new C1923s();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.e eVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1855c("platform", eVar.mo6387c());
            objectEncoderContext.mo1856f("version", eVar.mo6388d());
            objectEncoderContext.mo1856f("buildVersion", eVar.mo6386b());
            objectEncoderContext.mo1853a("jailbroken", eVar.mo6389e());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.t90$t */
    /* loaded from: classes.dex */
    public static final class C1924t implements ObjectEncoder<oa0.AbstractC1645d.f> {

        /* renamed from: a */
        public static final C1924t f6746a = new C1924t();

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(oa0.AbstractC1645d.f fVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo1856f("identifier", fVar.mo6654b());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    /* renamed from: a */
    public void mo1859a(EncoderConfig<?> encoderConfig) {
        C1906b c1906b = C1906b.f6728a;
        encoderConfig.mo1860a(oa0.class, c1906b);
        encoderConfig.mo1860a(u90.class, c1906b);
        C1912h c1912h = C1912h.f6734a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.class, c1912h);
        encoderConfig.mo1860a(y90.class, c1912h);
        C1909e c1909e = C1909e.f6731a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.a.class, c1909e);
        encoderConfig.mo1860a(z90.class, c1909e);
        C1910f c1910f = C1910f.f6732a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.a.b.class, c1910f);
        encoderConfig.mo1860a(aa0.class, c1910f);
        C1924t c1924t = C1924t.f6746a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.f.class, c1924t);
        encoderConfig.mo1860a(na0.class, c1924t);
        C1923s c1923s = C1923s.f6745a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.e.class, c1923s);
        encoderConfig.mo1860a(ma0.class, c1923s);
        C1911g c1911g = C1911g.f6733a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.c.class, c1911g);
        encoderConfig.mo1860a(ba0.class, c1911g);
        C1921q c1921q = C1921q.f6743a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.class, c1921q);
        encoderConfig.mo1860a(ca0.class, c1921q);
        C1913i c1913i = C1913i.f6735a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.class, c1913i);
        encoderConfig.mo1860a(da0.class, c1913i);
        C1915k c1915k = C1915k.f6737a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.class, c1915k);
        encoderConfig.mo1860a(ea0.class, c1915k);
        C1918n c1918n = C1918n.f6740a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.e.class, c1918n);
        encoderConfig.mo1860a(ia0.class, c1918n);
        C1919o c1919o = C1919o.f6741a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.class, c1919o);
        encoderConfig.mo1860a(ja0.class, c1919o);
        C1916l c1916l = C1916l.f6738a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.c.class, c1916l);
        encoderConfig.mo1860a(ga0.class, c1916l);
        C1917m c1917m = C1917m.f6739a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.AbstractC2507d.class, c1917m);
        encoderConfig.mo1860a(ha0.class, c1917m);
        C1914j c1914j = C1914j.f6736a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.a.b.AbstractC2503a.class, c1914j);
        encoderConfig.mo1860a(fa0.class, c1914j);
        C1905a c1905a = C1905a.f6727a;
        encoderConfig.mo1860a(oa0.AbstractC1643b.class, c1905a);
        encoderConfig.mo1860a(v90.class, c1905a);
        C1920p c1920p = C1920p.f6742a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.c.class, c1920p);
        encoderConfig.mo1860a(ka0.class, c1920p);
        C1922r c1922r = C1922r.f6744a;
        encoderConfig.mo1860a(oa0.AbstractC1645d.d.AbstractC2512d.class, c1922r);
        encoderConfig.mo1860a(la0.class, c1922r);
        C1907c c1907c = C1907c.f6729a;
        encoderConfig.mo1860a(oa0.AbstractC1644c.class, c1907c);
        encoderConfig.mo1860a(w90.class, c1907c);
        C1908d c1908d = C1908d.f6730a;
        encoderConfig.mo1860a(oa0.AbstractC1644c.b.class, c1908d);
        encoderConfig.mo1860a(x90.class, c1908d);
    }
}
