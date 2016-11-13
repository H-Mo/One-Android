package in.leob.one.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import in.leob.one.listener.OnImageDownloadListener;

/**
 * @author H-Mo
 * @time 16/11/13  10:53
 * @desc ${TODD}
 */
public class ImageUtil {

    public static void saveImage(Context context, String url, OnImageDownloadListener callBack){
        try {
            Bitmap bitmap = Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
            // 保存图片的方法
            saveImageToGallery(context,bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            callBack.onDownLoadSuccess();
        }
    }
    public static void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
        String fileName = "一个";
        File appDir = new File(file ,fileName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        fileName = System.currentTimeMillis() + ".jpg";
        File currentFile = new File(appDir, fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(currentFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 其次把文件插入到系统图库
        //        try {
        //            MediaStore.Images.Media.insertImage(context.getContentResolver(),
        //                    currentFile.getAbsolutePath(), fileName, null);
        //        } catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //        }

        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(currentFile.getPath()))));
    }
}
