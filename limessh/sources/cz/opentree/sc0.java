package cz.opentree;

import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class sc0 implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    public final int f6428a;

    /* renamed from: b */
    public final StackTraceTrimmingStrategy[] f6429b;

    /* renamed from: c */
    public final tc0 f6430c;

    public sc0(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f6428a = i;
        this.f6429b = stackTraceTrimmingStrategyArr;
        this.f6430c = new tc0(i);
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    /* renamed from: a */
    public StackTraceElement[] mo1848a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f6428a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f6429b) {
            if (stackTraceElementArr2.length <= this.f6428a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.mo1848a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f6428a ? this.f6430c.mo1848a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
