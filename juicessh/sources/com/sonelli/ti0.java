package com.sonelli;

/* compiled from: EscapeCharacters.java */
/* loaded from: classes.dex */
public class ti0 {

    /* renamed from: a */
    public EnumC1935b f6779a;

    /* compiled from: EscapeCharacters.java */
    /* renamed from: com.sonelli.ti0$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1934a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6780a;

        static {
            int[] iArr = new int[EnumC1935b.values().length];
            f6780a = iArr;
            try {
                iArr[EnumC1935b.LINUX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6780a[EnumC1935b.XTERM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6780a[EnumC1935b.XTERM_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6780a[EnumC1935b.XTERM_256COLOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6780a[EnumC1935b.VT100.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: EscapeCharacters.java */
    /* renamed from: com.sonelli.ti0$b */
    /* loaded from: classes.dex */
    public enum EnumC1935b {
        LINUX,
        XTERM,
        XTERM_COLOR,
        XTERM_256COLOR,
        VT100
    }

    public ti0(String str) {
        m8702b(str.equals("linux") ? EnumC1935b.LINUX : str.equals("xterm") ? EnumC1935b.XTERM : str.equals("xterm-color") ? EnumC1935b.XTERM_COLOR : str.equals("xterm-256color") ? EnumC1935b.XTERM_256COLOR : str.equals("vt100") ? EnumC1935b.VT100 : null);
    }

    /* renamed from: a */
    public String[] m8701a() {
        String[] strArr = new String[12];
        int i = C1934a.f6780a[this.f6779a.ordinal()];
        if (i == 1) {
            strArr[0] = "\u001b[[A";
            strArr[1] = "\u001b[[B";
            strArr[2] = "\u001b[[C";
            strArr[3] = "\u001b[[D";
            strArr[4] = "\u001b[[E";
            strArr[5] = "\u001b[17~";
            strArr[6] = "\u001b[18~";
            strArr[7] = "\u001b[19~";
            strArr[8] = "\u001b[20~";
            strArr[9] = "\u001b[21~";
            strArr[10] = "\u001b[23~";
            strArr[11] = "\u001b[24~";
        } else if (i == 2) {
            strArr[0] = "\u001bOP";
            strArr[1] = "\u001bOQ";
            strArr[2] = "\u001bOR";
            strArr[3] = "\u001bOS";
            strArr[4] = "\u001b[15~";
            strArr[5] = "\u001b[17~";
            strArr[6] = "\u001b[18~";
            strArr[7] = "\u001b[19~";
            strArr[8] = "\u001b[20~";
            strArr[9] = "\u001b[21~";
            strArr[10] = "\u001b[23~";
            strArr[11] = "\u001b[24~";
        } else if (i == 3) {
            strArr[0] = "\u001b[11~";
            strArr[1] = "\u001b[12~";
            strArr[2] = "\u001b[13~";
            strArr[3] = "\u001b[14~";
            strArr[4] = "\u001b[15~";
            strArr[5] = "\u001b[17~";
            strArr[6] = "\u001b[18~";
            strArr[7] = "\u001b[19~";
            strArr[8] = "\u001b[20~";
            strArr[9] = "\u001b[21~";
            strArr[10] = "\u001b[23~";
            strArr[11] = "\u001b[24~";
        } else if (i == 4) {
            strArr[0] = "\u001bOP";
            strArr[1] = "\u001bOQ";
            strArr[2] = "\u001bOR";
            strArr[3] = "\u001bOS";
            strArr[4] = "\u001b[15~";
            strArr[5] = "\u001b[17~";
            strArr[6] = "\u001b[18~";
            strArr[7] = "\u001b[19~";
            strArr[8] = "\u001b[20~";
            strArr[9] = "\u001b[21~";
            strArr[10] = "\u001b[23~";
            strArr[11] = "\u001b[24~";
        } else if (i == 5) {
            strArr[0] = "\u001bOP";
            strArr[1] = "\u001bOQ";
            strArr[2] = "\u001bOR";
            strArr[3] = "\u001bOS";
            strArr[4] = "\u001bOt";
            strArr[5] = "\u001bOu";
            strArr[6] = "\u001bOv";
            strArr[7] = "\u001bOl";
            strArr[8] = "\u001bOw";
            strArr[9] = "\u001bOx";
            strArr[10] = "";
            strArr[11] = "";
        }
        return strArr;
    }

    /* renamed from: b */
    public void m8702b(EnumC1935b enumC1935b) {
        if (enumC1935b == null) {
            this.f6779a = EnumC1935b.LINUX;
        } else {
            this.f6779a = enumC1935b;
        }
    }
}
