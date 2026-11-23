package com.sonelli;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.eu */
/* loaded from: classes.dex */
public final class C0954eu {
    @WorkerThread
    /* renamed from: a */
    public static Set<String> m3555a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* renamed from: b */
    public static void m3556b(C1889sy c1889sy, SQLiteDatabase sQLiteDatabase) {
        if (c1889sy == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            c1889sy.m8525K().m9083a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            c1889sy.m8525K().m9083a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            c1889sy.m8525K().m9083a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        c1889sy.m8525K().m9083a("Failed to turn on database write permission for owner");
    }

    @WorkerThread
    /* renamed from: c */
    public static void m3557c(C1889sy c1889sy, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (c1889sy == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m3558d(c1889sy, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            if (c1889sy == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            Set<String> m3555a = m3555a(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!m3555a.remove(str4)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                    sb.append("Table ");
                    sb.append(str);
                    sb.append(" is missing required column: ");
                    sb.append(str4);
                    throw new SQLiteException(sb.toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!m3555a.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (m3555a.isEmpty()) {
                return;
            }
            c1889sy.m8525K().m9085c("Table has extra columns. table, columns", str, TextUtils.join(", ", m3555a));
        } catch (SQLiteException e) {
            c1889sy.m8522H().m9084b("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    @WorkerThread
    /* renamed from: d */
    public static boolean m3558d(C1889sy c1889sy, SQLiteDatabase sQLiteDatabase, String str) {
        if (c1889sy == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean moveToFirst = cursor.moveToFirst();
                if (cursor != null) {
                    cursor.close();
                }
                return moveToFirst;
            } catch (SQLiteException e) {
                c1889sy.m8525K().m9085c("Error querying for table", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
