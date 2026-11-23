package jackpal.androidterm.emulatorview;

import androidx.core.app.FrameMetricsAggregator;

/* loaded from: classes.dex */
public final class TextStyle {
    public static final int ciBackground = 257;
    public static final int ciColorLength = 260;
    public static final int ciCursorBackground = 259;
    public static final int ciCursorForeground = 258;
    public static final int ciForeground = 256;
    public static final int fxBlink = 8;
    public static final int fxBold = 1;
    public static final int fxInverse = 16;
    public static final int fxInvisible = 32;
    public static final int fxItalic = 2;
    public static final int fxNormal = 0;
    public static final int fxUnderline = 4;
    public static final int kNormalTextStyle = encode(256, 257, 0);

    public static int decodeBackColor(int i) {
        return i & FrameMetricsAggregator.EVERY_DURATION;
    }

    public static int decodeEffect(int i) {
        return (i >> 18) & 63;
    }

    public static int decodeForeColor(int i) {
        return (i >> 9) & FrameMetricsAggregator.EVERY_DURATION;
    }

    public static int encode(int i, int i2, int i3) {
        return ((i & FrameMetricsAggregator.EVERY_DURATION) << 9) | ((i3 & 63) << 18) | (i2 & FrameMetricsAggregator.EVERY_DURATION);
    }
}
