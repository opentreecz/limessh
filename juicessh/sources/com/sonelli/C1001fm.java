package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.fm */
/* loaded from: classes.dex */
public final class C1001fm {

    /* renamed from: a */
    public static final AbstractC0946em f2721a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: com.sonelli.fm$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC0946em {
        @Override // com.sonelli.AbstractC0946em
        /* renamed from: a */
        public final void mo3530a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Integer r0 = m3805a()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L14
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L2a
            r2 = 19
            if (r1 < r2) goto L14
            com.sonelli.jm r1 = new com.sonelli.jm     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L14:
            java.lang.String r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch: java.lang.Throwable -> L2a
            r1 = r1 ^ 1
            if (r1 == 0) goto L24
            com.sonelli.im r1 = new com.sonelli.im     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L24:
            com.sonelli.fm$a r1 = new com.sonelli.fm$a     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L63
        L2a:
            r1 = move-exception
            goto L2e
        L2c:
            r1 = move-exception
            r0 = 0
        L2e:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<com.sonelli.fm$a> r3 = com.sonelli.C1001fm.a.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 133
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
            com.sonelli.fm$a r1 = new com.sonelli.fm$a
            r1.<init>()
        L63:
            com.sonelli.C1001fm.f2721a = r1
            if (r0 != 0) goto L68
            goto L6b
        L68:
            r0.intValue()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1001fm.<clinit>():void");
    }

    /* renamed from: a */
    public static Integer m3805a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* renamed from: b */
    public static void m3806b(Throwable th, Throwable th2) {
        f2721a.mo3530a(th, th2);
    }
}
