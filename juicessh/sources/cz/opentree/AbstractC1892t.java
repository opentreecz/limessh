package cz.opentree;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.C1581n;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.t */
/* loaded from: classes.dex */
public abstract class AbstractC1892t {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.t$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public abstract a mo6600a(@Nullable b bVar);

        @NonNull
        /* renamed from: b */
        public abstract a mo6601b(@Nullable c cVar);

        @NonNull
        /* renamed from: c */
        public abstract AbstractC1892t mo6602c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.t$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: P */
        public static final b f6627P;

        /* renamed from: Q */
        public static final b f6628Q;

        /* renamed from: R */
        public static final b f6629R;

        /* renamed from: S */
        public static final b f6630S;

        /* renamed from: T */
        public static final b f6631T;

        /* renamed from: U */
        public static final b f6632U;

        /* renamed from: V */
        public static final b f6633V;

        /* renamed from: W */
        public static final b f6634W;

        /* renamed from: X */
        public static final b f6635X;

        /* renamed from: Y */
        public static final b f6636Y;

        /* renamed from: Z */
        public static final b f6637Z;

        /* renamed from: a0 */
        public static final b f6638a0;

        /* renamed from: b0 */
        public static final b f6639b0;

        /* renamed from: c0 */
        public static final b f6640c0;

        /* renamed from: d0 */
        public static final b f6641d0;

        /* renamed from: e0 */
        public static final b f6642e0;

        /* renamed from: f0 */
        public static final b f6643f0;

        /* renamed from: g0 */
        public static final b f6644g0;

        /* renamed from: h0 */
        public static final b f6645h0;

        /* renamed from: i0 */
        public static final b f6646i0;

        /* renamed from: j0 */
        public static final b f6647j0;

        /* renamed from: k0 */
        public static final SparseArray<b> f6648k0;

        /* renamed from: O */
        public final int f6649O;

        static {
            b bVar = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            f6627P = bVar;
            b bVar2 = new b("GPRS", 1, 1);
            f6628Q = bVar2;
            b bVar3 = new b("EDGE", 2, 2);
            f6629R = bVar3;
            b bVar4 = new b("UMTS", 3, 3);
            f6630S = bVar4;
            b bVar5 = new b("CDMA", 4, 4);
            f6631T = bVar5;
            b bVar6 = new b("EVDO_0", 5, 5);
            f6632U = bVar6;
            b bVar7 = new b("EVDO_A", 6, 6);
            f6633V = bVar7;
            b bVar8 = new b("RTT", 7, 7);
            f6634W = bVar8;
            b bVar9 = new b("HSDPA", 8, 8);
            f6635X = bVar9;
            b bVar10 = new b("HSUPA", 9, 9);
            f6636Y = bVar10;
            b bVar11 = new b("HSPA", 10, 10);
            f6637Z = bVar11;
            b bVar12 = new b("IDEN", 11, 11);
            f6638a0 = bVar12;
            b bVar13 = new b("EVDO_B", 12, 12);
            f6639b0 = bVar13;
            b bVar14 = new b("LTE", 13, 13);
            f6640c0 = bVar14;
            b bVar15 = new b("EHRPD", 14, 14);
            f6641d0 = bVar15;
            b bVar16 = new b("HSPAP", 15, 15);
            f6642e0 = bVar16;
            b bVar17 = new b("GSM", 16, 16);
            f6643f0 = bVar17;
            b bVar18 = new b("TD_SCDMA", 17, 17);
            f6644g0 = bVar18;
            b bVar19 = new b("IWLAN", 18, 18);
            f6645h0 = bVar19;
            b bVar20 = new b("LTE_CA", 19, 19);
            f6646i0 = bVar20;
            f6647j0 = new b("COMBINED", 20, 100);
            SparseArray<b> sparseArray = new SparseArray<>();
            f6648k0 = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(1, bVar2);
            sparseArray.put(2, bVar3);
            sparseArray.put(3, bVar4);
            sparseArray.put(4, bVar5);
            sparseArray.put(5, bVar6);
            sparseArray.put(6, bVar7);
            sparseArray.put(7, bVar8);
            sparseArray.put(8, bVar9);
            sparseArray.put(9, bVar10);
            sparseArray.put(10, bVar11);
            sparseArray.put(11, bVar12);
            sparseArray.put(12, bVar13);
            sparseArray.put(13, bVar14);
            sparseArray.put(14, bVar15);
            sparseArray.put(15, bVar16);
            sparseArray.put(16, bVar17);
            sparseArray.put(17, bVar18);
            sparseArray.put(18, bVar19);
            sparseArray.put(19, bVar20);
        }

        public b(String str, int i, int i2) {
            this.f6649O = i2;
        }

        @Nullable
        /* renamed from: f */
        public static b m8556f(int i) {
            return f6648k0.get(i);
        }

        /* renamed from: a */
        public int m8557a() {
            return this.f6649O;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.t$c */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: P */
        public static final c f6650P;

        /* renamed from: Q */
        public static final c f6651Q;

        /* renamed from: R */
        public static final c f6652R;

        /* renamed from: S */
        public static final c f6653S;

        /* renamed from: T */
        public static final c f6654T;

        /* renamed from: U */
        public static final c f6655U;

        /* renamed from: V */
        public static final c f6656V;

        /* renamed from: W */
        public static final c f6657W;

        /* renamed from: X */
        public static final c f6658X;

        /* renamed from: Y */
        public static final c f6659Y;

        /* renamed from: Z */
        public static final c f6660Z;

        /* renamed from: a0 */
        public static final c f6661a0;

        /* renamed from: b0 */
        public static final c f6662b0;

        /* renamed from: c0 */
        public static final c f6663c0;

        /* renamed from: d0 */
        public static final c f6664d0;

        /* renamed from: e0 */
        public static final c f6665e0;

        /* renamed from: f0 */
        public static final c f6666f0;

        /* renamed from: g0 */
        public static final c f6667g0;

        /* renamed from: h0 */
        public static final c f6668h0;

        /* renamed from: i0 */
        public static final SparseArray<c> f6669i0;

        /* renamed from: O */
        public final int f6670O;

        static {
            c cVar = new c("MOBILE", 0, 0);
            f6650P = cVar;
            c cVar2 = new c("WIFI", 1, 1);
            f6651Q = cVar2;
            c cVar3 = new c("MOBILE_MMS", 2, 2);
            f6652R = cVar3;
            c cVar4 = new c("MOBILE_SUPL", 3, 3);
            f6653S = cVar4;
            c cVar5 = new c("MOBILE_DUN", 4, 4);
            f6654T = cVar5;
            c cVar6 = new c("MOBILE_HIPRI", 5, 5);
            f6655U = cVar6;
            c cVar7 = new c("WIMAX", 6, 6);
            f6656V = cVar7;
            c cVar8 = new c("BLUETOOTH", 7, 7);
            f6657W = cVar8;
            c cVar9 = new c("DUMMY", 8, 8);
            f6658X = cVar9;
            c cVar10 = new c("ETHERNET", 9, 9);
            f6659Y = cVar10;
            c cVar11 = new c("MOBILE_FOTA", 10, 10);
            f6660Z = cVar11;
            c cVar12 = new c("MOBILE_IMS", 11, 11);
            f6661a0 = cVar12;
            c cVar13 = new c("MOBILE_CBS", 12, 12);
            f6662b0 = cVar13;
            c cVar14 = new c("WIFI_P2P", 13, 13);
            f6663c0 = cVar14;
            c cVar15 = new c("MOBILE_IA", 14, 14);
            f6664d0 = cVar15;
            c cVar16 = new c("MOBILE_EMERGENCY", 15, 15);
            f6665e0 = cVar16;
            c cVar17 = new c("PROXY", 16, 16);
            f6666f0 = cVar17;
            c cVar18 = new c("VPN", 17, 17);
            f6667g0 = cVar18;
            c cVar19 = new c("NONE", 18, -1);
            f6668h0 = cVar19;
            SparseArray<c> sparseArray = new SparseArray<>();
            f6669i0 = sparseArray;
            sparseArray.put(0, cVar);
            sparseArray.put(1, cVar2);
            sparseArray.put(2, cVar3);
            sparseArray.put(3, cVar4);
            sparseArray.put(4, cVar5);
            sparseArray.put(5, cVar6);
            sparseArray.put(6, cVar7);
            sparseArray.put(7, cVar8);
            sparseArray.put(8, cVar9);
            sparseArray.put(9, cVar10);
            sparseArray.put(10, cVar11);
            sparseArray.put(11, cVar12);
            sparseArray.put(12, cVar13);
            sparseArray.put(13, cVar14);
            sparseArray.put(14, cVar15);
            sparseArray.put(15, cVar16);
            sparseArray.put(16, cVar17);
            sparseArray.put(17, cVar18);
            sparseArray.put(-1, cVar19);
        }

        public c(String str, int i, int i2) {
            this.f6670O = i2;
        }

        @Nullable
        /* renamed from: f */
        public static c m8558f(int i) {
            return f6669i0.get(i);
        }

        /* renamed from: a */
        public int m8559a() {
            return this.f6670O;
        }
    }

    @NonNull
    /* renamed from: a */
    public static a m8555a() {
        return new C1581n.b();
    }

    @Nullable
    /* renamed from: b */
    public abstract b mo6598b();

    @Nullable
    /* renamed from: c */
    public abstract c mo6599c();
}
