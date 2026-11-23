package com.sonelli;

import android.content.Context;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.nd */
/* loaded from: classes.dex */
public abstract class AbstractC1600nd<T> {

    /* renamed from: a */
    public final String f5257a;

    /* renamed from: b */
    public T f5258b;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.sonelli.nd$a */
    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public AbstractC1600nd(String str) {
        this.f5257a = str;
    }

    /* renamed from: a */
    public abstract T mo3168a(IBinder iBinder);

    /* renamed from: b */
    public final T m6664b(Context context) throws a {
        if (this.f5258b == null) {
            C0813ca.m2729k(context);
            Context m2678c = C0810c7.m2678c(context);
            if (m2678c == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.f5258b = mo3168a((IBinder) m2678c.getClassLoader().loadClass(this.f5257a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new a("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new a("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new a("Could not instantiate creator.", e3);
            }
        }
        return this.f5258b;
    }
}
