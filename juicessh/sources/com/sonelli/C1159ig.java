package com.sonelli;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.gtm.zzbw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.sonelli.ig */
/* loaded from: classes.dex */
public final class C1159ig extends AbstractC2006uf {

    /* renamed from: Q */
    public boolean f3301Q;

    /* renamed from: R */
    public final C0986fg f3302R;

    /* renamed from: S */
    public final C1552mh f3303S;

    /* renamed from: T */
    public final C1506lh f3304T;

    /* renamed from: U */
    public final C0709ag f3305U;

    /* renamed from: V */
    public long f3306V;

    /* renamed from: W */
    public final AbstractC2217wg f3307W;

    /* renamed from: X */
    public final AbstractC2217wg f3308X;

    /* renamed from: Y */
    public final C2221wh f3309Y;

    /* renamed from: Z */
    public long f3310Z;

    /* renamed from: a0 */
    public boolean f3311a0;

    public C1159ig(C2216wf c2216wf, C2342yf c2342yf) {
        super(c2216wf);
        C0813ca.m2729k(c2342yf);
        this.f3306V = Long.MIN_VALUE;
        this.f3304T = new C1506lh(c2216wf);
        this.f3302R = new C0986fg(c2216wf);
        this.f3303S = new C1552mh(c2216wf);
        this.f3305U = new C0709ag(c2216wf);
        this.f3309Y = new C2221wh(m8659g0());
        this.f3307W = new C1211jg(this, c2216wf);
        this.f3308X = new C1450kg(this, c2216wf);
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        this.f3302R.m8877D0();
        this.f3303S.m8877D0();
        this.f3305U.m8877D0();
    }

    /* renamed from: G0 */
    public final void m4755G0() {
        C1434k4.m5823i();
        C1434k4.m5823i();
        m8878F0();
        if (!C2007ug.m8879b()) {
            m8649A0("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.f3305U.m2056I0()) {
            m8676x0("Service not connected");
            return;
        }
        if (this.f3302R.m3757J0()) {
            return;
        }
        m8676x0("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<C1043gh> m3765T0 = this.f3302R.m3765T0(C2007ug.m8883f());
                if (m3765T0.isEmpty()) {
                    m4770X0();
                    return;
                }
                while (!m3765T0.isEmpty()) {
                    C1043gh c1043gh = m3765T0.get(0);
                    if (!this.f3305U.m2059P0(c1043gh)) {
                        m4770X0();
                        return;
                    }
                    m3765T0.remove(c1043gh);
                    try {
                        this.f3302R.m3769Z0(c1043gh.m4128g());
                    } catch (SQLiteException e) {
                        m8674w0("Failed to remove hit that was send for delivery", e);
                        m4772Z0();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                m8674w0("Failed to read hits from store", e2);
                m4772Z0();
                return;
            }
        }
    }

    /* renamed from: H0 */
    public final void m4756H0() {
        m8878F0();
        C0813ca.m2733o(!this.f3301Q, "Analytics backend already started");
        this.f3301Q = true;
        m8662j0().m5829e(new RunnableC1505lg(this));
    }

    /* renamed from: I0 */
    public final long m4757I0(C2424zf c2424zf, boolean z) {
        C0813ca.m2729k(c2424zf);
        m8878F0();
        C1434k4.m5823i();
        try {
            try {
                this.f3302R.m3754G0();
                C0986fg c0986fg = this.f3302R;
                long m10435c = c2424zf.m10435c();
                String m10434b = c2424zf.m10434b();
                C0813ca.m2725g(m10434b);
                c0986fg.m8878F0();
                C1434k4.m5823i();
                int delete = c0986fg.m3756I0().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(m10435c), m10434b});
                if (delete > 0) {
                    c0986fg.m8679z("Deleted property records", Integer.valueOf(delete));
                }
                long m3759L0 = this.f3302R.m3759L0(c2424zf.m10435c(), c2424zf.m10434b(), c2424zf.m10436d());
                c2424zf.m10433a(1 + m3759L0);
                C0986fg c0986fg2 = this.f3302R;
                C0813ca.m2729k(c2424zf);
                c0986fg2.m8878F0();
                C1434k4.m5823i();
                SQLiteDatabase m3756I0 = c0986fg2.m3756I0();
                Map<String, String> m10439g = c2424zf.m10439g();
                C0813ca.m2729k(m10439g);
                Uri.Builder builder = new Uri.Builder();
                for (Map.Entry<String, String> entry : m10439g.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                String encodedQuery = builder.build().getEncodedQuery();
                if (encodedQuery == null) {
                    encodedQuery = "";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_uid", Long.valueOf(c2424zf.m10435c()));
                contentValues.put("cid", c2424zf.m10434b());
                contentValues.put("tid", c2424zf.m10436d());
                contentValues.put("adid", Integer.valueOf(c2424zf.m10437e() ? 1 : 0));
                contentValues.put("hits_count", Long.valueOf(c2424zf.m10438f()));
                contentValues.put("params", encodedQuery);
                try {
                    if (m3756I0.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                        c0986fg2.m8650B0("Failed to insert/update a property (got -1)");
                    }
                } catch (SQLiteException e) {
                    c0986fg2.m8674w0("Error storing a property", e);
                }
                this.f3302R.m3758K0();
                try {
                    this.f3302R.m3755H0();
                } catch (SQLiteException e2) {
                    m8674w0("Failed to end transaction", e2);
                }
                return m3759L0;
            } catch (SQLiteException e3) {
                m8674w0("Failed to update Analytics property", e3);
                try {
                    this.f3302R.m3755H0();
                } catch (SQLiteException e4) {
                    m8674w0("Failed to end transaction", e4);
                }
                return -1L;
            }
        } finally {
        }
    }

    /* renamed from: J0 */
    public final void m4758J0(C2424zf c2424zf, C1507li c1507li) {
        C0813ca.m2729k(c2424zf);
        C0813ca.m2729k(c1507li);
        C0807c4 c0807c4 = new C0807c4(m8658f0());
        c0807c4.m2666f(c2424zf.m10436d());
        c0807c4.m2665e(c2424zf.m10437e());
        C1093h4 mo2664b = c0807c4.mo2664b();
        C1933ti c1933ti = (C1933ti) mo2664b.m4363n(C1933ti.class);
        c1933ti.m8699q("data");
        c1933ti.m8690h(true);
        mo2664b.m4352c(c1507li);
        C1658oi c1658oi = (C1658oi) mo2664b.m4363n(C1658oi.class);
        C1455ki c1455ki = (C1455ki) mo2664b.m4363n(C1455ki.class);
        for (Map.Entry<String, String> entry : c2424zf.m10439g().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                c1455ki.m5904g(value);
            } else if ("av".equals(key)) {
                c1455ki.m5905h(value);
            } else if ("aid".equals(key)) {
                c1455ki.m5902e(value);
            } else if ("aiid".equals(key)) {
                c1455ki.m5903f(value);
            } else if ("uid".equals(key)) {
                c1933ti.m8688f(value);
            } else {
                c1658oi.m7042e(key, value);
            }
        }
        m8654a0("Sending installation campaign to", c2424zf.m10436d(), c1507li);
        mo2664b.m4351b(m8667o0().m7035H0());
        mo2664b.m4357h();
    }

    /* renamed from: L0 */
    public final void m4759L0(C1043gh c1043gh) {
        Pair<String, Long> m7705c;
        C0813ca.m2729k(c1043gh);
        C1434k4.m5823i();
        m8878F0();
        if (this.f3311a0) {
            m8678y0("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            m8679z("Delivering hit", c1043gh);
        }
        if (TextUtils.isEmpty(c1043gh.m4133l()) && (m7705c = m8667o0().m7040M0().m7705c()) != null) {
            Long l = (Long) m7705c.second;
            String str = (String) m7705c.first;
            String valueOf = String.valueOf(l);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
            sb.append(valueOf);
            sb.append(":");
            sb.append(str);
            String sb2 = sb.toString();
            HashMap hashMap = new HashMap(c1043gh.m4126e());
            hashMap.put("_m", sb2);
            c1043gh = new C1043gh(this, hashMap, c1043gh.m4129h(), c1043gh.m4131j(), c1043gh.m4128g(), c1043gh.m4127f(), c1043gh.m4130i());
        }
        m4767U0();
        if (this.f3305U.m2059P0(c1043gh)) {
            m8678y0("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.f3302R.m3764S0(c1043gh);
            m4770X0();
        } catch (SQLiteException e) {
            m8674w0("Delivery failed to save hit to a database", e);
            m8660h0().m5889G0(c1043gh, "deliver: failed to insert hit to database");
        }
    }

    /* renamed from: M0 */
    public final void m4760M0(C2424zf c2424zf) {
        C1434k4.m5823i();
        m8653Z("Sending first hit to property", c2424zf.m10436d());
        if (m8667o0().m7036I0().m9521c(C2007ug.m8888l())) {
            return;
        }
        String m7039L0 = m8667o0().m7039L0();
        if (TextUtils.isEmpty(m7039L0)) {
            return;
        }
        C1507li m2073b = C0713ai.m2073b(m8660h0(), m7039L0);
        m8653Z("Found relevant installation campaign", m2073b);
        m4758J0(c2424zf, m2073b);
    }

    /* renamed from: O0 */
    public final void m4761O0(zzbw zzbwVar) {
        long j = this.f3310Z;
        C1434k4.m5823i();
        m8878F0();
        long m7037J0 = m8667o0().m7037J0();
        m8653Z("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(m7037J0 != 0 ? Math.abs(m8659g0().mo1177a() - m7037J0) : -1L));
        m4767U0();
        try {
            m4768V0();
            m8667o0().m7038K0();
            m4770X0();
            if (zzbwVar != null) {
                zzbwVar.mo1215a(null);
            }
            if (this.f3310Z != j) {
                this.f3304T.m6163e();
            }
        } catch (Exception e) {
            m8674w0("Local dispatch failed", e);
            m8667o0().m7038K0();
            m4770X0();
            if (zzbwVar != null) {
                zzbwVar.mo1215a(e);
            }
        }
    }

    /* renamed from: P0 */
    public final void m4762P0() {
        C1434k4.m5823i();
        this.f3310Z = m8659g0().mo1177a();
    }

    /* renamed from: Q0 */
    public final long m4763Q0() {
        C1434k4.m5823i();
        m8878F0();
        try {
            return this.f3302R.m3768W0();
        } catch (SQLiteException e) {
            m8674w0("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    /* renamed from: R0 */
    public final void m4764R0() {
        m8878F0();
        C1434k4.m5823i();
        Context m9475a = m8658f0().m9475a();
        if (!C1817rh.m7905b(m9475a)) {
            m8649A0("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!C1860sh.m8431i(m9475a)) {
            m8650B0("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!C1844s3.m8310a(m9475a)) {
            m8649A0("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        m8667o0().m7035H0();
        if (!m4775c1("android.permission.ACCESS_NETWORK_STATE")) {
            m8650B0("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m4774b1();
        }
        if (!m4775c1("android.permission.INTERNET")) {
            m8650B0("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m4774b1();
        }
        if (C1860sh.m8431i(m8675x())) {
            m8676x0("AnalyticsService registered in the app manifest and enabled");
        } else {
            m8649A0("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.f3311a0 && !this.f3302R.m3757J0()) {
            m4767U0();
        }
        m4770X0();
    }

    /* renamed from: S0 */
    public final void m4765S0() {
        m4761O0(new C1551mg(this));
    }

    /* renamed from: T0 */
    public final void m4766T0() {
        try {
            this.f3302R.m3767V0();
            m4770X0();
        } catch (SQLiteException e) {
            m8672t0("Failed to delete stale hits", e);
        }
        this.f3308X.m9501h(86400000L);
    }

    /* renamed from: U0 */
    public final void m4767U0() {
        if (this.f3311a0 || !C2007ug.m8879b() || this.f3305U.m2056I0()) {
            return;
        }
        if (this.f3309Y.m9521c(C0770bh.f1672B.m2801a().longValue())) {
            this.f3309Y.m9520b();
            m8676x0("Connecting to service");
            if (this.f3305U.m2054G0()) {
                m8676x0("Connected to service");
                this.f3309Y.m9519a();
                m4755G0();
            }
        }
    }

    /* renamed from: V0 */
    public final boolean m4768V0() {
        C1434k4.m5823i();
        m8878F0();
        m8676x0("Dispatching a batch of local hits");
        boolean z = !this.f3305U.m2056I0();
        boolean z2 = !this.f3303S.m6420Q0();
        if (z && z2) {
            m8676x0("No network or service available. Will retry later");
            return false;
        }
        long max = Math.max(C2007ug.m8883f(), C2007ug.m8884g());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        while (true) {
            try {
                try {
                    this.f3302R.m3754G0();
                    arrayList.clear();
                    try {
                        List<C1043gh> m3765T0 = this.f3302R.m3765T0(max);
                        if (m3765T0.isEmpty()) {
                            m8676x0("Store is empty, nothing to dispatch");
                            m4772Z0();
                            try {
                                this.f3302R.m3758K0();
                                this.f3302R.m3755H0();
                                return false;
                            } catch (SQLiteException e) {
                                m8674w0("Failed to commit local dispatch transaction", e);
                                m4772Z0();
                                return false;
                            }
                        }
                        m8679z("Hits loaded from store. count", Integer.valueOf(m3765T0.size()));
                        Iterator<C1043gh> it = m3765T0.iterator();
                        while (it.hasNext()) {
                            if (it.next().m4128g() == j) {
                                m8673u0("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(m3765T0.size()));
                                m4772Z0();
                                try {
                                    this.f3302R.m3758K0();
                                    this.f3302R.m3755H0();
                                    return false;
                                } catch (SQLiteException e2) {
                                    m8674w0("Failed to commit local dispatch transaction", e2);
                                    m4772Z0();
                                    return false;
                                }
                            }
                        }
                        if (this.f3305U.m2056I0()) {
                            m8676x0("Service connected, sending hits to the service");
                            while (!m3765T0.isEmpty()) {
                                C1043gh c1043gh = m3765T0.get(0);
                                if (!this.f3305U.m2059P0(c1043gh)) {
                                    break;
                                }
                                j = Math.max(j, c1043gh.m4128g());
                                m3765T0.remove(c1043gh);
                                m8653Z("Hit sent do device AnalyticsService for delivery", c1043gh);
                                try {
                                    this.f3302R.m3769Z0(c1043gh.m4128g());
                                    arrayList.add(Long.valueOf(c1043gh.m4128g()));
                                } catch (SQLiteException e3) {
                                    m8674w0("Failed to remove hit that was send for delivery", e3);
                                    m4772Z0();
                                    try {
                                        this.f3302R.m3758K0();
                                        this.f3302R.m3755H0();
                                        return false;
                                    } catch (SQLiteException e4) {
                                        m8674w0("Failed to commit local dispatch transaction", e4);
                                        m4772Z0();
                                        return false;
                                    }
                                }
                            }
                        }
                        if (this.f3303S.m6420Q0()) {
                            List<Long> m6418O0 = this.f3303S.m6418O0(m3765T0);
                            Iterator<Long> it2 = m6418O0.iterator();
                            while (it2.hasNext()) {
                                j = Math.max(j, it2.next().longValue());
                            }
                            try {
                                this.f3302R.m3762P0(m6418O0);
                                arrayList.addAll(m6418O0);
                            } catch (SQLiteException e5) {
                                m8674w0("Failed to remove successfully uploaded hits", e5);
                                m4772Z0();
                                try {
                                    this.f3302R.m3758K0();
                                    this.f3302R.m3755H0();
                                    return false;
                                } catch (SQLiteException e6) {
                                    m8674w0("Failed to commit local dispatch transaction", e6);
                                    m4772Z0();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.f3302R.m3758K0();
                                this.f3302R.m3755H0();
                                return false;
                            } catch (SQLiteException e7) {
                                m8674w0("Failed to commit local dispatch transaction", e7);
                                m4772Z0();
                                return false;
                            }
                        }
                        try {
                            this.f3302R.m3758K0();
                            this.f3302R.m3755H0();
                        } catch (SQLiteException e8) {
                            m8674w0("Failed to commit local dispatch transaction", e8);
                            m4772Z0();
                            return false;
                        }
                    } catch (SQLiteException e9) {
                        m8672t0("Failed to read hits from persisted store", e9);
                        m4772Z0();
                        try {
                            this.f3302R.m3758K0();
                            this.f3302R.m3755H0();
                            return false;
                        } catch (SQLiteException e10) {
                            m8674w0("Failed to commit local dispatch transaction", e10);
                            m4772Z0();
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    this.f3302R.m3758K0();
                    this.f3302R.m3755H0();
                    throw th;
                }
                this.f3302R.m3758K0();
                this.f3302R.m3755H0();
                throw th;
            } catch (SQLiteException e11) {
                m8674w0("Failed to commit local dispatch transaction", e11);
                m4772Z0();
                return false;
            }
        }
    }

    /* renamed from: W0 */
    public final void m4769W0() {
        C1434k4.m5823i();
        m8878F0();
        m8678y0("Sync dispatching local hits");
        long j = this.f3310Z;
        m4767U0();
        try {
            m4768V0();
            m8667o0().m7038K0();
            m4770X0();
            if (this.f3310Z != j) {
                this.f3304T.m6163e();
            }
        } catch (Exception e) {
            m8674w0("Sync local dispatch failed", e);
            m4770X0();
        }
    }

    /* renamed from: X0 */
    public final void m4770X0() {
        long min;
        C1434k4.m5823i();
        m8878F0();
        boolean z = true;
        if (!(!this.f3311a0 && m4773a1() > 0)) {
            this.f3304T.m6160b();
            m4772Z0();
            return;
        }
        if (this.f3302R.m3757J0()) {
            this.f3304T.m6160b();
            m4772Z0();
            return;
        }
        if (!C0770bh.f1700y.m2801a().booleanValue()) {
            this.f3304T.m6161c();
            z = this.f3304T.m6159a();
        }
        if (!z) {
            m4772Z0();
            m4771Y0();
            return;
        }
        m4771Y0();
        long m4773a1 = m4773a1();
        long m7037J0 = m8667o0().m7037J0();
        if (m7037J0 != 0) {
            min = m4773a1 - Math.abs(m8659g0().mo1177a() - m7037J0);
            if (min <= 0) {
                min = Math.min(C2007ug.m8881d(), m4773a1);
            }
        } else {
            min = Math.min(C2007ug.m8881d(), m4773a1);
        }
        m8679z("Dispatch scheduled (ms)", Long.valueOf(min));
        if (this.f3307W.m9500g()) {
            this.f3307W.m9502i(Math.max(1L, min + this.f3307W.m9499f()));
        } else {
            this.f3307W.m9501h(min);
        }
    }

    /* renamed from: Y0 */
    public final void m4771Y0() {
        C2425zg m8665m0 = m8665m0();
        if (m8665m0.m10452J0() && !m8665m0.m10451I0()) {
            long m4763Q0 = m4763Q0();
            if (m4763Q0 == 0 || Math.abs(m8659g0().mo1177a() - m4763Q0) > C0770bh.f1682g.m2801a().longValue()) {
                return;
            }
            m8679z("Dispatch alarm scheduled (ms)", Long.valueOf(C2007ug.m8882e()));
            m8665m0.m10453K0();
        }
    }

    /* renamed from: Z0 */
    public final void m4772Z0() {
        if (this.f3307W.m9500g()) {
            m8676x0("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f3307W.m9497a();
        C2425zg m8665m0 = m8665m0();
        if (m8665m0.m10451I0()) {
            m8665m0.m10449G0();
        }
    }

    /* renamed from: a1 */
    public final long m4773a1() {
        long j = this.f3306V;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long longValue = C0770bh.f1679d.m2801a().longValue();
        C0771bi m8666n0 = m8666n0();
        m8666n0.m8878F0();
        if (!m8666n0.f1707S) {
            return longValue;
        }
        m8666n0().m8878F0();
        return r0.f1708T * 1000;
    }

    /* renamed from: b1 */
    public final void m4774b1() {
        m8878F0();
        C1434k4.m5823i();
        this.f3311a0 = true;
        this.f3305U.m2055H0();
        m4770X0();
    }

    /* renamed from: c1 */
    public final boolean m4775c1(String str) {
        return C2272xc.m9755a(m8675x()).m9464a(str) == 0;
    }
}
