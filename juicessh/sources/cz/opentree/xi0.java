package cz.opentree;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.MainActivity;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.TeamMembership;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: PostProcessor.java */
/* loaded from: classes.dex */
public class xi0 {

    /* renamed from: a */
    public Context f7956a;

    /* renamed from: b */
    public NotificationManager f7957b;

    /* renamed from: c */
    public User f7958c;

    /* renamed from: d */
    public ArrayList<BaseModel<?>> f7959d = new ArrayList<>();

    /* renamed from: e */
    public ArrayList<BaseModel<?>> f7960e = new ArrayList<>();

    /* renamed from: f */
    public ArrayList<BaseModel<?>> f7961f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<BaseModel<?>> f7962g = new ArrayList<>();

    /* compiled from: PostProcessor.java */
    /* renamed from: cz.opentree.xi0$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2290a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f7963a;

        static {
            int[] iArr = new int[EnumC2291b.values().length];
            f7963a = iArr;
            try {
                iArr[EnumC2291b.MODE_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7963a[EnumC2291b.MODE_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7963a[EnumC2291b.MODE_DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7963a[EnumC2291b.MODE_UNCHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PostProcessor.java */
    /* renamed from: cz.opentree.xi0$b */
    /* loaded from: classes.dex */
    public enum EnumC2291b {
        MODE_CREATED,
        MODE_UPDATED,
        MODE_DELETED,
        MODE_UNCHANGED
    }

    public xi0(User user, Context context) {
        this.f7956a = context;
        this.f7958c = user;
        this.f7957b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    public <T> void m9775a(EnumC2291b enumC2291b, BaseModel<?> baseModel, BaseModel<?> baseModel2) {
        int i = C2290a.f7963a[enumC2291b.ordinal()];
        if (i == 1) {
            this.f7959d.add(baseModel2);
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.f7961f.add(baseModel);
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.f7962g.add(baseModel);
                return;
            }
        }
        this.f7960e.add(baseModel2);
        if (!baseModel2.getClass().getName().equals("cz.opentree.juicessh.models.TeamMembership") || baseModel == null || baseModel2 == null) {
            return;
        }
        TeamMembership teamMembership = (TeamMembership) baseModel;
        TeamMembership teamMembership2 = (TeamMembership) baseModel2;
        User user = teamMembership2.user;
        if (user == null || user.f3993id.toString().equals(this.f7958c.f3993id.toString()) || teamMembership.accepted || !teamMembership2.accepted) {
            return;
        }
        teamMembership2.m5516t(this.f7958c, this.f7956a);
    }

    /* renamed from: b */
    public void m9776b(int i) {
        if (i < 1 || !Boolean.parseBoolean(Config.m5458d("notifications:enabled", this.f7956a))) {
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(this.f7956a, 0, new Intent(this.f7956a, (Class<?>) MainActivity.class), 0);
        String str = this.f7956a.getString(R.string.app_name) + ": " + this.f7956a.getString(R.string.cloudsync);
        String format = String.format(this.f7956a.getString(R.string.restored_x_items_from_backup), Integer.valueOf(i));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f7956a);
        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentTitle(str);
        builder.setContentText(format);
        builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(false);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        this.f7957b.notify(wi0.m9568a(wi0.EnumC2225a.NOTIFICATION_CLOUDSYNC_RESTORED), builder.build());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:11|(1:(2:14|(2:16|(2:18|19)(2:31|27))(2:32|33))(2:34|35))(2:36|37)|20|21|22|(1:24)(1:28)|25|26|27|9) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x012a, code lost:
    
        r4.setSmallIcon(cz.opentree.juicessh.R.drawable.ic_notification);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m9777c(java.util.HashMap<cz.opentree.juicessh.models.User, java.util.HashMap<cz.opentree.xi0.EnumC2291b, java.util.ArrayList<cz.opentree.juicessh.p002db.BaseModel<?>>>> r14) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.xi0.m9777c(java.util.HashMap):void");
    }

    /* renamed from: d */
    public void m9778d() {
        HashMap<User, HashMap<EnumC2291b, ArrayList<BaseModel<?>>>> hashMap = new HashMap<>();
        m9779e(this.f7962g, EnumC2291b.MODE_UNCHANGED, this.f7958c, hashMap);
        m9779e(this.f7959d, EnumC2291b.MODE_CREATED, this.f7958c, hashMap);
        m9779e(this.f7960e, EnumC2291b.MODE_UPDATED, this.f7958c, hashMap);
        m9779e(this.f7961f, EnumC2291b.MODE_DELETED, this.f7958c, hashMap);
        for (User user : hashMap.keySet()) {
            gj0.m4141b("CloudSyncPostProcessor", user.name + " <" + user.email + ">:");
            for (EnumC2291b enumC2291b : hashMap.get(user).keySet()) {
                gj0.m4141b("CloudSyncPostProcessor", "   - " + enumC2291b.toString());
                Iterator<BaseModel<?>> it = hashMap.get(user).get(enumC2291b).iterator();
                while (it.hasNext()) {
                    BaseModel<?> next = it.next();
                    gj0.m4141b("CloudSyncPostProcessor", "      - " + next.f3993id + " / " + next.getClass().getName());
                }
            }
        }
        int i = 0;
        Iterator<User> it2 = hashMap.keySet().iterator();
        while (it2.hasNext()) {
            User next2 = it2.next();
            if (next2.f3993id.toString().equals(this.f7958c.f3993id.toString())) {
                HashMap<EnumC2291b, ArrayList<BaseModel<?>>> hashMap2 = hashMap.get(next2);
                EnumC2291b enumC2291b2 = EnumC2291b.MODE_CREATED;
                if (hashMap2.containsKey(enumC2291b2)) {
                    i += hashMap.get(next2).get(enumC2291b2).size();
                }
                HashMap<EnumC2291b, ArrayList<BaseModel<?>>> hashMap3 = hashMap.get(next2);
                EnumC2291b enumC2291b3 = EnumC2291b.MODE_UPDATED;
                if (hashMap3.containsKey(enumC2291b3)) {
                    i += hashMap.get(next2).get(enumC2291b3).size();
                }
                it2.remove();
            }
        }
        m9776b(i);
        m9777c(hashMap);
    }

    /* renamed from: e */
    public HashMap<User, HashMap<EnumC2291b, ArrayList<BaseModel<?>>>> m9779e(ArrayList<BaseModel<?>> arrayList, EnumC2291b enumC2291b, User user, HashMap<User, HashMap<EnumC2291b, ArrayList<BaseModel<?>>>> hashMap) {
        Iterator<BaseModel<?>> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseModel<?> next = it.next();
            if (next.isEncrypted) {
                User user2 = next.lastUpdatedBy;
                if (user2 == null || user2.m5383m() == null) {
                    next.lastUpdatedBy = user;
                }
                User user3 = null;
                for (User user4 : hashMap.keySet()) {
                    if (user4.f3993id.toString().equals(next.lastUpdatedBy.f3993id.toString())) {
                        user3 = user4;
                    }
                }
                if (user3 == null) {
                    user3 = next.lastUpdatedBy;
                    hashMap.put(user3, new HashMap<>());
                }
                if (!hashMap.get(user3).containsKey(enumC2291b)) {
                    hashMap.get(user3).put(enumC2291b, new ArrayList<>());
                }
                if (!hashMap.get(user3).get(enumC2291b).contains(next)) {
                    hashMap.get(user3).get(enumC2291b).add(next);
                }
            }
        }
        return hashMap;
    }
}
