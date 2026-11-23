package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.sonelli.BinderC1548md;
import com.sonelli.C0813ca;
import com.sonelli.C0869dc;
import com.sonelli.C1650od;
import com.sonelli.C1699pd;
import com.sonelli.C1756qd;
import com.sonelli.C1812rd;
import com.sonelli.C1856sd;
import com.sonelli.C1928td;
import com.sonelli.C2004ud;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: b */
    @GuardedBy("DynamiteModule.class")
    public static Boolean f931b = null;

    /* renamed from: c */
    @GuardedBy("DynamiteModule.class")
    public static zzj f932c = null;

    /* renamed from: d */
    @GuardedBy("DynamiteModule.class")
    public static zzl f933d = null;

    /* renamed from: e */
    @GuardedBy("DynamiteModule.class")
    public static String f934e = null;

    /* renamed from: f */
    @GuardedBy("DynamiteModule.class")
    public static int f935f = -1;

    /* renamed from: g */
    public static final ThreadLocal<C0449b> f936g = new ThreadLocal<>();

    /* renamed from: h */
    public static final VersionPolicy.zzb f937h = new C1650od();

    /* renamed from: i */
    public static final VersionPolicy f938i = new C1699pd();

    /* renamed from: j */
    public static final VersionPolicy f939j = new C1756qd();

    /* renamed from: k */
    public static final VersionPolicy f940k = new C1812rd();

    /* renamed from: a */
    public final Context f941a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$a */
        /* loaded from: classes.dex */
        public static class C0447a {

            /* renamed from: a */
            public int f942a = 0;

            /* renamed from: b */
            public int f943b = 0;

            /* renamed from: c */
            public int f944c = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* loaded from: classes.dex */
        public interface zzb {
            /* renamed from: a */
            int mo1196a(Context context, String str);

            /* renamed from: b */
            int mo1197b(Context context, String str, boolean z) throws C0448a;
        }

        /* renamed from: a */
        C0447a mo1195a(Context context, String str, zzb zzbVar) throws C0448a;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a */
    /* loaded from: classes.dex */
    public static class C0448a extends Exception {
        public C0448a(String str) {
            super(str);
        }

        public /* synthetic */ C0448a(String str, C1650od c1650od) {
            this(str);
        }

        public C0448a(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ C0448a(String str, Throwable th, C1650od c1650od) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b */
    /* loaded from: classes.dex */
    public static class C0449b {

        /* renamed from: a */
        public Cursor f945a;

        public C0449b() {
        }

        public /* synthetic */ C0449b(C1650od c1650od) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$c */
    /* loaded from: classes.dex */
    public static class C0450c implements VersionPolicy.zzb {

        /* renamed from: a */
        public final int f946a;

        public C0450c(int i, int i2) {
            this.f946a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        /* renamed from: a */
        public final int mo1196a(Context context, String str) {
            return this.f946a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        /* renamed from: b */
        public final int mo1197b(Context context, String str, boolean z) {
            return 0;
        }
    }

    public DynamiteModule(Context context) {
        C0813ca.m2729k(context);
        this.f941a = context;
    }

    /* renamed from: a */
    public static int m1182a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /* renamed from: b */
    public static int m1183b(Context context, String str) {
        return m1185e(context, str, false);
    }

    /* renamed from: d */
    public static DynamiteModule m1184d(Context context, VersionPolicy versionPolicy, String str) throws C0448a {
        ThreadLocal<C0449b> threadLocal = f936g;
        C0449b c0449b = threadLocal.get();
        C1650od c1650od = null;
        C0449b c0449b2 = new C0449b(c1650od);
        threadLocal.set(c0449b2);
        try {
            VersionPolicy.C0447a mo1195a = versionPolicy.mo1195a(context, str, f937h);
            int i = mo1195a.f942a;
            int i2 = mo1195a.f943b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            int i3 = mo1195a.f944c;
            if (i3 == 0 || ((i3 == -1 && mo1195a.f942a == 0) || (i3 == 1 && mo1195a.f943b == 0))) {
                int i4 = mo1195a.f942a;
                int i5 = mo1195a.f943b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new C0448a(sb2.toString(), c1650od);
            }
            if (i3 == -1) {
                DynamiteModule m1192l = m1192l(context, str);
                Cursor cursor = c0449b2.f945a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(c0449b);
                return m1192l;
            }
            if (i3 != 1) {
                int i6 = mo1195a.f944c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new C0448a(sb3.toString(), c1650od);
            }
            try {
                DynamiteModule m1186f = m1186f(context, str, mo1195a.f943b);
                Cursor cursor2 = c0449b2.f945a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(c0449b);
                return m1186f;
            } catch (C0448a e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                int i7 = mo1195a.f942a;
                if (i7 == 0 || versionPolicy.mo1195a(context, str, new C0450c(i7, 0)).f944c != -1) {
                    throw new C0448a("Remote load failed. No local fallback found.", e, c1650od);
                }
                DynamiteModule m1192l2 = m1192l(context, str);
                Cursor cursor3 = c0449b2.f945a;
                if (cursor3 != null) {
                    cursor3.close();
                }
                f936g.set(c0449b);
                return m1192l2;
            }
        } catch (Throwable th) {
            Cursor cursor4 = c0449b2.f945a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f936g.set(c0449b);
            throw th;
        }
    }

    /* renamed from: e */
    public static int m1185e(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f931b;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    m1187g(classLoader);
                                } catch (C0448a unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int m1191k = m1191k(context, str, z);
                                String str2 = f934e;
                                if (str2 != null && !str2.isEmpty()) {
                                    ClassLoader delegateLastClassLoader = Build.VERSION.SDK_INT >= 29 ? new DelegateLastClassLoader(f934e, ClassLoader.getSystemClassLoader()) : new C1856sd(f934e, ClassLoader.getSystemClassLoader());
                                    m1187g(delegateLastClassLoader);
                                    declaredField.set(null, delegateLastClassLoader);
                                    f931b = Boolean.TRUE;
                                    return m1191k;
                                }
                                return m1191k;
                            } catch (C0448a unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        f931b = bool2;
                    }
                }
                if (!bool2.booleanValue()) {
                    return m1189i(context, str, z);
                }
                try {
                    return m1191k(context, str, z);
                } catch (C0448a e2) {
                    String valueOf2 = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                    return 0;
                }
            }
        } catch (Throwable th) {
            C0869dc.m3183a(context, th);
            throw th;
        }
    }

    /* renamed from: f */
    public static DynamiteModule m1186f(Context context, String str, int i) throws C0448a {
        Boolean bool;
        IObjectWrapper mo1199T;
        C1650od c1650od = null;
        try {
            synchronized (DynamiteModule.class) {
                bool = f931b;
            }
            if (bool == null) {
                throw new C0448a("Failed to determine which loading route to use.", c1650od);
            }
            if (bool.booleanValue()) {
                return m1190j(context, str, i);
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("Selected remote version of ");
            sb.append(str);
            sb.append(", version >= ");
            sb.append(i);
            Log.i("DynamiteModule", sb.toString());
            zzj m1193m = m1193m(context);
            if (m1193m == null) {
                throw new C0448a("Failed to create IDynamiteLoader.", c1650od);
            }
            if (m1193m.mo1198I0() >= 2) {
                mo1199T = m1193m.mo1202y0(BinderC1548md.m6402O0(context), str, i);
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                mo1199T = m1193m.mo1199T(BinderC1548md.m6402O0(context), str, i);
            }
            if (BinderC1548md.m6403s(mo1199T) != null) {
                return new DynamiteModule((Context) BinderC1548md.m6403s(mo1199T));
            }
            throw new C0448a("Failed to load remote module.", c1650od);
        } catch (RemoteException e) {
            throw new C0448a("Failed to load remote module.", e, c1650od);
        } catch (C0448a e2) {
            throw e2;
        } catch (Throwable th) {
            C0869dc.m3183a(context, th);
            throw new C0448a("Failed to load remote module.", th, c1650od);
        }
    }

    @GuardedBy("DynamiteModule.class")
    /* renamed from: g */
    public static void m1187g(ClassLoader classLoader) throws C0448a {
        zzl c2004ud;
        C1650od c1650od = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                c2004ud = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                c2004ud = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new C2004ud(iBinder);
            }
            f933d = c2004ud;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new C0448a("Failed to instantiate dynamite loader", e, c1650od);
        }
    }

    /* renamed from: h */
    public static Boolean m1188h() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f935f >= 2);
        }
        return valueOf;
    }

    /* renamed from: i */
    public static int m1189i(Context context, String str, boolean z) {
        zzj m1193m = m1193m(context);
        if (m1193m == null) {
            return 0;
        }
        try {
            if (m1193m.mo1198I0() >= 2) {
                return m1193m.mo1200m0(BinderC1548md.m6402O0(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return m1193m.mo1201u0(BinderC1548md.m6402O0(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* renamed from: j */
    public static DynamiteModule m1190j(Context context, String str, int i) throws C0448a, RemoteException {
        zzl zzlVar;
        IObjectWrapper mo1203A;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzlVar = f933d;
        }
        C1650od c1650od = null;
        if (zzlVar == null) {
            throw new C0448a("DynamiteLoaderV2 was not cached.", c1650od);
        }
        C0449b c0449b = f936g.get();
        if (c0449b == null || c0449b.f945a == null) {
            throw new C0448a("No result cursor", c1650od);
        }
        Context applicationContext = context.getApplicationContext();
        Cursor cursor = c0449b.f945a;
        BinderC1548md.m6402O0(null);
        if (m1188h().booleanValue()) {
            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
            mo1203A = zzlVar.mo1204B(BinderC1548md.m6402O0(applicationContext), str, i, BinderC1548md.m6402O0(cursor));
        } else {
            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
            mo1203A = zzlVar.mo1203A(BinderC1548md.m6402O0(applicationContext), str, i, BinderC1548md.m6402O0(cursor));
        }
        Context context2 = (Context) BinderC1548md.m6403s(mo1203A);
        if (context2 != null) {
            return new DynamiteModule(context2);
        }
        throw new C0448a("Failed to get module context", c1650od);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.sonelli.od] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m1191k(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.C0448a {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f934e = r1     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f935f = r1     // Catch: java.lang.Throwable -> L79
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r10 = com.google.android.gms.dynamite.DynamiteModule.f936g     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$b r10 = (com.google.android.gms.dynamite.DynamiteModule.C0449b) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7c
            android.database.Cursor r1 = r10.f945a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7c
            r10.f945a = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            goto L7d
        L79:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7c:
            r0 = r8
        L7d:
            if (r0 == 0) goto L82
            r0.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.C0448a     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m1191k(android.content.Context, java.lang.String, boolean):int");
    }

    /* renamed from: l */
    public static DynamiteModule m1192l(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* renamed from: m */
    public static zzj m1193m(Context context) {
        zzj c1928td;
        synchronized (DynamiteModule.class) {
            zzj zzjVar = f932c;
            if (zzjVar != null) {
                return zzjVar;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c1928td = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c1928td = queryLocalInterface instanceof zzj ? (zzj) queryLocalInterface : new C1928td(iBinder);
                }
                if (c1928td != null) {
                    f932c = c1928td;
                    return c1928td;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    /* renamed from: c */
    public final IBinder m1194c(String str) throws C0448a {
        try {
            return (IBinder) this.f941a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new C0448a(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
