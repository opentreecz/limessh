package cz.opentree;

import java.util.Comparator;

/* renamed from: cz.opentree.g4 */
/* loaded from: classes.dex */
public final class C1026g4 implements Comparator<AbstractC1142i4> {
    public C1026g4(C0969f4 c0969f4) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(AbstractC1142i4 abstractC1142i4, AbstractC1142i4 abstractC1142i42) {
        return abstractC1142i4.getClass().getCanonicalName().compareTo(abstractC1142i42.getClass().getCanonicalName());
    }
}
