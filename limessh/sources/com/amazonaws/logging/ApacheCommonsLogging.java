package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public class ApacheCommonsLogging implements Log {

    /* renamed from: a */
    public org.apache.commons.logging.Log f170a;

    /* renamed from: b */
    public LogFactory.Level f171b = null;

    public ApacheCommonsLogging(String str) {
        this.f170a = org.apache.commons.logging.LogFactory.getLog(str);
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: a */
    public void mo225a(Object obj) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.DEBUG.m240f()) {
            this.f170a.debug(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: b */
    public void mo226b(Object obj, Throwable th) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.DEBUG.m240f()) {
            this.f170a.debug(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: c */
    public boolean mo227c() {
        return this.f170a.isDebugEnabled() && (m234i() == null || m234i().m240f() <= LogFactory.Level.DEBUG.m240f());
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: d */
    public boolean mo228d() {
        return this.f170a.isInfoEnabled() && (m234i() == null || m234i().m240f() <= LogFactory.Level.INFO.m240f());
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: e */
    public void mo229e(Object obj) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.INFO.m240f()) {
            this.f170a.info(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: f */
    public void mo230f(Object obj, Throwable th) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.WARN.m240f()) {
            this.f170a.warn(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: g */
    public void mo231g(Object obj) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.WARN.m240f()) {
            this.f170a.warn(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    /* renamed from: h */
    public void mo232h(Object obj) {
        if (m234i() == null || m234i().m240f() <= LogFactory.Level.TRACE.m240f()) {
            this.f170a.trace(obj);
        }
    }

    /* renamed from: i */
    public final LogFactory.Level m234i() {
        LogFactory.Level level = this.f171b;
        return level != null ? level : LogFactory.m236b();
    }
}
