package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ku */
/* loaded from: classes.dex */
public final class C1473ku {

    /* renamed from: a */
    public final String f4648a;

    /* renamed from: b */
    public final String f4649b;

    /* renamed from: c */
    public final long f4650c;

    /* renamed from: d */
    public final long f4651d;

    /* renamed from: e */
    public final long f4652e;

    /* renamed from: f */
    public final long f4653f;

    /* renamed from: g */
    public final long f4654g;

    /* renamed from: h */
    public final Long f4655h;

    /* renamed from: i */
    public final Long f4656i;

    /* renamed from: j */
    public final Long f4657j;

    /* renamed from: k */
    public final Boolean f4658k;

    public C1473ku(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        C0813ca.m2719a(j >= 0);
        C0813ca.m2719a(j2 >= 0);
        C0813ca.m2719a(j3 >= 0);
        C0813ca.m2719a(j5 >= 0);
        this.f4648a = str;
        this.f4649b = str2;
        this.f4650c = j;
        this.f4651d = j2;
        this.f4652e = j3;
        this.f4653f = j4;
        this.f4654g = j5;
        this.f4655h = l;
        this.f4656i = l2;
        this.f4657j = l3;
        this.f4658k = bool;
    }

    public C1473ku(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j3, 0L, null, null, null, null);
    }

    /* renamed from: a */
    public final C1473ku m5995a(long j) {
        return new C1473ku(this.f4648a, this.f4649b, this.f4650c, this.f4651d, this.f4652e, j, this.f4654g, this.f4655h, this.f4656i, this.f4657j, this.f4658k);
    }

    /* renamed from: b */
    public final C1473ku m5996b(long j, long j2) {
        return new C1473ku(this.f4648a, this.f4649b, this.f4650c, this.f4651d, this.f4652e, this.f4653f, j, Long.valueOf(j2), this.f4656i, this.f4657j, this.f4658k);
    }

    /* renamed from: c */
    public final C1473ku m5997c(Long l, Long l2, Boolean bool) {
        return new C1473ku(this.f4648a, this.f4649b, this.f4650c, this.f4651d, this.f4652e, this.f4653f, this.f4654g, this.f4655h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
