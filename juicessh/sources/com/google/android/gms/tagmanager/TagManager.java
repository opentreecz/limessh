package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.RequiresPermission;
import com.sonelli.c60;
import com.sonelli.d60;
import com.sonelli.e60;
import com.sonelli.f60;
import com.sonelli.g60;
import com.sonelli.h60;
import com.sonelli.j50;
import com.sonelli.l50;
import com.sonelli.v50;
import com.sonelli.x50;
import com.sonelli.y50;
import com.sonelli.z50;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class TagManager {

    /* renamed from: f */
    public static TagManager f1063f;

    /* renamed from: a */
    public final zza f1064a;

    /* renamed from: b */
    public final Context f1065b;

    /* renamed from: c */
    public final DataLayer f1066c;

    /* renamed from: d */
    public final y50 f1067d;

    /* renamed from: e */
    public final ConcurrentMap<String, h60> f1068e;

    /* loaded from: classes.dex */
    public interface zza {
    }

    public TagManager(Context context, zza zzaVar, DataLayer dataLayer, y50 y50Var) {
        Objects.requireNonNull(context, "context cannot be null");
        Context applicationContext = context.getApplicationContext();
        this.f1065b = applicationContext;
        this.f1067d = y50Var;
        this.f1064a = zzaVar;
        this.f1068e = new ConcurrentHashMap();
        this.f1066c = dataLayer;
        dataLayer.m1526b(new d60(this));
        dataLayer.m1526b(new c60(applicationContext));
        applicationContext.registerComponentCallbacks(new f60(this));
        j50.m5059d(applicationContext);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: b */
    public static TagManager m1534b(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (f1063f == null) {
                if (context == null) {
                    v50.m9168c("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f1063f = new TagManager(context, new e60(), new DataLayer(new l50(context)), z50.m10394c());
            }
            tagManager = f1063f;
        }
        return tagManager;
    }

    /* renamed from: a */
    public void m1536a() {
        this.f1067d.mo10089a();
    }

    /* renamed from: d */
    public final synchronized boolean m1537d(Uri uri) {
        x50 m9701d = x50.m9701d();
        if (!m9701d.m9703b(uri)) {
            return false;
        }
        String m9702a = m9701d.m9702a();
        int i = g60.f2836a[m9701d.m9704e().ordinal()];
        if (i == 1) {
            h60 h60Var = this.f1068e.get(m9702a);
            if (h60Var != null) {
                h60Var.m4380d(null);
                h60Var.m4378b();
            }
        } else if (i == 2 || i == 3) {
            for (String str : this.f1068e.keySet()) {
                h60 h60Var2 = this.f1068e.get(str);
                if (str.equals(m9702a)) {
                    h60Var2.m4380d(m9701d.m9705f());
                    h60Var2.m4378b();
                } else if (h60Var2.m4381e() != null) {
                    h60Var2.m4380d(null);
                    h60Var2.m4378b();
                }
            }
        }
        return true;
    }

    /* renamed from: e */
    public final boolean m1538e(h60 h60Var) {
        return this.f1068e.remove(h60Var.m4377a()) != null;
    }

    /* renamed from: f */
    public final void m1539f(String str) {
        Iterator<h60> it = this.f1068e.values().iterator();
        while (it.hasNext()) {
            it.next().m4379c(str);
        }
    }
}
