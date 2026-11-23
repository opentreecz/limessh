package com.sonelli;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.oy */
/* loaded from: classes.dex */
public final class C1681oy extends AbstractC0742ay {

    /* renamed from: c */
    public final C1838ry f5574c;

    /* renamed from: d */
    public boolean f5575d;

    public C1681oy(C2144uz c2144uz) {
        super(c2144uz);
        this.f5574c = new C1838ry(this, mo1482h(), "google_app_measurement_local.db");
    }

    /* renamed from: C */
    public static long m7120C(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1L;
            }
            cursor.close();
            return -1L;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sonelli.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0203  */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> m7121D(int r22) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1681oy.m7121D(int):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v11 */
    @androidx.annotation.WorkerThread
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m7122E(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1681oy.m7122E(int, byte[]):boolean");
    }

    /* renamed from: F */
    public final boolean m7123F(zzaq zzaqVar) {
        Parcel obtain = Parcel.obtain();
        zzaqVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m7122E(0, marshall);
        }
        mo1484j().m8523I().m9083a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    /* renamed from: G */
    public final boolean m7124G(zzkn zzknVar) {
        Parcel obtain = Parcel.obtain();
        zzknVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m7122E(1, marshall);
        }
        mo1484j().m8523I().m9083a("User property too long for local database. Sending directly to service");
        return false;
    }

    /* renamed from: H */
    public final boolean m7125H(zzy zzyVar) {
        m7588m();
        byte[] m4000m0 = g40.m4000m0(zzyVar);
        if (m4000m0.length <= 131072) {
            return m7122E(2, m4000m0);
        }
        mo1484j().m8523I().m9083a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    @WorkerThread
    /* renamed from: I */
    public final void m7126I() {
        mo7583b();
        mo7585d();
        try {
            int delete = m7129L().delete("messages", null, null) + 0;
            if (delete > 0) {
                mo1484j().m8530P().m9084b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            mo1484j().m8522H().m9084b("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    /* renamed from: J */
    public final boolean m7127J() {
        return m7122E(3, new byte[0]);
    }

    @WorkerThread
    /* renamed from: K */
    public final boolean m7128K() {
        mo7585d();
        mo7583b();
        if (this.f5575d || !m7130M()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase m7129L = m7129L();
                    if (m7129L == null) {
                        this.f5575d = true;
                        if (m7129L != null) {
                            m7129L.close();
                        }
                        return false;
                    }
                    m7129L.beginTransaction();
                    m7129L.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    m7129L.setTransactionSuccessful();
                    m7129L.endTransaction();
                    if (m7129L != null) {
                        m7129L.close();
                    }
                    return true;
                } catch (SQLiteException e) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    mo1484j().m8522H().m9084b("Error deleting app launch break from local database", e);
                    this.f5575d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e2) {
                mo1484j().m8522H().m9084b("Error deleting app launch break from local database", e2);
                this.f5575d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        mo1484j().m8525K().m9083a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @WorkerThread
    /* renamed from: L */
    public final SQLiteDatabase m7129L() throws SQLiteException {
        if (this.f5575d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f5574c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f5575d = true;
        return null;
    }

    /* renamed from: M */
    public final boolean m7130M() {
        return mo1482h().getDatabasePath("google_app_measurement_local.db").exists();
    }
}
