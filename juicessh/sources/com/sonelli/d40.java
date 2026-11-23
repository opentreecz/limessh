package com.sonelli;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzm;
import com.sonelli.C1032ga;
import com.sonelli.C1610nk;
import com.sonelli.C1722pk;
import com.sonelli.C1821rk;
import com.sonelli.C2175vk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class d40 extends w30 {
    public d40(z30 z30Var) {
        super(z30Var);
    }

    /* renamed from: A */
    public static <Builder extends zzgs> Builder m3120A(Builder builder, byte[] bArr) throws C0839co {
        C1466kn m5955c = C1466kn.m5955c();
        return m5955c != null ? (Builder) builder.mo1261p(bArr, m5955c) : (Builder) builder.mo1262x(bArr);
    }

    /* renamed from: E */
    public static String m3121E(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* renamed from: F */
    public static List<Long> m3122F(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        j |= 1 << i2;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* renamed from: H */
    public static List<C1722pk> m3123H(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                C1722pk.a m7356e0 = C1722pk.m7356e0();
                for (String str : bundle.keySet()) {
                    C1722pk.a m7356e02 = C1722pk.m7356e0();
                    m7356e02.m7380B(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        m7356e02.m7388y(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        m7356e02.m7382D((String) obj);
                    } else if (obj instanceof Double) {
                        m7356e02.m7387w(((Double) obj).doubleValue());
                    }
                    m7356e0.m7389z(m7356e02);
                }
                if (m7356e0.m7384F() > 0) {
                    arrayList.add((C1722pk) ((AbstractC2303xn) m7356e0.mo1259f()));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: L */
    public static void m3124L(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* renamed from: O */
    public static void m3125O(StringBuilder sb, int i, String str, C1937tk c1937tk, String str2) {
        if (c1937tk == null) {
            return;
        }
        m3124L(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (c1937tk.m8726T() != 0) {
            m3124L(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : c1937tk.m8724Q()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (c1937tk.m8721J() != 0) {
            m3124L(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : c1937tk.m8719E()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (c1937tk.m8731Z() != 0) {
            m3124L(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (C1558mk c1558mk : c1937tk.m8729X()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(c1558mk.m6438H() ? Integer.valueOf(c1558mk.m6439I()) : null);
                sb.append(":");
                sb.append(c1558mk.m6440J() ? Long.valueOf(c1558mk.m6441L()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (c1937tk.m8733b0() != 0) {
            m3124L(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (C2016uk c2016uk : c1937tk.m8732a0()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(c2016uk.m8909H() ? Integer.valueOf(c2016uk.m8910I()) : null);
                sb.append(": [");
                Iterator<Long> it = c2016uk.m8912L().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        m3124L(sb, 3);
        sb.append("}\n");
    }

    /* renamed from: P */
    public static void m3126P(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        m3124L(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    @WorkerThread
    /* renamed from: S */
    public static boolean m3127S(zzaq zzaqVar, zzm zzmVar) {
        C0813ca.m2729k(zzaqVar);
        C0813ca.m2729k(zzmVar);
        return (TextUtils.isEmpty(zzmVar.f998P) && TextUtils.isEmpty(zzmVar.f1014f0)) ? false : true;
    }

    /* renamed from: T */
    public static boolean m3128T(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* renamed from: U */
    public static boolean m3129U(List<Long> list, int i) {
        if (i < (list.size() << 6)) {
            return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
        }
        return false;
    }

    /* renamed from: w */
    public static int m3130w(C1821rk.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i = 0; i < aVar.m8108X(); i++) {
            if (str.equals(aVar.m8106V(i).m9273S())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: z */
    public static C1722pk m3131z(C1610nk c1610nk, String str) {
        for (C1722pk c1722pk : c1610nk.m6700E()) {
            if (c1722pk.m7363P().equals(str)) {
                return c1722pk;
            }
        }
        return null;
    }

    /* renamed from: B */
    public final String m3132B(C2429zj c2429zj) {
        if (c2429zj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (c2429zj.m10469I()) {
            m3126P(sb, 0, "filter_id", Integer.valueOf(c2429zj.m10470J()));
        }
        m3126P(sb, 0, "event_name", m7587l().m7809x(c2429zj.m10471L()));
        String m3121E = m3121E(c2429zj.m10476Q(), c2429zj.m10477R(), c2429zj.m10479T());
        if (!m3121E.isEmpty()) {
            m3126P(sb, 0, "filter_type", m3121E);
        }
        if (c2429zj.m10474O()) {
            m3140N(sb, 1, "event_count_filter", c2429zj.m10475P());
        }
        if (c2429zj.m10473N() > 0) {
            sb.append("  filters {\n");
            Iterator<C0718ak> it = c2429zj.m10472M().iterator();
            while (it.hasNext()) {
                m3139M(sb, 2, it.next());
            }
        }
        m3124L(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* renamed from: C */
    public final String m3133C(C0831ck c0831ck) {
        if (c0831ck == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (c0831ck.m2831F()) {
            m3126P(sb, 0, "filter_id", Integer.valueOf(c0831ck.m2832G()));
        }
        m3126P(sb, 0, "property_name", m7587l().m7805B(c0831ck.m2833H()));
        String m3121E = m3121E(c0831ck.m2835J(), c0831ck.m2836L(), c0831ck.m2838N());
        if (!m3121E.isEmpty()) {
            m3126P(sb, 0, "filter_type", m3121E);
        }
        m3139M(sb, 1, c0831ck.m2834I());
        sb.append("}\n");
        return sb.toString();
    }

    /* renamed from: D */
    public final String m3134D(C1766qk c1766qk) {
        if (c1766qk == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (C1821rk c1821rk : c1766qk.m7725E()) {
            if (c1821rk != null) {
                m3124L(sb, 1);
                sb.append("bundle {\n");
                if (c1821rk.m8016X()) {
                    m3126P(sb, 1, "protocol_version", Integer.valueOf(c1821rk.m8074y0()));
                }
                m3126P(sb, 1, "platform", c1821rk.m7971B2());
                if (c1821rk.m7993K2()) {
                    m3126P(sb, 1, "gmp_version", Long.valueOf(c1821rk.m8018Y()));
                }
                if (c1821rk.m8020Z()) {
                    m3126P(sb, 1, "uploading_gmp_version", Long.valueOf(c1821rk.m8022a0()));
                }
                if (c1821rk.m7992K0()) {
                    m3126P(sb, 1, "dynamite_version", Long.valueOf(c1821rk.m7994L0()));
                }
                if (c1821rk.m8062s0()) {
                    m3126P(sb, 1, "config_version", Long.valueOf(c1821rk.m8065t0()));
                }
                m3126P(sb, 1, "gmp_app_id", c1821rk.m8045k0());
                m3126P(sb, 1, "admob_app_id", c1821rk.m7990J0());
                m3126P(sb, 1, "app_id", c1821rk.m7989I2());
                m3126P(sb, 1, "app_version", c1821rk.m7991J2());
                if (c1821rk.m8054p0()) {
                    m3126P(sb, 1, "app_version_major", Integer.valueOf(c1821rk.m8056q0()));
                }
                m3126P(sb, 1, "firebase_instance_id", c1821rk.m8051o0());
                if (c1821rk.m8033f0()) {
                    m3126P(sb, 1, "dev_cert_hash", Long.valueOf(c1821rk.m8036g0()));
                }
                m3126P(sb, 1, "app_store", c1821rk.m7987H2());
                if (c1821rk.m7997M1()) {
                    m3126P(sb, 1, "upload_timestamp_millis", Long.valueOf(c1821rk.m7998N1()));
                }
                if (c1821rk.m8019Y1()) {
                    m3126P(sb, 1, "start_timestamp_millis", Long.valueOf(c1821rk.m8021Z1()));
                }
                if (c1821rk.m8044j2()) {
                    m3126P(sb, 1, "end_timestamp_millis", Long.valueOf(c1821rk.m8046k2()));
                }
                if (c1821rk.m8061r2()) {
                    m3126P(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(c1821rk.m8064s2()));
                }
                if (c1821rk.m8073x2()) {
                    m3126P(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(c1821rk.m8076y2()));
                }
                m3126P(sb, 1, "app_instance_id", c1821rk.m8030e0());
                m3126P(sb, 1, "resettable_device_id", c1821rk.m8024b0());
                m3126P(sb, 1, "device_id", c1821rk.m8059r0());
                m3126P(sb, 1, "ds_id", c1821rk.m8069w0());
                if (c1821rk.m8026c0()) {
                    m3126P(sb, 1, "limited_ad_tracking", Boolean.valueOf(c1821rk.m8028d0()));
                }
                m3126P(sb, 1, "os_version", c1821rk.m7972C2());
                m3126P(sb, 1, "device_model", c1821rk.m7974D2());
                m3126P(sb, 1, "user_default_language", c1821rk.m7976E2());
                if (c1821rk.m7979F2()) {
                    m3126P(sb, 1, "time_zone_offset_minutes", Integer.valueOf(c1821rk.m7983G2()));
                }
                if (c1821rk.m8038h0()) {
                    m3126P(sb, 1, "bundle_sequential_index", Integer.valueOf(c1821rk.m8040i0()));
                }
                if (c1821rk.m8047l0()) {
                    m3126P(sb, 1, "service_upload", Boolean.valueOf(c1821rk.m8049m0()));
                }
                m3126P(sb, 1, "health_monitor", c1821rk.m8043j0());
                if (!m7590o().m2630u(C1735pu.f5807O0) && c1821rk.m8066u0() && c1821rk.m8068v0() != 0) {
                    m3126P(sb, 1, "android_id", Long.valueOf(c1821rk.m8068v0()));
                }
                if (c1821rk.m8071x0()) {
                    m3126P(sb, 1, "retry_counter", Integer.valueOf(c1821rk.m7988I0()));
                }
                List<C2175vk> m8057q1 = c1821rk.m8057q1();
                if (m8057q1 != null) {
                    for (C2175vk c2175vk : m8057q1) {
                        if (c2175vk != null) {
                            m3124L(sb, 2);
                            sb.append("user_property {\n");
                            m3126P(sb, 2, "set_timestamp_millis", c2175vk.m9269L() ? Long.valueOf(c2175vk.m9270M()) : null);
                            m3126P(sb, 2, "name", m7587l().m7805B(c2175vk.m9273S()));
                            m3126P(sb, 2, "string_value", c2175vk.m9275V());
                            m3126P(sb, 2, "int_value", c2175vk.m9276W() ? Long.valueOf(c2175vk.m9277X()) : null);
                            m3126P(sb, 2, "double_value", c2175vk.m9278Y() ? Double.valueOf(c2175vk.m9279Z()) : null);
                            m3124L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C1512lk> m8050n0 = c1821rk.m8050n0();
                String m7989I2 = c1821rk.m7989I2();
                if (m8050n0 != null) {
                    for (C1512lk c1512lk : m8050n0) {
                        if (c1512lk != null) {
                            m3124L(sb, 2);
                            sb.append("audience_membership {\n");
                            if (c1512lk.m6237J()) {
                                m3126P(sb, 2, "audience_id", Integer.valueOf(c1512lk.m6238L()));
                            }
                            if (c1512lk.m6243R()) {
                                m3126P(sb, 2, "new_audience", Boolean.valueOf(c1512lk.m6244S()));
                            }
                            m3125O(sb, 2, "current_data", c1512lk.m6240O(), m7989I2);
                            if (c1512lk.m6241P()) {
                                m3125O(sb, 2, "previous_data", c1512lk.m6242Q(), m7989I2);
                            }
                            m3124L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C1610nk> m8013V0 = c1821rk.m8013V0();
                if (m8013V0 != null) {
                    for (C1610nk c1610nk : m8013V0) {
                        if (c1610nk != null) {
                            m3124L(sb, 2);
                            sb.append("event {\n");
                            m3126P(sb, 2, "name", m7587l().m7809x(c1610nk.m6709W()));
                            if (c1610nk.m6710X()) {
                                m3126P(sb, 2, "timestamp_millis", Long.valueOf(c1610nk.m6711Y()));
                            }
                            if (c1610nk.m6712Z()) {
                                m3126P(sb, 2, "previous_timestamp_millis", Long.valueOf(c1610nk.m6713a0()));
                            }
                            if (c1610nk.m6714b0()) {
                                m3126P(sb, 2, "count", Integer.valueOf(c1610nk.m6715c0()));
                            }
                            if (c1610nk.m6706S() != 0) {
                                m3141Q(sb, 2, c1610nk.m6700E());
                            }
                            m3124L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                m3124L(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* renamed from: G */
    public final List<Long> m3135G(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                mo1484j().m8525K().m9084b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    mo1484j().m8525K().m9085c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* renamed from: I */
    public final void m3136I(C1610nk.a aVar, String str, Object obj) {
        List<C1722pk> m6722E = aVar.m6722E();
        int i = 0;
        while (true) {
            if (i >= m6722E.size()) {
                i = -1;
                break;
            } else if (str.equals(m6722E.get(i).m7363P())) {
                break;
            } else {
                i++;
            }
        }
        C1722pk.a m7356e0 = C1722pk.m7356e0();
        m7356e0.m7380B(str);
        if (obj instanceof Long) {
            m7356e0.m7388y(((Long) obj).longValue());
        } else if (obj instanceof String) {
            m7356e0.m7382D((String) obj);
        } else if (obj instanceof Double) {
            m7356e0.m7387w(((Double) obj).doubleValue());
        } else if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5795I0) && (obj instanceof Bundle[])) {
            m7356e0.m7379A(m3123H((Bundle[]) obj));
        }
        if (i >= 0) {
            aVar.m6730v(i, m7356e0);
        } else {
            aVar.m6733z(m7356e0);
        }
    }

    /* renamed from: J */
    public final void m3137J(C1722pk.a aVar, Object obj) {
        C0813ca.m2729k(obj);
        aVar.m7386v();
        aVar.m7381C();
        aVar.m7383E();
        aVar.m7385G();
        if (obj instanceof String) {
            aVar.m7382D((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.m7388y(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.m7387w(((Double) obj).doubleValue());
        } else if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5795I0) && (obj instanceof Bundle[])) {
            aVar.m7379A(m3123H((Bundle[]) obj));
        } else {
            mo1484j().m8522H().m9084b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* renamed from: K */
    public final void m3138K(C2175vk.a aVar, Object obj) {
        C0813ca.m2729k(obj);
        aVar.m9287v();
        aVar.m9283A();
        aVar.m9286D();
        if (obj instanceof String) {
            aVar.m9285C((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.m9284B(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.m9288w(((Double) obj).doubleValue());
        } else {
            mo1484j().m8522H().m9084b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* renamed from: M */
    public final void m3139M(StringBuilder sb, int i, C0718ak c0718ak) {
        if (c0718ak == null) {
            return;
        }
        m3124L(sb, i);
        sb.append("filter {\n");
        if (c0718ak.m2128J()) {
            m3126P(sb, i, "complement", Boolean.valueOf(c0718ak.m2129L()));
        }
        if (c0718ak.m2130M()) {
            m3126P(sb, i, "param_name", m7587l().m7804A(c0718ak.m2131N()));
        }
        if (c0718ak.m2124F()) {
            int i2 = i + 1;
            C0886dk m2125G = c0718ak.m2125G();
            if (m2125G != null) {
                m3124L(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (m2125G.m3235D()) {
                    m3126P(sb, i2, "match_type", m2125G.m3236E().name());
                }
                if (m2125G.m3237F()) {
                    m3126P(sb, i2, "expression", m2125G.m3238G());
                }
                if (m2125G.m3239H()) {
                    m3126P(sb, i2, "case_sensitive", Boolean.valueOf(m2125G.m3240I()));
                }
                if (m2125G.m3242L() > 0) {
                    m3124L(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str : m2125G.m3241J()) {
                        m3124L(sb, i2 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                m3124L(sb, i2);
                sb.append("}\n");
            }
        }
        if (c0718ak.m2126H()) {
            m3140N(sb, i + 1, "number_filter", c0718ak.m2127I());
        }
        m3124L(sb, i);
        sb.append("}\n");
    }

    /* renamed from: N */
    public final void m3140N(StringBuilder sb, int i, String str, C0781bk c0781bk) {
        if (c0781bk == null) {
            return;
        }
        m3124L(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (c0781bk.m2534D()) {
            m3126P(sb, i, "comparison_type", c0781bk.m2535E().name());
        }
        if (c0781bk.m2536F()) {
            m3126P(sb, i, "match_as_float", Boolean.valueOf(c0781bk.m2537G()));
        }
        if (c0781bk.m2538H()) {
            m3126P(sb, i, "comparison_value", c0781bk.m2539I());
        }
        if (c0781bk.m2540J()) {
            m3126P(sb, i, "min_comparison_value", c0781bk.m2541L());
        }
        if (c0781bk.m2542M()) {
            m3126P(sb, i, "max_comparison_value", c0781bk.m2543N());
        }
        m3124L(sb, i);
        sb.append("}\n");
    }

    /* renamed from: Q */
    public final void m3141Q(StringBuilder sb, int i, List<C1722pk> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (C1722pk c1722pk : list) {
            if (c1722pk != null) {
                m3124L(sb, i2);
                sb.append("param {\n");
                if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5791G0)) {
                    m3126P(sb, i2, "name", c1722pk.m7362O() ? m7587l().m7804A(c1722pk.m7363P()) : null);
                    m3126P(sb, i2, "string_value", c1722pk.m7365U() ? c1722pk.m7366V() : null);
                    m3126P(sb, i2, "int_value", c1722pk.m7368Y() ? Long.valueOf(c1722pk.m7369Z()) : null);
                    m3126P(sb, i2, "double_value", c1722pk.m7370a0() ? Double.valueOf(c1722pk.m7371b0()) : null);
                    if (c1722pk.m7373d0() > 0) {
                        m3141Q(sb, i2, c1722pk.m7372c0());
                    }
                } else {
                    m3126P(sb, i2, "name", m7587l().m7804A(c1722pk.m7363P()));
                    m3126P(sb, i2, "string_value", c1722pk.m7366V());
                    m3126P(sb, i2, "int_value", c1722pk.m7368Y() ? Long.valueOf(c1722pk.m7369Z()) : null);
                    m3126P(sb, i2, "double_value", c1722pk.m7370a0() ? Double.valueOf(c1722pk.m7371b0()) : null);
                }
                m3124L(sb, i2);
                sb.append("}\n");
            }
        }
    }

    /* renamed from: R */
    public final boolean m3142R(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo1483i().mo1177a() - j) > j2;
    }

    /* renamed from: V */
    public final Object m3143V(C1610nk c1610nk, String str) {
        C1722pk m3131z = m3131z(c1610nk, str);
        if (m3131z == null) {
            return null;
        }
        if (m3131z.m7365U()) {
            return m3131z.m7366V();
        }
        if (m3131z.m7368Y()) {
            return Long.valueOf(m3131z.m7369Z());
        }
        if (m3131z.m7370a0()) {
            return Double.valueOf(m3131z.m7371b0());
        }
        if (!C1069gr.m4250b() || !m7590o().m2630u(C1735pu.f5795I0) || m3131z.m7373d0() <= 0) {
            return null;
        }
        List<C1722pk> m7372c0 = m3131z.m7372c0();
        ArrayList arrayList = new ArrayList();
        for (C1722pk c1722pk : m7372c0) {
            if (c1722pk != null) {
                Bundle bundle = new Bundle();
                for (C1722pk c1722pk2 : c1722pk.m7372c0()) {
                    if (c1722pk2.m7365U()) {
                        bundle.putString(c1722pk2.m7363P(), c1722pk2.m7366V());
                    } else if (c1722pk2.m7368Y()) {
                        bundle.putLong(c1722pk2.m7363P(), c1722pk2.m7369Z());
                    } else if (c1722pk2.m7370a0()) {
                        bundle.putDouble(c1722pk2.m7363P(), c1722pk2.m7371b0());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* renamed from: W */
    public final byte[] m3144W(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            mo1484j().m8522H().m9084b("Failed to ungzip content", e);
            throw e;
        }
    }

    /* renamed from: X */
    public final byte[] m3145X(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo1484j().m8522H().m9084b("Failed to gzip content", e);
            throw e;
        }
    }

    @Nullable
    /* renamed from: Y */
    public final List<Integer> m3146Y() {
        Map<String, String> m7501c = C1735pu.m7501c(this.f7863b.mo1482h());
        if (m7501c == null || m7501c.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = C1735pu.f5810Q.m6320a(null).intValue();
        for (Map.Entry<String, String> entry : m7501c.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            mo1484j().m8525K().m9084b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    mo1484j().m8525K().m9084b("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.sonelli.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        return false;
    }

    @WorkerThread
    /* renamed from: x */
    public final long m3147x(byte[] bArr) {
        C0813ca.m2729k(bArr);
        m7588m().mo7585d();
        MessageDigest m3988I0 = g40.m3988I0();
        if (m3988I0 != null) {
            return g40.m3983A(m3988I0.digest(bArr));
        }
        mo1484j().m8522H().m9083a("Failed to get MD5");
        return 0L;
    }

    /* renamed from: y */
    public final <T extends Parcelable> T m3148y(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (C1032ga.a unused) {
            mo1484j().m8522H().m9083a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }
}
