package com.sonelli;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* compiled from: PicassoDrawable.java */
/* loaded from: classes.dex */
public final class sl0 extends BitmapDrawable {

    /* renamed from: h */
    public static final Paint f6503h = new Paint();

    /* renamed from: a */
    public final boolean f6504a;

    /* renamed from: b */
    public final float f6505b;

    /* renamed from: c */
    public final Picasso.EnumC2454d f6506c;

    /* renamed from: d */
    public Drawable f6507d;

    /* renamed from: e */
    public long f6508e;

    /* renamed from: f */
    public boolean f6509f;

    /* renamed from: g */
    public int f6510g;

    public sl0(Context context, Bitmap bitmap, Drawable drawable, Picasso.EnumC2454d enumC2454d, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f6510g = 255;
        this.f6504a = z2;
        this.f6505b = context.getResources().getDisplayMetrics().density;
        this.f6506c = enumC2454d;
        if ((enumC2454d == Picasso.EnumC2454d.MEMORY || z) ? false : true) {
            this.f6507d = drawable;
            this.f6509f = true;
            this.f6508e = SystemClock.uptimeMillis();
        }
    }

    /* renamed from: b */
    public static Path m8465b(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }

    /* renamed from: c */
    public static void m8466c(ImageView imageView, Context context, Bitmap bitmap, Picasso.EnumC2454d enumC2454d, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new sl0(context, bitmap, drawable, enumC2454d, z, z2));
    }

    /* renamed from: d */
    public static void m8467d(ImageView imageView, int i, Drawable drawable) {
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageDrawable(drawable);
        }
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    /* renamed from: a */
    public final void m8468a(Canvas canvas) {
        Paint paint = f6503h;
        paint.setColor(-1);
        canvas.drawPath(m8465b(new Point(0, 0), (int) (this.f6505b * 16.0f)), paint);
        paint.setColor(this.f6506c.f8649O);
        canvas.drawPath(m8465b(new Point(0, 0), (int) (this.f6505b * 15.0f)), paint);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f6509f) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f6508e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f6509f = false;
                this.f6507d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f6507d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f6510g * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f6510g);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f6504a) {
            m8468a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6507d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6510g = i;
        Drawable drawable = this.f6507d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f6507d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
