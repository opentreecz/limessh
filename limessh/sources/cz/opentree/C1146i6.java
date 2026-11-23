package cz.opentree;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.i6 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1146i6 implements Comparator {

    /* renamed from: a */
    public static final Comparator f3268a = new C1146i6();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Scope) obj).m993x().compareTo(((Scope) obj2).m993x());
        return compareTo;
    }
}
