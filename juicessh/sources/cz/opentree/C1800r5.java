package cz.opentree;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.r5 */
/* loaded from: classes.dex */
public final class C1800r5 extends AsyncTaskLoader<Void> implements SignInConnectionListener {

    /* renamed from: a */
    public Semaphore f6183a;

    /* renamed from: b */
    public Set<GoogleApiClient> f6184b;

    public C1800r5(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f6183a = new Semaphore(0);
        this.f6184b = set;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Void loadInBackground() {
        Iterator<GoogleApiClient> it = this.f6184b.iterator();
        if (it.hasNext()) {
            it.next().m986e(this);
            throw null;
        }
        try {
            this.f6183a.tryAcquire(0, 5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.f6183a.drainPermits();
        forceLoad();
    }
}
