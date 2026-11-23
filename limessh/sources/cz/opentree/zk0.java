package cz.opentree;

import android.content.Context;
import android.util.LruCache;
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.User;
import cz.opentree.qg0;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LruSessionCache.java */
/* loaded from: classes.dex */
public class zk0 extends LruCache<String, Object> {
    public zk0() {
        super(5);
    }

    /* renamed from: a */
    public synchronized void m10492a(Context context) {
        Config.m5462h("session:cache", qg0.m7702c(new JSONObject(snapshot()).toString(), User.m5527u(context)), context);
    }

    /* renamed from: b */
    public int m10493b(Context context) {
        if (get("pinlock:attempts") == null) {
            m10498g(context);
        }
        if (get("pinlock:attempts") == null) {
            return 5;
        }
        return Integer.valueOf(String.valueOf(get("pinlock:attempts"))).intValue();
    }

    /* renamed from: c */
    public boolean m10494c(Context context) {
        if (get("pinlock:enabled") == null) {
            m10498g(context);
        }
        if (get("pinlock:enabled") == null) {
            return false;
        }
        return Boolean.valueOf(String.valueOf(get("pinlock:enabled"))).booleanValue();
    }

    /* renamed from: d */
    public long m10495d(Context context) {
        if (get("pinlock:timeout") == null) {
            m10498g(context);
        }
        return get("pinlock:timeout") == null ? System.currentTimeMillis() : Long.valueOf(String.valueOf(get("pinlock:timeout"))).longValue();
    }

    /* renamed from: e */
    public long m10496e(Context context) {
        if (get("session:timeout") == null) {
            m10498g(context);
        }
        if (get("session:timeout") == null) {
            return 300000L;
        }
        return Long.valueOf(String.valueOf(get("session:timeout"))).longValue();
    }

    /* renamed from: f */
    public int m10497f(Context context) {
        if (get("version:code") == null) {
            m10498g(context);
        }
        if (get("version:code") == null) {
            return 0;
        }
        return Integer.valueOf(String.valueOf(get("version:code"))).intValue();
    }

    /* renamed from: g */
    public synchronized void m10498g(Context context) {
        evictAll();
        try {
            try {
                JSONObject jSONObject = new JSONObject(qg0.m7700a(Config.m5458d("session:cache", context), User.m5527u(context)));
                if (jSONObject.length() > 5) {
                    gj0.m4142c("LruSessionCache", "Number of retrieved cache items is larger than cache size " + jSONObject.length() + "/5");
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    put(obj, jSONObject.get(obj));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (qg0.C1762a e2) {
            e2.printStackTrace();
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: h */
    public void m10499h(Context context, int i) {
        if (size() == 0) {
            m10498g(context);
        }
        put("pinlock:attempts", Integer.valueOf(i));
        m10492a(context);
    }

    /* renamed from: i */
    public void m10500i(Context context, int i, long j) {
        if (size() == 0) {
            m10498g(context);
        }
        put("pinlock:attempts", Integer.valueOf(i));
        put("pinlock:timeout", Long.valueOf(j));
        m10492a(context);
    }

    /* renamed from: j */
    public void m10501j(Context context, boolean z) {
        if (size() == 0) {
            m10498g(context);
        }
        put("pinlock:enabled", Boolean.valueOf(z));
        m10492a(context);
    }

    /* renamed from: k */
    public void m10502k(Context context, long j) {
        if (size() == 0) {
            m10498g(context);
        }
        put("pinlock:timeout", Long.valueOf(j));
        m10492a(context);
    }

    /* renamed from: l */
    public void m10503l(Context context, int i) {
        if (size() == 0) {
            m10498g(context);
        }
        put("version:code", Integer.valueOf(i));
        m10492a(context);
    }
}
