package com.sonelli.juicessh.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class FontAwesomeTextView extends AppCompatTextView {
    public FontAwesomeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5681a(context);
    }

    /* renamed from: a */
    public void m5681a(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf"));
    }
}
