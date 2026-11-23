package cz.opentree;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.x6 */
/* loaded from: classes.dex */
public class C2260x6 extends C2326y6 {

    /* renamed from: d */
    public static final Object f7885d = new Object();

    /* renamed from: e */
    public static final C2260x6 f7886e = new C2260x6();

    /* renamed from: c */
    @GuardedBy("mLock")
    public String f7887c;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: cz.opentree.x6$a */
    /* loaded from: classes.dex */
    public class a extends HandlerC2215we {

        /* renamed from: a */
        public final Context f7888a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f7888a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int mo9712g = C2260x6.this.mo9712g(this.f7888a);
            if (C2260x6.this.mo9714i(mo9712g)) {
                C2260x6.this.m9718o(this.f7888a, mo9712g);
            }
        }
    }

    /* renamed from: m */
    public static C2260x6 m9706m() {
        return f7886e;
    }

    /* renamed from: p */
    public static Dialog m9707p(Context context, int i, AbstractDialogInterfaceOnClickListenerC1998u9 abstractDialogInterfaceOnClickListenerC1998u9, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(C1904t9.m8610d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String m8609c = C1904t9.m8609c(context, i);
        if (m8609c != null) {
            builder.setPositiveButton(m8609c, abstractDialogInterfaceOnClickListenerC1998u9);
        }
        String m8613g = C1904t9.m8613g(context, i);
        if (m8613g != null) {
            builder.setTitle(m8613g);
        }
        return builder.create();
    }

    /* renamed from: q */
    public static void m9708q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            C0914e7.m3454e(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            DialogFragmentC2202w6.m9410a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @Override // cz.opentree.C2326y6
    @Nullable
    /* renamed from: b */
    public Intent mo9709b(Context context, int i, @Nullable String str) {
        return super.mo9709b(context, i, str);
    }

    @Override // cz.opentree.C2326y6
    @Nullable
    /* renamed from: c */
    public PendingIntent mo9710c(Context context, int i, int i2) {
        return super.mo9710c(context, i, i2);
    }

    @Override // cz.opentree.C2326y6
    /* renamed from: e */
    public final String mo9711e(int i) {
        return super.mo9711e(i);
    }

    @Override // cz.opentree.C2326y6
    /* renamed from: g */
    public int mo9712g(Context context) {
        return super.mo9712g(context);
    }

    @Override // cz.opentree.C2326y6
    /* renamed from: h */
    public int mo9713h(Context context, int i) {
        return super.mo9713h(context, i);
    }

    @Override // cz.opentree.C2326y6
    /* renamed from: i */
    public final boolean mo9714i(int i) {
        return super.mo9714i(i);
    }

    /* renamed from: k */
    public Dialog m9715k(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m9707p(activity, i, AbstractDialogInterfaceOnClickListenerC1998u9.m8862a(activity, mo9709b(activity, i, "d"), i2), onCancelListener);
    }

    @Nullable
    /* renamed from: l */
    public PendingIntent m9716l(Context context, ConnectionResult connectionResult) {
        return connectionResult.m953Z() ? connectionResult.m952Y() : mo9710c(context, connectionResult.m955x(), 0);
    }

    /* renamed from: n */
    public boolean m9717n(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog m9715k = m9715k(activity, i, i2, onCancelListener);
        if (m9715k == null) {
            return false;
        }
        m9708q(activity, m9715k, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    /* renamed from: o */
    public void m9718o(Context context, int i) {
        m9720s(context, i, null, m10093d(context, i, 0, "n"));
    }

    /* renamed from: r */
    public final void m9719r(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    @TargetApi(20)
    /* renamed from: s */
    public final void m9720s(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            m9719r(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String m8612f = C1904t9.m8612f(context, i);
        String m8611e = C1904t9.m8611e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(m8612f).setStyle(new NotificationCompat.BigTextStyle().bigText(m8611e));
        if (C0981fc.m3711b(context)) {
            C0813ca.m2732n(C1501lc.m6147g());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (C0981fc.m3712c(context)) {
                style.addAction(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(R$string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(m8611e);
        }
        if (C1501lc.m6150j()) {
            C0813ca.m2732n(C1501lc.m6150j());
            String m9722u = m9722u();
            if (m9722u == null) {
                m9722u = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String m8608b = C1904t9.m8608b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", m8608b, 4));
                } else if (!m8608b.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(m8608b);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            style.setChannelId(m9722u);
        }
        Notification build = style.build();
        if (i == 1 || i == 2 || i == 3) {
            i2 = 10436;
            C0810c7.f1878d.set(false);
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, build);
    }

    /* renamed from: t */
    public final boolean m9721t(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent m9716l = m9716l(context, connectionResult);
        if (m9716l == null) {
            return false;
        }
        m9720s(context, connectionResult.m955x(), null, GoogleApiActivity.m980a(context, m9716l, i));
        return true;
    }

    @VisibleForTesting(otherwise = 2)
    /* renamed from: u */
    public final String m9722u() {
        String str;
        synchronized (f7885d) {
            str = this.f7887c;
        }
        return str;
    }
}
