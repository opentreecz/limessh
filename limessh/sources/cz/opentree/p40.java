package cz.opentree;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import cz.opentree.C1610nk;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class p40 {

    /* renamed from: a */
    public C1610nk f5620a;

    /* renamed from: b */
    public Long f5621b;

    /* renamed from: c */
    public long f5622c;

    /* renamed from: d */
    public final /* synthetic */ o40 f5623d;

    public p40(o40 o40Var) {
        this.f5623d = o40Var;
    }

    public /* synthetic */ p40(o40 o40Var, n40 n40Var) {
        this(o40Var);
    }

    /* renamed from: a */
    public final C1610nk m7243a(String str, C1610nk c1610nk) {
        Object obj;
        String m6709W = c1610nk.m6709W();
        List<C1722pk> m6700E = c1610nk.m6700E();
        Long l = (Long) this.f5623d.m9686p().m3143V(c1610nk, "_eid");
        boolean z = l != null;
        if (z && m6709W.equals("_ep")) {
            m6709W = (String) this.f5623d.m9686p().m3143V(c1610nk, "_en");
            if (TextUtils.isEmpty(m6709W)) {
                this.f5623d.mo1484j().m8523I().m9084b("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.f5620a == null || this.f5621b == null || l.longValue() != this.f5621b.longValue()) {
                Pair<C1610nk, Long> m2993B = this.f5623d.m9687q().m2993B(str, l);
                if (m2993B == null || (obj = m2993B.first) == null) {
                    this.f5623d.mo1484j().m8523I().m9085c("Extra parameter without existing main event. eventName, eventId", m6709W, l);
                    return null;
                }
                this.f5620a = (C1610nk) obj;
                this.f5622c = ((Long) m2993B.second).longValue();
                this.f5621b = (Long) this.f5623d.m9686p().m3143V(this.f5620a, "_eid");
            }
            long j = this.f5622c - 1;
            this.f5622c = j;
            if (j <= 0) {
                C0845cu m9687q = this.f5623d.m9687q();
                m9687q.mo7585d();
                m9687q.mo1484j().m8530P().m9084b("Clearing complex main event info. appId", str);
                try {
                    m9687q.m3038x().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    m9687q.mo1484j().m8522H().m9084b("Error clearing complex main event", e);
                }
            } else {
                this.f5623d.m9687q().m3019X(str, l, this.f5622c, this.f5620a);
            }
            ArrayList arrayList = new ArrayList();
            for (C1722pk c1722pk : this.f5620a.m6700E()) {
                this.f5623d.m9686p();
                if (d40.m3131z(c1610nk, c1722pk.m7363P()) == null) {
                    arrayList.add(c1722pk);
                }
            }
            if (arrayList.isEmpty()) {
                this.f5623d.mo1484j().m8523I().m9084b("No unique parameters in main event. eventName", m6709W);
            } else {
                arrayList.addAll(m6700E);
                m6700E = arrayList;
            }
        } else if (z) {
            this.f5621b = l;
            this.f5620a = c1610nk;
            Object m3143V = this.f5623d.m9686p().m3143V(c1610nk, "_epc");
            long longValue = ((Long) (m3143V != null ? m3143V : 0L)).longValue();
            this.f5622c = longValue;
            if (longValue <= 0) {
                this.f5623d.mo1484j().m8523I().m9084b("Complex event with zero extra param count. eventName", m6709W);
            } else {
                this.f5623d.m9687q().m3019X(str, l, this.f5622c, c1610nk);
            }
        }
        C1610nk.a m9840z = c1610nk.m9840z();
        m9840z.m6720C(m6709W);
        m9840z.m6726I();
        m9840z.m6719B(m6700E);
        return (C1610nk) ((AbstractC2303xn) m9840z.mo1259f());
    }
}
