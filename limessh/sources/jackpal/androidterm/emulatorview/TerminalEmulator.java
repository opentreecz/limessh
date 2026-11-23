package jackpal.androidterm.emulatorview;

import android.util.Log;
import jackpal.androidterm.emulatorview.TermSession;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* loaded from: classes.dex */
public class TerminalEmulator {
    private static final int CHAR_SET_ALT_SPECIAL_GRAPICS = 4;
    private static final int CHAR_SET_ALT_STANDARD = 3;
    private static final int CHAR_SET_ASCII = 1;
    private static final int CHAR_SET_SPECIAL_GRAPHICS = 2;
    private static final int CHAR_SET_UK = 0;
    private static final boolean DEFAULT_TO_AUTOWRAP_ENABLED = true;
    private static final int ESC = 1;
    private static final int ESC_LEFT_SQUARE_BRACKET = 5;
    private static final int ESC_LEFT_SQUARE_BRACKET_QUESTION_MARK = 6;
    private static final int ESC_NONE = 0;
    private static final int ESC_PERCENT = 7;
    private static final int ESC_POUND = 2;
    private static final int ESC_RIGHT_SQUARE_BRACKET = 8;
    private static final int ESC_RIGHT_SQUARE_BRACKET_ESC = 9;
    private static final int ESC_SELECT_LEFT_PAREN = 3;
    private static final int ESC_SELECT_RIGHT_PAREN = 4;
    private static final int K_132_COLUMN_MODE_MASK = 8;
    private static final int K_DECSC_DECRC_MASK = 192;
    private static final int K_ORIGIN_MODE_MASK = 64;
    private static final int K_REVERSE_VIDEO_MASK = 32;
    private static final int K_SHOW_CURSOR_MASK = 33554432;
    private static final int K_WRAPAROUND_MODE_MASK = 128;
    private static final int MAX_ESCAPE_PARAMETERS = 16;
    private static final int MAX_OSC_STRING_LENGTH = 512;
    private static final int UNICODE_REPLACEMENT_CHAR = 65533;
    private static final char[] mSpecialGraphicsCharMap = new char[128];
    private boolean mAboutToAutoWrap;
    private TranscriptScreen mAltBuffer;
    private boolean mAlternateCharSet;
    private int mArgIndex;
    private int mBackColor;
    private TermSession.OnBellListener mBellListener;
    private int mBottomMargin;
    private int mColumns;
    private boolean mContinueSequence;
    private int mCursorCol;
    private int mCursorRow;
    private int mDecFlags;
    private int mDefaultBackColor;
    private int mDefaultForeColor;
    private int mEffect;
    private int mEscapeState;
    private int mForeColor;
    private CharBuffer mInputCharBuffer;
    private boolean mInsertMode;
    private TermKeyListener mKeyListener;
    private TranscriptScreen mMainBuffer;
    private int mMouseTrackingMode;
    private int mOSCArgLength;
    private int mOSCArgTokenizerIndex;
    private int mProcessedCharCount;
    private int mRows;
    private int mSavedCursorCol;
    private int mSavedCursorRow;
    private int mSavedDecFlags;
    private int mSavedDecFlags_DECSC_DECRC;
    private int mSavedEffect;
    private TranscriptScreen mScreen;
    private TermSession mSession;
    private boolean[] mTabStop;
    private int mTopMargin;
    private ByteBuffer mUTF8ByteBuffer;
    private CharsetDecoder mUTF8Decoder;
    private UpdateCallback mUTF8ModeNotify;
    private boolean mUseAlternateCharSet;
    private boolean mbCursorApplicationMode;
    private boolean mbKeypadApplicationMode;
    private int[] mArgs = new int[16];
    private byte[] mOSCArg = new byte[512];
    private int mLastEmittedCharWidth = 0;
    private boolean mJustWrapped = false;
    private int[] mCharSet = new int[2];
    private int mScrollCounter = 0;
    private boolean mDefaultUTF8Mode = false;
    private boolean mUTF8Mode = false;
    private boolean mUTF8EscapeUsed = false;
    private int mUTF8ToFollow = 0;

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            mSpecialGraphicsCharMap[c] = c;
        }
        char[] cArr = mSpecialGraphicsCharMap;
        cArr[95] = ' ';
        cArr[98] = 9225;
        cArr[99] = 9228;
        cArr[100] = 9229;
        cArr[101] = 9226;
        cArr[104] = 9252;
        cArr[105] = 9227;
        cArr[125] = 163;
        cArr[102] = 176;
        cArr[96] = 11045;
        cArr[126] = 8226;
        cArr[121] = 8804;
        cArr[124] = 8800;
        cArr[122] = 8805;
        cArr[103] = 177;
        cArr[123] = 960;
        cArr[46] = 9660;
        cArr[44] = 9664;
        cArr[43] = 9654;
        cArr[45] = 9650;
        cArr[104] = '#';
        cArr[97] = 9618;
        cArr[48] = 9608;
        cArr[113] = 9472;
        cArr[120] = 9474;
        cArr[109] = 9492;
        cArr[106] = 9496;
        cArr[108] = 9484;
        cArr[107] = 9488;
        cArr[119] = 9516;
        cArr[117] = 9508;
        cArr[116] = 9500;
        cArr[118] = 9524;
        cArr[110] = 9532;
        cArr[111] = 9146;
        cArr[112] = 9147;
        cArr[114] = 9148;
        cArr[115] = 9149;
    }

    public TerminalEmulator(TermSession termSession, TranscriptScreen transcriptScreen, int i, int i2, ColorScheme colorScheme) {
        this.mSession = termSession;
        this.mMainBuffer = transcriptScreen;
        this.mScreen = transcriptScreen;
        this.mAltBuffer = new TranscriptScreen(i, i2, i2, colorScheme);
        this.mRows = i2;
        this.mColumns = i;
        this.mTabStop = new boolean[i];
        setColorScheme(colorScheme);
        this.mUTF8ByteBuffer = ByteBuffer.allocate(4);
        this.mInputCharBuffer = CharBuffer.allocate(2);
        CharsetDecoder newDecoder = StandardCharsets.UTF_8.newDecoder();
        this.mUTF8Decoder = newDecoder;
        newDecoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.mUTF8Decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        reset();
    }

    private boolean autoWrapEnabled() {
        return (this.mDecFlags & 128) != 0;
    }

    private void blockClear(int i, int i2, int i3) {
        blockClear(i, i2, i3, 1);
    }

    private void blockClear(int i, int i2, int i3, int i4) {
        this.mScreen.blockSet(i, i2, i3, i4, 32, getStyle());
    }

    private void changeTitle(int i, String str) {
        if (i == 0 || i == 2) {
            this.mSession.setTitle(str);
        }
    }

    private boolean checkColor(int i) {
        return isValidColor(i);
    }

    private void collectOSCArgs(byte b) {
        int i = this.mOSCArgLength;
        if (i >= 512) {
            unknownSequence(b);
            return;
        }
        byte[] bArr = this.mOSCArg;
        this.mOSCArgLength = i + 1;
        bArr[i] = b;
        continueSequence();
    }

    private void computeEffectiveCharSet() {
        this.mUseAlternateCharSet = this.mCharSet[this.mAlternateCharSet ? 1 : 0] == 2;
    }

    private void continueSequence() {
        this.mContinueSequence = true;
    }

    private void continueSequence(int i) {
        this.mEscapeState = i;
        this.mContinueSequence = true;
    }

    private void doEsc(byte b) {
        if (b == 35) {
            continueSequence(2);
            return;
        }
        if (b == 48) {
            unimplementedSequence(b);
            return;
        }
        if (b == 72) {
            this.mTabStop[this.mCursorCol] = true;
            return;
        }
        if (b == 80) {
            unimplementedSequence(b);
            return;
        }
        if (b == 93) {
            startCollectingOSCArgs();
            continueSequence(8);
            return;
        }
        if (b == 40) {
            continueSequence(3);
            return;
        }
        if (b == 41) {
            continueSequence(4);
            return;
        }
        if (b == 55) {
            this.mSavedCursorRow = this.mCursorRow;
            this.mSavedCursorCol = this.mCursorCol;
            this.mSavedEffect = this.mEffect;
            this.mSavedDecFlags_DECSC_DECRC = this.mDecFlags & K_DECSC_DECRC_MASK;
            return;
        }
        if (b == 56) {
            setCursorRowCol(this.mSavedCursorRow, this.mSavedCursorCol);
            this.mEffect = this.mSavedEffect;
            this.mDecFlags = (this.mDecFlags & (-193)) | this.mSavedDecFlags_DECSC_DECRC;
            return;
        }
        if (b == 61) {
            this.mbKeypadApplicationMode = true;
            return;
        }
        if (b == 62) {
            this.mbKeypadApplicationMode = false;
            return;
        }
        if (b == 77) {
            int i = this.mCursorRow;
            int i2 = this.mTopMargin;
            if (i > i2) {
                this.mCursorRow = i - 1;
                return;
            } else {
                this.mScreen.blockCopy(0, i2, this.mColumns, this.mBottomMargin - (i2 + 1), 0, i2 + 1);
                blockClear(0, this.mTopMargin, this.mColumns);
                return;
            }
        }
        if (b == 78) {
            unimplementedSequence(b);
            return;
        }
        if (b == 90) {
            sendDeviceAttributes();
            return;
        }
        if (b == 91) {
            continueSequence(5);
            return;
        }
        switch (b) {
            case 68:
                doLinefeed();
                return;
            case 69:
                setCursorCol(0);
                doLinefeed();
                return;
            case 70:
                setCursorRowCol(0, this.mBottomMargin - 1);
                return;
            default:
                unknownSequence(b);
                return;
        }
    }

    private void doEscLSBQuest(byte b) {
        TranscriptScreen transcriptScreen;
        int arg0 = getArg0(0);
        int decFlagsMask = getDecFlagsMask(arg0);
        int i = this.mDecFlags;
        if (b == 104) {
            this.mDecFlags = i | decFlagsMask;
            if (arg0 == 1) {
                this.mKeyListener.setCursorKeysApplicationMode(true);
            } else if ((arg0 == 47 || arg0 == 1047 || arg0 == 1049) && (transcriptScreen = this.mAltBuffer) != null) {
                this.mScreen = transcriptScreen;
            }
            if (arg0 >= 1000 && arg0 <= 1003) {
                this.mMouseTrackingMode = arg0;
            }
        } else if (b == 108) {
            this.mDecFlags = (~decFlagsMask) & i;
            if (arg0 == 1) {
                this.mKeyListener.setCursorKeysApplicationMode(false);
            } else if (arg0 == 47 || arg0 == 1047 || arg0 == 1049) {
                this.mScreen = this.mMainBuffer;
            }
            if (arg0 >= 1000 && arg0 <= 1003) {
                this.mMouseTrackingMode = 0;
            }
        } else if (b == 114) {
            this.mDecFlags = ((~decFlagsMask) & i) | (this.mSavedDecFlags & decFlagsMask);
        } else if (b != 115) {
            parseArg(b);
        } else {
            this.mSavedDecFlags = (this.mSavedDecFlags & (~decFlagsMask)) | (i & decFlagsMask);
        }
        int i2 = ~i;
        int i3 = this.mDecFlags;
        int i4 = i2 & i3;
        if (((i3 ^ i) & 8) != 0) {
            blockClear(0, 0, this.mColumns, this.mRows);
            setCursorRowCol(0, 0);
        }
        if ((i4 & 64) != 0) {
            setCursorPosition(0, 0);
        }
    }

    private void doEscLeftSquareBracket(byte b) {
        if (b == 71) {
            setCursorCol(Math.min(Math.max(1, getArg0(1)), this.mColumns) - 1);
            return;
        }
        if (b == 72) {
            setHorizontalVerticalPosition();
            return;
        }
        if (b == 80) {
            int i = this.mColumns - this.mCursorCol;
            int min = Math.min(getArg0(1), i);
            int i2 = i - min;
            TranscriptScreen transcriptScreen = this.mScreen;
            int i3 = this.mCursorCol;
            int i4 = this.mCursorRow;
            transcriptScreen.blockCopy(i3 + min, i4, i2, 1, i3, i4);
            blockClear(this.mCursorCol + i2, this.mCursorRow, min);
            return;
        }
        if (b == 88) {
            blockClear(this.mCursorCol, this.mCursorRow, getArg0(0));
            return;
        }
        if (b == 90) {
            setCursorCol(prevTabStop(this.mCursorCol));
            return;
        }
        if (b == 114) {
            int max = Math.max(0, Math.min(getArg0(1) - 1, this.mRows - 2));
            int max2 = Math.max(max + 2, Math.min(getArg1(this.mRows), this.mRows));
            this.mTopMargin = max;
            this.mBottomMargin = max2;
            setCursorRowCol(max, 0);
            return;
        }
        if (b == 116) {
            unimplementedSequence(b);
            return;
        }
        if (b == 83) {
            int arg0 = getArg0(1);
            for (int i5 = 0; i5 < arg0; i5++) {
                this.mScreen.scroll(this.mTopMargin, this.mBottomMargin, getStyle());
            }
            return;
        }
        if (b == 84) {
            unimplementedSequence(b);
            return;
        }
        if (b == 99) {
            sendDeviceAttributes();
            return;
        }
        if (b == 100) {
            setCursorRow(Math.min(Math.max(1, getArg0(1)), this.mRows) - 1);
            return;
        }
        switch (b) {
            case 63:
                continueSequence(6);
                return;
            case 64:
                int i6 = this.mColumns - this.mCursorCol;
                int min2 = Math.min(getArg0(1), i6);
                TranscriptScreen transcriptScreen2 = this.mScreen;
                int i7 = this.mCursorCol;
                int i8 = this.mCursorRow;
                transcriptScreen2.blockCopy(i7, i8, i6 - min2, 1, i7 + min2, i8);
                blockClear(this.mCursorCol, this.mCursorRow, min2);
                return;
            case 65:
                setCursorRow(Math.max(this.mTopMargin, this.mCursorRow - getArg0(1)));
                return;
            case 66:
                setCursorRow(Math.min(this.mBottomMargin - 1, this.mCursorRow + getArg0(1)));
                return;
            case 67:
                setCursorCol(Math.min(this.mColumns - 1, this.mCursorCol + getArg0(1)));
                return;
            case 68:
                setCursorCol(Math.max(0, this.mCursorCol - getArg0(1)));
                return;
            default:
                switch (b) {
                    case 74:
                        int arg02 = getArg0(0);
                        if (arg02 == 0) {
                            int i9 = this.mCursorCol;
                            blockClear(i9, this.mCursorRow, this.mColumns - i9);
                            int i10 = this.mCursorRow;
                            blockClear(0, i10 + 1, this.mColumns, this.mRows - (i10 + 1));
                            return;
                        }
                        if (arg02 == 1) {
                            blockClear(0, 0, this.mColumns, this.mCursorRow);
                            blockClear(0, this.mCursorRow, this.mCursorCol + 1);
                            return;
                        } else if (arg02 != 2) {
                            unknownSequence(b);
                            return;
                        } else {
                            blockClear(0, 0, this.mColumns, this.mRows);
                            return;
                        }
                    case 75:
                        int arg03 = getArg0(0);
                        if (arg03 == 0) {
                            int i11 = this.mCursorCol;
                            blockClear(i11, this.mCursorRow, this.mColumns - i11);
                            return;
                        } else if (arg03 == 1) {
                            blockClear(0, this.mCursorRow, this.mCursorCol + 1);
                            return;
                        } else if (arg03 != 2) {
                            unknownSequence(b);
                            return;
                        } else {
                            blockClear(0, this.mCursorRow, this.mColumns);
                            return;
                        }
                    case 76:
                        int i12 = this.mBottomMargin - this.mCursorRow;
                        int min3 = Math.min(getArg0(1), i12);
                        TranscriptScreen transcriptScreen3 = this.mScreen;
                        int i13 = this.mCursorRow;
                        transcriptScreen3.blockCopy(0, i13, this.mColumns, i12 - min3, 0, i13 + min3);
                        blockClear(0, this.mCursorRow, this.mColumns, min3);
                        return;
                    case 77:
                        int i14 = this.mBottomMargin - this.mCursorRow;
                        int min4 = Math.min(getArg0(1), i14);
                        int i15 = i14 - min4;
                        TranscriptScreen transcriptScreen4 = this.mScreen;
                        int i16 = this.mCursorRow;
                        transcriptScreen4.blockCopy(0, i16 + min4, this.mColumns, i15, 0, i16);
                        blockClear(0, this.mCursorRow + i15, this.mColumns, min4);
                        return;
                    default:
                        switch (b) {
                            case 102:
                                setHorizontalVerticalPosition();
                                return;
                            case 103:
                                int arg04 = getArg0(0);
                                if (arg04 == 0) {
                                    this.mTabStop[this.mCursorCol] = false;
                                    return;
                                } else {
                                    if (arg04 != 3) {
                                        return;
                                    }
                                    for (int i17 = 0; i17 < this.mColumns; i17++) {
                                        this.mTabStop[i17] = false;
                                    }
                                    return;
                                }
                            case 104:
                                doSetMode(true);
                                return;
                            default:
                                switch (b) {
                                    case 108:
                                        doSetMode(false);
                                        return;
                                    case 109:
                                        selectGraphicRendition();
                                        return;
                                    case 110:
                                        int arg05 = getArg0(0);
                                        if (arg05 == 5) {
                                            this.mSession.write(new byte[]{27, 91, 48, 110}, 0, 4);
                                            return;
                                        } else {
                                            if (arg05 != 6) {
                                                return;
                                            }
                                            byte[] bytes = String.format(Locale.US, "\u001b[%d;%dR", Integer.valueOf(this.mCursorRow + 1), Integer.valueOf(this.mCursorCol + 1)).getBytes();
                                            this.mSession.write(bytes, 0, bytes.length);
                                            return;
                                        }
                                    default:
                                        parseArg(b);
                                        return;
                                }
                        }
                }
        }
    }

    private void doEscPercent(byte b) {
        if (b == 64) {
            setUTF8Mode(false);
            this.mUTF8EscapeUsed = true;
        } else {
            if (b != 71) {
                return;
            }
            setUTF8Mode(true);
            this.mUTF8EscapeUsed = true;
        }
    }

    private void doEscPound(byte b) {
        if (b != 56) {
            unknownSequence(b);
        } else {
            this.mScreen.blockSet(0, 0, this.mColumns, this.mRows, 69, getStyle());
        }
    }

    private void doEscRightSquareBracket(byte b) {
        if (b == 7) {
            doOSC();
        } else if (b != 27) {
            collectOSCArgs(b);
        } else {
            continueSequence(9);
        }
    }

    private void doEscRightSquareBracketEsc(byte b) {
        if (b == 92) {
            doOSC();
            return;
        }
        collectOSCArgs((byte) 27);
        collectOSCArgs(b);
        continueSequence(8);
    }

    private void doEscSelectLeftParen(byte b) {
        doSelectCharSet(0, b);
    }

    private void doEscSelectRightParen(byte b) {
        doSelectCharSet(1, b);
    }

    private void doLinefeed() {
        int i = this.mCursorRow + 1;
        if (i >= this.mBottomMargin) {
            scroll();
            i = this.mBottomMargin - 1;
        }
        setCursorRow(i);
    }

    private void doOSC() {
        startTokenizingOSC();
        int nextOSCInt = nextOSCInt(59);
        if (nextOSCInt == 0 || nextOSCInt == 1 || nextOSCInt == 2) {
            changeTitle(nextOSCInt, nextOSCString(-1));
        } else {
            unknownParameter(nextOSCInt);
        }
        finishSequence();
    }

    private void doSelectCharSet(int i, byte b) {
        int i2;
        if (b == 65) {
            i2 = 0;
        } else if (b != 66) {
            switch (b) {
                case 48:
                    i2 = 2;
                    break;
                case 49:
                    i2 = 3;
                    break;
                case 50:
                    i2 = 4;
                    break;
                default:
                    unknownSequence(b);
                    return;
            }
        } else {
            i2 = 1;
        }
        this.mCharSet[i] = i2;
        computeEffectiveCharSet();
    }

    private void doSetMode(boolean z) {
        int arg0 = getArg0(0);
        if (arg0 != 4) {
            unknownParameter(arg0);
        } else {
            this.mInsertMode = z;
        }
    }

    private void emit(byte b) {
        if (!this.mUseAlternateCharSet || b >= 128) {
            emit((int) b);
        } else {
            emit(mSpecialGraphicsCharMap[b]);
        }
    }

    private void emit(int i) {
        emit(i, getStyle());
    }

    private void emit(int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean autoWrapEnabled = autoWrapEnabled();
        int charWidth = UnicodeTranscript.charWidth(i);
        if (autoWrapEnabled && this.mCursorCol == this.mColumns - 1 && (this.mAboutToAutoWrap || charWidth == 2)) {
            this.mScreen.setLineWrap(this.mCursorRow);
            this.mCursorCol = 0;
            this.mJustWrapped = true;
            int i6 = this.mCursorRow;
            if (i6 + 1 < this.mBottomMargin) {
                this.mCursorRow = i6 + 1;
            } else {
                scroll();
            }
        }
        if ((this.mInsertMode & (charWidth != 0)) && (i4 = (i3 = this.mCursorCol) + charWidth) < (i5 = this.mColumns)) {
            TranscriptScreen transcriptScreen = this.mScreen;
            int i7 = this.mCursorRow;
            transcriptScreen.blockCopy(i3, i7, i5 - i4, 1, i4, i7);
        }
        if (charWidth != 0) {
            this.mScreen.set(this.mCursorCol, this.mCursorRow, i, i2);
            this.mJustWrapped = false;
        } else if (this.mJustWrapped) {
            this.mScreen.set(this.mColumns - this.mLastEmittedCharWidth, this.mCursorRow - 1, i, i2);
        } else {
            this.mScreen.set(this.mCursorCol - this.mLastEmittedCharWidth, this.mCursorRow, i, i2);
        }
        if (autoWrapEnabled) {
            boolean z = this.mCursorCol == this.mColumns - 1;
            this.mAboutToAutoWrap = z;
            if (z) {
                this.mScreen.setLineWrap(this.mCursorRow);
            }
        }
        this.mCursorCol = Math.min(this.mCursorCol + charWidth, this.mColumns - 1);
        if (charWidth > 0) {
            this.mLastEmittedCharWidth = charWidth;
        }
    }

    private void emit(char[] cArr) {
        if (Character.isHighSurrogate(cArr[0])) {
            emit(Character.toCodePoint(cArr[0], cArr[1]));
        } else {
            emit(cArr[0]);
        }
    }

    private void emit(char[] cArr, int i, int i2, int i3) {
        while (i < i2 && cArr[i] != 0) {
            if (Character.isHighSurrogate(cArr[i])) {
                char c = cArr[i];
                i++;
                emit(Character.toCodePoint(c, cArr[i]), i3);
            } else {
                emit(cArr[i], i3);
            }
            i++;
        }
    }

    private void finishSequence() {
        this.mEscapeState = 0;
    }

    private int getArg(int i, int i2, boolean z) {
        int i3 = this.mArgs[i];
        return i3 >= 0 ? (i3 == 0 && z) ? i2 : i3 : i2;
    }

    private int getArg0(int i) {
        return getArg(0, i, true);
    }

    private int getArg1(int i) {
        return getArg(1, i, true);
    }

    private int getBackColor() {
        return this.mBackColor;
    }

    private int getDecFlagsMask(int i) {
        if (i < 1 || i > 32) {
            return 0;
        }
        return 1 << i;
    }

    private int getEffect() {
        return this.mEffect;
    }

    private int getForeColor() {
        return this.mForeColor;
    }

    private int getStyle() {
        return TextStyle.encode(getForeColor(), getBackColor(), getEffect());
    }

    private boolean handleUTF8Sequence(byte b) {
        int i = this.mUTF8ToFollow;
        if (i == 0 && (b & 128) == 0) {
            return false;
        }
        if (i <= 0) {
            if ((b & 224) == K_DECSC_DECRC_MASK) {
                this.mUTF8ToFollow = 1;
            } else if ((b & 240) == 224) {
                this.mUTF8ToFollow = 2;
            } else {
                if ((b & 248) != 240) {
                    emit(UNICODE_REPLACEMENT_CHAR);
                    return true;
                }
                this.mUTF8ToFollow = 3;
            }
            this.mUTF8ByteBuffer.put(b);
        } else {
            if ((b & 192) != 128) {
                this.mUTF8ToFollow = 0;
                this.mUTF8ByteBuffer.clear();
                emit(UNICODE_REPLACEMENT_CHAR);
                return true;
            }
            this.mUTF8ByteBuffer.put(b);
            int i2 = this.mUTF8ToFollow - 1;
            this.mUTF8ToFollow = i2;
            if (i2 == 0) {
                ByteBuffer byteBuffer = this.mUTF8ByteBuffer;
                CharBuffer charBuffer = this.mInputCharBuffer;
                CharsetDecoder charsetDecoder = this.mUTF8Decoder;
                byteBuffer.rewind();
                charsetDecoder.reset();
                charsetDecoder.decode(byteBuffer, charBuffer, true);
                charsetDecoder.flush(charBuffer);
                char[] array = charBuffer.array();
                if (array[0] < 128 || array[0] > 159) {
                    emit(array);
                } else {
                    process((byte) array[0], false);
                }
                byteBuffer.clear();
                charBuffer.clear();
            }
        }
        return true;
    }

    private boolean isValidColor(int i) {
        return i >= 0 && i < 260;
    }

    private void logError(String str) {
        finishSequence();
    }

    private void logError(String str, byte b) {
    }

    private int nextOSCInt(int i) {
        int i2 = -1;
        while (true) {
            int i3 = this.mOSCArgTokenizerIndex;
            if (i3 >= this.mOSCArgLength) {
                break;
            }
            byte[] bArr = this.mOSCArg;
            this.mOSCArgTokenizerIndex = i3 + 1;
            byte b = bArr[i3];
            if (b == i) {
                break;
            }
            if (b < 48 || b > 57) {
                unknownSequence(b);
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                i2 = ((i2 * 10) + b) - 48;
            }
        }
        return i2;
    }

    private String nextOSCString(int i) {
        int i2 = this.mOSCArgTokenizerIndex;
        int i3 = i2;
        while (true) {
            int i4 = this.mOSCArgTokenizerIndex;
            if (i4 >= this.mOSCArgLength) {
                break;
            }
            byte[] bArr = this.mOSCArg;
            this.mOSCArgTokenizerIndex = i4 + 1;
            if (bArr[i4] == i) {
                break;
            }
            i3++;
        }
        return i2 == i3 ? "" : new String(this.mOSCArg, i2, i3 - i2, StandardCharsets.UTF_8);
    }

    private int nextTabStop(int i) {
        do {
            i++;
            int i2 = this.mColumns;
            if (i >= i2) {
                return i2 - 1;
            }
        } while (!this.mTabStop[i]);
        return i;
    }

    private void parseArg(byte b) {
        if (b < 48 || b > 57) {
            if (b != 59) {
                unknownSequence(b);
                return;
            }
            int i = this.mArgIndex;
            if (i < this.mArgs.length) {
                this.mArgIndex = i + 1;
            }
            continueSequence();
            return;
        }
        int i2 = this.mArgIndex;
        int[] iArr = this.mArgs;
        if (i2 < iArr.length) {
            int i3 = iArr[i2];
            int i4 = b - 48;
            if (i3 >= 0) {
                i4 += i3 * 10;
            }
            iArr[i2] = i4;
        }
        continueSequence();
    }

    private int prevTabStop(int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (this.mTabStop[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private void process(byte b) {
        process(b, true);
    }

    private void process(byte b, boolean z) {
        int i;
        if (z && this.mUTF8Mode && handleUTF8Sequence(b)) {
            return;
        }
        if ((b & 128) == 128 && (i = b & Byte.MAX_VALUE) <= 31) {
            process((byte) 27, false);
            process((byte) (i + 64), false);
            return;
        }
        if (b != 0) {
            if (b == 24 || b == 26) {
                if (this.mEscapeState != 0) {
                    this.mEscapeState = 0;
                    emit(Byte.MAX_VALUE);
                    return;
                }
                return;
            }
            if (b == 27) {
                if (this.mEscapeState != 8) {
                    startEscapeSequence(1);
                    return;
                } else {
                    doEscRightSquareBracket(b);
                    return;
                }
            }
            switch (b) {
                case 7:
                    if (this.mEscapeState == 8) {
                        doEscRightSquareBracket(b);
                        return;
                    }
                    TermSession.OnBellListener onBellListener = this.mBellListener;
                    if (onBellListener != null) {
                        onBellListener.onBellRecieved();
                        return;
                    }
                    return;
                case 8:
                    setCursorCol(Math.max(0, this.mCursorCol - 1));
                    return;
                case 9:
                    setCursorCol(nextTabStop(this.mCursorCol));
                    return;
                case 10:
                case 11:
                case 12:
                    doLinefeed();
                    return;
                case 13:
                    setCursorCol(0);
                    return;
                case 14:
                    setAltCharSet(true);
                    return;
                case 15:
                    setAltCharSet(false);
                    return;
                default:
                    this.mContinueSequence = false;
                    switch (this.mEscapeState) {
                        case 0:
                            if (b >= 32) {
                                emit(b);
                                break;
                            }
                            break;
                        case 1:
                            doEsc(b);
                            break;
                        case 2:
                            doEscPound(b);
                            break;
                        case 3:
                            doEscSelectLeftParen(b);
                            break;
                        case 4:
                            doEscSelectRightParen(b);
                            break;
                        case 5:
                            doEscLeftSquareBracket(b);
                            break;
                        case 6:
                            doEscLSBQuest(b);
                            break;
                        case 7:
                            doEscPercent(b);
                            break;
                        case 8:
                            doEscRightSquareBracket(b);
                            break;
                        case 9:
                            doEscRightSquareBracketEsc(b);
                            break;
                        default:
                            unknownSequence(b);
                            break;
                    }
                    if (this.mContinueSequence) {
                        return;
                    }
                    this.mEscapeState = 0;
                    return;
            }
        }
    }

    private void scroll() {
        this.mScrollCounter++;
        this.mScreen.scroll(this.mTopMargin, this.mBottomMargin, getStyle());
    }

    private void selectGraphicRendition() {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = this.mArgIndex;
            if (i2 > i3) {
                return;
            }
            int[] iArr = this.mArgs;
            int i4 = iArr[i2];
            if (i4 < 0) {
                if (i3 > 0) {
                    i2++;
                } else {
                    i4 = 0;
                }
            }
            if (i4 == 0) {
                this.mForeColor = this.mDefaultForeColor;
                this.mBackColor = this.mDefaultBackColor;
                this.mEffect = 0;
            } else if (i4 == 1) {
                this.mEffect |= 1;
            } else if (i4 == 3) {
                this.mEffect |= 2;
            } else if (i4 == 4) {
                this.mEffect |= 4;
            } else if (i4 == 5) {
                this.mEffect |= 8;
            } else if (i4 == 7) {
                this.mEffect |= 16;
            } else if (i4 == 8) {
                this.mEffect |= 32;
            } else if (i4 == 10) {
                setAltCharSet(false);
            } else if (i4 == 11) {
                setAltCharSet(true);
            } else if (i4 == 22) {
                this.mEffect &= -2;
            } else if (i4 == 23) {
                this.mEffect &= -3;
            } else if (i4 == 24) {
                this.mEffect &= -5;
            } else if (i4 == 25) {
                this.mEffect &= -9;
            } else if (i4 == 27) {
                this.mEffect &= -17;
            } else if (i4 == 28) {
                this.mEffect &= -33;
            } else if (i4 < 30 || i4 > 37) {
                if (i4 == 38 && (i = i2 + 2) <= i3 && iArr[i2 + 1] == 5) {
                    int i5 = iArr[i];
                    if (checkColor(i5)) {
                        this.mForeColor = i5;
                    }
                } else if (i4 == 39) {
                    this.mForeColor = this.mDefaultForeColor;
                } else if (i4 >= 40 && i4 <= 47) {
                    this.mBackColor = i4 - 40;
                } else if (i4 == 48 && (i = i2 + 2) <= i3 && iArr[i2 + 1] == 5) {
                    this.mBackColor = iArr[i];
                    int i6 = iArr[i];
                    if (checkColor(i6)) {
                        this.mBackColor = i6;
                    }
                } else if (i4 == 49) {
                    this.mBackColor = this.mDefaultBackColor;
                } else if (i4 >= 90 && i4 <= 97) {
                    this.mForeColor = (i4 - 90) + 8;
                } else if (i4 >= 100 && i4 <= 107) {
                    this.mBackColor = (i4 - 100) + 8;
                }
                i2 = i;
            } else {
                this.mForeColor = i4 - 30;
            }
            i2++;
        }
    }

    private void sendDeviceAttributes() {
        this.mSession.write(new byte[]{27, 91, 63, 49, 59, 50, 99}, 0, 7);
    }

    private void setAltCharSet(boolean z) {
        this.mAlternateCharSet = z;
        computeEffectiveCharSet();
    }

    private void setCursorCol(int i) {
        this.mCursorCol = i;
        this.mAboutToAutoWrap = false;
    }

    private void setCursorPosition(int i, int i2) {
        int i3;
        int i4;
        int i5 = this.mRows;
        if ((this.mDecFlags & 64) != 0) {
            i4 = this.mTopMargin;
            i3 = this.mBottomMargin;
        } else {
            i3 = i5;
            i4 = 0;
        }
        setCursorRowCol(Math.max(i4, Math.min(i2 + i4, i3 - 1)), Math.max(0, Math.min(i, this.mColumns - 1)));
    }

    private void setCursorRow(int i) {
        this.mCursorRow = i;
        this.mAboutToAutoWrap = false;
    }

    private void setCursorRowCol(int i, int i2) {
        this.mCursorRow = Math.min(i, this.mRows - 1);
        this.mCursorCol = Math.min(i2, this.mColumns - 1);
        this.mAboutToAutoWrap = false;
    }

    private void setDefaultTabStops() {
        int i = 0;
        while (i < this.mColumns) {
            this.mTabStop[i] = (i & 7) == 0 && i != 0;
            i++;
        }
    }

    private void setHorizontalVerticalPosition() {
        setCursorPosition(getArg1(1) - 1, getArg0(1) - 1);
    }

    private void startCollectingOSCArgs() {
        this.mOSCArgLength = 0;
    }

    private void startEscapeSequence(int i) {
        this.mEscapeState = i;
        this.mArgIndex = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            this.mArgs[i2] = -1;
        }
    }

    private void startTokenizingOSC() {
        this.mOSCArgTokenizerIndex = 0;
    }

    private void unimplementedSequence(byte b) {
        finishSequence();
    }

    private void unknownParameter(int i) {
    }

    private void unknownSequence(byte b) {
        finishSequence();
    }

    public void append(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i + i3];
            try {
                process(b);
                this.mProcessedCharCount++;
            } catch (Exception e) {
                Log.e(EmulatorDebug.LOG_TAG, "Exception while processing character " + this.mProcessedCharCount + " code " + Integer.toString(b), e);
            }
        }
    }

    public void clearScrollCounter() {
        this.mScrollCounter = 0;
    }

    public void finish() {
        TranscriptScreen transcriptScreen = this.mAltBuffer;
        if (transcriptScreen != null) {
            transcriptScreen.finish();
            this.mAltBuffer = null;
        }
    }

    public final boolean getCursorApplicationMode() {
        return this.mbCursorApplicationMode;
    }

    public final int getCursorCol() {
        return this.mCursorCol;
    }

    public final int getCursorRow() {
        return this.mCursorRow;
    }

    public final boolean getKeypadApplicationMode() {
        return this.mbKeypadApplicationMode;
    }

    public final int getMouseTrackingMode() {
        return this.mMouseTrackingMode;
    }

    public TermSession.OnBellListener getOnBellListener() {
        return this.mBellListener;
    }

    public final boolean getReverseVideo() {
        return (this.mDecFlags & 32) != 0;
    }

    public TranscriptScreen getScreen() {
        return this.mScreen;
    }

    public int getScrollCounter() {
        return this.mScrollCounter;
    }

    public String getSelectedText(int i, int i2, int i3, int i4) {
        return this.mScreen.getSelectedText(i, i2, i3, i4);
    }

    public final boolean getShowCursor() {
        return (this.mDecFlags & K_SHOW_CURSOR_MASK) != 0;
    }

    public boolean getUTF8Mode() {
        return this.mUTF8Mode;
    }

    public void reset() {
        this.mCursorRow = 0;
        this.mCursorCol = 0;
        this.mArgIndex = 0;
        this.mContinueSequence = false;
        this.mEscapeState = 0;
        this.mSavedCursorRow = 0;
        this.mSavedCursorCol = 0;
        this.mSavedEffect = 0;
        this.mSavedDecFlags_DECSC_DECRC = 0;
        this.mDecFlags = 0;
        int i = 0 | 128;
        this.mDecFlags = i;
        this.mDecFlags = i | K_SHOW_CURSOR_MASK;
        this.mSavedDecFlags = 0;
        this.mInsertMode = false;
        this.mTopMargin = 0;
        this.mBottomMargin = this.mRows;
        this.mAboutToAutoWrap = false;
        this.mForeColor = this.mDefaultForeColor;
        this.mBackColor = this.mDefaultBackColor;
        this.mbKeypadApplicationMode = false;
        this.mbCursorApplicationMode = false;
        this.mAlternateCharSet = false;
        int[] iArr = this.mCharSet;
        iArr[0] = 1;
        iArr[1] = 2;
        computeEffectiveCharSet();
        setDefaultTabStops();
        blockClear(0, 0, this.mColumns, this.mRows);
        setUTF8Mode(this.mDefaultUTF8Mode);
        this.mUTF8EscapeUsed = false;
        this.mUTF8ToFollow = 0;
        this.mUTF8ByteBuffer.clear();
        this.mInputCharBuffer.clear();
    }

    public void setColorScheme(ColorScheme colorScheme) {
        this.mDefaultForeColor = 256;
        this.mDefaultBackColor = 257;
        this.mMainBuffer.setColorScheme(colorScheme);
        TranscriptScreen transcriptScreen = this.mAltBuffer;
        if (transcriptScreen != null) {
            transcriptScreen.setColorScheme(colorScheme);
        }
    }

    public void setDefaultUTF8Mode(boolean z) {
        this.mDefaultUTF8Mode = z;
        if (this.mUTF8EscapeUsed) {
            return;
        }
        setUTF8Mode(z);
    }

    public void setKeyListener(TermKeyListener termKeyListener) {
        this.mKeyListener = termKeyListener;
    }

    public void setOnBellListener(TermSession.OnBellListener onBellListener) {
        this.mBellListener = onBellListener;
    }

    public void setUTF8Mode(boolean z) {
        if (z && !this.mUTF8Mode) {
            this.mUTF8ToFollow = 0;
            this.mUTF8ByteBuffer.clear();
            this.mInputCharBuffer.clear();
        }
        this.mUTF8Mode = z;
        UpdateCallback updateCallback = this.mUTF8ModeNotify;
        if (updateCallback != null) {
            updateCallback.onUpdate();
        }
    }

    public void setUTF8ModeUpdateCallback(UpdateCallback updateCallback) {
        this.mUTF8ModeNotify = updateCallback;
    }

    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v14 */
    public void updateSize(int i, int i2) {
        GrowableIntArray growableIntArray;
        String str;
        GrowableIntArray growableIntArray2;
        String str2;
        GrowableIntArray growableIntArray3;
        boolean z;
        char c;
        GrowableIntArray growableIntArray4;
        if (this.mRows == i2 && this.mColumns == i) {
            return;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("rows:" + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("rows:" + i2);
        }
        TranscriptScreen transcriptScreen = this.mScreen;
        TranscriptScreen transcriptScreen2 = this.mMainBuffer;
        if (transcriptScreen == transcriptScreen2) {
            transcriptScreen2 = this.mAltBuffer;
        }
        TranscriptScreen transcriptScreen3 = transcriptScreen2;
        int r12 = 0;
        int[] iArr = {this.mCursorCol, this.mCursorRow};
        boolean fastResize = transcriptScreen.fastResize(i, i2, iArr);
        if (fastResize) {
            growableIntArray = null;
            str = null;
            growableIntArray2 = null;
            str2 = null;
        } else {
            GrowableIntArray growableIntArray5 = new GrowableIntArray(1);
            int i3 = this.mCursorCol;
            int i4 = this.mCursorRow;
            String selectedText = transcriptScreen.getSelectedText(growableIntArray5, i3, i4, i3, i4);
            transcriptScreen.set(this.mCursorCol, this.mCursorRow, 27, 0);
            growableIntArray = new GrowableIntArray(1024);
            String transcriptText = transcriptScreen.getTranscriptText(growableIntArray);
            transcriptScreen.resize(i, i2, getStyle());
            growableIntArray2 = growableIntArray5;
            str2 = transcriptText;
            str = selectedText;
        }
        String str3 = null;
        if (transcriptScreen3 != null) {
            boolean fastResize2 = transcriptScreen3.fastResize(i, i2, null);
            if (fastResize2) {
                z = fastResize2;
                growableIntArray3 = null;
            } else {
                GrowableIntArray growableIntArray6 = new GrowableIntArray(1024);
                String transcriptText2 = transcriptScreen3.getTranscriptText(growableIntArray6);
                transcriptScreen3.resize(i, i2, getStyle());
                z = fastResize2;
                growableIntArray3 = growableIntArray6;
                str3 = transcriptText2;
            }
        } else {
            growableIntArray3 = null;
            z = true;
        }
        if (this.mRows != i2) {
            this.mRows = i2;
            this.mTopMargin = 0;
            this.mBottomMargin = i2;
        }
        int i5 = this.mColumns;
        if (i5 != i) {
            this.mColumns = i;
            boolean[] zArr = this.mTabStop;
            this.mTabStop = new boolean[i];
            r12 = 0;
            System.arraycopy(zArr, 0, this.mTabStop, 0, Math.min(i5, i));
        }
        if (z) {
            c = 1;
        } else {
            boolean z2 = this.mAboutToAutoWrap;
            this.mScreen = transcriptScreen3;
            this.mCursorRow = r12;
            this.mCursorCol = r12;
            this.mAboutToAutoWrap = r12 != 0;
            int length = str3.length() - 1;
            int i6 = 0;
            int i7 = 0;
            while (i6 <= length) {
                char charAt = str3.charAt(i6);
                int m10692at = growableIntArray3.m10692at(i6 - i7);
                if (Character.isHighSurrogate(charAt)) {
                    i6++;
                    growableIntArray4 = growableIntArray3;
                    emit(Character.toCodePoint(charAt, str3.charAt(i6)), m10692at);
                    i7++;
                } else {
                    growableIntArray4 = growableIntArray3;
                    if (charAt == '\n') {
                        setCursorCol(0);
                        doLinefeed();
                    } else {
                        emit(charAt, m10692at);
                    }
                }
                i6++;
                growableIntArray3 = growableIntArray4;
            }
            c = 1;
            this.mScreen = transcriptScreen;
            this.mAboutToAutoWrap = z2;
        }
        if (fastResize) {
            if (iArr[0] < 0 || iArr[c] < 0) {
                this.mCursorCol = 0;
                this.mCursorRow = 0;
                return;
            } else {
                this.mCursorCol = iArr[0];
                this.mCursorRow = iArr[c];
                return;
            }
        }
        this.mCursorRow = 0;
        this.mCursorCol = 0;
        this.mAboutToAutoWrap = false;
        int length2 = str2.length() - 1;
        while (length2 >= 0 && str2.charAt(length2) == '\n') {
            length2--;
        }
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        while (i12 <= length2) {
            char charAt2 = str2.charAt(i12);
            int m10692at2 = growableIntArray.m10692at(i12 - i8);
            if (Character.isHighSurrogate(charAt2)) {
                i12++;
                emit(Character.toCodePoint(charAt2, str2.charAt(i12)), m10692at2);
                i8++;
            } else if (charAt2 == '\n') {
                setCursorCol(0);
                doLinefeed();
            } else if (charAt2 == 27) {
                i9 = this.mCursorRow;
                i10 = this.mCursorCol;
                i11 = transcriptScreen.getActiveRows();
                if (str != null && str.length() > 0) {
                    emit(str.toCharArray(), 0, str.length(), growableIntArray2.m10692at(0));
                }
            } else {
                emit(charAt2, m10692at2);
            }
            i12++;
        }
        if (i9 == -1 || i10 == -1) {
            return;
        }
        this.mCursorRow = i9;
        this.mCursorCol = i10;
        int activeRows = transcriptScreen.getActiveRows() - i11;
        if (activeRows > 0 && activeRows <= i9) {
            this.mCursorRow -= activeRows;
        } else if (activeRows > i9) {
            this.mCursorRow = 0;
            this.mCursorCol = 0;
        }
    }
}
