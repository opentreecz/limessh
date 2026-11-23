package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.e */
/* loaded from: classes.dex */
public final class C0905e implements EncodedDestination {

    /* renamed from: c */
    public static final String f2306c = C2319y.m9988a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d */
    public static final String f2307d = C2319y.m9988a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* renamed from: e */
    public static final String f2308e = C2319y.m9988a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* renamed from: f */
    public static final Set<C0746b> f2309f = Collections.unmodifiableSet(new HashSet(Arrays.asList(C0746b.m2321b("proto"), C0746b.m2321b("json"))));

    /* renamed from: a */
    @NonNull
    public final String f2310a;

    /* renamed from: b */
    @Nullable
    public final String f2311b;

    public C0905e(@NonNull String str, @Nullable String str2) {
        this.f2310a = str;
        this.f2311b = str2;
    }

    @NonNull
    /* renamed from: c */
    public static C0905e m3345c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C0905e(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    /* renamed from: a */
    public Set<C0746b> mo741a() {
        return f2309f;
    }

    @Nullable
    /* renamed from: b */
    public byte[] m3346b() {
        String str = this.f2311b;
        if (str == null && this.f2310a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f2310a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    /* renamed from: d */
    public String m3347d() {
        return this.f2311b;
    }

    @NonNull
    /* renamed from: e */
    public String m3348e() {
        return this.f2310a;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    @Nullable
    public byte[] getExtras() {
        return m3346b();
    }

    @Override // com.google.android.datatransport.runtime.Destination
    @NonNull
    public String getName() {
        return "cct";
    }
}
