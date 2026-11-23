package cz.opentree;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;
import com.j256.ormlite.field.FieldType;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class g40 extends p00 {

    /* renamed from: g */
    public static final String[] f2823g = {"firebase_", "google_", "ga_"};

    /* renamed from: h */
    public static final String[] f2824h = {"_err"};

    /* renamed from: c */
    public SecureRandom f2825c;

    /* renamed from: d */
    public final AtomicLong f2826d;

    /* renamed from: e */
    public int f2827e;

    /* renamed from: f */
    public Integer f2828f;

    public g40(C2144uz c2144uz) {
        super(c2144uz);
        this.f2828f = null;
        this.f2826d = new AtomicLong(0L);
    }

    /* renamed from: A */
    public static long m3983A(byte[] bArr) {
        C0813ca.m2729k(bArr);
        int i = 0;
        C0813ca.m2732n(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* renamed from: B0 */
    public static boolean m3984B0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* renamed from: E */
    public static Bundle m3985E(List<zzkn> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkn zzknVar : list) {
            String str = zzknVar.f994S;
            if (str != null) {
                bundle.putString(zzknVar.f991P, str);
            } else {
                Long l = zzknVar.f993R;
                if (l != null) {
                    bundle.putLong(zzknVar.f991P, l.longValue());
                } else {
                    Double d = zzknVar.f996U;
                    if (d != null) {
                        bundle.putDouble(zzknVar.f991P, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    /* renamed from: E0 */
    public static boolean m3986E0(String str) {
        for (String str2 : f2824h) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: I */
    public static String m3987I(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* renamed from: I0 */
    public static MessageDigest m3988I0() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* renamed from: K0 */
    public static boolean m3989K0(String str) {
        C0813ca.m2729k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    /* renamed from: L */
    public static void m3990L(Bundle bundle, int i, String str, String str2, Object obj) {
        if (m4004s0(bundle, i)) {
            bundle.putString("_ev", m3987I(str, 40, true));
            if (obj != null) {
                C0813ca.m2729k(bundle);
                if (obj != null) {
                    if ((obj instanceof String) || (obj instanceof CharSequence)) {
                        bundle.putLong("_el", String.valueOf(obj).length());
                    }
                }
            }
        }
    }

    /* renamed from: X */
    public static boolean m3991X(Context context, boolean z) {
        C0813ca.m2729k(context);
        return Build.VERSION.SDK_INT >= 24 ? m4003r0(context, "com.google.android.gms.measurement.AppMeasurementJobService") : m4003r0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* renamed from: Y */
    public static boolean m3992Y(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* renamed from: Z */
    public static boolean m3993Z(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* renamed from: a0 */
    public static boolean m3994a0(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* renamed from: b0 */
    public static boolean m3995b0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* renamed from: c0 */
    public static boolean m3996c0(String str) {
        C0813ca.m2725g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* renamed from: i0 */
    public static boolean m3997i0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    /* renamed from: j0 */
    public static boolean m3998j0(String str, String[] strArr) {
        C0813ca.m2729k(strArr);
        for (String str2 : strArr) {
            if (m4008z0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l0 */
    public static boolean m3999l0(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* renamed from: m0 */
    public static byte[] m4000m0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: p0 */
    public static Bundle m4001p0(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* renamed from: q0 */
    public static ArrayList<Bundle> m4002q0(List<zzy> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzy zzyVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzyVar.f1019O);
            bundle.putString("origin", zzyVar.f1020P);
            bundle.putLong("creation_timestamp", zzyVar.f1022R);
            bundle.putString("name", zzyVar.f1021Q.f991P);
            r00.m7840b(bundle, zzyVar.f1021Q.m1501x());
            bundle.putBoolean("active", zzyVar.f1023S);
            String str = zzyVar.f1024T;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaq zzaqVar = zzyVar.f1025U;
            if (zzaqVar != null) {
                bundle.putString("timed_out_event_name", zzaqVar.f986O);
                zzal zzalVar = zzyVar.f1025U.f987P;
                if (zzalVar != null) {
                    bundle.putBundle("timed_out_event_params", zzalVar.m1457Z());
                }
            }
            bundle.putLong("trigger_timeout", zzyVar.f1026V);
            zzaq zzaqVar2 = zzyVar.f1027W;
            if (zzaqVar2 != null) {
                bundle.putString("triggered_event_name", zzaqVar2.f986O);
                zzal zzalVar2 = zzyVar.f1027W.f987P;
                if (zzalVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzalVar2.m1457Z());
                }
            }
            bundle.putLong("triggered_timestamp", zzyVar.f1021Q.f992Q);
            bundle.putLong("time_to_live", zzyVar.f1028X);
            zzaq zzaqVar3 = zzyVar.f1029Y;
            if (zzaqVar3 != null) {
                bundle.putString("expired_event_name", zzaqVar3.f986O);
                zzal zzalVar3 = zzyVar.f1029Y.f987P;
                if (zzalVar3 != null) {
                    bundle.putBundle("expired_event_params", zzalVar3.m1457Z());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: r0 */
    public static boolean m4003r0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: s0 */
    public static boolean m4004s0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    /* renamed from: v0 */
    public static Bundle[] m4005v0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* renamed from: x */
    public static long m4006x(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* renamed from: z */
    public static long m4007z(zzal zzalVar) {
        long j = 0;
        if (zzalVar == null) {
            return 0L;
        }
        Iterator<String> it = zzalVar.iterator();
        while (it.hasNext()) {
            if (zzalVar.m1456Y(it.next()) instanceof Parcelable[]) {
                j += ((Parcelable[]) r3).length;
            }
        }
        return j;
    }

    /* renamed from: z0 */
    public static boolean m4008z0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    @WorkerThread
    /* renamed from: A0 */
    public final boolean m4009A0(String str) {
        mo7585d();
        if (C2272xc.m9755a(mo1482h()).m9464a(str) == 0) {
            return true;
        }
        mo1484j().m8529O().m9084b("Permission not granted", str);
        return false;
    }

    /* renamed from: B */
    public final Bundle m4010B(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            mo1484j().m8525K().m9084b("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* renamed from: C */
    public final Bundle m4011C(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object m4019H = m4019H(str, bundle.get(str));
                if (m4019H == null) {
                    mo1484j().m8527M().m9084b("Param value can't be null", m7587l().m7804A(str));
                } else {
                    m4027N(bundle2, str, m4019H);
                }
            }
        }
        return bundle2;
    }

    /* renamed from: C0 */
    public final boolean m4012C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String m2620P = m7590o().m2620P();
        mo1480f();
        return m2620P.equals(str);
    }

    /* renamed from: D */
    public final Bundle m4013D(String str, String str2, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        int m4016F0;
        int i;
        Bundle bundle2;
        g40 g40Var = this;
        List<String> list2 = list;
        boolean z3 = C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5799K0);
        boolean m3998j0 = z3 ? m3998j0(str2, t00.f6676c) : z2;
        if (bundle == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle);
        int m2608B = m7590o().m2608B();
        int i2 = 0;
        for (String str3 : m7590o().m2610D(str, C1735pu.f5830d0) ? new TreeSet<>(bundle.keySet()) : bundle.keySet()) {
            if (list2 == null || !list2.contains(str3)) {
                m4016F0 = z ? g40Var.m4016F0(str3) : 0;
                if (m4016F0 == 0) {
                    m4016F0 = g40Var.m4020H0(str3);
                }
            } else {
                m4016F0 = 0;
            }
            if (m4016F0 != 0) {
                m3990L(bundle3, m4016F0, str3, str3, m4016F0 == 3 ? str3 : null);
                bundle3.remove(str3);
                i = m2608B;
                bundle2 = bundle3;
            } else {
                i = m2608B;
                bundle2 = bundle3;
                int m4049w = m4049w(str, str2, str3, bundle.get(str3), bundle3, list, z, m3998j0);
                if (z3 && m4049w == 17) {
                    m3990L(bundle2, m4049w, str3, str3, Boolean.FALSE);
                } else if (m4049w != 0 && !"_ev".equals(str3)) {
                    m3990L(bundle2, m4049w, m4049w == 21 ? str2 : str3, str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (m3996c0(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i);
                        sb.append(" params");
                        mo1484j().m8524J().m9085c(sb.toString(), m7587l().m7809x(str2), m7587l().m7807v(bundle));
                        m4004s0(bundle2, 5);
                        bundle2.remove(str3);
                        i2 = i3;
                        m2608B = i;
                        bundle3 = bundle2;
                        g40Var = this;
                        list2 = list;
                    } else {
                        i2 = i3;
                    }
                }
            }
            m2608B = i;
            bundle3 = bundle2;
            g40Var = this;
            list2 = list;
        }
        return bundle3;
    }

    /* renamed from: D0 */
    public final long m4014D0() {
        long andIncrement;
        long j;
        if (this.f2826d.get() != 0) {
            synchronized (this.f2826d) {
                this.f2826d.compareAndSet(-1L, 1L);
                andIncrement = this.f2826d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f2826d) {
            long nextLong = new Random(System.nanoTime() ^ mo1483i().mo1177a()).nextLong();
            int i = this.f2827e + 1;
            this.f2827e = i;
            j = nextLong + i;
        }
        return j;
    }

    /* renamed from: F */
    public final zzaq m4015F(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m4044n0(str2) != 0) {
            mo1484j().m8522H().m9084b("Invalid conditional property event name", m7587l().m7805B(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        return new zzaq(str2, new zzal(m4011C(m4013D(str, str2, bundle2, C0817cc.m2757b("_o"), false, false))), str3, j);
    }

    /* renamed from: F0 */
    public final int m4016F0(String str) {
        if (!m4040f0("event param", str)) {
            return 3;
        }
        if (m4043k0("event param", null, str)) {
            return !m4039e0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    /* renamed from: G */
    public final Object m4017G(int i, Object obj, boolean z, boolean z2) {
        Bundle m4011C;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return m3987I(String.valueOf(obj), i, z);
        }
        if (!C1069gr.m4250b() || !m7590o().m2630u(C1735pu.f5797J0) || !m7590o().m2630u(C1735pu.f5795I0) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (m4011C = m4011C((Bundle) parcelable)) != null && !m4011C.isEmpty()) {
                arrayList.add(m4011C);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    @WorkerThread
    /* renamed from: G0 */
    public final SecureRandom m4018G0() {
        mo7585d();
        if (this.f2825c == null) {
            this.f2825c = new SecureRandom();
        }
        return this.f2825c;
    }

    /* renamed from: H */
    public final Object m4019H(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m4017G(256, obj, true, true);
        }
        return m4017G(m3984B0(str) ? 256 : 100, obj, false, true);
    }

    /* renamed from: H0 */
    public final int m4020H0(String str) {
        if (!m4046t0("event param", str)) {
            return 3;
        }
        if (m4043k0("event param", null, str)) {
            return !m4039e0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    /* renamed from: J */
    public final URL m4021J(long j, @NonNull String str, @NonNull String str2, long j2) {
        try {
            C0813ca.m2725g(str2);
            C0813ca.m2725g(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(m4022J0())), str2, str, Long.valueOf(j2));
            if (str.equals(m7590o().m2621Q())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            mo1484j().m8522H().m9084b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* renamed from: J0 */
    public final int m4022J0() {
        if (this.f2828f == null) {
            this.f2828f = Integer.valueOf(C2326y6.m10090f().m10092a(mo1482h()) / 1000);
        }
        return this.f2828f.intValue();
    }

    /* renamed from: K */
    public final void m4023K(int i, String str, String str2, int i2) {
        m4036V(null, i, str, str2, i2);
    }

    /* renamed from: L0 */
    public final int m4024L0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(str)) {
            return 256;
        }
        return (m7590o().m2630u(C1735pu.f5850n0) && "_lgclid".equals(str)) ? 100 : 36;
    }

    @WorkerThread
    /* renamed from: M */
    public final void m4025M(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            mo1484j().m8525K().m9084b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    @WorkerThread
    /* renamed from: M0 */
    public final String m4026M0() {
        byte[] bArr = new byte[16];
        m4018G0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* renamed from: N */
    public final void m4027N(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5797J0) && m7590o().m2630u(C1735pu.f5795I0) && (obj instanceof Bundle[])) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            mo1484j().m8527M().m9085c("Not putting event parameter. Invalid value type. name, type", m7587l().m7804A(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    /* renamed from: N0 */
    public final boolean m4028N0() {
        try {
            mo1482h().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: O */
    public final void m4029O(zzs zzsVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning int value to wrapper", e);
        }
    }

    /* renamed from: P */
    public final void m4030P(zzs zzsVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning long value to wrapper", e);
        }
    }

    /* renamed from: Q */
    public final void m4031Q(zzs zzsVar, Bundle bundle) {
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning bundle value to wrapper", e);
        }
    }

    /* renamed from: R */
    public final void m4032R(zzs zzsVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning string value to wrapper", e);
        }
    }

    /* renamed from: S */
    public final void m4033S(zzs zzsVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning bundle list to wrapper", e);
        }
    }

    /* renamed from: T */
    public final void m4034T(zzs zzsVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning boolean value to wrapper", e);
        }
    }

    /* renamed from: U */
    public final void m4035U(zzs zzsVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f5899a.mo1484j().m8525K().m9084b("Error returning byte array to wrapper", e);
        }
    }

    /* renamed from: V */
    public final void m4036V(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m4004s0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        this.f5899a.mo1480f();
        this.f5899a.m9101G().m10009S("auto", "_err", bundle);
    }

    /* renamed from: W */
    public final void m4037W(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z) {
        int m4016F0;
        String str4;
        int m4049w;
        String sb;
        if (bundle == null) {
            return;
        }
        boolean m2630u = m7590o().m2630u(C1735pu.f5799K0);
        int m2608B = m2630u ? 0 : m7590o().m2608B();
        int i = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                m4016F0 = z ? m4016F0(str5) : 0;
                if (m4016F0 == 0) {
                    m4016F0 = m4020H0(str5);
                }
            } else {
                m4016F0 = 0;
            }
            if (m4016F0 != 0) {
                m3990L(bundle, m4016F0, str5, str5, m4016F0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (m3995b0(bundle.get(str5))) {
                    mo1484j().m8527M().m9086d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    m4049w = 22;
                    str4 = str5;
                } else {
                    str4 = str5;
                    m4049w = m4049w(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (m4049w != 0 && !"_ev".equals(str4)) {
                    m3990L(bundle, m4049w, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (m3996c0(str4) && (!m2630u || !m3998j0(str4, s00.f6314d))) {
                    int i2 = i + 1;
                    if (i2 > m2608B) {
                        if (m2630u) {
                            sb = "Item cannot contain custom parameters";
                        } else {
                            StringBuilder sb2 = new StringBuilder(63);
                            sb2.append("Child bundles can't contain more than ");
                            sb2.append(m2608B);
                            sb2.append(" custom params");
                            sb = sb2.toString();
                        }
                        mo1484j().m8524J().m9085c(sb, m7587l().m7809x(str2), m7587l().m7807v(bundle));
                        m4004s0(bundle, m2630u ? 23 : 5);
                        bundle.remove(str4);
                    }
                    i = i2;
                }
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: d0 */
    public final boolean m4038d0(String str, double d) {
        try {
            SharedPreferences.Editor edit = mo1482h().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (Exception e) {
            mo1484j().m8522H().m9084b("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    /* renamed from: e0 */
    public final boolean m4039e0(String str, int i, String str2) {
        if (str2 == null) {
            mo1484j().m8524J().m9084b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        mo1484j().m8524J().m9086d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* renamed from: f0 */
    public final boolean m4040f0(String str, String str2) {
        if (str2 == null) {
            mo1484j().m8524J().m9084b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo1484j().m8524J().m9084b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            mo1484j().m8524J().m9085c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                mo1484j().m8524J().m9085c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* renamed from: g0 */
    public final boolean m4041g0(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                mo1484j().m8527M().m9086d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* renamed from: h0 */
    public final boolean m4042h0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (m3989K0(str)) {
                return true;
            }
            if (this.f5899a.m9105K()) {
                mo1484j().m8524J().m9084b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C1889sy.m8516y(str));
            }
            return false;
        }
        if (C1011fs.m3874b() && m7590o().m2630u(C1735pu.f5856q0) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f5899a.m9105K()) {
                mo1484j().m8524J().m9083a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (m3989K0(str2)) {
            return true;
        }
        mo1484j().m8524J().m9084b("Invalid admob_app_id. Analytics disabled.", C1889sy.m8516y(str2));
        return false;
    }

    /* renamed from: k0 */
    public final boolean m4043k0(String str, String[] strArr, String str2) {
        boolean z;
        if (str2 == null) {
            mo1484j().m8524J().m9084b("Name is required and can't be null. Type", str);
            return false;
        }
        C0813ca.m2729k(str2);
        String[] strArr2 = f2823g;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            mo1484j().m8524J().m9085c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !m3998j0(str2, strArr)) {
            return true;
        }
        mo1484j().m8524J().m9085c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* renamed from: n0 */
    public final int m4044n0(String str) {
        if (!m4046t0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (m4043k0(NotificationCompat.CATEGORY_EVENT, t00.f6674a, str)) {
            return !m4039e0(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
        }
        return 13;
    }

    /* renamed from: o0 */
    public final int m4045o0(String str, Object obj) {
        return "_ldl".equals(str) ? m4041g0("user property referrer", str, m4024L0(str), obj) : m4041g0("user property", str, m4024L0(str), obj) ? 0 : 7;
    }

    @Override // cz.opentree.p00
    @WorkerThread
    /* renamed from: p */
    public final void mo3596p() {
        mo7585d();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                mo1484j().m8525K().m9083a("Utils falling back to Random for random id");
            }
        }
        this.f2826d.set(nextLong);
    }

    @Override // cz.opentree.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        return true;
    }

    /* renamed from: t0 */
    public final boolean m4046t0(String str, String str2) {
        if (str2 == null) {
            mo1484j().m8524J().m9084b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo1484j().m8524J().m9084b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            mo1484j().m8524J().m9085c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                mo1484j().m8524J().m9085c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* renamed from: u0 */
    public final boolean m4047u0(String str, String str2, int i, Object obj) {
        int size;
        if (!(obj instanceof Parcelable[])) {
            if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            return true;
        }
        size = ((Parcelable[]) obj).length;
        if (size > i) {
            mo1484j().m8527M().m9086d("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(size));
            return false;
        }
        return true;
    }

    /* renamed from: v */
    public final int m4048v(int i) {
        return C2326y6.m10090f().mo9713h(mo1482h(), C0810c7.f1875a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m4049w(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, android.os.Bundle r22, @androidx.annotation.Nullable java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.g40.m4049w(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* renamed from: w0 */
    public final int m4050w0(String str) {
        if (!m4046t0("user property", str)) {
            return 6;
        }
        if (m4043k0("user property", u00.f6880a, str)) {
            return !m4039e0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    /* renamed from: x0 */
    public final Object m4051x0(String str, Object obj) {
        return "_ldl".equals(str) ? m4017G(m4024L0(str), obj, true, false) : m4017G(m4024L0(str), obj, false, false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0065 -> B:7:0x0072). Please report as a decompilation issue!!! */
    @WorkerThread
    /* renamed from: y */
    public final long m4052y(Context context, String str) {
        mo7585d();
        C0813ca.m2729k(context);
        C0813ca.m2725g(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest m3988I0 = m3988I0();
        long j = -1;
        if (m3988I0 == null) {
            mo1484j().m8522H().m9083a("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e) {
                    mo1484j().m8522H().m9084b("Package name not found", e);
                }
                if (!m4053y0(context, str)) {
                    Signature[] signatureArr = C2272xc.m9755a(context).m9468e(mo1482h().getPackageName(), 64).signatures;
                    if (signatureArr == null || signatureArr.length <= 0) {
                        mo1484j().m8525K().m9083a("Could not get signatures");
                    } else {
                        j = m3983A(m3988I0.digest(signatureArr[0].toByteArray()));
                    }
                }
            }
            j = 0;
        }
        return j;
    }

    /* renamed from: y0 */
    public final boolean m4053y0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo m9468e = C2272xc.m9755a(context).m9468e(str, 64);
            if (m9468e == null || (signatureArr = m9468e.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            mo1484j().m8522H().m9084b("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            mo1484j().m8522H().m9084b("Error obtaining certificate", e2);
            return true;
        }
    }
}
