package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.j256.ormlite.field.FieldType;
import com.sonelli.AbstractC0749b2;
import com.sonelli.AbstractC0906e0;
import com.sonelli.AbstractC1022g2;
import com.sonelli.AbstractC1138i0;
import com.sonelli.C0746b;
import com.sonelli.C0855d0;
import com.sonelli.C0966f3;
import com.sonelli.C1091h2;
import com.sonelli.C1140i2;
import com.sonelli.C1193j2;
import com.sonelli.C1422k2;
import com.sonelli.C1485l2;
import com.sonelli.C1486l3;
import com.sonelli.C1534m2;
import com.sonelli.C1585n2;
import com.sonelli.C1630o2;
import com.sonelli.C1687p2;
import com.sonelli.C1745q2;
import com.sonelli.C1797r2;
import com.sonelli.C1843s2;
import com.sonelli.C1895t2;
import com.sonelli.C1991u2;
import com.sonelli.C2148v2;
import com.sonelli.C2196w2;
import com.sonelli.C2253x0;
import com.sonelli.C2255x2;
import com.sonelli.C2322y2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
@WorkerThread
/* loaded from: classes.dex */
public class SQLiteEventStore implements EventStore, SynchronizationGuard {

    /* renamed from: S */
    public static final C0746b f514S = C0746b.m2321b("proto");

    /* renamed from: O */
    public final SchemaManager f515O;

    /* renamed from: P */
    public final Clock f516P;

    /* renamed from: Q */
    public final Clock f517Q;

    /* renamed from: R */
    public final AbstractC0749b2 f518R;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes.dex */
    public interface Function<T, U> {
        U apply(T t);
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes.dex */
    public interface Producer<T> {
        /* renamed from: a */
        T mo798a();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$b */
    /* loaded from: classes.dex */
    public static class C0421b {

        /* renamed from: a */
        public final String f519a;

        /* renamed from: b */
        public final String f520b;

        public C0421b(String str, String str2) {
            this.f519a = str;
            this.f520b = str2;
        }
    }

    public SQLiteEventStore(Clock clock, Clock clock2, AbstractC0749b2 abstractC0749b2, SchemaManager schemaManager) {
        this.f515O = schemaManager;
        this.f516P = clock;
        this.f517Q = clock2;
        this.f518R = abstractC0749b2;
    }

    /* renamed from: D */
    public static /* synthetic */ Object m764D(Throwable th) {
        throw new C0966f3("Timed out while trying to acquire the lock.", th);
    }

    /* renamed from: K */
    public static /* synthetic */ SQLiteDatabase m765K(Throwable th) {
        throw new C0966f3("Timed out while trying to open db.", th);
    }

    /* renamed from: Y */
    public static /* synthetic */ Long m766Y(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* renamed from: Z */
    public static /* synthetic */ Long m767Z(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* renamed from: a0 */
    public static /* synthetic */ Boolean m768a0(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0, SQLiteDatabase sQLiteDatabase) {
        Long m791l = sQLiteEventStore.m791l(sQLiteDatabase, abstractC1138i0);
        return m791l == null ? Boolean.FALSE : (Boolean) m781r0(sQLiteEventStore.m787d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{m791l.toString()}), C1843s2.m8306a());
    }

    /* renamed from: b0 */
    public static /* synthetic */ List m769b0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            AbstractC1138i0.a m4681a = AbstractC1138i0.m4681a();
            m4681a.mo2327b(cursor.getString(1));
            m4681a.mo2329d(C1486l3.m6047b(cursor.getInt(2)));
            m4681a.mo2328c(m778m0(cursor.getString(3)));
            arrayList.add(m4681a.mo2326a());
        }
        return arrayList;
    }

    /* renamed from: c0 */
    public static /* synthetic */ List m770c0(SQLiteDatabase sQLiteDatabase) {
        return (List) m781r0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C1797r2.m7850a());
    }

    /* renamed from: d0 */
    public static /* synthetic */ List m771d0(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0, SQLiteDatabase sQLiteDatabase) {
        List<AbstractC1022g2> m790k0 = sQLiteEventStore.m790k0(sQLiteDatabase, abstractC1138i0);
        sQLiteEventStore.m797x(m790k0, sQLiteEventStore.m792l0(sQLiteDatabase, m790k0));
        return m790k0;
    }

    /* renamed from: e0 */
    public static /* synthetic */ Object m772e0(SQLiteEventStore sQLiteEventStore, List list, AbstractC1138i0 abstractC1138i0, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            AbstractC0906e0.a m3349a = AbstractC0906e0.m3349a();
            m3349a.mo3370j(cursor.getString(1));
            m3349a.mo3369i(cursor.getLong(2));
            m3349a.mo3371k(cursor.getLong(3));
            if (z) {
                m3349a.mo3368h(new C0855d0(m779p0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                m3349a.mo3368h(new C0855d0(m779p0(cursor.getString(4)), sQLiteEventStore.m794n0(j)));
            }
            if (!cursor.isNull(6)) {
                m3349a.mo3367g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(AbstractC1022g2.m3931a(j, abstractC1138i0, m3349a.mo3364d()));
        }
        return null;
    }

    /* renamed from: f0 */
    public static /* synthetic */ Object m773f0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new C0421b(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* renamed from: g0 */
    public static /* synthetic */ Long m774g0(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0, SQLiteDatabase sQLiteDatabase) {
        if (sQLiteEventStore.m796p()) {
            return -1L;
        }
        long m786c = sQLiteEventStore.m786c(sQLiteDatabase, abstractC1138i0);
        int mo2348e = sQLiteEventStore.f518R.mo2348e();
        byte[] m3083a = abstractC0906e0.mo3353e().m3083a();
        boolean z = m3083a.length <= mo2348e;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(m786c));
        contentValues.put("transport_name", abstractC0906e0.mo3358j());
        contentValues.put("timestamp_ms", Long.valueOf(abstractC0906e0.mo3354f()));
        contentValues.put("uptime_ms", Long.valueOf(abstractC0906e0.mo3359k()));
        contentValues.put("payload_encoding", abstractC0906e0.mo3353e().m3084b().m2322a());
        contentValues.put("code", abstractC0906e0.mo3352d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? m3083a : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(m3083a.length / mo2348e);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(m3083a, (i - 1) * mo2348e, Math.min(i * mo2348e, m3083a.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : abstractC0906e0.m3357i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* renamed from: h0 */
    public static /* synthetic */ byte[] m775h0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* renamed from: i0 */
    public static /* synthetic */ Object m776i0(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    /* renamed from: j0 */
    public static /* synthetic */ Object m777j0(long j, AbstractC1138i0 abstractC1138i0, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{abstractC1138i0.mo2323b(), String.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d()))}) < 1) {
            contentValues.put("backend_name", abstractC1138i0.mo2323b());
            contentValues.put("priority", Integer.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* renamed from: m0 */
    public static byte[] m778m0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* renamed from: p0 */
    public static C0746b m779p0(@Nullable String str) {
        return str == null ? f514S : C0746b.m2321b(str);
    }

    /* renamed from: q0 */
    public static String m780q0(Iterable<AbstractC1022g2> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<AbstractC1022g2> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo1952c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: r0 */
    public static <T> T m781r0(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* renamed from: z */
    public static /* synthetic */ Object m783z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    @Nullable
    /* renamed from: M */
    public AbstractC1022g2 mo755M(AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        C2253x0.m9657b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", abstractC1138i0.mo2325d(), abstractC0906e0.mo3358j(), abstractC1138i0.mo2323b());
        long longValue = ((Long) m793n(C1991u2.m8833a(this, abstractC1138i0, abstractC0906e0))).longValue();
        if (longValue < 1) {
            return null;
        }
        return AbstractC1022g2.m3931a(longValue, abstractC1138i0, abstractC0906e0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: Q */
    public long mo756Q(AbstractC1138i0 abstractC1138i0) {
        return ((Long) m781r0(m787d().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{abstractC1138i0.mo2323b(), String.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d()))}), C2255x2.m9673a())).longValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: S */
    public boolean mo757S(AbstractC1138i0 abstractC1138i0) {
        return ((Boolean) m793n(C2322y2.m10050a(this, abstractC1138i0))).booleanValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: T */
    public void mo758T(Iterable<AbstractC1022g2> iterable) {
        if (iterable.iterator().hasNext()) {
            m793n(C2196w2.m9389a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + m780q0(iterable)));
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    /* renamed from: a */
    public <T> T mo784a(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase m787d = m787d();
        m785b(m787d);
        try {
            T mo806h = criticalSection.mo806h();
            m787d.setTransactionSuccessful();
            return mo806h;
        } finally {
            m787d.endTransaction();
        }
    }

    /* renamed from: b */
    public final void m785b(SQLiteDatabase sQLiteDatabase) {
        m795o0(C1630o2.m6835b(sQLiteDatabase), C1687p2.m7220a());
    }

    /* renamed from: c */
    public final long m786c(SQLiteDatabase sQLiteDatabase, AbstractC1138i0 abstractC1138i0) {
        Long m791l = m791l(sQLiteDatabase, abstractC1138i0);
        if (m791l != null) {
            return m791l.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", abstractC1138i0.mo2323b());
        contentValues.put("priority", Integer.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (abstractC1138i0.mo2324c() != null) {
            contentValues.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(abstractC1138i0.mo2324c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f515O.close();
    }

    @VisibleForTesting
    /* renamed from: d */
    public SQLiteDatabase m787d() {
        SchemaManager schemaManager = this.f515O;
        schemaManager.getClass();
        return (SQLiteDatabase) m795o0(C1745q2.m7603b(schemaManager), C1895t2.m8577a());
    }

    /* renamed from: f */
    public final long m788f() {
        return m787d().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* renamed from: h */
    public final long m789h() {
        return m787d().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: i */
    public int mo759i() {
        return ((Integer) m793n(C1422k2.m5790a(this.f516P.mo807a() - this.f518R.mo2346c()))).intValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: j */
    public void mo760j(Iterable<AbstractC1022g2> iterable) {
        if (iterable.iterator().hasNext()) {
            m787d().compileStatement("DELETE FROM events WHERE _id in " + m780q0(iterable)).execute();
        }
    }

    /* renamed from: k0 */
    public final List<AbstractC1022g2> m790k0(SQLiteDatabase sQLiteDatabase, AbstractC1138i0 abstractC1138i0) {
        ArrayList arrayList = new ArrayList();
        Long m791l = m791l(sQLiteDatabase, abstractC1138i0);
        if (m791l == null) {
            return arrayList;
        }
        m781r0(sQLiteDatabase.query("events", new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{m791l.toString()}, null, null, null, String.valueOf(this.f518R.mo2347d())), C1485l2.m6044a(this, arrayList, abstractC1138i0));
        return arrayList;
    }

    @Nullable
    /* renamed from: l */
    public final Long m791l(SQLiteDatabase sQLiteDatabase, AbstractC1138i0 abstractC1138i0) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(abstractC1138i0.mo2323b(), String.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d()))));
        if (abstractC1138i0.mo2324c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(abstractC1138i0.mo2324c(), 0));
        }
        return (Long) m781r0(sQLiteDatabase.query("transport_contexts", new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), C2148v2.m9146a());
    }

    /* renamed from: l0 */
    public final Map<Long, Set<C0421b>> m792l0(SQLiteDatabase sQLiteDatabase, List<AbstractC1022g2> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).mo1952c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        m781r0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), C1585n2.m6627a(hashMap));
        return hashMap;
    }

    /* renamed from: n */
    public final <T> T m793n(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase m787d = m787d();
        m787d.beginTransaction();
        try {
            T apply = function.apply(m787d);
            m787d.setTransactionSuccessful();
            return apply;
        } finally {
            m787d.endTransaction();
        }
    }

    /* renamed from: n0 */
    public final byte[] m794n0(long j) {
        return (byte[]) m781r0(m787d().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), C1534m2.m6339a());
    }

    /* renamed from: o0 */
    public final <T> T m795o0(Producer<T> producer, Function<Throwable, T> function) {
        long mo807a = this.f517Q.mo807a();
        while (true) {
            try {
                return producer.mo798a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f517Q.mo807a() >= this.f518R.mo2345b() + mo807a) {
                    return function.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    /* renamed from: p */
    public final boolean m796p() {
        return m788f() * m789h() >= this.f518R.mo2349f();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: q */
    public Iterable<AbstractC1022g2> mo761q(AbstractC1138i0 abstractC1138i0) {
        return (Iterable) m793n(C1140i2.m4707a(this, abstractC1138i0));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: r */
    public void mo762r(AbstractC1138i0 abstractC1138i0, long j) {
        m793n(C1091h2.m4342a(j, abstractC1138i0));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    /* renamed from: u */
    public Iterable<AbstractC1138i0> mo763u() {
        return (Iterable) m793n(C1193j2.m5035a());
    }

    /* renamed from: x */
    public final List<AbstractC1022g2> m797x(List<AbstractC1022g2> list, Map<Long, Set<C0421b>> map) {
        ListIterator<AbstractC1022g2> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC1022g2 next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.mo1952c()))) {
                AbstractC0906e0.a m3360l = next.mo1951b().m3360l();
                for (C0421b c0421b : map.get(Long.valueOf(next.mo1952c()))) {
                    m3360l.m3363c(c0421b.f519a, c0421b.f520b);
                }
                listIterator.set(AbstractC1022g2.m3931a(next.mo1952c(), next.mo1953d(), m3360l.mo3364d()));
            }
        }
        return list;
    }
}
