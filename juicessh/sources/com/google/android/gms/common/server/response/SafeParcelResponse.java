package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.sonelli.C0705ac;
import com.sonelli.C0813ca;
import com.sonelli.C1032ga;
import com.sonelli.C1099ha;
import com.sonelli.C1207jc;
import com.sonelli.C1444kc;
import com.sonelli.C1810rb;
import com.sonelli.C2420zb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new C1810rb();

    /* renamed from: O */
    public final int f895O;

    /* renamed from: P */
    public final Parcel f896P;

    /* renamed from: Q */
    public final int f897Q;

    /* renamed from: R */
    public final zaj f898R;

    /* renamed from: S */
    public final String f899S;

    /* renamed from: T */
    public int f900T;

    /* renamed from: U */
    public int f901U;

    public SafeParcelResponse(int i, Parcel parcel, zaj zajVar) {
        this.f895O = i;
        C0813ca.m2729k(parcel);
        this.f896P = parcel;
        this.f897Q = 2;
        this.f898R = zajVar;
        if (zajVar == null) {
            this.f899S = null;
        } else {
            this.f899S = zajVar.m1170K();
        }
        this.f900T = 2;
    }

    /* renamed from: h */
    public static void m1166h(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(C1207jc.m5100a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(C0705ac.m2036a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(C0705ac.m2037b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                C1444kc.m5866a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: a */
    public Map<String, FastJsonResponse.Field<?, ?>> mo840a() {
        zaj zajVar = this.f898R;
        if (zajVar == null) {
            return null;
        }
        return zajVar.m1171Y(this.f899S);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: c */
    public Object mo1150c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: e */
    public boolean mo1151e(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* renamed from: i */
    public final void m1167i(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().m1159c0(), entry);
        }
        sb.append('{');
        int m4070J = C1032ga.m4070J(parcel);
        boolean z = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(C1032ga.m4093u(m4062B));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.m1163g0()) {
                    switch (field.f887R) {
                        case 0:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, Integer.valueOf(C1032ga.m4064D(parcel, m4062B))));
                            break;
                        case 1:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, C1032ga.m4075c(parcel, m4062B)));
                            break;
                        case 2:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, Long.valueOf(C1032ga.m4066F(parcel, m4062B))));
                            break;
                        case 3:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, Float.valueOf(C1032ga.m4098z(parcel, m4062B))));
                            break;
                        case 4:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, Double.valueOf(C1032ga.m4096x(parcel, m4062B))));
                            break;
                        case 5:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, C1032ga.m4073a(parcel, m4062B)));
                            break;
                        case 6:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, Boolean.valueOf(C1032ga.m4094v(parcel, m4062B))));
                            break;
                        case 7:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, C1032ga.m4087o(parcel, m4062B)));
                            break;
                        case 8:
                        case 9:
                            m1168j(sb, field, FastJsonResponse.m1149g(field, C1032ga.m4079g(parcel, m4062B)));
                            break;
                        case 10:
                            Bundle m4078f = C1032ga.m4078f(parcel, m4062B);
                            HashMap hashMap = new HashMap();
                            for (String str2 : m4078f.keySet()) {
                                hashMap.put(str2, m4078f.getString(str2));
                            }
                            m1168j(sb, field, FastJsonResponse.m1149g(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i = field.f887R;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f888S) {
                    sb.append("[");
                    switch (field.f887R) {
                        case 0:
                            C2420zb.m10421e(sb, C1032ga.m4082j(parcel, m4062B));
                            break;
                        case 1:
                            C2420zb.m10423g(sb, C1032ga.m4076d(parcel, m4062B));
                            break;
                        case 2:
                            C2420zb.m10422f(sb, C1032ga.m4083k(parcel, m4062B));
                            break;
                        case 3:
                            C2420zb.m10420d(sb, C1032ga.m4081i(parcel, m4062B));
                            break;
                        case 4:
                            C2420zb.m10419c(sb, C1032ga.m4080h(parcel, m4062B));
                            break;
                        case 5:
                            C2420zb.m10423g(sb, C1032ga.m4074b(parcel, m4062B));
                            break;
                        case 6:
                            C2420zb.m10424h(sb, C1032ga.m4077e(parcel, m4062B));
                            break;
                        case 7:
                            C2420zb.m10425i(sb, C1032ga.m4088p(parcel, m4062B));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] m4085m = C1032ga.m4085m(parcel, m4062B);
                            int length = m4085m.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(",");
                                }
                                m4085m[i2].setDataPosition(0);
                                m1167i(sb, field.m1165i0(), m4085m[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f887R) {
                        case 0:
                            sb.append(C1032ga.m4064D(parcel, m4062B));
                            break;
                        case 1:
                            sb.append(C1032ga.m4075c(parcel, m4062B));
                            break;
                        case 2:
                            sb.append(C1032ga.m4066F(parcel, m4062B));
                            break;
                        case 3:
                            sb.append(C1032ga.m4098z(parcel, m4062B));
                            break;
                        case 4:
                            sb.append(C1032ga.m4096x(parcel, m4062B));
                            break;
                        case 5:
                            sb.append(C1032ga.m4073a(parcel, m4062B));
                            break;
                        case 6:
                            sb.append(C1032ga.m4094v(parcel, m4062B));
                            break;
                        case 7:
                            String m4087o = C1032ga.m4087o(parcel, m4062B);
                            sb.append("\"");
                            sb.append(C1207jc.m5100a(m4087o));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] m4079g = C1032ga.m4079g(parcel, m4062B);
                            sb.append("\"");
                            sb.append(C0705ac.m2036a(m4079g));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] m4079g2 = C1032ga.m4079g(parcel, m4062B);
                            sb.append("\"");
                            sb.append(C0705ac.m2037b(m4079g2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle m4078f2 = C1032ga.m4078f(parcel, m4062B);
                            Set<String> keySet = m4078f2.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(C1207jc.m5100a(m4078f2.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel m4084l = C1032ga.m4084l(parcel, m4062B);
                            m4084l.setDataPosition(0);
                            m1167i(sb, field.m1165i0(), m4084l);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == m4070J) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(m4070J);
        throw new C1032ga.a(sb3.toString(), parcel);
    }

    /* renamed from: j */
    public final void m1168j(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (!field.f886Q) {
            m1166h(sb, field.f885P, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m1166h(sb, field.f885P, arrayList.get(i));
        }
        sb.append("]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r0 != 1) goto L9;
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Parcel m1169k() {
        /*
            r2 = this;
            int r0 = r2.f900T
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.f896P
            int r0 = com.sonelli.C1099ha.m4396a(r0)
            r2.f901U = r0
        L10:
            android.os.Parcel r0 = r2.f896P
            int r1 = r2.f901U
            com.sonelli.C1099ha.m4397b(r0, r1)
            r0 = 2
            r2.f900T = r0
        L1a:
            android.os.Parcel r0 = r2.f896P
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.m1169k():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        C0813ca.m2730l(this.f898R, "Cannot convert to JSON on client side.");
        Parcel m1169k = m1169k();
        m1169k.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m1167i(sb, this.f898R.m1171Y(this.f899S), m1169k);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zaj zajVar;
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f895O);
        C1099ha.m4410o(parcel, 2, m1169k(), false);
        int i2 = this.f897Q;
        if (i2 == 0) {
            zajVar = null;
        } else if (i2 == 1) {
            zajVar = this.f898R;
        } else {
            if (i2 != 2) {
                int i3 = this.f897Q;
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            zajVar = this.f898R;
        }
        C1099ha.m4411p(parcel, 3, zajVar, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
