package com.sh.wm.ministry.featuers.userfile.languages.view;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetSearch;
import com.sh.wm.ministry.custem.FileUtils;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentAddLanguageBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.languages.viewmodel.LanguagesViewModel;
import com.sh.wm.ministry.featuers.userfile.languages.viewmodel.UserLanguagesViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AddLanguageFragment extends Fragment implements BottomSheetDialogGeneral.BottomSheetInterface, BottomSheetSearch.BottomSheetSearchInterface  {

    private LanguagesViewModel mViewModel;
    private UserLanguagesViewModel mUserViewModel;
    private UserFileViewModel userFileViewModel;
    private FragmentAddLanguageBinding binding;
    private List<Constants> level;
    private List<Language> lang;

    private ShMyDialog dialog;
    private String langId , userLangId = "-1";
    private String readPer, writePer, conversationPer, type;
    private Observer<List<Language>> languageObserver;
    private Uri fileUri;
    private String filePath;
    private MultipartBody.Part image;
    private File file;

    private RequestBody requestFile;
    private OnFragmentInteractionListener mListener;

    BottomSheetDialogGeneral bottomSheetDialogGeneral;
    BottomSheetSearch bottomSheetSearch;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);
        bottomSheetSearch = new BottomSheetSearch(getContext() ,this);

        //setup viewModel
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);
        mViewModel = new ViewModelProvider(this).get(LanguagesViewModel.class);
        mUserViewModel = new ViewModelProvider(this).get(UserLanguagesViewModel.class);

    }

    public static AddLanguageFragment newInstance() {
        return new AddLanguageFragment();
    }




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddLanguageBinding.inflate(inflater, container, false);

        btnListener();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        level = new ArrayList<>();




        languageObserver = new Observer<List<Language>>() {
            @Override
            public void onChanged(List<Language> languages) {
                lang = new ArrayList<>();
                if (languages != null) {
                    lang.addAll(languages);
                    bottomSheetSearch.setUpAdapter(lang, getActivity());
                } else {
                    languages.clear();
                    bottomSheetSearch.notifyAdapter();

                }

            }
        };

        getBundleData();




    }

    public void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            binding.tvLanguage.setText(bundle.getString("language"));
            binding.tvSpeakingSkill.setText(bundle.getString("speaking_skill"));
            binding.tvWritingSkill.setText(bundle.getString("writing_skill"));
            binding.tvReadingSkill.setText(bundle.getString("reading_skill"));
            userLangId = bundle.getString("user_lang_Id");
            langId = bundle.getString("lang_id");
            readPer = bundle.getString("read_id");
            writePer = bundle.getString("write_id");
            conversationPer = bundle.getString("speak_id");


        }
    }


    public void getConstant(String parentId, String skillName) {


        //check if level list is empty send request to get constant else just display the bottom sheet
        if (level.size() == 0) {
            userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
                @Override
                public void onChanged(List<Constants> constants) {
                    level = new ArrayList<>();
                    if (constants != null) {
                        level.addAll(constants);
                        showLevelSheet(skillName);
                    } else {
                        Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            showLevelSheet(skillName);
        }
    }


    public void showBtmSheet(int title, List<Constants> list, TextView tv_change, String type) {

        this.type = type;

        ArrayAdapter<Constants> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);


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
                        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                        chooseFile.setType("*/*");
                        chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                        startActivityForResult(chooseFile, 1);
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


    public void btnListener() {


        binding.tvSpeakingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("66", "speak");
            }
        });

        binding.tvWritingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("66", "write");
            }
        });

        binding.tvReadingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConstant("66", "read");
            }
        });


        binding.tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSearchSheet(languageObserver);
            }
        });

        binding.btnInsertFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestStoragePermission();
            }
        });

        binding.btnSaveAddLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (binding.tvLanguage.getText().toString().isEmpty() || binding.tvReadingSkill.getText().toString().isEmpty() || binding.tvSpeakingSkill.getText().toString().isEmpty() || binding.tvWritingSkill.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                        } else {
                            binding.progress.setVisibility(View.VISIBLE);
                            if (userLangId.equals("-1")) {
                                RequestBody action = RequestBody.create("insert", MediaType.parse("multipart/form-data"));
                                RequestBody userId = RequestBody.create(SharedPreferneceHelper.getUserId(getContext()), MediaType.parse("multipart/form-data"));
                                RequestBody langID = RequestBody.create(langId, MediaType.parse("multipart/form-data"));
                                RequestBody read = RequestBody.create(readPer, MediaType.parse("multipart/form-data"));
                                RequestBody write = RequestBody.create(writePer, MediaType.parse("multipart/form-data"));
                                RequestBody conversation = RequestBody.create(conversationPer, MediaType.parse("multipart/form-data"));


                                //sending request body as a hash map of request body

                                HashMap<String, RequestBody> data = new HashMap<>();
                                data.put("action", action);
                                data.put("USER_LANG_USER_ID", userId);
                                data.put("USER_LANG_LANG_ID", langID);
                                data.put("USER_LANG_READ_PERCENTAGE", read);
                                data.put("USER_LANG_WRITE_PERCENTAGE", write);
                                data.put("USER_LANG_CONVERSATION_PER", conversation);
                                mUserViewModel.updateUserLanguages(data, image).observe(getViewLifecycleOwner(), userLanguagesModel -> {

                                    if (userLanguagesModel != null) {
                                        binding.progress.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), userLanguagesModel.getMessageText(), Toast.LENGTH_LONG).show();
                                        if (userLanguagesModel.getStatus().equals("0"))
                                            mListener.onFragmentInteraction(90);
                                    }
                                });
                            } else {

                                RequestBody action = RequestBody.create("update", MediaType.parse("multipart/form-data"));
                                RequestBody userLangID = RequestBody.create(userLangId, MediaType.parse("multipart/form-data"));
                                RequestBody userId = RequestBody.create(SharedPreferneceHelper.getUserId(getContext()), MediaType.parse("multipart/form-data"));
                                RequestBody langID = RequestBody.create(langId, MediaType.parse("multipart/form-data"));
                                RequestBody read = RequestBody.create(readPer, MediaType.parse("multipart/form-data"));
                                RequestBody write = RequestBody.create(writePer, MediaType.parse("multipart/form-data"));
                                RequestBody conversation = RequestBody.create(conversationPer, MediaType.parse("multipart/form-data"));


                                //sending request body as a hash map of request body
                                HashMap<String, RequestBody> data = new HashMap<>();
                                data.put("action", action);
                                data.put("USER_LANG_ID", userLangID);
                                data.put("USER_LANG_USER_ID", userId);
                                data.put("USER_LANG_LANG_ID", langID);
                                data.put("USER_LANG_READ_PERCENTAGE", read);
                                data.put("USER_LANG_WRITE_PERCENTAGE", write);
                                data.put("USER_LANG_CONVERSATION_PER", conversation);
                                mUserViewModel.updateUserLanguages(data, image).observe(getViewLifecycleOwner(), userLanguagesModel -> {
                                    binding.progress.setVisibility(View.GONE);

                                    if (userLanguagesModel != null) {
                                        Toast.makeText(getContext(), userLanguagesModel.getMessageText(), Toast.LENGTH_LONG).show();
                                        if (userLanguagesModel.getStatus().equals("0"))
                                            mListener.onFragmentInteraction(90);
                                    }
                                });


                            }
                        }

                        dialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        dialog.dismiss();
                    }
                }, getString(R.string.save_language), getString(R.string.save), getString(R.string.edit));
                dialog.show(getParentFragmentManager(), "dialog tag");
            }
        });


    }

    private void showBottomSearchSheet(Observer observer) {

        bottomSheetSearch.openDialog(observer);
        mViewModel.getAllLanguages().observe(getViewLifecycleOwner(), observer);

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

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {


                    fileUri = data.getData();

                    filePath = fileUri.getPath();
                    // file = new File(FileUtil.getPath(fileUri , getContext()));


                    String displayName = null;

                    if (fileUri.toString().startsWith("content://")) {
                        Cursor cursor = null;
                        try {
                            cursor = getActivity().getContentResolver().query(fileUri, null, null, null, null);
                            if (cursor != null && cursor.moveToFirst()) {
                                displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                            }
                        } finally {
                            cursor.close();
                        }
                    } else if (fileUri.toString().startsWith("file://")) {
                        displayName = file.getName();
                    }

                    //FileUtils class to get file path dependent from where is selected
                    file = new File(FileUtils.getPath(getActivity(), fileUri));
                    requestFile = RequestBody.create(file, MediaType.parse("multipart/*"));


                    int file_size = Integer.parseInt(String.valueOf((file.length() / 1024) / 1024));
                    if (file_size <= 2) {//check file size is less than 2 MB
                        binding.tvNoFile.setText(displayName);
                        //send file as a multipart

                        image = MultipartBody.Part.createFormData("language_certificate", file.getName(), requestFile);

                    } else
                        Toast.makeText(getContext(), getString(R.string.file_is_large), Toast.LENGTH_SHORT).show();


                    break;
                }
        }


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


    private void showLevelSheet(String skillName) {
        if (skillName.equals("read"))
            showBtmSheet(R.string.reading_skill, level,  binding.tvReadingSkill, skillName);
        else if (skillName.equals("write"))
            showBtmSheet(R.string.writing_skill, level, binding.tvWritingSkill, skillName);
        else
            showBtmSheet(R.string.speaking_skill, level,binding.tvSpeakingSkill, skillName);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (type) {
            case "speak":
                conversationPer = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "read":
                readPer = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;
            case "write":
                writePer = ((Constants) adapterView.getItemAtPosition(i)).getCONSTANTID();
                break;

        }

    }

    @Override
    public void observerAction(Object object) {
        langId = ((Language) object).getLANGUAGEID();
        binding.tvLanguage.setText(((Language) object).getLANGUAGEARNAME());
    }

    @Override
    public void etLengthMoreThan3(EditText ed_text, Observer observer) {
        mViewModel.getAllLanguages(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);


    }

    @Override
    public void etLengthLessThan3(EditText ed_text, Observer observer) {
        mViewModel.getAllLanguages().observe(getViewLifecycleOwner(), observer);


    }
}

