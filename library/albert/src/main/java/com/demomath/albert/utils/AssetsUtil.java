package com.demomath.albert.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssetsUtil {
    /**
     * 获取assets目录下的图片
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return Bitmap图片
     */
    public static Bitmap getImageFromAssetsFile(Context context, String fileName) {
        Bitmap bitmap = null;
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(fileName);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    /**
     * 获取文件内容从assets
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return js
     */
    public static String getJsFromAssets(Context context, String fileName) {
        InputStreamReader inputReader = null;
        BufferedReader bufReader = null;
        StringBuilder Result = new StringBuilder("");
        try {
            inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            bufReader = new BufferedReader(inputReader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                Result.append(line);
            }
            bufReader.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.toString();
    }
}
