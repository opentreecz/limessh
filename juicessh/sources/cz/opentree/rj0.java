package cz.opentree;

import android.net.Uri;
import android.provider.BaseColumns;
import com.j256.ormlite.field.FieldType;

/* compiled from: PluginContract.java */
/* loaded from: classes.dex */
public final class rj0 implements BaseColumns {

    /* renamed from: a */
    public static final Uri f6224a = Uri.parse("content://cz.opentree.juicessh.api.v1/snippets");

    static {
        String.format("rowid AS %s", FieldType.FOREIGN_ID_FIELD_SUFFIX);
    }
}
