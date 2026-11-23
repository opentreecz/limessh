package cz.opentree;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: cz.opentree.fg */
/* loaded from: classes.dex */
public final class C0986fg extends AbstractC2006uf implements Closeable {

    /* renamed from: T */
    public static final String f2678T = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");

    /* renamed from: U */
    public static final String f2679U = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");

    /* renamed from: Q */
    public final C1040gg f2680Q;

    /* renamed from: R */
    public final C2221wh f2681R;

    /* renamed from: S */
    public final C2221wh f2682S;

    public C0986fg(C2216wf c2216wf) {
        super(c2216wf);
        this.f2681R = new C2221wh(m8659g0());
        this.f2682S = new C2221wh(m8659g0());
        this.f2680Q = new C1040gg(this, c2216wf.m9475a(), "google_analytics_v4.db");
    }

    /* renamed from: X0 */
    public static String m3752X0() {
        return "google_analytics_v4.db";
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
    }

    /* renamed from: G0 */
    public final void m3754G0() {
        m8878F0();
        m3756I0().beginTransaction();
    }

    /* renamed from: H0 */
    public final void m3755H0() {
        m8878F0();
        m3756I0().endTransaction();
    }

    /* renamed from: I0 */
    public final SQLiteDatabase m3756I0() {
        try {
            return this.f2680Q.getWritableDatabase();
        } catch (SQLiteException e) {
            m8672t0("Error opening database", e);
            throw e;
        }
    }

    /* renamed from: J0 */
    public final boolean m3757J0() {
        return m3766U0() == 0;
    }

    /* renamed from: K0 */
    public final void m3758K0() {
        m8878F0();
        m3756I0().setTransactionSuccessful();
    }

    /* renamed from: L0 */
    public final long m3759L0(long j, String str, String str2) {
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        m8878F0();
        C1434k4.m5823i();
        return m3761N0("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    /* renamed from: M0 */
    public final long m3760M0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m3756I0().rawQuery(str, null);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                m8673u0("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: N0 */
    public final long m3761N0(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = m3756I0().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor == null) {
                    return 0L;
                }
                cursor.close();
                return 0L;
            } catch (SQLiteException e) {
                m8673u0("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: P0 */
    public final void m3762P0(List<Long> list) {
        C0813ca.m2729k(list);
        C1434k4.m5823i();
        m8878F0();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String sb2 = sb.toString();
        try {
            SQLiteDatabase m3756I0 = m3756I0();
            m8679z("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int delete = m3756I0.delete("hits2", sb2, null);
            if (delete != list.size()) {
                m8655b0("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
            }
        } catch (SQLiteException e) {
            m8674w0("Error deleting hits", e);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
    
        r9.add(java.lang.Long.valueOf(r10.getLong(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r10.moveToNext() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r10.moveToFirst() != false) goto L9;
     */
    /* renamed from: R0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.Long> m3763R0(long r14) {
        /*
            r13 = this;
            java.lang.String r0 = "hit_id"
            cz.opentree.C1434k4.m5823i()
            r13.m8878F0()
            r1 = 0
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 > 0) goto L13
            java.util.List r14 = java.util.Collections.emptyList()
            return r14
        L13:
            android.database.sqlite.SQLiteDatabase r1 = r13.m3756I0()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            java.lang.String r2 = "hits2"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r12 = 0
            r11[r12] = r0     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r8 = java.lang.String.format(r8, r11)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r14 = java.lang.Long.toString(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r14
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            boolean r14 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            if (r14 == 0) goto L5b
        L4a:
            long r14 = r10.getLong(r12)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r9.add(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            boolean r14 = r10.moveToNext()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            if (r14 != 0) goto L4a
        L5b:
            if (r10 == 0) goto L6e
            r10.close()
            goto L6e
        L61:
            r14 = move-exception
            goto L6f
        L63:
            r14 = move-exception
            java.lang.String r15 = "Error selecting hit ids"
            r13.m8672t0(r15, r14)     // Catch: java.lang.Throwable -> L61
            if (r10 == 0) goto L6e
            r10.close()
        L6e:
            return r9
        L6f:
            if (r10 == 0) goto L74
            r10.close()
        L74:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0986fg.m3763R0(long):java.util.List");
    }

    /* renamed from: S0 */
    public final void m3764S0(C1043gh c1043gh) {
        C0813ca.m2729k(c1043gh);
        C1434k4.m5823i();
        m8878F0();
        C0813ca.m2729k(c1043gh);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : c1043gh.m4126e().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            m8660h0().m5889G0(c1043gh, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = C0770bh.f1678c.m2801a().intValue();
        long m3766U0 = m3766U0();
        if (m3766U0 > intValue - 1) {
            List<Long> m3763R0 = m3763R0((m3766U0 - intValue) + 1);
            m8672t0("Store full, deleting hits to make room, count", Integer.valueOf(m3763R0.size()));
            m3762P0(m3763R0);
        }
        SQLiteDatabase m3756I0 = m3756I0();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(c1043gh.m4129h()));
        contentValues.put("hit_app_id", Integer.valueOf(c1043gh.m4127f()));
        contentValues.put("hit_url", c1043gh.m4131j() ? C2007ug.m8885h() : C2007ug.m8886i());
        try {
            long insert = m3756I0.insert("hits2", null, contentValues);
            if (insert == -1) {
                m8650B0("Failed to insert a hit (got -1)");
            } else {
                m8654a0("Hit saved to database. db-id, hit", Long.valueOf(insert), c1043gh);
            }
        } catch (SQLiteException e) {
            m8674w0("Error storing a hit", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x007e, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
    
        if (r1.moveToFirst() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        r14.add(new cz.opentree.C1043gh(r13, m3770a1(r1.getString(2)), r1.getLong(1), cz.opentree.C0713ai.m2080i(r1.getString(3)), r1.getLong(0), r1.getInt(4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0077, code lost:
    
        if (r1.moveToNext() != false) goto L26;
     */
    /* renamed from: T0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<cz.opentree.C1043gh> m3765T0(long r14) {
        /*
            r13 = this;
            java.lang.String r0 = "hit_id"
            r1 = 0
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 < 0) goto Lc
            r1 = r2
            goto Ld
        Lc:
            r1 = r3
        Ld:
            cz.opentree.C0813ca.m2719a(r1)
            cz.opentree.C1434k4.m5823i()
            r13.m8878F0()
            android.database.sqlite.SQLiteDatabase r4 = r13.m3756I0()
            r1 = 0
            java.lang.String r5 = "hits2"
            java.lang.String r6 = "hit_time"
            java.lang.String r7 = "hit_string"
            java.lang.String r8 = "hit_url"
            java.lang.String r9 = "hit_app_id"
            java.lang.String[] r6 = new java.lang.String[]{r0, r6, r7, r8, r9}     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "%s ASC"
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r12[r3] = r0     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            java.lang.String r11 = java.lang.String.format(r11, r12)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            java.lang.String r12 = java.lang.Long.toString(r14)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r14.<init>()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            boolean r15 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            if (r15 == 0) goto L79
        L4a:
            long r10 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r15 = 2
            java.lang.String r15 = r1.getString(r15)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r0 = 3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r4 = 4
            int r12 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            java.util.Map r6 = r13.m3770a1(r15)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            boolean r9 = cz.opentree.C0713ai.m2080i(r0)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            cz.opentree.gh r15 = new cz.opentree.gh     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r4 = r15
            r5 = r13
            r4.<init>(r5, r6, r7, r9, r10, r12)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            r14.add(r15)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            boolean r15 = r1.moveToNext()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteException -> L81
            if (r15 != 0) goto L4a
        L79:
            if (r1 == 0) goto L7e
            r1.close()
        L7e:
            return r14
        L7f:
            r14 = move-exception
            goto L88
        L81:
            r14 = move-exception
            java.lang.String r15 = "Error loading hits from the database"
            r13.m8674w0(r15, r14)     // Catch: java.lang.Throwable -> L7f
            throw r14     // Catch: java.lang.Throwable -> L7f
        L88:
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0986fg.m3765T0(long):java.util.List");
    }

    /* renamed from: U0 */
    public final long m3766U0() {
        C1434k4.m5823i();
        m8878F0();
        return m3760M0("SELECT COUNT(*) FROM hits2", null);
    }

    /* renamed from: V0 */
    public final int m3767V0() {
        C1434k4.m5823i();
        m8878F0();
        if (!this.f2681R.m9521c(86400000L)) {
            return 0;
        }
        this.f2681R.m9520b();
        m8676x0("Deleting stale hits (if any)");
        int delete = m3756I0().delete("hits2", "hit_time < ?", new String[]{Long.toString(m8659g0().mo1177a() - 2592000000L)});
        m8679z("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    /* renamed from: W0 */
    public final long m3768W0() {
        C1434k4.m5823i();
        m8878F0();
        return m3761N0(f2679U, null, 0L);
    }

    /* renamed from: Z0 */
    public final void m3769Z0(long j) {
        C1434k4.m5823i();
        m8878F0();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        m8679z("Deleting hit, id", Long.valueOf(j));
        m3762P0(arrayList);
    }

    /* renamed from: a1 */
    public final Map<String, String> m3770a1(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return C1103hc.m4430b(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            m8674w0("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f2680Q.close();
        } catch (SQLiteException e) {
            m8674w0("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            m8674w0("Error closing database", e2);
        }
    }
}
