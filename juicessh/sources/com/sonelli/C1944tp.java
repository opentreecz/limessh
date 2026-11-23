package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.tp */
/* loaded from: classes.dex */
public final class C1944tp {
    /* renamed from: a */
    public static String m8791a(AbstractC1939tm abstractC1939tm) {
        C2182vp c2182vp = new C2182vp(abstractC1939tm);
        StringBuilder sb = new StringBuilder(c2182vp.mo1282a());
        for (int i = 0; i < c2182vp.mo1282a(); i++) {
            byte mo1283c = c2182vp.mo1283c(i);
            if (mo1283c == 34) {
                sb.append("\\\"");
            } else if (mo1283c == 39) {
                sb.append("\\'");
            } else if (mo1283c != 92) {
                switch (mo1283c) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (mo1283c < 32 || mo1283c > 126) {
                            sb.append('\\');
                            sb.append((char) (((mo1283c >>> 6) & 3) + 48));
                            sb.append((char) (((mo1283c >>> 3) & 7) + 48));
                            sb.append((char) ((mo1283c & 7) + 48));
                            break;
                        } else {
                            sb.append((char) mo1283c);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
