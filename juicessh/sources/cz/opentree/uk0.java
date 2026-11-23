package cz.opentree;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.Transformation;

/* compiled from: CircleTransform.java */
/* loaded from: classes.dex */
public class uk0 implements Transformation {
    @Override // com.squareup.picasso.Transformation
    /* renamed from: a */
    public Bitmap mo8916a(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f = min / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    @Override // com.squareup.picasso.Transformation
    /* renamed from: b */
    public String mo8917b() {
        return "circle";
    }
}
