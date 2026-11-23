package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zab;
import com.sonelli.C0705ac;
import com.sonelli.C0758ba;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1207jc;
import com.sonelli.C1444kc;
import com.sonelli.C1598nb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final C1598nb CREATOR = new C1598nb();

        /* renamed from: O */
        public final int f884O;

        /* renamed from: P */
        public final int f885P;

        /* renamed from: Q */
        public final boolean f886Q;

        /* renamed from: R */
        public final int f887R;

        /* renamed from: S */
        public final boolean f888S;

        /* renamed from: T */
        public final String f889T;

        /* renamed from: U */
        public final int f890U;

        /* renamed from: V */
        public final Class<? extends FastJsonResponse> f891V;

        /* renamed from: W */
        public final String f892W;

        /* renamed from: X */
        public zaj f893X;

        /* renamed from: Y */
        public FieldConverter<I, O> f894Y;

        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zab zabVar) {
            this.f884O = i;
            this.f885P = i2;
            this.f886Q = z;
            this.f887R = i3;
            this.f888S = z2;
            this.f889T = str;
            this.f890U = i4;
            if (str2 == null) {
                this.f891V = null;
                this.f892W = null;
            } else {
                this.f891V = SafeParcelResponse.class;
                this.f892W = str2;
            }
            if (zabVar == null) {
                this.f894Y = null;
            } else {
                this.f894Y = (FieldConverter<I, O>) zabVar.m1147K();
            }
        }

        public Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.f884O = 1;
            this.f885P = i;
            this.f886Q = z;
            this.f887R = i2;
            this.f888S = z2;
            this.f889T = str;
            this.f890U = i3;
            this.f891V = cls;
            if (cls == null) {
                this.f892W = null;
            } else {
                this.f892W = cls.getCanonicalName();
            }
            this.f894Y = fieldConverter;
        }

        /* renamed from: K */
        public static <T extends FastJsonResponse> Field<T, T> m1152K(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        /* renamed from: Y */
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> m1153Y(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        /* renamed from: Z */
        public static Field<Integer, Integer> m1154Z(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        /* renamed from: a0 */
        public static Field<String, String> m1155a0(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        /* renamed from: b0 */
        public static Field<ArrayList<String>, ArrayList<String>> m1156b0(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        /* renamed from: x */
        public static Field<byte[], byte[]> m1158x(String str, int i) {
            return new Field<>(8, false, 8, false, str, i, null, null);
        }

        /* renamed from: c0 */
        public int m1159c0() {
            return this.f890U;
        }

        /* renamed from: e0 */
        public final void m1160e0(zaj zajVar) {
            this.f893X = zajVar;
        }

        /* renamed from: f */
        public final I m1161f(O o) {
            return this.f894Y.mo1144f(o);
        }

        /* renamed from: f0 */
        public final String m1162f0() {
            String str = this.f892W;
            if (str == null) {
                return null;
            }
            return str;
        }

        /* renamed from: g0 */
        public final boolean m1163g0() {
            return this.f894Y != null;
        }

        /* renamed from: h0 */
        public final zab m1164h0() {
            FieldConverter<I, O> fieldConverter = this.f894Y;
            if (fieldConverter == null) {
                return null;
            }
            return zab.m1146x(fieldConverter);
        }

        /* renamed from: i0 */
        public final Map<String, Field<?, ?>> m1165i0() {
            C0813ca.m2729k(this.f892W);
            C0813ca.m2729k(this.f893X);
            return this.f893X.m1171Y(this.f892W);
        }

        public String toString() {
            C0758ba.a m2406c = C0758ba.m2406c(this);
            m2406c.m2407a("versionCode", Integer.valueOf(this.f884O));
            m2406c.m2407a("typeIn", Integer.valueOf(this.f885P));
            m2406c.m2407a("typeInArray", Boolean.valueOf(this.f886Q));
            m2406c.m2407a("typeOut", Integer.valueOf(this.f887R));
            m2406c.m2407a("typeOutArray", Boolean.valueOf(this.f888S));
            m2406c.m2407a("outputFieldName", this.f889T);
            m2406c.m2407a("safeParcelFieldId", Integer.valueOf(this.f890U));
            m2406c.m2407a("concreteTypeName", m1162f0());
            Class<? extends FastJsonResponse> cls = this.f891V;
            if (cls != null) {
                m2406c.m2407a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.f894Y;
            if (fieldConverter != null) {
                m2406c.m2407a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return m2406c.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int m4396a = C1099ha.m4396a(parcel);
            C1099ha.m4406k(parcel, 1, this.f884O);
            C1099ha.m4406k(parcel, 2, this.f885P);
            C1099ha.m4398c(parcel, 3, this.f886Q);
            C1099ha.m4406k(parcel, 4, this.f887R);
            C1099ha.m4398c(parcel, 5, this.f888S);
            C1099ha.m4412q(parcel, 6, this.f889T, false);
            C1099ha.m4406k(parcel, 7, m1159c0());
            C1099ha.m4412q(parcel, 8, m1162f0(), false);
            C1099ha.m4411p(parcel, 9, m1164h0(), i, false);
            C1099ha.m4397b(parcel, m4396a);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface FieldConverter<I, O> {
        /* renamed from: f */
        I mo1144f(O o);
    }

    /* renamed from: f */
    public static void m1148f(StringBuilder sb, Field field, Object obj) {
        int i = field.f885P;
        if (i == 11) {
            sb.append(field.f891V.cast(obj).toString());
        } else {
            if (i != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(C1207jc.m5100a((String) obj));
            sb.append("\"");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public static <O, I> I m1149g(Field<I, O> field, Object obj) {
        return field.f894Y != null ? field.m1161f(obj) : obj;
    }

    /* renamed from: a */
    public abstract Map<String, Field<?, ?>> mo840a();

    /* renamed from: b */
    public Object mo841b(Field field) {
        String str = field.f889T;
        if (field.f891V == null) {
            return mo1150c(str);
        }
        C0813ca.m2734p(mo1150c(str) == null, "Concrete field shouldn't be value object: %s", field.f889T);
        boolean z = field.f888S;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public abstract Object mo1150c(String str);

    /* renamed from: d */
    public boolean mo842d(Field field) {
        if (field.f887R != 11) {
            return mo1151e(field.f889T);
        }
        if (field.f888S) {
            String str = field.f889T;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = field.f889T;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* renamed from: e */
    public abstract boolean mo1151e(String str);

    public String toString() {
        Map<String, Field<?, ?>> mo840a = mo840a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mo840a.keySet()) {
            Field<?, ?> field = mo840a.get(str);
            if (mo842d(field)) {
                Object m1149g = m1149g(field, mo841b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (m1149g != null) {
                    switch (field.f887R) {
                        case 8:
                            sb.append("\"");
                            sb.append(C0705ac.m2036a((byte[]) m1149g));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(C0705ac.m2037b((byte[]) m1149g));
                            sb.append("\"");
                            break;
                        case 10:
                            C1444kc.m5866a(sb, (HashMap) m1149g);
                            break;
                        default:
                            if (field.f886Q) {
                                ArrayList arrayList = (ArrayList) m1149g;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        m1148f(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                m1148f(sb, field, m1149g);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
