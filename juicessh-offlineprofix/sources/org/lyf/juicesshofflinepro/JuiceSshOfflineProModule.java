package org.lyf.juicesshofflinepro;

import android.content.Context;
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* loaded from: classes.dex */
public final class JuiceSshOfflineProModule implements IXposedHookLoadPackage {
    private static final String MODULE_PACKAGE = "org.lyf.juicesshofflinepro";
    private static final long SECONDS_PER_YEAR = 31536000;
    private static final String TAG = "JuiceSSHOfflinePro";
    private static final String TARGET = "com.sonelli.juicessh";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Config {
        final boolean hookApiGate;
        final boolean hookProCheck;
        final boolean hookSessionExpiry;
        final boolean hookUserSignature;
        final int sessionYears;

        Config(boolean z, boolean z2, boolean z3, boolean z4, int i) {
            this.hookProCheck = z;
            this.hookUserSignature = z2;
            this.hookSessionExpiry = z3;
            this.hookApiGate = z4;
            this.sessionYears = Math.max(1, Math.min(100, i));
        }

        static Config load() {
            try {
                XSharedPreferences xSharedPreferences = new XSharedPreferences(JuiceSshOfflineProModule.MODULE_PACKAGE, "settings");
                xSharedPreferences.makeWorldReadable();
                xSharedPreferences.reload();
                return new Config(xSharedPreferences.getBoolean("hook_pro_check", true), xSharedPreferences.getBoolean("hook_user_signature", true), xSharedPreferences.getBoolean("hook_session_expiry", true), xSharedPreferences.getBoolean("hook_api_gate", true), xSharedPreferences.getInt("session_years", 10));
            } catch (Throwable th) {
                JuiceSshOfflineProModule.log("failed to read settings; using defaults", th);
                return new Config(true, true, true, true, 10);
            }
        }

        public String toString() {
            return "Config{pro=" + this.hookProCheck + ", userSig=" + this.hookUserSignature + ", session=" + this.hookSessionExpiry + ", apiGate=" + this.hookApiGate + ", years=" + this.sessionYears + '}';
        }
    }

    private void hookApiUserGate(final ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("com.sonelli.pi0", classLoader, "m", new Object[]{Context.class, XC_MethodReplacement.returnConstant(Boolean.TRUE)});
            log("hooked pi0.m(Context) => true");
        } catch (Throwable th) {
            log("failed to hook pi0.m", th);
        }
        try {
            XposedHelpers.findAndHookMethod("com.sonelli.pi0", classLoader, "j", new Object[]{Context.class, XposedHelpers.findClass("com.sonelli.pi0$p", classLoader), new XC_MethodReplacement(this) { // from class: org.lyf.juicesshofflinepro.JuiceSshOfflineProModule.1
                final /* synthetic */ JuiceSshOfflineProModule this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected java.lang.Object replaceHookedMethod(de.robv.android.xposed.XC_MethodHook.MethodHookParam r8) throws java.lang.Throwable {
                    /*
                        r7 = this;
                        java.lang.String r0 = "com.sonelli.juicessh.models.User"
                        java.lang.Object[] r1 = r8.args
                        r2 = 1
                        r1 = r1[r2]
                        r3 = 0
                        if (r1 != 0) goto Lb
                        return r3
                    Lb:
                        r4 = 0
                        java.lang.Object[] r5 = r8.args     // Catch: java.lang.Throwable -> L29
                        r5 = r5[r4]     // Catch: java.lang.Throwable -> L29
                        boolean r5 = r5 instanceof android.content.Context     // Catch: java.lang.Throwable -> L29
                        if (r5 == 0) goto L29
                        java.lang.ClassLoader r5 = r2     // Catch: java.lang.Throwable -> L29
                        java.lang.Class r5 = de.robv.android.xposed.XposedHelpers.findClass(r0, r5)     // Catch: java.lang.Throwable -> L29
                        java.lang.String r6 = "A"
                        java.lang.Object[] r8 = r8.args     // Catch: java.lang.Throwable -> L29
                        r8 = r8[r4]     // Catch: java.lang.Throwable -> L29
                        java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch: java.lang.Throwable -> L29
                        java.lang.Object r8 = de.robv.android.xposed.XposedHelpers.callStaticMethod(r5, r6, r8)     // Catch: java.lang.Throwable -> L29
                        goto L2a
                    L29:
                        r8 = r3
                    L2a:
                        if (r8 != 0) goto L3e
                        java.lang.ClassLoader r8 = r2
                        java.lang.Class r8 = de.robv.android.xposed.XposedHelpers.findClass(r0, r8)
                        java.lang.Class[] r0 = new java.lang.Class[r4]
                        java.lang.reflect.Constructor r8 = r8.getDeclaredConstructor(r0)
                        java.lang.Object[] r0 = new java.lang.Object[r4]
                        java.lang.Object r8 = r8.newInstance(r0)
                    L3e:
                        java.lang.Class r0 = r1.getClass()
                        java.lang.Class[] r5 = new java.lang.Class[r2]
                        java.lang.Class r6 = r8.getClass()
                        r5[r4] = r6
                        java.lang.String r4 = "b"
                        java.lang.reflect.Method r0 = r0.getMethod(r4, r5)
                        r0.setAccessible(r2)
                        java.lang.Object[] r8 = new java.lang.Object[]{r8}
                        r0.invoke(r1, r8)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.lyf.juicesshofflinepro.JuiceSshOfflineProModule.C00001.replaceHookedMethod(de.robv.android.xposed.XC_MethodHook$MethodHookParam):java.lang.Object");
                }
            }});
            log("hooked pi0.j(Context,p) => local callback, no network refresh");
        } catch (Throwable th2) {
            log("failed to hook pi0.j", th2);
        }
    }

    private void hookProCheck(ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("com.sonelli.oi0", classLoader, "d", new Object[]{Object.class, XC_MethodReplacement.returnConstant(Boolean.TRUE)});
            log("hooked com.sonelli.oi0.d(Object) => true");
        } catch (Throwable th) {
            log("failed to hook oi0.d", th);
        }
    }

    private void hookUserSignatureAndSession(ClassLoader classLoader, Config config) {
        if (config.hookUserSignature) {
            try {
                XposedHelpers.findAndHookMethod("com.sonelli.juicessh.models.User", classLoader, "H", new Object[]{XC_MethodReplacement.returnConstant(Boolean.TRUE)});
                log("hooked User.H() => true");
            } catch (Throwable th) {
                log("failed to hook User.H", th);
            }
        }
        if (config.hookSessionExpiry) {
            try {
                XposedHelpers.findAndHookMethod("com.sonelli.juicessh.models.User", classLoader, "w", new Object[]{XC_MethodReplacement.returnConstant(Long.valueOf(config.sessionYears * SECONDS_PER_YEAR))});
                log("hooked User.w() => " + config.sessionYears + " years");
            } catch (Throwable th2) {
                log("failed to hook User.w", th2);
            }
        }
    }

    private static void log(String str) {
        XposedBridge.log("JuiceSSHOfflinePro: " + str);
        Log.i(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str, Throwable th) {
        XposedBridge.log("JuiceSSHOfflinePro: " + str + "\n" + Log.getStackTraceString(th));
        Log.e(TAG, str, th);
    }

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (TARGET.equals(loadPackageParam.packageName)) {
            Config load = Config.load();
            log("hooking " + loadPackageParam.packageName + " with " + load);
            if (load.hookProCheck) {
                hookProCheck(loadPackageParam.classLoader);
            }
            if (load.hookUserSignature || load.hookSessionExpiry) {
                hookUserSignatureAndSession(loadPackageParam.classLoader, load);
            }
            if (load.hookApiGate) {
                hookApiUserGate(loadPackageParam.classLoader);
            }
        }
    }
}
