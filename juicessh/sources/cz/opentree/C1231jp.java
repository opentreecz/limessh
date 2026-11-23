package cz.opentree;

import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.jp */
/* loaded from: classes.dex */
public final class C1231jp<FieldDescriptorType> extends C1468kp<FieldDescriptorType, Object> {
    public C1231jp(int i) {
        super(i, null);
    }

    @Override // cz.opentree.C1468kp
    /* renamed from: e */
    public final void mo5180e() {
        if (!m5980i()) {
            for (int i = 0; i < m5981j(); i++) {
                Map.Entry<FieldDescriptorType, Object> m5979h = m5979h(i);
                if (((zzfd) m5979h.getKey()).mo1229d()) {
                    m5979h.setValue(Collections.unmodifiableList((List) m5979h.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : m5983m()) {
                if (((zzfd) entry.getKey()).mo1229d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo5180e();
    }
}
