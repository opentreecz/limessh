package com.sonelli;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhf;
import com.sonelli.AbstractC1464km;
import com.sonelli.AbstractC1560mm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.km */
/* loaded from: classes.dex */
public abstract class AbstractC1464km<MessageType extends AbstractC1464km<MessageType, BuilderType>, BuilderType extends AbstractC1560mm<MessageType, BuilderType>> implements zzgt {
    public int zza = 0;

    /* renamed from: h */
    public static <T> void m5945h(Iterable<T> iterable, List<? super T> list) {
        C2435zn.m10538d(iterable);
        if (iterable instanceof zzga) {
            List<?> mo1242b = ((zzga) iterable).mo1242b();
            zzga zzgaVar = (zzga) list;
            int size = list.size();
            for (Object obj : mo1242b) {
                if (obj == null) {
                    int size2 = zzgaVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzgaVar.size() - 1; size3 >= size; size3--) {
                        zzgaVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof AbstractC1939tm) {
                    zzgaVar.mo1244y((AbstractC1939tm) obj);
                } else {
                    zzgaVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzhf) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    /* renamed from: g */
    public final AbstractC1939tm mo1265g() {
        try {
            C2433zm m8766r = AbstractC1939tm.m8766r(mo1267j());
            mo1264c(m8766r.m10505b());
            return m8766r.m10504a();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* renamed from: k */
    public final byte[] m5946k() {
        try {
            byte[] bArr = new byte[mo1267j()];
            AbstractC1116hn m4517f = AbstractC1116hn.m4517f(bArr);
            mo1264c(m4517f);
            m4517f.m4537N();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* renamed from: l */
    public int mo5947l() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: m */
    public void mo5948m(int i) {
        throw new UnsupportedOperationException();
    }
}
