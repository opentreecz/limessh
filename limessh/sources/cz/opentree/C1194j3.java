package cz.opentree;

import android.os.SystemClock;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.j3 */
/* loaded from: classes.dex */
public class C1194j3 implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    /* renamed from: a */
    public long mo807a() {
        return SystemClock.elapsedRealtime();
    }
}
