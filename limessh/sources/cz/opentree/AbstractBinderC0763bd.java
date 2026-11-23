package cz.opentree;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.bd */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0763bd extends AbstractBinderC0816cb {

    /* renamed from: a */
    public int f1647a;

    public AbstractBinderC0763bd(byte[] bArr) {
        C0813ca.m2719a(bArr.length == 25);
        this.f1647a = Arrays.hashCode(bArr);
    }

    /* renamed from: O0 */
    public static byte[] m2433O0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: b */
    public final IObjectWrapper mo1139b() {
        return BinderC1548md.m6402O0(mo2434s());
    }

    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: c */
    public final int mo1140c() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        IObjectWrapper mo1139b;
        if (obj != null && (obj instanceof zzi)) {
            try {
                zzi zziVar = (zzi) obj;
                if (zziVar.mo1140c() == hashCode() && (mo1139b = zziVar.mo1139b()) != null) {
                    return Arrays.equals(mo2434s(), (byte[]) BinderC1548md.m6403s(mo1139b));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1647a;
    }

    /* renamed from: s */
    public abstract byte[] mo2434s();
}
