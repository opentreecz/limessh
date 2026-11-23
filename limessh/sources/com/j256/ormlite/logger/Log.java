package com.j256.ormlite.logger;

/* loaded from: classes.dex */
public interface Log {

    /* loaded from: classes.dex */
    public enum Level {
        TRACE(1),
        DEBUG(2),
        INFO(3),
        WARNING(4),
        ERROR(5),
        FATAL(6);

        private int level;

        Level(int i) {
            this.level = i;
        }

        public boolean isEnabled(Level level) {
            return this.level <= level.level;
        }
    }

    boolean isLevelEnabled(Level level);

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);
}
