package com.sonelli;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: com.sonelli.og */
/* loaded from: classes.dex */
public final class C1653og extends AbstractC2006uf {

    /* renamed from: Q */
    public volatile String f5480Q;

    /* renamed from: R */
    public Future<String> f5481R;

    public C1653og(C2216wf c2216wf) {
        super(c2216wf);
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
    }

    /* renamed from: H0 */
    public final boolean m7027H0(Context context, String str) {
        C0813ca.m2725g(str);
        C0813ca.m2728j("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    m8679z("Storing clientId", str);
                    fileOutputStream = context.openFileOutput("gaClientId", 0);
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream == null) {
                        return true;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        m8674w0("Failed to close clientId writing stream", e);
                        return true;
                    }
                } catch (FileNotFoundException e2) {
                    m8674w0("Error creating clientId file", e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            m8674w0("Failed to close clientId writing stream", e3);
                        }
                    }
                    return false;
                }
            } catch (IOException e4) {
                m8674w0("Error writing to clientId file", e4);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        m8674w0("Failed to close clientId writing stream", e5);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    m8674w0("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x007f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:54:0x007f */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: I0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m7028I0(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.sonelli.C0813ca.m2728j(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69 java.io.FileNotFoundException -> L8b
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            int r7 = r3.available()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            if (r7 <= 0) goto L33
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.m8649A0(r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L32
            r3.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r9 = move-exception
            r8.m8674w0(r1, r9)
        L32:
            return r2
        L33:
            r7 = 14
            if (r4 >= r7) goto L4d
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.m8649A0(r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r9 = move-exception
            r8.m8674w0(r1, r9)
        L4c:
            return r2
        L4d:
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            r7.<init>(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            java.lang.String r4 = "Read client id from disk"
            r8.m8679z(r4, r7)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7e java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r9 = move-exception
            r8.m8674w0(r1, r9)
        L64:
            return r7
        L65:
            r4 = move-exception
            goto L6b
        L67:
            r9 = move-exception
            goto L80
        L69:
            r4 = move-exception
            r3 = r2
        L6b:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.m8674w0(r5, r4)     // Catch: java.lang.Throwable -> L7e
            r9.deleteFile(r0)     // Catch: java.lang.Throwable -> L7e
            if (r3 == 0) goto L7d
            r3.close()     // Catch: java.io.IOException -> L79
            goto L7d
        L79:
            r9 = move-exception
            r8.m8674w0(r1, r9)
        L7d:
            return r2
        L7e:
            r9 = move-exception
            r2 = r3
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L86
            goto L8a
        L86:
            r0 = move-exception
            r8.m8674w0(r1, r0)
        L8a:
            throw r9
        L8b:
            r3 = r2
        L8c:
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.io.IOException -> L92
            goto L96
        L92:
            r9 = move-exception
            r8.m8674w0(r1, r9)
        L96:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1653og.m7028I0(android.content.Context):java.lang.String");
    }

    /* renamed from: J0 */
    public final String m7029J0() {
        String str;
        m8878F0();
        synchronized (this) {
            if (this.f5480Q == null) {
                this.f5481R = m8662j0().m5828c(new CallableC1702pg(this));
            }
            Future<String> future = this.f5481R;
            if (future != null) {
                try {
                    this.f5480Q = future.get();
                } catch (InterruptedException e) {
                    m8672t0("ClientId loading or generation was interrupted", e);
                    this.f5480Q = "0";
                } catch (ExecutionException e2) {
                    m8674w0("Failed to load or generate client id", e2);
                    this.f5480Q = "0";
                }
                if (this.f5480Q == null) {
                    this.f5480Q = "0";
                }
                m8679z("Loaded clientId", this.f5480Q);
                this.f5481R = null;
            }
            str = this.f5480Q;
        }
        return str;
    }

    /* renamed from: K0 */
    public final String m7030K0() {
        synchronized (this) {
            this.f5480Q = null;
            this.f5481R = m8662j0().m5828c(new CallableC1761qg(this));
        }
        return m7029J0();
    }

    /* renamed from: L0 */
    public final String m7031L0() {
        String m7028I0 = m7028I0(m8662j0().m5827a());
        return m7028I0 == null ? m7032M0() : m7028I0;
    }

    /* renamed from: M0 */
    public final String m7032M0() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !m7027H0(m8662j0().m5827a(), lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            m8674w0("Error saving clientId file", e);
            return "0";
        }
    }
}
