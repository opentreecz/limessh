package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.sonelli.C0693a3;
import com.sonelli.C0750b3;
import com.sonelli.C0806c3;
import com.sonelli.C0858d3;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes.dex */
public final class SchemaManager extends SQLiteOpenHelper {

    /* renamed from: Q */
    public static int f521Q = 4;

    /* renamed from: R */
    public static final Migration f522R;

    /* renamed from: S */
    public static final Migration f523S;

    /* renamed from: T */
    public static final Migration f524T;

    /* renamed from: U */
    public static final Migration f525U;

    /* renamed from: V */
    public static final List<Migration> f526V;

    /* renamed from: O */
    public final int f527O;

    /* renamed from: P */
    public boolean f528P;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes.dex */
    public interface Migration {
        /* renamed from: a */
        void mo805a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        Migration m1976b = C0693a3.m1976b();
        f522R = m1976b;
        Migration m2358b = C0750b3.m2358b();
        f523S = m2358b;
        Migration m2661b = C0806c3.m2661b();
        f524T = m2661b;
        Migration m3111b = C0858d3.m3111b();
        f525U = m3111b;
        f526V = Arrays.asList(m1976b, m2358b, m2661b, m3111b);
    }

    public SchemaManager(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f528P = false;
        this.f527O = i;
    }

    /* renamed from: b */
    public static /* synthetic */ void m799b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* renamed from: c */
    public static /* synthetic */ void m800c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* renamed from: f */
    public static /* synthetic */ void m802f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* renamed from: a */
    public final void m803a(SQLiteDatabase sQLiteDatabase) {
        if (this.f528P) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    /* renamed from: h */
    public final void m804h(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<Migration> list = f526V;
        if (i2 <= list.size()) {
            while (i < i2) {
                f526V.get(i).mo805a(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f528P = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m803a(sQLiteDatabase);
        m804h(sQLiteDatabase, 0, this.f527O);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        m803a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m803a(sQLiteDatabase);
        m804h(sQLiteDatabase, i, i2);
    }
}
