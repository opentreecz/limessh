package cz.opentree;

import android.content.Context;
import cz.opentree.juicessh.models.Config;
import java.util.Arrays;
import java.util.List;

/* compiled from: TerminalFont.java */
/* loaded from: classes.dex */
public class aj0 {

    /* renamed from: a */
    public static final EnumC0717a f1417a;

    /* renamed from: b */
    public static final List<EnumC0717a> f1418b;

    /* compiled from: TerminalFont.java */
    /* renamed from: cz.opentree.aj0$a */
    /* loaded from: classes.dex */
    public enum EnumC0717a {
        CASCADIA_CODE_MONO("Cascadia Code Mono", "fonts/Caskaydia.Cove.Regular.Nerd.Font.Complete.Mono.otf"),
        SAUCE_CODE_PRO("Sauce Code Pro", "fonts/Sauce.Code.Pro.Nerd.Font.Complete.ttf"),
        INCONSOLATA("Inconsolata", "fonts/Inconsolata.Nerd.Font.Complete.Mono.otf"),
        ROBOTO_MONO("Roboto Mono", "fonts/Roboto.Mono.Nerd.Font.Complete.Mono.ttf"),
        JETBRAINS_MONO("JetBrains Mono", "fonts/JetBrains.Mono.Regular.Nerd.Font.Complete.Mono.ttf"),
        FIRA_CODE("Fira Code", "fonts/Fira.Code.Regular.Nerd.Font.Complete.ttf"),
        OPEN_DYSLEXIC("Open Dyslexic", "fonts/OpenDyslexic.Regular.Nerd.Font.Complete.Mono.otf"),
        DROID_SANS_MONO("Droid Sans Mono", "fonts/Droid.Sans.Mono.Nerd.Font.Complete.otf");


        /* renamed from: O */
        public String f1428O;

        /* renamed from: P */
        public String f1429P;

        EnumC0717a(String str, String str2) {
            this.f1428O = str;
            this.f1429P = str2;
        }

        /* renamed from: k */
        public String m2119k() {
            return this.f1429P;
        }
    }

    static {
        EnumC0717a enumC0717a = EnumC0717a.CASCADIA_CODE_MONO;
        f1417a = enumC0717a;
        f1418b = Arrays.asList(enumC0717a, EnumC0717a.SAUCE_CODE_PRO, EnumC0717a.ROBOTO_MONO, EnumC0717a.JETBRAINS_MONO, EnumC0717a.FIRA_CODE, EnumC0717a.OPEN_DYSLEXIC, EnumC0717a.INCONSOLATA, EnumC0717a.DROID_SANS_MONO);
    }

    /* renamed from: a */
    public static EnumC0717a m2114a(String str) {
        EnumC0717a enumC0717a = null;
        for (EnumC0717a enumC0717a2 : m2115b()) {
            if (enumC0717a2.f1428O.equals(str)) {
                enumC0717a = enumC0717a2;
            }
        }
        if (enumC0717a != null) {
            return enumC0717a;
        }
        gj0.m4142c("TerminalFont", "Could not load font: " + str);
        return f1417a;
    }

    /* renamed from: b */
    public static List<EnumC0717a> m2115b() {
        return f1418b;
    }

    /* renamed from: c */
    public static String m2116c(Context context) {
        return m2114a(Config.m5458d("terminal:font", context)).f1429P;
    }
}
