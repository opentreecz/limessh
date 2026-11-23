package cz.opentree;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NotificationTracker.java */
/* loaded from: classes.dex */
public class wi0 {

    /* renamed from: d */
    public static wi0 f7733d;

    /* renamed from: a */
    public AtomicInteger f7734a;

    /* renamed from: b */
    public HashMap<UUID, HashMap<EnumC2225a, Integer>> f7735b;

    /* renamed from: c */
    public UUID f7736c;

    /* compiled from: NotificationTracker.java */
    /* renamed from: cz.opentree.wi0$a */
    /* loaded from: classes.dex */
    public enum EnumC2225a {
        NOTIFICATION_TEST,
        NOTIFICATION_CLOUDSYNC_RESTORED,
        NOTIFICATION_CLOUDSYNC_UPDATED,
        NOTIFICATION_CLOUDSYNC_PASSWORD_INCORRECT,
        NOTIFICATION_NEW_TEAM_MEMBER,
        NOTIFICATION_TEAM_INVITE,
        NOTIFICATION_TEAM_UPDATES,
        NOTIFICATION_TEAM_CREATES,
        NOTIFICATION_TEAM_DELETES,
        NOTIFICATION_TEAM_UNCHANGED,
        NOTIFICATION_EC2_PROFILE_DISABLED,
        NOTIFICATION_SFTP_TRANSFER
    }

    /* renamed from: a */
    public static int m9568a(EnumC2225a enumC2225a) {
        wi0 m9570c = m9570c();
        if (!m9570c.f7735b.containsKey(m9570c.f7736c)) {
            gj0.m4141b("NotificationTracker", "Creating a first time notification for: " + enumC2225a.toString());
            m9570c.f7735b.put(m9570c.f7736c, new HashMap<>());
        }
        if (!m9570c.f7735b.get(m9570c.f7736c).containsKey(enumC2225a)) {
            m9570c.f7735b.get(m9570c.f7736c).put(enumC2225a, Integer.valueOf(m9570c.f7734a.incrementAndGet()));
        }
        int intValue = m9570c.f7735b.get(m9570c.f7736c).get(enumC2225a).intValue();
        gj0.m4141b("NotificationTracker", String.format("Got ID:%d for notification %s", Integer.valueOf(intValue), enumC2225a.toString()));
        return intValue;
    }

    /* renamed from: b */
    public static int m9569b(UUID uuid, EnumC2225a enumC2225a) {
        wi0 m9570c = m9570c();
        if (!m9570c.f7735b.containsKey(uuid)) {
            m9570c.f7735b.put(uuid, new HashMap<>());
            m9570c.f7735b.get(uuid).put(enumC2225a, Integer.valueOf(m9570c.f7734a.incrementAndGet()));
            int intValue = m9570c.f7735b.get(uuid).get(enumC2225a).intValue();
            gj0.m4141b("NotificationTracker", String.format("Returning a new id for a UUID we haven't seen before ID:%d", Integer.valueOf(intValue)));
            return intValue;
        }
        if (m9570c.f7735b.get(uuid).containsKey(enumC2225a)) {
            int intValue2 = m9570c.f7735b.get(uuid).get(enumC2225a).intValue();
            gj0.m4141b("NotificationTracker", String.format("Returning a previously generated ID:%d for %s / %s", Integer.valueOf(intValue2), uuid.toString(), enumC2225a.toString()));
            return intValue2;
        }
        m9570c.f7735b.get(uuid).put(enumC2225a, Integer.valueOf(m9570c.f7734a.incrementAndGet()));
        int intValue3 = m9570c.f7735b.get(uuid).get(enumC2225a).intValue();
        gj0.m4141b("NotificationTracker", String.format("Returning a new id for previously UUID but different type ID:%d for %s / %s", Integer.valueOf(intValue3), uuid.toString(), enumC2225a.toString()));
        return intValue3;
    }

    /* renamed from: c */
    public static wi0 m9570c() {
        wi0 wi0Var = f7733d;
        if (wi0Var != null) {
            return wi0Var;
        }
        wi0 wi0Var2 = new wi0();
        f7733d = wi0Var2;
        wi0Var2.f7734a = new AtomicInteger();
        f7733d.f7735b = new HashMap<>();
        f7733d.f7736c = UUID.randomUUID();
        return f7733d;
    }
}
