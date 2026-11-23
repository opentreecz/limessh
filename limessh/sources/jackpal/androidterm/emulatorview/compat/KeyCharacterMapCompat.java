package jackpal.androidterm.emulatorview.compat;

import android.view.KeyCharacterMap;

/* loaded from: classes.dex */
public abstract class KeyCharacterMapCompat {
    public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
    public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;

    /* loaded from: classes.dex */
    public static class KeyCharacterMapApi11OrLater extends KeyCharacterMapCompat {
        private KeyCharacterMap mMap;

        public KeyCharacterMapApi11OrLater(Object obj) {
            this.mMap = (KeyCharacterMap) obj;
        }

        @Override // jackpal.androidterm.emulatorview.compat.KeyCharacterMapCompat
        public int getModifierBehaviour() {
            return this.mMap.getModifierBehavior();
        }
    }

    public static KeyCharacterMapCompat wrap(Object obj) {
        if (obj == null || AndroidCompat.SDK < 11) {
            return null;
        }
        return new KeyCharacterMapApi11OrLater(obj);
    }

    public abstract int getModifierBehaviour();
}
