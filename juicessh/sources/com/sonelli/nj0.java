package com.sonelli;

import android.net.Uri;
import android.provider.BaseColumns;
import com.j256.ormlite.field.FieldType;

/* compiled from: PluginContract.java */
/* loaded from: classes.dex */
public class nj0 implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5302a = Uri.parse("content://com.sonelli.juicessh.api.v1/connections");

    static {
        String.format("rowid AS %s", FieldType.FOREIGN_ID_FIELD_SUFFIX);
        String.format("COALESCE(NULLIF(nickname,''), address) AS %s", "name");
    }
}
