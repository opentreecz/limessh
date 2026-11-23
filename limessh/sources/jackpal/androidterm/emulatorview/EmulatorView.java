package jackpal.androidterm.emulatorview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.widget.Scroller;
import jackpal.androidterm.emulatorview.compat.ClipboardManagerCompatFactory;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class EmulatorView extends View implements GestureDetector.OnGestureListener {
    private static final int CURSOR_BLINK_PERIOD = 1000;
    private static final boolean LOG_IME = false;
    private static final boolean LOG_KEY_EVENTS = false;
    private static final int SELECT_TEXT_OFFSET_Y = -56;
    private static final String TAG = "EmulatorView";
    private int[] colors;
    private Typeface font;
    private boolean mAutocomplete;
    private boolean mBackKeySendsCharacter;
    private Paint mBackgroundPaint;
    private Runnable mBlinkCursor;
    private int mCharacterHeight;
    private float mCharacterWidth;
    private ColorScheme mColorScheme;
    private int mColumns;
    private int mControlKeyCode;
    private int mCursorBlink;
    private boolean mCursorVisible;
    private boolean mDeferInit;
    private float mDensity;
    private TerminalEmulator mEmulator;
    private GestureDetector.OnGestureListener mExtGestureListener;
    private Runnable mFlingRunner;
    private int mFnKeyCode;
    private Paint mForegroundPaint;
    private GestureDetector mGestureDetector;
    private boolean mGotSelectionFinish;
    private boolean mGotSelectionStart;
    private final Handler mHandler;
    private String mImeBuffer;
    private boolean mIsActive;
    private boolean mIsControlKeySent;
    private boolean mIsFnKeySent;
    private boolean mIsSelectingText;
    private TermKeyListener mKeyListener;
    public OnKeyPressListener mKeyPressListener;
    private boolean mKnownSize;
    private int mLeftColumn;
    private Hashtable<Integer, URLSpan[]> mLinkLayer;
    private boolean mMouseTracking;
    private MouseTrackingFlingRunner mMouseTrackingFlingRunner;
    private int mRows;
    private float mScaledDensity;
    private float mScrollRemainder;
    private Scroller mScroller;
    private int mSelX1;
    private int mSelX2;
    private int mSelXAnchor;
    private int mSelY1;
    private int mSelY2;
    private int mSelYAnchor;
    private SelectingTextListener mSelectingTextListener;
    private int mSelectionFinishX;
    private int mSelectionFinishY;
    private int mSelectionStartX;
    private int mSelectionStartY;
    private TermSession mTermSession;
    private TextRenderer mTextRenderer;
    private int mTextSize;
    private int mTopOfScreenMargin;
    private int mTopRow;
    private UpdateCallback mUpdateNotify;
    private boolean mUseCookedIme;
    private int mVisibleColumns;
    private int mVisibleHeight;
    private int mVisibleWidth;
    private static final boolean sTrapAltAndMeta = Build.MODEL.contains("Transformer TF101");
    private static Linkify.MatchFilter sHttpMatchFilter = new HttpMatchFilter();

    /* loaded from: classes.dex */
    public static class HttpMatchFilter implements Linkify.MatchFilter {
        private HttpMatchFilter() {
        }

        private boolean startsWith(CharSequence charSequence, int i, int i2, String str) {
            int length = str.length();
            if (length > i2 - i) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (charSequence.charAt(i + i3) != str.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.text.util.Linkify.MatchFilter
        public boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            return startsWith(charSequence, i, i2, "http:") || startsWith(charSequence, i, i2, "https:");
        }
    }

    /* loaded from: classes.dex */
    public class MouseTrackingFlingRunner implements Runnable {
        private int mLastY;
        private MotionEvent mMotionEvent;
        private Scroller mScroller;

        private MouseTrackingFlingRunner() {
        }

        public void fling(MotionEvent motionEvent, float f, float f2) {
            this.mScroller.fling(0, 0, -((int) (f * 0.15f)), -((int) (f2 * 0.15f)), 0, 0, -100, 100);
            this.mLastY = 0;
            this.mMotionEvent = motionEvent;
            EmulatorView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && EmulatorView.this.isMouseTrackingActive()) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                int currY = this.mScroller.getCurrY();
                while (this.mLastY < currY) {
                    EmulatorView.this.sendMouseEventCode(this.mMotionEvent, 65);
                    this.mLastY++;
                }
                while (this.mLastY > currY) {
                    EmulatorView.this.sendMouseEventCode(this.mMotionEvent, 64);
                    this.mLastY--;
                }
                if (computeScrollOffset) {
                    EmulatorView.this.post(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnKeyPressListener {
        void onKeyPressed(int i);
    }

    /* loaded from: classes.dex */
    public static abstract class SelectingTextListener {
        public void onEndPointSelected() {
        }

        public void onSelectionFinish() {
        }

        public void onSelectionStart() {
        }

        public void onStartPointSelected() {
        }
    }

    public EmulatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDeferInit = false;
        this.mTextSize = 10;
        this.mColorScheme = BaseTextRenderer.defaultColorScheme;
        this.mCursorVisible = true;
        this.mIsSelectingText = false;
        this.mBackKeySendsCharacter = false;
        this.mIsControlKeySent = false;
        this.mIsFnKeySent = false;
        this.mSelXAnchor = -1;
        this.mSelYAnchor = -1;
        this.mSelX1 = -1;
        this.mSelY1 = -1;
        this.mSelX2 = -1;
        this.mSelY2 = -1;
        this.mIsActive = false;
        this.mAutocomplete = false;
        this.mGotSelectionStart = false;
        this.mGotSelectionFinish = false;
        this.mSelectionStartX = -1;
        this.mSelectionStartY = -1;
        this.mSelectionFinishX = -1;
        this.mSelectionFinishY = -1;
        this.mBlinkCursor = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.1
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mCursorBlink != 0) {
                    EmulatorView emulatorView = EmulatorView.this;
                    emulatorView.mCursorVisible = true ^ emulatorView.mCursorVisible;
                    EmulatorView.this.mHandler.postDelayed(this, 1000L);
                } else {
                    EmulatorView.this.mCursorVisible = true;
                }
                EmulatorView.this.invalidate();
            }
        };
        this.mFlingRunner = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.2
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mScroller.isFinished() || EmulatorView.this.isMouseTrackingActive()) {
                    return;
                }
                boolean computeScrollOffset = EmulatorView.this.mScroller.computeScrollOffset();
                int currY = EmulatorView.this.mScroller.getCurrY();
                if (currY != EmulatorView.this.mTopRow) {
                    EmulatorView.this.mTopRow = currY;
                    EmulatorView.this.invalidate();
                }
                if (computeScrollOffset) {
                    EmulatorView.this.post(this);
                }
            }
        };
        this.mLinkLayer = new Hashtable<>();
        this.mMouseTrackingFlingRunner = new MouseTrackingFlingRunner();
        this.mImeBuffer = "";
        this.mHandler = new Handler();
        this.mUpdateNotify = new UpdateCallback() { // from class: jackpal.androidterm.emulatorview.EmulatorView.3
            @Override // jackpal.androidterm.emulatorview.UpdateCallback
            public void onUpdate() {
                if (EmulatorView.this.mIsSelectingText) {
                    int scrollCounter = EmulatorView.this.mEmulator.getScrollCounter();
                    EmulatorView.this.mSelY1 -= scrollCounter;
                    EmulatorView.this.mSelY2 -= scrollCounter;
                    EmulatorView.this.mSelYAnchor -= scrollCounter;
                }
                EmulatorView.this.mEmulator.clearScrollCounter();
                EmulatorView.this.ensureCursorVisible();
                EmulatorView.this.invalidate();
            }
        };
        commonConstructor(context);
    }

    public EmulatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDeferInit = false;
        this.mTextSize = 10;
        this.mColorScheme = BaseTextRenderer.defaultColorScheme;
        this.mCursorVisible = true;
        this.mIsSelectingText = false;
        this.mBackKeySendsCharacter = false;
        this.mIsControlKeySent = false;
        this.mIsFnKeySent = false;
        this.mSelXAnchor = -1;
        this.mSelYAnchor = -1;
        this.mSelX1 = -1;
        this.mSelY1 = -1;
        this.mSelX2 = -1;
        this.mSelY2 = -1;
        this.mIsActive = false;
        this.mAutocomplete = false;
        this.mGotSelectionStart = false;
        this.mGotSelectionFinish = false;
        this.mSelectionStartX = -1;
        this.mSelectionStartY = -1;
        this.mSelectionFinishX = -1;
        this.mSelectionFinishY = -1;
        this.mBlinkCursor = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.1
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mCursorBlink != 0) {
                    EmulatorView emulatorView = EmulatorView.this;
                    emulatorView.mCursorVisible = true ^ emulatorView.mCursorVisible;
                    EmulatorView.this.mHandler.postDelayed(this, 1000L);
                } else {
                    EmulatorView.this.mCursorVisible = true;
                }
                EmulatorView.this.invalidate();
            }
        };
        this.mFlingRunner = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.2
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mScroller.isFinished() || EmulatorView.this.isMouseTrackingActive()) {
                    return;
                }
                boolean computeScrollOffset = EmulatorView.this.mScroller.computeScrollOffset();
                int currY = EmulatorView.this.mScroller.getCurrY();
                if (currY != EmulatorView.this.mTopRow) {
                    EmulatorView.this.mTopRow = currY;
                    EmulatorView.this.invalidate();
                }
                if (computeScrollOffset) {
                    EmulatorView.this.post(this);
                }
            }
        };
        this.mLinkLayer = new Hashtable<>();
        this.mMouseTrackingFlingRunner = new MouseTrackingFlingRunner();
        this.mImeBuffer = "";
        this.mHandler = new Handler();
        this.mUpdateNotify = new UpdateCallback() { // from class: jackpal.androidterm.emulatorview.EmulatorView.3
            @Override // jackpal.androidterm.emulatorview.UpdateCallback
            public void onUpdate() {
                if (EmulatorView.this.mIsSelectingText) {
                    int scrollCounter = EmulatorView.this.mEmulator.getScrollCounter();
                    EmulatorView.this.mSelY1 -= scrollCounter;
                    EmulatorView.this.mSelY2 -= scrollCounter;
                    EmulatorView.this.mSelYAnchor -= scrollCounter;
                }
                EmulatorView.this.mEmulator.clearScrollCounter();
                EmulatorView.this.ensureCursorVisible();
                EmulatorView.this.invalidate();
            }
        };
        commonConstructor(context);
    }

    public EmulatorView(Context context, TermSession termSession, DisplayMetrics displayMetrics) {
        super(context);
        this.mDeferInit = false;
        this.mTextSize = 10;
        this.mColorScheme = BaseTextRenderer.defaultColorScheme;
        this.mCursorVisible = true;
        this.mIsSelectingText = false;
        this.mBackKeySendsCharacter = false;
        this.mIsControlKeySent = false;
        this.mIsFnKeySent = false;
        this.mSelXAnchor = -1;
        this.mSelYAnchor = -1;
        this.mSelX1 = -1;
        this.mSelY1 = -1;
        this.mSelX2 = -1;
        this.mSelY2 = -1;
        this.mIsActive = false;
        this.mAutocomplete = false;
        this.mGotSelectionStart = false;
        this.mGotSelectionFinish = false;
        this.mSelectionStartX = -1;
        this.mSelectionStartY = -1;
        this.mSelectionFinishX = -1;
        this.mSelectionFinishY = -1;
        this.mBlinkCursor = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.1
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mCursorBlink != 0) {
                    EmulatorView emulatorView = EmulatorView.this;
                    emulatorView.mCursorVisible = true ^ emulatorView.mCursorVisible;
                    EmulatorView.this.mHandler.postDelayed(this, 1000L);
                } else {
                    EmulatorView.this.mCursorVisible = true;
                }
                EmulatorView.this.invalidate();
            }
        };
        this.mFlingRunner = new Runnable() { // from class: jackpal.androidterm.emulatorview.EmulatorView.2
            @Override // java.lang.Runnable
            public void run() {
                if (EmulatorView.this.mScroller.isFinished() || EmulatorView.this.isMouseTrackingActive()) {
                    return;
                }
                boolean computeScrollOffset = EmulatorView.this.mScroller.computeScrollOffset();
                int currY = EmulatorView.this.mScroller.getCurrY();
                if (currY != EmulatorView.this.mTopRow) {
                    EmulatorView.this.mTopRow = currY;
                    EmulatorView.this.invalidate();
                }
                if (computeScrollOffset) {
                    EmulatorView.this.post(this);
                }
            }
        };
        this.mLinkLayer = new Hashtable<>();
        this.mMouseTrackingFlingRunner = new MouseTrackingFlingRunner();
        this.mImeBuffer = "";
        this.mHandler = new Handler();
        this.mUpdateNotify = new UpdateCallback() { // from class: jackpal.androidterm.emulatorview.EmulatorView.3
            @Override // jackpal.androidterm.emulatorview.UpdateCallback
            public void onUpdate() {
                if (EmulatorView.this.mIsSelectingText) {
                    int scrollCounter = EmulatorView.this.mEmulator.getScrollCounter();
                    EmulatorView.this.mSelY1 -= scrollCounter;
                    EmulatorView.this.mSelY2 -= scrollCounter;
                    EmulatorView.this.mSelYAnchor -= scrollCounter;
                }
                EmulatorView.this.mEmulator.clearScrollCounter();
                EmulatorView.this.ensureCursorVisible();
                EmulatorView.this.invalidate();
            }
        };
        attachSession(termSession);
        setDensity(displayMetrics);
        commonConstructor(context);
    }

    private void commonConstructor(Context context) {
        this.mScroller = new Scroller(context);
        this.mMouseTrackingFlingRunner.mScroller = new Scroller(context);
    }

    private int createLinks(int i) {
        int i2;
        int i3;
        URLSpan[] uRLSpanArr;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        int charWidth;
        URLSpan[] uRLSpanArr2;
        int charWidth2;
        int i7;
        TranscriptScreen screen = this.mEmulator.getScreen();
        char[] scriptLine = screen.getScriptLine(i);
        boolean z3 = true;
        if (scriptLine == null) {
            return 1;
        }
        boolean isBasicLine = screen.isBasicLine(i);
        int i8 = 0;
        if (isBasicLine) {
            i2 = scriptLine.length;
        } else {
            i2 = 0;
            while (scriptLine[i2] != 0) {
                i2++;
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new String(scriptLine, 0, i2));
        boolean scriptLineWrap = screen.getScriptLineWrap(i);
        int i9 = 1;
        while (scriptLineWrap) {
            int i10 = i + i9;
            char[] scriptLine2 = screen.getScriptLine(i10);
            if (scriptLine2 == null) {
                break;
            }
            boolean isBasicLine2 = screen.isBasicLine(i10);
            if (isBasicLine && !isBasicLine2) {
                isBasicLine = isBasicLine2;
            }
            if (isBasicLine2) {
                i7 = scriptLine2.length;
            } else {
                i7 = 0;
                while (scriptLine2[i7] != 0) {
                    i7++;
                }
            }
            spannableStringBuilder.append((CharSequence) new String(scriptLine2, 0, i7));
            scriptLineWrap = screen.getScriptLineWrap(i10);
            i9++;
        }
        Linkify.addLinks(spannableStringBuilder, Patterns.WEB_URL, (String) null, sHttpMatchFilter, (Linkify.TransformFilter) null);
        URLSpan[] uRLSpanArr3 = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        if (uRLSpanArr3.length > 0) {
            int i11 = this.mColumns;
            int i12 = i - this.mTopRow;
            URLSpan[][] uRLSpanArr4 = new URLSpan[i9];
            for (int i13 = 0; i13 < i9; i13++) {
                uRLSpanArr4[i13] = new URLSpan[i11];
                Arrays.fill(uRLSpanArr4[i13], (Object) null);
            }
            int i14 = 0;
            while (i14 < uRLSpanArr3.length) {
                URLSpan uRLSpan = uRLSpanArr3[i14];
                int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
                if (isBasicLine) {
                    int i15 = this.mColumns;
                    i3 = spanStart / i15;
                    i6 = spanStart % i15;
                    int i16 = spanEnd / i15;
                    i5 = spanEnd % i15;
                    uRLSpanArr = uRLSpanArr3;
                    z = isBasicLine;
                    i4 = i16;
                } else {
                    int i17 = i8;
                    i3 = i17;
                    while (i8 < spanStart) {
                        char charAt = spannableStringBuilder.charAt(i8);
                        if (Character.isHighSurrogate(charAt)) {
                            i8++;
                            uRLSpanArr2 = uRLSpanArr3;
                            charWidth2 = UnicodeTranscript.charWidth(charAt, spannableStringBuilder.charAt(i8));
                        } else {
                            uRLSpanArr2 = uRLSpanArr3;
                            charWidth2 = UnicodeTranscript.charWidth(charAt);
                        }
                        i17 += charWidth2;
                        if (i17 >= i11) {
                            i3++;
                            i17 %= i11;
                        }
                        i8++;
                        uRLSpanArr3 = uRLSpanArr2;
                    }
                    uRLSpanArr = uRLSpanArr3;
                    int i18 = i17;
                    i4 = i3;
                    while (spanStart < spanEnd) {
                        char charAt2 = spannableStringBuilder.charAt(spanStart);
                        if (Character.isHighSurrogate(charAt2)) {
                            spanStart++;
                            z2 = isBasicLine;
                            charWidth = UnicodeTranscript.charWidth(charAt2, spannableStringBuilder.charAt(spanStart));
                        } else {
                            z2 = isBasicLine;
                            charWidth = UnicodeTranscript.charWidth(charAt2);
                        }
                        i18 += charWidth;
                        if (i18 >= i11) {
                            i4++;
                            i18 %= i11;
                        }
                        spanStart++;
                        isBasicLine = z2;
                    }
                    z = isBasicLine;
                    i5 = i18;
                    i6 = i17;
                }
                int i19 = i3;
                while (i19 <= i4) {
                    Arrays.fill(uRLSpanArr4[i19], i19 == i3 ? i6 : 0, i19 == i4 ? i5 : this.mColumns, uRLSpan);
                    i19++;
                }
                i14++;
                uRLSpanArr3 = uRLSpanArr;
                isBasicLine = z;
                z3 = true;
                i8 = 0;
            }
            for (int i20 = 0; i20 < i9; i20++) {
                try {
                    this.mLinkLayer.put(Integer.valueOf(i12 + i20), uRLSpanArr4[i20]);
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureCursorVisible() {
        this.mTopRow = 0;
        if (this.mVisibleColumns > 0) {
            int cursorCol = this.mEmulator.getCursorCol();
            int cursorCol2 = this.mEmulator.getCursorCol() - this.mLeftColumn;
            if (cursorCol2 < 0) {
                this.mLeftColumn = cursorCol;
                return;
            }
            int i = this.mVisibleColumns;
            if (cursorCol2 >= i) {
                this.mLeftColumn = (cursorCol - i) + 1;
            }
        }
    }

    private boolean handleControlKey(int i, boolean z) {
        if (i != this.mControlKeyCode) {
            return false;
        }
        this.mKeyListener.handleControlKey(z);
        invalidate();
        return true;
    }

    private boolean handleFnKey(int i, boolean z) {
        if (i != this.mFnKeyCode) {
            return false;
        }
        this.mKeyListener.handleFnKey(z);
        invalidate();
        return true;
    }

    private boolean handleHardwareControlKey(int i, KeyEvent keyEvent) {
        if (i != 113 && i != 114) {
            return false;
        }
        this.mKeyListener.handleHardwareControlKey(keyEvent.getAction() == 0);
        invalidate();
        return true;
    }

    private void initialize() {
        TermSession termSession = this.mTermSession;
        updateText();
        this.mEmulator = termSession.getEmulator();
        termSession.setUpdateCallback(this.mUpdateNotify);
        requestFocus();
    }

    private boolean isInterceptedSystemKey(int i) {
        return i == 4 && this.mBackKeySendsCharacter;
    }

    private boolean isSystemKey(int i, KeyEvent keyEvent) {
        return keyEvent.isSystem();
    }

    private boolean onTouchEventWhileSelectingText(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int max = Math.max(0, (int) (x / this.mCharacterWidth));
        int max2 = Math.max(0, ((int) ((y + (this.mScaledDensity * (-56.0f))) / this.mCharacterHeight)) + this.mTopRow);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.mSelectionStartX >= 0 || this.mSelectionStartY >= 0) {
                        if (max2 > this.mSelY1) {
                            this.mSelX2 = max;
                        } else {
                            this.mSelX2 = Math.max(max, this.mSelX1);
                        }
                        this.mSelY2 = Math.max(Math.max(max2, 0), this.mSelY1);
                    } else {
                        this.mSelX1 = max;
                        this.mSelY1 = Math.max(max2, 0);
                        this.mSelX2 = max;
                        this.mSelY2 = Math.max(max2, 0);
                    }
                    invalidate();
                }
            } else if (this.mSelectionStartX >= 0 || this.mSelectionStartY >= 0) {
                this.mSelectionFinishX = this.mSelX2;
                this.mSelectionFinishY = this.mSelY2;
                ClipboardManagerCompatFactory.getManager(getContext().getApplicationContext()).setText(getSelectedText().trim());
                invalidate();
                SelectingTextListener selectingTextListener = this.mSelectingTextListener;
                if (selectingTextListener != null) {
                    selectingTextListener.onEndPointSelected();
                }
                toggleSelectingText(null);
            } else {
                this.mSelectionStartX = this.mSelX1;
                this.mSelectionStartY = this.mSelY1;
                SelectingTextListener selectingTextListener2 = this.mSelectingTextListener;
                if (selectingTextListener2 != null) {
                    selectingTextListener2.onStartPointSelected();
                }
            }
        } else if (this.mSelectionStartX >= 0 || this.mSelectionStartY >= 0) {
            this.mSelX2 = max;
            this.mSelY2 = max2;
        } else {
            this.mSelX1 = max;
            this.mSelY1 = max2;
            this.mSelX2 = -1;
            this.mSelY2 = -1;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMouseEventCode(MotionEvent motionEvent, int i) {
        int x = ((int) (motionEvent.getX() / this.mCharacterWidth)) + 1;
        int y = ((int) ((motionEvent.getY() - this.mTopOfScreenMargin) / this.mCharacterHeight)) + 1;
        boolean z = x < 1 || y < 1 || x > this.mColumns || y > this.mRows || x > 223 || y > 223;
        if (i >= 0 && i <= 223) {
            if (z) {
                return;
            }
            this.mTermSession.write(new byte[]{27, 91, 77, (byte) (i + 32), (byte) (x + 32), (byte) (y + 32)}, 0, 6);
        } else {
            Log.e("EmulatorView", "mouse button_code out of range: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImeBuffer(String str) {
        if (!str.equals(this.mImeBuffer)) {
            invalidate();
        }
        this.mImeBuffer = str;
    }

    private void updateSize(int i, int i2) {
        this.mColumns = Math.max(1, (int) (i / this.mCharacterWidth));
        this.mVisibleColumns = (int) (this.mVisibleWidth / this.mCharacterWidth);
        int topMargin = this.mTextRenderer.getTopMargin();
        this.mTopOfScreenMargin = topMargin;
        int max = Math.max(1, (i2 - topMargin) / this.mCharacterHeight);
        this.mRows = max;
        this.mTermSession.updateSize(this.mColumns, max);
        this.mTopRow = 0;
        this.mLeftColumn = 0;
        invalidate();
    }

    private void updateText() {
        ColorScheme colorScheme = this.mColorScheme;
        if (this.mTextSize > 0) {
            int[] iArr = this.colors;
            if (iArr == null || iArr.length != 260) {
                this.mTextRenderer = new PaintRenderer(this.mTextSize, getFont(), colorScheme);
            } else {
                colorScheme = new ColorScheme(iArr[256], iArr[257]);
                this.mTextRenderer = new StyledPaintRenderer(this.mTextSize, getFont(), colorScheme, this.colors);
            }
        } else {
            int[] iArr2 = this.colors;
            if (iArr2 == null || iArr2.length != 260) {
                this.mTextRenderer = new Bitmap4x8FontRenderer(getResources(), colorScheme);
            } else {
                colorScheme = new ColorScheme(iArr2[256], iArr2[257]);
                this.mTextRenderer = new StyledBitmap4x8FontRenderer(getResources(), colorScheme, this.colors);
            }
        }
        this.mForegroundPaint.setColor(colorScheme.getForeColor());
        this.mBackgroundPaint.setColor(colorScheme.getBackColor());
        this.mCharacterWidth = this.mTextRenderer.getCharacterWidth();
        this.mCharacterHeight = this.mTextRenderer.getCharacterHeight();
        updateSize(true);
    }

    public void attachSession(TermSession termSession) {
        this.mTextRenderer = null;
        this.mForegroundPaint = new Paint();
        this.mBackgroundPaint = new Paint();
        this.mTopRow = 0;
        this.mLeftColumn = 0;
        this.mGestureDetector = new GestureDetector(this);
        setVerticalScrollBarEnabled(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mTermSession = termSession;
        if (termSession.getKeyListener() != null) {
            this.mKeyListener = termSession.getKeyListener();
        } else {
            TermKeyListener termKeyListener = new TermKeyListener(termSession);
            this.mKeyListener = termKeyListener;
            termSession.setKeyListener(termKeyListener);
        }
        if (this.mDeferInit) {
            this.mDeferInit = false;
            this.mKnownSize = true;
            initialize();
        }
    }

    public void cancelSpecialKeyStatus() {
        this.mKeyListener.handleHardwareControlKey(false);
    }

    public void clearSpecialKeyStatus() {
        if (this.mIsControlKeySent) {
            Log.d("EmulatorView", "Ctrl key is set - updating it to unpressed");
            this.mIsControlKeySent = false;
            this.mKeyListener.handleControlKey(false);
            invalidate();
        }
        if (this.mIsFnKeySent) {
            this.mIsFnKeySent = false;
            this.mKeyListener.handleFnKey(false);
            invalidate();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return this.mRows;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return (this.mEmulator.getScreen().getActiveRows() + this.mTopRow) - this.mRows;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return this.mEmulator.getScreen().getActiveRows();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[LOOP:1: B:11:0x0081->B:31:0x00cb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007e A[LOOP:0: B:6:0x0040->B:54:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String findWordAt(float r11, float r12, int r13) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jackpal.androidterm.emulatorview.EmulatorView.findWordAt(float, float, int):java.lang.String");
    }

    public float getCharacterHeight() {
        return this.mCharacterHeight;
    }

    public float getCharacterWidth() {
        return this.mCharacterWidth;
    }

    public boolean getCursorApplicationMode() {
        return this.mEmulator.getCursorApplicationMode();
    }

    public Typeface getFont() {
        return Typeface.MONOSPACE;
    }

    public boolean getKeypadApplicationMode() {
        return this.mEmulator.getKeypadApplicationMode();
    }

    public String getSelectedText() {
        return this.mEmulator.getSelectedText(this.mSelX1, this.mSelY1, this.mSelX2, this.mSelY2);
    }

    public boolean getSelectingText() {
        return this.mIsSelectingText;
    }

    public TermSession getTermSession() {
        return this.mTermSession;
    }

    public int getTopOfScreenMargin() {
        return this.mTopOfScreenMargin;
    }

    public String getURLat(float f, float f2) {
        URLSpan uRLSpan;
        float width = getWidth();
        float height = getHeight();
        if (width != 0.0f && height != 0.0f) {
            int floor = (int) Math.floor((f2 / height) * this.mRows);
            int floor2 = (int) Math.floor((f / width) * this.mColumns);
            URLSpan[] uRLSpanArr = this.mLinkLayer.get(Integer.valueOf(floor));
            if (uRLSpanArr != null && (uRLSpan = uRLSpanArr[floor2]) != null) {
                return uRLSpan.getURL();
            }
        }
        return null;
    }

    public int getVisibleHeight() {
        return this.mVisibleHeight;
    }

    public int getVisibleWidth() {
        return this.mVisibleWidth;
    }

    public boolean isMouseTrackingActive() {
        return this.mEmulator.getMouseTrackingMode() != 0 && this.mMouseTracking;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.imeOptions = 268435457;
        boolean z = true;
        if (this.mAutocomplete) {
            editorInfo.inputType = 1;
        } else {
            editorInfo.inputType = KeycodeConstants.KEYCODE_NUMPAD_1;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            editorInfo.imeOptions = 268435457 | 33554432;
        }
        return new BaseInputConnection(this, z) { // from class: jackpal.androidterm.emulatorview.EmulatorView.4
            private int mComposingTextEnd;
            private int mComposingTextStart;
            private int mCursor;
            private int mSelectedTextEnd;
            private int mSelectedTextStart;

            private void clearComposingText() {
                int length = EmulatorView.this.mImeBuffer.length();
                if (this.mComposingTextStart > length || this.mComposingTextEnd > length) {
                    this.mComposingTextStart = 0;
                    this.mComposingTextEnd = 0;
                    return;
                }
                EmulatorView.this.setImeBuffer(EmulatorView.this.mImeBuffer.substring(0, this.mComposingTextStart) + EmulatorView.this.mImeBuffer.substring(this.mComposingTextEnd));
                int i = this.mCursor;
                int i2 = this.mComposingTextStart;
                if (i >= i2) {
                    int i3 = this.mComposingTextEnd;
                    if (i < i3) {
                        this.mCursor = i2;
                    } else {
                        this.mCursor = i - (i3 - i2);
                    }
                }
                this.mComposingTextStart = 0;
                this.mComposingTextEnd = 0;
            }

            private void mapAndSend(int i) throws IOException {
                int mapControlChar = EmulatorView.this.mKeyListener.mapControlChar(i);
                if (mapControlChar < 10485760) {
                    EmulatorView.this.mTermSession.write(mapControlChar);
                } else {
                    EmulatorView.this.mKeyListener.handleKeyCode(mapControlChar - TermKeyListener.KEYCODE_OFFSET, null, EmulatorView.this.getKeypadApplicationMode());
                }
                EmulatorView.this.clearSpecialKeyStatus();
                OnKeyPressListener onKeyPressListener = EmulatorView.this.mKeyPressListener;
                if (onKeyPressListener != null) {
                    onKeyPressListener.onKeyPressed(i);
                }
            }

            private void sendText(CharSequence charSequence) {
                int length = charSequence.length();
                int i = 0;
                while (i < length) {
                    try {
                        char charAt = charSequence.charAt(i);
                        if (charAt == '\n') {
                            charAt = '\r';
                        }
                        if (Character.isHighSurrogate(charAt)) {
                            i++;
                            mapAndSend(i < length ? Character.toCodePoint(charAt, charSequence.charAt(i)) : 65533);
                        } else {
                            mapAndSend(charAt);
                        }
                        i++;
                    } catch (IOException e) {
                        Log.e("EmulatorView", "error writing ", e);
                        return;
                    }
                }
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean beginBatchEdit() {
                EmulatorView.this.setImeBuffer("");
                this.mCursor = 0;
                this.mComposingTextStart = 0;
                this.mComposingTextEnd = 0;
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean clearMetaKeyStates(int i) {
                return false;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean commitCompletion(CompletionInfo completionInfo) {
                return false;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean commitCorrection(CorrectionInfo correctionInfo) {
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean commitText(CharSequence charSequence, int i) {
                clearComposingText();
                sendText(charSequence);
                EmulatorView.this.setImeBuffer("");
                this.mCursor = 0;
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i, int i2) {
                if (i > 0) {
                    for (int i3 = 0; i3 < i; i3++) {
                        sendKeyEvent(new KeyEvent(0, 67));
                    }
                    return true;
                }
                if (i != 0 || i2 != 0) {
                    return true;
                }
                sendKeyEvent(new KeyEvent(0, 67));
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean endBatchEdit() {
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean finishComposingText() {
                sendText(EmulatorView.this.mImeBuffer);
                EmulatorView.this.setImeBuffer("");
                this.mComposingTextStart = 0;
                this.mComposingTextEnd = 0;
                this.mCursor = 0;
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public int getCursorCapsMode(int i) {
                return (i & 4096) != 0 ? 4096 : 0;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
                return null;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public CharSequence getSelectedText(int i) {
                int length = EmulatorView.this.mImeBuffer.length();
                int i2 = this.mSelectedTextEnd;
                return (i2 >= length || this.mSelectedTextStart > i2) ? "" : EmulatorView.this.mImeBuffer.substring(this.mSelectedTextStart, this.mSelectedTextEnd + 1);
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public CharSequence getTextAfterCursor(int i, int i2) {
                int i3;
                int min = Math.min(i, EmulatorView.this.mImeBuffer.length() - this.mCursor);
                if (min <= 0 || (i3 = this.mCursor) < 0 || i3 >= EmulatorView.this.mImeBuffer.length()) {
                    return "";
                }
                String str = EmulatorView.this.mImeBuffer;
                int i4 = this.mCursor;
                return str.substring(i4, min + i4);
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public CharSequence getTextBeforeCursor(int i, int i2) {
                int i3;
                int min = Math.min(i, this.mCursor);
                if (min <= 0 || (i3 = this.mCursor) < 0 || i3 >= EmulatorView.this.mImeBuffer.length()) {
                    return "";
                }
                String str = EmulatorView.this.mImeBuffer;
                int i4 = this.mCursor;
                return str.substring(i4 - min, i4);
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean performContextMenuAction(int i) {
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean performEditorAction(int i) {
                if (i == 0 || i == 1) {
                    sendText("\r");
                }
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(String str, Bundle bundle) {
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean reportFullscreenMode(boolean z2) {
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean sendKeyEvent(KeyEvent keyEvent) {
                EmulatorView.this.dispatchKeyEvent(keyEvent);
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean setComposingRegion(int i, int i2) {
                if (i >= i2 || i <= 0 || i2 >= EmulatorView.this.mImeBuffer.length()) {
                    return true;
                }
                clearComposingText();
                this.mComposingTextStart = i;
                this.mComposingTextEnd = i2;
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean setComposingText(CharSequence charSequence, int i) {
                int length = EmulatorView.this.mImeBuffer.length();
                if (this.mComposingTextStart > length || this.mComposingTextEnd > length) {
                    return false;
                }
                EmulatorView.this.setImeBuffer(EmulatorView.this.mImeBuffer.substring(0, this.mComposingTextStart) + ((Object) charSequence) + EmulatorView.this.mImeBuffer.substring(this.mComposingTextEnd));
                int length2 = this.mComposingTextStart + charSequence.length();
                this.mComposingTextEnd = length2;
                this.mCursor = i > 0 ? (length2 + i) - 1 : this.mComposingTextStart - i;
                return true;
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean setSelection(int i, int i2) {
                int length = EmulatorView.this.mImeBuffer.length();
                if (i == i2 && i > 0 && i < length) {
                    this.mSelectedTextEnd = 0;
                    this.mSelectedTextStart = 0;
                    this.mCursor = i;
                    return true;
                }
                if (i >= i2 || i <= 0 || i2 >= length) {
                    return true;
                }
                this.mSelectedTextStart = i;
                this.mSelectedTextEnd = i2;
                this.mCursor = i;
                return true;
            }
        };
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mExtGestureListener;
        if (onGestureListener != null && onGestureListener.onDown(motionEvent)) {
            return true;
        }
        this.mScrollRemainder = 0.0f;
        return true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z = false;
        updateSize(false);
        if (this.mEmulator == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        boolean reverseVideo = this.mEmulator.getReverseVideo();
        this.mTextRenderer.setReverseVideo(reverseVideo);
        canvas.drawRect(0.0f, 0.0f, width, height, reverseVideo ? this.mForegroundPaint : this.mBackgroundPaint);
        float f = (-this.mLeftColumn) * this.mCharacterWidth;
        float f2 = this.mCharacterHeight + this.mTopOfScreenMargin;
        int i4 = this.mTopRow + this.mRows;
        int cursorCol = this.mEmulator.getCursorCol();
        int cursorRow = this.mEmulator.getCursorRow();
        if (this.mCursorVisible && this.mEmulator.getShowCursor()) {
            z = true;
        }
        String str = this.mImeBuffer;
        int combiningAccent = this.mKeyListener.getCombiningAccent();
        if (combiningAccent != 0) {
            str = str + String.valueOf((char) combiningAccent);
        }
        String str2 = str;
        int cursorMode = this.mKeyListener.getCursorMode();
        int i5 = this.mTopRow;
        while (i5 < i4) {
            int i6 = (i5 == cursorRow && z) ? cursorCol : -1;
            int i7 = this.mSelY1;
            if (i5 < i7 || i5 > (i3 = this.mSelY2)) {
                i = -1;
                i2 = -1;
            } else {
                i = i5 == i7 ? this.mSelX1 : -1;
                i2 = i5 == i3 ? this.mSelX2 : this.mColumns;
            }
            this.mEmulator.getScreen().drawText(i5, canvas, f, f2, this.mTextRenderer, i6, i, i2, str2, cursorMode);
            f2 += this.mCharacterHeight;
            i5++;
            cursorRow = cursorRow;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        GestureDetector.OnGestureListener onGestureListener = this.mExtGestureListener;
        if (onGestureListener != null && onGestureListener.onFling(motionEvent, motionEvent2, f, f2)) {
            return true;
        }
        this.mScrollRemainder = 0.0f;
        if (isMouseTrackingActive()) {
            this.mMouseTrackingFlingRunner.fling(motionEvent, f, f2);
        } else {
            this.mScroller.fling(0, this.mTopRow, -((int) (f * 0.25f)), -((int) (f2 * 0.25f)), 0, 0, -this.mEmulator.getScreen().getActiveTranscriptRows(), 0);
            post(this.mFlingRunner);
        }
        return true;
    }

    public boolean onJumpTapDown(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.mTopRow = 0;
        invalidate();
        return true;
    }

    public boolean onJumpTapUp(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.mTopRow = -this.mEmulator.getScreen().getActiveTranscriptRows();
        invalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (handleControlKey(i, true) || handleFnKey(i, true)) {
            return true;
        }
        if (isSystemKey(i, keyEvent) && !isInterceptedSystemKey(i)) {
            return super.onKeyDown(i, keyEvent);
        }
        try {
            int combiningAccent = this.mKeyListener.getCombiningAccent();
            int cursorMode = this.mKeyListener.getCursorMode();
            this.mKeyListener.keyDown(i, keyEvent, getKeypadApplicationMode(), TermKeyListener.isEventFromToggleDevice(keyEvent));
            if (this.mKeyListener.getCombiningAccent() != combiningAccent || this.mKeyListener.getCursorMode() != cursorMode) {
                invalidate();
            }
        } catch (IOException unused) {
        }
        return true;
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (sTrapAltAndMeta) {
            boolean altSendsEsc = this.mKeyListener.getAltSendsEsc();
            boolean z = (keyEvent.getMetaState() & 2) != 0;
            boolean z2 = (keyEvent.getMetaState() & 65536) != 0;
            boolean z3 = i == 57 || i == 58;
            boolean isAltActive = this.mKeyListener.isAltActive();
            if (altSendsEsc && (z || z3 || isAltActive || z2)) {
                return keyEvent.getAction() == 0 ? onKeyDown(i, keyEvent) : onKeyUp(i, keyEvent);
            }
        }
        if (handleHardwareControlKey(i, keyEvent)) {
            return true;
        }
        return this.mKeyListener.isCtrlActive() ? keyEvent.getAction() == 0 ? onKeyDown(i, keyEvent) : onKeyUp(i, keyEvent) : super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (handleControlKey(i, false) || handleFnKey(i, false)) {
            return true;
        }
        if (isSystemKey(i, keyEvent) && !isInterceptedSystemKey(i)) {
            return super.onKeyUp(i, keyEvent);
        }
        this.mKeyListener.keyUp(i, keyEvent);
        clearSpecialKeyStatus();
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        showContextMenu();
    }

    public void onPause() {
        if (this.mCursorBlink != 0) {
            this.mHandler.removeCallbacks(this.mBlinkCursor);
        }
        TermKeyListener termKeyListener = this.mKeyListener;
        if (termKeyListener != null) {
            termKeyListener.onPause();
        }
    }

    public void onResume() {
        updateSize(false);
        if (this.mCursorBlink != 0) {
            this.mHandler.postDelayed(this.mBlinkCursor, 1000L);
        }
        TermKeyListener termKeyListener = this.mKeyListener;
        if (termKeyListener != null) {
            termKeyListener.onResume();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        GestureDetector.OnGestureListener onGestureListener = this.mExtGestureListener;
        if (onGestureListener != null && onGestureListener.onScroll(motionEvent, motionEvent2, f, f2)) {
            return true;
        }
        float f3 = f2 + this.mScrollRemainder;
        int i = (int) (f3 / this.mCharacterHeight);
        this.mScrollRemainder = f3 - (r4 * i);
        if (!isMouseTrackingActive()) {
            this.mTopRow = Math.min(0, Math.max(-this.mEmulator.getScreen().getActiveTranscriptRows(), this.mTopRow + i));
            invalidate();
            return true;
        }
        while (i > 0) {
            sendMouseEventCode(motionEvent, 65);
            i--;
        }
        while (i < 0) {
            sendMouseEventCode(motionEvent, 64);
            i++;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mExtGestureListener;
        if (onGestureListener != null) {
            onGestureListener.onShowPress(motionEvent);
        }
    }

    public void onSingleTapConfirmed(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mExtGestureListener;
        if (onGestureListener != null && onGestureListener.onSingleTapUp(motionEvent)) {
            return true;
        }
        if (isMouseTrackingActive()) {
            sendMouseEventCode(motionEvent, 0);
            sendMouseEventCode(motionEvent, 3);
        }
        requestFocus();
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mTermSession == null) {
            this.mDeferInit = true;
        } else if (this.mKnownSize) {
            updateSize(false);
        } else {
            this.mKnownSize = true;
            initialize();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mIsSelectingText ? onTouchEventWhileSelectingText(motionEvent) : this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void page(int i) {
        this.mTopRow = Math.min(0, Math.max(-this.mEmulator.getScreen().getActiveTranscriptRows(), this.mTopRow + (this.mRows * i)));
        invalidate();
    }

    public void pageHorizontal(int i) {
        this.mLeftColumn = Math.max(0, Math.min(this.mLeftColumn + i, this.mColumns - this.mVisibleColumns));
        invalidate();
    }

    public void sendControlKey() {
        this.mIsControlKeySent = true;
        this.mKeyListener.handleHardwareControlKey(true);
        invalidate();
    }

    public void sendFnKey() {
        this.mIsFnKeySent = true;
        this.mKeyListener.handleFnKey(true);
        invalidate();
    }

    public void setAltSendsEsc(boolean z) {
        this.mKeyListener.setAltSendsEsc(z);
    }

    public void setAutocomplete(boolean z) {
        this.mAutocomplete = z;
    }

    public void setBackKeyCharacter(int i) {
        this.mKeyListener.setBackKeyCharacter(i);
        this.mBackKeySendsCharacter = i != 0;
    }

    public void setBackspaceKey(String str) {
        this.mKeyListener.setBackspaceKey(str);
    }

    public void setColorScheme(ColorScheme colorScheme) {
        if (colorScheme == null) {
            this.mColorScheme = BaseTextRenderer.defaultColorScheme;
        } else {
            this.mColorScheme = colorScheme;
        }
        updateText();
    }

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setControlKeyCode(int i) {
        this.mControlKeyCode = i;
    }

    public void setDensity(DisplayMetrics displayMetrics) {
        if (this.mDensity == 0.0f) {
            this.mTextSize = (int) (this.mTextSize * displayMetrics.density);
        }
        this.mDensity = displayMetrics.density;
        this.mScaledDensity = displayMetrics.scaledDensity;
    }

    public void setExtGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.mExtGestureListener = onGestureListener;
    }

    public void setFnKeyCode(int i) {
        this.mFnKeyCode = i;
    }

    public void setMouseTracking(boolean z) {
        this.mMouseTracking = z;
    }

    public void setOnKeyPressListener(OnKeyPressListener onKeyPressListener) {
        this.mKeyPressListener = onKeyPressListener;
    }

    public void setTermType(String str) {
        this.mKeyListener.setTermType(str);
    }

    public void setTextSize(int i) {
        this.mTextSize = (int) (i * this.mDensity);
        updateText();
    }

    public void setUseCookedIME(boolean z) {
        this.mUseCookedIme = z;
    }

    public void toggleSelectingText(SelectingTextListener selectingTextListener) {
        if (selectingTextListener != null) {
            this.mSelectingTextListener = selectingTextListener;
        }
        if (this.mIsSelectingText) {
            this.mIsSelectingText = false;
            this.mSelX1 = -1;
            this.mSelY1 = -1;
            this.mSelX2 = -1;
            this.mSelY2 = -1;
            this.mSelectionStartX = -1;
            this.mSelectionStartY = -1;
            this.mSelectionFinishX = -1;
            this.mSelectionFinishY = -1;
            setVerticalScrollBarEnabled(true);
            SelectingTextListener selectingTextListener2 = this.mSelectingTextListener;
            if (selectingTextListener2 != null) {
                selectingTextListener2.onSelectionFinish();
                return;
            }
            return;
        }
        this.mIsSelectingText = true;
        this.mSelX1 = -1;
        this.mSelY1 = -1;
        this.mSelX2 = -1;
        this.mSelY2 = -1;
        this.mSelectionStartX = -1;
        this.mSelectionStartY = -1;
        this.mSelectionFinishX = -1;
        this.mSelectionFinishY = -1;
        setVerticalScrollBarEnabled(false);
        int[] iArr = this.colors;
        iArr[259] = iArr[1];
        SelectingTextListener selectingTextListener3 = this.mSelectingTextListener;
        if (selectingTextListener3 != null) {
            selectingTextListener3.onSelectionStart();
        }
    }

    public void updateSize(boolean z) {
        this.mLinkLayer.clear();
        if (this.mKnownSize) {
            int width = getWidth();
            int height = getHeight();
            if (!z && width == this.mVisibleWidth && height == this.mVisibleHeight) {
                return;
            }
            this.mVisibleWidth = width;
            this.mVisibleHeight = height;
            updateSize(width, height);
        }
    }
}
