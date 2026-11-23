package com.sun.jna;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class Platform {
    public static final int AIX = 7;
    public static final int ANDROID = 8;
    public static final String ARCH;
    public static final String C_LIBRARY_NAME;
    public static final int FREEBSD = 4;
    public static final int GNU = 9;
    public static final boolean HAS_AWT;
    public static final boolean HAS_BUFFERS;
    public static final boolean HAS_DLL_CALLBACKS;
    public static final boolean HAS_JAWT;
    public static final int KFREEBSD = 10;
    public static final int LINUX = 1;
    public static final int MAC = 0;
    public static final String MATH_LIBRARY_NAME;
    public static final int NETBSD = 11;
    public static final int OPENBSD = 5;
    public static final String RESOURCE_PREFIX;
    public static final boolean RO_FIELDS;
    public static final int SOLARIS = 3;
    public static final int UNSPECIFIED = -1;
    public static final int WINDOWS = 2;
    public static final int WINDOWSCE = 6;
    private static final int osType;

    static {
        boolean z;
        String property = System.getProperty("os.name");
        if (property.startsWith("Linux")) {
            if ("dalvik".equals(System.getProperty("java.vm.name").toLowerCase())) {
                osType = 8;
                System.setProperty("jna.nounpack", "true");
            } else {
                osType = 1;
            }
        } else if (property.startsWith("AIX")) {
            osType = 7;
        } else if (property.startsWith("Mac") || property.startsWith("Darwin")) {
            osType = 0;
        } else if (property.startsWith("Windows CE")) {
            osType = 6;
        } else if (property.startsWith("Windows")) {
            osType = 2;
        } else if (property.startsWith("Solaris") || property.startsWith("SunOS")) {
            osType = 3;
        } else if (property.startsWith("FreeBSD")) {
            osType = 4;
        } else if (property.startsWith("OpenBSD")) {
            osType = 5;
        } else if (property.equalsIgnoreCase("gnu")) {
            osType = 9;
        } else if (property.equalsIgnoreCase("gnu/kfreebsd")) {
            osType = 10;
        } else if (property.equalsIgnoreCase("netbsd")) {
            osType = 11;
        } else {
            osType = -1;
        }
        try {
            Class.forName("java.nio.Buffer");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        int i = osType;
        boolean z2 = (i == 6 || i == 8 || i == 7) ? false : true;
        HAS_AWT = z2;
        HAS_JAWT = z2 && i != 0;
        HAS_BUFFERS = z;
        RO_FIELDS = i != 6;
        String str = "coredll";
        C_LIBRARY_NAME = i == 2 ? "msvcrt" : i == 6 ? "coredll" : "c";
        if (i == 2) {
            str = "msvcrt";
        } else if (i != 6) {
            str = "m";
        }
        MATH_LIBRARY_NAME = str;
        HAS_DLL_CALLBACKS = i == 2;
        ARCH = getCanonicalArchitecture(System.getProperty("os.arch"), i);
        RESOURCE_PREFIX = getNativeLibraryResourcePrefix();
    }

    private Platform() {
    }

    public static String getCanonicalArchitecture(String str, int i) {
        String trim = str.toLowerCase().trim();
        if ("powerpc".equals(trim)) {
            trim = "ppc";
        } else if ("powerpc64".equals(trim)) {
            trim = "ppc64";
        } else if ("i386".equals(trim) || "i686".equals(trim)) {
            trim = "x86";
        } else if ("x86_64".equals(trim) || "amd64".equals(trim)) {
            trim = "x86-64";
        }
        if ("ppc64".equals(trim) && "little".equals(System.getProperty("sun.cpu.endian"))) {
            trim = "ppc64le";
        }
        return ("arm".equals(trim) && i == 1 && isSoftFloat()) ? "armel" : trim;
    }

    public static String getNativeLibraryResourcePrefix() {
        String property = System.getProperty("jna.prefix");
        return property != null ? property : getNativeLibraryResourcePrefix(getOSType(), System.getProperty("os.arch"), System.getProperty("os.name"));
    }

    public static String getNativeLibraryResourcePrefix(int i, String str, String str2) {
        String canonicalArchitecture = getCanonicalArchitecture(str, i);
        switch (i) {
            case 0:
                return "darwin";
            case 1:
                return "linux-" + canonicalArchitecture;
            case 2:
                return "win32-" + canonicalArchitecture;
            case 3:
                return "sunos-" + canonicalArchitecture;
            case 4:
                return "freebsd-" + canonicalArchitecture;
            case 5:
                return "openbsd-" + canonicalArchitecture;
            case 6:
                return "w32ce-" + canonicalArchitecture;
            case 7:
            case 9:
            default:
                String lowerCase = str2.toLowerCase();
                int indexOf = lowerCase.indexOf(" ");
                if (indexOf != -1) {
                    lowerCase = lowerCase.substring(0, indexOf);
                }
                return lowerCase + "-" + canonicalArchitecture;
            case 8:
                if (canonicalArchitecture.startsWith("arm")) {
                    canonicalArchitecture = "arm";
                }
                return "android-" + canonicalArchitecture;
            case 10:
                return "kfreebsd-" + canonicalArchitecture;
            case 11:
                return "netbsd-" + canonicalArchitecture;
        }
    }

    public static final int getOSType() {
        return osType;
    }

    public static final boolean hasRuntimeExec() {
        return (isWindowsCE() && "J9".equals(System.getProperty("java.vm.name"))) ? false : true;
    }

    public static final boolean is64Bit() {
        String property = System.getProperty("sun.arch.data.model", System.getProperty("com.ibm.vm.bitmode"));
        if (property != null) {
            return "64".equals(property);
        }
        String str = ARCH;
        return "x86-64".equals(str) || "ia64".equals(str) || "ppc64".equals(str) || "ppc64le".equals(str) || "sparcv9".equals(str) || "mips64".equals(str) || "mips64el".equals(str) || "amd64".equals(str) || "aarch64".equals(str) || Native.POINTER_SIZE == 8;
    }

    public static final boolean isAIX() {
        return osType == 7;
    }

    public static final boolean isARM() {
        String str = ARCH;
        return str.startsWith("arm") || str.startsWith("aarch");
    }

    public static final boolean isAndroid() {
        return osType == 8;
    }

    public static final boolean isFreeBSD() {
        return osType == 4;
    }

    public static final boolean isGNU() {
        return osType == 9;
    }

    public static final boolean isIntel() {
        return ARCH.startsWith("x86");
    }

    public static final boolean isLinux() {
        return osType == 1;
    }

    public static final boolean isMIPS() {
        String str = ARCH;
        return str.equals("mips") || str.equals("mips64") || str.equals("mipsel") || str.equals("mips64el");
    }

    public static final boolean isMac() {
        return osType == 0;
    }

    public static final boolean isNetBSD() {
        return osType == 11;
    }

    public static final boolean isOpenBSD() {
        return osType == 5;
    }

    public static final boolean isPPC() {
        return ARCH.startsWith("ppc");
    }

    public static final boolean isSPARC() {
        return ARCH.startsWith("sparc");
    }

    public static boolean isSoftFloat() {
        try {
            if (new File("/proc/self/exe").exists()) {
                return !ELFAnalyser.analyse(r1.getCanonicalPath()).isArmHardFloat();
            }
            return false;
        } catch (IOException e) {
            Logger.getLogger(Platform.class.getName()).log(Level.INFO, "Failed to read '/proc/self/exe' or the target binary.", (Throwable) e);
            return false;
        } catch (SecurityException e2) {
            Logger.getLogger(Platform.class.getName()).log(Level.INFO, "SecurityException while analysing '/proc/self/exe' or the target binary.", (Throwable) e2);
            return false;
        }
    }

    public static final boolean isSolaris() {
        return osType == 3;
    }

    public static final boolean isWindows() {
        int i = osType;
        return i == 2 || i == 6;
    }

    public static final boolean isWindowsCE() {
        return osType == 6;
    }

    public static final boolean isX11() {
        return (isWindows() || isMac()) ? false : true;
    }

    public static final boolean iskFreeBSD() {
        return osType == 10;
    }
}
