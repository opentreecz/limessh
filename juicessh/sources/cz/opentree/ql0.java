package cz.opentree;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkBitmapHunter.java */
/* loaded from: classes.dex */
public class ql0 extends fl0 {

    /* renamed from: e0 */
    public final Downloader f6050e0;

    /* renamed from: f0 */
    public int f6051f0;

    public ql0(Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var, Downloader downloader) {
        super(picasso, jl0Var, cache, xl0Var, dl0Var);
        this.f6050e0 = downloader;
        this.f6051f0 = 2;
    }

    /* renamed from: A */
    public final Bitmap m7741A(InputStream inputStream, ul0 ul0Var) throws IOException {
        ol0 ol0Var = new ol0(inputStream);
        long m7052b = ol0Var.m7052b(65536);
        BitmapFactory.Options m3783f = fl0.m3783f(ul0Var);
        boolean m3785t = fl0.m3785t(m3783f);
        boolean m2578s = bm0.m2578s(ol0Var);
        ol0Var.m7051a(m7052b);
        if (m2578s) {
            byte[] m2582w = bm0.m2582w(ol0Var);
            if (m3785t) {
                BitmapFactory.decodeByteArray(m2582w, 0, m2582w.length, m3783f);
                fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
            }
            return BitmapFactory.decodeByteArray(m2582w, 0, m2582w.length, m3783f);
        }
        if (m3785t) {
            BitmapFactory.decodeStream(ol0Var, null, m3783f);
            fl0.m3782d(ul0Var.f7001f, ul0Var.f7002g, m3783f);
            ol0Var.m7051a(m7052b);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(ol0Var, null, m3783f);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    @Override // cz.opentree.fl0
    /* renamed from: g */
    public Bitmap mo3528g(ul0 ul0Var) throws IOException {
        Downloader.C2448a mo2146a = this.f6050e0.mo2146a(ul0Var.f6998c, this.f6051f0 == 0);
        if (mo2146a == null) {
            return null;
        }
        this.f2715Z = mo2146a.f8616c ? Picasso.EnumC2454d.DISK : Picasso.EnumC2454d.NETWORK;
        Bitmap m10672a = mo2146a.m10672a();
        if (m10672a != null) {
            return m10672a;
        }
        InputStream m10674c = mo2146a.m10674c();
        if (m10674c == null) {
            return null;
        }
        if (mo2146a.m10673b() == 0) {
            bm0.m2564e(m10674c);
            throw new IOException("Received response with 0 content-length header.");
        }
        if (this.f2715Z == Picasso.EnumC2454d.NETWORK && mo2146a.m10673b() > 0) {
            this.f2707R.m9807f(mo2146a.m10673b());
        }
        try {
            return m7741A(m10674c, ul0Var);
        } finally {
            bm0.m2564e(m10674c);
        }
    }

    @Override // cz.opentree.fl0
    /* renamed from: v */
    public boolean mo3801v(boolean z, NetworkInfo networkInfo) {
        int i = this.f6051f0;
        if (!(i > 0)) {
            return false;
        }
        this.f6051f0 = i - 1;
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // cz.opentree.fl0
    /* renamed from: x */
    public boolean mo3803x() {
        return true;
    }
}
