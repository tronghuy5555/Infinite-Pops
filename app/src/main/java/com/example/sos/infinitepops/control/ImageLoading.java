package com.example.sos.infinitepops.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * ImageLoading
 *
 * @author SOS
 * @since 08/09/2018.
 */
public class ImageLoading {


    public static void load(final String url, final ImageView imageView) {
        imageView.setImageBitmap(null);
        AsyncTask<String,Void,Bitmap> asyncTask = new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    String url = strings[0];
                    URL urlImage = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlImage.openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    InputStream input = httpURLConnection.getInputStream();
                    return BitmapFactory.decodeStream(input);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                if (bitmap != null) {
//                    stringBitmapMap.put(url, bitmap);
                    imageView.setImageBitmap(bitmap);
                }
            }
        };
        asyncTask.execute(url);
    }
}
