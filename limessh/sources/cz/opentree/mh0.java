package cz.opentree;

import android.content.Context;
import cz.opentree.limessh.models.Host;
import cz.opentree.limessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/* compiled from: HostKeyAdapter.java */
/* loaded from: classes.dex */
public class mh0 {

    /* renamed from: a */
    public Context f5039a;

    /* renamed from: b */
    public String f5040b;

    /* renamed from: c */
    public String f5041c;

    /* renamed from: d */
    public String f5042d;

    /* compiled from: HostKeyAdapter.java */
    /* renamed from: cz.opentree.mh0$a */
    /* loaded from: classes.dex */
    public enum EnumC1553a {
        OKAY,
        CHANGED,
        NOT_SEEN
    }

    public mh0(Context context, String str, String str2, String str3) {
        this.f5039a = context;
        this.f5040b = str;
        this.f5041c = str2;
        this.f5042d = str3;
    }

    /* renamed from: a */
    public void m6422a() {
        try {
            Host host = new Host();
            host.hostname = this.f5040b;
            host.fingerprint = this.f5041c;
            host.key = this.f5042d;
            C1328DB.m5404d(Host.class, this.f5039a).createOrUpdate(host);
        } catch (SQLException e) {
            gj0.m4142c("Adapters/HostKeyAdapter", "Failed saving host key");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public EnumC1553a m6423b() {
        if (this.f5040b.contains("[127.0.0.1]:") || this.f5040b.contains("[localhost]:")) {
            return EnumC1553a.OKAY;
        }
        try {
            List queryForEq = C1328DB.m5404d(Host.class, this.f5039a).queryForEq("hostname", this.f5040b);
            if (queryForEq.size() <= 0) {
                return EnumC1553a.NOT_SEEN;
            }
            Iterator it = queryForEq.iterator();
            while (it.hasNext()) {
                if (((Host) it.next()).key.equals(this.f5042d)) {
                    return EnumC1553a.OKAY;
                }
            }
            return EnumC1553a.CHANGED;
        } catch (SQLException e) {
            gj0.m4142c("Adapters/HostKeyAdapter", "Failed to check if host key exists");
            e.printStackTrace();
            return EnumC1553a.NOT_SEEN;
        }
    }
}
