package comenjoy.com.imageloadlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;



/**
 * @author twp
 * @date 2017/6/28
 */

public class GlideUtil {

    private RequestOptions options = null;

    private volatile static GlideUtil mSingleInstance = null;

    private GlideUtil() {
        options = new RequestOptions();
        options.priority(Priority.HIGH)//高优先级
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)//保存最终图片
                .skipMemoryCache(true)//跳过内存缓存
                .format(DecodeFormat.PREFER_RGB_565);
    }

    public static GlideUtil getInstance() {
        if (mSingleInstance == null) {
            synchronized (GlideUtil.class) {
                if (mSingleInstance == null) {
                    mSingleInstance = new GlideUtil();
                }
            }
        }
        return mSingleInstance;

    }


//    public GlideUtil() {
////        DiskCacheStrategy有五个常量：
////        DiskCacheStrategy.ALL 使用DATA和RESOURCE缓存远程数据，仅使用RESOURCE来缓存本地数据。
////        DiskCacheStrategy.NONE 不使用磁盘缓存
////        DiskCacheStrategy.DATA 在资源解码前就将原始数据写入磁盘缓存
////        DiskCacheStrategy.RESOURCE 在资源解码后将数据写入磁盘缓存，即经过缩放等转换后的图片资源。
////        DiskCacheStrategy.AUTOMATIC 根据原始图片数据和资源编码策略来自动选择磁盘缓存策略。
//
//    }
//
//    private static class ImageHolder {
//        private static final GlideUtil INSTANCE = new GlideUtil();
//    }
//
//    public static final GlideUtil getInstance() {
//        return GlideUtil.ImageHolder.INSTANCE;
//    }

    public void loadImage(Context context, String url, int defaultImgId, int animatDuration, ImageView imageView) {
        options.placeholder(defaultImgId)
                .error(defaultImgId)
                .fallback(defaultImgId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(animatDuration))
//                .placeholder(defaultImgId)//加载中显示的图片
//                .error(defaultImgId)//加载失败时显示的图片
//                .skipMemoryCache(false)//跳过内存缓存
//                .priority(Priority.HIGH)//高优先级
//                .crossFade(animatDuration)//淡入显示,注意:如果设置了这个,则必须要去掉asBitmap
//                .diskCacheStrategy(DiskCacheStrategy.RESULT)//保存最终图片
//                        .thumbnail(0.1f)//10%的原图大小
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        spinner.setVisibility(View.GONE);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        spinner.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
                .into(imageView);
    }

    public void loadImage(Context context, String url, int defaultImgId, ImageView imageView) {
        options.placeholder(defaultImgId)
                .error(defaultImgId)
                .fallback(defaultImgId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public void loadImage(Context context, Uri uri, int defaultImgId, ImageView imageView) {
        options.placeholder(defaultImgId)
                .error(defaultImgId)
                .fallback(defaultImgId);
        Glide.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }

    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(0))
                .into(imageView);
    }

    public void loadImage(Context context, Uri uri, ImageView imageView) {
        Glide.with(context)
                .load(uri)
                .transition(new DrawableTransitionOptions().crossFade(0))
                .into(imageView);
    }

    public void loadImage(Context context, Bitmap bitmap, ImageView imageView) {
        Glide.with(context)
                .load(bitmap)
                .transition(new DrawableTransitionOptions().crossFade(0))
                .into(imageView);
    }

    /**
     * @param context
     * @param resId
     * @param imageView
     */
    public void loadImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .transition(new DrawableTransitionOptions().crossFade(0))
                .into(imageView);
    }

    public void loadImage(Context context, String url, int defaultImgId, int animatDuration, ImageView imageView, RequestListener listener) {
        options.placeholder(defaultImgId)
                .error(defaultImgId)
                .fallback(defaultImgId);
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(animatDuration))
                .listener(listener)
                .into(imageView);
    }

    public void loadBigImage(Context context, String url, int defaultImgId, int animatDuration, ImageView imageView, RequestListener listener) {
        options.placeholder(-1)
                .error(defaultImgId)
                .fallback(-1);
//        GlideApp.with(context).load(url).
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(animatDuration))
                .listener(listener)
                .into(imageView);
    }

    public void loadImage(Context context, String url, int animatDuration, ImageView imageView, RequestListener listener) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(animatDuration))
                .listener(listener)
                .into(imageView);
    }

    public void loadRoudImage(Context context, String url, int defaultImgId, ImageView imageView, int dp) {
        RequestOptions myOptions = new RequestOptions()
                .placeholder(defaultImgId)
                .error(defaultImgId)
                .fallback(defaultImgId)
                .transform(new GlideRoundTransform(context, dp));
        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadRoudImage(Context context, int url, ImageView imageView, int dp) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideRoundTransform(context, dp));
        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);

    }

    public void loadRoudImage(Context context, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideRoundTransform(context, 1));

        Glide.with(context)
                .load(defaultImgId)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, String url, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .transform(new GlideCircleTransform(context));

        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, byte[] bytes, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .transform(new GlideCircleTransform(context));

        Glide.with(context)
                .load(bytes)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, String url, ImageView imageView, boolean isBoradWidth) {
        RequestOptions myOptions;
        if (isBoradWidth) {
            myOptions = new RequestOptions()
                    .skipMemoryCache(true)//跳过内存缓存
                    .transform(new GlideCircleTransform(context));
        } else {
            myOptions = new RequestOptions()
                    .skipMemoryCache(true)//跳过内存缓存
                    .transform(new GlideCircleTransform(context, 0, 255, 255, context.getResources().getColor(R.color.stroke_color)));
        }

        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, String url, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .error(defaultImgId)
                .transform(new GlideCircleTransform(context));

        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .transform(new GlideCircleTransform(context));

        Glide.with(context)
                .load(defaultImgId)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, int borderColor, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideCircleTransform(context, 0, 255, 255, borderColor));

        Glide.with(context)
                .load(defaultImgId)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, int borderColor, String url, int defaultImgId, ImageView imageView) {
        if (!TextUtils.isEmpty(url)) {
            RequestOptions myOptions = new RequestOptions()
                    .transform(new GlideCircleTransform(context, 0, 255, 255, borderColor))
                    .placeholder(defaultImgId)
                    .error(defaultImgId)
                    .fallback(defaultImgId);

            Glide.with(context)
                    .load(url)
                    .apply(myOptions)
                    .into(imageView);
        } else {
            loadCircleImage(context, borderColor, defaultImgId, imageView);
        }

    }

    public void loadCircleImage(Context context, int borderWidth, int borderAlpha, int insideAlpha, int borderColor, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideCircleTransform(context, borderWidth, borderAlpha, insideAlpha, borderColor));

        Glide.with(context)
                .load(defaultImgId)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, int borderColor, int insideAlpha, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideCircleTransform(context, borderColor, insideAlpha));

        Glide.with(context)
                .load(defaultImgId)
                .apply(myOptions)
                .into(imageView);
    }


    public void loadBlurImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(context)))
                .into(imageView);
    }


    public void clearCache(Context context) {
        // TODO clear image cache
    }


    public void loadCircleImage(Context context, Bitmap bm, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .transform(new GlideCircleTransform(context));

        Glide.with(context)
                .load(bm)
                .apply(myOptions)
                .into(imageView);
    }

    public void loadCircleImage(Context context, Uri uri, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .transform(new GlideCircleTransform(context));
        Glide.with(context)
                .load(uri)
                .apply(myOptions)
                .into(imageView);
    }

    //    public void loadCircleImage(Context context, Uri uri, int defaultImgId,ImageView imageView) {
//        RequestOptions myOptions = new RequestOptions()
//                .skipMemoryCache(true)//跳过内存缓存
//                .placeholder(defaultImgId)
//                .error(defaultImgId)
//                .transform(new GlideCircleTransform(context));
//        Glide.with(context)
//                .load(uri)
//                .apply(myOptions)
//                .into(imageView);
//    }
    public void loadCircleImage(Context context, Uri uri, int defaultImgId, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .skipMemoryCache(true)//跳过内存缓存
                .placeholder(defaultImgId)
                .error(defaultImgId)
                .transform(new GlideCircleTransform(context));
        Glide.with(context)
                .load(uri)
                .apply(myOptions)
                .into(imageView);
    }

//    /**
//     * 加载类似微信朋友圈预览照片的效果
//     *
//     * @param context
//     * @param url
//     */
//    public void loadPreviewImage(Context context, String url) {
//        ImagePreview
//                .getInstance()
//                // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
//                .setContext(context)
//                // 设置从第几张开始看（索引从0开始）
//                .setIndex(0)
//                .setShowDownButton(false)
//                //=================================================================================================
//                // 有三种设置数据集合的方式，根据自己的需求进行三选一：
//                // 1：第一步生成的imageInfo List
////                .setImageInfoList(imageInfoList)
//                // 2：直接传url List
//                //.setImageList(List<String> imageList)
//                // 3：只有一张图片的情况，可以直接传入这张图片的url
//                .setImage(url)
//                //=================================================================================================
//                // 开启预览
//                .start();
//
//
//    }
}
