package com.xpy.administrator.probityeducation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/11/20.
 */

public class ImageUtils {
    /**
     * 创建缩略图
     * @param context
     * @param imageId 图片id
     * @return
     */
    public static Bitmap getImageThumbnail(Context context,int imageId){
        //通过openRawResource获取一个InputStream对象
        InputStream input  = context.getResources().openRawResource(imageId);
        //通过InputStream创建BitmapDrawable对象
        BitmapDrawable image = new BitmapDrawable(input);
        //通过BitmapDrawable对象获取Bitmap对象
        Bitmap bitmap = image.getBitmap();
        //利用Bitmap对象创建缩略图
        bitmap = ThumbnailUtils.extractThumbnail(bitmap,60,60);
        return bitmap;
    }
}
