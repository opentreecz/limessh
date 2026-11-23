package com.sonelli;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public final class cd0 implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a */
    public cd0 f1916a = null;

    /* renamed from: b */
    public boolean f1917b = true;

    /* renamed from: c */
    public final JsonWriter f1918c;

    /* renamed from: d */
    public final Map<Class<?>, ObjectEncoder<?>> f1919d;

    /* renamed from: e */
    public final Map<Class<?>, ValueEncoder<?>> f1920e;

    /* renamed from: f */
    public final ObjectEncoder<Object> f1921f;

    /* renamed from: g */
    public final boolean f1922g;

    public cd0(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z) {
        this.f1918c = new JsonWriter(writer);
        this.f1919d = map;
        this.f1920e = map2;
        this.f1921f = objectEncoder;
        this.f1922g = z;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: a */
    public /* bridge */ /* synthetic */ ObjectEncoderContext mo1853a(@NonNull String str, boolean z) throws IOException {
        m2769n(str, z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: b */
    public /* bridge */ /* synthetic */ ObjectEncoderContext mo1854b(@NonNull String str, long j) throws IOException {
        m2767l(str, j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: c */
    public /* bridge */ /* synthetic */ ObjectEncoderContext mo1855c(@NonNull String str, int i) throws IOException {
        m2766k(str, i);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: d */
    public /* bridge */ /* synthetic */ ValueEncoderContext mo1857d(@Nullable String str) throws IOException {
        m2765j(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: e */
    public /* bridge */ /* synthetic */ ValueEncoderContext mo1858e(boolean z) throws IOException {
        m2770o(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: f */
    public /* bridge */ /* synthetic */ ObjectEncoderContext mo1856f(@NonNull String str, @Nullable Object obj) throws IOException {
        m2768m(str, obj);
        return this;
    }

    @NonNull
    /* renamed from: g */
    public cd0 m2762g(int i) throws IOException {
        m2777v();
        this.f1918c.value(i);
        return this;
    }

    @NonNull
    /* renamed from: h */
    public cd0 m2763h(long j) throws IOException {
        m2777v();
        this.f1918c.value(j);
        return this;
    }

    @NonNull
    /* renamed from: i */
    public cd0 m2764i(@Nullable Object obj, boolean z) throws IOException {
        int i = 0;
        if (z && m2772q(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new xc0(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f1918c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f1918c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f1918c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m2764i(it.next(), false);
                }
                this.f1918c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f1918c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m2768m((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new xc0(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.f1918c.endObject();
                return this;
            }
            ObjectEncoder<?> objectEncoder = this.f1919d.get(obj.getClass());
            if (objectEncoder != null) {
                m2774s(objectEncoder, obj, z);
                return this;
            }
            ValueEncoder<?> valueEncoder = this.f1920e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.mo1852a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                m2765j(((Enum) obj).name());
                return this;
            }
            m2774s(this.f1921f, obj, z);
            return this;
        }
        if (obj instanceof byte[]) {
            m2771p((byte[]) obj);
            return this;
        }
        this.f1918c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.f1918c.value(r6[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                m2763h(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.f1918c.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.f1918c.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                m2764i(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                m2764i(obj2, false);
            }
        }
        this.f1918c.endArray();
        return this;
    }

    @NonNull
    /* renamed from: j */
    public cd0 m2765j(@Nullable String str) throws IOException {
        m2777v();
        this.f1918c.value(str);
        return this;
    }

    @NonNull
    /* renamed from: k */
    public cd0 m2766k(@NonNull String str, int i) throws IOException {
        m2777v();
        this.f1918c.name(str);
        m2762g(i);
        return this;
    }

    @NonNull
    /* renamed from: l */
    public cd0 m2767l(@NonNull String str, long j) throws IOException {
        m2777v();
        this.f1918c.name(str);
        m2763h(j);
        return this;
    }

    @NonNull
    /* renamed from: m */
    public cd0 m2768m(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f1922g) {
            m2776u(str, obj);
            return this;
        }
        m2775t(str, obj);
        return this;
    }

    @NonNull
    /* renamed from: n */
    public cd0 m2769n(@NonNull String str, boolean z) throws IOException {
        m2777v();
        this.f1918c.name(str);
        m2770o(z);
        return this;
    }

    @NonNull
    /* renamed from: o */
    public cd0 m2770o(boolean z) throws IOException {
        m2777v();
        this.f1918c.value(z);
        return this;
    }

    @NonNull
    /* renamed from: p */
    public cd0 m2771p(@Nullable byte[] bArr) throws IOException {
        m2777v();
        if (bArr == null) {
            this.f1918c.nullValue();
        } else {
            this.f1918c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* renamed from: q */
    public final boolean m2772q(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    /* renamed from: r */
    public void m2773r() throws IOException {
        m2777v();
        this.f1918c.flush();
    }

    /* renamed from: s */
    public cd0 m2774s(ObjectEncoder<Object> objectEncoder, Object obj, boolean z) throws IOException {
        if (!z) {
            this.f1918c.beginObject();
        }
        objectEncoder.mo1852a(obj, this);
        if (!z) {
            this.f1918c.endObject();
        }
        return this;
    }

    /* renamed from: t */
    public final cd0 m2775t(@NonNull String str, @Nullable Object obj) throws IOException, xc0 {
        m2777v();
        this.f1918c.name(str);
        if (obj == null) {
            this.f1918c.nullValue();
            return this;
        }
        m2764i(obj, false);
        return this;
    }

    /* renamed from: u */
    public final cd0 m2776u(@NonNull String str, @Nullable Object obj) throws IOException, xc0 {
        if (obj == null) {
            return this;
        }
        m2777v();
        this.f1918c.name(str);
        m2764i(obj, false);
        return this;
    }

    /* renamed from: v */
    public final void m2777v() throws IOException {
        if (!this.f1917b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        cd0 cd0Var = this.f1916a;
        if (cd0Var != null) {
            cd0Var.m2777v();
            this.f1916a.f1917b = false;
            this.f1916a = null;
            this.f1918c.endObject();
        }
    }
}
