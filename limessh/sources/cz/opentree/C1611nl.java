package cz.opentree;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.nl */
/* loaded from: classes.dex */
public final class C1611nl {

    /* renamed from: a */
    @GuardedBy("PhenotypeConstants.class")
    public static final ArrayMap<String, Uri> f5303a = new ArrayMap<>();

    /* renamed from: a */
    public static synchronized Uri m6734a(String str) {
        Uri uri;
        synchronized (C1611nl.class) {
            ArrayMap<String, Uri> arrayMap = f5303a;
            uri = arrayMap.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }
}
