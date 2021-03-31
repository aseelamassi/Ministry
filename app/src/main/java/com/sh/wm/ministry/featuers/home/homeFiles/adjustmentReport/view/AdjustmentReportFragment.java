package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.view;

import android.Manifest;
import android.app.AlertDialog;
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
import android.widget.RadioGroup;
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
import com.sh.wm.ministry.custem.FileUtils;
import com.sh.wm.ministry.custem.RadioButtonCreation;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeAdder;
import com.sh.wm.ministry.databinding.FragmentAdjustmentReportBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.HomeViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.viewmodel.AdjustmentReportViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.SubjectNumberAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.model.Inspector;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class AdjustmentReportFragment extends Fragment implements DateAdder.Listener, TimeAdder.Listener, BottomSheetDialogGeneral.BottomSheetInterface {

    private FragmentAdjustmentReportBinding binding;
    private AdjustmentReportViewModel adjustmentReportViewModel;
    private HomeViewModel homeViewModel;

    private UserFileViewModel viewModel;
    private RadioButtonCreation creation;
    private DateAdder dateAdder;
    private TimeAdder timeAdder;

    private Uri fileUri;
    private String filePath;
    private MultipartBody.Part image;
    private File file;

    //pal law & inspector
    private ArrayList<PalLaw> lawList;
    private HashMap<String, String> laws;
    private HashMap<String, String> inspectors;
    private ArrayList<Inspector> inspectorList;
    private Observer<PalLawModel> palLawObserver;
    private String palLawId, inspectorSn1, inspectorSn2, inspectorSn3, constructionId, infractionReportTypeId, type;

    private boolean isBigger;
    private long startTime;
    private long endTime;

    private BottomSheetDialog dialog;
    private Observer<ConstructByName> constructByNameObserver;

    private EditText ed_text;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private BottomSheetSearchList bottomSheetSearchList;
    private BottomSheetSearchList.MyTestAdapter myAdapter;

    private ShMyDialog shMyDialog;

    private HashMap<String, RequestBody> data;


    private SubjectNumberAdapter subjectNumberAdapter;
    private int thisPosition;


    //for date and hours
    private String reportStartHour, reportEndHour, startOrEnd;

    BottomSheetDialogGeneral bottomSheetDialogGeneral;

    long chosenTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialogGeneral = new BottomSheetDialogGeneral(getContext(), this);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeAdder = new TimeAdder(getActivity().getSupportFragmentManager(), this::onTimeChosen);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdjustmentReportBinding.inflate(inflater, container, false);


        //setup viewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        data = new HashMap<>();

        //this for add radio buttons to radio group dependents on data come from API
        creation = new RadioButtonCreation(getContext());

        lawList = new ArrayList<>();
        laws = new HashMap<>();

        inspectors = new HashMap<>();
        inspectorList = new ArrayList<>();

        palLawObserver = new Observer<PalLawModel>() {
            @Override
            public void onChanged(PalLawModel palLawModel) {

                if (palLawModel != null) {
                    bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearchList.setBottomSheetDialog(dialog);
                    bottomSheetSearchList.setMyList((ArrayList<?>) palLawModel.getPalLaws(), ed_text.getText().toString());

                    myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object palLaw) {

                            lawList.remove(thisPosition);
                            lawList.add((PalLaw) palLaw);



                            subjectNumberAdapter.notifyDataSetChanged();


                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                        }
                    });

                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearchList.setBottomSheetDialog(dialog);
                    bottomSheetSearchList.setMyList((ArrayList<?>) constructByName.getConstructs(), ed_text.getText().toString());

                    myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Object constructByName) {
                            binding.cardViewSearchShAdjustmentReport.llSecondView.setVisibility(View.VISIBLE);
                            if (((Construct) constructByName).getCONSTRUCTIONOWNER() != null) {
                                binding.cardViewSearchShAdjustmentReport.tvOwnerName.setText(getString(R.string.owner_name) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getOWNERNAME());
                                binding.cardViewSearchShAdjustmentReport.tvOwnerId.setText(getString(R.string.owner_id) + " " + ((Construct) constructByName).getCONSTRUCTIONOWNER().getUSERSN());

                            } else {
                                binding.cardViewSearchShAdjustmentReport.tvOwnerName.setText(getString(R.string.owner_name));
                                binding.cardViewSearchShAdjustmentReport.tvOwnerId.setText(getString(R.string.owner_id));
                            }

                            if (((Construct) constructByName).getCONSTRUCTTELEPHONE() != null)
                                binding.cardViewSearchShAdjustmentReport.tvBusinessName.setText(getString(R.string.phone) + " " + ((Construct) constructByName).getCONSTRUCTTELEPHONE());
                            binding.cardViewSearchShAdjustmentReport.tvActiveSector.setText(getString(R.string.The_business_name) + " " + ((Construct) constructByName).getCONSTRUCTNAMEUSING());
                            binding.cardViewSearchShAdjustmentReport.tvWorkField.setText(getString(R.string.state) + " " + ((Construct) constructByName).getCONSTRUCTMAINECON());
                            binding.cardViewSearchShAdjustmentReport.tvInstitutionName.setText(getString(R.string.address_details) + " " + ((Construct) constructByName).getCONSTRUCTADDRESS());

                            constructionId = ((Construct) constructByName).getCONSTRUCTNUM();
                            binding.tvNuFacility.setVisibility(View.GONE);
                            binding.edNuFacility.setVisibility(View.GONE);
                            binding.cardViewSearchShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                        }
                    });

                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearchList.setAdapter(myAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };


        dialog = new BottomSheetDialog(getContext());


        lawList.add(null);
        subjectNumberAdapter = new SubjectNumberAdapter(lawList, position -> {
            thisPosition = position;
            showBottomSearchSheet(palLawObserver, "palLaw");
        });

        binding.edArticleNumberLegalAction.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberLegalAction.setAdapter(subjectNumberAdapter);


        btnListener();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adjustmentReportViewModel = new ViewModelProvider(this).get(AdjustmentReportViewModel.class);

    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        chosenTime = timeChosen;
        isBigger = date.after(Calendar.getInstance().getTime());
        binding.edDateVisit.setText(format.format(date));

    }

    private void btnListener() {

        binding.cardViewSearchShAdjustmentReport.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacility.setVisibility(View.VISIBLE);
            binding.tvNuFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearchShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            binding.edNuFacility.setText("");


        });
        binding.radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_1)
                    infractionReportTypeId = "1";
                else if (i == R.id.rb_2)
                    infractionReportTypeId = "2";
                else if (i == R.id.rb_3)
                    infractionReportTypeId = "3";
            }
        });

        binding.edDateVisit.setOnClickListener(view -> dateAdder.show());

        binding.edMember1.setOnClickListener(view -> getInspector("one"));

        binding.edMember2.setOnClickListener(view -> getInspector("two"));

        binding.edMember3.setOnClickListener(view -> getInspector("three"));

        binding.btnAddLegalAction.setOnClickListener(view1 -> {

            if (subjectNumberAdapter.getItemCount() >= 5) {
                Toast.makeText(getContext(), getString(R.string.greater_than_5), Toast.LENGTH_SHORT).show();
                return;
            }
            if (lawList.get(lawList.size() - 1) == null) {
                Toast.makeText(getContext(), getString(R.string.field_before_empty), Toast.LENGTH_SHORT).show();
                return;
            }
            subjectNumberAdapter.notifyDataSetChanged();
            lawList.add(null);
        });

        binding.edNuFacility.setOnClickListener(view15 -> {
            showBottomSearchSheet(constructByNameObserver, "constructName");
        });


        binding.edReportStartDate.setOnClickListener(view -> {
            startOrEnd = "start";
            timeAdder.show();
        });

        binding.edReportEndDate.setOnClickListener(view -> {
            startOrEnd = "end";
            timeAdder.show();
        });


        binding.btnAddFile.setOnClickListener(view -> requestStoragePermission());

        binding.btnSaveLegalAction.setOnClickListener(view -> {
            String startReportTime = binding.edReportStartDate.getText().toString();
            String endReportTime = binding.edReportEndDate.getText().toString();
            String reportDate = binding.edDateVisit.getText().toString();

            laws = new HashMap<>();
            for (int  i =0 ; i<lawList.size() ; i++)
                if (lawList.get(i) != null) {
                   laws.put("LAW_ARTICAL_NUM_" + (i + 1), lawList.get(i).getId());
                    data.put("LAW_ARTICAL_NUM_" + (i + 1), RequestBody.create(palLawId, MediaType.parse("text/plain")));

                }

            if (constructionId == null || startReportTime.isEmpty() || endReportTime.isEmpty() || reportDate.isEmpty() || inspectors.size() == 0 || laws.size() == 0) {
                Toast.makeText(getContext(), R.string.alarm_empty, Toast.LENGTH_LONG).show();
            } else if (startTime >= endTime)
                Toast.makeText(getContext(), R.string.adjustment_bigger, Toast.LENGTH_LONG).show();
            else if (isBigger)
                Toast.makeText(getContext(), R.string.adjustment_today, Toast.LENGTH_LONG).show();
            else {
                shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {

                        binding.progress.setVisibility(View.VISIBLE);

                        data.put("CONSTRUCT_ID", RequestBody.create(constructionId, MediaType.parse("text/plain")));
                        data.put("INFRACTION_REPORT_DATE", RequestBody.create(binding.edDateVisit.getText().toString(), MediaType.parse("text/plain")));
                        data.put("INFRACTION_REPORT_START_T", RequestBody.create(binding.edReportStartDate.getText().toString(), MediaType.parse("text/plain")));
                        data.put("INFRACTION_REPORT_END_T", RequestBody.create(binding.edReportStartDate.getText().toString(), MediaType.parse("text/plain")));
                        if (infractionReportTypeId != null)
                            data.put("INFRACTION_REPORT_FILE_TYPE_ID", RequestBody.create(infractionReportTypeId, MediaType.parse("text/plain")));
                        //INFRACTION_REPORT_FILE_NAME
                        if (displayName != null)
                            data.put("INFRACTION_REPORT_FILE_NAME", RequestBody.create(displayName, MediaType.parse("text/plain")));

                        data.put("INSERT_USERID", RequestBody.create(SharedPreferneceHelper.getUserId(getContext()), MediaType.parse("text/plain")));



                        adjustmentReportViewModel.storeAdjustmentReport(data, image).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                            @Override
                            public void onChanged(ActionModel updateUser) {
                                if (updateUser != null) {
                                    binding.progress.setVisibility(View.INVISIBLE);
                                }

                            }
                        });


                        shMyDialog.dismiss();
                    }


                    @Override
                    public void edite(View view) {
                        shMyDialog.dismiss();
                    }
                }, getString(R.string.save_alarm), getString(R.string.save), getString(R.string.cancel));
                shMyDialog.show(getParentFragmentManager(), "hi their");
            }


        });


    }


    private void showBottomSearchSheet(Observer observer, String type) {
        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_training_program);
        ed_text = dialog.findViewById(R.id.search_view);
        bottomSheetSearchList = dialog.findViewById(R.id.recycler_view);
        imNoData = dialog.findViewById(R.id.image_no_data);
        progressBar = dialog.findViewById(R.id.progressbar);
        ed_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (ed_text.getText().toString().length() >= 3 && type.equals("constructName")) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                    homeViewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                } else if (ed_text.getText().toString().length() >= 1 && type.equals("palLaw")) {
                    homeViewModel.getPalLaw(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);

                } else {
                    bottomSheetSearchList.clerList();
                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                BottomSheetSearchList.clerList();
            }
        });
        dialog.show();

    }

    public void showBtmSheet(int title, List<Inspector> list, TextView tv_change, String type) {


        this.type = type;

        ArrayAdapter<Inspector> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

    }


    private void getInspector(String type) {
        if (inspectorList.size() == 0) {

            homeViewModel.getInspectors().observe(getViewLifecycleOwner(), new Observer<InspectorModel>() {
                @Override
                public void onChanged(InspectorModel inspectorModel) {
                    if (inspectorModel != null) {
                        inspectorList.addAll(inspectorModel.getInspectors());
                        inspectorShowSheet(type);
                    } else {
                        Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            inspectorShowSheet(type);

        }
    }

    private void inspectorShowSheet(String type) {
        if (type.equals("one"))
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember1, type);
        else if (type.equals("two"))
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember2, type);
        else
            showBtmSheet(R.string.inspector_members, inspectorList, binding.edMember3, type);
    }


    @Override
    public void onTimeChosen(long timeChosen) {
        Date date = new Date(timeChosen);
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        chosenTime = timeChosen;

        if (startOrEnd.equals("start")) {
            startTime = timeChosen;
            binding.edReportStartDate.setText(format.format(date));
        } else {
            endTime = timeChosen;
            binding.edReportEndDate.setText(format.format(date));
        }

    }


    private void requestStoragePermission() {

        //using Dexter to allow permissions to upload file
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

    String displayName = null;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {


                    fileUri = data.getData();

                    filePath = fileUri.getPath();
                    // file = new File(FileUtil.getPath(fileUri , getContext()));


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

                    file = new File(FileUtils.getPath(getActivity(), fileUri));
                    RequestBody requestFile = RequestBody.create(file, MediaType.parse("multipart/*"));


                    //to get file size im MB so we can't upload file larger than MB
                    int file_size = Integer.parseInt(String.valueOf((file.length() / 1024) / 1024));
                    if (file_size <= 2) {
                        image = MultipartBody.Part.createFormData("INFRACTION_REPORT_ATTACHMENT_F", FileUtils.getFileName(getContext(), fileUri), requestFile);
                    } else
                        Toast.makeText(getContext(), getString(R.string.file_is_large), Toast.LENGTH_SHORT).show();


                    break;
                }
        }


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (type.equals("one")) {
            inspectorSn1 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INFRACTIONREPORT_USER_ID_2", inspectorSn1);
            data.put("INFRACTIONREPORT_USER_ID_1", RequestBody.create(inspectorSn1, MediaType.parse("text/plain")));
        } else if (type.equals("two")) {
            inspectorSn2 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INFRACTIONREPORT_USER_ID_2", inspectorSn2);
            data.put("INFRACTIONREPORT_USER_ID_2", RequestBody.create(inspectorSn2, MediaType.parse("text/plain")));
        } else {
            inspectorSn3 = ((Inspector) adapterView.getItemAtPosition(i)).getUSERSN();
            inspectors.put("INFRACTIONREPORT_USER_ID_3", inspectorSn3);
            data.put("INFRACTIONREPORT_USER_ID_3", RequestBody.create(inspectorSn3, MediaType.parse("text/plain")));
        }

    }
}