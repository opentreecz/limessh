package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzhz;
import com.sonelli.C0813ca;
import com.sonelli.C2144uz;
import com.sonelli.r00;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    /* renamed from: d */
    public static volatile AppMeasurement f972d;

    /* renamed from: a */
    public final C2144uz f973a;

    /* renamed from: b */
    public final zzhz f974b;

    /* renamed from: c */
    public final boolean f975c;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(@NonNull Bundle bundle) {
            C0813ca.m2729k(bundle);
            this.mAppId = (String) r00.m7839a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) r00.m7839a(bundle, "origin", String.class, null);
            this.mName = (String) r00.m7839a(bundle, "name", String.class, null);
            this.mValue = r00.m7839a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) r00.m7839a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) r00.m7839a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) r00.m7839a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) r00.m7839a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) r00.m7839a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) r00.m7839a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) r00.m7839a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) r00.m7839a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) r00.m7839a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) r00.m7839a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) r00.m7839a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) r00.m7839a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }

        /* renamed from: a */
        public final Bundle m1441a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                r00.m7840b(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    /* loaded from: classes.dex */
    public interface EventInterceptor extends zzgx {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    /* loaded from: classes.dex */
    public interface OnEventListener extends zzha {
    }

    public AppMeasurement(zzhz zzhzVar) {
        C0813ca.m2729k(zzhzVar);
        this.f974b = zzhzVar;
        this.f973a = null;
        this.f975c = true;
    }

    public AppMeasurement(C2144uz c2144uz) {
        C0813ca.m2729k(c2144uz);
        this.f973a = c2144uz;
        this.f974b = null;
        this.f975c = false;
    }

    /* renamed from: b */
    public static AppMeasurement m1436b(Context context, Bundle bundle) {
        if (f972d == null) {
            synchronized (AppMeasurement.class) {
                if (f972d == null) {
                    zzhz m1438e = m1438e(context, bundle);
                    if (m1438e != null) {
                        f972d = new AppMeasurement(m1438e);
                    } else {
                        f972d = new AppMeasurement(C2144uz.m9092b(context, null, null, bundle));
                    }
                }
            }
        }
        return f972d;
    }

    /* renamed from: c */
    public static AppMeasurement m1437c(Context context, String str, String str2) {
        if (f972d == null) {
            synchronized (AppMeasurement.class) {
                if (f972d == null) {
                    zzhz m1438e = m1438e(context, null);
                    if (m1438e != null) {
                        f972d = new AppMeasurement(m1438e);
                    } else {
                        f972d = new AppMeasurement(C2144uz.m9092b(context, null, null, null));
                    }
                }
            }
        }
        return f972d;
    }

    /* renamed from: e */
    public static zzhz m1438e(Context context, Bundle bundle) {
        try {
            return (zzhz) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, bundle);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return m1437c(context, null, null);
    }

    /* renamed from: a */
    public void m1439a(OnEventListener onEventListener) {
        if (this.f975c) {
            this.f974b.mo1499o(onEventListener);
        } else {
            this.f973a.m9101G().m10004K(onEventListener);
        }
    }

    @Keep
    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.f975c) {
            this.f974b.mo1490f(str);
        } else {
            this.f973a.m9114T().m9887A(str, this.f973a.mo1483i().mo1178b());
        }
    }

    @Keep
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.f975c) {
            this.f974b.mo1496l(str, str2, bundle);
        } else {
            this.f973a.m9101G().m10040y0(str, str2, bundle);
        }
    }

    @Keep
    public void clearConditionalUserPropertyAs(@NonNull @Size(min = 1) String str, @NonNull @Size(max = 24, min = 1) String str2, @Nullable String str3, @Nullable Bundle bundle) {
        if (this.f975c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f973a.m9101G().m10015Y(str, str2, str3, bundle);
        throw null;
    }

    /* renamed from: d */
    public final void m1440d(boolean z) {
        if (this.f975c) {
            this.f974b.mo1497m(z);
        } else {
            this.f973a.m9101G().m10038w0(z);
        }
    }

    @Keep
    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.f975c) {
            this.f974b.mo1492h(str);
        } else {
            this.f973a.m9114T().m9890E(str, this.f973a.mo1483i().mo1178b());
        }
    }

    @Keep
    public long generateEventId() {
        return this.f975c ? this.f974b.mo1489e() : this.f973a.m9102H().m4014D0();
    }

    @Nullable
    @Keep
    public String getAppInstanceId() {
        return this.f975c ? this.f974b.mo1487c() : this.f973a.m9101G().m10023g0();
    }

    @Keep
    @WorkerThread
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        List<Bundle> mo1495k = this.f975c ? this.f974b.mo1495k(str, str2) : this.f973a.m9101G().m9996C(str, str2);
        ArrayList arrayList = new ArrayList(mo1495k == null ? 0 : mo1495k.size());
        Iterator<Bundle> it = mo1495k.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Keep
    @WorkerThread
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable @Size(max = 23, min = 1) String str3) {
        if (this.f975c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f973a.m9101G().m9997D(str, str2, str3);
        throw null;
    }

    @Nullable
    @Keep
    public String getCurrentScreenClass() {
        return this.f975c ? this.f974b.mo1486b() : this.f973a.m9101G().m10026j0();
    }

    @Nullable
    @Keep
    public String getCurrentScreenName() {
        return this.f975c ? this.f974b.mo1485a() : this.f973a.m9101G().m10025i0();
    }

    @Nullable
    @Keep
    public String getGmpAppId() {
        return this.f975c ? this.f974b.mo1488d() : this.f973a.m9101G().m10027k0();
    }

    @Keep
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        if (this.f975c) {
            return this.f974b.mo1491g(str);
        }
        this.f973a.m9101G();
        C0813ca.m2725g(str);
        return 25;
    }

    @Keep
    @WorkerThread
    public Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z) {
        return this.f975c ? this.f974b.mo1493i(str, str2, z) : this.f973a.m9101G().m9999F(str, str2, z);
    }

    @Keep
    @WorkerThread
    public Map<String, Object> getUserPropertiesAs(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable @Size(max = 23, min = 1) String str3, boolean z) {
        if (this.f975c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f973a.m9101G().m9998E(str, str2, str3, z);
        throw null;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f975c) {
            this.f974b.mo1498n(str, str2, bundle);
        } else {
            this.f973a.m9101G().m10009S(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        C0813ca.m2729k(conditionalUserProperty);
        if (this.f975c) {
            this.f974b.mo1494j(conditionalUserProperty.m1441a());
        } else {
            this.f973a.m9101G().m10001H(conditionalUserProperty.m1441a());
        }
    }

    @Keep
    public void setConditionalUserPropertyAs(@NonNull ConditionalUserProperty conditionalUserProperty) {
        C0813ca.m2729k(conditionalUserProperty);
        if (this.f975c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f973a.m9101G().m10032p0(conditionalUserProperty.m1441a());
        throw null;
    }
}
