package com.sonelli;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.sonelli.gg */
/* loaded from: classes.dex */
public final class C1040gg extends SQLiteOpenHelper {

    /* renamed from: O */
    public final /* synthetic */ C0986fg f2863O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1040gg(C0986fg c0986fg, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f2863O = c0986fg;
    }

    /* renamed from: b */
    public static Set<String> m4119b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            for (String str2 : rawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* renamed from: a */
    public final boolean m4120a(SQLiteDatabase sQLiteDatabase, String str) {
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
                this.f2863O.m8657e0("Error querying for table", str, e);
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        C2221wh c2221wh;
        C2221wh c2221wh2;
        String m3752X0;
        C2221wh c2221wh3;
        c2221wh = this.f2863O.f2682S;
        if (!c2221wh.m9521c(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            c2221wh2 = this.f2863O.f2682S;
            c2221wh2.m9520b();
            this.f2863O.m8650B0("Opening the database failed, dropping the table and recreating it");
            C0986fg c0986fg = this.f2863O;
            m3752X0 = C0986fg.m3752X0();
            this.f2863O.m8675x().getDatabasePath(m3752X0).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                c2221wh3 = this.f2863O.f2682S;
                c2221wh3.m9519a();
                return writableDatabase;
            } catch (SQLiteException e) {
                this.f2863O.m8674w0("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (C0711ah.m2065a() < 9) {
            return;
        }
        File file = new File(path);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String str;
        if (Build.VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (m4120a(sQLiteDatabase, "hits2")) {
            Set<String> m4119b = m4119b(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i = 0; i < 4; i++) {
                String str2 = strArr[i];
                if (!m4119b.remove(str2)) {
                    String valueOf = String.valueOf(str2);
                    throw new SQLiteException(valueOf.length() != 0 ? "Database hits2 is missing required column: ".concat(valueOf) : new String("Database hits2 is missing required column: "));
                }
            }
            boolean z = !m4119b.remove("hit_app_id");
            if (!m4119b.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            str = C0986fg.f2678T;
            sQLiteDatabase.execSQL(str);
        }
        if (!m4120a(sQLiteDatabase, "properties")) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
        }
        Set<String> m4119b2 = m4119b(sQLiteDatabase, "properties");
        String[] strArr2 = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
        for (int i2 = 0; i2 < 6; i2++) {
            String str3 = strArr2[i2];
            if (!m4119b2.remove(str3)) {
                String valueOf2 = String.valueOf(str3);
                throw new SQLiteException(valueOf2.length() != 0 ? "Database properties is missing required column: ".concat(valueOf2) : new String("Database properties is missing required column: "));
            }
        }
        if (!m4119b2.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
