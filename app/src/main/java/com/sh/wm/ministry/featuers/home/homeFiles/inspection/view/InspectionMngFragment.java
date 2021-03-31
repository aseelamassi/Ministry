package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInspectionMngBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.InspectionLoadState;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.InspectionVisitAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.viewmodel.NewWorkPlaceViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.AutoStartHelper;
import com.sh.wm.ministry.network.utiels.InspectionVisitComparator;

import java.util.ArrayList;
import java.util.List;


public class InspectionMngFragment extends Fragment implements InspectionVisitAdapter.OnClick {

    private FragmentInspectionMngBinding binding;
    private List<InspectionVisit> inspectionVisits;
    private InspectionsViewModel viewModel;
    private String constructId;
    private InspectionVisitAdapter inspectionVisitAdapter;
    private String constructionId ="";


    private BottomSheetSearchList.MyTestAdapter myAdapter;
    private ImageView imNoData;
    private ProgressBar progressBar;

    private BottomSheetSearchList bottomSheetSearchList;
    private BottomSheetDialog dialog;
    private EditText ed_text;

    private NewWorkPlaceViewModel newWorkPlaceViewModel;

    private Observer<ConstructByName> constructByNameObserver;

    private OnFragmentInteractionListener mListener;

    public InspectionMngFragment() {
        // Required empty public constructor
    }


    public static InspectionMngFragment newInstance() {
        InspectionMngFragment fragment = new InspectionMngFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInspectionMngBinding.inflate(inflater, container, false);


        inspectionVisitAdapter = new InspectionVisitAdapter(new InspectionVisitComparator(), getContext(), this::onClick);

        viewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);
        newWorkPlaceViewModel = new ViewModelProvider(this).get(NewWorkPlaceViewModel.class);


        binding.rvFacilityInspections.setLayoutManager(new LinearLayoutManager(getContext()));


        getInspectionPlan();


        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    if (constructByName.getStatus() == 1){
                        imNoData.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }else {
                        progressBar.setVisibility(View.GONE);


                        bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
                        bottomSheetSearchList.setBottomSheetDialog(dialog);
                        bottomSheetSearchList.setMyList((ArrayList<?>) constructByName.getConstructs(), ed_text.getText().toString());

                        myAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
                            @Override
                            public void MyMethod(Object constructByName) {


                                progressBar.setVisibility(View.GONE);
                                binding.etFacilityName.setText(((Construct) constructByName).getCONSTRUCTNAMEUSING());
                                constructionId = ((Construct) constructByName).getCONSTRUCTID();
                                ed_text.setText("");
                                imNoData.setVisibility(View.VISIBLE);
                            }
                        });

                        bottomSheetSearchList.setAdapter(myAdapter);
                    }
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

            }
        };



        btnListener();
//        viewModel.getInspectionsPlan(null,  0 ,5).observe(getViewLifecycleOwner() , inspectionVisitModel->{
//            if (inspectionVisitModel != null){
//                inspectionVisits.addAll(inspectionVisitModel.getInspectionVisit());
//                //InspectionVisitAdapter adapter = new InspectionVisitAdapter(getContext() , inspectionVisits,this::onClick );
//               binding.rvFacilityInspections.setLayoutManager(new LinearLayoutManager(getContext()));
//               // binding.rvFacilityInspections.setAdapter(adapter);
//                //, InspectionVisitAdapter.InspectionVisitComparator.getInstance()
//            }
//        });


//        binding.insCompanyName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context =InspectionMngFragment.this.getContext();
//                BottomSheetDialog dialog = new BottomSheetDialog(context);
//                new BottomSheetSearsh(context, dialog, new BottomSheetSearsh.bottomSheetSearsh() {
//                    @Override
//                    public void searshByNumber(String num_facility) {
//
//                    }
//                }) ;
//            }
//        });

//        binding.insInspectorName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context =InspectionMngFragment.this.getContext();
//                BottomSheetDialog dialog = new BottomSheetDialog(context);
//                new BottomSheetSearsh(context, dialog, new BottomSheetSearsh.bottomSheetSearsh() {
//                    @Override
//                    public void searshByNumber(String num_facility) {
//
//                    }
//                }) ;
//
//            }
//        });
//
//        binding.btnSaveAddInspection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return binding.getRoot();
    }

    @Override
    public void onClick(String type, InspectionVisit inspectionVisit) {
        if (!SharedPreferneceHelper.isAutoStart(getContext()))
            AutoStartHelper.getInstance().getAutoStartPermission(getContext());

        switch (type) {
            case "storeResult": {
                Bundle bundle = new Bundle();
                bundle.putSerializable("inspectionVisit", inspectionVisit);
                mListener.onFragmentInteraction(402, bundle);
                break;
            }
            case "recommendation": {
                Bundle bundle = new Bundle();
                bundle.putSerializable("inspectionVisit", inspectionVisit);
                mListener.onFragmentInteraction(403, bundle);
                break;
            }
            case "revisit": {
                Bundle bundle = new Bundle();
                bundle.putSerializable("inspectionVisit", inspectionVisit);
                mListener.onFragmentInteraction(404, bundle);
                break;
            }
            case "additionalServices": {
                Bundle bundle = new Bundle();
                bundle.putSerializable("inspectionVisit", inspectionVisit);
                mListener.onFragmentInteraction(400, bundle);
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


    private void btnListener() {
        binding.btnSearchConstruct.setOnClickListener(view -> {
            if (binding.etFacilityName.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), getString(R.string.construction_num_empty), Toast.LENGTH_SHORT).show();
            }
            else {
                getInspectionPlan();
            }
        });



        binding.etFacilityName.setOnClickListener(view -> showBottomSearchSheet(constructByNameObserver));

        binding.btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etFacilityName.setText("");
                constructionId = "";
                getInspectionPlan();
            }
        });

    }


    private void getInspectionPlan() {
        viewModel.getInspectionsVisit(constructionId);



        viewModel.pagingDataFlow.subscribe(InspectionVisitSourceData -> {
            // submit new data to recyclerview adapter
            inspectionVisitAdapter.submitData(getLifecycle(), InspectionVisitSourceData);
        });


        binding.rvFacilityInspections.setAdapter(
                // concat movies adapter with header and footer loading view
                // This will show end user a progress bar while pages are being requested from server
                inspectionVisitAdapter.withLoadStateFooter(
                        // Pass footer load state adapter.
                        // When we will scroll down and next page request will be sent
                        // while we get response form server Progress bar will show to end user
                        // If request success Progress bar will hide and next page of movies
                        // will be shown to end user or if request will fail error message and
                        // retry button will be shown to resend the request
                        new InspectionLoadState(v -> {
                            inspectionVisitAdapter.retry();
                        })));

        binding.progressbar.setVisibility(View.GONE);


    }


    private void showBottomSearchSheet(Observer observer) {
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

                if (ed_text.getText().toString().length() >= 3) {
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                    newWorkPlaceViewModel.getConstructionData(ed_text.getText().toString()).observe(getViewLifecycleOwner(), observer);
                } else {
                    BottomSheetSearchList.clerList();
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

}
