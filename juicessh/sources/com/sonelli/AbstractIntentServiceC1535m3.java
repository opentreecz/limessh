package com.sonelli;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: GCMBaseIntentService.java */
/* renamed from: com.sonelli.m3 */
/* loaded from: classes.dex */
public abstract class AbstractIntentServiceC1535m3 extends IntentService {

    /* renamed from: P */
    public static PowerManager.WakeLock f4969P;

    /* renamed from: Q */
    public static final Object f4970Q = AbstractIntentServiceC1535m3.class;

    /* renamed from: R */
    public static int f4971R = 0;

    /* renamed from: S */
    public static final Random f4972S;

    /* renamed from: T */
    public static final int f4973T;

    /* renamed from: U */
    public static final String f4974U;

    /* renamed from: O */
    public final String[] f4975O;

    static {
        Random random = new Random();
        f4972S = random;
        f4973T = (int) TimeUnit.SECONDS.toMillis(3600L);
        f4974U = Long.toBinaryString(random.nextLong());
    }

    public AbstractIntentServiceC1535m3() {
        this(m6346a("DynamicSenderIds"), null);
    }

    public AbstractIntentServiceC1535m3(String str, String[] strArr) {
        super(str);
        this.f4975O = strArr;
    }

    /* renamed from: a */
    public static String m6346a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("GCMIntentService-");
        sb.append(str);
        sb.append("-");
        int i = f4971R + 1;
        f4971R = i;
        sb.append(i);
        String sb2 = sb.toString();
        Log.v("GCMBaseIntentService", "Intent service name: " + sb2);
        return sb2;
    }

    /* renamed from: j */
    public static void m6347j(Context context, Intent intent, String str) {
        synchronized (f4970Q) {
            if (f4969P == null) {
                f4969P = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        Log.v("GCMBaseIntentService", "Acquiring wakelock");
        f4969P.acquire();
        intent.setClassName(context, str);
        context.startService(intent);
    }

    /* renamed from: b */
    public String[] mo5643b(Context context) {
        String[] strArr = this.f4975O;
        if (strArr != null) {
            return strArr;
        }
        throw new IllegalStateException("sender id not set on constructor");
    }

    /* renamed from: c */
    public final void m6348c(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = intent.getStringExtra("error");
        String stringExtra3 = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3);
        if (stringExtra != null) {
            C1631o3.m6855n(context);
            C1631o3.m6857p(context, stringExtra);
            mo5646h(context, stringExtra);
            return;
        }
        if (stringExtra3 != null) {
            C1631o3.m6855n(context);
            mo5647i(context, C1631o3.m6845d(context));
            return;
        }
        Log.d("GCMBaseIntentService", "Registration error: " + stringExtra2);
        if (!"SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
            mo5644e(context, stringExtra2);
            return;
        }
        if (!m6350g(context, stringExtra2)) {
            Log.d("GCMBaseIntentService", "Not retrying failed operation");
            return;
        }
        int m6847f = C1631o3.m6847f(context);
        int nextInt = (m6847f / 2) + f4972S.nextInt(m6847f);
        Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + nextInt + " (" + m6847f + ")");
        Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
        intent2.putExtra("token", f4974U);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + ((long) nextInt), PendingIntent.getBroadcast(context, 0, intent2, 0));
        if (m6847f < f4973T) {
            C1631o3.m6856o(context, m6847f * 2);
        }
    }

    /* renamed from: d */
    public void m6349d(Context context, int i) {
    }

    /* renamed from: e */
    public abstract void mo5644e(Context context, String str);

    /* renamed from: f */
    public abstract void mo5645f(Context context, Intent intent);

    /* renamed from: g */
    public boolean m6350g(Context context, String str) {
        return true;
    }

    /* renamed from: h */
    public abstract void mo5646h(Context context, String str);

    /* renamed from: i */
    public abstract void mo5647i(Context context, String str);

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        try {
            Context applicationContext = getApplicationContext();
            String action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                C1631o3.m6858q(applicationContext);
                m6348c(applicationContext, intent);
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                String stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    mo5645f(applicationContext, intent);
                } else if (stringExtra.equals("deleted_messages")) {
                    String stringExtra2 = intent.getStringExtra("total_deleted");
                    if (stringExtra2 != null) {
                        try {
                            int parseInt = Integer.parseInt(stringExtra2);
                            Log.v("GCMBaseIntentService", "Received deleted messages notification: " + parseInt);
                            m6349d(applicationContext, parseInt);
                        } catch (NumberFormatException unused) {
                            Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + stringExtra2);
                        }
                    }
                } else {
                    Log.e("GCMBaseIntentService", "Received unknown special message: " + stringExtra);
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                String stringExtra3 = intent.getStringExtra("token");
                if (!f4974U.equals(stringExtra3)) {
                    Log.e("GCMBaseIntentService", "Received invalid token: " + stringExtra3);
                    synchronized (f4970Q) {
                        if (f4969P != null) {
                            Log.v("GCMBaseIntentService", "Releasing wakelock");
                            f4969P.release();
                        } else {
                            Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        }
                    }
                    return;
                }
                if (C1631o3.m6853l(applicationContext)) {
                    C1631o3.m6852k(applicationContext);
                } else {
                    C1631o3.m6851j(applicationContext, mo5643b(applicationContext));
                }
            }
            synchronized (f4970Q) {
                if (f4969P != null) {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    f4969P.release();
                } else {
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
            }
        } catch (Throwable th) {
            synchronized (f4970Q) {
                if (f4969P != null) {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    f4969P.release();
                } else {
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
                throw th;
            }
        }
    }
}
