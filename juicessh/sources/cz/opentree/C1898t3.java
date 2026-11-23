package cz.opentree;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import com.google.android.gms.analytics.GoogleAnalytics;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: cz.opentree.t3 */
/* loaded from: classes.dex */
public class C1898t3 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler f6700a;

    /* renamed from: b */
    public final C2323y3 f6701b;

    /* renamed from: c */
    public final Context f6702c;

    /* renamed from: d */
    public ExceptionParser f6703d;

    /* renamed from: e */
    public GoogleAnalytics f6704e;

    public C1898t3(C2323y3 c2323y3, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        Objects.requireNonNull(c2323y3, "tracker cannot be null");
        Objects.requireNonNull(context, "context cannot be null");
        this.f6700a = uncaughtExceptionHandler;
        this.f6701b = c2323y3;
        this.f6703d = new C2256x3(context, new ArrayList());
        this.f6702c = context.getApplicationContext();
        String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
        C1212jh.m5111b(valueOf.length() != 0 ? "ExceptionReporter created, original handler is ".concat(valueOf) : new String("ExceptionReporter created, original handler is "));
    }

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler m8586a() {
        return this.f6700a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        if (this.f6703d != null) {
            str = this.f6703d.mo812a(thread != null ? thread.getName() : null, th);
        } else {
            str = "UncaughtException";
        }
        String valueOf = String.valueOf(str);
        C1212jh.m5111b(valueOf.length() != 0 ? "Reporting uncaught exception: ".concat(valueOf) : new String("Reporting uncaught exception: "));
        C2323y3 c2323y3 = this.f6701b;
        C2151v3 c2151v3 = new C2151v3();
        c2151v3.m9158c(str);
        c2151v3.m9159d(true);
        c2323y3.m10072I0(c2151v3.m9401a());
        if (this.f6704e == null) {
            this.f6704e = GoogleAnalytics.m813k(this.f6702c);
        }
        GoogleAnalytics googleAnalytics = this.f6704e;
        googleAnalytics.m815h();
        googleAnalytics.m2667g().m9480h().m7022N0();
        if (this.f6700a != null) {
            C1212jh.m5111b("Passing exception to the original handler");
            this.f6700a.uncaughtException(thread, th);
        }
    }
}
