package android.support.v4.media.session;

import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

@RequiresApi(24)
/* loaded from: classes.dex */
public class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    /* loaded from: classes.dex */
    public interface Callback extends MediaSessionCompatApi23.Callback {
        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onCustomAction(String str, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onFastForward();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ boolean onMediaButtonEvent(Intent intent);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPause();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlay();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlayFromMediaId(String str, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onPlayFromSearch(String str, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
        /* synthetic */ void onPlayFromUri(Uri uri, Bundle bundle);

        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onRewind();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSeekTo(long j);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSetRating(Object obj);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSetRating(Object obj, Bundle bundle);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToNext();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToPrevious();

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onSkipToQueueItem(long j);

        @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback, android.support.v4.media.session.MediaSessionCompatApi21.Callback
        /* synthetic */ void onStop();
    }

    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static String getCallingPackage(Object obj) {
        MediaSession mediaSession = (MediaSession) obj;
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e(TAG, "Cannot execute MediaSession.getCallingPackage()", e);
            return null;
        }
    }
}
