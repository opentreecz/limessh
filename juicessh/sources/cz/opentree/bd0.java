package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.material.datepicker.UtcDates;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public final class bd0 implements EncoderConfig<bd0> {

    /* renamed from: e */
    public static final ObjectEncoder<Object> f1648e = yc0.m10123b();

    /* renamed from: f */
    public static final ValueEncoder<String> f1649f = zc0.m10427b();

    /* renamed from: g */
    public static final ValueEncoder<Boolean> f1650g = ad0.m2044b();

    /* renamed from: h */
    public static final C0765b f1651h = new C0765b(null);

    /* renamed from: a */
    public final Map<Class<?>, ObjectEncoder<?>> f1652a = new HashMap();

    /* renamed from: b */
    public final Map<Class<?>, ValueEncoder<?>> f1653b = new HashMap();

    /* renamed from: c */
    public ObjectEncoder<Object> f1654c = f1648e;

    /* renamed from: d */
    public boolean f1655d = false;

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
    /* renamed from: cz.opentree.bd0$a */
    /* loaded from: classes.dex */
    public class C0764a implements DataEncoder {
        public C0764a() {
        }

        @Override // com.google.firebase.encoders.DataEncoder
        /* renamed from: a */
        public void mo1850a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
            cd0 cd0Var = new cd0(writer, bd0.this.f1652a, bd0.this.f1653b, bd0.this.f1654c, bd0.this.f1655d);
            cd0Var.m2764i(obj, false);
            cd0Var.m2773r();
        }

        @Override // com.google.firebase.encoders.DataEncoder
        /* renamed from: b */
        public String mo1851b(@NonNull Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                mo1850a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
    /* renamed from: cz.opentree.bd0$b */
    /* loaded from: classes.dex */
    public static final class C0765b implements ValueEncoder<Date> {

        /* renamed from: a */
        public static final DateFormat f1657a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f1657a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }

        public C0765b() {
        }

        public /* synthetic */ C0765b(C0764a c0764a) {
            this();
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo1852a(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.mo1857d(f1657a.format(date));
        }
    }

    public bd0() {
        m2446m(String.class, f1649f);
        m2446m(Boolean.class, f1650g);
        m2446m(Date.class, f1651h);
    }

    /* renamed from: i */
    public static /* synthetic */ void m2439i(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new xc0("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    /* renamed from: a */
    public /* bridge */ /* synthetic */ bd0 mo1860a(@NonNull Class cls, @NonNull ObjectEncoder objectEncoder) {
        m2445l(cls, objectEncoder);
        return this;
    }

    @NonNull
    /* renamed from: f */
    public DataEncoder m2442f() {
        return new C0764a();
    }

    @NonNull
    /* renamed from: g */
    public bd0 m2443g(@NonNull Configurator configurator) {
        configurator.mo1859a(this);
        return this;
    }

    @NonNull
    /* renamed from: h */
    public bd0 m2444h(boolean z) {
        this.f1655d = z;
        return this;
    }

    @NonNull
    /* renamed from: l */
    public <T> bd0 m2445l(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.f1652a.put(cls, objectEncoder);
        this.f1653b.remove(cls);
        return this;
    }

    @NonNull
    /* renamed from: m */
    public <T> bd0 m2446m(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.f1653b.put(cls, valueEncoder);
        this.f1652a.remove(cls);
        return this;
    }
}
