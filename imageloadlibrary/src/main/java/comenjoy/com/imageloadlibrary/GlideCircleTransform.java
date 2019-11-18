package comenjoy.com.imageloadlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.security.MessageDigest;

/**
 * Created by android-03 on 2017/11/28.
 */

public class GlideCircleTransform extends BitmapTransformation {

    private float mBorderWidth;
    private int mBorderColor;
    private int mBorderAlpha;
    private int red;
    private int green;
    private int blue;
    private int mInsideAlpha;

    public GlideCircleTransform(Context context) {
        this(context, 0, 255, 255, context.getResources().getColor(R.color.stroke_color));
    }

    public GlideCircleTransform(Context context,int borderColor) {
        this(context, 4, 255, 255, borderColor);
    }

    public GlideCircleTransform(Context context,int borderColor, int insideAlpha) {
        this(context, 4, 255, insideAlpha, borderColor);


    }
    public GlideCircleTransform(Context context, int borderAlpha,int insideAlpha, int borderColor){
        this(context, 4, borderAlpha, insideAlpha, borderColor);
    }

    public GlideCircleTransform(Context context, int borderWidth,int borderAlpha,int insideAlpha, int borderColor) {
        mBorderWidth = Resources.getSystem().getDisplayMetrics().density * borderWidth;
        mBorderColor = borderColor;
        if(borderAlpha == 255){
            mBorderAlpha = (borderColor & 0xff000000) >>> 24;
        }else{
            mBorderAlpha = borderAlpha;
        }
        mInsideAlpha = insideAlpha;
        red = (borderColor & 0xff0000) >> 16;
        green = (borderColor & 0x00ff00) >> 8;
        blue = (borderColor & 0x0000ff);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = TransformationUtils.centerCrop(pool, toTransform, outWidth, outHeight);
        return roundCrop(pool, bitmap);
    }

    private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setAlpha(mInsideAlpha);
        float r = size / 2f;
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        canvas.drawCircle(r, r, r, paint);
        if(mBorderWidth != 0){
            Paint borderPaint = new Paint();
            borderPaint.setDither(true);
            borderPaint.setAntiAlias(true);
            borderPaint.setARGB(mBorderAlpha,red,green,blue);
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setStrokeWidth(mBorderWidth);
            float borderRadius = r - mBorderWidth/2;
            canvas.drawCircle(r, r, borderRadius, borderPaint);
        }
        return result;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }

}