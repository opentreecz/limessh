package cz.opentree;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.co */
/* loaded from: classes.dex */
public class C0839co extends IOException {
    public C0839co(String str) {
        super(str);
    }

    /* renamed from: a */
    public static C0839co m2889a() {
        return new C0839co("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    public static C0839co m2890b() {
        return new C0839co("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    public static C0839co m2891c() {
        return new C0839co("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: d */
    public static C0790bo m2892d() {
        return new C0790bo("Protocol message tag had invalid wire type.");
    }

    /* renamed from: e */
    public static C0839co m2893e() {
        return new C0839co("Failed to parse the message.");
    }

    /* renamed from: f */
    public static C0839co m2894f() {
        return new C0839co("Protocol message had invalid UTF-8.");
    }
}
