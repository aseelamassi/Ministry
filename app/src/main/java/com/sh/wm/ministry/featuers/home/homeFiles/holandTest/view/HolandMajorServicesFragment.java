package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHolandMajorServicesBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.ApiConstent;


public class HolandMajorServicesFragment extends Fragment {

    private FragmentHolandMajorServicesBinding binding;
    private HollandBasicTabsModel hollandBasicTabsModel ;
    private HollandViewModel viewModel ;
    private String testId;
    private Bundle bundle;
    private OnFragmentInteractionListener mListener;


    public HolandMajorServicesFragment() {
        // Required empty public constructor
    }

    public static HolandMajorServicesFragment newInstance() {
        HolandMajorServicesFragment fragment = new HolandMajorServicesFragment();

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
        binding =  FragmentHolandMajorServicesBinding.inflate(inflater, container, false);

        //setup viewModel
        viewModel = new ViewModelProvider(this).get(HollandViewModel.class);

        getBundle();

        btnListener();
        return binding.getRoot();
    }

    private void btnListener() {
        binding.btnSave.setOnClickListener(view -> {
            if (binding.edNumberOfYears.getText().toString().isEmpty())
                Toast.makeText(getContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();

            else {
                binding.progress.setVisibility(View.VISIBLE);
                viewModel.saveBasicData(testId , binding.edNumberOfYears.getText().toString() ).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        if (actionModel != null ) {
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();
                            // Save testId
                            SharedPreferences.Editor userEditor = getContext().getSharedPreferences(ApiConstent.TEST_ID, getContext().MODE_PRIVATE).edit();
                            userEditor.putString(ApiConstent.TEST_ID,actionModel.getId());
                            userEditor.apply();
                            userEditor.commit();



                            mListener.onFragmentInteraction(182  );


                        }
                    }
                });
            }
        });


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                mListener.onFragmentInteraction(180 );



            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!SharedPreferneceHelper.getTestId(getContext()).equals("Empty")) {


                    mListener.onFragmentInteraction(182);


                }else
                    Toast.makeText(getContext(), "يجب عليك حفظ البيانات الاساسية أولا", Toast.LENGTH_SHORT).show();

            }
        });



    }


    private void getBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            hollandBasicTabsModel = (HollandBasicTabsModel) bundle.getSerializable("hollandTest");
            if (hollandBasicTabsModel != null && hollandBasicTabsModel.getHollandTest() != null) {
                testId = hollandBasicTabsModel.getHollandTest().getHOLLANDTESTID();

                binding.edNumberOfYears.setText(hollandBasicTabsModel.getHollandTest().getHOLLANDTESTSTUDYYEARS());

            }
            if(hollandBasicTabsModel != null && hollandBasicTabsModel.getUserInfo() != null){
                binding.edBirthDate.setText(hollandBasicTabsModel.getUserInfo().getuSERBIRTHDAY());
                binding.edFullName.setText(hollandBasicTabsModel.getUserInfo().getuSERFULLNAME());
                binding.edGender.setText(hollandBasicTabsModel.getUserInfo().getUserSex());
                binding.edAge.setText(hollandBasicTabsModel.getUserInfo().getUserAge());
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



    private void actions() {

        //get holland test basic info
        viewModel.getHollandBasicTabs().observe(getViewLifecycleOwner(), new Observer<HollandBasicTabsModel>() {
            @Override
            public void onChanged(HollandBasicTabsModel hollandBasicTabsModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                if (hollandBasicTabsModel != null) {

                    bundle = new Bundle();

                    bundle.putSerializable("hollandTest", hollandBasicTabsModel);



                    mListener.onFragmentInteraction(182 ,bundle );

                }
            }
        });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }



}