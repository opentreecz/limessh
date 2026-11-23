package com.google.android.gms.tagmanager;

import cz.opentree.k50;
import cz.opentree.v50;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class DataLayer {

    /* renamed from: g */
    public static final Object f1052g = new Object();

    /* renamed from: h */
    public static final String[] f1053h = "gtm.lifetime".split("\\.");

    /* renamed from: i */
    public static final Pattern f1054i = Pattern.compile("(\\d+)\\s*([smhd]?)");

    /* renamed from: e */
    public final zzc f1059e;

    /* renamed from: a */
    public final ConcurrentHashMap<zzb, Integer> f1055a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final Map<String, Object> f1056b = new HashMap();

    /* renamed from: c */
    public final ReentrantLock f1057c = new ReentrantLock();

    /* renamed from: d */
    public final LinkedList<Map<String, Object>> f1058d = new LinkedList<>();

    /* renamed from: f */
    public final CountDownLatch f1060f = new CountDownLatch(1);

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$a */
    /* loaded from: classes.dex */
    public static final class C0453a {

        /* renamed from: a */
        public final String f1061a;

        /* renamed from: b */
        public final Object f1062b;

        public C0453a(String str, Object obj) {
            this.f1061a = str;
            this.f1062b = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0453a)) {
                return false;
            }
            C0453a c0453a = (C0453a) obj;
            return this.f1061a.equals(c0453a.f1061a) && this.f1062b.equals(c0453a.f1062b);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f1061a.hashCode()), Integer.valueOf(this.f1062b.hashCode())});
        }

        public final String toString() {
            String str = this.f1061a;
            String obj = this.f1062b.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(obj).length());
            sb.append("Key: ");
            sb.append(str);
            sb.append(" value: ");
            sb.append(obj);
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public interface zzb {
        /* renamed from: a */
        void mo1531a(Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface zzc {
        /* renamed from: a */
        void mo1532a(zzaq zzaqVar);

        /* renamed from: b */
        void mo1533b(List<C0453a> list, long j);
    }

    public DataLayer(zzc zzcVar) {
        this.f1059e = zzcVar;
        zzcVar.mo1532a(new k50(this));
    }

    /* renamed from: f */
    public static Long m1524f(String str) {
        long j;
        Matcher matcher = f1054i.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            v50.m9169d(valueOf.length() != 0 ? "unknown _lifetime: ".concat(valueOf) : new String("unknown _lifetime: "));
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            v50.m9167b(valueOf2.length() != 0 ? "illegal number in _lifetime value: ".concat(valueOf2) : new String("illegal number in _lifetime value: "));
            j = 0;
        }
        if (j <= 0) {
            String valueOf3 = String.valueOf(str);
            v50.m9169d(valueOf3.length() != 0 ? "non-positive _lifetime: ".concat(valueOf3) : new String("non-positive _lifetime: "));
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        char charAt = group.charAt(0);
        if (charAt == 'd') {
            return Long.valueOf(j * 1000 * 60 * 60 * 24);
        }
        if (charAt == 'h') {
            return Long.valueOf(j * 1000 * 60 * 60);
        }
        if (charAt == 'm') {
            return Long.valueOf(j * 1000 * 60);
        }
        if (charAt == 's') {
            return Long.valueOf(j * 1000);
        }
        String valueOf4 = String.valueOf(str);
        v50.m9167b(valueOf4.length() != 0 ? "unknown units in _lifetime: ".concat(valueOf4) : new String("unknown units in _lifetime: "));
        return null;
    }

    /* renamed from: i */
    public static Map<String, Object> m1525i(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    /* renamed from: b */
    public final void m1526b(zzb zzbVar) {
        this.f1055a.put(zzbVar, 0);
    }

    /* renamed from: d */
    public final void m1527d(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m1527d((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m1529g((Map) obj, (Map) list2.get(i));
            } else if (obj != f1052g) {
                list2.set(i, obj);
            }
        }
    }

    /* renamed from: e */
    public final void m1528e(Map<String, Object> map, String str, Collection<C0453a> collection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String key = entry.getKey();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + str2.length() + String.valueOf(key).length());
            sb.append(str);
            sb.append(str2);
            sb.append(key);
            String sb2 = sb.toString();
            if (entry.getValue() instanceof Map) {
                m1528e((Map) entry.getValue(), sb2, collection);
            } else if (!sb2.equals("gtm.lifetime")) {
                collection.add(new C0453a(sb2, entry.getValue()));
            }
        }
    }

    /* renamed from: g */
    public final void m1529g(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m1527d((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m1529g((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    /* renamed from: h */
    public final void m1530h(Map<String, Object> map) {
        Long l;
        this.f1057c.lock();
        try {
            this.f1058d.offer(map);
            int i = 0;
            if (this.f1057c.getHoldCount() == 1) {
                int i2 = 0;
                do {
                    Map<String, Object> poll = this.f1058d.poll();
                    if (poll != null) {
                        synchronized (this.f1056b) {
                            for (String str : poll.keySet()) {
                                m1529g(m1525i(str, poll.get(str)), this.f1056b);
                            }
                        }
                        Iterator<zzb> it = this.f1055a.keySet().iterator();
                        while (it.hasNext()) {
                            it.next().mo1531a(poll);
                        }
                        i2++;
                    }
                } while (i2 <= 500);
                this.f1058d.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }
            String[] strArr = f1053h;
            int length = strArr.length;
            Object obj = map;
            while (true) {
                l = null;
                if (i >= length) {
                    break;
                }
                String str2 = strArr[i];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i++;
                }
            }
            if (obj != null) {
                l = m1524f(obj.toString());
            }
            if (l != null) {
                ArrayList arrayList = new ArrayList();
                m1528e(map, "", arrayList);
                this.f1059e.mo1533b(arrayList, l.longValue());
            }
        } finally {
            this.f1057c.unlock();
        }
    }

    public String toString() {
        String sb;
        synchronized (this.f1056b) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.f1056b.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
