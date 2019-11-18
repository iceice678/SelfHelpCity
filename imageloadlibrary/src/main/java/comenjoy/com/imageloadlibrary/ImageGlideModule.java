package comenjoy.com.imageloadlibrary;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

/**
 * 所以你知道要创建一个额外的类去定制 Glide。
 * 下一步是要全局的去声明这个类，让 Glide 知道它应该在哪里被加载和使用。
 * Glide 会扫描 AndroidManifest.xml 为 Glide module 的 meta 声明。
 * 因此，你必须在 AndroidManifest.xml 的 &lt;application&gt; 标签内去声明这个SimpleGlideModule。
 *
 * @author mChenys
 * @date 2016/6/10
 */
@GlideModule
public class ImageGlideModule extends AppGlideModule {
    public static DiskCache cache;

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
//        super.applyOptions(context, builder);
        // 在 Android 中有两个主要的方法对图片进行解码：ARGB8888 和 RGB565。前者为每个像素使用了 4 个字节，
        // 后者仅为每个像素使用了 2 个字节。ARGB8888 的优势是图像质量更高以及能存储一个 alpha 通道。
        // Picasso 使用 ARGB8888，Glide 默认使用低质量的 RGB565。
        // 对于 Glide 使用者来说：你使用 Glide module 方法去改变解码规则。
        //设置缓存目录
        File cacheDir = context.getExternalCacheDir();
        cache = DiskLruCacheWrapper.get(cacheDir, 1024 * 1024 * 1024);// 500M
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                return cache;
            }
        });
        //设置memory和Bitmap池的大小
        MemorySizeCalculator.Builder calculator = new MemorySizeCalculator.Builder(context);
//        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.build().getBitmapPoolSize();

//        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.5 * defaultBitmapPoolSize);

//        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
        super.applyOptions(context, builder);
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
//        registry.append(String.class, InputStream.class,new CustomBaseGlideUrlLoader.Factory());
//        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(ProgressManager.getOkHttpClient()));
    }

//    public static DiskCache cache;
//
//    @Override
//    public void applyOptions(Context context, GlideBuilder builder) {
//// 在 Android 中有两个主要的方法对图片进行解码：ARGB8888 和 RGB565。前者为每个像素使用了 4 个字节，
//        // 后者仅为每个像素使用了 2 个字节。ARGB8888 的优势是图像质量更高以及能存储一个 alpha 通道。
//        // Picasso 使用 ARGB8888，Glide 默认使用低质量的 RGB565。
//        // 对于 Glide 使用者来说：你使用 Glide module 方法去改变解码规则。
//        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
//        //设置缓存目录
//        File cacheDir = NasApplication.getInstance().getExternalCacheDir();
//
//        cache = DiskLruCacheWrapper.get(cacheDir, 80 * 1024 * 1024);// 80M
//        builder.setDiskCache(new DiskCache.Factory() {
//            @Override
//            public DiskCache build() {
//                return cache;
//            }
//        });
//        //设置memory和Bitmap池的大小
//        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
////        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
//        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
//
////        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
//        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
//
////        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
//        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
//    }
}
