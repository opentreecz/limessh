package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.LruCache;
import com.google.android.gms.common.annotation.KeepName;
import cz.opentree.AbstractC1594n9;
import cz.opentree.C1542m9;
import cz.opentree.C1804r9;
import cz.opentree.C2166ve;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: i */
    public static final Object f771i = new Object();

    /* renamed from: j */
    public static HashSet<Uri> f772j = new HashSet<>();

    /* renamed from: a */
    public final Context f773a;

    /* renamed from: b */
    public final Handler f774b;

    /* renamed from: c */
    public final ExecutorService f775c;

    /* renamed from: d */
    public final C0433a f776d;

    /* renamed from: e */
    public final C2166ve f777e;

    /* renamed from: f */
    public final Map<AbstractC1594n9, ImageReceiver> f778f;

    /* renamed from: g */
    public final Map<Uri, ImageReceiver> f779g;

    /* renamed from: h */
    public final Map<Uri, Long> f780h;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @KeepName
    /* loaded from: classes.dex */
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: O */
        public final Uri f781O;

        /* renamed from: P */
        public final ArrayList<AbstractC1594n9> f782P;

        /* renamed from: Q */
        public final /* synthetic */ ImageManager f783Q;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            this.f783Q.f775c.execute(new RunnableC0434b(this.f783Q, this.f781O, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface OnImageLoadedListener {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    /* loaded from: classes.dex */
    public static final class C0433a extends LruCache<C1542m9, Bitmap> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    /* loaded from: classes.dex */
    public final class RunnableC0434b implements Runnable {

        /* renamed from: O */
        public final Uri f784O;

        /* renamed from: P */
        public final ParcelFileDescriptor f785P;

        /* renamed from: Q */
        public final /* synthetic */ ImageManager f786Q;

        public RunnableC0434b(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f784O = uri;
            this.f785P = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1804r9.m7889b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f785P;
            boolean z = false;
            Bitmap bitmap = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.f784O);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z = true;
                }
                try {
                    this.f785P.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f786Q.f774b.post(new RunnableC0435c(this.f786Q, this.f784O, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.f784O);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    /* loaded from: classes.dex */
    public final class RunnableC0435c implements Runnable {

        /* renamed from: O */
        public final Uri f787O;

        /* renamed from: P */
        public final Bitmap f788P;

        /* renamed from: Q */
        public final CountDownLatch f789Q;

        /* renamed from: R */
        public boolean f790R;

        /* renamed from: S */
        public final /* synthetic */ ImageManager f791S;

        public RunnableC0435c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f787O = uri;
            this.f788P = bitmap;
            this.f790R = z;
            this.f789Q = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1804r9.m7888a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f788P != null;
            if (this.f791S.f776d != null) {
                if (this.f790R) {
                    this.f791S.f776d.evictAll();
                    System.gc();
                    this.f790R = false;
                    this.f791S.f774b.post(this);
                    return;
                }
                if (z) {
                    this.f791S.f776d.put(new C1542m9(this.f787O), this.f788P);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.f791S.f779g.remove(this.f787O);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.f782P;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbstractC1594n9 abstractC1594n9 = (AbstractC1594n9) arrayList.get(i);
                    if (z) {
                        abstractC1594n9.m6650a(this.f791S.f773a, this.f788P, false);
                    } else {
                        this.f791S.f780h.put(this.f787O, Long.valueOf(SystemClock.elapsedRealtime()));
                        abstractC1594n9.m6651b(this.f791S.f773a, this.f791S.f777e, false);
                    }
                    this.f791S.f778f.remove(abstractC1594n9);
                }
            }
            this.f789Q.countDown();
            synchronized (ImageManager.f771i) {
                ImageManager.f772j.remove(this.f787O);
            }
        }
    }
}
