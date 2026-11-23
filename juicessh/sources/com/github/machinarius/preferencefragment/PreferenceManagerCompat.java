package com.github.machinarius.preferencefragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class PreferenceManagerCompat {

    /* renamed from: a */
    public static final String f512a = "PreferenceManagerCompat";

    /* loaded from: classes.dex */
    public interface OnPreferenceTreeClickListener {
        /* renamed from: a */
        boolean mo719a(PreferenceScreen preferenceScreen, Preference preference);
    }

    /* renamed from: com.github.machinarius.preferencefragment.PreferenceManagerCompat$a */
    /* loaded from: classes.dex */
    public static class C0419a implements InvocationHandler {

        /* renamed from: a */
        public final /* synthetic */ OnPreferenceTreeClickListener f513a;

        public C0419a(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
            this.f513a = onPreferenceTreeClickListener;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals("onPreferenceTreeClick")) {
                return Boolean.valueOf(this.f513a.mo719a((PreferenceScreen) objArr[0], (Preference) objArr[1]));
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m729a(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityDestroy", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.dispatchActivityDestroy by reflection", e);
        }
    }

    /* renamed from: b */
    public static void m730b(PreferenceManager preferenceManager, int i, int i2, Intent intent) {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityResult", cls, cls, Intent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, Integer.valueOf(i), Integer.valueOf(i2), intent);
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.dispatchActivityResult by reflection", e);
        }
    }

    /* renamed from: c */
    public static void m731c(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityStop", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.dispatchActivityStop by reflection", e);
        }
    }

    /* renamed from: d */
    public static PreferenceScreen m732d(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("getPreferenceScreen", new Class[0]);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.getPreferenceScreen by reflection", e);
            return null;
        }
    }

    /* renamed from: e */
    public static PreferenceScreen m733e(PreferenceManager preferenceManager, Activity activity, int i, PreferenceScreen preferenceScreen) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("inflateFromResource", Context.class, Integer.TYPE, PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(preferenceManager, activity, Integer.valueOf(i), preferenceScreen);
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.inflateFromResource by reflection", e);
            return null;
        }
    }

    /* renamed from: f */
    public static PreferenceManager m734f(Activity activity, int i) {
        try {
            Constructor declaredConstructor = PreferenceManager.class.getDeclaredConstructor(Activity.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (PreferenceManager) declaredConstructor.newInstance(activity, Integer.valueOf(i));
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call constructor PreferenceManager by reflection", e);
            return null;
        }
    }

    /* renamed from: g */
    public static void m735g(PreferenceManager preferenceManager, PreferenceFragment preferenceFragment) {
    }

    /* renamed from: h */
    public static void m736h(PreferenceManager preferenceManager, OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        try {
            Field declaredField = PreferenceManager.class.getDeclaredField("mOnPreferenceTreeClickListener");
            declaredField.setAccessible(true);
            if (onPreferenceTreeClickListener != null) {
                declaredField.set(preferenceManager, Proxy.newProxyInstance(declaredField.getType().getClassLoader(), new Class[]{declaredField.getType()}, new C0419a(onPreferenceTreeClickListener)));
            } else {
                declaredField.set(preferenceManager, null);
            }
        } catch (Exception e) {
            Log.w(f512a, "Couldn't set PreferenceManager.mOnPreferenceTreeClickListener by reflection", e);
        }
    }

    /* renamed from: i */
    public static boolean m737i(PreferenceManager preferenceManager, PreferenceScreen preferenceScreen) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("setPreferences", PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(preferenceManager, preferenceScreen)).booleanValue();
        } catch (Exception e) {
            Log.w(f512a, "Couldn't call PreferenceManager.setPreferences by reflection", e);
            return false;
        }
    }
}
