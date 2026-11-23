package com.sun.jna.ptr;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: classes.dex */
public class DoubleByReference extends ByReference {
    public DoubleByReference() {
        this(ShadowDrawableWrapper.COS_45);
    }

    public DoubleByReference(double d) {
        super(8);
        setValue(d);
    }

    public double getValue() {
        return getPointer().getDouble(0L);
    }

    public void setValue(double d) {
        getPointer().setDouble(0L, d);
    }
}
