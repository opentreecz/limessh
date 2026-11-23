package jackpal.androidterm.emulatorview;

/* loaded from: classes.dex */
public class ColorScheme {
    private static final int sDefaultCursorBackColor = -8355712;
    private int backColor;
    private int cursorBackColor;
    private int cursorForeColor;
    private int foreColor;

    public ColorScheme(int i, int i2) {
        this.foreColor = i;
        this.backColor = i2;
        setDefaultCursorColors();
    }

    public ColorScheme(int i, int i2, int i3, int i4) {
        this.foreColor = i;
        this.backColor = i2;
        this.cursorForeColor = i3;
        this.cursorBackColor = i4;
    }

    public ColorScheme(int[] iArr) {
        int length = iArr.length;
        if (length != 2 && length != 4) {
            throw new IllegalArgumentException();
        }
        this.foreColor = iArr[0];
        this.backColor = iArr[1];
        if (length == 2) {
            setDefaultCursorColors();
        } else {
            this.cursorForeColor = iArr[2];
            this.cursorBackColor = iArr[3];
        }
    }

    private static int channelDistance(int i, int i2, int i3) {
        return Math.abs(getChannel(i, i3) - getChannel(i2, i3));
    }

    private static int distance(int i, int i2) {
        return (channelDistance(i, i2, 0) * 3) + (channelDistance(i, i2, 1) * 5) + channelDistance(i, i2, 2);
    }

    private static int getChannel(int i, int i2) {
        return (i >> ((2 - i2) * 8)) & 255;
    }

    private void setDefaultCursorColors() {
        this.cursorBackColor = sDefaultCursorBackColor;
        if (distance(this.foreColor, sDefaultCursorBackColor) * 2 >= distance(this.backColor, this.cursorBackColor)) {
            this.cursorForeColor = this.foreColor;
        } else {
            this.cursorForeColor = this.backColor;
        }
    }

    public int getBackColor() {
        return this.backColor;
    }

    public int getCursorBackColor() {
        return this.cursorBackColor;
    }

    public int getCursorForeColor() {
        return this.cursorForeColor;
    }

    public int getForeColor() {
        return this.foreColor;
    }
}
