package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompatApi21;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* loaded from: classes.dex */
public class MediaSessionCompatApi23 {

    /* loaded from: classes.dex */
    public interface Callback extends MediaSessionCompatApi21.Callback {
        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onCustomAction(String str, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onFastForward();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ boolean onMediaButtonEvent(Intent intent);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPause();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlay();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlayFromMediaId(String str, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlayFromSearch(String str, Bundle bundle);

        void onPlayFromUri(Uri uri, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onRewind();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSeekTo(long j);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSetRating(Object obj);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSetRating(Object obj, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToNext();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToPrevious();

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToQueueItem(long j);

        @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onStop();
    }

    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
