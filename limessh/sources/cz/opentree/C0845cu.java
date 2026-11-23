package cz.opentree;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.internal.zzy;
import cz.opentree.AbstractC2303xn;
import cz.opentree.C0718ak;
import cz.opentree.C0831ck;
import cz.opentree.C1610nk;
import cz.opentree.C1722pk;
import cz.opentree.C1821rk;
import cz.opentree.C2356yj;
import cz.opentree.C2429zj;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.cu */
/* loaded from: classes.dex */
public final class C0845cu extends w30 {

    /* renamed from: f */
    public static final String[] f2046f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g */
    public static final String[] f2047g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h */
    public static final String[] f2048h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: i */
    public static final String[] f2049i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j */
    public static final String[] f2050j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k */
    public static final String[] f2051k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l */
    public static final String[] f2052l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m */
    public static final String[] f2053m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d */
    public final C1013fu f2054d;

    /* renamed from: e */
    public final r30 f2055e;

    public C0845cu(z30 z30Var) {
        super(z30Var);
        this.f2055e = new r30(mo1483i());
        this.f2054d = new C1013fu(this, mo1482h(), "google_app_measurement.db");
    }

    @WorkerThread
    /* renamed from: M */
    public static void m2982M(ContentValues contentValues, String str, Object obj) {
        C0813ca.m2725g(str);
        C0813ca.m2729k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    @WorkerThread
    /* renamed from: A */
    public final long m2991A(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = m3038x().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9085c("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    /* renamed from: A0 */
    public final void m2992A0() {
        m9404t();
        m3038x().endTransaction();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<cz.opentree.C1610nk, java.lang.Long> m2993B(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.mo7585d()
            r7.m9404t()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.m3038x()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            cz.opentree.sy r8 = r7.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.uy r8 = r8.m8530P()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.m9083a(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.nk$a r4 = cz.opentree.C1610nk.m6697d0()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgs r2 = cz.opentree.d40.m3120A(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.nk$a r2 = (cz.opentree.C1610nk.a) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgt r2 = r2.mo1259f()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.xn r2 = (cz.opentree.AbstractC2303xn) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.nk r2 = (cz.opentree.C1610nk) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            cz.opentree.sy r3 = r7.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            cz.opentree.uy r3 = r3.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = cz.opentree.C1889sy.m8516y(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.m9086d(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            cz.opentree.sy r9 = r7.mo1484j()     // Catch: java.lang.Throwable -> L90
            cz.opentree.uy r9 = r9.m8522H()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.m9084b(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m2993B(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* renamed from: B0 */
    public final boolean m2994B0() {
        return m3022i0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    /* renamed from: C */
    public final C0899du m2995C(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        C0813ca.m2725g(str);
        mo7585d();
        m9404t();
        String[] strArr = {str};
        C0899du c0899du = new C0899du();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase m3038x = m3038x();
                Cursor query = m3038x.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    mo1484j().m8525K().m9084b("Not updating daily counts, app is not known. appId", C1889sy.m8516y(str));
                    if (query != null) {
                        query.close();
                    }
                    return c0899du;
                }
                if (query.getLong(0) == j) {
                    c0899du.f2283b = query.getLong(1);
                    c0899du.f2282a = query.getLong(2);
                    c0899du.f2284c = query.getLong(3);
                    c0899du.f2285d = query.getLong(4);
                    c0899du.f2286e = query.getLong(5);
                }
                if (z) {
                    c0899du.f2283b += j2;
                }
                if (z2) {
                    c0899du.f2282a += j2;
                }
                if (z3) {
                    c0899du.f2284c += j2;
                }
                if (z4) {
                    c0899du.f2285d += j2;
                }
                if (z5) {
                    c0899du.f2286e += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(c0899du.f2282a));
                contentValues.put("daily_events_count", Long.valueOf(c0899du.f2283b));
                contentValues.put("daily_conversions_count", Long.valueOf(c0899du.f2284c));
                contentValues.put("daily_error_events_count", Long.valueOf(c0899du.f2285d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(c0899du.f2286e));
                m3038x.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return c0899du;
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9085c("Error updating daily counts. appId", C1889sy.m8516y(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return c0899du;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* renamed from: C0 */
    public final void m2996C0() {
        int delete;
        mo7585d();
        m9404t();
        if (m3021h0()) {
            long m4968a = m7589n().f2563h.m4968a();
            long mo1178b = mo1483i().mo1178b();
            if (Math.abs(mo1178b - m4968a) > C1735pu.f5873z.m6320a(null).longValue()) {
                m7589n().f2563h.m4969b(mo1178b);
                mo7585d();
                m9404t();
                if (!m3021h0() || (delete = m3038x().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo1483i().mo1177a()), String.valueOf(C0796bu.m2605N())})) <= 0) {
                    return;
                }
                mo1484j().m8530P().m9084b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    @WorkerThread
    /* renamed from: D */
    public final C0899du m2997D(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return m2995C(j, str, 1L, false, false, z3, false, z5);
    }

    @WorkerThread
    /* renamed from: D0 */
    public final long m2998D0() {
        return m2991A("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:71:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
    @androidx.annotation.WorkerThread
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final cz.opentree.C1473ku m2999E(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m2999E(java.lang.String, java.lang.String):cz.opentree.ku");
    }

    @WorkerThread
    /* renamed from: E0 */
    public final long m3000E0() {
        return m2991A("select max(timestamp) from raw_events", null, 0L);
    }

    /* renamed from: F0 */
    public final boolean m3001F0() {
        return m3022i0("select count(1) > 0 from raw_events", null) != 0;
    }

    @WorkerThread
    /* renamed from: G */
    public final Object m3002G(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            mo1484j().m8522H().m9083a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            mo1484j().m8522H().m9084b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        mo1484j().m8522H().m9083a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* renamed from: G0 */
    public final boolean m3003G0() {
        return m3022i0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m3004H(long r5) {
        /*
            r4 = this;
            r4.mo7585d()
            r4.m9404t()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.m3038x()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            cz.opentree.sy r6 = r4.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            cz.opentree.uy r6 = r6.m8530P()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.m9083a(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            cz.opentree.sy r1 = r4.mo1484j()     // Catch: java.lang.Throwable -> L57
            cz.opentree.uy r1 = r1.m8522H()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.m9084b(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3004H(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    @androidx.annotation.WorkerThread
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<cz.opentree.h40> m3005I(java.lang.String r14) {
        /*
            r13 = this;
            cz.opentree.C0813ca.m2725g(r14)
            r13.mo7585d()
            r13.m9404t()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.m3038x()     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L3e
            r2.close()
        L3e:
            return r0
        L3f:
            java.lang.String r7 = r2.getString(r12)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L4b
            java.lang.String r3 = ""
        L4b:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r3 = 3
            java.lang.Object r10 = r13.m3002G(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r10 != 0) goto L6a
            cz.opentree.sy r3 = r13.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            cz.opentree.uy r3 = r3.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = cz.opentree.C1889sy.m8516y(r14)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r3.m9084b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            goto L74
        L6a:
            cz.opentree.h40 r3 = new cz.opentree.h40     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
        L74:
            boolean r3 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L7f
            r2.close()
        L7f:
            return r0
        L80:
            r0 = move-exception
            goto L86
        L82:
            r14 = move-exception
            goto L9f
        L84:
            r0 = move-exception
            r2 = r1
        L86:
            cz.opentree.sy r3 = r13.mo1484j()     // Catch: java.lang.Throwable -> L9d
            cz.opentree.uy r3 = r3.m8522H()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r14 = cz.opentree.C1889sy.m8516y(r14)     // Catch: java.lang.Throwable -> L9d
            r3.m9085c(r4, r14, r0)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L9c
            r2.close()
        L9c:
            return r1
        L9d:
            r14 = move-exception
            r1 = r2
        L9f:
            if (r1 == 0) goto La4
            r1.close()
        La4:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3005I(java.lang.String):java.util.List");
    }

    @WorkerThread
    /* renamed from: J */
    public final List<Pair<C1821rk, Long>> m3006J(String str, int i, int i2) {
        byte[] m3144W;
        mo7585d();
        m9404t();
        C0813ca.m2719a(i > 0);
        C0813ca.m2719a(i2 > 0);
        C0813ca.m2725g(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = m3038x().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!query.moveToFirst()) {
                    List<Pair<C1821rk, Long>> emptyList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                do {
                    long j = query.getLong(0);
                    try {
                        m3144W = m9686p().m3144W(query.getBlob(1));
                    } catch (IOException e) {
                        mo1484j().m8522H().m9085c("Failed to unzip queued bundle. appId", C1889sy.m8516y(str), e);
                    }
                    if (!arrayList.isEmpty() && m3144W.length + i3 > i2) {
                        break;
                    }
                    try {
                        C1821rk.a aVar = (C1821rk.a) d40.m3120A(C1821rk.m7933N0(), m3144W);
                        if (!query.isNull(2)) {
                            aVar.m8125o0(query.getInt(2));
                        }
                        i3 += m3144W.length;
                        arrayList.add(Pair.create((C1821rk) ((AbstractC2303xn) aVar.mo1259f()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        mo1484j().m8522H().m9085c("Failed to merge queued bundle. appId", C1889sy.m8516y(str), e2);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i3 <= i2);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                mo1484j().m8522H().m9085c("Error querying bundles. appId", C1889sy.m8516y(str), e3);
                List<Pair<C1821rk, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0090, code lost:
    
        mo1484j().m8522H().m9084b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    @androidx.annotation.WorkerThread
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<cz.opentree.h40> m3007K(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3007K(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        mo1484j().m8522H().m9084b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzy> m3008L(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3008L(java.lang.String, java.lang.String[]):java.util.List");
    }

    @WorkerThread
    /* renamed from: N */
    public final void m3009N(C1473ku c1473ku) {
        C0813ca.m2729k(c1473ku);
        mo7585d();
        m9404t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1473ku.f4648a);
        contentValues.put("name", c1473ku.f4649b);
        contentValues.put("lifetime_count", Long.valueOf(c1473ku.f4650c));
        contentValues.put("current_bundle_count", Long.valueOf(c1473ku.f4651d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c1473ku.f4653f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c1473ku.f4654g));
        contentValues.put("last_bundled_day", c1473ku.f4655h);
        contentValues.put("last_sampled_complex_event_id", c1473ku.f4656i);
        contentValues.put("last_sampling_rate", c1473ku.f4657j);
        contentValues.put("current_session_count", Long.valueOf(c1473ku.f4652e));
        Boolean bool = c1473ku.f4658k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (m3038x().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo1484j().m8522H().m9084b("Failed to insert/update event aggregates (got -1). appId", C1889sy.m8516y(c1473ku.f4648a));
            }
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing event aggregates. appId", C1889sy.m8516y(c1473ku.f4648a), e);
        }
    }

    @WorkerThread
    /* renamed from: O */
    public final void m3010O(C2318xz c2318xz) {
        C0813ca.m2729k(c2318xz);
        mo7585d();
        m9404t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2318xz.m9957t());
        contentValues.put("app_instance_id", c2318xz.m9961x());
        contentValues.put("gmp_app_id", c2318xz.m9899A());
        contentValues.put("resettable_device_id_hash", c2318xz.m9908J());
        contentValues.put("last_bundle_index", Long.valueOf(c2318xz.m9936f0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c2318xz.m9914P()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c2318xz.m9916R()));
        contentValues.put("app_version", c2318xz.m9918T());
        contentValues.put("app_store", c2318xz.m9922X());
        contentValues.put("gmp_version", Long.valueOf(c2318xz.m9924Z()));
        contentValues.put("dev_cert_hash", Long.valueOf(c2318xz.m9928b0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c2318xz.m9934e0()));
        contentValues.put("day", Long.valueOf(c2318xz.m9944j0()));
        contentValues.put("daily_public_events_count", Long.valueOf(c2318xz.m9946k0()));
        contentValues.put("daily_events_count", Long.valueOf(c2318xz.m9948l0()));
        contentValues.put("daily_conversions_count", Long.valueOf(c2318xz.m9950m0()));
        contentValues.put("config_fetched_time", Long.valueOf(c2318xz.m9938g0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c2318xz.m9940h0()));
        contentValues.put("app_version_int", Long.valueOf(c2318xz.m9920V()));
        contentValues.put("firebase_instance_id", c2318xz.m9911M());
        contentValues.put("daily_error_events_count", Long.valueOf(c2318xz.m9939h()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(c2318xz.m9937g()));
        contentValues.put("health_monitor_sample", c2318xz.m9941i());
        contentValues.put("android_id", Long.valueOf(c2318xz.m9945k()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c2318xz.m9947l()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(c2318xz.m9949m()));
        contentValues.put("admob_app_id", c2318xz.m9902D());
        contentValues.put("dynamite_version", Long.valueOf(c2318xz.m9932d0()));
        if (c2318xz.m9952o() != null) {
            if (c2318xz.m9952o().size() == 0) {
                mo1484j().m8525K().m9084b("Safelisted events should not be an empty list. appId", c2318xz.m9957t());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", c2318xz.m9952o()));
            }
        }
        if (C1011fs.m3874b() && m7590o().m2610D(c2318xz.m9957t(), C1735pu.f5856q0)) {
            contentValues.put("ga_app_id", c2318xz.m9905G());
        }
        try {
            SQLiteDatabase m3038x = m3038x();
            if (m3038x.update("apps", contentValues, "app_id = ?", new String[]{c2318xz.m9957t()}) == 0 && m3038x.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo1484j().m8522H().m9084b("Failed to insert/update app (got -1). appId", C1889sy.m8516y(c2318xz.m9957t()));
            }
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing app. appId", C1889sy.m8516y(c2318xz.m9957t()), e);
        }
    }

    @WorkerThread
    /* renamed from: P */
    public final void m3011P(String str, List<C2356yj> list) {
        boolean z;
        boolean z2;
        C0813ca.m2729k(list);
        for (int i = 0; i < list.size(); i++) {
            C2356yj.a m9840z = list.get(i).m9840z();
            if (m9840z.m10175A() != 0) {
                for (int i2 = 0; i2 < m9840z.m10175A(); i2++) {
                    C2429zj.a m9840z2 = m9840z.m10176B(i2).m9840z();
                    C2429zj.a aVar = (C2429zj.a) ((AbstractC2303xn.b) m9840z2.clone());
                    String m8562b = t00.m8562b(m9840z2.m10484z());
                    if (m8562b != null) {
                        aVar.m10482w(m8562b);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < m9840z2.m10480A(); i3++) {
                        C0718ak m10483y = m9840z2.m10483y(i3);
                        String m8290a = s00.m8290a(m10483y.m2131N());
                        if (m8290a != null) {
                            C0718ak.a m9840z3 = m10483y.m9840z();
                            m9840z3.m2133v(m8290a);
                            aVar.m10481v(i3, (C0718ak) ((AbstractC2303xn) m9840z3.mo1259f()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        m9840z.m10178w(i2, aVar);
                        list.set(i, (C2356yj) ((AbstractC2303xn) m9840z.mo1259f()));
                    }
                }
            }
            if (m9840z.m10177v() != 0) {
                for (int i4 = 0; i4 < m9840z.m10177v(); i4++) {
                    C0831ck m10180z = m9840z.m10180z(i4);
                    String m8823a = u00.m8823a(m10180z.m2833H());
                    if (m8823a != null) {
                        C0831ck.a m9840z4 = m10180z.m9840z();
                        m9840z4.m2839v(m8823a);
                        m9840z.m10179y(i4, m9840z4);
                        list.set(i, (C2356yj) ((AbstractC2303xn) m9840z.mo1259f()));
                    }
                }
            }
        }
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        C0813ca.m2729k(list);
        SQLiteDatabase m3038x = m3038x();
        m3038x.beginTransaction();
        try {
            m9404t();
            mo7585d();
            C0813ca.m2725g(str);
            SQLiteDatabase m3038x2 = m3038x();
            m3038x2.delete("property_filters", "app_id=?", new String[]{str});
            m3038x2.delete("event_filters", "app_id=?", new String[]{str});
            for (C2356yj c2356yj : list) {
                m9404t();
                mo7585d();
                C0813ca.m2725g(str);
                C0813ca.m2729k(c2356yj);
                if (c2356yj.m10168I()) {
                    int m10169J = c2356yj.m10169J();
                    Iterator<C2429zj> it = c2356yj.m10173O().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().m10469I()) {
                                mo1484j().m8525K().m9085c("Event filter with no ID. Audience definition ignored. appId, audienceId", C1889sy.m8516y(str), Integer.valueOf(m10169J));
                                break;
                            }
                        } else {
                            Iterator<C0831ck> it2 = c2356yj.m10171M().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().m2831F()) {
                                        mo1484j().m8525K().m9085c("Property filter with no ID. Audience definition ignored. appId, audienceId", C1889sy.m8516y(str), Integer.valueOf(m10169J));
                                        break;
                                    }
                                } else {
                                    Iterator<C2429zj> it3 = c2356yj.m10173O().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!m3017V(str, m10169J, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<C0831ck> it4 = c2356yj.m10171M().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!m3018W(str, m10169J, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        m9404t();
                                        mo7585d();
                                        C0813ca.m2725g(str);
                                        SQLiteDatabase m3038x3 = m3038x();
                                        m3038x3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(m10169J)});
                                        m3038x3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(m10169J)});
                                    }
                                }
                            }
                        }
                    }
                } else {
                    mo1484j().m8525K().m9084b("Audience with no ID. appId", C1889sy.m8516y(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (C2356yj c2356yj2 : list) {
                arrayList.add(c2356yj2.m10168I() ? Integer.valueOf(c2356yj2.m10169J()) : null);
            }
            m3026m0(str, arrayList);
            m3038x.setTransactionSuccessful();
        } finally {
            m3038x.endTransaction();
        }
    }

    @WorkerThread
    /* renamed from: Q */
    public final void m3012Q(List<Long> list) {
        mo7585d();
        m9404t();
        C0813ca.m2729k(list);
        C0813ca.m2731m(list.size());
        if (m3021h0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (m3022i0(sb3.toString(), null) > 0) {
                mo1484j().m8525K().m9083a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase m3038x = m3038x();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + KeycodeConstants.KEYCODE_MEDIA_PAUSE);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                m3038x.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9084b("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    /* renamed from: R */
    public final boolean m3013R(C1821rk c1821rk, boolean z) {
        mo7585d();
        m9404t();
        C0813ca.m2729k(c1821rk);
        C0813ca.m2725g(c1821rk.m7989I2());
        C0813ca.m2732n(c1821rk.m8044j2());
        m2996C0();
        long mo1177a = mo1483i().mo1177a();
        if (c1821rk.m8046k2() < mo1177a - C0796bu.m2605N() || c1821rk.m8046k2() > C0796bu.m2605N() + mo1177a) {
            mo1484j().m8525K().m9086d("Storing bundle outside of the max uploading time span. appId, now, timestamp", C1889sy.m8516y(c1821rk.m7989I2()), Long.valueOf(mo1177a), Long.valueOf(c1821rk.m8046k2()));
        }
        try {
            byte[] m3145X = m9686p().m3145X(c1821rk.m5946k());
            mo1484j().m8530P().m9084b("Saving bundle, size", Integer.valueOf(m3145X.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c1821rk.m7989I2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(c1821rk.m8046k2()));
            contentValues.put("data", m3145X);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (c1821rk.m8071x0()) {
                contentValues.put("retry_count", Integer.valueOf(c1821rk.m7988I0()));
            }
            try {
                if (m3038x().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo1484j().m8522H().m9084b("Failed to insert bundle (got -1). appId", C1889sy.m8516y(c1821rk.m7989I2()));
                return false;
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9085c("Error storing bundle. appId", C1889sy.m8516y(c1821rk.m7989I2()), e);
                return false;
            }
        } catch (IOException e2) {
            mo1484j().m8522H().m9085c("Data loss. Failed to serialize bundle. appId", C1889sy.m8516y(c1821rk.m7989I2()), e2);
            return false;
        }
    }

    /* renamed from: S */
    public final boolean m3014S(C1177iu c1177iu, long j, boolean z) {
        mo7585d();
        m9404t();
        C0813ca.m2729k(c1177iu);
        C0813ca.m2725g(c1177iu.f3417a);
        C1610nk.a m6697d0 = C1610nk.m6697d0();
        m6697d0.m6725H(c1177iu.f3421e);
        Iterator<String> it = c1177iu.f3422f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            C1722pk.a m7356e0 = C1722pk.m7356e0();
            m7356e0.m7380B(next);
            m9686p().m3137J(m7356e0, c1177iu.f3422f.m1456Y(next));
            m6697d0.m6733z(m7356e0);
        }
        byte[] m5946k = ((C1610nk) ((AbstractC2303xn) m6697d0.mo1259f())).m5946k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1177iu.f3417a);
        contentValues.put("name", c1177iu.f3418b);
        contentValues.put("timestamp", Long.valueOf(c1177iu.f3420d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", m5946k);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (m3038x().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            mo1484j().m8522H().m9084b("Failed to insert raw event (got -1). appId", C1889sy.m8516y(c1177iu.f3417a));
            return false;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing raw event. appId", C1889sy.m8516y(c1177iu.f3417a), e);
            return false;
        }
    }

    @WorkerThread
    /* renamed from: T */
    public final boolean m3015T(h40 h40Var) {
        C0813ca.m2729k(h40Var);
        mo7585d();
        m9404t();
        if (m3028o0(h40Var.f3100a, h40Var.f3102c) == null) {
            if (g40.m3996c0(h40Var.f3102c)) {
                if (m3022i0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{h40Var.f3100a}) >= m7590o().m2634y(h40Var.f3100a)) {
                    return false;
                }
            } else if (!"_npa".equals(h40Var.f3102c) && m3022i0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{h40Var.f3100a, h40Var.f3101b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", h40Var.f3100a);
        contentValues.put("origin", h40Var.f3101b);
        contentValues.put("name", h40Var.f3102c);
        contentValues.put("set_timestamp", Long.valueOf(h40Var.f3103d));
        m2982M(contentValues, "value", h40Var.f3104e);
        try {
            if (m3038x().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo1484j().m8522H().m9084b("Failed to insert/update user property (got -1). appId", C1889sy.m8516y(h40Var.f3100a));
            }
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing user property. appId", C1889sy.m8516y(h40Var.f3100a), e);
        }
        return true;
    }

    @WorkerThread
    /* renamed from: U */
    public final boolean m3016U(zzy zzyVar) {
        C0813ca.m2729k(zzyVar);
        mo7585d();
        m9404t();
        if (m3028o0(zzyVar.f1019O, zzyVar.f1021Q.f991P) == null && m3022i0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzyVar.f1019O}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzyVar.f1019O);
        contentValues.put("origin", zzyVar.f1020P);
        contentValues.put("name", zzyVar.f1021Q.f991P);
        m2982M(contentValues, "value", zzyVar.f1021Q.m1501x());
        contentValues.put("active", Boolean.valueOf(zzyVar.f1023S));
        contentValues.put("trigger_event_name", zzyVar.f1024T);
        contentValues.put("trigger_timeout", Long.valueOf(zzyVar.f1026V));
        m7588m();
        contentValues.put("timed_out_event", g40.m4000m0(zzyVar.f1025U));
        contentValues.put("creation_timestamp", Long.valueOf(zzyVar.f1022R));
        m7588m();
        contentValues.put("triggered_event", g40.m4000m0(zzyVar.f1027W));
        contentValues.put("triggered_timestamp", Long.valueOf(zzyVar.f1021Q.f992Q));
        contentValues.put("time_to_live", Long.valueOf(zzyVar.f1028X));
        m7588m();
        contentValues.put("expired_event", g40.m4000m0(zzyVar.f1029Y));
        try {
            if (m3038x().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo1484j().m8522H().m9084b("Failed to insert/update conditional user property (got -1)", C1889sy.m8516y(zzyVar.f1019O));
            }
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing conditional user property", C1889sy.m8516y(zzyVar.f1019O), e);
        }
        return true;
    }

    @WorkerThread
    /* renamed from: V */
    public final boolean m3017V(String str, int i, C2429zj c2429zj) {
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        C0813ca.m2729k(c2429zj);
        if (TextUtils.isEmpty(c2429zj.m10471L())) {
            mo1484j().m8525K().m9086d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", C1889sy.m8516y(str), Integer.valueOf(i), String.valueOf(c2429zj.m10469I() ? Integer.valueOf(c2429zj.m10470J()) : null));
            return false;
        }
        byte[] m5946k = c2429zj.m5946k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c2429zj.m10469I() ? Integer.valueOf(c2429zj.m10470J()) : null);
        contentValues.put("event_name", c2429zj.m10471L());
        contentValues.put("session_scoped", c2429zj.m10478S() ? Boolean.valueOf(c2429zj.m10479T()) : null);
        contentValues.put("data", m5946k);
        try {
            if (m3038x().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo1484j().m8522H().m9084b("Failed to insert event filter (got -1). appId", C1889sy.m8516y(str));
            return true;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing event filter. appId", C1889sy.m8516y(str), e);
            return false;
        }
    }

    @WorkerThread
    /* renamed from: W */
    public final boolean m3018W(String str, int i, C0831ck c0831ck) {
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        C0813ca.m2729k(c0831ck);
        if (TextUtils.isEmpty(c0831ck.m2833H())) {
            mo1484j().m8525K().m9086d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", C1889sy.m8516y(str), Integer.valueOf(i), String.valueOf(c0831ck.m2831F() ? Integer.valueOf(c0831ck.m2832G()) : null));
            return false;
        }
        byte[] m5946k = c0831ck.m5946k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c0831ck.m2831F() ? Integer.valueOf(c0831ck.m2832G()) : null);
        contentValues.put("property_name", c0831ck.m2833H());
        contentValues.put("session_scoped", c0831ck.m2837M() ? Boolean.valueOf(c0831ck.m2838N()) : null);
        contentValues.put("data", m5946k);
        try {
            if (m3038x().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo1484j().m8522H().m9084b("Failed to insert property filter (got -1). appId", C1889sy.m8516y(str));
            return false;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing property filter. appId", C1889sy.m8516y(str), e);
            return false;
        }
    }

    /* renamed from: X */
    public final boolean m3019X(String str, Long l, long j, C1610nk c1610nk) {
        mo7585d();
        m9404t();
        C0813ca.m2729k(c1610nk);
        C0813ca.m2725g(str);
        C0813ca.m2729k(l);
        byte[] m5946k = c1610nk.m5946k();
        mo1484j().m8530P().m9085c("Saving complex main event, appId, data size", m7587l().m7809x(str), Integer.valueOf(m5946k.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", m5946k);
        try {
            if (m3038x().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            mo1484j().m8522H().m9084b("Failed to insert complex main event (got -1). appId", C1889sy.m8516y(str));
            return false;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing complex main event. appId", C1889sy.m8516y(str), e);
            return false;
        }
    }

    /* renamed from: Y */
    public final long m3020Y() {
        Cursor cursor = null;
        try {
            try {
                cursor = m3038x().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9084b("Error querying raw events", e);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: h0 */
    public final boolean m3021h0() {
        return mo1482h().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    /* renamed from: i0 */
    public final long m3022i0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m3038x().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                mo1484j().m8522H().m9085c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0159 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0187 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b3 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01cb A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e9 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022d  */
    @androidx.annotation.WorkerThread
    /* renamed from: j0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final cz.opentree.C2318xz m3023j0(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3023j0(java.lang.String):cz.opentree.xz");
    }

    @WorkerThread
    /* renamed from: k0 */
    public final List<zzy> m3024k0(String str, String str2, String str3) {
        C0813ca.m2725g(str);
        mo7585d();
        m9404t();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return m3008L(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    /* renamed from: l0 */
    public final void m3025l0(String str, String str2) {
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        mo7585d();
        m9404t();
        try {
            m3038x().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9086d("Error deleting user property. appId", C1889sy.m8516y(str), m7587l().m7805B(str2), e);
        }
    }

    /* renamed from: m0 */
    public final boolean m3026m0(String str, List<Integer> list) {
        C0813ca.m2725g(str);
        m9404t();
        mo7585d();
        SQLiteDatabase m3038x = m3038x();
        try {
            long m3022i0 = m3022i0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(RecyclerView.MAX_SCROLL_DURATION, m7590o().m2632w(str, C1735pu.f5790G)));
            if (m3022i0 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + KeycodeConstants.KEYCODE_F10);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return m3038x.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Database error querying filters. appId", C1889sy.m8516y(str), e);
            return false;
        }
    }

    /* renamed from: n0 */
    public final long m3027n0(String str) {
        C0813ca.m2725g(str);
        mo7585d();
        m9404t();
        try {
            return m3038x().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, m7590o().m2632w(str, C1735pu.f5855q))))});
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error deleting over the limit events. appId", C1889sy.m8516y(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    @androidx.annotation.WorkerThread
    /* renamed from: o0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final cz.opentree.h40 m3028o0(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            cz.opentree.C0813ca.m2725g(r19)
            cz.opentree.C0813ca.m2725g(r20)
            r18.mo7585d()
            r18.m9404t()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.m3038x()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            r11 = r18
            java.lang.Object r7 = r11.m3002G(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            cz.opentree.h40 r0 = new cz.opentree.h40     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            if (r1 == 0) goto L6e
            cz.opentree.sy r1 = r18.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            cz.opentree.uy r1 = r1.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = cz.opentree.C1889sy.m8516y(r19)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1.m9084b(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
        L6e:
            if (r10 == 0) goto L73
            r10.close()
        L73:
            return r0
        L74:
            r0 = move-exception
            goto L86
        L76:
            r0 = move-exception
            r11 = r18
            goto La6
        L7a:
            r0 = move-exception
            r11 = r18
            goto L86
        L7e:
            r0 = move-exception
            r11 = r18
            goto La7
        L82:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L86:
            cz.opentree.sy r1 = r18.mo1484j()     // Catch: java.lang.Throwable -> La5
            cz.opentree.uy r1 = r1.m8522H()     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = cz.opentree.C1889sy.m8516y(r19)     // Catch: java.lang.Throwable -> La5
            cz.opentree.qy r4 = r18.m7587l()     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = r4.m7805B(r8)     // Catch: java.lang.Throwable -> La5
            r1.m9086d(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La5
            if (r10 == 0) goto La4
            r10.close()
        La4:
            return r9
        La5:
            r0 = move-exception
        La6:
            r9 = r10
        La7:
            if (r9 == 0) goto Lac
            r9.close()
        Lac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3028o0(java.lang.String, java.lang.String):cz.opentree.h40");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0121  */
    @androidx.annotation.WorkerThread
    /* renamed from: p0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzy m3029p0(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3029p0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzy");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    @androidx.annotation.WorkerThread
    /* renamed from: q0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] m3030q0(java.lang.String r11) {
        /*
            r10 = this;
            cz.opentree.C0813ca.m2725g(r11)
            r10.mo7585d()
            r10.m9404t()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.m3038x()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r2 != 0) goto L31
            if (r1 == 0) goto L30
            r1.close()
        L30:
            return r0
        L31:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r3 == 0) goto L4c
            cz.opentree.sy r3 = r10.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            cz.opentree.uy r3 = r3.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = cz.opentree.C1889sy.m8516y(r11)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            r3.m9084b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            return r2
        L52:
            r2 = move-exception
            goto L58
        L54:
            r11 = move-exception
            goto L71
        L56:
            r2 = move-exception
            r1 = r0
        L58:
            cz.opentree.sy r3 = r10.mo1484j()     // Catch: java.lang.Throwable -> L6f
            cz.opentree.uy r3 = r3.m8522H()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = cz.opentree.C1889sy.m8516y(r11)     // Catch: java.lang.Throwable -> L6f
            r3.m9085c(r4, r11, r2)     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r11 = move-exception
            r0 = r1
        L71:
            if (r0 == 0) goto L76
            r0.close()
        L76:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3030q0(java.lang.String):byte[]");
    }

    @WorkerThread
    /* renamed from: r0 */
    public final int m3031r0(String str, String str2) {
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        mo7585d();
        m9404t();
        try {
            return m3038x().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9086d("Error deleting conditional property", C1889sy.m8516y(str), m7587l().m7805B(str2), e);
            return 0;
        }
    }

    /* renamed from: s0 */
    public final Map<Integer, List<C2429zj>> m3032s0(String str) {
        C0813ca.m2725g(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = m3038x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<C2429zj>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        C2429zj c2429zj = (C2429zj) ((AbstractC2303xn) ((C2429zj.a) d40.m3120A(C2429zj.m10464U(), query.getBlob(1))).mo1259f());
                        if (c2429zj.m10474O()) {
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(c2429zj);
                        }
                    } catch (IOException e) {
                        mo1484j().m8522H().m9085c("Failed to merge filter. appId", C1889sy.m8516y(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            mo1484j().m8522H().m9085c("Database error querying filters. appId", C1889sy.m8516y(str), e2);
            Map<Integer, List<C2429zj>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: t0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> m3033t0(java.lang.String r8) {
        /*
            r7 = this;
            r7.m9404t()
            r7.mo7585d()
            cz.opentree.C0813ca.m2725g(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.m3038x()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6b
        L67:
            r8 = move-exception
            goto L84
        L69:
            r0 = move-exception
            r1 = r2
        L6b:
            cz.opentree.sy r3 = r7.mo1484j()     // Catch: java.lang.Throwable -> L82
            cz.opentree.uy r3 = r3.m8522H()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = cz.opentree.C1889sy.m8516y(r8)     // Catch: java.lang.Throwable -> L82
            r3.m9085c(r4, r8, r0)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L81
            r1.close()
        L81:
            return r2
        L82:
            r8 = move-exception
            r2 = r1
        L84:
            if (r2 == 0) goto L89
            r2.close()
        L89:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3033t0(java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* renamed from: u0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<cz.opentree.C2429zj>> m3034u0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.m9404t()
            r12.mo7585d()
            cz.opentree.C0813ca.m2725g(r13)
            cz.opentree.C0813ca.m2725g(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.m3038x()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.zj$a r2 = cz.opentree.C2429zj.m10464U()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgs r1 = cz.opentree.d40.m3120A(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.zj$a r1 = (cz.opentree.C2429zj.a) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgt r1 = r1.mo1259f()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.xn r1 = (cz.opentree.AbstractC2303xn) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.zj r1 = (cz.opentree.C2429zj) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            goto L8a
        L78:
            r1 = move-exception
            cz.opentree.sy r2 = r12.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.uy r2 = r2.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = cz.opentree.C1889sy.m8516y(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r2.m9085c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Lb5
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            cz.opentree.sy r1 = r12.mo1484j()     // Catch: java.lang.Throwable -> Lb3
            cz.opentree.uy r1 = r1.m8522H()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = cz.opentree.C1889sy.m8516y(r13)     // Catch: java.lang.Throwable -> Lb3
            r1.m9085c(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb3
            if (r14 == 0) goto Lb2
            r14.close()
        Lb2:
            return r9
        Lb3:
            r13 = move-exception
            r9 = r14
        Lb5:
            if (r9 == 0) goto Lba
            r9.close()
        Lba:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3034u0(java.lang.String, java.lang.String):java.util.Map");
    }

    @Override // cz.opentree.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        return false;
    }

    @WorkerThread
    /* renamed from: v0 */
    public final void m3035v0() {
        m9404t();
        m3038x().beginTransaction();
    }

    @WorkerThread
    /* renamed from: w */
    public final void m3036w() {
        m9404t();
        m3038x().setTransactionSuccessful();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* renamed from: w0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, cz.opentree.C1937tk> m3037w0(java.lang.String r12) {
        /*
            r11 = this;
            r11.m9404t()
            r11.mo7585d()
            cz.opentree.C0813ca.m2725g(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.m3038x()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r1 != 0) goto L33
            if (r0 == 0) goto L32
            r0.close()
        L32:
            return r8
        L33:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
        L38:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            cz.opentree.tk$a r4 = cz.opentree.C1937tk.m8715c0()     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzgs r3 = cz.opentree.d40.m3120A(r4, r3)     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            cz.opentree.tk$a r3 = (cz.opentree.C1937tk.a) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzgt r3 = r3.mo1259f()     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            cz.opentree.xn r3 = (cz.opentree.AbstractC2303xn) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            cz.opentree.tk r3 = (cz.opentree.C1937tk) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            goto L70
        L5a:
            r3 = move-exception
            cz.opentree.sy r4 = r11.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            cz.opentree.uy r4 = r4.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = cz.opentree.C1889sy.m8516y(r12)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r4.m9086d(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
        L70:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r2 != 0) goto L38
            if (r0 == 0) goto L7b
            r0.close()
        L7b:
            return r1
        L7c:
            r1 = move-exception
            goto L82
        L7e:
            r12 = move-exception
            goto L9b
        L80:
            r1 = move-exception
            r0 = r8
        L82:
            cz.opentree.sy r2 = r11.mo1484j()     // Catch: java.lang.Throwable -> L99
            cz.opentree.uy r2 = r2.m8522H()     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = cz.opentree.C1889sy.m8516y(r12)     // Catch: java.lang.Throwable -> L99
            r2.m9085c(r3, r12, r1)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L98
            r0.close()
        L98:
            return r8
        L99:
            r12 = move-exception
            r8 = r0
        L9b:
            if (r8 == 0) goto La0
            r8.close()
        La0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3037w0(java.lang.String):java.util.Map");
    }

    @WorkerThread
    /* renamed from: x */
    public final SQLiteDatabase m3038x() {
        mo7585d();
        try {
            return this.f2054d.getWritableDatabase();
        } catch (SQLiteException e) {
            mo1484j().m8525K().m9084b("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* renamed from: x0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<cz.opentree.C0831ck>> m3039x0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.m9404t()
            r12.mo7585d()
            cz.opentree.C0813ca.m2725g(r13)
            cz.opentree.C0813ca.m2725g(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.m3038x()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.ck$a r2 = cz.opentree.C0831ck.m2828O()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgs r1 = cz.opentree.d40.m3120A(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.ck$a r1 = (cz.opentree.C0831ck.a) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgt r1 = r1.mo1259f()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.xn r1 = (cz.opentree.AbstractC2303xn) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.ck r1 = (cz.opentree.C0831ck) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            goto L8a
        L78:
            r1 = move-exception
            cz.opentree.sy r2 = r12.mo1484j()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            cz.opentree.uy r2 = r2.m8522H()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = cz.opentree.C1889sy.m8516y(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r2.m9085c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Lb5
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            cz.opentree.sy r1 = r12.mo1484j()     // Catch: java.lang.Throwable -> Lb3
            cz.opentree.uy r1 = r1.m8522H()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = cz.opentree.C1889sy.m8516y(r13)     // Catch: java.lang.Throwable -> Lb3
            r1.m9085c(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb3
            if (r14 == 0) goto Lb2
            r14.close()
        Lb2:
            return r9
        Lb3:
            r13 = move-exception
            r9 = r14
        Lb5:
            if (r9 == 0) goto Lba
            r9.close()
        Lba:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3039x0(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    @androidx.annotation.WorkerThread
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m3040y() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.m3038x()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            cz.opentree.sy r3 = r6.mo1484j()     // Catch: java.lang.Throwable -> L3e
            cz.opentree.uy r3 = r3.m8522H()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.m9084b(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0845cu.m3040y():java.lang.String");
    }

    /* renamed from: y0 */
    public final long m3041y0(String str) {
        C0813ca.m2725g(str);
        return m2991A("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* renamed from: z */
    public final long m3042z(C1821rk c1821rk) throws IOException {
        mo7585d();
        m9404t();
        C0813ca.m2729k(c1821rk);
        C0813ca.m2725g(c1821rk.m7989I2());
        byte[] m5946k = c1821rk.m5946k();
        long m3147x = m9686p().m3147x(m5946k);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1821rk.m7989I2());
        contentValues.put("metadata_fingerprint", Long.valueOf(m3147x));
        contentValues.put("metadata", m5946k);
        try {
            m3038x().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return m3147x;
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9085c("Error storing raw event metadata. appId", C1889sy.m8516y(c1821rk.m7989I2()), e);
            throw e;
        }
    }

    @WorkerThread
    /* renamed from: z0 */
    public final long m3043z0(String str, String str2) {
        long m2991A;
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        mo7585d();
        m9404t();
        SQLiteDatabase m3038x = m3038x();
        m3038x.beginTransaction();
        long j = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
                sb.append("select ");
                sb.append(str2);
                sb.append(" from app2 where app_id=?");
                m2991A = m2991A(sb.toString(), new String[]{str}, -1L);
                if (m2991A == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (m3038x.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        mo1484j().m8522H().m9085c("Failed to insert column (got -1). appId", C1889sy.m8516y(str), str2);
                        return -1L;
                    }
                    m2991A = 0;
                }
            } finally {
                m3038x.endTransaction();
            }
        } catch (SQLiteException e) {
            e = e;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + m2991A));
            if (m3038x.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                mo1484j().m8522H().m9085c("Failed to update column (got 0). appId", C1889sy.m8516y(str), str2);
                return -1L;
            }
            m3038x.setTransactionSuccessful();
            return m2991A;
        } catch (SQLiteException e2) {
            e = e2;
            j = m2991A;
            mo1484j().m8522H().m9086d("Error inserting column. appId", C1889sy.m8516y(str), str2, e);
            m3038x.endTransaction();
            return j;
        }
    }
}
