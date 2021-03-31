package com.sh.wm.ministry.network.utiels;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.view.PracticalStatusFragment;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import okhttp3.ResponseBody;


public class BackgroundNotificationService extends IntentService {

    public BackgroundNotificationService() {
        super("Service");
    }

    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;


    @Override
    protected void onHandleIntent(Intent intent) {

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("id", "an", NotificationManager.IMPORTANCE_LOW);

            notificationChannel.setDescription("no sound");
            notificationChannel.setSound(null, null);
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        notificationBuilder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(android.R.drawable.stat_sys_download)
                .setContentTitle("Download")
                .setContentText("Downloading Image")
                .setDefaults(0)
                .setAutoCancel(true);
        notificationManager.notify(0, notificationBuilder.build());

        initRetrofit();
//
//        final BackgroundNotificationService.DownloadTask downloadTask = new BackgroundNotificationService.DownloadTask(getApplicationContext());
//        downloadTask.execute(ApiConstent.BASEURL+"export_user_unemployed");

    }

    private void initRetrofit() {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://unsplash.com/")
//                .build();
//
//        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        NetworkUtils networkUtils = NetworkUtils.getInstance(true , getApplicationContext());
//        Call<ResponseBody> request = retrofitInterface.downloadImage("photos/YYW9shdLIwo/download?force=true");
        try {

            downloadImage(Objects.requireNonNull(networkUtils.getApiInterface().getUnemployedFile().execute().body()));

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
//
    private void downloadImage(ResponseBody body) throws IOException {

        int count;
        byte data[] = new byte[1024 * 4];
        long fileSize = body.contentLength();
        InputStream inputStream = new BufferedInputStream(body.byteStream(), 1024 * 8);
        File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "journaldev-image-downloaded.jpg");
        OutputStream outputStream = new FileOutputStream(outputFile);
        long total = 0;
        boolean downloadComplete = false;
        //int totalFileSize = (int) (fileSize / (Math.pow(1024, 2)));

        while ((count = inputStream.read(data)) != -1) {

            total += count;
            int progress = (int) ((double) (total * 100) / (double) fileSize);


            updateNotification(progress);
            outputStream.write(data, 0, count);
            downloadComplete = true;
        }
        onDownloadComplete(downloadComplete);
        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }

    private void updateNotification(int currentProgress) {


        notificationBuilder.setProgress(100, currentProgress, false);
        notificationBuilder.setContentText("Downloaded: " + currentProgress + "%");
        notificationManager.notify(0, notificationBuilder.build());
    }


    private void sendProgressUpdate(boolean downloadComplete) {

        Intent intent = new Intent(PracticalStatusFragment.PROGRESS_UPDATE);
        intent.putExtra("downloadComplete", downloadComplete);
        LocalBroadcastManager.getInstance(BackgroundNotificationService.this).sendBroadcast(intent);
    }

    private void onDownloadComplete(boolean downloadComplete) {
        sendProgressUpdate(downloadComplete);

        notificationBuilder.setProgress(0, 0, false);
        notificationBuilder.setContentText("Image Download Complete");
        Uri selectedUri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator +getString(R.string.breakdown_statement) + ".pdf");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(selectedUri, "application/pdf"); // here we set correct type for PDF
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);
        notificationManager.notify(0, notificationBuilder.build());

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        notificationManager.cancel(0);
    }


    private class DownloadTask extends AsyncTask<String, Integer, String> {

        private Context context;
        private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            boolean downloadComplete = false;
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", SharedPreferneceHelper.getToken(getApplicationContext()));


                connection.connect();

                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }

                // this will be useful to display download percentage
                // might be -1: server did not report the length
                int fileLength = connection.getContentLength();



                // download the file


                input = connection.getInputStream();
                output = new FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + getString(R.string.breakdown_statement) + ".pdf");

                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;



                    int progress = (int) ((double) (total * 100) / (double) fileLength);
                    updateNotification(progress);
                    // publishing the progress....
//                    if (fileLength > 0) // only if total length is known
//                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                    downloadComplete = true;

                }
                onDownloadComplete(downloadComplete);


            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null) {
                        output.flush();
                        output.close();
                    }if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }


//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // take CPU lock to prevent CPU from going off if the user
//            // presses the power button during download
//            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
//                    getClass().getName());
//            mWakeLock.acquire();
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... progress) {
//            super.onProgressUpdate(progress);
//            // if we get here, length is known, now set indeterminate to false
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.setMax(100);
//            mProgressDialog.setProgress(progress[0]);
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            mWakeLock.release();
//            mProgressDialog.dismiss();
//            if (result != null)
//                Toast.makeText(context,"Download error: "+result, Toast.LENGTH_LONG).show();
//            else
//                Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
//        }

    }


}
