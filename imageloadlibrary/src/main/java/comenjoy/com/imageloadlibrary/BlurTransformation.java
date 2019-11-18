package comenjoy.com.imageloadlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.RenderScript;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * Created by android-03 on 2017/11/29.
 */

public class BlurTransformation extends BitmapTransformation {

    private RenderScript rs;

    public BlurTransformation(Context context) {
        rs = RenderScript.create(context);
    }

    public BlurTransformation(Context context, int radius) {
        rs = RenderScript.create(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
//        Bitmap blurredBitmap = toTransform.copy(Bitmap.Config.ARGB_8888, true);
        // Allocate memory for Renderscript to work with
//        Allocation input = Allocation.createFromBitmap(rs, blurredBitmap, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SHARED);
//        Allocation output = Allocation.createTyped(rs, input.getType());
//
//        // Load up an instance of the specific script that we want to use.
//        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
//        // Set the blur radius
//        script.setRadius(25f);
//        script.setInput(input);
//        // Start the ScriptIntrinisicBlur
//        script.forEach(output);
//
//        // Copy the output to the blurred bitmap
//        output.copyTo(blurredBitmap);
        Bitmap blurredBitmap = toTransform.copy(Bitmap.Config.RGB_565, true);
        return ImageUtils.blur(blurredBitmap, 100);
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("blur transformation".getBytes());
    }

}