package com.sonelli.juicessh.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.sonelli.juicessh.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class SyncProgressReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public AtomicBoolean f4148a = new AtomicBoolean(false);

    /* renamed from: b */
    public final OnSyncCompleteListener f4149b;

    /* renamed from: c */
    public TextView f4150c;

    /* renamed from: d */
    public View f4151d;

    /* loaded from: classes.dex */
    public interface OnSyncCompleteListener {
        /* renamed from: a */
        void mo5420a();
    }

    /* renamed from: com.sonelli.juicessh.receivers.SyncProgressReceiver$a */
    /* loaded from: classes.dex */
    public class RunnableC1364a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Context f4152O;

        public RunnableC1364a(Context context) {
            this.f4152O = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4152O, R.anim.rotate_around_center_point);
            SyncProgressReceiver.this.f4151d.setDrawingCacheEnabled(true);
            SyncProgressReceiver.this.f4151d.startAnimation(loadAnimation);
        }
    }

    public SyncProgressReceiver(TextView textView, View view, OnSyncCompleteListener onSyncCompleteListener) {
        this.f4149b = onSyncCompleteListener;
        this.f4150c = textView;
        this.f4151d = view;
    }

    /* renamed from: b */
    public void m5611b() {
        if (this.f4148a.get()) {
            this.f4148a.set(false);
            this.f4151d.setAnimation(null);
        }
    }

    /* renamed from: c */
    public void m5612c(Context context) {
        if (this.f4148a.get()) {
            return;
        }
        this.f4148a.set(true);
        new Handler().postDelayed(new RunnableC1364a(context), 100L);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            switch (intent.getExtras().getInt(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE)) {
                case 1:
                    this.f4150c.setText(context.getString(R.string.starting_backup));
                    m5612c(context);
                    break;
                case 2:
                    this.f4150c.setText(context.getString(R.string.encrypting_items));
                    m5612c(context);
                    break;
                case 3:
                    this.f4150c.setText(context.getString(R.string.sending_items));
                    m5612c(context);
                    break;
                case 4:
                    this.f4150c.setText(context.getString(R.string.receiving_items));
                    m5612c(context);
                    break;
                case 5:
                    this.f4150c.setText(context.getString(R.string.decrypting_items));
                    m5612c(context);
                    break;
                case 6:
                    this.f4150c.setText(context.getString(R.string.importing_items));
                    m5612c(context);
                    break;
                case 7:
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f4150c.setText(String.format(context.getString(R.string.last_sync), DateUtils.formatDateTime(context, currentTimeMillis, 16), DateUtils.formatDateTime(context, currentTimeMillis, 1)));
                    m5611b();
                    OnSyncCompleteListener onSyncCompleteListener = this.f4149b;
                    if (onSyncCompleteListener != null) {
                        onSyncCompleteListener.mo5420a();
                        break;
                    }
                    break;
                case 8:
                    this.f4150c.setText(context.getString(R.string.Caps_sync_failed));
                    m5611b();
                    break;
            }
        } catch (NullPointerException unused) {
        }
    }
}
