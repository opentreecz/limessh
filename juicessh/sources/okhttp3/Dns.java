package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public interface Dns {

    /* renamed from: a */
    public static final Dns f8653a = new C2483a();

    /* renamed from: okhttp3.Dns$a */
    /* loaded from: classes.dex */
    public class C2483a implements Dns {
        @Override // okhttp3.Dns
        /* renamed from: a */
        public List<InetAddress> mo10698a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    }

    /* renamed from: a */
    List<InetAddress> mo10698a(String str) throws UnknownHostException;
}
