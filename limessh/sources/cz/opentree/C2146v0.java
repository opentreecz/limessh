package cz.opentree;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.v0 */
/* loaded from: classes.dex */
public class C2146v0 implements BackendRegistry {

    /* renamed from: a */
    public final a f7367a;

    /* renamed from: b */
    public final C1893t0 f7368b;

    /* renamed from: c */
    public final Map<String, TransportBackend> f7369c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.v0$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final Context f7370a;

        /* renamed from: b */
        public Map<String, String> f7371b = null;

        public a(Context context) {
            this.f7370a = context;
        }

        /* renamed from: d */
        public static Bundle m9132d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* renamed from: a */
        public final Map<String, String> m9133a(Context context) {
            Bundle m9132d = m9132d(context);
            if (m9132d == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : m9132d.keySet()) {
                Object obj = m9132d.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        @Nullable
        /* renamed from: b */
        public BackendFactory m9134b(String str) {
            String str2 = m9135c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            }
        }

        /* renamed from: c */
        public final Map<String, String> m9135c() {
            if (this.f7371b == null) {
                this.f7371b = m9133a(this.f7370a);
            }
            return this.f7371b;
        }
    }

    public C2146v0(Context context, C1893t0 c1893t0) {
        this(new a(context), c1893t0);
    }

    public C2146v0(a aVar, C1893t0 c1893t0) {
        this.f7369c = new HashMap();
        this.f7367a = aVar;
        this.f7368b = c1893t0;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    @Nullable
    /* renamed from: a */
    public synchronized TransportBackend mo747a(String str) {
        if (this.f7369c.containsKey(str)) {
            return this.f7369c.get(str);
        }
        BackendFactory m9134b = this.f7367a.m9134b(str);
        if (m9134b == null) {
            return null;
        }
        TransportBackend create = m9134b.create(this.f7368b.m8560a(str));
        this.f7369c.put(str, create);
        return create;
    }
}
