package cz.opentree;

import android.net.NetworkInfo;
import cz.opentree.bm0;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PicassoExecutorService.java */
/* loaded from: classes.dex */
public class tl0 extends ThreadPoolExecutor {
    public tl0() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new bm0.ThreadFactoryC0788e());
    }

    /* renamed from: a */
    public void m8761a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m8762b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                m8762b(4);
                return;
            } else {
                m8762b(3);
                return;
            }
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                m8762b(1);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                        m8762b(3);
                        return;
                    default:
                        m8762b(3);
                        return;
                }
        }
        m8762b(2);
    }

    /* renamed from: b */
    public final void m8762b(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }
}
