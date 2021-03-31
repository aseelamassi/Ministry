package com.sh.wm.ministry.featuers.userfile.practicalstatus.view;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentPracticalStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.adapter.PracticalStatusAdapter;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.UserWorkStatus;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel.PracticalStatusViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.ApiConstent;
import com.sh.wm.ministry.network.utiels.BackgroundNotificationService;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class PracticalStatusFragment extends Fragment implements PracticalStatusAdapter.OnEditClickListener {

    private PracticalStatusViewModel mViewModel;
    private FragmentPracticalStatusBinding binding;
    private OnFragmentInteractionListener mListener;
    private ShMyDialog dialog;
    private Dialog successDialog;

    private ProgressDialog mProgressDialog;

    private boolean isDownload = false;
    public static final String PROGRESS_UPDATE = "progress_update";
    private static final int PERMISSION_REQUEST_CODE = 1;

    public static PracticalStatusFragment newInstance() {
        return new PracticalStatusFragment();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("A message");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPracticalStatusBinding.inflate(inflater, container, false);
        binding.LLLayoutPracticalStatus.setVisibility(View.INVISIBLE);


        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(PracticalStatusViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            mViewModel.getUserPracticalStatus().observe(getViewLifecycleOwner(), practicalStatusModel -> {
                if (practicalStatusModel != null) {

                    //get data from API
                    binding.progress.setVisibility(View.GONE);
                    if (practicalStatusModel.getUserWorkStatus() != null) {

                        //setUp adapter
                        List<UserWorkStatus> workStatus = practicalStatusModel.getUserWorkStatus();
                        PracticalStatusAdapter adapter = new PracticalStatusAdapter(workStatus, this);
                        binding.rvPracticalStatus.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        binding.rvPracticalStatus.setAdapter(adapter);
                        binding.LLLayoutPracticalStatus.setVisibility(View.GONE);

                    } else {
                        binding.LLLayoutPracticalStatus.setVisibility(View.VISIBLE);

                    }
                }
            });

        } else {
            binding.progress.setVisibility(View.GONE);
            binding.LLLayoutPracticalStatus.setVisibility(View.VISIBLE);
            binding.tvNoPracticalStatus.setVisibility(View.VISIBLE);
            binding.tvNoPracticalStatus.setText(getString(R.string.no_internet_to_show));
        }

        if (this.getArguments() != null)
            binding.btnDownloadFile.setVisibility(View.VISIBLE);
        else
            binding.btnDownloadFile.setVisibility(View.GONE);


        btnListener();

        registerReceiver();
        return binding.getRoot();
    }


    private void btnListener() {

        binding.btnDownloadFile.setOnClickListener(view -> {

            startImageDownload();

//            final DownloadTask downloadTask = new DownloadTask(getContext());
//            downloadTask.execute(ApiConstent.BASEURL+"export_user_unemployed");
//
//            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//
//                @Override
//                public void onCancel(DialogInterface dialog) {
//                    downloadTask.cancel(true); //cancel the task
//                }
//            });
//            if (NetworkUtils.isOnline(getContext())) {
//                if (!isDownload)
//                    requestStoragePermission();
//                else
//                    Toast.makeText(getContext(), getString(R.string.download_complete), Toast.LENGTH_SHORT).show();
//
//
//            } else
//                Toast.makeText(getContext(), getString(R.string.no_internet_to_download), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onEditClick(UserWorkStatus workStatus) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("workStatus", workStatus);
        mListener.onFragmentInteraction(10, bundle);
    }

    @Override
    public void onClick(UserWorkStatus workStatus) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("workStatus", workStatus);
        bundle.putString("type", "view");
        mListener.onFragmentInteraction(10, bundle);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    private void requestStoragePermission() {

        Dexter.withContext(getContext())
                .withPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        // permission is granted
                        breakdownStatementDialog();

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        // check for permanent denial of permission
                        if (response.isPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .check();
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.allow_permission));
        builder.setMessage(getString(R.string.need_permission));
        builder.setPositiveButton(getString(R.string.go_to_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }


    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
    }


    private void breakdownStatementDialog() {

        dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
            @Override
            public void sase(View view) {

                mViewModel.getUnemployedFile().observe(getViewLifecycleOwner(), new Observer<ResponseBody>() {
                    @Override
                    public void onChanged(ResponseBody responseBody) {
                        if (responseBody != null) {
                            try {
                                new AsyncTask<Void, Integer, Void>() {
                                    @Override
                                    protected Void doInBackground(Void... voids) {
                                        boolean writtenToDisk = writeResponseBodyToDisk(responseBody);

                                        isDownload = writtenToDisk;


                                        if (writtenToDisk == true) {
                                            getActivity().runOnUiThread(new Runnable() {

                                                @Override
                                                public void run() {

                                                    binding.progress.setVisibility(View.GONE);
                                                    successDialog = new Dialog(getContext());
                                                    successDialog.setContentView(R.layout.dialog_complete_download_file);


                                                    Window window = successDialog.getWindow();
                                                    WindowManager.LayoutParams wlp = window.getAttributes();

                                                    wlp.gravity = Gravity.CENTER;
                                                    wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                                                    window.setAttributes(wlp);

                                                    Button button = successDialog.findViewById(R.id.btn_okay);
                                                    button.setOnClickListener(view1 -> successDialog.dismiss());

                                                    successDialog.show();


                                                }
                                            });

                                        }
                                        return null;
                                    }
                                }.execute();
                            } catch (Exception e) {
                                Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();

                            }


                        }
                    }
                });
                dialog.dismiss();
            }

            @Override
            public void edite(View view) {
                dialog.dismiss();
            }
        }, getString(R.string.breakdown_statement_request), getString(R.string.emphasis), getString(R.string.Cancel));
        dialog.show(getParentFragmentManager(), "home Fragment");
    }


    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {

            File futureStudioIconFile;
            futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + getString(R.string.breakdown_statement) + ".pdf");


            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();


                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();


                outputStream = new FileOutputStream(futureStudioIconFile);


                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {

                        break;
                    }


                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                }

                outputStream.flush();

                return true;
            } catch (IOException e) {

                // Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();

                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {

            return false;
        }

    }


    @Override
    public void onPause() {
        super.onPause();
        if (successDialog != null)

            successDialog.dismiss();
    }

    private void registerReceiver() {

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PROGRESS_UPDATE);
        bManager.registerReceiver(mBroadcastReceiver, intentFilter);

    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(PROGRESS_UPDATE)) {

                boolean downloadComplete = intent.getBooleanExtra("downloadComplete", false);
                //Log.d("API123", download.getProgress() + " current progress");

                if (downloadComplete) {

                    Toast.makeText(getActivity().getApplicationContext(), "File download completed", Toast.LENGTH_SHORT).show();

//                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator +
//                            "journaldev-image-downloaded.jpg");
//
//                    Picasso.get().load(file).into(imageView);

                }
            }
        }
    };



    private void startImageDownload() {


        Intent intent = new Intent(getContext(), BackgroundNotificationService.class);
        getActivity().startService(intent);

    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {

        private Context context;
        private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", SharedPreferneceHelper.getToken(getContext()));


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
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // take CPU lock to prevent CPU from going off if the user
            // presses the power button during download
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    getClass().getName());
            mWakeLock.acquire();
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            // if we get here, length is known, now set indeterminate to false
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            mWakeLock.release();
            mProgressDialog.dismiss();
            if (result != null)
                Toast.makeText(context,"Download error: "+result, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
        }

    }
}

