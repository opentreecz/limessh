package jackpal.androidterm.emulatorview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TermSession {
    private static final int FINISH = 3;
    private static final int NEW_INPUT = 1;
    private static final int NEW_OUTPUT = 2;
    private static final int TRANSCRIPT_ROWS = 10000;
    private ByteQueue mByteQueue;
    private boolean mDefaultUTF8Mode;
    private TerminalEmulator mEmulator;
    private FinishCallback mFinishCallback;
    private TermKeyListener mKeyListener;
    private UpdateCallback mNotify;
    private Thread mReaderThread;
    private byte[] mReceiveBuffer;
    private InputStream mTermIn;
    private OutputStream mTermOut;
    private String mTitle;
    private UpdateCallback mTitleChangedListener;
    private TranscriptScreen mTranscriptScreen;
    private CharsetEncoder mUTF8Encoder;
    private ByteQueue mWriteQueue;
    private Handler mWriterHandler;
    private Thread mWriterThread;
    private ColorScheme mColorScheme = BaseTextRenderer.defaultColorScheme;
    private boolean mIsRunning = false;
    private Handler mMsgHandler = new Handler() { // from class: jackpal.androidterm.emulatorview.TermSession.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (TermSession.this.mIsRunning && message.what == 1) {
                TermSession.this.readFromProcess();
            }
        }
    };
    private CharBuffer mWriteCharBuffer = CharBuffer.allocate(2);
    private ByteBuffer mWriteByteBuffer = ByteBuffer.allocate(4);

    /* loaded from: classes.dex */
    public interface FinishCallback {
        void onSessionFinish(TermSession termSession);
    }

    /* loaded from: classes.dex */
    public interface OnBellListener {
        void onBellRecieved();
    }

    public TermSession() {
        CharsetEncoder newEncoder = StandardCharsets.UTF_8.newEncoder();
        this.mUTF8Encoder = newEncoder;
        newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.mUTF8Encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.mReceiveBuffer = new byte[4096];
        this.mByteQueue = new ByteQueue(4096);
        Thread thread = new Thread() { // from class: jackpal.androidterm.emulatorview.TermSession.2
            private byte[] mBuffer = new byte[4096];

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        int read = TermSession.this.mTermIn.read(this.mBuffer);
                        if (read == -1) {
                            return;
                        }
                        int i = 0;
                        while (read > 0) {
                            int write = TermSession.this.mByteQueue.write(this.mBuffer, i, read);
                            i += write;
                            read -= write;
                            TermSession.this.mMsgHandler.sendMessage(TermSession.this.mMsgHandler.obtainMessage(1));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        };
        this.mReaderThread = thread;
        thread.setName("TermSession input reader");
        this.mWriteQueue = new ByteQueue(4096);
        Thread thread2 = new Thread() { // from class: jackpal.androidterm.emulatorview.TermSession.3
            private byte[] mBuffer = new byte[4096];

            /* JADX INFO: Access modifiers changed from: private */
            public void writeToOutput() {
                ByteQueue byteQueue = TermSession.this.mWriteQueue;
                byte[] bArr = this.mBuffer;
                OutputStream outputStream = TermSession.this.mTermOut;
                int min = Math.min(byteQueue.getBytesAvailable(), bArr.length);
                if (min == 0) {
                    return;
                }
                try {
                    byteQueue.read(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    outputStream.flush();
                } catch (IOException | InterruptedException unused) {
                }
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Looper.prepare();
                TermSession.this.mWriterHandler = new Handler() { // from class: jackpal.androidterm.emulatorview.TermSession.3.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 2) {
                            writeToOutput();
                        } else if (i == 3) {
                            Looper.myLooper().quit();
                        }
                    }
                };
                writeToOutput();
                Looper.loop();
            }
        };
        this.mWriterThread = thread2;
        thread2.setName("TermSession output writer");
    }

    private void notifyNewOutput() {
        Handler handler = this.mWriterHandler;
        if (handler == null) {
            return;
        }
        handler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromProcess() {
        try {
            processInput(this.mReceiveBuffer, 0, this.mByteQueue.read(this.mReceiveBuffer, 0, Math.min(this.mByteQueue.getBytesAvailable(), this.mReceiveBuffer.length)));
            notifyUpdate();
        } catch (InterruptedException unused) {
        }
    }

    public final void appendToEmulator(byte[] bArr, int i, int i2) {
        this.mEmulator.append(bArr, i, i2);
    }

    public void finish() {
        this.mIsRunning = false;
        TerminalEmulator terminalEmulator = this.mEmulator;
        if (terminalEmulator != null) {
            terminalEmulator.finish();
        }
        TranscriptScreen transcriptScreen = this.mTranscriptScreen;
        if (transcriptScreen != null) {
            transcriptScreen.finish();
        }
        Handler handler = this.mWriterHandler;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
        try {
            this.mTermIn.close();
            this.mTermOut.close();
        } catch (IOException | NullPointerException unused) {
        }
        FinishCallback finishCallback = this.mFinishCallback;
        if (finishCallback != null) {
            finishCallback.onSessionFinish(this);
        }
    }

    public TerminalEmulator getEmulator() {
        return this.mEmulator;
    }

    public TermKeyListener getKeyListener() {
        return this.mKeyListener;
    }

    public OnBellListener getOnBellListener() {
        if (getEmulator() != null) {
            return getEmulator().getOnBellListener();
        }
        return null;
    }

    public InputStream getTermIn() {
        return this.mTermIn;
    }

    public OutputStream getTermOut() {
        return this.mTermOut;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public TranscriptScreen getTranscriptScreen() {
        return this.mTranscriptScreen;
    }

    public String getTranscriptText() {
        TranscriptScreen transcriptScreen = this.mTranscriptScreen;
        if (transcriptScreen == null) {
            return null;
        }
        return transcriptScreen.getTranscriptText();
    }

    public boolean getUTF8Mode() {
        TerminalEmulator terminalEmulator = this.mEmulator;
        return terminalEmulator == null ? this.mDefaultUTF8Mode : terminalEmulator.getUTF8Mode();
    }

    public void initializeEmulator(int i, int i2) {
        this.mTranscriptScreen = new TranscriptScreen(i, TRANSCRIPT_ROWS, i2, this.mColorScheme);
        TerminalEmulator terminalEmulator = new TerminalEmulator(this, this.mTranscriptScreen, i, i2, this.mColorScheme);
        this.mEmulator = terminalEmulator;
        terminalEmulator.setDefaultUTF8Mode(this.mDefaultUTF8Mode);
        this.mEmulator.setKeyListener(this.mKeyListener);
        this.mIsRunning = true;
        this.mReaderThread.start();
        this.mWriterThread.start();
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void notifyTitleChanged() {
        UpdateCallback updateCallback = this.mTitleChangedListener;
        if (updateCallback != null) {
            updateCallback.onUpdate();
        }
    }

    public void notifyUpdate() {
        UpdateCallback updateCallback = this.mNotify;
        if (updateCallback != null) {
            updateCallback.onUpdate();
        }
    }

    public void processInput(byte[] bArr, int i, int i2) {
        this.mEmulator.append(bArr, i, i2);
    }

    public void reset() {
        this.mEmulator.reset();
        notifyUpdate();
    }

    public void setColorScheme(ColorScheme colorScheme) {
        if (colorScheme == null) {
            colorScheme = BaseTextRenderer.defaultColorScheme;
        }
        this.mColorScheme = colorScheme;
        TerminalEmulator terminalEmulator = this.mEmulator;
        if (terminalEmulator == null) {
            return;
        }
        terminalEmulator.setColorScheme(colorScheme);
    }

    public void setDefaultUTF8Mode(boolean z) {
        this.mDefaultUTF8Mode = z;
        TerminalEmulator terminalEmulator = this.mEmulator;
        if (terminalEmulator == null) {
            return;
        }
        terminalEmulator.setDefaultUTF8Mode(z);
    }

    public void setFinishCallback(FinishCallback finishCallback) {
        this.mFinishCallback = finishCallback;
    }

    public void setKeyListener(TermKeyListener termKeyListener) {
        this.mKeyListener = termKeyListener;
    }

    public void setOnBellListener(OnBellListener onBellListener) {
        if (getEmulator() != null) {
            getEmulator().setOnBellListener(onBellListener);
        }
    }

    public void setTermIn(InputStream inputStream) {
        this.mTermIn = inputStream;
    }

    public void setTermOut(OutputStream outputStream) {
        this.mTermOut = outputStream;
    }

    public void setTitle(String str) {
        this.mTitle = str;
        notifyTitleChanged();
    }

    public void setTitleChangedListener(UpdateCallback updateCallback) {
        this.mTitleChangedListener = updateCallback;
    }

    public void setUTF8ModeUpdateCallback(UpdateCallback updateCallback) {
        TerminalEmulator terminalEmulator = this.mEmulator;
        if (terminalEmulator != null) {
            terminalEmulator.setUTF8ModeUpdateCallback(updateCallback);
        }
    }

    public void setUpdateCallback(UpdateCallback updateCallback) {
        this.mNotify = updateCallback;
    }

    public void updateSize(int i, int i2) {
        TerminalEmulator terminalEmulator = this.mEmulator;
        if (terminalEmulator == null) {
            initializeEmulator(i, i2);
        } else {
            terminalEmulator.updateSize(i, i2);
        }
    }

    public void write(int i) {
        CharBuffer charBuffer = this.mWriteCharBuffer;
        ByteBuffer byteBuffer = this.mWriteByteBuffer;
        CharsetEncoder charsetEncoder = this.mUTF8Encoder;
        charBuffer.clear();
        byteBuffer.clear();
        Character.toChars(i, charBuffer.array(), 0);
        charsetEncoder.reset();
        charsetEncoder.encode(charBuffer, byteBuffer, true);
        charsetEncoder.flush(byteBuffer);
        write(byteBuffer.array(), 0, byteBuffer.position() - 1);
    }

    public void write(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        write(bytes, 0, bytes.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            try {
                int write = this.mWriteQueue.write(bArr, i, i2);
                i += write;
                i2 -= write;
                notifyNewOutput();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
