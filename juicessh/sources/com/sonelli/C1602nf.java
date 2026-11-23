package com.sonelli;

import android.text.TextUtils;
import com.sonelli.C1688p3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.sonelli.nf */
/* loaded from: classes.dex */
public final class C1602nf extends AbstractC2006uf {

    /* renamed from: V */
    public static boolean f5261V;

    /* renamed from: Q */
    public C1688p3.a f5262Q;

    /* renamed from: R */
    public final C2221wh f5263R;

    /* renamed from: S */
    public String f5264S;

    /* renamed from: T */
    public boolean f5265T;

    /* renamed from: U */
    public final Object f5266U;

    public C1602nf(C2216wf c2216wf) {
        super(c2216wf);
        this.f5265T = false;
        this.f5266U = new Object();
        this.f5263R = new C2221wh(c2216wf.m9476d());
    }

    /* renamed from: M0 */
    public static String m6665M0(String str) {
        MessageDigest m2079h = C0713ai.m2079h("MD5");
        if (m2079h == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, m2079h.digest(str.getBytes())));
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
    }

    /* renamed from: G0 */
    public final boolean m6666G0(C1688p3.a aVar, C1688p3.a aVar2) {
        String str = null;
        String m7239a = aVar2 == null ? null : aVar2.m7239a();
        if (TextUtils.isEmpty(m7239a)) {
            return true;
        }
        String m7029J0 = m8668p0().m7029J0();
        synchronized (this.f5266U) {
            if (!this.f5265T) {
                this.f5264S = m6671L0();
                this.f5265T = true;
            } else if (TextUtils.isEmpty(this.f5264S)) {
                if (aVar != null) {
                    str = aVar.m7239a();
                }
                if (str == null) {
                    String valueOf = String.valueOf(m7239a);
                    String valueOf2 = String.valueOf(m7029J0);
                    return m6672N0(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                String valueOf3 = String.valueOf(str);
                String valueOf4 = String.valueOf(m7029J0);
                this.f5264S = m6665M0(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            }
            String valueOf5 = String.valueOf(m7239a);
            String valueOf6 = String.valueOf(m7029J0);
            String m6665M0 = m6665M0(valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
            if (TextUtils.isEmpty(m6665M0)) {
                return false;
            }
            if (m6665M0.equals(this.f5264S)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.f5264S)) {
                m8676x0("Resetting the client id because Advertising Id changed.");
                m7029J0 = m8668p0().m7030K0();
                m8679z("New client Id", m7029J0);
            }
            String valueOf7 = String.valueOf(m7239a);
            String valueOf8 = String.valueOf(m7029J0);
            return m6672N0(valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7));
        }
    }

    /* renamed from: H0 */
    public final boolean m6667H0() {
        m8878F0();
        C1688p3.a m6669J0 = m6669J0();
        return (m6669J0 == null || m6669J0.m7240b()) ? false : true;
    }

    /* renamed from: I0 */
    public final String m6668I0() {
        m8878F0();
        C1688p3.a m6669J0 = m6669J0();
        String m7239a = m6669J0 != null ? m6669J0.m7239a() : null;
        if (TextUtils.isEmpty(m7239a)) {
            return null;
        }
        return m7239a;
    }

    /* renamed from: J0 */
    public final synchronized C1688p3.a m6669J0() {
        if (this.f5263R.m9521c(1000L)) {
            this.f5263R.m9520b();
            C1688p3.a m6670K0 = m6670K0();
            if (m6666G0(this.f5262Q, m6670K0)) {
                this.f5262Q = m6670K0;
            } else {
                m8650B0("Failed to reset client id on adid change. Not using adid");
                this.f5262Q = new C1688p3.a("", false);
            }
        }
        return this.f5262Q;
    }

    /* renamed from: K0 */
    public final C1688p3.a m6670K0() {
        try {
            return C1688p3.m7230b(m8675x());
        } catch (IllegalStateException unused) {
            m8649A0("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Exception e) {
            if (!f5261V) {
                f5261V = true;
                m8672t0("Error getting advertiser id", e);
            }
            return null;
        }
    }

    /* renamed from: L0 */
    public final String m6671L0() {
        String str = null;
        try {
            FileInputStream openFileInput = m8675x().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                m8649A0("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                m8675x().deleteFile("gaClientIdData");
            } else if (read <= 0) {
                m8676x0("Hash file is empty.");
                openFileInput.close();
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                } catch (IOException e) {
                    e = e;
                    str = str2;
                    m8672t0("Error reading Hash file, deleting it", e);
                    m8675x().deleteFile("gaClientIdData");
                    return str;
                }
                str = str2;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e2) {
            e = e2;
        }
        return str;
    }

    /* renamed from: N0 */
    public final boolean m6672N0(String str) {
        try {
            String m6665M0 = m6665M0(str);
            m8676x0("Storing hashed adid.");
            FileOutputStream openFileOutput = m8675x().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(m6665M0.getBytes());
            openFileOutput.close();
            this.f5264S = m6665M0;
            return true;
        } catch (IOException e) {
            m8674w0("Error creating hash file", e);
            return false;
        }
    }
}
