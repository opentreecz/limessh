package cz.opentree;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzj;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class be0 {

    /* renamed from: g */
    public static int f1658g;

    /* renamed from: h */
    public static PendingIntent f1659h;

    /* renamed from: b */
    public final Context f1661b;

    /* renamed from: c */
    public final vd0 f1662c;

    /* renamed from: e */
    public Messenger f1664e;

    /* renamed from: f */
    public zzj f1665f;

    /* renamed from: a */
    @GuardedBy("responseCallbacks")
    public final SimpleArrayMap<String, k60<Bundle>> f1660a = new SimpleArrayMap<>();

    /* renamed from: d */
    public Messenger f1663d = new Messenger(new de0(this, Looper.getMainLooper()));

    public be0(Context context, vd0 vd0Var) {
        this.f1661b = context;
        this.f1662c = vd0Var;
    }

    /* renamed from: b */
    public static synchronized String m2449b() {
        String num;
        synchronized (be0.class) {
            int i = f1658g;
            f1658g = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* renamed from: c */
    public static synchronized void m2450c(Context context, Intent intent) {
        synchronized (be0.class) {
            if (f1659h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f1659h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f1659h);
        }
    }

    /* renamed from: a */
    public final Bundle m2452a(Bundle bundle) throws IOException {
        if (this.f1662c.m9219g() < 12000000) {
            return m2455g(bundle);
        }
        try {
            return (Bundle) Tasks.m1558a(jd0.m5102d(this.f1661b).m5106e(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if ((e.getCause() instanceof td0) && ((td0) e.getCause()).m8642a() == 4) {
                return m2455g(bundle);
            }
            return null;
        }
    }

    /* renamed from: d */
    public final void m2453d(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzj.C0667a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzj) {
                        this.f1665f = (zzj) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f1664e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf2 = String.valueOf(stringExtra);
                            Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Unexpected response string: ".concat(valueOf2) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    m2454f(group, extras);
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf3 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf3);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf4 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Received InstanceID error ".concat(valueOf4) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (this.f1660a) {
                        for (int i = 0; i < this.f1660a.size(); i++) {
                            m2454f(this.f1660a.keyAt(i), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] split = stringExtra2.split("\\|");
                if (split.length <= 2 || !"ID".equals(split[1])) {
                    String valueOf5 = String.valueOf(stringExtra2);
                    Log.w("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected structured response ".concat(valueOf5) : new String("Unexpected structured response "));
                    return;
                }
                String str = split[2];
                String str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
                m2454f(str, intent2.putExtra("error", str2).getExtras());
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    /* renamed from: f */
    public final void m2454f(String str, Bundle bundle) {
        synchronized (this.f1660a) {
            k60<Bundle> remove = this.f1660a.remove(str);
            if (remove != null) {
                remove.m5844c(bundle);
            } else {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
            }
        }
    }

    /* renamed from: g */
    public final Bundle m2455g(Bundle bundle) throws IOException {
        Bundle m2456h = m2456h(bundle);
        if (m2456h == null || !m2456h.containsKey("google.messenger")) {
            return m2456h;
        }
        Bundle m2456h2 = m2456h(bundle);
        if (m2456h2 == null || !m2456h2.containsKey("google.messenger")) {
            return m2456h2;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
    
        if (r8.f1665f != null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [cz.opentree.k60, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d0 -> B:21:0x00db). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00d6 -> B:21:0x00db). Please report as a decompilation issue!!! */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle m2456h(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.be0.m2456h(android.os.Bundle):android.os.Bundle");
    }
}
