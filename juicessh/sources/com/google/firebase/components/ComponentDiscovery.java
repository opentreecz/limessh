package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class ComponentDiscovery<T> {

    /* renamed from: a */
    public final T f1116a;

    /* renamed from: b */
    public final RegistrarNameRetriever<T> f1117b;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface RegistrarNameRetriever<T> {
        /* renamed from: a */
        List<String> mo1605a(T t);
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* renamed from: com.google.firebase.components.ComponentDiscovery$b */
    /* loaded from: classes.dex */
    public static class C0627b implements RegistrarNameRetriever<Context> {

        /* renamed from: a */
        public final Class<? extends Service> f1118a;

        public C0627b(Class<? extends Service> cls) {
            this.f1118a = cls;
        }

        /* renamed from: b */
        public final Bundle m1606b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f1118a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f1118a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> mo1605a(Context context) {
            Bundle m1606b = m1606b(context);
            if (m1606b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : m1606b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(m1606b.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    @VisibleForTesting
    public ComponentDiscovery(T t, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.f1116a = t;
        this.f1117b = registrarNameRetriever;
    }

    /* renamed from: b */
    public static ComponentDiscovery<Context> m1602b(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new C0627b(cls));
    }

    /* renamed from: c */
    public static List<ComponentRegistrar> m1603c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                    arrayList.add((ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } else {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e3);
            } catch (NoSuchMethodException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e4);
            } catch (InvocationTargetException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e5);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<ComponentRegistrar> m1604a() {
        return m1603c(this.f1117b.mo1605a(this.f1116a));
    }
}
