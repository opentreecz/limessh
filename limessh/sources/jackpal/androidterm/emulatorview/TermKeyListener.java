package jackpal.androidterm.emulatorview;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.google.android.material.badge.BadgeDrawable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import jackpal.androidterm.emulatorview.compat.AndroidCompat;
import jackpal.androidterm.emulatorview.compat.KeyCharacterMapCompat;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TermKeyListener {
    public static final int KEYCODE_OFFSET = 10485760;
    private static final int KEYMOD_ALT = Integer.MIN_VALUE;
    private static final int KEYMOD_CTRL = 1073741824;
    private static final int KEYMOD_SCAN = 268435456;
    private static final int KEYMOD_SHIFT = 536870912;
    private static final boolean LOG_COMBINING_ACCENT = false;
    private static final boolean LOG_KEYS = false;
    private static final boolean LOG_MISC = false;
    private static final boolean SUPPORT_8_BIT_META = false;
    private static final String TAG = "TermKeyListener";
    private static Map<Integer, String> mKeyMap;
    private boolean mAltSendsEsc;
    private int mBackKeyCode;
    private int mCombiningAccent;
    private int mCursorMode;
    private boolean mHardwareControlKey;
    private TermSession mTermSession;
    private String[] mKeyCodes = new String[256];
    private String[] mAppKeyCodes = new String[256];
    private ModifierKey mAltKey = new ModifierKey();
    private ModifierKey mCapKey = new ModifierKey();
    private ModifierKey mControlKey = new ModifierKey();
    private ModifierKey mFnKey = new ModifierKey();

    /* loaded from: classes.dex */
    public class ModifierKey {
        private static final int LOCKED = 4;
        private static final int PRESSED = 1;
        private static final int RELEASED = 2;
        private static final int UNPRESSED = 0;
        private static final int USED = 3;
        private int mState = 0;

        public ModifierKey() {
        }

        public void adjustAfterKeypress() {
            int i = this.mState;
            if (i == 1) {
                this.mState = 3;
            } else {
                if (i != 2) {
                    return;
                }
                this.mState = 0;
            }
        }

        public int getUIMode() {
            int i = this.mState;
            if (i == 1 || i == 2 || i == 3) {
                return 1;
            }
            return i != 4 ? 0 : 2;
        }

        public boolean isActive() {
            return this.mState != 0;
        }

        public void onPress() {
            int i = this.mState;
            if (i != 1) {
                if (i == 2) {
                    this.mState = 4;
                } else if (i != 3) {
                    if (i != 4) {
                        this.mState = 1;
                    } else {
                        this.mState = 0;
                    }
                }
            }
        }

        public void onRelease() {
            int i = this.mState;
            if (i == 1) {
                this.mState = 2;
            } else {
                if (i != 3) {
                    return;
                }
                this.mState = 0;
            }
        }
    }

    public TermKeyListener(TermSession termSession) {
        this.mTermSession = termSession;
        initKeyCodes();
        updateCursorMode();
    }

    private static int getCursorModeHelper(ModifierKey modifierKey, int i) {
        return modifierKey.getUIMode() << i;
    }

    private void initKeyCodes() {
        HashMap hashMap = new HashMap();
        mKeyMap = hashMap;
        hashMap.put(536870933, "\u001b[1;2D");
        mKeyMap.put(-2147483627, "\u001b[1;3D");
        mKeyMap.put(-1610612715, "\u001b[1;4D");
        mKeyMap.put(1073741845, "\u001b[1;5D");
        mKeyMap.put(1610612757, "\u001b[1;6D");
        mKeyMap.put(-1073741803, "\u001b[1;7D");
        mKeyMap.put(-536870891, "\u001b[1;8D");
        mKeyMap.put(536870934, "\u001b[1;2C");
        mKeyMap.put(-2147483626, "\u001b[1;3C");
        mKeyMap.put(-1610612714, "\u001b[1;4C");
        mKeyMap.put(1073741846, "\u001b[1;5C");
        mKeyMap.put(1610612758, "\u001b[1;6C");
        mKeyMap.put(-1073741802, "\u001b[1;7C");
        mKeyMap.put(-536870890, "\u001b[1;8C");
        mKeyMap.put(536870931, "\u001b[1;2A");
        mKeyMap.put(-2147483629, "\u001b[1;3A");
        mKeyMap.put(-1610612717, "\u001b[1;4A");
        mKeyMap.put(1073741843, "\u001b[1;5A");
        mKeyMap.put(1610612755, "\u001b[1;6A");
        mKeyMap.put(-1073741805, "\u001b[1;7A");
        mKeyMap.put(-536870893, "\u001b[1;8A");
        mKeyMap.put(536870932, "\u001b[1;2B");
        mKeyMap.put(-2147483628, "\u001b[1;3B");
        mKeyMap.put(-1610612716, "\u001b[1;4B");
        mKeyMap.put(1073741844, "\u001b[1;5B");
        mKeyMap.put(1610612756, "\u001b[1;6B");
        mKeyMap.put(-1073741804, "\u001b[1;7B");
        mKeyMap.put(-536870892, "\u001b[1;8B");
        mKeyMap.put(536871024, "\u001b[3;2~");
        mKeyMap.put(-2147483536, "\u001b[3;3~");
        mKeyMap.put(1073741936, "\u001b[3;5~");
        mKeyMap.put(536871036, "\u001b[2;2~");
        mKeyMap.put(-2147483524, "\u001b[2;3~");
        mKeyMap.put(1073741948, "\u001b[2;5~");
        mKeyMap.put(1073741946, "\u001b[1;5H");
        mKeyMap.put(1073741947, "\u001b[1;5F");
        mKeyMap.put(-2147483582, "\u001b\r");
        mKeyMap.put(1073741890, "\n");
        mKeyMap.put(1073741886, "\u0000");
        mKeyMap.put(536871043, "\u001b[1;2P");
        mKeyMap.put(536871044, "\u001b[1;2Q");
        mKeyMap.put(536871045, "\u001b[1;2R");
        mKeyMap.put(536871046, "\u001b[1;2S");
        mKeyMap.put(536871047, "\u001b[15;2~");
        mKeyMap.put(536871048, "\u001b[17;2~");
        mKeyMap.put(536871049, "\u001b[18;2~");
        mKeyMap.put(536871050, "\u001b[19;2~");
        mKeyMap.put(536871051, "\u001b[20;2~");
        mKeyMap.put(536871052, "\u001b[21;2~");
        String[] strArr = this.mKeyCodes;
        strArr[23] = "\r";
        strArr[19] = "\u001b[A";
        strArr[20] = "\u001b[B";
        strArr[22] = "\u001b[C";
        strArr[21] = "\u001b[D";
        setFnKeys("vt100");
        String[] strArr2 = this.mKeyCodes;
        strArr2[120] = "\u001b[32~";
        strArr2[121] = "\u001b[34~";
        strArr2[61] = "\t";
        strArr2[66] = "\r";
        strArr2[111] = "\u001b";
        strArr2[124] = "\u001b[2~";
        strArr2[112] = "\u001b[3~";
        strArr2[92] = "\u001b[5~";
        strArr2[93] = "\u001b[6~";
        strArr2[67] = "\u007f";
        strArr2[143] = "\u001bOP";
        strArr2[154] = "/";
        strArr2[155] = "*";
        strArr2[156] = "-";
        strArr2[157] = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        strArr2[160] = "\r";
        strArr2[161] = SimpleComparison.EQUAL_TO_OPERATION;
        strArr2[159] = ",";
        strArr2[158] = strArr2[112];
        strArr2[144] = strArr2[124];
        strArr2[145] = strArr2[123];
        strArr2[146] = strArr2[20];
        strArr2[147] = strArr2[93];
        strArr2[148] = strArr2[21];
        strArr2[149] = "5";
        strArr2[150] = strArr2[22];
        strArr2[151] = strArr2[122];
        strArr2[152] = strArr2[19];
        strArr2[153] = strArr2[92];
        String[] strArr3 = this.mAppKeyCodes;
        strArr3[154] = "\u001bOo";
        strArr3[155] = "\u001bOj";
        strArr3[156] = "\u001bOm";
        strArr3[157] = "\u001bOk";
        strArr3[160] = "\u001bOM";
        strArr3[161] = "\u001bOX";
        strArr3[158] = "\u001bOn";
        strArr3[159] = "\u001bOl";
        strArr3[144] = "\u001bOp";
        strArr3[145] = "\u001bOq";
        strArr3[146] = "\u001bOr";
        strArr3[147] = "\u001bOs";
        strArr3[148] = "\u001bOt";
        strArr3[149] = "\u001bOu";
        strArr3[150] = "\u001bOv";
        strArr3[151] = "\u001bOw";
        strArr3[152] = "\u001bOx";
        strArr3[153] = "\u001bOy";
    }

    public static boolean isEventFromToggleDevice(KeyEvent keyEvent) {
        return AndroidCompat.SDK < 11 || KeyCharacterMapCompat.wrap(KeyCharacterMap.load(keyEvent.getDeviceId())).getModifierBehaviour() == 1;
    }

    private void setFnKeys(String str) {
        if (str.equals("xterm")) {
            String[] strArr = this.mKeyCodes;
            strArr[122] = "\u001bOH";
            strArr[151] = "\u001bOH";
            strArr[123] = "\u001bOF";
            strArr[145] = "\u001bOF";
        } else {
            String[] strArr2 = this.mKeyCodes;
            strArr2[122] = "\u001b[1~";
            strArr2[151] = "\u001b[1~";
            strArr2[123] = "\u001b[4~";
            strArr2[145] = "\u001b[4~";
        }
        if (str.equals("vt100")) {
            String[] strArr3 = this.mKeyCodes;
            strArr3[131] = "\u001bOP";
            strArr3[132] = "\u001bOQ";
            strArr3[133] = "\u001bOR";
            strArr3[134] = "\u001bOS";
            strArr3[135] = "\u001bOt";
            strArr3[136] = "\u001bOu";
            strArr3[137] = "\u001bOv";
            strArr3[138] = "\u001bOl";
            strArr3[139] = "\u001bOw";
            strArr3[140] = "\u001bOx";
            strArr3[141] = "\u001b[23~";
            strArr3[142] = "\u001b[24~";
            return;
        }
        if (str.startsWith("linux")) {
            String[] strArr4 = this.mKeyCodes;
            strArr4[131] = "\u001b[[A";
            strArr4[132] = "\u001b[[B";
            strArr4[133] = "\u001b[[C";
            strArr4[134] = "\u001b[[D";
            strArr4[135] = "\u001b[[E";
            strArr4[136] = "\u001b[17~";
            strArr4[137] = "\u001b[18~";
            strArr4[138] = "\u001b[19~";
            strArr4[139] = "\u001b[20~";
            strArr4[140] = "\u001b[21~";
            strArr4[141] = "\u001b[23~";
            strArr4[142] = "\u001b[24~";
            return;
        }
        String[] strArr5 = this.mKeyCodes;
        strArr5[131] = "\u001bOP";
        strArr5[132] = "\u001bOQ";
        strArr5[133] = "\u001bOR";
        strArr5[134] = "\u001bOS";
        strArr5[135] = "\u001b[15~";
        strArr5[136] = "\u001b[17~";
        strArr5[137] = "\u001b[18~";
        strArr5[138] = "\u001b[19~";
        strArr5[139] = "\u001b[20~";
        strArr5[140] = "\u001b[21~";
        strArr5[141] = "\u001b[23~";
        strArr5[142] = "\u001b[24~";
    }

    private void updateCursorMode() {
        this.mCursorMode = getCursorModeHelper(this.mCapKey, 0) | getCursorModeHelper(this.mAltKey, 2) | getCursorModeHelper(this.mControlKey, 4) | getCursorModeHelper(this.mFnKey, 6);
    }

    public boolean getAltSendsEsc() {
        return this.mAltSendsEsc;
    }

    public int getCombiningAccent() {
        return this.mCombiningAccent;
    }

    public int getCursorMode() {
        return this.mCursorMode;
    }

    public void handleControlKey(boolean z) {
        if (z) {
            this.mControlKey.onPress();
        } else {
            this.mControlKey.onRelease();
        }
        updateCursorMode();
    }

    public void handleFnKey(boolean z) {
        if (z) {
            this.mFnKey.onPress();
        } else {
            this.mFnKey.onRelease();
        }
        updateCursorMode();
    }

    public void handleHardwareControlKey(boolean z) {
        this.mHardwareControlKey = z;
    }

    public boolean handleKeyCode(int i, KeyEvent keyEvent, boolean z) throws IOException {
        String str;
        if (keyEvent != null) {
            int i2 = (this.mHardwareControlKey || this.mControlKey.isActive()) ? KEYMOD_CTRL : 0;
            if ((keyEvent.getMetaState() & 2) != 0) {
                i2 |= Integer.MIN_VALUE;
            }
            if ((keyEvent.getMetaState() & 1) != 0) {
                i2 |= KEYMOD_SHIFT;
            }
            str = mKeyMap.get(Integer.valueOf(keyEvent.getScanCode() | KEYMOD_SCAN | i2));
            if (str == null) {
                str = mKeyMap.get(Integer.valueOf(i2 | i));
            }
        } else {
            str = null;
        }
        if (str == null && i >= 0) {
            String[] strArr = this.mKeyCodes;
            if (i < strArr.length) {
                if (z) {
                    str = this.mAppKeyCodes[i];
                }
                if (str == null) {
                    str = strArr[i];
                }
            }
        }
        if (str == null) {
            return false;
        }
        this.mTermSession.write(str);
        return true;
    }

    public boolean isAltActive() {
        return this.mAltKey.isActive();
    }

    public boolean isCtrlActive() {
        return this.mControlKey.isActive();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void keyDown(int r8, android.view.KeyEvent r9, boolean r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jackpal.androidterm.emulatorview.TermKeyListener.keyDown(int, android.view.KeyEvent, boolean, boolean):void");
    }

    public void keyUp(int i, KeyEvent keyEvent) {
        boolean isEventFromToggleDevice = isEventFromToggleDevice(keyEvent);
        switch (i) {
            case 57:
            case 58:
                if (isEventFromToggleDevice) {
                    this.mAltKey.onRelease();
                    updateCursorMode();
                    return;
                }
                return;
            case 59:
            case 60:
                if (isEventFromToggleDevice) {
                    this.mCapKey.onRelease();
                    updateCursorMode();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int mapControlChar(int i) {
        return mapControlChar(this.mHardwareControlKey || this.mControlKey.isActive(), this.mFnKey.isActive(), i);
    }

    public int mapControlChar(boolean z, boolean z2, int i) {
        int i2;
        int i3;
        if (z) {
            if (i >= 97 && i <= 122) {
                i3 = i - 97;
            } else if (i >= 65 && i <= 90) {
                i3 = i - 65;
            } else if (i == 32 || i == 50) {
                i = 0;
            } else {
                if (i != 91 && i != 51) {
                    if (i != 92 && i != 52) {
                        if (i == 93 || i == 53) {
                            i = 29;
                        } else if (i == 94 || i == 54) {
                            i = 30;
                        } else if (i == 95 || i == 55) {
                            i = 31;
                        } else if (i == 56) {
                            i = KeycodeConstants.KEYCODE_MEDIA_PAUSE;
                        } else if (i == 57) {
                            i = 10485901;
                        } else if (i == 48) {
                            i = 10485902;
                        }
                    }
                    i = 28;
                }
                i = 27;
            }
            i2 = i3 + 1;
            i = (char) i2;
        } else if (z2) {
            if (i == 119 || i == 87) {
                i = 10485779;
            } else if (i == 97 || i == 65) {
                i = 10485781;
            } else if (i == 115 || i == 83) {
                i = 10485780;
            } else if (i == 100 || i == 68) {
                i = 10485782;
            } else if (i == 112 || i == 80) {
                i = 10485852;
            } else if (i == 110 || i == 78) {
                i = 10485853;
            } else if (i == 116 || i == 84) {
                i = 10485821;
            } else if (i == 108 || i == 76) {
                i = 124;
            } else if (i == 117 || i == 85) {
                i = 95;
            } else {
                if (i != 101 && i != 69) {
                    if (i != 46) {
                        if (i > 48 && i <= 57) {
                            i2 = ((i + KEYCODE_OFFSET) + KeycodeConstants.KEYCODE_F1) - 1;
                            i = (char) i2;
                        } else if (i == 48) {
                            i = 10485900;
                        } else if (i == 105 || i == 73) {
                            i = 10485884;
                        } else if (i == 120 || i == 88) {
                            i = 10485872;
                        } else if (i == 104 || i == 72) {
                            i = 10485882;
                        } else if (i == 102 || i == 70) {
                            i = 10485883;
                        }
                    }
                    i = 28;
                }
                i = 27;
            }
        }
        if (i > -1) {
            this.mAltKey.adjustAfterKeypress();
            this.mCapKey.adjustAfterKeypress();
            this.mControlKey.adjustAfterKeypress();
            this.mFnKey.adjustAfterKeypress();
            updateCursorMode();
        }
        return i;
    }

    public void onPause() {
        this.mHardwareControlKey = false;
    }

    public void onResume() {
    }

    public void setAltSendsEsc(boolean z) {
        this.mAltSendsEsc = z;
    }

    public void setBackKeyCharacter(int i) {
        this.mBackKeyCode = i;
    }

    public void setBackspaceKey(String str) {
        this.mKeyCodes[67] = str;
    }

    public void setCursorKeysApplicationMode(boolean z) {
        if (z) {
            String[] strArr = this.mKeyCodes;
            strArr[19] = "\u001bOA";
            strArr[152] = "\u001bOA";
            strArr[20] = "\u001bOB";
            strArr[146] = "\u001bOB";
            strArr[22] = "\u001bOC";
            strArr[150] = "\u001bOC";
            strArr[21] = "\u001bOD";
            strArr[148] = "\u001bOD";
            return;
        }
        String[] strArr2 = this.mKeyCodes;
        strArr2[19] = "\u001b[A";
        strArr2[152] = "\u001b[A";
        strArr2[20] = "\u001b[B";
        strArr2[146] = "\u001b[B";
        strArr2[22] = "\u001b[C";
        strArr2[150] = "\u001b[C";
        strArr2[21] = "\u001b[D";
        strArr2[148] = "\u001b[D";
    }

    public void setTermType(String str) {
        setFnKeys(str);
    }
}
