package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view.additionalServices.insertWorker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.badoualy.stepperindicator.StepperIndicator;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInsertWorkerBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter.StepperAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertWorkerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertWorkerFragment extends Fragment {


    private FragmentInsertWorkerBinding binding ;
    private String[] titles;
    private InspectionVisit inspectionVisit;
    private InspectionsViewModel viewModel ;
    private String userSn ;
    private OnFragmentInteractionListener mListener;
    private Bundle bundle ;


    private StepperAdapter stepperAdapter;

    public InsertWorkerFragment() {
        // Required empty public constructor
    }


    public static InsertWorkerFragment newInstance() {
        InsertWorkerFragment fragment = new InsertWorkerFragment();

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
        binding =  FragmentInsertWorkerBinding.inflate(inflater, container, false);


        viewModel = new ViewModelProvider(this).get(InspectionsViewModel.class);


        titles = new String[]{getString(R.string.major_services) , getString(R.string.work_status_data) , getString(R.string.health_status_data)};

        stepperAdapter = new StepperAdapter(getChildFragmentManager() );

        getBundle();
        stepperAdapter.setInspectionVisit(inspectionVisit);



        binding.viewPager.setAdapter(stepperAdapter);


        binding.stepper.setViewPager(binding.viewPager);
        binding.stepper.setCurrentStep(0);







        binding.btnNext.setOnClickListener(view -> {

            if(binding.stepper.getCurrentStep() ==0 ){
                if (sn.getUSerSn() != null){
                    if(sn.getUSerSn().isEmpty() )
                        Toast.makeText(getContext(), getString(R.string.user_sn_empty), Toast.LENGTH_SHORT).show();
                    else if (sn.getUSerSn().length()<9)
                        Toast.makeText(getContext(), getString(R.string.sn_must_be_9), Toast.LENGTH_SHORT).show();

                    else {
                        userSn = sn.getUSerSn();
                        stepperAdapter.setUserSn(sn.getUSerSn());
                        if (sn.getUserId()!= null)
                            stepperAdapter.setUserId(sn.getUserId());

                        move();

                    }
            }


            }


            else if (binding.stepper.getCurrentStep() == 1){

                AddWorkerModel addWorkerModel = checkUSerSn.getAddWorker();
                if (addWorkerModel.getJobId() == null || addWorkerModel.getSkillLevelId()==null || addWorkerModel.getPerExam() == null
                || addWorkerModel.getPrimExam() == null || addWorkerModel.getHaveCertificate() == null ||addWorkerModel.getWorkTypeId() == null ||
                 addWorkerModel.getWorkTypeDescId() == null || addWorkerModel.getWorkTypeDescDescId() == null || addWorkerModel.getStartDate().isEmpty()
                ||addWorkerModel.getSalary().isEmpty() || addWorkerModel.getCurrencyId() == null || addWorkerModel.getPayId()==null || addWorkerModel.getConstructId() == null){
                    Toast.makeText(getContext(), getString(R.string.empty_field), Toast.LENGTH_SHORT).show();
                }else {
                    viewModel.addWorkModel(inspectionVisit.getCONSTRUCTID(),userSn,addWorkerModel.getPerExam(),addWorkerModel.getPrimExam(),addWorkerModel.getHaveCertificate(),addWorkerModel.getWorkTypeId(),addWorkerModel.getWorkTypeDescId(),addWorkerModel.getWorkTypeDescDescId(),addWorkerModel.getStartDate(),addWorkerModel.getEndDate(),addWorkerModel.getLeaveDate(),addWorkerModel.getLeaveReason(),addWorkerModel.getCurrencyId(),addWorkerModel.getSalary(),addWorkerModel.getPayId(),addWorkerModel.getJobId(),addWorkerModel.getSkillLevelId(),addWorkerModel.getContractId(),addWorkerModel.getVisitId());
                    binding.btnNext.setText(R.string.save);
                    move();

                }
            }




            else if (binding.stepper.getCurrentStep() == 2){
                healthStatus.saveHealth().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        if (aBoolean != null && aBoolean){
                            if (bundle != null)
                            mListener.onFragmentInteraction(405 ,bundle);

                        }


                    }
                });

            }



        });


        binding.stepper.addOnStepClickListener(new StepperIndicator.OnStepClickListener() {
            @Override
            public void onStepClicked(int step) {
                if (step == 2)
                    binding.btnNext.setText(R.string.save);

            }
        });

        return binding.getRoot();
    }

    static GetData checkUSerSn ;
    static CheckUserSn sn ;
    public static HealthStatus healthStatus ;


     interface GetData {
        AddWorkerModel getAddWorker();
    }

    interface  CheckUserSn{
        String getUSerSn();
        String getUserId();


    }


    public interface HealthStatus{
        LiveData<Boolean> saveHealth();
    }






    private void getBundle(){
         bundle = this.getArguments();
        if (bundle != null)
            inspectionVisit = (InspectionVisit) bundle.getSerializable("inspectionVisit");
    }



    private void  move(){
        if (! (binding.stepper.getCurrentStep() == 2)){

            binding.stepper.setCurrentStep(binding.stepper.getCurrentStep() + 1);
            binding.viewPager.setCurrentItem(binding.stepper.getCurrentStep());
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        stepperAdapter = new StepperAdapter(getChildFragmentManager()); //here used child fragment manager

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding= null;
    }
}