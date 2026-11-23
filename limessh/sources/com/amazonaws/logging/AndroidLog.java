package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public class AndroidLog implements Log {

    /* renamed from: a */
    public final String f168a;

    /* renamed from: b */
    public LogFactory.Level f169b = null;

    public AndroidLog(String str) {
        this.f168a = str;
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: a */
    public void mo225a(Object obj) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.DEBUG.m240f()) {
            android.util.Log.d(this.f168a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: b */
    public void mo226b(Object obj, Throwable th) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.DEBUG.m240f()) {
            android.util.Log.d(this.f168a, obj.toString(), th);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: c */
    public boolean mo227c() {
        return android.util.Log.isLoggable(this.f168a, 3) && (m233i() == null || m233i().m240f() <= LogFactory.Level.DEBUG.m240f());
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: d */
    public boolean mo228d() {
        return android.util.Log.isLoggable(this.f168a, 4) && (m233i() == null || m233i().m240f() <= LogFactory.Level.INFO.m240f());
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: e */
    public void mo229e(Object obj) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.INFO.m240f()) {
            android.util.Log.i(this.f168a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: f */
    public void mo230f(Object obj, Throwable th) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.WARN.m240f()) {
            android.util.Log.w(this.f168a, obj.toString(), th);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: g */
    public void mo231g(Object obj) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.WARN.m240f()) {
            android.util.Log.w(this.f168a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: h */
    public void mo232h(Object obj) {
        if (m233i() == null || m233i().m240f() <= LogFactory.Level.TRACE.m240f()) {
            android.util.Log.v(this.f168a, obj.toString());
        }
    }

    /* renamed from: i */
    public final LogFactory.Level m233i() {
        LogFactory.Level level = this.f169b;
        return level != null ? level : LogFactory.m236b();
    }
}
