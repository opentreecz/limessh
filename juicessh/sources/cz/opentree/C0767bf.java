package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzf;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.bf */
/* loaded from: classes.dex */
public final class C0767bf implements zzf {
    public C0767bf() {
    }

    @Override // com.google.android.gms.internal.common.zzf
    @NonNull
    /* renamed from: b */
    public final ScheduledExecutorService mo1206b(int i, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
