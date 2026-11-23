package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TimingInfoFullSupport extends TimingInfo {

    /* renamed from: c */
    public final Map<String, List<TimingInfo>> f492c;

    /* renamed from: d */
    public final Map<String, Number> f493d;

    public TimingInfoFullSupport(Long l, long j, Long l2) {
        super(l, j, l2);
        this.f492c = new HashMap();
        this.f493d = new HashMap();
    }

    @Override // com.amazonaws.util.TimingInfo
    /* renamed from: a */
    public void mo686a(String str, TimingInfo timingInfo) {
        List<TimingInfo> list = this.f492c.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f492c.put(str, list);
        }
        if (timingInfo.m695k()) {
            list.add(timingInfo);
            return;
        }
        LogFactory.m237c(TimingInfoFullSupport.class).mo225a("Skip submeasurement timing info with no end time for " + str);
    }

    @Override // com.amazonaws.util.TimingInfo
    /* renamed from: d */
    public Map<String, Number> mo688d() {
        return this.f493d;
    }

    @Override // com.amazonaws.util.TimingInfo
    /* renamed from: g */
    public Map<String, List<TimingInfo>> mo691g() {
        return this.f492c;
    }

    @Override // com.amazonaws.util.TimingInfo
    /* renamed from: j */
    public void mo694j(String str) {
        mo696l(str, (m697q(str) != null ? r0.intValue() : 0) + 1);
    }

    @Override // com.amazonaws.util.TimingInfo
    /* renamed from: l */
    public void mo696l(String str, long j) {
        this.f493d.put(str, Long.valueOf(j));
    }

    /* renamed from: q */
    public Number m697q(String str) {
        return this.f493d.get(str);
    }
}
